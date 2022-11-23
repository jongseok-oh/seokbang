<template>
    <b-card class="h-100">
        <b-row>
            <b-col cols="8">
                <b-input placeholder="원하시는 지역명, 아파트명을 입력해주세요" @keyup.enter="search" v-model="keyword"></b-input>
            </b-col>
            <b-col>
                <b-button @click="search" >검색하기</b-button>
            </b-col>
        </b-row>
    </b-card>
</template>

<script>
import {mapActions, mapMutations } from "vuex";

export default {
    name: 'FrontendHouseSearch',

    data() {
        return {
            keyword:"",
        };
    },
    mounted() {
        
    },
    methods: {
        ...mapActions('houseStore', ['getHouseDealListByKeyword']),
        ...mapMutations('houseStore', ['SET_LIST_STATE']),
        search() {
            this.getHouseDealListByKeyword(this.keyword);
            this.SET_LIST_STATE('search');
        }
    },
};
</script>

<style lang="scss" scoped>

</style>