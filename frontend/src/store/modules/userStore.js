import { login, logout, modifyUser, deleteUser, deleteInterestArea, insertInterestArea} from "@/api/user.js";
import { apiInstance } from "@/api/index.js";
import router from "@/router";

const restApi = apiInstance();

const userStore = {
  namespaced: true,
  state: {
    userinfo: {},
    interestList: [],
  },
  getters: {
    userNo(state) {
      return state.userNo;
    },
  },
  mutations: {
    SET_USER_INFO(state, userinfo) {
      for (var key in userinfo) {
        state.userinfo[key] = userinfo[key];
      }
      //console.log(state.userinfo);
    },
    SET_INTEREST_LIST(state, payload) {
      state.interestList = payload;
    },
    CLEAR_USER_INFO(state) {
      state.userinfo = {}
    },
    DELET_INTEREST(state, gugunCode) {
      const idx = state.interestList.indexOf(gugunCode);
      if (idx > -1) state.interestList.splice(idx, 1);
    },
    INSERT_INTEREST(state, gugunCode) {
      state.interestList.push(gugunCode);
    },
  },
  actions: {
    doLogin: ({ commit, dispatch }, payload) => {
      //console.log(payload);
      login(
        payload
        , ({status, data}) => {
          if (status == 204) {
            alert("로그인 정보를 확인해 주세요");
          } else if(status == 200){
            commit("SET_USER_INFO", data);
            dispatch("getInterestAreas");
            alert(`반갑습니다 ${data.userName}님!`);
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
        () => {
          commit("CLEAR_USER_INFO");
          router.push('/');
        },
        (error) => {
          console.log(error);
        }
      )
    },
    doModifyUser:({ commit, state }, userInfo) => {
      //console.log(payload);
      commit('SET_USER_INFO', userInfo);
      console.log(state);
      modifyUser(
        state.userinfo,
        () => {
          alert("회원정보 수정 성공!");
          router.push('/');
        },
        (error) => {
          console.log(error);
        }
      )
    },
    doDeleteUser:({ state, dispatch }) => {
      //console.log(payload);
      let params = { no: state.userinfo.no };
      deleteUser(
      params,
        () => {
          dispatch('doLogout');
          alert("탈퇴 성공 ㅜㅜ");
          router.push('/');
        },
        (error) => {
          console.log(error);
        }
      )
    },
    getInterestAreas({commit}) {
      return restApi.get(`/api/interests`).then(({data}) => {
        commit("SET_INTEREST_LIST", data);
      });
    },
    doDeleteInterestArea:({commit}, path) => {
      //console.log(payload);
      deleteInterestArea(
        path,
        () => {
          commit('DELET_INTEREST', path);
        },
        (error) => {
          console.log(error);
        }
      )
    },
    doInsertInterestArea:({commit}, path) => {
      //console.log(payload);
      insertInterestArea(
        path,
        () => {
          commit('INSERT_INTEREST', path);
        },
        (error) => {
          console.log(error);
        }
      )
    },
  },
};

export default userStore;
