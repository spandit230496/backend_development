from abc import ABC, abstractmethod


# Abstraction
class Device(ABC):

    @abstractmethod
    def turn_on(self):
        pass


