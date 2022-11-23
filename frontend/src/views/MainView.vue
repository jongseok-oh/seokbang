<template>
    <div>
        <header class="masthead">
            <div class="container position-relative">
                <div class="row justify-content-center">
                    <div class="col-xl-6">
                        <div class="text-center text-white">
                            <h1 class="mb-3" id = "subject">Where is My Home</h1>
                            <div class="row">
                                <b-row>
                                    <b-col cols="10">
                                        <b-input placeholder="원하시는 지역명, 아파트명을 입력해주세요" @keyup.enter="search" v-model="keyword"></b-input>
                                    </b-col>
                                    <b-col>
                                        <b-button @click="search">검색하기</b-button>
                                    </b-col>
                                </b-row>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <section class="py-5" id="features">
            <div class="container px-5 my-5">
            <div class="row gx-5">
                <div class="col-lg-4 mb-5 mb-lg-0">
                <h2 class="fw-bolder mb-0">엥? 이게 집이라고?</h2>
                <img
                    class="img-fluid rounded-3 my-5"
                    src="https://youimg1.tripcdn.com/target/100v1f000001h1crh2F42_C_750_420.jpg_.webp?proc=source%2Ftrip"
                    alt=""
                />
                </div>
                <div class="col-lg-8">
                    <div class="row gx-5 row-cols-md-2">
                        <div class="col mb-5 h-100">
                        <h2 class="h5">지혜롭게 내집 마련하기</h2>
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action">가용자금 확인 및 대출 계획</a>
                            <a href="#" class="list-group-item list-group-item-action">집 종류 및 지역 선택</a>
                            <a href="#" class="list-group-item list-group-item-action">정보 수집 & 시세파악</a>
                            <a href="#" class="list-group-item list-group-item-action">부동산 방문 & 집구경</a>
                            <a href="#" class="list-group-item list-group-item-action">계약 및 잔금 치르기</a>
                            <a href="#" class="list-group-item list-group-item-action">소유권 이전등기</a>
                            <a href="#" class="list-group-item list-group-item-action">인테리어 공사</a>
                        </div>
                        
                        </div>
                        <div class="col mb-5 h-100">
                            <h2 class="h5">부동산 뉴스</h2>
                            <div class="list-group">
                                <a href="#" class="list-group-item list-group-item-action list-group-item-light">서울 입주 2년차 아파트 전셋값 1억400만원 올라</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-light">12:16 거래한파...매수자가 사라졌다</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-light">재건축 대안 또는 수직증축 리모델링... 추진 속...</a>
                                <a href="#" class="list-group-item list-group-item-action list-group-item-light">고가기준 9억, 서울 아파트 중간값 됐다</a>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
      </section>
    </div>
</template>

<style>
    .masthead{
        height: 80vh;
        background-image: url("../assets/RaffinaJ_contents_1__01.webp");
        background-size: cover;
    }
    #subject{
        margin-top: 80%;
    }
</style>

<script>
import store from "@/store";
import {mapActions, mapMutations } from "vuex";

export default {
    data() {
        return {
            keyword:"",
        };
    },
    created() {
        store.commit('SET_NAV_FOOTER', true);
    },
    mounted() {
    },
    methods: {
        ...mapActions('houseStore', ['getHouseDealListByKeyword']),
        ...mapMutations('houseStore', ['SET_LIST_STATE']),
        async search() {
            if(!await this.getHouseDealListByKeyword(this.keyword).then(() => {
                console.log("then");
                return false;
            })) return;
            this.SET_LIST_STATE('search');
            this.$router.push('/dealinfo');
        }
    },
};
</script>