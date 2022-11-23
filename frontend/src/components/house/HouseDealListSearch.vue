<template>
    <div>
        <h3 class="mb-3">{{searchkey}} 검색 결과 거래 내역</h3>
        <div class="mb-3" style="overflow-y: auto; height: 80vh; white-space: nowrap">
            <house-deal-list-item-search v-for="(deal, index) in deals" :key="index" :deal="deal" />
        </div>
    </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import HouseDealListItemSearch from "@/components/house/HouseDealListItemSearch.vue";

const houseStore = "houseStore";
export default {
    name: "FrontendHouseDealListSearch",
    components: {
        HouseDealListItemSearch,
    },
    data() {
        return {};
    },
    computed: {
        ...mapState(houseStore, ["searchkey", "deals"]),
    },
    mounted() {},
    methods: {
        ...mapMutations(houseStore, ["CLEAR_DEAL_HOUSE_LIST"]),
    },
    destroyed() {
        //alert("이잏 파괘");
        this.CLEAR_DEAL_HOUSE_LIST();
    },
};
</script>

<style lang="scss" scoped></style>
