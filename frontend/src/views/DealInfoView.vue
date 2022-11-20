<template>
  <div id="dealinfoview">
    <b-row><select-bar /></b-row>
    <b-row>
      <b-col cols="8">
        <my-map />
      </b-col>
      <b-col>
        <house-deal-list />
      </b-col>
    </b-row>
  </div>
</template>

<script>
import MyMap from "@/components/house/MyMap.vue";
import SelectBar from "@/components/house/HouseSelectBar.vue";
import HouseDealList from "@/components/house/HouseDealList.vue";

export default {
  components: {
    MyMap,
    SelectBar,
    HouseDealList,
  },
};
</script>
