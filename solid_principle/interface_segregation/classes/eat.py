from abc import ABC ,abstractmethod

class Eatable(ABC):

    @abstractmethod
    def eat(self):
        pass


