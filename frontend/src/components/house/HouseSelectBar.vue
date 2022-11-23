<template>
    <b-card class="my-2 mx-2">
        <b-row>
            <b-col>지역 선택</b-col>
            <b-col>
                <b-form-select
                    v-model="sidoCode"
                    :options="sidos"
                    @change="gugunList"
                ></b-form-select>
            </b-col>
            <b-col>
                <b-form-select
                    v-model="tgugunCode"
                    :options="guguns"
                    @change="searchApt"
                ></b-form-select>
            </b-col>
        </b-row>
    </b-card>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
const houseStore = "houseStore";

export default {
    name: "HouseSelectBar",
    data() {
        return {
            sidoCode: null,
            tgugunCode: null,
        };
    },
    computed: {
        ...mapState(houseStore, ["sidos", "guguns", "houses"]),
    },
    created() {
        this.getSido();
    },
    destroyed() {
        //alert("셀렉트 바 파괘");
        this.CLEAR_SIDO_LIST();
        this.CLEAR_APT_LIST();
    },
    methods: {
        ...mapActions(houseStore, ["getSido", "getGugun", "getHouseList"]),
        ...mapMutations(houseStore, [
            "CLEAR_SIDO_LIST",
            "CLEAR_GUGUN_LIST",
            "CLEAR_APT_LIST",
            "SET_GUGUN_CODE",
        ]),

        gugunList() {
            this.CLEAR_GUGUN_LIST();
            this.tgugunCode = null;
            if (this.sidoCode) this.getGugun(this.sidoCode);
        },
        searchApt() {
            if (this.tgugunCode) {
                this.SET_GUGUN_CODE(this.tgugunCode);
                this.getHouseList(this.tgugunCode);
            }
        },
    },
};
</script>

<style></style>
