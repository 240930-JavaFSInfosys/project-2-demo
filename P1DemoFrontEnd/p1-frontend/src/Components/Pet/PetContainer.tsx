import axios from "axios"
import { useEffect, useState } from "react"
import { Container } from "react-bootstrap"
import { PetTable } from "./PetTable"
import { store } from "../../globalData/store"

export const PetContainer:React.FC = () => {

    //we'll store a state object that contains an Array of PetInterfaces
    //TODO: make the pet interface, but for now, we can just use an any[]
    const[pets, setPets] = useState([])

    //Defining a useEffect that calls the function that gets pets by userId
    useEffect(()=>{
        getPetsByUserId()
    }, []) //this useEffect triggers on component load


    //The function that gets all pets with an axios GET request
    const getPetsByUserId = async () => {

        //axios GET request 
        //NOTE: using the id of the loggedInUser to get only their pets
        const response = await axios.get("http://localhost:7777/pets/user/" + store.loggedInUser.userId)
        //TODO: then(), catch() etc

        //populate the pets state object
        setPets(response.data) //data holds the data send in the response body

        console.log(response.data)
    }


    return(
        /* TODO: navbar thing? for navigation options etc */
        <Container>

            <h3>{store.loggedInUser.username}'s Pets:</h3>

            {/* Sending the entire pets array to get rendered in the PetTable Component */}
            <PetTable pets={pets}></PetTable>

        </Container>
    )

}