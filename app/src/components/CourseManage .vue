<template>
  <div>
    <v-text-field v-model="search" append-icon="mdi-magnify" label="搜索..." single-line hide-details></v-text-field>
    <v-data-table
      :headers="headers"
      :items="users"
      :items-per-page="5"
      :search="search"
      class="elevation-1"
    >
      <template v-slot:item.pronunciation="{ item }">
        <audio-player :src="item.pronunciation" />
      </template>
      <template v-slot:item.action="{ item }">
        <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
      </template>
    </v-data-table>
    <!-- 新增弹框 -->
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">发布公告</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="editedItem.content" label="公告内容"></v-text-field>
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
  </div>
</template>

<script>
import { baseUrl } from "@/config";
import axios from "axios";
export default {
  components: {},
  data: () => ({
    search: "",
    totalusers: 0,
    loading: true,
    pagination: {},
    headers: [
      {
        text: "ID",
        align: "left",
        sortable: true,
        value: "id"
      },
      { text: "公告内容", value: "content" },
      { text: "发布日期", value: "date" },
      {
        text: "操作",
        align: "left",
        sortable: false,
        value: "action"
      }
    ],
    users: [],
    editedIndex: -1,
    editedItem: {
      id: null,
      content: ""
    },
    defaultItem: {
      id: null,
      content: ""
    },
    // dialog
    dialog: false
  }),
  mounted() {
    this.getDataFromApi().then(data => {
      this.users = data.items;
      this.totalusers = data.total;
    });
  },
  methods: {
    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      }, 300);
    },
    callback(data) {},
    successfulUploadCallback(data) {},
    getDataFromApi() {
      this.loading = true;
      return new Promise((resolve, reject) => {
        const { sortBy, descending, page, rowsPerPage } = this.pagination;
        axios.get(baseUrl + "/allannouncements").then(response => {
          this.loading = false;
          let search = this.search.trim().toLowerCase();
          var items = response.data;
          if (search) {
            items = items.filter(item => {
              return Object.values(item)
                .join(",")
                .toLowerCase()
                .includes(search);
            });
          }
          var total = items.length;
          if (rowsPerPage > 0) {
            items = items.slice((page - 1) * rowsPerPage, page * rowsPerPage);
          }
          resolve({
            items,
            total
          });
        });
      });
    },
    save() {
      var today = new Date();
      var date =
        today.getFullYear() +
        "-" +
        (today.getMonth() + 1) +
        "-" +
        today.getDate();
      var time =
        today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      var dateTime = date + " " + time;
      this.editedItem.date = dateTime;
      axios.post(baseUrl + "/saveannouncement", this.editedItem).then(() => {
        this.getDataFromApi().then(data => {
          this.users = data.items;
          this.totalusers = data.total;
        });
        // initialize editItem and it's index
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });

      this.close();
    },
    deleteItem(item) {
      if (confirm("确定要删除该公告吗?")) {
        axios
          .get(baseUrl + "/deleteannouncement", {
            params: { id: item.id }
          })
          .then(() => {
            this.getDataFromApi().then(data => {
              this.users = data.items;
              this.totalusers = data.total;
            });
          });
      }
    }
  }
};
</script>

<style>
</style>