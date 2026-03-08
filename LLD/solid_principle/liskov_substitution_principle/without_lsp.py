class Bird:
    def fly(self):
        print("Bird can fly")


class Sparrow(Bird):
    def fly(self):
        print("Sparrow flies")


class Penguin(Bird):
    def fly(self):
        raise Exception("Penguins can't fly")


def make_bird_fly(bird):
    bird.fly()


sparrow = Sparrow()
penguin = Penguin()

make_bird_fly(sparrow)   # Works
make_bird_fly(penguin)   # Breaks