import authHeader from "./auth-header";

const API_URL="http://localhost:8080/api/test/";

const getPublicAccess=()=>{
    fetch(API_URL+"all",{
        method:"GET"
    })
}

const getUserAccess=()=>{
    fetch(API_URL+"user",{
        method:"GET",
        headers:authHeader()
        
    })
}

const getAdminAccess=()=>{
    fetch(API_URL+"admin",{
        method:"GET",
        headers:authHeader()
        
    })
}

export default{
    getPublicAccess,getAdminAccess,getUserAccess
}