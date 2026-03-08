class LightBulb:

    def turn_on(self):
        print("LightBulb ON")

    def turn_off(self):
        print("LightBulb OFF")


class Switch:

    def __init__(self):
        self.bulb = LightBulb()  # Direct dependency

    def operate(self):
        self.bulb.turn_on()


switch = Switch()
switch.operate()