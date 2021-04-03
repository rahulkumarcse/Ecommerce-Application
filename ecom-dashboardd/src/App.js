import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './Login'
import AddProduct from './AddProduct'
import Register from './Register'
import UpdateProduct from './UpdateProduct'
import Protected from './Protected'

import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
        <Route path="/login" >
          <Login />
        </Route>

        <Route path="/add">
        <Protected Cmp={AddProduct}/>
        </Route>
        
        <Route path="/update">
        <Protected Cmp={UpdateProduct}/>
        </Route>
        
        <Route path ="/register">
        <Register/>
        </Route>
      
      </Router>


    </div>
  )
}

export default App;
