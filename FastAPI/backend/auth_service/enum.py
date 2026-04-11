# enums/user_enums.py
from enum import Enum

class UserRole(str, Enum):
    admin = "admin"
    user = "user"
    provider = "provider"

class Gender(str, Enum):
    male = "male"
    female = "female"
    other = "other"

class UserStatus(str, Enum):
    active = "active"
    inactive = "inactive"
    blocked = "blocked"