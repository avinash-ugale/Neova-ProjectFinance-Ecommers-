import logo from './logo.svg';
import './App.css';
import './index.css';
import Posts from './Posts';
import Navbar from './Navbar';
import Header from './Header';
import Body from './Body';
import { Route, Routes } from 'react-router-dom';
import ToDo from './ToDo';
import Footer from './Footer';
import Register from './Register';
import Login from './Login';
import Home from './Home';
import Regis from './Regis';
import RegiList from './RegiList';
import UserProject from './UserProject';


function App() {
  return (
    <>

     <Header/>
    <Navbar/>
    <Routes> 
    <Route path={"/posts"} element= { <Posts/> }/>
    <Route path={"/todos"} element= { <ToDo/> }/> 
     <Route path={"/regis"} element= { <Regis/> }/>
    <Route path={"/login"} element= { <Login/> }/>
    <Route path={"/regiList"} element= { <RegiList/> }/>
    <Route path={"/home"} element= { <Home/> }/>
    </Routes> 
    

    {/* <Footer/> */}
    {/* <UserProject/> */}
                                                    
    </>
  );
}

export default App;


