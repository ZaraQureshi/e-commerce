import React,{useEffect,useState} from 'react'
import { Link } from 'react-router-dom';
import Category from '../Category/Category';
import Header from './Header/Header';
import { useParams } from 'react-router-dom';
import axios from "axios";
import Product from '../Product/Product';
const Home=() =>{

 let total1=0;
 
  const [product, setProduct] = useState([]);
  // const [category,setCategory]=useState([]);
  const [total, setTotal] = useState(0);
  const [loading,setLoading]=useState(false);
    
  const {category} = useParams(); 
  useEffect(()=>{
    // setLoading(true);
    // viewProducts();
    getByCategory();
    // viewCategory();
    // setLoading(false);
  },[category])

  async function viewProducts(){
   await fetch("http://localhost:8080/product",{
      method:"GET"
    }).then((res)=>res.json())
    .then((data)=>{
     
      // setProduct(data);
      console.log(data)
      
    }).catch((err) => {
      console.log("List ERROR ", err);
    });
  }

  // async function viewCategory(){
  //   await fetch("http://localhost:8080/category",{
  //     method:"GET"
  //   }).then((res)=>{
  //     return res.json();
  //   }).then((data)=>{
  //     setCategory(data);
  //     console.log(data);
  //   })
  // }

  async function getByCategory(){
    const data=await axios.get("http://localhost:8080/product");
    console.log(data.data)
    if(category){
      const categoryProduct=data.data.filter(item=>item.category.categoryName===category)
      setProduct(categoryProduct);
    }else{
      setProduct(data.data);
    }
    // await fetch("http://localhost:8080/product/category/"+Number(),{
    //   method:"GET"
    // }).then((res)=>{
    //   return res.json();
    // }).then((data)=>{
      
    //   console.log(data);
    // })
  }
  
  // function cart(pid,cid){
  //   setTotal(total+price);
  //   fetch("http://localhost:8080/cart/add/"+Number(cid)+"/"+Number(pid)+"/"+Number(total),{
  //     method:"POST",
  //     headers:{
  //       "Content-Type": "application/json",
  //     }
      // body: JSON.stringify({
      //     // cid:1,
      //     totalPrice:Number(total)
      //     // id:Number(cid)
      // })
      
  //   })
  // }
  async function addToCart(pid,cid,price){
    
    
    await fetch("http://localhost:8080/cart/add/"+Number(cid)+"/"+Number(pid)+"/"+Number(price),{
      method:"POST",
      headers:{
        "Content-Type": "application/json",
      }
      // body: JSON.stringify({
      //     // cid:1,
      //     totalPrice:Number(total)
      //     // id:Number(cid)
      // })
      
    })
    
  }

  function calcTotalprice(price){
    // var total=0;
    // console.log(total)
   
    // console.log(typeof(parseFloat(Math.round(total * 100) / 100).toFixed(2)));
    // return total
    console.log(total);
  }
  console.log(product);
  return (
    <div>
       
  <Header/>
    {/* <Category/> */}
    
      {/* {data.productName} */}
      {/* {product.productID} */}
      <div className="home">
      <Product product={product}/>
      </div>
    </div>
  )
}

export default Home;