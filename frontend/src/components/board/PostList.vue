<template>
  <div class="container" id="board">
    <h2 class="">강남구 게시판</h2>
    <hr/>
    
    <b-button variant="outline-dark" :pressed.sync="allToggle" size="sm" @click="allPosts">전체글</b-button>
    <b-button variant="outline-dark" :pressed.sync="popularToggle" size="sm" @click="popularPosts">인기글</b-button>
    <hr/>

    <b-table striped hover bordered
      id="my-table"
      ref="table"
      :items="postList"
      :fields="fields"
      :per-page="perPage"
      :current-page="currentPage"
      @row-clicked="movePostDetail"
      label-sort-asc=""
      label-sort-desc=""
      label-sort-clear="">
    </b-table>

    <b-pagination small
        v-model="currentPage"
        :total-rows= "rows"
        :per-page="perPage"
        aria-controls="my-table"
        align="center"
        class="mt-4">
    </b-pagination>

    <b-button variant="outline-dark" :pressed.sync="allToggle" size="sm" @click="allPosts">전체글</b-button>
    <b-button variant="outline-dark" :pressed.sync="popularToggle" size="sm" @click="popularPosts">인기글</b-button>
    <b-button variant="outline-dark float-end" @click="moveWriteForm" size="sm">글쓰기</b-button>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const boardStore = "boardStore";

export default {
    data() {
        return {
            perPage: 10,
            currentPage: 1,
            gugunCode: "1111000000",
            postList: this.posts,
            allToggle: true,
            popularToggle: false,

            fields: [
              {
                key: 'title',
                label: '제목',
                tdClass: 'w70',
              },
              {
                key: 'userNo',
                label: '작성자',
                thClass: 'w10',
              },
              {
                key: 'postDate',
                label: '작성일',
                thClass: 'w10',
              },
              {
                key: 'hit',
                label: '조회수',
                sortable: true,
                sortDirection: "desc",
                thClass: 'w10',
              },
            ],
        };
    },
  computed: {
    ...mapState(boardStore, ["posts"]),
    rows(){
      if(!this.postList)
        return 0;
      return this.postList.length;
    }
  },
  methods: {
    ...mapActions(boardStore,["getPosts","hit"]),
    async movePostDetail(post){
      await this.hit(post.no);
      this.$router.push({
        name: "postdetail",
        params: { postNo: post.no },
      });
    },
    moveWriteForm() {
      this.$router.push({name : "postwriteform"});
    },
    allPosts(){
      this.allToggle = true;
      this.popularToggle = false;
      this.postList = this.posts;
      this.$refs.table.refresh();
    },
    popularPosts(){
      this.allToggle = false;
      this.popularToggle = true;
      this.postList = this.posts.filter(post => post.hit >= 5);
      this.$refs.table.refresh();
    },
  },
  async mounted() {
    await this.getPosts(this.gugunCode);
    this.allPosts();
  },
};
</script>

<style>
.w70 {
  width: 65%;
}
</style>