# Phonebook application
### Prerequisites:

- Tomcat Server
- Docker with MySql container

### Api documentation

- Create contact 

 ```shell 
POST:  /api/v1/contacts/create

Sample request body:

{
    "contactName" : "Sviat",
    "phoneNumber" : "911"
}
``` 

- Retrieve all contacts stored in db

```shell 
GET:  /api/v1/contacts
 ``` 

- Retrieve contact by name

```shell 
GET: /api/v1/contacts/{userContactName}
``` 
- Update contact by name using parameter "phoneNumber"

```shell 
PUT: /api/v1/contacts/{userContactName}?phoneNumber={phoneNumber}
``` 
-   Delete contact by name

```shell
DELETE: /api/v1/contacts/{userContactName}
  ```
