<template>
    <div class="container">
        <post-banner />
        <b-container class="mt-3">
            <b-row class="mb-1">
                <b-col>
                    <b-card
                        :header-html="`<h3>${post.title}</h3>
            <h6 class='float-end'>${post.dateString}</h6>`"
                        class="mb-2"
                        border-variant="dark"
                        no-body
                    >
                        <b-card-body>
                            <div
                                v-html="
                                    `${post.userName}<div class='float-end'>조회수 ${post.hit}</div>`
                                "
                            ></div>
                            <hr />
                            <div v-html="message"></div>
                        </b-card-body>
                    </b-card>
                </b-col>
            </b-row>
            <b-row class="mb-1">
                <b-col class="text-left">
                    <b-button variant="outline-dark mx-1" size="sm" @click="moveList"
                        >목록</b-button
                    >
                </b-col>
                <b-col class="text-center">
                    <b-button variant="outline-danger" size="sm" @click="likeBtn">
                        <b-icon-heart color="red" v-if="!isLiked"></b-icon-heart>
                        <b-icon-heart-fill color="red" v-else></b-icon-heart-fill>
                        {{ likesCnt }}
                    </b-button>
                </b-col>
                <b-col class="text-right">
                    <template v-if="post.userNo == userinfo.no">
                        <b-button
                            variant="outline-danger float-end mx-1"
                            size="sm"
                            @click="clickDelete"
                            >글삭제</b-button
                        >
                        <b-button
                            variant="outline-primary float-end mx-1"
                            size="sm"
                            @click="moveModifyArticle"
                            >글수정</b-button
                        >
                    </template>
                </b-col>
            </b-row>
        </b-container>
        <reple-list></reple-list>
    </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import RepleList from "./RepleList.vue";
import PostBanner from "@/components/board/PostBanner.vue";

export default {
    components: {
        PostBanner,
        RepleList,
    },
    data() {
        return {
            isLiked: Boolean,
            likesCnt: Number,
        };
    },
    computed: {
        ...mapState("boardStore", ["post", "postNo"]),
        ...mapState("userStore", ["userinfo", "interestList"]),
        message() {
            if (this.post.content) return this.post.content.split("\n").join("<br>");
            return "";
        },
    },
    methods: {
        ...mapActions("boardStore", ["getPost", "deletePost", "likePost", "unlikePost"]),
        moveList() {
            this.$router.push({ name: "postlist" });
        },
        moveModifyArticle() {
            this.$router.push({ name: "postmodifyform" });
        },
        async clickDelete() {
            await this.deletePost(this.postNo);
            this.moveList();
        },
        likeBtn() {
            if (this.isLiked) {
                this.likesCnt -= 1;
                this.isLiked = false;
            } else {
                this.likesCnt += 1;
                this.isLiked = true;
            }
        },
        interestBtn() {
            console.log(this.postNo);
        },
        async init() {
            await this.getPost(this.postNo);
            this.likesCnt = this.post.likesCnt;
            this.isLiked = this.post.isLiked;
        },
    },
    async beforeDestroy() {
        console.log("destroy!!");
        if (this.isLiked && !this.post.isLiked) {
            await this.likePost(this.postNo);
        } else if (!this.isLiked && this.post.isLiked) {
            await this.unlikePost(this.postNo);
        }
        console.log("destroy end!!");
    },
    mounted() {
        this.init();
    },
};
</script>

<style scoped></style>
