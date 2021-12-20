import React, { Component } from "react";
 import { connect } from "react-redux";
 import { Link } from "react-router-dom";
class Regis extends Component{
state={
    name:"",
    dateofbirth:0,
    emailId:"",
    password:"",
    phoneNumber:0,
    userName:"",
    address:"",
}
onValueChangeHandler=(event)=>{
    const {name,value}=event.target;
    this.setState({[name]:value});
}
onFormSubmitHandler=(event)=>{
    event.preventDefault();
    console.log(this.state);
    this.props.addPerson(this.state);
}

    render(){
        return(
        <div>
       <h1>Registration</h1>
       <form onSubmit={this.onFormSubmitHandler} className="container col">

       <div class="col-md-4">
            <label for="exampleInputEmail1" class="form-label">Name :</label>
            <input type="text"  size="20" required aria-describedby="emailHelp" 
            name={"name"} value={this.state.value} onChange={this.onValueChangeHandler}/>
            
        </div>
        <div class="col-md-4">
            <label for="exampleInputDateOfBirth1" class="form-label">Date Of Birth :</label>
            <input type="date" size="20" required aria-describedby="emailHelp" 
             name={"dateofbirth"}value={this.state.value} onChange={this.onValueChangeHandler}/>
            
      </div>
      <div class="col-md-4">
            <label for="exampleInputEmail1" class="form-label">Email ID :</label>
            <input type="text"  size="20" required aria-describedby="emailHelp" 
            name={"emailId"} value={this.state.value} onChange={this.onValueChangeHandler}/>
            
        </div>
        <div class="col-md-4">
            <label for="exampleInputDateOfBirth1" class="form-label">Password:</label>
            <input type="Password" size="20" required aria-describedby="emailHelp" 
             name={"password"}value={this.state.value} onChange={this.onValueChangeHandler}/>
            
      </div>
      <div class="col-md-4">
            <label for="exampleInputDateOfBirth1" class="form-label">PhoneNumber :</label>
            <input type="number" size="20" required aria-describedby="emailHelp" 
             name={"phoneNumber"}value={this.state.value} onChange={this.onValueChangeHandler}/>
            
      </div>
      <div class="col-md-4">
            <label for="exampleInputEmail1" class="form-label">UserName :</label>
            <input type="text"  size="20" required aria-describedby="emailHelp" 
            name={"userName"} value={this.state.value} onChange={this.onValueChangeHandler}/>
            
        </div>
        <div class="col-md-4">
            <label for="exampleInputDateOfBirth1" class="form-label">Address:</label>
            <input type="text" size="20" required aria-describedby="emailHelp" 
             name={"address"}value={this.state.value} onChange={this.onValueChangeHandler}/>
            
      </div>

       {/* <input name={"age"} value={this.state.value} onChange={this.onValueChangeHandler} class="form-control"/>
       <br/> </div> */}
        <div class="col-md-8" >
        <button type="submit" class="btn btn-primary">Register</button> 
      </div>

        <div class="col-md-8" >
             <li > <p1>Already a member ?</p1>
          <Link class="nav-link active" aria-current="page" to={"/login"}> 
         Login here</Link>
        </li>
      </div>
      
       </form>
       </div>
          
        );
       

    };

};
const mapStateToProps=(state)=>{  //getting the value from state to props 
    return{
        
    };
   };
   const mapDispatchToProps=(dispatch)=>{
    return{
         addPerson:(payload)=>dispatch({type:"PERSON_ADD",payload:payload}),
    };
   };
   export default connect(mapStateToProps,mapDispatchToProps)(Regis);
