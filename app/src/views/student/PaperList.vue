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
        <div v-if="isInTime(item.date,item.starttime,item.endtime)">
          <v-btn text @click="$router.push('/generate/' + item.id)">进入考试</v-btn>
        </div>
        <div v-else>
          <v-btn text @click="$router.push('/generate/' + item.id);" disabled>已过期</v-btn>
        </div>
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
      { text: "描述", value: "description" },
      { text: "考试日期", value: "date" },
      { text: "开始时间", value: "starttime" },
      { text: "结束时间", value: "endtime" },
      { text: "负责老师", value: "name" },
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
    if (store.getters.user && store.getters.user.usertype != "学生")
      this.$router.replace({
        path: this.$route.query.redirect || "/manage"
      });
    this.refresh();
  },
  methods: {
    refresh() {
      // 获取数据
      fetchList("/paper/query/available", {
        uid: store.getters.user.id
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
    isInTime(date, starttime, endtime) {
      var startdatetime = new Date(date + "T" + starttime);
      var enddatetime = new Date(date + "T" + endtime);
      var currentdatetime = new Date();
      if (startdatetime < currentdatetime && currentdatetime < enddatetime) {
        return true;
      } else {
        return false;
      }
    }
  }
};
</script>

<style>
</style>