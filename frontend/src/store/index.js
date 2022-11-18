import Vue from 'vue'
import Vuex from 'vuex'
import Constant from '@/common/Constant.js'
import restApi from "@/util/http-common.js";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts: [],
  },
  getters: {
    posts(state){
      return state.posts;
    }
  },
  mutations: {
    [Constant.SET_POSTS](state,payload) {
      state.posts = payload;
    },
  },
  actions: {
    [Constant.GET_POSTS](context){
      return restApi.get("/api/posts").then(({ data }) => {
        context.commit(Constant.SET_POSTS, data);
      });
    },
  }
})
