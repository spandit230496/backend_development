from classes.light_bulb import LightBulb
from classes.fan import Fan
from classes.switch import Switch


if __name__=="__main__":
    bulb = LightBulb()
    fan = Fan()

    switch1 = Switch(bulb)
    switch1.operate()

    switch2 = Switch(fan)
    switch2.operate()