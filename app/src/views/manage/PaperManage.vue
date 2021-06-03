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
        <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
        <v-tooltip bottom>
          <template v-slot:activator="{ on }">
            <v-btn @click="download(item)" icon v-on="on">
              <v-icon style="margin-left:10px;" small>mdi-download</v-icon>
            </v-btn>
          </template>
          <span>下载考试成绩</span>
        </v-tooltip>
      </template>
    </v-data-table>
    <!-- 新增弹框 -->
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">新建考试</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-select
                  :items="courseList"
                  item-text="name"
                  item-value="id"
                  label="下拉选择考试科目"
                  v-model="editedItem.courseid"
                ></v-select>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="editedItem.title" label="考试名称"></v-text-field>
              </v-col>
              <v-col cols="4">
                <v-menu
                  v-model="menu"
                  :close-on-content-click="false"
                  :nudge-right="40"
                  transition="scale-transition"
                  offset-y
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      v-model="editedItem.date"
                      label="考试日期"
                      prepend-icon="mdi-event"
                      readonly
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker v-model="editedItem.date" @input="menu = false" dark></v-date-picker>
                </v-menu>
              </v-col>
              <v-col cols="4">
                <v-menu
                  v-model="startTimeMenu"
                  :close-on-content-click="false"
                  :nudge-right="40"
                  transition="scale-transition"
                  offset-y
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      v-model="editedItem.starttime"
                      label="开始时间"
                      prepend-icon="mdi-event"
                      readonly
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-time-picker v-model="editedItem.starttime" @input="startTimeMenu = false" dark></v-time-picker>
                </v-menu>
              </v-col>
              <v-col cols="4">
                <v-menu
                  v-model="endTimeMenu"
                  :close-on-content-click="false"
                  :nudge-right="40"
                  transition="scale-transition"
                  offset-y
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      v-model="editedItem.endtime"
                      label="结束时间"
                      prepend-icon="mdi-event"
                      readonly
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-time-picker v-model="editedItem.endtime" @input="endTimeMenu = false" dark></v-time-picker>
                </v-menu>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="editedItem.description" label="考试描述"></v-text-field>
              </v-col>

              <v-col cols="12">
                <v-subheader>试题难度数量设置:</v-subheader>
              </v-col>
              <v-col cols="6" style="padding-bottom:0;padding-top:0;">
                <v-text-field v-model="editedItem.count1" label="单选题个数" type="number"></v-text-field>
              </v-col>
              <v-col cols="4" style="padding-bottom:0;padding-top:0;">
                <v-select :items="['简单','一般','困难']" v-model="editedItem.difficulty1" label="单选题难度"></v-select>
              </v-col>
              <v-col cols="2">
                <div style="color:red;border-style:groove;text-align:center;">2分</div>
              </v-col>
              <v-col cols="6" style="padding-bottom:0;padding-top:0;">
                <v-text-field v-model="editedItem.count2" label="填空题个数" type="number"></v-text-field>
              </v-col>
              <v-col cols="4" style="padding-bottom:0;padding-top:0;">
                <v-select :items="['简单','一般','困难']" v-model="editedItem.difficulty2" label="填空题难度"></v-select>
              </v-col>
              <v-col cols="2">
                <div style="color:red;border-style:groove;text-align:center;">1分</div>
              </v-col>
              <v-col cols="6" style="padding-bottom:0;padding-top:0;">
                <v-text-field v-model="editedItem.count3" label="判断题个数" type="number"></v-text-field>
              </v-col>
              <v-col cols="4" style="padding-bottom:0;padding-top:0;">
                <v-select :items="['简单','一般','困难']" v-model="editedItem.difficulty3" label="判断题难度"></v-select>
              </v-col>
              <v-col cols="2">
                <div style="color:red;border-style:groove;text-align:center;">1分</div>
              </v-col>
              <v-col cols="6" style="padding-bottom:0;padding-top:0;">
                <v-text-field v-model="editedItem.count4" label="主观题个数" type="number"></v-text-field>
              </v-col>
              <v-col cols="4" style="padding-bottom:0;padding-top:0;">
                <v-select :items="['简单','一般','困难']" v-model="editedItem.difficulty4" label="主观题难度"></v-select>
              </v-col>
              <v-col cols="2">
                <div style="color:red;border-style:groove;text-align:center;">10分</div>
              </v-col>
              <v-col cols="12">
                <div
                  style="color:black;font-size:20px;border-style:groove;padding:15px;max-width:300px;"
                >默认时长：1小时30分</div>
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
      { text: "考试名称", value: "title" },
      { text: "描述", value: "description" },
      { text: "考试时间", value: "date" },
      { text: "负责老师ID", value: "uid" },
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
    dialog: false,
    courseList: [],
    menu: false,
    // time picker
    startTimePicker: null,
    endTimePicker: null,
    startTimeMenu: false,
    endTimeMenu: false
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
      fetchList("/paper/query/list", {
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
    deleteItem(item) {
      if (confirm("确定要删除该课程吗?")) {
        axios
          .get(baseUrl + "/paper/delete", {
            params: { id: item.id }
          })
          .then(() => {
            this.refresh();
          });
      }
    },
    save() {
      fly
        .post(baseUrl + "/paper/upsert", {
          courseid: this.editedItem.courseid,
          title: this.editedItem.title,
          description: this.editedItem.description,
          uid: store.getters.user.id,
          date: this.editedItem.date,
          count1: this.editedItem.count1,
          count2: this.editedItem.count2,
          count3: this.editedItem.count3,
          count4: this.editedItem.count4,
          difficulty1: this.editedItem.difficulty1,
          difficulty2: this.editedItem.difficulty2,
          difficulty3: this.editedItem.difficulty3,
          difficulty4: this.editedItem.difficulty4,
          starttime: this.editedItem.starttime,
          endtime: this.editedItem.endtime
        })
        .then(response => {
          this.refresh();
          this.dialog = false;
        });
    },
    download(item) {
      fetchList("/paperhistory/query/list", {
        paperid: item.id
      }).then(data => {
        if (data.items.length > 0) {
          window.open(baseUrl + "/paper/downloadexcel?paperid=" + item.id);
        } else alert("暂无数据，无法下载");
      });
    }
  }
};
</script>

<style>
</style>