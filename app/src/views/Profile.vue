<template>
  <v-container>
    <v-card>
      <v-card-title>
        <span class="headline">密码修改</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12">
              <v-text-field v-model="oldpasswd" label="请输入原密码"></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field v-model="newpasswd" label="新输入新密码"></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field v-model="repeatnewpasswd" label="重复新密码"></v-text-field>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="save">保存</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";
import { baseUrl } from "@/config";
import store from "@/store";
export default {
  data: () => ({
    oldpasswd: "",
    newpasswd: "",
    repeatnewpasswd: ""
  }),
  methods: {
    close() {
      this.dialog = false;
    },
    save() {
      console.warn(store.getters.user);
      if (store.getters.user.password != this.oldpasswd) {
        alert("原密码输入错误！");
        return;
      } else if (this.newpasswd != this.repeatnewpasswd) {
        alert("两次输入新密码不相同！");
        return;
      }
      axios.post(baseUrl + "/user/upsert", {
        id: store.getters.user.id,
        name: store.getters.user.name,
        username: store.getters.user.username,
        password: this.newpasswd,
        major: store.getters.user.major,
        usertype: store.getters.user.usertype
      });
      alert("修改成功，请使用新密码重新登录！");
      store.dispatch("user/logout");
      this.$router.replace({ path: this.$route.query.redirect || "/login" });
    }
  },
  mounted() {
    this.editedItem = store.getters.user;
  }
};
</script>

<style>
</style>