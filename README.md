# 

## Model
www.msaez.io/#/storming/bbed4c3b0b3a72966c5878d7e6c42f8d

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

- App
- Adress Check
- Pay
- store
- Delivery
- Customer


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- App
```
 http :8088/orders Order_id="Order_id" Order_time="Order_time" Order_qty="Order_qty" Order_subject="Order_subject" status="status" Cust_id="Cust_id" StoreId="StoreId" 
```
- Adress Check
```
 http :8088/checkOederAdresses Order_id="Order_id" Order_time="Order_time" Order_qty="Order_qty" Order_subject="Order_subject" status="status" Cust_id="Cust_id" StoreId="StoreId" 
```
- Pay
```
 http :8088/payments id="id" Order_id="Order_id" Order_Amout="Order_Amout" ApproveTime="ApproveTime" status="status" 
```
- store
```
 http :8088/foodCookings id="id" Order_time="Order_time" Order_id="Order_id" Order_Amout="Order_Amout" order_qty="order_qty" Order_subject="Order_subject" ApproveTime="ApproveTime" Cust_id="Cust_id" Adress="Adress" 
```
- Delivery
```
 http :8088/deliveryOrderProcessings id="id" Order_time="Order_time" Order_id="Order_id" Order_Amout="Order_Amout" order_qty="order_qty" Order_subject="Order_subject" Adress="Adress" 
```
- Customer
```
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

