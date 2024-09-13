import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ViewData from './Pages/ViewData';
import UpdateStudent from './Pages/UpdateData';
import RegistrationForm from './Pages/RegistrationForm';


function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<RegistrationForm />} />
                <Route path="/data" element={<ViewData />} />
                <Route path="/update/:id" element={<UpdateStudent />} />
            </Routes>
        </Router>
    );
}

export default App;
