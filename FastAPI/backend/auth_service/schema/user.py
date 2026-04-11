
from sqlmodel import SQLModel
from ..enum import UserRole, Gender

class UserCreate(SQLModel):
    full_name: str
    phone: str
    email: str
    gender: Gender
    role: UserRole