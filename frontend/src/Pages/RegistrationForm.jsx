import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function RegistrationForm() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    dateOfBirth: "",
    gender: "",
    email: "",
    phoneNumber: "",
    address: "",
    city: "",
    state: "",
    zipCode: "",
    dateOfRegistration: "",
    status: "",
    photoUrl: "",
  });

  const url = 'http://localhost:8080/api/v1';

  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Create new item
  const handleCreate = async () => {
    try {
      await axios.post(`${url}/student`, formData);
      setFormData({
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        gender: "",
        email: "",
        phoneNumber: "",
        address: "",
        city: "",
        state: "",
        zipCode: "",
        dateOfRegistration: "",
        status: "",
        photoUrl: "",
       
      });
      navigate('/data'); // Navigate to the data page after creation
    } catch (error) {
      console.error('Error creating item:', error);
    }
  };

  return (
    <div className='p-5'>
      <h1 className="h1 text-center mt-2">Add Student</h1>

      <div className="form-group mb-3">
        <label htmlFor="firstName">First Name</label>
        <input
          className="form-control"
          name="firstName"
          placeholder="First Name"
          value={formData.firstName}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="lastName">Last Name</label>
        <input
          className="form-control"
          name="lastName"
          placeholder="Last Name"
          value={formData.lastName}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="dateOfBirth">Date of Birth</label>
        <input
          className="form-control"
          name="dateOfBirth"
          type="date"
          value={formData.dateOfBirth}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="gender">Gender</label>
        <input
          className="form-control"
          name="gender"
          placeholder="Gender"
          value={formData.gender}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="email">Email</label>
        <input
          className="form-control"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="phoneNumber">Phone Number</label>
        <input
          className="form-control"
          name="phoneNumber"
          placeholder="Phone Number"
          value={formData.phoneNumber}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="address">Address</label>
        <input
          className="form-control"
          name="address"
          placeholder="Address"
          value={formData.address}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="city">City</label>
        <input
          className="form-control"
          name="city"
          placeholder="City"
          value={formData.city}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="state">State</label>
        <input
          className="form-control"
          name="state"
          placeholder="State"
          value={formData.state}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="zipCode">Zip Code</label>
        <input
          className="form-control"
          name="zipCode"
          placeholder="Zip Code"
          value={formData.zipCode}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="dateOfRegistration">Date of Registration</label>
        <input
          className="form-control"
          name="dateOfRegistration"
          type="date"
          value={formData.dateOfRegistration}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="status">Status (Active/Inactive)</label>
        <input
          className="form-control"
          name="status"
          placeholder="Status"
          value={formData.status}
          onChange={handleInputChange}
        />
      </div>

      <div className="form-group mb-3">
        <label htmlFor="photoUrl">Photo URL</label>
        <input
          className="form-control"
          name="photoUrl"
          placeholder="Photo URL"
          value={formData.photoUrl}
          onChange={handleInputChange}
        />
      </div>
      <button type="submit" onClick={handleCreate} className="btn btn-primary">
        Create
      </button>
    </div>
  );
}

export default RegistrationForm;
