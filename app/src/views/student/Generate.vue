<template>
  <v-container v-if="questionMap">
    <div class="title" style="margin-bottom:10px;">一丶单选题</div>
    <div v-for="(item,index) in questionMap['单选题']" v-bind:key="item.id">
      <div>{{index+1}}.{{item.title}}</div>
      <v-radio-group v-model="item.input" >
        <v-radio :label="item.choicea" value="A"></v-radio>
        <v-radio :label="item.choiceb" value="B"></v-radio>
        <v-radio :label="item.choicec" value="C"></v-radio>
        <v-radio :label="item.choiced" value="D"></v-radio>
      </v-radio-group>
    </div>
    <div class="title" style="margin-bottom:10px;">二丶填空题</div>
    <div v-for="(item,index) in questionMap['填空题']" v-bind:key="item.id">
      <div>{{index+1}}.{{item.title}}</div>
      <v-text-field v-model="item.input" label="答案" style="width:20%;"></v-text-field>
    </div>
    <div class="title" style="margin-bottom:10px;">三丶判断题</div>
    <div v-for="(item,index) in questionMap['判断题']" v-bind:key="item.id">
      <div>{{index+1}}.{{item.title}}</div>
      <v-select :items="['正确','错误']" v-model="item.input" label="答案" style="width:20%;"></v-select>
    </div>
    <div class="title" style="margin-bottom:10px;">四丶主观题</div>
    <div v-for="(item,index) in questionMap['主观题']" v-bind:key="item.id">
      <div>{{index+1}}.{{item.title}}</div>
      <v-textarea v-model="item.input" label="答案" style="width:40%;"></v-textarea>
    </div>
    <v-btn class="mx-5" fixed bottom right large color="secondary" @click="submit">
      交卷(
      <span v-cloak>{{hour}}:{{min}}:{{sec}}</span>)
    </v-btn>
    <v-dialog v-model="dialog" max-width="600px" persistent>
      <v-card>
        <v-card-title>考试须知：</v-card-title>
        <v-card-text>
          <v-container>
            <div>一丶考试为在线考试，有时间限制</div>
            <div>二丶考试期间不得离开考试页面，否则本次考试作废</div>
            <div>三丶考试请独立思考，不得与他人交流</div>
            <div>四丶请将手机带离考场或交给监考老师保管，带手机进入考场一律视为作弊</div>
            <div>五丶若还没开考，请耐心等待</div>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="red darken-1" text @click="close">我已阅读考试须知并将严格遵守</v-btn>
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
      { text: "描述", value: "description" },
      { text: "考试时间", value: "date" },
      { text: "负责老师ID", value: "uid" },
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
    menu: false,
    questionMap: null,
    //计时
    timer: 0,
    hour: 0,
    min: 0,
    sec: 0
  }),
  computed: {
    ...mapGetters(["user"])
  },
  mounted() {
    this.dialog = true;
    fly
      .get(baseUrl + "/paper/generate", {
        id: this.$route.params.id
      })
      .then(response => {
        this.questionMap = response.data;
      });
    // 开始计时
    let endTime = new Date().getTime() + 5400000;
    // let endTime = new Date().getTime() + 54000;
    this.timer = window.setInterval(() => {
      let timeLast = endTime - new Date().getTime();
      let hour = parseInt(timeLast / (1000 * 60 * 60));
      let min = parseInt((timeLast % (1000 * 60 * 60)) / (1000 * 60));
      let sec = parseInt(((timeLast % (1000 * 60 * 60)) % (1000 * 60)) / 1000);
      this.hour = hour < 10 ? "0" + hour : hour;
      this.min = min < 10 ? "0" + min : min;
      this.sec = sec < 10 ? "0" + sec : sec;
      if (this.hour == 0 && this.min == 0 && this.sec == 0) {
        window.clearInterval(this.timer);
        this.submit();
      }
    }, 1000);
  },
  methods: {
    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = {};
        this.editedIndex = -1;
      }, 300);
    },
    submit() {
      let questionList = this.questionMap["单选题"]
        .concat(this.questionMap["填空题"])
        .concat(this.questionMap["判断题"])
        .concat(this.questionMap["主观题"]);
      fly
        .post(baseUrl + "/paper/submit", questionList, {
          params: {
            uid: store.getters.user.id,
            paperid: this.$route.params.id
          }
        })
        .then(response => {
          alert("交卷成功，请等待系统批阅。");
          this.$router.replace({
            path: "/paperlist"
          });
        });
    }
  }
};
</script>

<style>
.active-class{
  color: aqua;
}
</style>