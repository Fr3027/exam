import Cookies from 'js-cookie'
import axios from "axios";
import { baseUrl } from "@/config";

const state = {
    user: Cookies.get('user') ? JSON.parse(Cookies.get('user')) : null,
}

const mutations = {
    SET_USER: (state, user) => {
        state.user = user
        Cookies.set('user', user);
    }
}

const actions = {
    login({ commit }, userInfo) {
        const { username, password, usertype } = userInfo
        return new Promise((resolve, reject) => {
            axios
                .post(baseUrl + "/user/login", {
                    username: username,
                    password: password,
                    usertype: usertype
                })
                .then(response => {
                    if (response.data.id) {
                        console.log("success");
                        // 登录成功后存入state
                        commit('SET_USER', response.data)
                        resolve(response)
                    } else {
                        alert("用户名密码不匹配！")
                    }
                }).catch(error => {
                    reject(error);
                });
        })
    },
    logout({ commit }) {
        commit('SET_USER', null);
        Cookies.remove('user');
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}