<template>
  <div>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center">
        <div class="headline" style="color:black;">在线考试系统</div>
      </div>
      <v-spacer></v-spacer>
      <div v-if="user" style="color:black;">欢迎您，{{user.name}}</div>
      <v-menu left bottom>
        <template v-slot:activator="{ on }">
          <v-btn icon v-on="on" light>
            <v-icon>mdi-dots-vertical</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item @click="historyview">
            <v-list-item-title>查看历史成绩</v-list-item-title>
          </v-list-item>
          <v-list-item @click="passwdview">
            <v-list-item-title>密码修改</v-list-item-title>
          </v-list-item>
          <v-list-item
            @click="()=>{}"
            to="/manage"
            target="_blank"
            v-if="(user)&&(!(user.usertype==='学生'))"
          >
            <v-list-item-title>进入管理后台</v-list-item-title>
          </v-list-item>
          <v-list-item @click="logout">
            <v-list-item-title>注销</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-app-bar>
    <v-content>
      <router-view></router-view>
    </v-content>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import store from "@/store";

export default {
  name: "home",
  components: {},
  data: () => ({
    currentTab: 0,
    tabs: [
      {
        name: "待做试卷",
        route: "/stu/notebook"
      },
      {
        name: "学习单词",
        route: "/stu/wordlearning"
      }
    ]
  }),
  computed: {
    ...mapGetters(["user"])
  },
  methods: {
    logout() {
      store.dispatch("user/logout");
      this.$router.replace({ path: this.$route.query.redirect || "/login" });
    },
    historyview() {
      let routeData = this.$router.resolve({
        name: "stupaperhistory",
        query: { data: "someData" }
      });
      window.open(routeData.href, "_blank");
    },
    passwdview(){
      window.close();
      let routeData = this.$router.resolve({
        name: "studentpasswd",
        query: { data: "someData" }
      });
      window.open(routeData.href, "_blank");
    }
  },
  created() {}
};
</script>
