from classes.sparrow import Sparrow
from classes.penguin import Penguin


class Main:

    @staticmethod
    def make_bird_fly(bird):
        bird.fly()

    @staticmethod
    def make_bird_swim(bird):
        bird.swim()


sparrow = Sparrow()
penguin = Penguin()


if __name__ == "__main__":
    Main.make_bird_fly(sparrow)
    Main.make_bird_swim(penguin)