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
        <v-btn text @click="$router.push('/generate/' + item.id);">进入考试</v-btn>
      </template>
      <template v-slot:item.scorewrapper="{ item }">
        <div>{{item.score}}/{{item.totalscore}}</div>
      </template>
    </v-data-table>
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
      { text: "学生姓名", value: "name" },
      { text: "考试时间", value: "date" },
      { text: "得分/总分", value: "scorewrapper" },
      { text: "状态", value: "status" }
    ],
    items: [],
    editedIndex: -1,
    editedItem: {},
    // dialog
    dialog: false,
    courseList: [],
    menu: false
  }),
  computed: {
    ...mapGetters(["user"])
  },
  created() {
    fetchList("/course/query/list", {
      teacherid: store.getters.user.id
    }).then(data => {
      this.courseList = data.items;
    });
  },
  mounted() {
    this.refresh();
  },
  methods: {
    refresh() {
      // 获取数据
      fetchList("/paperhistory/query/list", {}).then(data => {
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
    }
  }
};
</script>

<style>
</style>