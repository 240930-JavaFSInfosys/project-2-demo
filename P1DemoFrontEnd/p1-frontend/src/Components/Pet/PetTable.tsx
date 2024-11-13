//This component takes in the Pets array as props from the PetContainer

import { Button, Container, Table } from "react-bootstrap"

//we'll call this Pets array "pets"
export const PetTable:React.FC<{pets:any[]}> = ({pets}) => {

    //hypothetical methods for update pet and delete pet (which both need pet id to find the pet in question)
    const updatePet = (id:number) => {
        alert("Pet with id " + id + " has been updated (not really)")
    }

    const deletePet = (id:number) => {
        alert("Pet with id " + id + " has been deleted (not really)")
    }

    return(
        <Container>

            <Table>
                <thead>
                    <tr>
                        <th>Pet ID</th>
                        <th>Name</th>
                        <th>Species</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {pets.map((pet:any)=>(
                        <tr>
                            <td>{pet.petId}</td>
                            <td>{pet.name}</td>
                            <td>{pet.species}</td>
                            <td>
                                <Button className="btn-info" onClick={() => updatePet(pet.petId)}>Update</Button>
                                <Button className="btn-danger" onClick={() =>deletePet(pet.petId)}>Delete</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>


        </Container>
    )

}