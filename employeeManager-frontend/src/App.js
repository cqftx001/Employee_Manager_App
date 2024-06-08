import React, { useState, useEffect } from 'react';
import { Container } from 'react-bootstrap';
import EmployeeList from './components/EmployeeList';
import EmployeeForm from './components/EmployeeForm';
import EmployeeService from './services/EmployeeService';
import AppNavbar from './components/AppNavbar'; // 导入 AppNavbar

const App = () => {
    const [employees, setEmployees] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [currentEmployee, setCurrentEmployee] = useState(null);

    useEffect(() => {
        fetchEmployees();
    }, []);

    const fetchEmployees = async () => {
        const response = await EmployeeService.getEmployees();
        setEmployees(response.data);
    };

    const handleAddEmployee = () => {
        setCurrentEmployee(null);
        setShowForm(true);
    };

    const handleEditEmployee = (employee) => {
        setCurrentEmployee(employee);
        setShowForm(true);
    };

    const handleSaveEmployee = async (employee) => {
        try {
            if (currentEmployee) {
                await EmployeeService.updateEmployee(currentEmployee.id, employee);
            } else {
                await EmployeeService.addEmployee(employee);
            }
            setShowForm(false);
            fetchEmployees();
        } catch (error) {
            if (error.response && error.response.status === 415) {
                console.error('Unsupported Media Type:', error.response.data);
                // 显示错误信息给用户，例如设置错误状态
                setError('请求的媒体类型不受支持。');
            } else {
                console.error('保存员工时发生错误:', error);
                // 处理其他类型的错误
                setError('保存员工时发生错误。');
            }
        }
    };

    const handleDeleteEmployee = async (id) => {
        await EmployeeService.deleteEmployee(id);
        fetchEmployees();
    };

    return (
        <>
            <AppNavbar onAdd={handleAddEmployee} /> {/* 使用 AppNavbar 组件 */}
            <Container>
                <EmployeeList employees={employees} onEdit={handleEditEmployee} onDelete={handleDeleteEmployee} />
                <EmployeeForm show={showForm} handleClose={() => setShowForm(false)} onSave={handleSaveEmployee} employee={currentEmployee} />
            </Container>
        </>
    );
};

export default App;
