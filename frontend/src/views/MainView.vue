<template>
    <div>
        <b-row class="bg-img">
            <b-container class="pt70">
                <b-row>
                    <h1 class="mb-3">Where Is My Home</h1>
                </b-row>
                <b-row>
                    <b-col md="4" offset-md="4">
                        <house-search-bar :mainSearch="true"></house-search-bar>
                    </b-col>
                </b-row>
            </b-container>
        </b-row>
        <b-row class="p-5" cols="11">
            <b-col class="p-5" md="3" offset-md="1">
                <h2 class="fw-bolder mb-0">엥? 이게 집이라고?</h2>
                <img
                    class="img-fluid rounded-3 my-5"
                    src="https://youimg1.tripcdn.com/target/100v1f000001h1crh2F42_C_750_420.jpg_.webp?proc=source%2Ftrip"
                    alt=""
                />
            </b-col>
            <b-col class="p-5" md="3">
                <h2 class="h5">지혜롭게 내집 마련하기</h2>
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action"
                        >가용자금 확인 및 대출 계획</a
                    >
                    <a href="#" class="list-group-item list-group-item-action"
                        >집 종류 및 지역 선택</a
                    >
                    <a href="#" class="list-group-item list-group-item-action"
                        >정보 수집 & 시세파악</a
                    >
                    <a href="#" class="list-group-item list-group-item-action"
                        >부동산 방문 & 집구경</a
                    >
                    <a href="#" class="list-group-item list-group-item-action"
                        >계약 및 잔금 치르기</a
                    >
                    <a href="#" class="list-group-item list-group-item-action">소유권 이전등기</a>
                    <a href="#" class="list-group-item list-group-item-action">인테리어 공사</a>
                </div>
            </b-col>
            <b-col class="p-5" md="3">
                <notice-card></notice-card>
            </b-col>
        </b-row>
    </div>
</template>

<style>
@import url("https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap");

.bg-img {
    height: 80vh;
    background-image: url("../assets/RaffinaJ_contents_1__01.webp");
    background-size: cover;
}

.pt70 {
    padding-top: 56vh;
}

h1 {
    font-family: "Hi Melody", cursive;
    color: white;
}
</style>

<script>
import store from "@/store";
import { mapActions, mapMutations } from "vuex";
import NoticeCard from '@/components/notice/NoticeCard.vue';
import HouseSearchBar from '@/components/house/HouseSearchBar.vue';

export default {
  components: { HouseSearchBar, NoticeCard },
    data() {
        return {
            keyword: "",
        };
    },
    created() {
        store.commit("SET_NAV_FOOTER", true);
    },
    mounted() {},
    methods: {},
};
</script>
