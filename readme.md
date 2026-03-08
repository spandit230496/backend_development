# 🚀 System Design (HLD + LLD) Complete Syllabus

This repository contains a **structured roadmap to learn System Design**, including:

* **High-Level Design (HLD)** → Large-scale system architecture
* **Low-Level Design (LLD)** → Object-oriented design & implementation

This syllabus helps developers prepare for:

* System Design Interviews
* Backend Engineering Roles
* Distributed Systems Development

---

# 📚 Table of Contents

1. High-Level Design (HLD)
2. Architecture Fundamentals
3. System Components
4. Scalability Concepts
5. Performance & Reliability
6. System Communication
7. Observability & Security
8. HLD Interview Problems
9. Low-Level Design (LLD)
10. Design Patterns
11. Database & API Design
12. LLD Interview Problems

---

# Part I: High-Level Design (HLD)

High-Level Design focuses on **designing scalable and distributed systems**.

---

# 1️⃣ System Requirements

Important system qualities when designing large-scale applications.

* Scalability
* Availability
* Latency
* Throughput
* Consistency
* Fault Tolerance
* Reliability
* Maintainability
* Security
* Observability
* Durability

---

# 2️⃣ Architecture Fundamentals

## Monolithic Architecture

Single codebase containing the entire application.

## Microservices Architecture

Application divided into independent services.

## Client-Server Model

Clients send requests and servers respond with data.

Example:

Client → Server → Database

## Layered Architecture

Typical layers:

1. Presentation Layer
2. Business Logic Layer
3. Data Access Layer

## Event-Driven Architecture

Components communicate using events.

Example technologies:

* Kafka
* RabbitMQ

## Service-Oriented Architecture (SOA)

Applications composed of reusable network services.

---

# 3️⃣ System Components

## API Gateway

Acts as the entry point for client requests.

Responsibilities:

* Request routing
* Authentication
* Rate limiting
* Logging

---

## Load Balancer

Distributes incoming traffic across servers.

Types:

* Round Robin
* Least Connections
* IP Hash

Examples:

* Nginx
* AWS ELB

---

## Application Servers

Responsible for executing business logic.

Examples:

* Node.js
* Django
* Spring Boot
* Flask

---

## Database Systems

### SQL

* MySQL
* PostgreSQL

### NoSQL

* MongoDB
* Cassandra
* DynamoDB

---

## Caching Layer

Stores frequently accessed data.

Examples:

* Redis
* Memcached

Benefits:

* Faster response
* Reduced database load

---

## Message Queue / Stream

Used for asynchronous processing.

Examples:

* Kafka
* RabbitMQ
* AWS SQS

---

## CDN (Content Delivery Network)

Delivers content from servers closest to users.

Examples:

* Cloudflare
* AWS CloudFront

---

## Object Storage

Used for storing files and media.

Examples:

* Amazon S3
* Google Cloud Storage
* MinIO

---

# 4️⃣ Scalability Concepts

## Horizontal Scaling

Adding more machines.

Example:

Server1 + Server2 + Server3

---

## Vertical Scaling

Increasing resources of one machine.

Example:

More RAM or CPU.

---

## Replication

Copying data across multiple servers.

Benefits:

* Fault tolerance
* Read scalability

---

## Sharding / Partitioning

Splitting large databases.

Example:

Users 1–1M → DB1
Users 1M–2M → DB2

---

## Consistent Hashing

Efficiently distributes data across nodes.

---

## CAP Theorem

A distributed system can guarantee only two of:

* Consistency
* Availability
* Partition Tolerance

---

# 5️⃣ Performance & Reliability

## Caching Strategies

* Write Through
* Write Behind

---

## Database Optimization

* Indexing
* Query optimization

---

## Connection Pooling

Reuse database connections.

---

## Fault Tolerance

* Retry mechanisms
* Failover systems

---

## Data Backup & Recovery

Methods:

* Snapshots
* Incremental backups

---

## Circuit Breaker Pattern

Prevents cascading failures.

States:

* Closed
* Open
* Half-open

---

# 6️⃣ System Communication

## Synchronous Communication

Client waits for response.

Examples:

* REST APIs
* gRPC

---

## Asynchronous Communication

Client does not wait.

Examples:

