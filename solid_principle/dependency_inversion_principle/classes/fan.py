# Another low-level module
from .device import Device

class Fan(Device):

    def turn_on(self):
        print("Fan ON")


