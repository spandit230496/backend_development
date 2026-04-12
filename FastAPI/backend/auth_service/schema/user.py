
from sqlmodel import SQLModel,Field
from ..enum import UserRole, Gender


class UserCreate(SQLModel):
    full_name: str
    phone: str
    email: str
    gender: Gender
    role: UserRole
    password:str=Field(min_length=3, max_length=50)
    
class UserRead(SQLModel):
    full_name: str
    phone: str
    email: str
    gender: Gender
    role: UserRole