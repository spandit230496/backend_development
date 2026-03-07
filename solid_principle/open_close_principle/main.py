from classes.credit_card_payment import CreditCardPayment
from classes.payment_processor import PaymentProcessor

creditcard=CreditCardPayment()


process_payment=PaymentProcessor(creditcard)

process_payment.pay()

