<template>
  <v-app>
    <v-navigation-drawer app class="mx-auto text-center" color="#87cefa" dark permanent>
      <v-list nav class="text-left">
        <v-list-item v-for="item in items" :key="item.name" link :to="item.route">
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title class="title">{{ item.name }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-btn width="200" color="blue" class="mt-10" @click="logout">注销</v-btn>
    </v-navigation-drawer>
    <v-content>
      <router-view></router-view>
    </v-content>
    <!-- <component :is="appropriateComponent"></component> -->
  </v-app>
</template>

<script>
import axios from "axios";
import { baseUrl } from "@/config";
import { mapGetters } from "vuex";
import store from "@/store";

export default {
  computed: {
    appropriateComponent() {
      if (store.getters.user.usertype === "管理员2") return "UserManage";
      else if (store.getters.user.usertype === "卖家") return "ProductManage";
      return "ProductList";
    },
    ...mapGetters(["user"]),
    items() {
      let admin_items = [
        {
          name: "学生账户管理",
          route: "/studentmanage",
          icon: "mdi-account-child-circle"
        },
        {
          name: "老师账户管理",
          route: "/teachermanage",
          icon: "mdi-account-multiple"
        },
        {
          name: "管理员账户管理",
          route: "/adminmanage",
          icon: "mdi-account-tie-outline"
        },
        {
          name: "密码修改",
          route: "/profile",
          icon: "mdi-lock"
        },
      ];
      let tea_items = [
        {
          name: "课程管理",
          route: "/coursemanage",
          icon: "mdi-school"
        },
        {
          name: "考试管理",
          route: "/papermanage",
          icon: "mdi-newspaper-variant-multiple"
        },
        {
          name: "主观题批阅",
          route: "/questionscore",
          icon: "mdi-message-draw"
        },
        {
          name: "学生成绩",
          route: "/manage/paperhistory",
          icon: "mdi-equal-box"
        },
        {
          name: "密码修改",
          route: "/profile",
          icon: "mdi-lock"
        },
      ];

      if (store.getters.user && store.getters.user.usertype == "管理员")
        return admin_items;
      else return tea_items;
    }
  },
  methods: {
    beseller() {
      axios
        .get(baseUrl + "/user/beseller", {
          params: {
            id: store.getters.user.id
          }
        })
        .then(() => {
          alert("成为卖家成功，请重新登录！");
          this.logout();
        });
    },
    logout() {
      store.dispatch("user/logout");
      this.$router.replace({ path: this.$route.query.redirect || "/login" });
    }
  },
  mounted() {
    if (this.$router.currentRoute.path != "/manage") {
      return;
    }
    if (store.getters.user.usertype === "管理员") {
      this.$router.replace({ path: "/studentmanage" });
    } else if (store.getters.user.usertype === "老师") {
      this.$router.replace({ path: "/coursemanage" });
    }
  }
};
</script>