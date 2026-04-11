# controllers/user_controller.py
from ..model.user import User
from fastapi_cache import FastAPICache
from sqlmodel import Session, select
from ..model.user import User

def create_user(db, user_data):
    new_user = User(**user_data.model_dump())
    db.add(new_user)
    db.commit()
    db.refresh(new_user)

    FastAPICache.clear()
    
    return new_user



def get_user_by_id(db: Session, user_id: int):
    statement = select(User).where(User.id == user_id)
    user = db.exec(statement).first()
    return user



