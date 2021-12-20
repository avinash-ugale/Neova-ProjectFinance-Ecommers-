import React, { Component } from "react";
import { Link } from "react-router-dom";

  export default class Register extends Component{
      render(){
          return(
              <>
              <div style={{backgroundColor:"aqua"}}> 
             
                  <h1>Register Here</h1>
                 
              <form className="container col">
        <div class="col-md-4">
            <label for="exampleInputEmail1" class="form-label">Name :</label>
            <input type="text"  size="20" required aria-describedby="emailHelp" />
            
        </div>
        <div class="col-md-4">
            <label for="exampleInputDateOfBirth1" class="form-label">Date Of Birth :</label>
            <input type="date" size="20" required aria-describedby="emailHelp" />
            
      </div>
        <div class="col-md-4">
            <label for="exampleInputEmail1" class="form-label">Email Id :</label>
            <input type="email" size="20" required aria-describedby="emailHelp" />
            
        </div>
        <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">Password:</label>
            <input type="password"size="20" required/>
        </div> 
{/*         
        <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">Phone No :</label>
            <input type="number" size="20" required/>
        </div>
        <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">UserName :</label>
            <input type="text" size="20" required/>
        </div>
        <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">Address :</label>
            <input type="text" size="20" required />
        </div>
        <div>
        
           <div class="col-md-8">
            <select class="mb8" aria-label="Default select example">
            <option selected size="20" required>Select Bank</option>
            <option value="1">SBI</option>
            <option value="2">UNION</option>
            <option value="3">AXIX</option>
            </select>
            </div>
        
            <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">Saving Account Number :</label>
            <input type="number" size="20" required />
        </div>
        <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">Ifsc Code :</label>
            <input type="text" size="20" required />
        </div>
        <div class="col-md-4">
            <label for="exampleInputPassword1" class="form-label">Account Status :</label>
            <input type="text" size="20" required/>
        </div>
        <label class="" for="flexRadioDefault1">Card Type:</label>
       
        <div class="col-md-4">
            
            <label class="form" for="flexRadioDefault1">Titanium</label>
             <input  class="form" type="radio" name="flexRadioDefault" id="flexRadioDefault1" />
           </div>
           <div class="col-md-4">
           <label class="form" for="flexRadioDefault2">Gold</label>
            <input class="form" type="radio" name="flexRadioDefault" id="flexRadioDefault1" /></div>
           </div>
        <div class="col-md-8">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"/>
                <label class="form-check-label" for="flexCheckDefault">
                   I accept the <strong>Terms Of Use</strong> and <strong>Privacy Policy.</strong>
                </label>
                </div> */}
               cc
    </form>
 
              </div>
              
              </>
          )
      }
  }