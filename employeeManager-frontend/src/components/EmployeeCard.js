import React from 'react';
import { Card, Button } from 'react-bootstrap';

const EmployeeCard = ({ employee, onEdit, onDelete }) => {
  return (
    <Card className="my-3 shadow-sm employee-card" style={{ width: '18rem', position: 'relative' }}>
      {employee.imgURL && (
        <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', position: 'relative', top: '10px', width: '100%' }}>
          <img src={employee.imgURL} alt="Employee" style={{ borderRadius: '50%', height: '100px', width: '100px', objectFit: 'cover' }} />
        </div>
      )}
      <hr style={{ margin: '20px 0' }} />
      <Card.Body style={{ paddingTop: '0px' }}>
        <Card.Title>{employee.name}</Card.Title>
        <Card.Text>
          <strong>Job Title: </strong>{employee.jobTitle}<br />
          <strong>Email: </strong>{employee.email}<br />
          <strong>Phone: </strong>{employee.phoneNumber}
        </Card.Text>
        <Button variant="primary" onClick={() => onEdit(employee)}>Edit</Button>
        <Button variant="danger" onClick={onDelete} style={{ marginLeft: '10px' }}>Delete</Button>
      </Card.Body>
    </Card>
  );
};

export default EmployeeCard;
