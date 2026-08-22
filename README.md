# 🌱 Spring & Spring Boot Playground

<p align="center">
  <b>My hands-on journey into Java Backend Development with Spring, Spring Boot & Microservices.</b>
</p>

---

## 🧭 Spring Boot & Microservices Roadmap

```mermaid
flowchart LR
    A[☕ Core Java] --> B[🌱 Spring Core]
    B --> C[🌐 Spring MVC]
    C --> D[🚀 Spring Boot]

    D --> E[🌐 REST APIs]
    D --> F[🗄️ Spring Data JPA]
    D --> G[🔐 Spring Security]
    D --> H[🧪 Testing]
    D --> I[⚙️ Spring AOP]

    F --> J[🐘 Hibernate]
    J --> K[(🛢️ MySQL)]

    G --> L[🎫 JWT Authentication]

    D --> M[🏗️ Microservices]

    M --> N[🔎 Service Discovery]
    M --> O[🌐 API Gateway]
    M --> P[⚙️ Config Server]
    M --> Q[📨 Kafka]
    M --> R[⚡ Redis]
    M --> S[🔄 Resilience4j]

    M --> T[🐳 Docker]
    T --> U[☸️ Kubernetes]
```

---

## 🏗️ Microservices Architecture

```mermaid
flowchart TD
    CLIENT[👤 Client] --> GATEWAY[🌐 API Gateway]

    GATEWAY --> AUTH[🔐 Auth Service]
    GATEWAY --> USER[👤 User Service]
    GATEWAY --> ORDER[📦 Order Service]
    GATEWAY --> PRODUCT[🛒 Product Service]

    AUTH --> AUTHDB[(🛢️ Auth DB)]
    USER --> USERDB[(🛢️ User DB)]
    ORDER --> ORDERDB[(🛢️ Order DB)]
    PRODUCT --> PRODUCTDB[(🛢️ Product DB)]

    ORDER --> PRODUCT

    DISCOVERY[🔎 Service Discovery] --> AUTH
    DISCOVERY --> USER
    DISCOVERY --> ORDER
    DISCOVERY --> PRODUCT

    CONFIG[⚙️ Config Server] --> AUTH
    CONFIG --> USER
    CONFIG --> ORDER
    CONFIG --> PRODUCT
```

---

## 🔄 Microservices Communication

```mermaid
flowchart LR
    A[Order Service] -->|REST| B[Product Service]

    A -->|Event| K[📨 Kafka]

    K --> C[Notification Service]
    K --> D[Payment Service]
    K --> E[Inventory Service]

    C --> EMAIL[📧 Email]
    D --> BANK[💳 Payment Gateway]
    E --> STOCK[(📦 Inventory DB)]
```

---

## 🌐 API Gateway

```mermaid
flowchart LR
    CLIENT[👤 Client] --> GATEWAY[🌐 API Gateway]

    GATEWAY --> AUTH[🔐 Auth Service]
    GATEWAY --> USER[👤 User Service]
    GATEWAY --> ORDER[📦 Order Service]
    GATEWAY --> PRODUCT[🛒 Product Service]

    GATEWAY --> FILTER[🔍 Filters]
    FILTER --> ROUTE[🛣️ Routing]
    FILTER --> AUTH_CHECK[🔐 Authentication]
```

### Topics

* Spring Cloud Gateway
* Routing
* Filters
* Authentication
* Authorization
* Rate Limiting
* Load Balancing

---

## 🔎 Service Discovery

```mermaid
flowchart TD
    DISCOVERY[🔎 Eureka Server]

    USER[👤 User Service] -->|Register| DISCOVERY
    ORDER[📦 Order Service] -->|Register| DISCOVERY
    PRODUCT[🛒 Product Service] -->|Register| DISCOVERY
    PAYMENT[💳 Payment Service] -->|Register| DISCOVERY

    CLIENT[🌐 Service] -->|Find Service| DISCOVERY
    DISCOVERY --> CLIENT
```

### Topics

* Eureka
* Service Registration
* Service Discovery
* Client-Side Discovery
* Load Balancing

---

## ⚙️ Centralized Configuration

```mermaid
flowchart TD
    CONFIG[⚙️ Config Server] --> USER[👤 User Service]
    CONFIG --> ORDER[📦 Order Service]
    CONFIG --> PAYMENT[💳 Payment Service]
    CONFIG --> PRODUCT[🛒 Product Service]

    GIT[🐙 Git Repository] --> CONFIG
```

### Topics

* Spring Cloud Config
* Centralized Configuration
* External Configuration
* Environment-specific Configuration

---

## 📨 Event-Driven Architecture

