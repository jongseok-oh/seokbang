<template>
    <div>
        <h3 class="mb-3">{{ aptName }} 거래 내역</h3>
        <div class="mb-3" style="overflow-y: auto; height: 80vh; white-space: nowrap">
            <house-deal-list-item-gugun v-for="(deal, index) in deals" :key="index" :deal="deal" />
        </div>
    </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import HouseDealListItemGugun from "@/components/house/HouseDealListItemGugun.vue";

const houseStore = "houseStore";
export default {
    name: "FrontendHouseDealListGugun",
    components: {
        HouseDealListItemGugun,
    },
    data() {
        return {};
    },
    computed: {
        ...mapState(houseStore, ["aptName", "deals"]),
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
