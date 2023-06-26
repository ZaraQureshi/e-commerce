import React,{useRef,useState} from 'react'
import { Link } from 'react-router-dom'
import Cart from '../../Cart/Cart'
import Profile from '../Profile';
import "./header.css";
import SearchBar from './SearchBar';
import Category, {CATEGORY_CLASS_NAME}from '../../Category/Category';
import {GiHamburgerMenu} from 'react-icons/gi';
import { BsCartFill } from 'react-icons/bs';
import {FaUserAlt} from 'react-icons/fa';
const Header=()=> {
//  const element = useRef(null);
const [show, setShow] = useState(false);
console.log(show)
 console.log(CATEGORY_CLASS_NAME)
  function handleClick(){
    // element.current.classList.toggle('active');
    // console.log(document.getElementsByClassName(CATEGORY_CLASS_NAME)[0].classList.add('active'));
  //   var container = document.getElementsByClassName(CATEGORY_CLASS_NAME)[0];
  // console.log(container);
  // container.classList.toggle('active');
  }
  // console.log(element)
  return (
    <>
    <div className="header-container" >
        <div className="logo">
          <label>Name</label>
        </div>
        <div className="search">
          <SearchBar/>
        </div>
        <div className="nav">
          <Link to="/profile">
            <FaUserAlt/>
            {/* <label>User</label> */}
          </Link>
          <Link to="/cart">
            <BsCartFill/>
            {/* <label>Cart</label> */}
          </Link>
        </div>
        <div className="burger" onClick={() => setShow(!show)}>
        <GiHamburgerMenu/>
        </div>
        {/* <div className="header-content">
        <Link to="/cart">
            <label>Cart</label>
          </Link>
        </div> */}
    </div>
    <Category props={show}/>

    </>
  )
}

export default Header