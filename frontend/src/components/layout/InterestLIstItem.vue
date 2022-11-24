<template>
  <b-row class="m-2" v-if="show">
    <b-card>
      <b-row>
        <b-col>
          {{ interest.text }}
        </b-col>
        <b-col >
          <b-button-group class="float-end">
            <b-button  @click="goToBoard"> 게시판 </b-button>
            <b-button variant="danger" @click="remove">삭제</b-button>
          </b-button-group>
        </b-col>
      </b-row>
    </b-card>
  </b-row>
</template>

<script>
import { mapActions, mapMutations } from "vuex";

export default {
  data() {
    return {
      show: true,
    };
  },
  props: {
    interest: Object,
  },
  methods: {
    ...mapActions("userStore", ["doDeleteInterestArea"]),
    ...mapMutations("boardStore", ["setGugunCode", "setGugunName"]),
    remove() {
      // console.log(`remove ${this.interest.value}`);
      this.doDeleteInterestArea(this.interest.value);
      this.hide();
    },
    hide() {
      this.show = false;
    },
    goToBoard() {
      this.setGugunCode(this.interest.value);
      this.setGugunName(this.interest.text);
      this.$emit("modalClose");
      this.$router.push("/board");
    },
  },
};
</script>
