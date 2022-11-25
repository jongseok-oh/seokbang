<template>
  <div id="replelist" class="px-2">
    <hr/>
    <h5>댓글 ({{reples.length}})</h5>
    <b-row>
      <b-col>
        <table class="table">
            <tbody>
              <tr v-if="reples.length == 0">
                  <td colspan="4">등록된 댓글 정보가 없습니다.</td>
              </tr>
              <template v-else>
                <tr :key="reple.no" v-for="reple in reples">
                  <td class="w70">{{ reple.content }}</td>
                  <td>{{ reple.userName }}</td>
                  <td>{{ reple.dateString }}</td>
                  <td>
                    <b-button v-if="reple.userNo == userinfo.no" variant="outline-danger mx-1" inline @click="deleteRepleBtn(reple.no)" size="sm">삭제</b-button>
                  </td>
                </tr>
              </template>
            </tbody>
        </table>
      </b-col>
    </b-row>
    <b-row>
      <b-col sm="11">
        <b-form-input v-model="repleContent" placeholder="댓글 작성"></b-form-input>
      </b-col>
      <b-col sm="1">
        <b-button variant="outline-dark" inline @click="writeReple" size="sm">댓글쓰기</b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
    data() {
        return {
          reples: [],
          repleContent: "",
        };
    },
  computed: {
    ...mapState("boardStore", ["postNo"]),
    ...mapState("userStore", ["userinfo"]),
  },
  methods: {
    ...mapActions("boardStore", ["getReples", "registReple", "deleteReple"]),
    async writeReple(){
      await this.registReple({
        postNo : this.postNo,
        userNo : this.userinfo.no,
        content : this.repleContent,
        repleDate : new Date()
      })
      this.repleContent = "";
      this.init();
    },
    init(){
      this.getReples(this.postNo).then((data) => {this.reples = data;});
    },
    async deleteRepleBtn(no){
      await this.deleteReple(no);
      this.init();
    },
  },
  created() {
    this.init();
  }, 
};
</script>

<style>
</style>