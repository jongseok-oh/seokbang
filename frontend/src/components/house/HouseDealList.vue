<template>
    <b-container v-if="deals && deals.length != 0" class="bv-example-row mt-3">
      <house-list-item v-for="(deal, index) in deals" :key="index" :deal="deal"/>
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>거래 내역이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
  </template>
  
  <script>
  import HouseDealsListItem from "@/components/house/HouseDealsListItem.vue";
  import { mapState } from "vuex";
  
  const houseStore = "houseStore";
  
  export default {
    name: "HouseList",
    components: {
      HouseDealsListItem,
    },
    data() {
      return {};
    },
    computed: {
      ...mapState(houseStore, ["deals"]),
      // houses() {
      //   return this.$store.state.houses;
      // },
    },
  };
  </script>
  
  <style></style>
  