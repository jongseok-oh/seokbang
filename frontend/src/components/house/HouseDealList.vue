<template>
    <b-container v-if="deals && deals.length != 0" class="bv-example-row mt-3">
        <h3 class = "mb-3">{{aptName + " 거래 내역"}}</h3>
        <div class = "mb-3"
        style="overflow-y:auto; height : 80vh; white-space:nowrap;">
            <house-deal-list-item v-for="(deal, index) in deals" :key="index" :deal="deal"/>
        </div>
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>거래 내역이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
  </template>
  
  <script>
  import HouseDealListItem from "@/components/house/HouseDealsListItem.vue";
  import { mapState } from "vuex";
  
  const houseStore = "houseStore";
  
  export default {
    name: "HouseList",
    components: {
      HouseDealListItem,
    },
    data() {
        return {};
    },
    computed: {
        ...mapState(houseStore, ["deals", "aptName"]),
    },
  };
  </script>
  
  <style></style>
  