* Message queues
* Event systems

---

## Communication APIs

* REST
* GraphQL
* gRPC

---

## Messaging Patterns

* Pub/Sub
* Event Sourcing
* CQRS

---

# 7️⃣ Observability & Security

## Observability

* Logging
* Monitoring
* Alerting

Tools:

* Prometheus
* Grafana
* ELK Stack

---

## Security

### Authentication

* OAuth2
* JWT

### Authorization

Access control mechanisms.

### Rate Limiting

Limits requests per user/IP.

### Audit Trails

Tracks user actions.

---

# 8️⃣ HLD Interview Problems

## Beginner

* What happens when you type `google.com` in a browser?
* Design a **URL Shortener**
* Design a **Rate Limiter**
* Design an **API Gateway**
* How does a **Load Balancer** work?
* Explain **CAP Theorem**
* What is a **Bloom Filter**?

---

## Intermediate

* Design a **File Storage System (Google Drive)**
* Design a **Notification System**
* Design a **Logging System**
* Design a **Metrics & Monitoring System**
* Design a **Search System**
* Design a **Distributed Cache (Redis)**

---

## Advanced

* Design **Twitter News Feed**
* Design **WhatsApp Chat System**
* Design **YouTube**
* Design **Uber / Ride Sharing**
* Design **Amazon / Flipkart**
* Design **Instagram**
* Design **Netflix Streaming**
* Design **Google Maps**
* Design **Payment System**

---

# Part II: Low-Level Design (LLD)

Low-Level Design focuses on **object-oriented design and class structure**.

---

# 1️⃣ OOP Fundamentals

* Class & Object
* Abstraction
* Encapsulation
* Inheritance
* Polymorphism
* Composition vs Inheritance
* SOLID Principles

---

# 2️⃣ UML (Unified Modeling Language)

Used to visualize system structure.

### Diagrams

* Class Diagram
* Object Diagram
* Component Diagram
* Deployment Diagram

---

# 3️⃣ Design Patterns

## Creational Patterns

* Factory Pattern
* Abstract Factory Pattern
* Singleton Pattern
* Prototype Pattern
* Builder Pattern

---

## Structural Patterns

* Adapter Pattern
* Bridge Pattern
* Composite Pattern
* Decorator Pattern
* Facade Pattern
* Flyweight Pattern
* Proxy Pattern

---

## Behavioral Patterns

* Chain of Responsibility
* Command Pattern
* Interpreter Pattern
* Iterator Pattern
* Mediator Pattern
* Memento Pattern
* Observer Pattern
* State Pattern
* Strategy Pattern
* Template Method
* Visitor Pattern

---

# 4️⃣ Microservices & Cloud Patterns

### Decomposition

* Business Capability
* Sub-domain
* Strangler Fig
* Sidecar
* Bulkhead

### Data Management

* Database per Service
* Saga Pattern
* CQRS
* Event Sourcing

### API Patterns

* API Gateway
* Gateway Routing
* Backend for Frontend (BFF)
* Aggregator Pattern

### Observability

* Log Aggregation
* Distributed Tracing
* Health Checks
* Service Discovery
* Blue-Green Deployment

---

# 5️⃣ Database & API Design

Steps for designing systems:

1. Identify Entities
2. Define Relationships
3. Design Database Schema
4. Design APIs
5. Consider:

* Caching
* Scaling
* Security
* Optimization

---

# 6️⃣ LLD Interview Problems

## Easy

* Design Vending Machine
* Design Parking Lot
* Design Tic Tac Toe
* Design Snake & Ladder
* Design Library Management
* Design ATM
* Design Movie Ticket Booking
* Design Hotel Booking
* Design Splitwise

---

## Medium

* Design Elevator System
* Design LRU / LFU Cache
* Design Rate Limiter
* Design File Storage
* Design Online Chess
* Design Notification System
* Design Food Delivery (Swiggy/Zomato)
* Design Task Scheduler
* Design Key Value Store
* Design Pub/Sub System

---

## Advanced

* Design Amazon Cart System
* Design Ride Sharing System
* Design News Feed
* Design Chat System
* Design Payment System
* Design Stock Exchange
* Design Logging Framework
* Design Metrics Collector
* Design Online Exam System
* Design Airline Reservation



