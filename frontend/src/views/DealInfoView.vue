<template>
  <div id="dealinfoview">
    <select-bar />
    <my-map />
    <house-deal-list/>
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
    HouseDealList
  },
};
</script>
