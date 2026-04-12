# 🔁 Retry Mechanism in FastAPI

A production-ready implementation of a **Retry Mechanism** using Python and FastAPI. This project demonstrates how to handle transient failures in distributed systems using retry strategies like **Exponential Backoff** and **Jitter**.

---

## 📌 Features

* ✅ Fixed Retry Strategy
* ✅ Exponential Backoff
* ✅ Exponential Backoff with Jitter (Best Practice 🚀)
* ✅ Retry Decorator for reusable logic
* ✅ FastAPI integration
* ✅ Clean and scalable structure

---

## 🧠 What is Retry Mechanism?

A retry mechanism is used to **automatically retry failed operations** (like API calls or DB queries) when failures are temporary.

---

## ⚙️ Retry Strategies

### 1. Fixed Delay

Retries after a constant interval.

### 2. Exponential Backoff

Delay increases exponentially after each retry.

### 3. Exponential Backoff with Jitter

Adds randomness to avoid system overload (recommended).

---

## 🏗️ Project Structure

```
retry-mechanism/
│── app/
│   ├── main.py
│   ├── retry.py
│   └── service.py
│
│── requirements.txt
│── README.md
```

---

## 🚀 Installation

```bash
git clone https://github.com/your-username/retry-mechanism.git
cd retry-mechanism
pip install -r requirements.txt
```

---

## ▶️ Running the App

```bash
uvicorn app.main:app --reload
```

---

## 🔁 Retry Decorator Example

```python
import time
import random
from functools import wraps

def retry(retries=3, delay=1):
    def decorator(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            d = delay
            for i in range(retries):
                try:
                    return func(*args, **kwargs)
                except Exception as e:
                    print(f"Retry {i+1} failed: {e}")

                    if i == retries - 1:
                        raise

                    sleep_time = d + random.uniform(0, 1)
                    time.sleep(sleep_time)
                    d *= 2
        return wrapper
    return decorator
```

---

## 📡 Example Usage

```python
@retry(retries=5)
def call_external_api():
    # Simulated failure
    raise Exception("Service unavailable")
```

---

## ⚡ FastAPI Integration

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/retry")
def retry_endpoint():
    return call_external_api()
```

---

## 🧩 When to Use Retry?

### ✅ Use Cases

* External API calls
* Database transient failures
* Message queue processing
* Payment gateway retries

### ❌ Avoid Retry

* 400 Bad Request
* Authentication errors (401/403)
* Permanent failures

---

## 🧱 Production Best Practices

* 🔹 Use **Exponential Backoff + Jitter**
* 🔹 Combine with **Circuit Breaker**
* 🔹 Add **Timeouts**
* 🔹 Ensure **Idempotency**
* 🔹 Log all retries

---

## ⚠️ Common Mistakes

* ❌ Infinite retries
* ❌ No delay between retries
* ❌ Retrying non-retriable errors
* ❌ No monitoring/logging

---

## 📦 Future Improvements

* Add async retry support
* Integrate with Tenacity library
* Add Kafka consumer retry handling
* Add distributed tracing

---

## 🤝 Contributing

Feel free to fork this repo and improve it 🚀

---

## 📄 License

MIT License

---
# 🔁 Retry Mechanism in FastAPI

A production-ready implementation of a **Retry Mechanism** using Python and FastAPI. This project demonstrates how to handle transient failures in distributed systems using retry strategies like **Exponential Backoff** and **Jitter**.

---

## 📌 Features

* ✅ Fixed Retry Strategy
* ✅ Exponential Backoff
* ✅ Exponential Backoff with Jitter (Best Practice 🚀)
* ✅ Retry Decorator for reusable logic
* ✅ FastAPI integration
* ✅ Clean and scalable structure

---

## 🧠 What is Retry Mechanism?

A retry mechanism is used to **automatically retry failed operations** (like API calls or DB queries) when failures are temporary.

---

## ⚙️ Retry Strategies

### 1. Fixed Delay

Retries after a constant interval.

### 2. Exponential Backoff

Delay increases exponentially after each retry.

### 3. Exponential Backoff with Jitter

Adds randomness to avoid system overload (recommended).

---

## 🏗️ Project Structure

```
retry-mechanism/
│── app/
│   ├── main.py
│   ├── retry.py
│   └── service.py
│
│── requirements.txt
│── README.md
```

---

## 🚀 Installation

```bash
git clone https://github.com/your-username/retry-mechanism.git
cd retry-mechanism
pip install -r requirements.txt
```

---

## ▶️ Running the App

```bash
uvicorn app.main:app --reload
```

---

## 🔁 Retry Decorator Example

```python
import time
import random
from functools import wraps

def retry(retries=3, delay=1):
    def decorator(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            d = delay
            for i in range(retries):
                try:
                    return func(*args, **kwargs)
                except Exception as e:
                    print(f"Retry {i+1} failed: {e}")

                    if i == retries - 1:
                        raise

                    sleep_time = d + random.uniform(0, 1)
                    time.sleep(sleep_time)
                    d *= 2
        return wrapper
    return decorator
```

---

## 📡 Example Usage

```python
@retry(retries=5)
def call_external_api():
    # Simulated failure
    raise Exception("Service unavailable")
```

---

## ⚡ FastAPI Integration

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/retry")
def retry_endpoint():
    return call_external_api()
```

---

## 🧩 When to Use Retry?

### ✅ Use Cases

* External API calls
* Database transient failures
* Message queue processing
* Payment gateway retries

### ❌ Avoid Retry

* 400 Bad Request
* Authentication errors (401/403)
* Permanent failures

---

## 🧱 Production Best Practices

* 🔹 Use **Exponential Backoff + Jitter**
* 🔹 Combine with **Circuit Breaker**
* 🔹 Add **Timeouts**
* 🔹 Ensure **Idempotency**
* 🔹 Log all retries

---

## ⚠️ Common Mistakes

* ❌ Infinite retries
* ❌ No delay between retries
* ❌ Retrying non-retriable errors
* ❌ No monitoring/logging

---

## 📦 Future Improvements

* Add async retry support
* Integrate with Tenacity library
* Add Kafka consumer retry handling
* Add distributed tracing

---
