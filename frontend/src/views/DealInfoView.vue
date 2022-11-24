<template>
    <div id="dealinfoview">
        <b-row>
            <b-col>
                <b-card class="my-4 mx-4">
                    <b-row>
                        <b-col>
                            <select-bar />
                        </b-col>
                        <b-col>
                            <house-search-bar />
                        </b-col>
                    </b-row>
                </b-card>
            </b-col>
            <b-col cols="4"></b-col>
        </b-row>
        <b-row>
            <b-col cols="8">
                <my-map />
            </b-col>
            <b-col>
                <house-deal-list />
            </b-col>
        </b-row>
    </div>
</template>

<script>
import MyMap from "@/components/house/MyMap.vue";
import SelectBar from "@/components/house/HouseSelectBar.vue";
import HouseDealList from "@/components/house/HouseDealList.vue";
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";

export default {
    components: {
        MyMap,
        SelectBar,
        HouseDealList,
        HouseSearchBar,
    },
};
</script>
