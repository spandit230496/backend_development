package Decorators;
import LLD.design_patterns.decorator_design_pattern.CharacterDecorator;



class GunPowerDecorator extends CharacterDecorator {

    public GunPowerDecorator(Character character) {
        super(character);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Gun Power";
    }
}
