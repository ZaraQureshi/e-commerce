import React,{useState,useEffect} from 'react'
import Header from '../Components/Header/Header';
import CartProduct from './CartProduct';
// Header
function Cart() {
    const [product, setProduct] = useState([])
    const [quantity, setQuantity] = useState(0);
    useEffect(() => {
      viewCartProduct();
    }, []);

    
    

  function handleQuantityChange(newQuantity) {
    setQuantity(newQuantity);
    // console.log(newQuantity);

  }
console.log(quantity)
    const viewCartProduct=()=>{
        fetch("http://localhost:8080/cart/get/1",{
            method:"GET"
        }).then((res)=>{
            return  res.json();
        }).then((data)=>{
            setProduct(data);
            console.log(data);
        })
    }

    

    const placeOrder=()=>{
        fetch("http://localhost:8080/order/add/3",{
            method:"POST"
        }).then((res)=>{
            return res.json();
        }).then((data)=>{
            console.log(data);
        })
        window.location.reload();
    }
    const handleRemoveProduct=(productId)=>{
        const updatedProducts=product.filter((p)=>p.productID!==productId);
        console.log(updatedProducts)
        setProduct(updatedProducts);
    }
    console.log("update"+product)
  return (
    <>
    <Header/>
    <div className="cart-container">
        <div className="cart-product-main">
            {product.map((i,key)=>{
                    return(
                        <CartProduct i={i} onQuantityChange={handleQuantityChange} onRemove={handleRemoveProduct}/>
                    )
            })}
            <div className="cart-subtotal">
                Subtotal: 
            </div>
        </div>
        
        <div className="order-container">
            <h3>Total</h3>
            <div className="order-container-desc">
                <table>
                    <tr>
                        <td> Subtotal</td>
                        <td>hsgdhs</td>
                    </tr>
                    <tr>
                        <td>Delivery Charges</td>
                        <td>Griffin</td>
                    </tr>
                </table>
            </div>
           {product.length == 0   ? " ":<button onClick={()=>placeOrder()}>Place order</button>}
        </div>
    </div>

   </>
  )
}

export default Cart