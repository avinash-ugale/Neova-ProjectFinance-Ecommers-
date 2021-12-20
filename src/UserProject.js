import { useEffect, useState } from "react"
import { getUserById, getUserList } from "./UserService";


export default()=>{
   const[userList,setUserList]=useState([]);

   useEffect(()=>{
       getUserList().then((response)=>{
           if(response && response.data){
               setUserList(response.data);
           }
       });
   },[]);

   const onGetDetailClickHandler =(userId)=>{
       getUserById(userId).then((response)=>{
           if(response&& response.data){
               alert('Name'+response.data.UserName);
           }
       });
   };

   return(
       <>
     <h1 className='text-center'>UserList</h1>  
     <table>
         <thead>
             <tr>
                 <th>Name</th>
                 <th>Password</th>
             </tr>
         </thead>
         <tbody>
             {userList.map((user)=>{
                 return(
                     <tr key={user.userId}>
                         <td >{user.userName}</td>
                         <td>{user.userPassword}</td>
                         <td>
                             <button onClick={()=>{
                                 onGetDetailClickHandler(user.userId);
                             }}>GetDetail</button>
                         </td>
                     </tr>
                 )
             })}
         </tbody>
     </table>
       
       </>
   )
}