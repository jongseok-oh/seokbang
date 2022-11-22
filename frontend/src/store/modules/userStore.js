import { login, logout, duplicate} from "@/api/user.js";
import router from "@/router";


const userStore = {
  namespaced: true,
  state: {
    userNo: 1,
    userinfo: {}
  },
  getters: {
    userNo(state) {
      return state.userNo;
    },
  },
  mutations: {
    SET_USER_INFO(state, userinfo) {
      state.userinfo = userinfo;
      //console.log(state.userinfo);
    },
    CLEAR_USER_INFO(state) {
      state.userinfo = {}
    }
  },
  actions: {
    doLogin: ({ commit }, payload) => {
      //console.log(payload);
      login(
        payload
        ,(res) => {
          if (res.status == 204) {
            alert("로그인 정보를 확인해 주세요");
          } else if(res.status == 200){
            commit("SET_USER_INFO", res.data);
            alert(`반갑습니다 ${res.data.userName}님!`);
            router.push({name: "main"});
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    doLogout: ({ commit }) => {
      //console.log(payload);
      logout(
        (res) => {
          commit("CLEAR_USER_INFO");
        },
        (error) => {
          console.log(error);
        }
      )
    },
  },
};

export default userStore;
