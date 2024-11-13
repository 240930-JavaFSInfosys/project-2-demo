import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Login } from './Components/LoginRegister/Login';
import { Register } from './Components/LoginRegister/Register';
import 'bootstrap/dist/css/bootstrap.css'; //NEED THIS FOR BOOTSTRAP TO WORK
import { PetContainer } from './Components/Pet/PetContainer';
import { UserContainer } from './Components/User/UserContainer';

function App() {
  return (
    <div className="App">
        <BrowserRouter>
          <Routes>
            {/*blank path makes this component render at startup*/}
            <Route path="" element={<Login/>} /> 
            <Route path="/register" element={<Register/>}/>
            <Route path="/pets" element={<PetContainer/>}/>
            <Route path="/users" element={<UserContainer/>}/>
          </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
