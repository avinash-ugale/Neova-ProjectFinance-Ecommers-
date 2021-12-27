import axios from "axios";
import { useState } from "react"
import { useEffect } from "react";

export default  () =>
 {
     const[userList,setUserList]=useState([]);
     const [userName,setUserName]=useState("");
     const [phoneNumber,setUserPhoneNumber]=useState(0);
     const [email,setUserEmail]=useState("");
     const [password,setUserPassword]=useState("");
     const [address,setUserAddress]=useState("");
     const [panCard,setPanCard]=useState("");
     const [bankName,setBankName]=useState("");
     const[cibilScore,setCibilScore]=useState(0);
     const[ifsc,setIfsc]=useState("");
     const[accountNumber,setAccountNumber]=useState(0);
     const[accountStatus,setAccountStatus]=useState(0);
     const[dateOfBirth,setDateOfBirth]=useState("");
     const[isEditMode,setEditMode]=useState(false);
     const[userId,setUserId]=useState(0);
     const[selectedUserId,setSelectedUserId]=useState(-1);
     const[editObject,setEditObject]=useState({});
     const [userObject,setUserObject]=useState({
         userName:"",
         dateOfBirth:"",
         phoneNumber:"",
         email:null,
         password:0,
         address:0,
         panCard:0,
         bankName:"",
         cibilScore:0,
         ifsc:0,
         accountNumber:0,
         accountStatus:"",
     });
   


    const FetchData =() =>{ 
        axios.get("http://localhost:8080/user/getAll").then((response) => {
        console.log(response.data);
        if(response && response.data)
        {
             setUserList(response.data);
        }
     });
    }
    
     useEffect(() => {
     },[])

      const onFormSubmit =(event) =>{
         event.preventDefault();
        if(!isEditMode){
        axios.post("http://localhost:8080/user/Add",{
            ...userObject,
        }).then((response) =>{
            console.log(response);
            alert("Added");
          
            setUserObject({
            
                userName:"",
                dateOfBirth:"",
                phoneNumber:"",
                email:"",
                password:"",
                address:"",
                panCard:"",
                bankName:"",
                cibilScore:0,
                ifsc:"",
                accountNumber:0,
                accountStatus:"",
              
            });
            FetchData();
        });
    
    }
}

      const onDeleteHandler =(userId)=>{
        
            axios.delete("http://localhost:8080/user/delete/"+userId).then((response)=>{
            console.log(response);
            alert("Deleted");
            FetchData();
        })
    }

      const onEdit =(userObject) =>{
          console.log(userObject);
          setUserName(userObject.userName);
          setUserPhoneNumber(userObject.phoneNumber);
          setUserEmail(userObject.email);
          setUserPassword(userObject.password);
          setUserAddress(userObject.address);
          setPanCard(userObject.panCard);
          setBankName(userObject.bankName);
        setCibilScore(userObject.cibilScore);
        setIfsc(userObject.ifsc);
        setAccountNumber(userObject.accountNumber);
        setAccountStatus(userObject.accountStatus);
        setDateOfBirth(userObject.dateOfBirth);
        setUserId(userObject.userId);
        setSelectedUserId(userObject.userId);
        setEditObject({
            ...userObject
        })
      };

    const onEditObjectChangeHandler = (event) =>
     {
        if(event) {
            const {name,value}=event.target;
            setEditObject ({
                ...editObject,
                [name]:value,
            })
        }

      };
      const onUserObjectChangeHandler = (event) => {
        if(event)
        {
            const {name,value}=event.target;
            setUserObject ({
                ...userObject,
                [name]:value,
            })

        }
      };
     

      const onResetRowHandler = () => {
          setSelectedUserId(-1);
          setEditObject({
            userName:"",
            dateOfBirth:"",
            phoneNumber:"",
            email:0,
            password:0,
            address:0,
            panCard:0,
            bankName:"",
            cibilScore:0,
            ifsc:0,
            accountNumber:null,
            accountStatus:"",
          });
      }
    const onUpdateRow = () =>
    {
        if(userId >0){
            axios.put("http://localhost:8080/user/update/"+userId,{
                userId:userId,
                
                ...editObject,
            }).then((response) =>{
                if(response){
                    FetchData();
                    alert("updated");
                    onResetRowHandler();
                }
                });
            }
    }

    return(
        <>
        <h1 className="text-center">From User</h1>
            <form className="container" onSubmit={onFormSubmit}>
                <div className="col-md-5">
                     <label htmlFor="name" className="form-label"> User Name</label>
                    <input 
                            id="name"
                            className="form-control"
                            name="userName" 
                            value={userObject.userName} 
                        onChange={onUserObjectChangeHandler}
                        placeholder="Please Enter Your Name"
                    />
                </div>
                <div className="col-md-5">
                    <label htmlFor="sourcelocation"className="form-label">Phone Number</label>
                    <input
                            id="sourcelocation"
                            className="form-control"
                            name="phoneNumber"
                            value={userObject.phoneNumber}
                        onChange={onUserObjectChangeHandler}
                        placeholder="Please Enter Your Phone Number"
                    />
                </div>
                <div className="col-md-5">
                    <label htmlFor="destinationlocation" className="form-label">Email </label>
                    <input 
                            id="destinationLocation"
                            className="form-control"
                            name="email" 
                            value={userObject.email} 
                        onChange={onUserObjectChangeHandler}
                        placeholder="Please EnterYour Email"
                    />
                </div>
                <div className="col-md-5">
                    <label htmlFor="departuredatetime" className="form-label">Date Of Birth</label>
                    <input
                        id="departuredatetime"
                         className="form-control"
                       type="date"
                         name="dateOfBirth"
                         placeholder="Please EnterYour Date Of Birth"
                         value={userObject.dateOfBirth}
                        onChange={onUserObjectChangeHandler}
                        
                    />
                </div>
                <div className="col-md-5">
                     <label htmlFor="arrivaldatetime" className="form-label">password</label>
                    <input
                             id="arrivaldatetime"
                             className="form-control"
                             placeholder="Please EnterYour Password"
                             name="password"
                             value={userObject.password}
                             onChange={onUserObjectChangeHandler} />
                </div>
                <div className="col-md-5">
                    <label htmlFor="economyseatprice" className="form-label">Address</label>
                    <input 
                            id="economyseatprice"
                             className="form-control"
                             name="address" 
                             placeholder="Please EnterYour Address"
                             value={userObject.address} 
                        onChange={onUserObjectChangeHandler}
                        
                    />
                </div>
                <div className="col-md-5">
                     <label htmlFor="businessseatprice" className="form-label">PanCard</label>
                    <input 
                            id="businessseatprice"
                             className="form-control"
                             name="panCard" 
                             placeholder="Please EnterYour Pancard"
                             value={userObject.panCard} 
                             onChange={onUserObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                     <label htmlFor="totaleconomyseat" className="form-label">Cibil Score</label>
                    <input 
                            id="totaleconomyseat"
                           className="form-control"
                           name="cibilScore" 
                           placeholder="Please EnterYour cibil score"
                           value={userObject.cibilScore} 
                           onChange={onUserObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                     <label htmlFor="totaleconomyseat" className="form-label">Bank Name</label>
                    <input 
                            id="totaleconomyseat"
                           className="form-control"
                           name="bankName" 
                           value={userObject.bankName} 
                           onChange={onUserObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                      <label htmlFor="totalbusinessseats" className="form-label">IFSC</label>
                    <input 
                            id="totalbusinessseats"
                            className="form-control"
                            name="ifsc" 
                            value={userObject.ifsc}
                            onChange={onUserObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                     <label htmlFor="availablebusinessseats" className="form-label">Account Number</label>
                    <input 
                              id="availablebusinessseats"
                              className="form-control"
                              name="accountNumber" 
                              value={userObject.accountNumber} 
                              onChange={onUserObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                         <label htmlFor="availableeconomyseats" className="form-label">Account Status</label>
                            <input
                                  id="availableeconomyseats"
                                  className="form-control"
                                  name="accountStatus"
                                  value={userObject.accountStatus} 
                                  onChange={onUserObjectChangeHandler}/>
                </div>
                <br/>
                <div className="col-md-5">
                     <button type="submit" className="btn btn-success">{isEditMode ? "update" : "submit"}</button>
                    {isEditMode && <button>Rest:</button>}
                 </div>
        </form>
            <h1>User List</h1>
            <table className="table table-bordered border border-info">
                <thead>
                <tr className="table">
                    <th>UserId</th>
                    <th>UserName</th>
                    <th>phoneNumber</th>
                    <th>dateOfBirth</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>panCard</th>
                    <th>BAnk NAme</th>
                    <th>cibilScore</th>
                    <th>accountNumber</th>
                    <th>account Status</th>
                    <th>Ifsc</th>
                    <th>Option</th>
                </tr>
                </thead>
                <tbody>
                    {userList.map((user)=>{
                        return(
                            <tr key={user.userId}>
                                <td>{user.userId}</td>
                                <td>
                                    {selectedUserId === user.userId ?
                                     (<input 
                                     name="userName" 
                                     value={editObject.userName} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(user.userName)}</td>
                                <td>
                                    {selectedUserId === user.userId ?
                                     (<input 
                                     name="phoneNumber" 
                                     value={editObject.phoneNumber} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(user.phoneNumber)}
                                </td>
                                <td>
                                    {selectedUserId === user.userId
                                    ? (<input
                                     name="dateOfBirth" 
                                     value={editObject.dateOfBirth} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(user.dateOfBirth)}
                                </td>
                                <td>
                                    {selectedUserId === user.userId
                                    ? (<input
                                     name="email" 
                                     value={editObject.email} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(user.email)}
                                </td>
                                <td>
                                    {selectedUserId === user.userId
                                        ? (<input
                                            name="password"
                                            value={editObject.password}
                                            onChange={onEditObjectChangeHandler} />)
                                        : (user.password)}
                                </td>
                                <td>
                                    {selectedUserId === user.userId
                                        ? (<input
                                            name="address"
                                            value={editObject.address}
                                            onChange={onEditObjectChangeHandler} />)
                                        : (user.address)}
                                </td>
                                <td>
                                    {selectedUserId === user.userId? 
                                    (<input name="bankName" 
                                    value={editObject.bankName} 
                                    onChange={onEditObjectChangeHandler}/>)
                                    : (user.bankName)}</td>
                                <td>
                                    {selectedUserId === user.userId ?
                                     (<input name="ifsc" 
                                     value={editObject.ifsc} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(user.ifsc)}
                                </td>
                                <td>
                                    {selectedUserId === user.userId ? 
                                    (<input 
                                    name="accountNumber"
                                     value={editObject.accountNumber} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     : (user.accountNumber)}</td>
                                <td>
                                    {selectedUserId === user.userId? 
                                    (<input 
                                    name="cibilScore" 
                                    value={editObject.cibilScore} 
                                    onChange={onEditObjectChangeHandler}/>)
                                    :(user.cibilScore)}</td>
                                <td>
                                    {selectedUserId ===user.userId ?
                                     (<input 
                                     name="accountStatus"
                                     value={editObject.accountStatus} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     : (user.accountStatus)}</td>
                               
                                 <td>{selectedUserId === user.userId ? (<>
                                <button className="btn btn-info" onClick={onUpdateRow}>Update</button>
                                <button onClick={onResetRowHandler}> Reset</button>
                             </>) : (<>
                                <button className="btn btn-danger"
                                    onClick={() =>{
                                        onDeleteHandler(user.userId);
                                    }}
                                >Delete
                                </button>
                                <button className="btn-btn-secondary" onClick={()=>{ onEdit(user)}}>Edit:</button>
                             </>)}
                             </td>
                            </tr>
                        );
                    })}
                    </tbody>
            </table>
        </>
    )
}