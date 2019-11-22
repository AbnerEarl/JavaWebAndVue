<template>
  <baidu-map class="map" :center="{lng: 116.404, lat: 39.915}" :zoom="15" >
    <bm-marker :position="{lng: 116.404, lat: 39.915}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="坐标位置" :labelStyle="{color: 'red', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
  </baidu-map>
</template>

<script>
export default {
    name:"Map",
    data(){
        return{
            msg:"我的地图！"
        }
    }
}
</script>

<style scoped>
    .map{
      width: 80%;
      height: 500px;
      margin-left: 10%;
      margin-bottom: 100px;

    }

</style>