import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { Modal, Button, Form } from 'react-bootstrap';

const EmployeeForm = ({ show, handleClose, onSave, employee }) => {
    const { register, handleSubmit, setValue, reset } = useForm({
        defaultValues: employee || {},
    });
    const [selectedFile, setSelectedFile] = useState(employee ? employee.imgURL : '');

    const handleImageChange = (event) => {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onloadend = () => {
                setSelectedFile(reader.result);
                setValue('imgURL', reader.result);
            };
            reader.readAsDataURL(file);
        }
    };

    const onSubmit = (data) => {
        onSave(data);
        reset();
        handleClose();
    };

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>{employee ? 'Edit Employee' : 'Add Employee'}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form onSubmit={handleSubmit(onSubmit)}>
                    <Form.Group controlId="name">
                        <Form.Label>Name</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter name"
                            {...register('name', { required: true })}
                        />
                    </Form.Group>
                    <Form.Group controlId="email">
                        <Form.Label>Email</Form.Label>
                        <Form.Control
                            type="email"
                            placeholder="Enter email"
                            {...register('email', { required: true })}
                        />
                    </Form.Group>
                    <Form.Group controlId="jobTitle">
                        <Form.Label>Job Title</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter job title"
                            {...register('jobTitle', { required: true })}
                        />
                    </Form.Group>
                    <Form.Group controlId="phoneNumber">
                        <Form.Label>Phone Number</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter phone number"
                            {...register('phoneNumber', { required: true })}
                        />
                    </Form.Group>
                    <Form.Group controlId="image">
                        <Form.Label>Upload Image</Form.Label>
                        <Form.Control type="file" onChange={handleImageChange} />
                        {selectedFile && (
                            <img src={selectedFile} alt="Employee" style={{ width: '100px', height: '100px', marginTop: '10px' }} />
                        )}
                    </Form.Group>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose}>
                            Close
                        </Button>
                        <Button variant="primary" type="submit">
                            Save changes
                        </Button>
                    </Modal.Footer>
                </Form>
            </Modal.Body>
        </Modal>
    );
};

export default EmployeeForm;
