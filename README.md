# 

## Model
www.msaez.io/#/storming/S2w97jV8rER8403Izo34li2FKWf1/ad570bc6b053e3482591e8369b255723
## Event-Storming 
![moel](https://user-images.githubusercontent.com/70205519/203257687-38bc9e6d-7b35-4e04-8525-1df16dfec77e.PNG)

### Saga(Pub/Sub)
![111](https://user-images.githubusercontent.com/70205519/203258591-92707d0f-fe0d-45e5-9b6f-4c950fff8610.PNG)
![222](https://user-images.githubusercontent.com/70205519/203258602-f696d34b-c7e6-4485-bc98-9643232b28e0.PNG)

### CQRS
![11](https://user-images.githubusercontent.com/70205519/203259654-9caac31c-fc62-4868-bbd0-9e91ea1d95cd.PNG)
![22](https://user-images.githubusercontent.com/70205519/203259705-d157b642-65c8-4b3b-85d1-215184d48f30.PNG)

### Compensation / Correlation
![서킷브레이커](https://user-images.githubusercontent.com/70205519/203258156-4f09181c-96ea-4d43-9442-16b3336df906.PNG)

### Circuit breaker
![33](https://user-images.githubusercontent.com/70205519/203259813-05a91841-b96c-421c-84a3-2f3d30667bb0.PNG)

### Gateway
![gateway](https://user-images.githubusercontent.com/70205519/203259836-2c3bd94b-668c-4d4c-91ee-365b7e0ec93d.PNG)

### 추가한 기능
1. 주문하려고 할 떄 잔액이 부족하면 결제실패
2. 요리완료 후 상태 변경

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- app
- store
- payment
- deliveryMen


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- app
```
 http :8088/orders id="id" foodId="foodId" amount="amount" status="status" reason="reason" foodCost="foodCost" 
```
- store
```
 http :8088/storeOrders id="id" foodId="foodId" orderId="orderId" status="status" 
```
- payment
```
 http :8088/payHistories id="id" orderId="orderId" cost="cost" 
```
- deliveryMen
```
 http :8088/deliveries id="id" address="address" orderId="orderId" deliveryStatus="deliveryStatus" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

