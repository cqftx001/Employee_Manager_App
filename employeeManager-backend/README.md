1. Create data.json file with employee info

touch data.json

nano data.json
     

    eg:{
       "email": "qifanc@usc.edu",
       "employeeCode": "9ffd4edc-8e2a-417a-a3d0-9973acefc8f5",
       "id": "66642eb5ead4345851626b70",
       "imgURL": "http://example.com/image.jpg",
       "jobTitle": "Software Engineer",
       "name": "Kevin Chen",
       "phoneNumber": "213-308-0507"
       }


Post method with http://localhost:8080/employee/add manually

or

http POST :8080/employee/add < data.json

http :8080/employee/all

2. for the front-end part

    npm install -g @anglar/cli

    ng new employeemanagerapp

    cd employeemanagerapp
    
    ng serve

    ng generate service <name>