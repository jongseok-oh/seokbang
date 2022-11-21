import Constant from "@/common/Constant.js";
import restApi from "@/util/http-common.js";

const boardStore = {
  namespaced: true,
  state: {
    posts: [],
    post: {},
  },
  getters: {
    posts(state) {
      return state.posts;
    },
    post(state) {
      return state.post;
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
      return restApi.post(`/api/posts`, payload).then(() => {
        console.log(`store action ${Constant.REGIST_POST}`);
      });
    },
    hit(context, payload){
      return restApi.put(`/api/posts/${payload}`).then(() => {
        console.log(`hit ㅋㅋ`);
      });
    }
  },
};

export default boardStore;
