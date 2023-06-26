import React from 'react';
import { useNavigate } from "react-router-dom";
import './product.css';
function Product({product}) {
    // console.log(data.category)
    let navigate = useNavigate(); 

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
        navigate('/cart');
    }

    function makeUpperCase(string){
        return string.charAt(0).toUpperCase()+string.slice(1);
    }

  return(
  <div className="product-container">
    {product.map((i,key)=>{ 
        return <div className="product-item"key={i.productID}>
         <div className='product-img'>
          <img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"/>
         </div>
         <p className="product-name">{makeUpperCase(i.productName)}</p> 
          <p>{makeUpperCase(i.productBrand)}</p> 
          {/* <p>{i.productPrice}</p>  */}
          {/* <p>{i.category.categoryID}</p> */}
          {/* <button onClick={()=>addToCart(i.productID,1,i.productPrice)}>Add to Cart</button> */}
          <div className="product-footer">
          <p>Rs. {i.productPrice}</p> 
          <button onClick={()=>addToCart(i.productID,1,i.productPrice)}>Add to Cart</button>
          </div>
        </div> 
      })}
  </div>
)
}

export default Product;