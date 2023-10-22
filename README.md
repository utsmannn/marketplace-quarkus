# Marketplace API

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

## Base Url

Currently live on:
```shell
https://marketfake.fly.dev/
```

## Endpoint

### Get product

```shell
https://marketfake.fly.dev/product?page={int}&pageSize={int}&categoryId={int}&query={string}&sort={string}
```

| query        | description                                                       | mandatory |
|--------------|-------------------------------------------------------------------|-----------|
| `page`       | page (default 1)                                                  | false     |
| `pageSize`   | size of page (default 10)                                         | false     |
| `categoryId` | get product by category id                                        | false     |
| `query`      | query of search product                                           | false     |
| `sort`       | sort of product (`rating`, `discount`, `high_price`, `low_price`) | false     |

Response:
```json

{
    "status": true,
    "message": "Get product success",
    "data": [
        {
            "id": 1,
            "name": "Stylish Leather Handbag",
            "description": "Elegant leather handbag with a classic design. The perfect accessory for any occasion.",
            "category": {
                "id": 7,
                "name": "Fashion",
                "description": "Clothing"
            },
            "price": 80.0,
            "rating": 4.0,
            "discount": 10,
            "images": [
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/images/Stylish%20Leather%20Handbag/img-0.jpeg",
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/images/Stylish%20Leather%20Handbag/img-1.jpeg",
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/images/Stylish%20Leather%20Handbag/img-2.jpeg"
            ]
        },
        {
            "id": 2,
            "name": "Smartphone Stand and Charger",
            "description": "Convenient smartphone stand with a built-in charger. Keep your phone charged and accessible at all times.",
            "category": {
                "id": 6,
                "name": "Electronics",
                "description": "Electronic products such as mobile phones"
            },
            "price": 30.0,
            "rating": 4.5,
            "discount": 15,
            "images": [
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/images/Smartphone%20Stand%20and%20Charger/img-0.jpeg",
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/images/Smartphone%20Stand%20and%20Charger/img-1.jpeg",
                "https://raw.githubusercontent.com/utsmannn/utsmannn/master/images/Smartphone%20Stand%20and%20Charger/img-2.jpeg"
            ]
        },
        ...
      ]
}
```

### Get category
```shell
http://localhost:8080/product/category
```

Response:
```json
{
    "status": true,
    "message": "Get category success",
    "data": [
        {
            "id": 1,
            "name": "Accessories",
            "description": "A diverse range of accessory products"
        },
        {
            "id": 2,
            "name": "Art & Decor",
            "description": "Artwork"
        },
        ...
    ]
}
```

Watch livestream this project on [youtube](https://www.youtube.com/watch?v=9ERigk50fcw)

---
