import logo from './logo.svg';
import './App.css';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import Login from './Components/AuthPage/Login';
import Home from './Components/Home';
import Cart from './Cart/Cart';
import Register from './Components/AuthPage/Register';
import Profile from './Components/Profile';
import Authentication from './Components/AuthPage/Authentication';

// test1
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/:category" element={<Home/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/cart" element={<Cart/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/profile" element={<Profile/>}/>
          <Route path="/authenticate" element={<Authentication/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
