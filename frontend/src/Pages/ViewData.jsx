import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function ViewData() {
    const [data, setData] = useState([]);
    const url = 'http://localhost:8080/api/v1';
    const navigate = useNavigate();
     // React Router hook for navigation

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const response = await axios.get(`${url}/students`);
            setData(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    // Function to navigate to update page with the id
    const handleUpdate = (id) => {
        navigate(`/update/${id}`); // Navigate to /update/:id
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`${url}/students/${id}`);
            fetchData();
        } catch (error) {
            console.error('Error deleting item:', error);
        }
    };

    return (
        <>
            <h1 className='text-center'>Student List</h1>
            <table className="table p-5">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">FirstName</th>
                        <th scope="col">LastName</th>
                        <th scope="col">Email</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item) => (
                        <tr key={item.id}>
                            <td>{item.studentId}</td>
                            <td>{item.firstName}</td>
                            <td>{item.lastName}</td>
                            <td>{item.email}</td>
                            <td>
                                <div>
                                    <button
                                        className='btn btn-success m-2'
                                        onClick={() => handleUpdate(item.studentId)} // Pass the id to handleUpdate
                                    >
                                        Update
                                    </button>
                                    <button
                                        className='btn btn-danger'
                                        onClick={() => handleDelete(item.studentId)}
                                    >
                                        Delete
                                    </button>
                                </div>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );
}
