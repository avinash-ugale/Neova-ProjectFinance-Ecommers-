import React , {Component} from "react";
import { Link } from "react-router-dom";

export default class Navbar extends Component{
    render(){
        return(
<>


<div style={{backgroundColor:"green"}}>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Finance</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        {/* <li class="nav-item">
          <Link class="nav-link active" aria-current="page" to={"/posts"}>Post</Link>
        </li>
        <li class="nav-item">
          <Link class="nav-link" to={"/todos"}>ToDo</Link>
        </li > */}
        <li class="nav-item">
          <Link class="nav-link active" aria-current="page" to={"/home"}>Home</Link>
        </li>
        <li class="nav-item">
          <Link class="nav-link active" aria-current="page" to={"/login"}>Login</Link>
        </li>
        
        
        <li class="mb-3">
          <Link class="nav-link active" aria-current="page" to={"/regis"}>Register</Link>
        </li>
         
        <li class="mb-3">
          <Link class="nav-link active" aria-current="page" to={"/regiList"}>Register List</Link>
        </li>
       
        
      </ul>
    </div>
  </div>
</nav>
</div>


</>
        );
    }
}