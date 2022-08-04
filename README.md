# UserManagement
The repo is of user management where it is used to add,edit,update and delete users according to requirement using simple CRUD operation.
Implementation of JWT auth using spring security is provided in the code. The login endpoint returns the auth token after proper verification 
of username and password stored in the db.
All the other endpoints should pass the auth token while requesting the data from the backend.

In the application.properties file all the db configs and token expiration time is set. The expiration time can be changed according to requirement.
As the the token is expired, logic is handled in the backend to invalidate the token and none of the endpoints in backend 
can be accessed without creation of the new valid token.
