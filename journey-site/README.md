# microservices-design
Example project to show multimodule microservices project using gradle build.
There are 2 projects called hotel-list and hotel-operations inside the parent module journey-site. 

Hotel-list:(GET operation sorted by Rating) : http://localhost:8090/hotels?page=0&size=2 
Sample response:
```
{
    "content": [
        {
            "id": 1004,
            "name": "Embassy Suites",
            "groupName": "Hilton",
            "rating": 5,
            "location": "Edison, New Jersey, USA"
        },
        {
            "id": 1005,
            "name": "Rennaisance Inn",
            "groupName": "Mariott",
            "rating": 5,
            "location": "Newark, New Jersey, USA"
        },
        {
            "id": 1007,
            "name": "Homewood Suites",
            "groupName": "Hilton",
            "rating": 4,
            "location": "Jersey City, New Jersey, USA"
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": false,
            "sorted": true,
            "empty": false
        },
        "offset": 0,
        "pageSize": 3,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 2,
    "totalElements": 4,
    "last": false,
    "size": 3,
    "number": 0,
    "numberOfElements": 3,
    "sort": {
        "unsorted": false,
        "sorted": true,
        "empty": false
    },
    "first": true,
    "empty": false
}
```

Hotel-list:(GET operation) : http://localhost:8090/hotels/1005

```
{
    "id": 1005,
    "name": "Rennaisance Inn",
    "groupName": "Mariott",
    "rating": 5,
    "location": "Newark, New Jersey, USA"
}
```

Hotel-operations:(PUT operation): http://localhost:8091/hotels/1005 and add the request body without array.
Sample request:
```
        {
            "id": 1005,
            "name": "Rennaisance Inn",
            "groupName": "Mariott",
            "rating": 6,
            "location": "Newark, New Jersey, USA"
        }
```
Response:
```
HTTPStatus: 204 No Content
```

Hotel-Operations [POST operation]: http://localhost:8091/hotels/add
Sample Request:
```
[		{
            "id": 1007,
            "name": "Embassy Suites",
            "groupName": "Hilton",
            "rating": 5,
            "location": "Newark, New Jersey, USA"
        }
]
```

Response:
```
HTTPStatus: 201 Created
Body: Hotel(s) has been added successfully
```

Hotel-Operations:(GET operation) : http://localhost:8091/hotels/1007
Response:
```
{
    "id": 1007,
    "name": "Embassy Suites",
    "groupName": "Hilton",
    "rating": 5,
    "location": "Newark, New Jersey, USA"
}
```
