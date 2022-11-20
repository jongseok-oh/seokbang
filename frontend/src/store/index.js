import Vue from "vue";
import Vuex from "vuex";
import Constant from "@/common/Constant.js";
import restApi from "@/util/http-common.js";
import houseStore from "@/store/modules/houseStore";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    houseStore,
  },
  state: {
    posts: [],
    post: {},
    userNo: 1,
  },
  getters: {
    posts(state) {
      return state.posts;
    },
    post(state) {
      return state.post;
    },
    userNo(state) {
      return state.userNo;
    },
  },
  mutations: {
    [Constant.SET_POSTS](state, payload) {
      state.posts = payload;
    },
    [Constant.SET_POST](state, payload) {
      state.post = payload;
    },
  },
  actions: {
    [Constant.GET_POSTS](context, payload) {
      return restApi.get(`/api/posts/${payload}`).then(({ data }) => {
        context.commit(Constant.SET_POSTS, data);
      });
    },
    [Constant.GET_POST](context, payload) {
      return restApi.get(`/api/posts/detail/${payload}`).then(({ data }) => {
        context.commit(Constant.SET_POST, data);
      });
    },
    [Constant.REGIST_POST](context, payload) {
      console.log(payload);
      return restApi.post(`/api/posts`, payload).then(() => {
        console.log(`store action ${Constant.REGIST_POST}`);
      });
    },
  },
});
