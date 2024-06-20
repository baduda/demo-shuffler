# demo-shuffler
Simple demo project

## Installation
```bash 
cd service-log
./mvnw spring-boot:run &

cd ../service-shuffle
./mvnw spring-boot:run &
```

## Usage
```bash
curl --location 'localhost:8080/shuffle' \
--header 'Content-Type: application/json' \
--data '{
    "number": 100
}'
```