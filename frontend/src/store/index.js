import Vue from 'vue'
import Vuex from 'vuex'
import Constant from '@/common/Constant.js'
import restApi from "@/util/http-common.js";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts : [],
    post : {}
  },
  getters:{
    posts(state){
      return state.posts;
    }
  },
  mutations: {
    [Constant.SET_POSTS](state,payload) {
      state.posts = payload;
    },
    [Constant.SET_POST](state,payload) {
      state.post = payload;
    },
  },
  actions: {
    [Constant.GET_POSTS](context){
      return restApi.get("/api/posts").then(({ data }) => {context.commit(Constant.SET_POSTS, data);});
    },
    [Constant.REGISTER_POST](context,payload) {
      return restApi.post(`/api/posts`, payload).then(() => console.log(`store action ${Constant.REGISTER_POST}`));
    },
    [Constant.GET_POST](context, payload){
      return restApi.get(`/api/posts/${payload}`).then(({ data }) => {context.commit(Constant.SET_POST, data)});
    },
    [Constant.MODIFY_POST](context, payload){
      return restApi.put(`/api/posts`, payload).then(() => console.log(`store action ${Constant.MODIFY_POST}`));
    },
    [Constant.REMOVE_POST](context, payload){
      return restApi.delete(`/api/posts/${payload.no}`).then(() => console.log(`store action ${Constant.REMOVE_POST}`));
    },
  },
})
