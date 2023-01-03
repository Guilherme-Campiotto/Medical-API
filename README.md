# Medical-API
This project simulates an API to control the registration of doctor from a hospital. Its possible to create, read, update and delete doctors. 

Made using JAVA 17, spring boot, bean validation, maven, lombok, JPA and h2database.

Run the file MedApiApplication to test it.

Endpoints and examples:

List all doctors:

http://localhost:8080/doctor/get-all
Method GET

Create doctor:

http://localhost:8080/doctor/create 
Method POST

json body:
{
"name": "Alberto Dono",
"email": "doctor1@test.com",
"crm": "123456",
"speciality": "ORTHOPEDY",
"addressRegistration": {
    "street": "street 1",
    "district": "district Y",
    "zipCode": "12345678",
    "city": "Brasilia",
    "uf": "DF",
    "number": "1",
    "complement": "comprement X"
    }
} 

Update doctor

http://localhost:8080/doctor/update
Method PUT

json body:
{
"id": "1",
"name": "Alberto Fono",
"email": "doctor1@test.com",
"phoneNumber": "989807584",
"addressRegistration": {
    "street": "street 1",
    "district": "district Y",
    "zipCode": "12345678",
    "city": "Brasilia",
    "uf": "DF",
    "number": "1",
    "complement": "comprement X"
    }
} 

Delete Doctor

http://localhost:8080/doctor/delete/{id}
Method DELETE


