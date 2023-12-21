# Product API Specs

## Create Product

Endpoint: POST http://localhost:80/api/addproduct

Request Body:
```json
{
    "name" : "Semen Tiga Roda",
    "price" : 50000,
    "qty": 100,
    "description": "Semen merk Tiga Roda dengan berat 20 Kg"
}
```

Respon Body (Success) :
```json
{
    "data": {
        "id": 7,
        "name": "Semen Tiga Roda",
        "price": 50000,
        "qty": 100,
        "description": "Semen merk Tiga Roda dengan berat 20 Kg"
    },
    "errors": null
}
```

Respon Body (Failed) :
```json
{
    "data": null,
    "errors": "price: must not be null, name: must not be blank"
}
```

## Update Product

Endpoint: PUT http://localhost:80/api/update/{id}

Request Body:
```json
{
    "name": "Update",
    "price": 50000,
    "qty": 100,
    "description": "update"
}
```

Respon Body (Success) :
```json
{
    "data": {
        "id": 7,
        "name": "Update",
        "price": 50000,
        "qty": 100,
        "description": "update"
    },
    "errors": null
}
```

Respon Body (Failed) :
```json
{
    "data": null,
    "errors": "price: must not be null, name: must not be blank"
}
```

## Get Product

## Get All

Endpoint: GET http://localhost:80/api/products

Respon Body (Success) :
```json
{
    "data": [
        {
            "id": 1,
            "name": "Cat Tembok Interior",
            "price": 50000,
            "qty": 100,
            "description": "Cat tembok interior dengan formula tahan lama dan mudah diaplikasikan."
        },
        {
            "id": 2,
            "name": "Paku Beton 8 cm",
            "price": 2000,
            "qty": 500,
            "description": "Paku beton berkualitas tinggi untuk konstruksi bangunan."
        }
    ],
    "errors": null
}
```

## Get By Id

Endpoint: GET http://localhost:80/api/productbyid/{id}

Respon Body (Success) :
```json
{
    "data": {
        "id": 7,
        "name": "Semen Tiga Roda",
        "price": 50000,
        "qty": 100,
        "description": "Semen merk Tiga Roda dengan berat 20 Kg"
    },
    "errors": null
}
```

Response Body (Failed, 404) :

```json
{
    "data": null,
    "errors": "Product not found"
}
```

## Get By Name 

Endpoint: GET http://localhost:80/api/product/?name={name}

Respon Body (Success) :
```json
{
    "data": {
        "id": 7,
        "name": "Semen Tiga Roda",
        "price": 50000,
        "qty": 100,
        "description": "Semen merk Tiga Roda dengan berat 20 Kg"
    },
    "errors": null
}
```

Response Body (Failed, 404) :

```json
{
    "data": null,
    "errors": "Product not found"
}
```

## Delete Product
Endpoint : DELETE api/products/{id}

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed, 404) :

```json
{
  "errors" : "Product is not found ..."
}
```