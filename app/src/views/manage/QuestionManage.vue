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
      <template v-slot:item.title-beautify="{ item }">
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <div v-on="on" class="text-truncate" style="width:700px;">{{item.title}}</div>
          </template>
          <span>{{item.title}}</span>
        </v-tooltip>
      </template>
      <template v-slot:item.action="{ item }">
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn @click="editUser(item)" icon v-on="on">
              <v-icon small>mdi-pencil</v-icon>
            </v-btn>
          </template>
          <span>编辑</span>
        </v-tooltip>
        <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
      </template>
    </v-data-table>
    <!-- 新增弹框 -->
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">添加/修改试题</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-select :items="['单选题','填空题','判断题','主观题']" v-model="editedItem.type" label="题目类型"></v-select>
                <v-textarea v-model="editedItem.title" label="题干"></v-textarea>
                <div v-if="editedItem.type==='单选题'">
                  <v-text-field v-model="editedItem.choicea" label="A选项"></v-text-field>
                  <v-text-field v-model="editedItem.choiceb" label="B选项"></v-text-field>
                  <v-text-field v-model="editedItem.choicec" label="C选项"></v-text-field>
                  <v-text-field v-model="editedItem.choiced" label="D选项"></v-text-field>
                </div>
                <v-select
                  v-if="editedItem.type==='单选题'"
                  v-model="editedItem.answer"
                  label="答案"
                  :items="['A','B','C','D']"
                ></v-select>
                <v-text-field
                  v-else-if="editedItem.type==='填空题'"
                  v-model="editedItem.answer"
                  label="答案"
                ></v-text-field>
                <v-select
                  v-else-if="editedItem.type==='判断题'"
                  v-model="editedItem.answer"
                  label="答案"
                  :items="['正确','错误']"
                ></v-select>
                <v-select :items="['简单','一般','困难']" v-model="editedItem.difficulty" label="难度"></v-select>
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
    <v-btn class="mx-5" fixed bottom right fab dark large color="green" @click="dialog=true">
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
      { text: "题目类型", value: "type" },
      { text: "题干", value: "title-beautify" },
      { text: "答案", value: "answer" },
      { text: "难度", value: "difficulty" },
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
      fetchList("/question/query/list", {
        courseid: this.$route.params.id
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
      if (confirm("确定要删除该题目吗?")) {
        axios
          .get(baseUrl + "/question/delete", {
            params: { id: item.id }
          })
          .then(() => {
            this.refresh();
          });
      }
    },
    save() {
      this.editedItem["courseid"] = this.$route.params.id;
      fly.post(baseUrl + "/question/upsert", this.editedItem).then(response => {
        this.refresh();
        this.dialog = false;
        this.editedItem = {};
      });
    },
    editUser(item) {
      this.editedIndex = this.items.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    }
  }
};
</script>

<style>
</style>