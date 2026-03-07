from .work import Workable
from .eat import Eatable

# Robot only works
class Robot(Workable):

    def work(self):
        print("Robot is working")


