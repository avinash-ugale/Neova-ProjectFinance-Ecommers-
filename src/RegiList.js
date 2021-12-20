import React, { Component } from "react";
import { connect } from "react-redux";

 class RegiList extends Component{
     state={
         selectObject :null,

     };
    onDeleteHandler=(index)=>{
        const personListCopy=this.state.personList;
        personListCopy.splice(index , 1);
        this.setState({personList: personListCopy});
        };

       editButtonClickHandler=(person)=>{
          console.log("edit",person);
          this.setState({selectObject:person});
        
       };
       onResetHandler =()=>{
           this.setState({selectObject:null});
       }
       onValueChangeHandler=(event)=>{
           const {value,name} =(event.target);
           this.setState({selectObject:{...this.state.selectObject,[name]:value},
        });

       };
     render(){
         return(
             <div>
              <table >
                  <thead>
                      <tr>
                          <th>Sr no</th>
                          <th>Name</th>
                          {/* <th>Age</th>
                          <th>Option</th> */}
                          <th>Date OF birth</th>
                          <th>Email Id</th>
                          <th>Password</th>
                          <th>PhoneNumber</th>
                          <th>UserName</th>
                          <th>Address</th>
                      </tr>
                  </thead>
             <tbody>
                 {this.props.personList.map((person,index)=>
                 {
                     return(
                     <tr key={person.id}>
                         <th>{person.id}</th>
                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input 
                                name="name"
                                value={this.state.selectObject.name} 
                                onChange={this.onValueChangeHandler}/>) :(person.name) 
                            }
                             
                          </th>
                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input type="date"
                                name="dateofbirth"
                                value={this.state.selectObject.dateofbirth} 
                                onChange={this.onValueChangeHandler}/>) :(person.dateofbirth) 
                            }
                             
                          </th>
                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input type="email"
                                name="emailId"
                                value={this.state.selectObject.emailId} 
                                onChange={this.onValueChangeHandler}/>) :(person.emailId) 
                            }
                             
                          </th>

                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input type="password"
                                name="password"
                                value={this.state.selectObject.password} 
                                onChange={this.onValueChangeHandler}/>) :(person.password) 
                            }
                             
                          </th>
                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input type="number"
                                name="phoneNumber"
                                value={this.state.selectObject.phoneNumber} 
                                onChange={this.onValueChangeHandler}/>) :(person.phoneNumber) 
                            }
                             
                          </th>
                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input type="text"
                                name="userName"
                                value={this.state.selectObject.userName} 
                                onChange={this.onValueChangeHandler}/>) :(person.userName) 
                            }
                             
                          </th>

                          <th>
                              {this.state.selectObject && this.state.selectObject.id === person.id ?
                            (<input type="text"
                                name="address"
                                value={this.state.selectObject.address} 
                                onChange={this.onValueChangeHandler}/>) :(person.address) 
                            }
                             
                          </th>


                          

                          
                          <th>
                          {this.state.selectObject && this.state.selectObject.id === person.id ? <>
                          <button className="btn btn-danger" 
                               onClick={()=>{
                              this.props.updatePerson({
                                  ...this.state.selectObject,
                              });
                              this.onResetHandler();
                          }}
                          >Update</button>
                          &nbsp;
                          <button onClick={()=>{
                              this.onResetHandler();
                          }}>Reset</button></> : 
                          <>
                          <button className="btn btn-danger" 
                          onClick={()=>{
                          this.props.deletePersonByIndex(index)
                     }}
                        >Delete</button>
                     &nbsp;
                     <button onClick={()=>{
                         this.editButtonClickHandler(person);
                     }}>Edit</button>
                     </>}
                              </th>
                         </tr>
                     );
                    })}
             </tbody>
              </table>
             </div>
         );
     }
}
const mapStateToProps=(state)=>{  //getting the value from state to props 
    return{
        personList:state.personList,
    };
   };
   const mapDispatchToProps=(dispatch)=>{
    return{
      deletePersonByIndex:(index)=>dispatch({type:"PERSON_DELETE",payload:index}),

      updatePerson:(person)=>dispatch({type:"PERSON_UPDATE",payload:person}),
    };
   };
   export default connect(mapStateToProps,mapDispatchToProps)(RegiList);