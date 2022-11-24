<template>
    <b-container v-if="deals && deals.length != 0" class="bv-example-row mt-3">      
        <house-deal-list-gugun v-if="listState=='gugun'"/>
        <house-deal-list-search v-else-if="listState=='search'"/>
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert variant="dark" show>거래 내역이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
</template>
  
  <script>
import HouseDealListGugun from "@/components/house/HouseDealListGugun.vue";
import HouseDealListSearch from "@/components/house/HouseDealListSearch.vue";
import { mapState } from "vuex";
  
  export default {
    name: "HouseList",
    components: {
      HouseDealListGugun,
      HouseDealListSearch
    },
    data() {
        return {};
    },
    computed: {
      ...mapState('houseStore', ["deals", "listState"]),
    },
  };
  </script>
  
  <style></style>
  