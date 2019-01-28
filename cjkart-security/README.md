
# microservices-security
This is a multimodule OAuth2.0 demonstration java web app project that consists of home grown Authorization server and Resource server. Client application in this project will register itself to Auth server. Resource server will respond with the logged in user details. Currently the user is stored, validated and retrieved from inmemory H2 datasource but it can be modified any datasource. This project uses thymeleaf for its UI and Spring boot 2.0 has been integrated with Thymeleaf.
This project supports 3 different grant_types: authorization_code, password and refresh_token.

There are 2 sub module projects called authorization-server and client-applicatiom inside the parent module cjakart-security. 

Authorization_code demonstration via webapp project:

URL for webapp project: http://localhost:8091/client/ 
Clicking on login button will direct to a login form: http://localhost:8090/auth/login by passing the client-id, redirect uri 
and grant_type: http://localhost:8090/auth/oauth/authorize?client_id=democlientid&redirect_uri=http://localhost:8091/client/login&response_type=code&state=9u27H7

Entering the correct user credentials and passing the above client id to Auth server will respond with : http://localhost:8091/client/login?code=oBqTfa&state=9u27H7 and thenredirect the form to http://localhost:8091/client/authenticatedPage: Redirection process has the Authorization code that is passed to the user REST endpoint and the Resource server will serve the resources which in this case will be user credentials. 

Password grant_type demonstration via Postman:

Steps to generate OAuth Token:

POST operation: http://localhost:8090/auth/oauth/token
Authorization: 
Basic Auth: 
  Username: democlientid
  password: secret
Click Preview request to generate Headers.

Body:
form_data:
  grant_type: password
  username: ceejay
  password: ceejay
  redirect_uri: http://localhost:8091/client/login


Response:
```
{
    "access_token": "41e1a471-d9b3-43c0-815d-2847ff7d60d4",
    "token_type": "bearer",
    "refresh_token": "8c5d5a28-2f56-46e2-a4bb-f88669f0021c",
    "expires_in": 43074,
    "scope": "read write user_info"
}
```

Steps to retrieve client app response:

http://localhost:8090/auth/user/me
Headers:
Authorization: Bearer 41e1a471-d9b3-43c0-815d-2847ff7d60d4 

Response:

```
{
    "authorities": [
        {
            "authority": "ADMIN"
        },
        {
            "authority": "USER"
        }
    ],
    "details": {
        "remoteAddress": "0:0:0:0:0:0:0:1",
        "sessionId": null,
        "tokenValue": "41e1a471-d9b3-43c0-815d-2847ff7d60d4",
        "tokenType": "Bearer",
        "decodedDetails": null
    },
    "authenticated": true,
    "userAuthentication": {
        "authorities": [
            {
                "authority": "ADMIN"
            },
            {
                "authority": "USER"
            }
        ],
        "details": {
            "redirect_uri": "http://localhost:8091/client/login",
            "grant_type": "password",
            "username": "ceejay"
        },
        "authenticated": true,
        "principal": {
            "password": null,
            "username": "ceejay",
            "authorities": [
                {
                    "authority": "ADMIN"
                },
                {
                    "authority": "USER"
                }
            ],
            "accountNonExpired": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "enabled": true
        },
        "credentials": null,
        "name": "ceejay"
    },
    "credentials": "",
    "principal": {
        "password": null,
        "username": "ceejay",
        "authorities": [
            {
                "authority": "ADMIN"
            },
            {
                "authority": "USER"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    },
    "oauth2Request": {
        "clientId": "democlientid",
        "scope": [
            "read",
            "write",
            "user_info"
        ],
        "requestParameters": {
            "redirect_uri": "http://localhost:8091/client/login",
            "grant_type": "password",
            "username": "ceejay"
        },
        "resourceIds": [],
        "authorities": [],
        "approved": true,
        "refresh": false,
        "redirectUri": null,
        "responseTypes": [],
        "extensions": {},
        "grantType": "password",
        "refreshTokenRequest": null
    },
    "clientOnly": false,
    "name": "ceejay"
}

```
