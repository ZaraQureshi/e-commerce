import React,{useState} from 'react'
import './cart.css';
import { GrClose,GrTrash } from 'react-icons/gr';
import {BsTrash} from 'react-icons/bs';
const CartProduct=({i,onQuantityChange, onRemove})=> {
    
    const [count,setCount]=useState(1);
    const [quantity, setQuantity] = useState(1);
    const remove=(id)=>{
        fetch("http://localhost:8080/cart/remove/"+Number(id),{
            method:"GET"
        }).then((res)=>{
            return  res.json();
        }).then((data)=>{
           console.log(data);
        })
        // setCount(0);
        // handleQuantityChange();
        onRemove(id);
        // window.location.reload();
    }
    
    function makeUpperCase(string){
        return string.charAt(0).toUpperCase()+string.slice(1);
    }
    function handleQuantityChange() {
        const newQuantity = count*i.productPrice;
        console.log(newQuantity);
        setQuantity(newQuantity);
        onQuantityChange(newQuantity);
        console.log(onQuantityChange(newQuantity));
      }
    console.log(count*i.productPrice);
  return (
    // <div>
        <div className='cart-product-container'>
            <div className='cart-product-img'>
                <img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"/>
            </div>
            <div className="cart-product-desc">
                <h3>{makeUpperCase(i.productName)}</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod </p>
                <p>Rs. {i.productPrice}</p>
                <div className="quantity">
                    <button onClick={()=>{setCount(count+1); handleQuantityChange();}}>+</button>
                    <span>{count}</span>
                    {count<=1 ? <button onClick={()=>remove(i.productID)}>{<GrTrash/>}</button>:<button onClick={()=>setCount(count-1)}>-</button>}
                </div>
                
            </div>
            <div className="cart-product-remove">
            <button onClick={()=>remove(i.productID)}>{<GrClose/>}</button>
            </div>
        </div>

    // </div>
  )
}

export default CartProduct;
// export const TOTAL_PRICE;