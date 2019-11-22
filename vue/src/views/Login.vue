<template>
  <div>
    <h1>用户登录</h1>
    <br>
    帐号：<input type="text" v-model="username">
    <br>
    密码：<input type="password" v-model="password">
    <br>
    <button @click="verfify">登录</button>
  </div>
</template>

<script>
import {loginUserUrl} from "../api/api";
import axios from "axios";
import {Notification} from "element-ui";

export default {
  name:"Login",
    data(){
        return{
            msg:"用户登录！",
            username:'',
            password:''
        }
    },
    methods:{
      verfify(){
        console.log("开始执行登录！帐号："+this.username+" 密码："+this.password);
        let param={
          id:this.username,
        }
        loginUserUrl(param).then(res=>{
          console.log("服务器返回数据："+res.data.username);
          if(res.data!=null&&res.data.username!=null){
            this.$router.push({path:'/map'});

          }else{
            Notification({
         title:"出错了",
         type:"error",
         message:"帐号或密码错误！"
        });

         }
        });
      }

    }
}
</script>