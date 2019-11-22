import axios from "axios";
import {Notification} from "element-ui";
import router from"../router";
const baseUrl="http://localhost:8090/web/api";

axios.interceptors.response.use(function(response){
    return response;
},function(error){
    var message="服务器请求错误";
    switch(error.response.status){
        case 401:
            message:"授权错误",
            router.push({path:"/login"});
            break;
    }
    Notification({
        title:"出错了",
        type:"error",
        message:message
    });
    return Promise.reject(error);
});

//用户登录接口
export const loginUserUrl=params=>{
    var url=baseUrl+"/user/id/0"  ;
    return axios.get(url,params);
}