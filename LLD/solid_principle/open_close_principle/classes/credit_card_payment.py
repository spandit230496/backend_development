from .payment_method import PaymentMethod

class CreditCardPayment(PaymentMethod):
    def __init__(self):
        pass
    
    def pay(self):
        print("processing creditcard payment......................")
    