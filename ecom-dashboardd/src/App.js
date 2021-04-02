import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './Login'
import AddProduct from './AddProduct'
import Register from './Register'
import UpdateProduct from './UpdateProduct'

import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import Header from './Header'

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <h1>E-com Project</h1>
        <Route path="/login" >
          <Login />
        </Route>

        <Route path="/add">
          <AddProduct />
        </Route>
        
        <Route path="/update">
          <UpdateProduct />
        </Route>
        
        <Route path ="/register">
        <Register/>
        </Route>
      
      </Router>


    </div>
  )
}

export default App;
