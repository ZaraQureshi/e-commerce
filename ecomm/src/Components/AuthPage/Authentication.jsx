import React,{useState} from 'react'
import "./auth.css";
import Login from './Login';
import Register from './Register';




const Authentication=()=>{

  const [form, setForm] = useState("");
  // const [active, isActive]=useState(false);
  const handleClick=(e)=>{
    setForm(e.target.value);
    // isActive(current=>!current);
  }
  return (
    <div className="auth-container">
        <div className="form-container">
          <div className="btn-container">
            <button className="signin" value="signin" onClick={handleClick}>
              SignIn
            </button>
            <button className="signup" value="signup" onClick={handleClick}>
              SignUp
            </button>
            
          </div> 
          <div className="line"></div>
          {(form=="signin")?<Login/>:<Register/>}
            
        </div>
    </div>
  )
}

export default Authentication