```mermaid
flowchart LR
    ORDER[📦 Order Service] -->|Order Created| KAFKA[📨 Apache Kafka]

    KAFKA --> PAYMENT[💳 Payment Service]
    KAFKA --> INVENTORY[📦 Inventory Service]
    KAFKA --> NOTIFICATION[🔔 Notification Service]

    PAYMENT --> EVENT1[Payment Completed]
    INVENTORY --> EVENT2[Stock Updated]
    NOTIFICATION --> EVENT3[Notification Sent]
```

### Topics

* Apache Kafka
* Producers
* Consumers
* Topics
* Partitions
* Consumer Groups
* Events
* Event-Driven Architecture

---

## ⚡ Redis & Caching

```mermaid
flowchart LR
    CLIENT[👤 Client] --> API[🌐 Spring Boot API]

    API --> CACHE{⚡ Redis Cache}

    CACHE -->|Cache Hit| RESPONSE[📤 Response]

    CACHE -->|Cache Miss| DB[(🛢️ Database)]
    DB --> CACHE
    CACHE --> RESPONSE
```

### Topics

* Redis
* Caching
* Cache Hit / Miss
* `@Cacheable`
* `@CachePut`
* `@CacheEvict`
* Distributed Cache

---

## 🛡️ Resilience in Microservices

```mermaid
flowchart LR
    A[Order Service] --> R[🛡️ Resilience4j]

    R --> B[Payment Service]

    R --> C[Circuit Breaker]
    R --> D[Retry]
    R --> E[Timeout]
    R --> F[Rate Limiter]

    B --> DB[(Payment DB)]
```

### Topics

* Resilience4j
* Circuit Breaker
* Retry
* Timeout
* Rate Limiting
* Fallback

---

## 🧪 Testing

```mermaid
flowchart TD
    TEST[🧪 Testing] --> UNIT[Unit Testing]
    TEST --> INTEGRATION[Integration Testing]
    TEST --> API[API Testing]
    TEST --> MICRO[Microservice Testing]

    UNIT --> JUNIT[JUnit 5]
    UNIT --> MOCKITO[Mockito]

    INTEGRATION --> SPRINGTEST[Spring Boot Test]

    API --> POSTMAN[Postman]

    MICRO --> TESTCONTAINERS[Testcontainers]
```

---

## 📚 Technologies I'm Learning

| Category         | Technologies                     |
| ---------------- | -------------------------------- |
| ☕ Language       | Java                             |
| 🌱 Framework     | Spring                           |
| 🚀 Backend       | Spring Boot                      |
| 🌐 API           | REST                             |
| 🗄️ ORM          | JPA, Hibernate                   |
| 🛢️ Database     | MySQL                            |
| 🔐 Security      | Spring Security, JWT             |
| 🏗️ Architecture | Microservices                    |
| 🌐 Gateway       | Spring Cloud Gateway             |
| 🔎 Discovery     | Eureka                           |
| ⚙️ Configuration | Spring Cloud Config              |
| 📨 Messaging     | Apache Kafka                     |
| ⚡ Caching        | Redis                            |
| 🛡️ Resilience   | Resilience4j                     |
| 🧪 Testing       | JUnit 5, Mockito, Testcontainers |
| 📡 API Testing   | Postman                          |
| ⚙️ AOP           | Spring AOP                       |
| 📦 Build Tool    | Maven                            |
| 🐳 Containers    | Docker                           |
| ☸️ Orchestration | Kubernetes                       |

---

## 🎯 My Goal

Build strong backend development skills with **Java + Spring Boot + Microservices** and understand how production-grade distributed systems are designed.

```mermaid
flowchart LR
    JAVA[☕ Java] --> SPRING[🌱 Spring]
    SPRING --> BOOT[🚀 Spring Boot]

    BOOT --> REST[🌐 REST APIs]
    BOOT --> JPA[🗄️ JPA / Hibernate]
    BOOT --> SECURITY[🔐 Security]
    BOOT --> TEST[🧪 Testing]

    BOOT --> MICRO[🏗️ Microservices]

    MICRO --> GATEWAY[🌐 API Gateway]
    MICRO --> DISCOVERY[🔎 Service Discovery]
    MICRO --> CONFIG[⚙️ Config Server]
    MICRO --> KAFKA[📨 Kafka]
    MICRO --> REDIS[⚡ Redis]
    MICRO --> RESILIENCE[🛡️ Resilience4j]

    MICRO --> DOCKER[🐳 Docker]
    DOCKER --> K8S[☸️ Kubernetes]

    K8S --> CLOUD[☁️ Cloud Deployment]
```

---

## 💡 Learning Philosophy

> **Understand → Code → Debug → Build → Scale**

This repository is my **Spring & Spring Boot playground**, where I practice backend development, JPA/Hibernate, security, REST APIs, microservices, distributed systems, messaging, caching, and production-ready architectures.

---

## ⭐ Keep Building

**Learn the concept. Write the code. Break it. Debug it. Understand it. Build it.**

**Keep learning. Keep coding. Keep building. 🚀**
