<template>
  <div class="container" id="board">
    <h2 class="mx-3">공지사항</h2>
    <hr/>
    
    <b-button variant="outline-dark" :pressed.sync="allToggle" size="sm" @click="allPosts">전체글</b-button>
    <b-button variant="outline-dark" :pressed.sync="popularToggle" size="sm" @click="popularPosts">인기글</b-button>
    <hr/>

    <b-table-simple v-if="rows == 0" striped hover bordered>
      <b-thead>
        <b-tr>
          <b-th class="w70">제목</b-th>
          <b-th>작성일</b-th>
          <b-th>조회수</b-th>
          <b-th>좋아요</b-th>
        </b-tr>
      </b-thead>
      <b-tbody>
        <b-tr>
          <b-td colspan="4">등록된 글이 없습니다.</b-td>
        </b-tr>
      </b-tbody>
    </b-table-simple>
    <b-table v-else striped hover bordered
      id="my-table"
      :items="postList"
      :fields="fields"
      :per-page="perPage"
      :current-page="currentPage"
      @row-clicked="movePostDetail"
      label-sort-asc=""
      label-sort-desc=""
      label-sort-clear="">
    </b-table>

    <b-pagination
        v-model="currentPage"
        :total-rows= "rows"
        :per-page="perPage"
        aria-controls="my-table"
        align="center"
        size="sm"
        class="mt-4">
    </b-pagination>

    <b-button variant="outline-dark" :pressed.sync="allToggle" size="sm" @click="allPosts">전체글</b-button>
    <b-button variant="outline-dark" :pressed.sync="popularToggle" size="sm" @click="popularPosts">인기글</b-button>
    <b-button v-if="userinfo.admin" variant="outline-dark float-end" @click="moveWriteForm" size="sm">글쓰기</b-button>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const boardStore = "boardStore";

export default {
    data() {
        return {
            perPage: 10,
            currentPage: 1,
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
                key: 'postDate',
                label: '작성일',
              },
              {
                key: 'hit',
                label: '조회수',
                sortable: true,
                sortDirection: "desc",
              },
              {
                key: 'likesCnt',
                label: '좋아요',
                sortable: true,
                sortDirection: "desc",
              },
            ],
        };
    },
  computed: {
    ...mapState("boardStore", ["posts", "gugunCode"]),
    ...mapState("userStore", ["userinfo"]),
    rows(){
      if(!this.postList)
        return 0;
      return this.postList.length;
    }
  },
  methods: {
    ...mapMutations("boardStore",["setPostNo"]),
    ...mapActions(boardStore,["getPosts","hit"]),
    async movePostDetail(post){
      await this.hit(post.no);
      await this.setPostNo(post.no);
      this.$router.push({name : "noticedetail"});
    },
    moveWriteForm() {
      this.$router.push({name : "noticewriteform"});
    },
    allPosts(){
      this.allToggle = true;
      this.popularToggle = false;
      this.postList = this.posts;
    },
    popularPosts(){
      this.allToggle = false;
      this.popularToggle = true;
      this.postList = this.posts.filter(post => post.likesCnt >= 3);
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
  width: 60%;
}
</style>