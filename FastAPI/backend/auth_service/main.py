from fastapi import FastAPI
from .routes.user_routes import user_router 
from .database.db_connection import onstartup
from fastapi_cache import FastAPICache
from fastapi_cache.backends.redis import RedisBackend
import redis.asyncio as redis



app = FastAPI()

app.include_router(user_router, prefix="/api/v1")



@app.on_event("startup")
def on_startup():
    r = redis.from_url("redis://localhost:6379", encoding="utf8", decode_responses=True)
    FastAPICache.init(RedisBackend(r), prefix="fastapi-cache")
    onstartup()

@app.get("/ping")
def ping():
    return {"message": "pong"}