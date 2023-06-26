import React from 'react'
import axios from "axios";
const API_URL = "http://localhost:8080/api/auth/";

const login=(username,password)=>{
    return axios.post(API_URL+"signin",{
      
            username:username,
            password:password,
           
        }).then((res)=>{
            console.log(res);
            if (res.data.accessToken) {
                localStorage.setItem("user", JSON.stringify(res.data));
              }
        
              return res.data;
        })
}

const register=(username,email,password)=>{
    return axios.post(API_URL+"signup",{
            username:username,
            password:password,
            email:email
            
        }).then((res)=>{
            console.log(res);
        })  
}

const logout = () => {
    localStorage.removeItem("user");
  };

export default {
    login,register,logout
}