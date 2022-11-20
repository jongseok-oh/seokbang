<template>
  <b-row class="m-2">
    <b-col cols="2" class="text-center align-self-center" />
    <b-col cols="10" class="align-self-center"> [{{ deal.일련번호 }}] {{ house.아파트 }} </b-col>
  </b-row>
</template>

<script>
export default {
  name: "HouseListItem",
  data() {
    return {};
  },
};
</script>
