from .work import Workable
from .eat import Eatable

# Human can work and eat

class Human(Workable, Eatable):

    def work(self):
        print("Human is working")

    def eat(self):
        print("Human is eating")


