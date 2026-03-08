from classes.email_service import EmailService
from classes.user_repository import UserRepository
from classes.user_service import UserService


if __name__ == "__main__":

    user_service = UserService()
    user_repo = UserRepository()
    email_service = EmailService()

    user_service.create_user("Sandip")
    user_repo.save("Sandip")
    email_service.send_email("Sandip")