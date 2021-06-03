<template>
  <v-app id="inspire">
    <v-content>
      <v-container class="fill-height login" fluid>
        <v-row align="center" justify="end">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12" height="600" width="460">
              <v-toolbar color="primary" flat>
                <v-toolbar-title>登录</v-toolbar-title>
                <v-spacer />
              </v-toolbar>
              <v-card-text>
                <div class="time1 timeActive">
                  <h1 style="margin-bottom:10px;">2021考研倒计时</h1>
                  <div id="CountMsg" class="HotDate">{{countdown}}</div>
                </div>
                <v-form>
                  <v-text-field
                    v-model="username"
                    label="用户名"
                    name="login"
                    prepend-icon="mdi-account"
                    type="text"
                  />

                  <v-text-field
                    v-model="password"
                    id="password"
                    label="密码"
                    name="password"
                    prepend-icon="mdi-lock"
                    type="password"
                  />
                  <v-radio-group v-model="usertype" row>
                    <v-radio label="学生" value="学生"></v-radio>
                    <v-radio label="老师" value="老师"></v-radio>
                    <v-radio label="管理员" value="管理员"></v-radio>
                  </v-radio-group>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer />
                <v-btn color="secondary" @click="login" style="width:300px;" class="title">登录</v-btn>
                <v-spacer />
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>
<script>
import axios from "axios";
import store from "@/store";
export default {
  props: {
    source: String
  },
  data: () => ({
    username: "",
    password: "",
    usertype: "",
    countdown: ""
  }),
  methods: {
    recompute() {
      var now = new Date();
      //定义目标时间变量
      // var future = new Date(2020,12,20,24,0,0);
      var future = new Date("2020/12/20 00:00:00");
      var lefts = parseInt((future - now) / 1000); //秒数
      var day = parseInt(lefts / 86400);
      var hour = parseInt((lefts % 86400) / 3600);
      var min = parseInt(((lefts % 86400) % 3600) / 60);
      var sec = lefts % 60;
      var str = day + "天" + hour + "时" + min + "分" + sec + "秒";
      this.countdown = str;
    },
    login() {
      // 用户名密码合法性检验
      var reg = /[`~!#$%^&*()_+<>?:"{},;'[\]]/im;
      if (reg.test(this.username)||reg.test(this.password)) {
        alert("提示：您输入的信息含有非法字符！");
        return;
      }
      store
        .dispatch("user/login", {
          username: this.username,
          password: this.password,
          usertype: this.usertype
        })
        .then(() => {
          if (store.getters.user) {
            if (store.getters.user.usertype == "学生")
              this.$router.replace({
                path: this.$route.query.redirect || "/paperlist"
              });
            else
              this.$router.replace({
                path: this.$route.query.redirect || "/manage"
              });
          }
        });
    }
  },
  mounted() {
    setInterval(this.recompute, 1000);
  }
};
</script>
<style>
/* 登录界面 */
.login {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  background-image: url("https://m.zhan.com/uploadfile/2017/08/24/201_2017082418072719QZE.jpg");
  background-size: cover;
  min-height: 580px;
}

.login .login-content-wrap {
  position: absolute;
  width: 460px;
  height: 100%;
  min-height: 580px;
  background: rgba(255, 255, 255, 0.4);
  top: 0;
  right: 0;
}

.login .login-content {
  width: 360px;
  height: 580px;
  margin: auto;
  background: rgba(255, 255, 255, 1);
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  font-size: 12px;
  transform: translateY(-50%);
}

.login .logo {
  display: block;
  margin: 0 auto;
  margin-top: 50px;
}

.login .login-form-button {
  width: 100%;
}

.login .login-from {
  width: 80%;
  margin: 0 auto;
  margin-top: 50px;
}
.time1 {
  border-radius: 5%;
  margin-bottom: 10px;
  padding: 15px;
  width: 100%;
  background: url("https://pic.sucaibar.com/pic/201708/14/463ba29231.jpg");
  background-position: center;
  opacity: 0.7;
  text-align: center;
  color: #ffffff;
}
</style>