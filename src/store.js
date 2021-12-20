
import {createStore} from 'redux';


//create inital object

const initialState={
   personList:[],
    //  courseList:[],

};
//create a reducer 

const reducer=(state=initialState , action)=>{
    const{type,payload}= action;
    const personListCopy = [...state.personList];
    switch (type) {
    case "PERSON_ADD":

    const id=payload.id ? payload.id:state.personList.length +1;
    personListCopy.push({...payload,id});
    return {
    personList : personListCopy,
    };
    
    case "PERSON_UPDATE":
        let objectToBeUpdateIndex =personListCopy.findIndex(
            (person)=>person.id === payload.id
        );
        personListCopy[objectToBeUpdateIndex] ={
            ...personListCopy[objectToBeUpdateIndex],
            ...payload,
        };
        return {
            personList : personListCopy,
            };
    
    case "PERSON_DELETE":
    personListCopy.splice(payload,1)
    alert("Deleted");
    return {
    personList : personListCopy,
    };
    default:
    return state;
    }
    } ;

// const reducer=(state=initialState , action)=>{
//     const{type,payload}= action;
//     const courseListCopy = [...state.courseList];
//     switch (type) {
//     case "COURSE_ADD":
//     courseListCopy.push(payload);
//     return {
//     courseList : courseListCopy,
//     };
    
//     case "COURSE_DELETE":
//     courseListCopy.splice(payload,1)

//     return {
//     courseList : courseListCopy,
//     };
//     default:
//     return state;
//     }
//     } ;

   //create a store 
const store =createStore(reducer);
export default store;
