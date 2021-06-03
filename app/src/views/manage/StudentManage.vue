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
            <v-btn @click="editUser(item)" icon v-on="on">
              <v-icon small>mdi-pencil</v-icon>
            </v-btn>
          </template>
          <span>编辑</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn @click="deleteItem(item)" icon v-on="on">
              <v-icon small>mdi-delete</v-icon>
            </v-btn>
          </template>
          <span>删除</span>
        </v-tooltip>
      </template>
    </v-data-table>
    <!-- 新增弹框 -->
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">添加/修改学生</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="editedItem.name" label="姓名"></v-text-field>
                <v-text-field v-model="editedItem.username" label="学号"></v-text-field>
                <v-text-field v-model="editedItem.password" label="密码"></v-text-field>
                <v-text-field v-model="editedItem.major" label="专业"></v-text-field>
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
      { text: "姓名", value: "name" },
      { text: "学号", value: "username" },
      { text: "密码", value: "password" },
      { text: "专业", value: "major" },
      {
        text: "操作",
        align: "center",
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
      fetchList("/user/query/list", {
        usertype: "学生"
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
      if (confirm("确定要删除该学生吗?")) {
        axios
          .get(baseUrl + "/user/delete", {
            params: { id: item.id }
          })
          .then(() => {
            this.refresh();
          });
      }
    },
    save() {
      // 学号合法性检验
      var isnum = /^\d+$/.test(this.editedItem.username);
      if(!isnum){
        alert("学号必须全为数字，添加失败");
        return;
      }
      fly
        .post(baseUrl + "/user/upsert", {
          id: this.editedItem.id,
          name: this.editedItem.name,
          username: this.editedItem.username,
          password: this.editedItem.password,
          major: this.editedItem.major,
          usertype: "学生"
        })
        .then(response => {
          if (response.data == "重复注册") alert("重复注册！");
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