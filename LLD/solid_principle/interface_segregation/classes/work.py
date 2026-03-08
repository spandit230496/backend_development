from abc import ABC, abstractmethod

class Workable(ABC):

    @abstractmethod
    def work(self):
        pass

