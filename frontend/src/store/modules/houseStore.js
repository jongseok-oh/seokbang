import { sidoList, gugunList, houseList, houseDealList } from "@/api/house.js";

const houseStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    houses: [],
    deals: [],
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
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
      console.log(state.houses);
    },
    SET_DEAL_HOUSE_LIST(state, deals) {
      deals.forEach((deal) => {
        state.deals.push(deal);
      });
    },
    SET_APT_CODE(state, aptCode) {
      state.aptCode = aptCode;
    },
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
    getHouseDealsList: ({ commit }, aptCode) => {
      const params = {
        aptCode: aptCode,
      };
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
