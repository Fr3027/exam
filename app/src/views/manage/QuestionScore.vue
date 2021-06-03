<template>
  <v-container>
    <v-text-field v-model="search" append-icon="mdi-magnify" label="搜索..." single-line hide-details></v-text-field>
    <v-data-table
      :headers="headers"
      :items="items"
      :items-per-page="5"
      :search="search"
      class="elevation-1"
    >
      <template v-slot:item.action="{ item }">
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn @click="paperhistoryid=item.id;review(item)" icon v-on="on">
              <v-icon small>mdi-circle-edit-outline</v-icon>
            </v-btn>
          </template>
          <span>批阅</span>
        </v-tooltip>
      </template>
    </v-data-table>
    <!-- 阅卷弹框 -->
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">主观题批阅</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <div v-for="(item,index) in reviewItems" v-bind:key="item.id">
                <div>{{index+1}}.{{item.title}}</div>
                <div>{{item.input}}</div>
                <v-select :items="[0,1,2,3,4,5]" v-model="item.score" label="得分"></v-select>
              </div>
            </v-row>
          </v-container>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="close">取消</v-btn>
          <v-btn color="blue darken-1" text @click="save">确认</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import store from "@/store";
import { baseUrl } from "@/config";
import axios from "axios";
import { fetchList } from "@/utils";
import { mapGetters } from "vuex";
import fly from "@/flyjs";
export default {
  components: {},
  data: () => ({
    search: "",
    headers: [
      { text: "考试名称", value: "title" },
      { text: "考试时间", value: "date" },
      { text: "状态", value: "status" },
      {
        text: "操作",
        align: "left",
        sortable: false,
        value: "action"
      }
    ],
    items: [],
    editedIndex: -1,
    editedItem: {},
    reviewItems: [],
    // dialog
    dialog: false,
    paperhistoryid: null
  }),
  computed: {
    ...mapGetters(["user"])
  },
  mounted() {
    this.refresh();
  },
  methods: {
    refresh() {
      // 获取数据
      fetchList("/paperhistory/query/list", {
        status: "待批阅"
      }).then(data => {
        this.items = data.items;
        this.total = data.total;
      });
    },
    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = {};
        this.editedIndex = -1;
      }, 300);
    },
    save() {
      let score = 0;
      for (let i = 0; i < this.reviewItems.length; i++) {
        score += parseInt(this.reviewItems[i].score);
      }
      fly
        .get(baseUrl + "/paper/score", {
          score: score,
          paperhistoryid: this.paperhistoryid
        })
        .then(response => {
          alert("阅卷完成！");
          this.dialog = false;
          this.refresh();
        });
    },
    review(item) {
      this.dialog = true;
      fetchList("/papermap/query/subjective", {
        paperhistoryid: item.id
      }).then(data => {
        this.reviewItems = data.items;
      });
    }
  }
};
</script>

<style>
</style>