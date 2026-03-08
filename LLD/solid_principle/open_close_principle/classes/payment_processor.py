from .payment_method import PaymentMethod

class PaymentProcessor():
    def __init__(self, method: PaymentMethod):
        self.method = method

    def pay(self):
        self.method.pay()
