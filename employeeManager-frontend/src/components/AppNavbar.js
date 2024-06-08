import React from 'react';
import { Navbar, Nav, Button } from 'react-bootstrap';

const AppNavbar = ({ onAdd }) => {
  return (
    <Navbar bg="light" variant="light" className="mb-4" style={{ backgroundColor: '#fff' }}>
      <Navbar.Brand style={{ color: '#000000' }}>Employee Manager</Navbar.Brand>
      <Nav className="ml-auto">
        <Button variant="primary" onClick={onAdd} >Add Employee</Button>
      </Nav>
    </Navbar>
  );
};

export default AppNavbar;
