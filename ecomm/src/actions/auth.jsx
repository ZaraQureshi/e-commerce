import authService from "../services/auth.service";
import { LOGIN_FAIL, LOGIN_SUCCESS, REGISTER_SUCCESS, SET_MESSAGE, REGISTER_FAIL, LOGOUT } from "./types";

export const register=(username,email,password)=>(dispatch)=>{
    authService.register(username,email,password).then(
        (response)=>{
            dispatch({
                type:REGISTER_SUCCESS
            });
            dispatch({
                type:SET_MESSAGE,
                payload:response.data.message
            });
            return Promise.resolve();
        },
        (error)=>{
            const message=
            (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
            
            dispatch({
                type:REGISTER_FAIL
            });
            dispatch({
                type:SET_MESSAGE,
                payload:message
            });
            return Promise.reject();
      
        }
    );

}

export const login=(username,password)=>(dispatch)=>{
    authService.login(username,password).then(
        (data)=>{
            dispatch({
                type:LOGIN_SUCCESS,
                payload:{
                    user:data
                }
            });
            
            return Promise.resolve();
        },
        (error) => {
            const message =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();

            dispatch({
                type:LOGIN_FAIL
            });
            dispatch({
                type:SET_MESSAGE,
                payload:message
            })
            return Promise.reject();
        }
    );
}

export const logout = () => (dispatch) => {
    authService.logout();
  
    dispatch({
      type: LOGOUT,
    });
  };