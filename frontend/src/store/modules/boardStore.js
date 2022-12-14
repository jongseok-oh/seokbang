import { apiInstance } from "@/api/index.js";

const restApi = apiInstance();

const boardStore = {
  namespaced: true,
  state: {
    posts: [],
    post: {},
    postNo: Number,
    gugunCode: String,
    gugunName: String,
  },
  getters: {
    posts(state) {
      return state.posts;
    },
  },
  mutations: {
    setPosts(state, payload) {
      state.posts = payload;
    },
    setPost(state, payload) {
      state.post = payload;
    },
    setPostNo(state, payload) {
      state.postNo = payload;
    },
    setGugunCode(state, payload) {
      state.gugunCode = payload;
    },
    setGugunName(state, payload) {
      state.gugunName = payload;
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
    getPosts(context, payload) {
      context.commit("clear");
      return restApi.get(`/api/posts/${payload}`).then(({ data }) => {
        context.commit("setPosts", data);
        // console.log(data);
      });
    },
    getPost(context, payload) {
      context.commit("clear");
      return restApi.get(`/api/posts/detail/${payload}`).then(({ data }) => {
        context.commit("setPost", data.post);
        context.commit("setIsLiked", data.isLiked);
      });
    },
    registPost(context, payload) {
      return restApi.post(`/api/posts`, payload).then(() => {
        // console.log(`store action registPost`);
      });
    },
    modifyPost(context, payload) {
      return restApi.put(`/api/posts`, payload).then(() => {
        // console.log(`store action modifyPost`);
      });
    },
    deletePost(context, payload) {
      return restApi.delete(`/api/posts/${payload}`).then(() => {
        // console.log("delete post");
      });
    },
    hit(context, payload){
      return restApi.put(`/api/posts/${payload}`).then(() => {
        // console.log(`hit ㅋㅋ`);
      });
    },
    likePost(context, payload){
        return restApi.post(`/api/posts/like/${payload}`).then(() => {
          // console.log(`like ㅋㅋ`);
        });
      },
    unlikePost(context, payload){
        return restApi.delete(`/api/posts/like/${payload}`).then(() => {
          // console.log(`unlike ㅋㅋ`);
        });
    },
    registReple(context, payload) {
      return restApi.post(`/api/reples`, payload).then(() => {
        // console.log(`store action regist reple`);
      });
    },
    getReples(context, payload) {
      return restApi.get(`/api/reples/${payload}`).then(({data}) => {
        // console.log(data);
        return data;});
    },
    deleteReple(context, payload) {
      return restApi.delete(`/api/reples/${payload}`).then(() => {
        // console.log("delete reple");
      });
    },
    getNotices(context) {
      return restApi.get(`/api/posts/notices`).then(({ data }) => {
        return data;
      });
    }
  },
};

export default boardStore;
