# routes/user_routes.py
from fastapi import APIRouter, Depends
from sqlmodel import Session
from ..schema.user import UserCreate,UserRead
from ..controllers.user_controller import create_user , get_user_by_id
from ..database.db_connection import get_session
from fastapi_cache.decorator import cache



user_router = APIRouter(prefix="/users", tags=["Users"])


@user_router.post("/",response_model=UserRead)
def create(user: UserCreate, db: Session = Depends(get_session),response_model=UserRead):
    return create_user(db, user)

@user_router.get("/{user_id}")
@cache(expire=60)
def get_user(user_id: int, db: Session = Depends(get_session)):
    user = get_user_by_id(db, user_id)
    
    if not user:
        return {"error": "User not found"}
    
    return user