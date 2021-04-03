import Header from './Header'
import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom'

function Login() {
    const history = useHistory();
    const[email,setEmail]=useState("");
    const[password,setPassword]=useState("");

    useEffect(() => {
        if (localStorage.getItem('user-info')) {
            history.push("/add")
        }
    }
    )
    async function loginhoga(){
        console.warn("data", email,password)
        let user={email,password}
        let result=await fetch("http://localhost:8080/user/login",{
            method:'POST',
            headers:{
                "Content-Type":"application/json",
                "Accept":"application/json"
            },
            body:JSON.stringify(user)
        });
        result=await result.json();
        localStorage.setItem('user-info',JSON.stringify(result));
        history.push("/add")
    }
    return (
        <>
            <Header />

        <div className="col-sm-3 offset-sm-4">
            <h1>Login Page</h1>
            <br />

            <input type="text" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} className="form-control" />
            <br />
            <input type="text" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} className="form-control" />
            <br />
            <button className="btn btn-primary" onClick={loginhoga}>Login</button>
        </div>
        </>
    )
}
export default Login;