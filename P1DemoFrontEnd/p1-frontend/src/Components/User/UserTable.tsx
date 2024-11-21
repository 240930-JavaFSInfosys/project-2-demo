//This is sort of a placeholder component - admins get navigated to this after login
//In your P1 this is probably where admins could see all users, update, delete etc.

import axios from "axios";
import { useEffect, useState } from "react"
import { Button, Container, Table } from "react-bootstrap";

//And maybe there's a navbar or some button that navigates to the admin reimbursement manager
export const UserTable:React.FC<{users:any[]}> = ({users}) => {

    //set the child state to be the array of users from the parent
    const [childUsers, setUsers] = useState<any[]>(users);

    //then we get the users from the DB with the child's own get all users request
    useEffect(()=>{
        getUsers()
    },[])

    const deleteUser = async (id:number) => {
        const response = await axios.delete("http://[EC2 IPV4 HERE]:7777/users/" + id)
        .then((response) =>{
            alert("deleted")}
        )
        .then(()=>{
            getUsers()
        })
    }

    const getUsers = async () => {
        const userData = await axios.get("http://localhost:7777/users")
        .then((userData) => {
            setUsers(userData.data)
        })
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
                    {childUsers.map((user:any)=>(
                        <tr>
                            <td>{user.userId}</td>
                            <td>{user.username}</td>
                            <td>{user.role}</td>
                            <td>
                                <Button className="btn-danger" onClick={() =>deleteUser(user.userId)}>Delete</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

        </Container>
    )

}