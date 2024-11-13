import axios from "axios"
import { useEffect, useState } from "react"
import { Container } from "react-bootstrap"
import { store } from "../../globalData/store"
import { UserTable } from "./UserTable"

export const UserContainer:React.FC = () => {

    //we'll store a state object that contains an Array of PetInterfaces
    //TODO: make the pet interface, but for now, we can just use an any[]
    const[users, setUsers] = useState<any[]>([])

    //Defining a useEffect that calls the function that gets pets by userId
    useEffect(()=>{
        getUsers()
    }, []) //this useEffect triggers on component load


    //The function that gets all pets with an axios GET request
    const getUsers = async () => {

        //axios GET request 
        //NOTE: using the id of the loggedInUser to get only their pets
        const response = await axios.get("http://localhost:7777/users")
        //TODO: then(), catch() etc

        //populate the pets state object
        setUsers(response.data) //data holds the data send in the response body

        console.log(response.data)
    }


    return(
        /* TODO: navbar thing? for navigation options etc */
        <Container>

            <h3>{store.loggedInUser.username}'s Users:</h3>

            
            <UserTable users={users}></UserTable> 

        </Container>
    )

}