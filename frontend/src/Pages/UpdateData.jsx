import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

export default function UpdateStudent() {
    const { id } = useParams(); // Get the id from the route parameter
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: ''
    });
    const url = 'http://localhost:8080/api/v1';
    const navigate = useNavigate(); // For redirecting after successful update

    useEffect(() => {
        // Fetch the existing data for the student by id
        const fetchStudent = async () => {
            try {
                const response = await axios.get(`${url}/students/${id}`);
                setFormData(response.data);
            } catch (error) {
                console.error('Error fetching student:', error);
            }
        };
        fetchStudent();
    }, [id]);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.put(`${url}/students/${id}`, formData);
            navigate('/data'); // Redirect to the main page after update
        } catch (error) {
            console.error('Error updating student:', error);
        }
    };

    return (
        <div className="container">
            <h1>Update Student</h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>First Name</label>
                    <input
                        type="text"
                        className="form-control"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                    />
                </div>
                <div className="form-group">
                    <label>Last Name</label>
                    <input
                        type="text"
                        className="form-control"
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleChange}
                    />
                </div>
                <div className="form-group">
                    <label>Email</label>
                    <input
                        type="email"
                        className="form-control"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                    />
                </div>
                <button type="submit" className="btn btn-primary">
                    Update Student
                </button>
            </form>
        </div>
    );
}
