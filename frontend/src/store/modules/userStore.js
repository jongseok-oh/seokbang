import Constant from "@/common/Constant.js";
import restApi from "@/util/http-common.js";

const userStore = {
  namespaced: true,
  state: {
    userNo: 1,
  },
  getters: {
    userNo(state) {
      return state.userNo;
    },
  },
  mutations: {
  },
  actions: {
  },
};

export default userStore;
