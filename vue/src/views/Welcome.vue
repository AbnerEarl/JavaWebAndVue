
<template>
    <div>
    <h1>欢迎使用Vue前后端分离架构！</h1>
    <h1>{{ msg }}</h1>
    <router-link class="enter" to="/login">点击开始</router-link>
    </div>
</template>

<script>
export default {
    name:"Welcome",
    data(){
        return{
            msg:"准备调试接口吧！"
        }
    }
}
</script>

<style scoped>
.enter{
    font-size: 30px;
}
</style>