<template>
  <div id="map" style="width: 100%; height: 90vh;"></div>
</template>

<script>
export default {
  data() {
    return {
      map: '',
    }
  },
  
  methods: {
    initMap() {
      const mapContainer = document.getElementById('map');
      const mapOption = {
        center: new kakao.maps.LatLng(37.56666, 126.97800),
        level: 3,
      };
      this.map = new kakao.maps.Map(mapContainer, mapOption);
    },
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=45b9e1bf120dbf1e4d5c03664a3e045a";
      document.head.appendChild(script);
    }
    console.log(this.prevRoute)
    console.log(this.prevRoute.name);
  },
};
</script>
