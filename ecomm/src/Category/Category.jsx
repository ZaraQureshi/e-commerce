import React,{useState, forwardRef } from 'react'
import { useEffect } from 'react';
import { Link } from 'react-router-dom';
import "./category.css";
import '../Components/Header/header.css';
import { useNavigate} from "react-router-dom";
const Category=(props)=> {


  const [category,setCategory]=useState([]);
  const [menuToggle,setMenuToggle]=useState(true);
  const navigate = useNavigate();

  let path="";
  useEffect(()=>{
    viewCategory();
  },[])

  async function viewCategory(){
    await fetch("http://localhost:8080/category",{
      method:"GET"
    }).then((res)=>{
      return res.json();
    }).then((data)=>{
      setCategory(data);
      console.log(data);
    })
  }
  function collapseMenu(){
    // setMenuToggle(false);
    // console.log("menuToggle"+menuToggle)
    // navigate(`/`+path);
    // setTimeout(() => {
    //   setMenuToggle(true);
    //   console.log("menuToggle", menuToggle);
    // }, 500);
    props.props=false;
  }
  console.log("menu"+menuToggle)
  // async function viewProducts(){
  //   await fetch("http://localhost:8080/product",{
  //      method:"GET"
  //    }).then((res)=>res.json())
  //    .then((data)=>{
      
  //     //  setProduct(data);
  //      console.log(data)
       
  //    }).catch((err) => {
  //      console.log("List ERROR ", err);
  //    });
  //   }
    //  async function getByCategory(id){
    //   await fetch("http://localhost:8080/product/category/"+Number(id),{
    //     method:"GET"
    //   }).then((res)=>{
    //     return res.json();
    //   }).then((data)=>{
    //     // setProduct(data);
    //     console.log(data);
    //   })
    // }
    console.log(props.props);
  return (
    <div>
        <div className={
            props.props ? "category-container active-category"  : "category-container" 
          }>
        {/* <h3>Category</h3> */}
        {/* <div style={{display:`flex`,justifyContent:`space-around`}} > */}
          <div>
          <Link className="cat-a"to={`/`} onClick={collapseMenu}>All</Link>
          </div>
          {category.map((i,key)=>{
            path=i.categoryName
            return <div>
              
              <Link to={`/${i.categoryName}`} onClick={collapseMenu}>{i.categoryName}</Link>
              {/* <button onClick={()=>getByCategory(i.categoryID,1)} >{i.categoryName}</button> */}
            </div>
          })}
        {/* </div> */}
      </div>
    </div>
  )
}

export default Category;
export const CATEGORY_CLASS_NAME = 'category-container';