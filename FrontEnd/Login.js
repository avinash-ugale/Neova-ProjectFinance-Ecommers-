import { Component } from "react";

   class Login extends Component{
       render(){
           return(
               <>
               
    <form class="container col">
    <h1>Login here</h1>
        <div class="mb1">
            <label for="exampleInputEmail1" class="form-label">Email address :</label>
            <input type="email" size="20" required aria-describedby="emailHelp" />
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb1">
            <label for="exampleInputPassword1" class="form-label">Password :</label>
            <input type="password" size="20" required/>
        </div>
 
        <button type="submit" class="btn btn-primary">Submit</button>
</form>
               </>
           )
       }
   }
   export default Login;