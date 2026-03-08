class UserManager:

    def create_user(self, name):
        print(f"User {name} created")

    def save_to_database(self, name):
        print(f"Saving {name} to database")

    def send_email(self, name):
        print(f"Sending welcome email to {name}")


if __name__ == "__main__":

    user = UserManager()

    user.create_user("Sandip")
    user.save_to_database("Sandip")
    user.send_email("Sandip")