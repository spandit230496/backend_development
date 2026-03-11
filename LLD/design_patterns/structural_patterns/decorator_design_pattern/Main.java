

interface Character {
    String getAbilities();
}

class Mario implements Character {

    public String getAbilities() {
        return "Mario";
    }
}

abstract class CharacterDecorator implements Character {

    protected Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }
}
class HeightUpDecorator extends CharacterDecorator {

    public HeightUpDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Height Up";
    }
}

class GunPowerDecorator extends CharacterDecorator {

    public GunPowerDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Gun Power";
    }
}

class StarPowerDecorator extends CharacterDecorator {

    public StarPowerDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Star Power";
    }
}

public class Main {

    public static void main(String[] args) {

        Character mario = new Mario();

        mario = new HeightUpDecorator(mario);
        mario = new GunPowerDecorator(mario);
        mario = new StarPowerDecorator(mario);

        System.out.println(mario.getAbilities());
    }
}
