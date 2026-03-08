# High-level module

from .device import Device

class Switch:

    def __init__(self, device: Device):
        self.device = device

    def operate(self):
        self.device.turn_on()


