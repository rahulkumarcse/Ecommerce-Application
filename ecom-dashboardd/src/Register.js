import { FormControl } from "react-bootstrap";
import React, { useState,useEffect } from 'react';
import { useHistory } from 'react-router-dom'
import Header from './Header'

function Register() {

    useEffect(()=>{
        if(localStorage.getItem('user-info'))
        {
            history.push("/add")
        }
    }
    )
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const history = useHistory();
    async function signUp() {
        let new_user = { name, email, password }
        let result = await fetch("http://localhost:8080/user/registration", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(new_user)
        });
        result = await result.json();
        console.warn("result", result)
        localStorage.setItem("user-info", JSON.stringify(result));
        history.push("/add")

    }
    function Sigupvalidator(e) {
        let temp_email = { email };

    }
    return (
        <>
            <Header />


            <div className="col-sm-6 offset-sm-3">

                <h1>User Sign Up</h1>
                <br />
                <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} className="form-control" />
                <br />
                <input type="text" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} className="form-control" />
                <br />
                <input type="text" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} className="form-control" />
                <br />
                <button className="btn btn-primary" onClick={signUp}>Sign UP</button>
            </div>
        </>
    );
}
export default Register;