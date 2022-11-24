<template>
  <div>
      <h5 @click="moveNoticeList" style="cursor: pointer">공지사항</h5>
      <div class="list-group">
        <div @click="moveNoticeDetail(notice.no)" class="overflow-hidden list-group-item list-group-item-action" :key="notice.no" v-for="notice in notices">
          {{notice.title}}
        </div>
      </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  data() {
      return {
        notices: [],
      };
  },
  computed: {
    ...mapState("boardStore", ["postNo", "gugunCode"]),
  },
  methods: {
    ...mapMutations("boardStore", ["setGugunCode", "setPostNo"]),
    ...mapActions("boardStore", ["getNotices", "hit"]),
    async moveNoticeList(){
      await this.setGugunCode("99");
      this.$router.push({name : "notice"});
    },
    async moveNoticeDetail(no){
      await this.setGugunCode("99");
      await this.setPostNo(no);
      await this.hit(no);
      this.$router.push({name : "noticedetail"});
    },
  },
  async mounted() {
    await this.getNotices().then((data) => {
      this.notices = data;
    });
  },
};
</script>

<style>
</style>