import { sidoList, gugunList, houseList, houseDealList } from "@/api/house.js";
import axios from "axios";

const houseStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    gugunCode:"",
    houses: [],
    deals: [],
    aptName:""
  },
  getters: {},
  mutations: {
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_APT_LIST(state) {
      state.houses = [];
      state.house = null;
    },
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    SET_GUGUN_CODE(state, gugunCode) {
      state.gugunCode = gugunCode;
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
      //console.log(state.houses);
    },
    SET_DEAL_HOUSE_LIST(state, deals) {
      state.deals = deals;
      //console.log(state.deals);
    },
    CLEAR_DEAL_HOUSE_LIST(state) {
      state.deals = [];
    },
    SET_APT_NAME(state, aptName) {
      state.aptName = aptName;
    }
  },
  actions: {
    getSido: ({ commit }) => {
      sidoList(
        ({ data }) => {
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
      // axios.get(`http://localhost:8080/api/locations/sidocode`, { withCredentials: true }).then(({ data }) => {
      //   commit("SET_SIDO_LIST", data);
      // }).catch((error) => {
      //   console.log(error);
      // });
    },
    getGugun: ({ commit }, sidoCode) => {
      const params = { sido: sidoCode };
      gugunList(
        params,
        ({ data }) => {
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseList: ({ commit }, gugunCode) => {
      const params = {
        gugunCode: gugunCode,
      };
      houseList(
        params,
        ({ data }) => {
          //console.log(data);
          commit("SET_HOUSE_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseDealList: ({ commit }, aptObj) => {
      const params = {
        aptCode: aptObj["aptCode"],
      };
      commit("SET_APT_NAME", aptObj["aptName"]);
      houseDealList(
        params,
        ({ data }) => {
          commit("SET_DEAL_HOUSE_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default houseStore;
