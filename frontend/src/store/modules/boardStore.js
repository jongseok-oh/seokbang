import { apiInstance } from "@/api/index.js";

let restApi = apiInstance();

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
    setPosts(state, payload) {
      state.posts = payload;
    },
    setPost(state, payload) {
      state.post = payload;
    },
    setLikesCnt(state, payload) {
      state.post.likesCnt = payload;
    },
    setIsLiked(state, payload) {
      state.post.isLiked = payload;
    },
    clear(state) {
      state.posts = [];
      state.post = {};
    },
  },
  actions: {
    async getPosts(context, payload) {
      context.commit("clear");
      return await restApi.get(`/api/posts/${payload}`).then(({ data }) => {
        context.commit("setPosts", data);
      });
    },
    async getPost(context, payload) {
      context.commit("clear");
      return await restApi.get(`/api/posts/detail/${payload}`).then(({ data }) => {
        context.commit("setPost", data.post);
        context.commit("setLikesCnt", data.likesCnt);
        context.commit("setIsLiked", data.isLiked);
      });
    },
    async registPost(context, payload) {
      return await restApi.post(`/api/posts`, payload).then(() => {
        console.log(`store action registPost`);
      });
    },
    async modifyPost(context, payload) {
      return await restApi.put(`/api/posts`, payload).then(() => {
        console.log(`store action modifyPost`);
      });
    },
    async deletePost(context, payload, success) {
      console.log("delete");
      return await restApi.delete(`/api/posts/${payload}`).then(success);
    },
    async hit(context, payload){
      return await restApi.put(`/api/posts/${payload}`).then(() => {
        console.log(`hit ㅋㅋ`);
      });
    },
    async likePost(context, payload){
        return await restApi.post(`/api/posts/like/${payload}`).then(() => {
          console.log(`like ㅋㅋ`);
        });
      },
    async unlikePost(context, payload){
        return await restApi.delete(`/api/posts/like/${payload}`).then(() => {
          console.log(`unlike ㅋㅋ`);
        });
    },
    async registReple(context, payload) {
      return await restApi.post(`/api/reples`, payload).then(() => {
        console.log(`store action regist reple`);
      });
    },
    async getReples(context, payload) {
      return await restApi.get(`/api/reples/${payload}`);
    },
  },
};

export default boardStore;
