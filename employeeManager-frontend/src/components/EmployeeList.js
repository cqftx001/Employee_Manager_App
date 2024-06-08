import React from 'react';
import { Button, Card } from 'react-bootstrap';

const EmployeeList = ({ employees, onEdit, onDelete }) => {
    return (
        <div className="d-flex flex-wrap justify-content-center">
            {employees.map((employee) => (
                <Card key={employee.id} style={{ width: '18rem', margin: '10px' }}>
                    <Card.Img variant="top" src={employee.imgURL} alt="Employee" style={{ width: '100px', height: '100px', margin: '10px auto' }} />
                    <Card.Body>
                        <Card.Title>{employee.name}</Card.Title>
                        <Card.Subtitle className="mb-2 text-muted">{employee.jobTitle}</Card.Subtitle>
                        <Card.Text>
                            {employee.email}
                            <br />
                            {employee.phoneNumber}
                        </Card.Text>
                        <Button variant="primary" onClick={() => onEdit(employee)}>Edit</Button>
                        <Button variant="danger" onClick={() => onDelete(employee.id)} style={{ marginLeft: '10px' }}>Delete</Button>
                    </Card.Body>
                </Card>
            ))}
        </div>
    );
};

export default EmployeeList;
