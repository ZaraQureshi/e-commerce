import React from "react";
import { Navigate } from 'react-router-dom';
import { useSelector } from "react-redux";
import { useCallback } from "react";
import { useDispatch } from "react-redux";
import { logout } from "../actions/auth";

const Profile = () => {
  const { user: currentUser } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  if (!currentUser) {
    return <Navigate to="/login" />;
  }

  
  const logOut = () => {
    dispatch(logout());
  };
  console.log(currentUser)
  return (
    
    <div className="container">
        <button onClick={logOut}>Logout</button>
      <header className="jumbotron">
        <h3>
          <strong>{currentUser.username}</strong> Profile
        </h3>
      </header>
      <p>
        <strong>Token:</strong> {currentUser.accessToken.substring(0, 20)} ...{" "}
        {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
      </p>
      <p>
        <strong>Id:</strong> {currentUser.id}
      </p>
      <p>
        <strong>Email:</strong> {currentUser.email}
      </p>
      <strong>Authorities:</strong>
      <p>{currentUser.roles}</p>
      <ul>
        {currentUser.roles &&
          currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
      </ul>
    </div>
  );
};

export default Profile;