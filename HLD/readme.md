# 📘 System Design Preparation (HLD)

A complete guide for System Design interviews including:
- Functional Requirements
- Non-Functional Requirements
- Database Selection
- Types of Databases & Features

---

## 🧠 HLD vs LLD

| HLD | LLD |
|-----|-----|
| Architecture | Code |
| Scalability | Design Patterns |
| Distributed Systems | Classes & Objects |

---

# 🔥 High-Level Design (HLD)

---

## 🌐 Social Media & Communication

### 📌 Design Instagram

#### ✅ Functional Requirements
- User authentication
- Upload posts (image/video)
- Like, comment, share
- Follow/unfollow
- Feed generation

#### ⚙️ Non-Functional Requirements
- High availability
- Low latency
- Scalability
- Eventual consistency

#### 🗄️ Database Choice
- User → SQL (PostgreSQL)
- Posts/Feeds → NoSQL (Cassandra)
- Cache → Redis
- Media → S3 + CDN

---

### 📌 Design WhatsApp

#### 🗄️ Database Choice
- Messages → NoSQL (Cassandra)
- Metadata → SQL
- Queue → Kafka
- Cache → Redis

---

### 📌 Design Twitter (X)

#### 🗄️ Database Choice
- Tweets → NoSQL
- Users → SQL
- Timeline → Redis (cache)

---

## 🎥 Media Platforms

### 📌 Design YouTube

#### 🗄️ Database Choice
- Metadata → SQL
- Video → Object Storage (S3)
- Analytics → BigQuery
- Cache → CDN + Redis

---

## 🛒 E-commerce Systems

### 📌 Design Amazon

#### 🗄️ Database Choice
- Orders/Payments → SQL
- Catalog → NoSQL
- Search → Elasticsearch
- Cache → Redis

---

## 🚗 Transportation

### 📌 Design Uber

#### 🗄️ Database Choice
- Trips → NoSQL
- Users → SQL
- Location → Redis / Geo DB

---

## 🔗 Core Problems

### 📌 URL Shortener

#### 🗄️ Database Choice
- Mapping → NoSQL
- Cache → Redis

---

---

# 🧠 Types of Databases & Their Features

---

## 🟦 1. Relational Database (SQL)

### Examples:
- PostgreSQL, MySQL, Oracle

### ✅ Features
- Structured schema (tables, rows, columns)
- ACID properties (strong consistency)
- Supports JOINs
- Transactions support
- Vertical scaling (mainly)

### 📌 Best Use Cases
- Banking systems
- Payment systems
- Order management
- Any system requiring strong consistency

---

## 🟩 2. NoSQL Databases

---

### 🔹 Key-Value Store

#### Examples:
- Redis, DynamoDB

#### ✅ Features
- Simple key → value mapping
- Extremely fast (O(1) access)
- In-memory support
- High scalability

#### 📌 Use Cases
- Caching
- Session storage
- Rate limiting

---

### 🔹 Document Database

#### Examples:
- MongoDB, CouchDB

#### ✅ Features
- JSON-like flexible schema
- No fixed structure
- Easy horizontal scaling

#### 📌 Use Cases
- User profiles
- Content management
- Catalog systems

---

### 🔹 Column-Family Database

#### Examples:
- Cassandra, HBase

#### ✅ Features
- High write throughput
- Distributed by default
- Handles huge data
- Eventual consistency

#### 📌 Use Cases
- Messaging systems
- Time-series data
- Logs/analytics

---

### 🔹 Graph Database

#### Examples:
- Neo4j

#### ✅ Features
- Stores relationships efficiently
- Graph traversal (very fast)
- Nodes + edges model

#### 📌 Use Cases
- Social networks
- Recommendation systems
- Fraud detection

---

## 🟨 3. Search Databases

### Examples:
- Elasticsearch, Solr

### ✅ Features
- Full-text search
- Ranking & relevance
- Fast filtering
- Inverted indexing

### 📌 Use Cases
- Product search
- Log analysis
- Search engines

---

## 🟧 4. In-Memory Databases

### Examples:
- Redis, Memcached

### ✅ Features
- Extremely low latency
- Data stored in RAM
- Supports TTL (expiry)
- Pub/Sub support

### 📌 Use Cases
- Caching
- Real-time analytics
- Leaderboards

---

## 🟥 5. Distributed File Storage

### Examples:
- Amazon S3, HDFS

### ✅ Features
- Stores large files (videos/images)
- Highly durable
- Scalable
- Cost-efficient

### 📌 Use Cases
- Media storage
- Backup systems
- Big data

---

## 🟪 6. Data Warehouses / Analytics DB

### Examples:
- BigQuery, Redshift, Snowflake

### ✅ Features
- Optimized for analytics queries
- Columnar storage
- Handles TB/PB data
- Batch processing

### 📌 Use Cases
- Business analytics
- Reporting
- Data pipelines

---

## 🟫 7. Message Queues / Streaming Systems

### Examples:
- Kafka, RabbitMQ

### ✅ Features
- Asynchronous communication
- High throughput
- Fault-tolerant
- Event-driven architecture

### 📌 Use Cases
- Notification systems
- Event streaming
- Microservices communication

---

# 🧠 Database Selection Cheat Sheet

| Requirement | Best Choice |
|------------|------------|
| Strong consistency | SQL |
| High scalability | NoSQL |
| Ultra-fast reads | Redis |
| Search functionality | Elasticsearch |
| Large files | S3 |
| Real-time streaming | Kafka |
| Analytics | BigQuery |

---

    