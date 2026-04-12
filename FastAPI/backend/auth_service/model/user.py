from sqlmodel import SQLModel, Field
from typing import Optional
from datetime import datetime, date
from ..enum import UserRole, Gender, UserStatus


class User(SQLModel, table=True):
    
    id: Optional[int] = Field(default=None, primary_key=True)

    full_name: str
    gender: Optional[Gender] = None
    phone: str
    email: str
    password:str = None

    dob: Optional[date] = None
    user_image_url: Optional[str] = None
    aadhar_card: Optional[str] = None

    role: UserRole = UserRole.user
    is_verified: bool = False
    rating: float = 0.0
    status: UserStatus = UserStatus.active

    created_ts: datetime = Field(default_factory=datetime.utcnow)
    updated_ts: datetime = Field(default_factory=datetime.utcnow)