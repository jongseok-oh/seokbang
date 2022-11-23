<template>
    <b-card class="my-1 mx-1">
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
        search() {
            alert(this.keyword);
        }
    },
};
</script>

<style lang="scss" scoped>

</style>