from abc import ABC, abstractmethod

class Worker(ABC):

    @abstractmethod
    def work(self):
        pass

    @abstractmethod
    def eat(self):
        pass

class Human(Worker):

    def work(self):
        print("Human is working")

    def eat(self):
        print("Human is eating")


class Robot(Worker):

    def work(self):
        print("Robot is working")

    def eat(self):
        raise Exception("Robot cannot eat")

if  __name__=='__main__':
    human=Human()
    human.eat()
    human.work()
    
    robot=Robot()
    robot.eat()
    robot.work()