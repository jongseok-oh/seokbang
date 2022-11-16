<template>
  <div>
    <my-map></my-map>
    <router-view></router-view>
  </div>
</template>

<script>
  import MyMap from "@/components/MyMap.vue";
  export default {
    components: {
      MyMap,
    },
  };
</script>
