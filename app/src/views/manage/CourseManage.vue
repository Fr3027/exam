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
      <template v-slot:item.pronunciation="{ item }">
        <audio-player :src="item.pronunciation" />
      </template>
      <template v-slot:item.status-beautify="{ item }">
        <div>{{item.status==='pass'?'已通过':'未通过'}}</div>
      </template>
      <template v-slot:item.istop-beautify="{ item }">
        <div>{{item.istop==='true'?'已置顶':'未置顶'}}</div>
      </template>
      <template v-slot:item.action="{ item }">
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn @click="deleteItem(item)" icon v-on="on">
              <v-icon small>mdi-delete</v-icon>
            </v-btn>
          </template>
          <span>删除课程</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn icon @click="$router.push('/questionmanage/' + item.id);" v-on="on">
              <v-icon>mdi-reorder-horizontal</v-icon>
            </v-btn>
          </template>
          <span>题目列表</span>
        </v-tooltip>
      </template>
    </v-data-table>
    <!-- 新增弹框 -->
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">新建课程</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="editedItem.name" label="课程名称"></v-text-field>
                <v-text-field v-model="editedItem.description" label="课程描述"></v-text-field>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="close">取消</v-btn>
          <v-btn color="blue darken-1" text @click="save">保存</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-btn class="mx-5" fixed bottom right fab dark large color="secondary" @click="dialog=true">
      <v-icon dark>mdi-plus</v-icon>
    </v-btn>
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
      { text: "课程名称", value: "name" },
      { text: "描述", value: "description" },
      { text: "负责老师姓名", value: "teachername" },
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
    // dialog
    dialog: false
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
      fetchList("/course/query/list", {
        teacherid: store.getters.user.id
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
    deleteItem(item) {
      if (confirm("确定要删除该课程吗?")) {
        axios
          .get(baseUrl + "/course/delete", {
            params: { id: item.id }
          })
          .then(() => {
            this.refresh();
          });
      }
    },
    save() {
      fly
        .post(baseUrl + "/course/upsert", {
          name: this.editedItem.name,
          description: this.editedItem.description,
          teacherid: store.getters.user.id,
          teachername: store.getters.user.name
        })
        .then(response => {
          this.refresh();
          this.dialog = false;
        });
    }
  }
};
</script>

<style>
</style>