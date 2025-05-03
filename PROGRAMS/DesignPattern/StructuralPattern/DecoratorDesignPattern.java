package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;


abstract class BasePizza{
    abstract Integer getCost();
}

abstract class PizzaDecorator extends BasePizza{

}

class MainPizza extends BasePizza{

    @Override
    Integer getCost() {
        return 100;
    }
}

class CheeseTopping extends PizzaDecorator{
    private BasePizza basePizza;
    CheeseTopping(BasePizza basePizza){
        this.basePizza=basePizza;
    }

    @Override
    Integer getCost() {
        return basePizza.getCost()+10;
    }
}

class MushroomTopping extends PizzaDecorator{
    private BasePizza basePizza;
    MushroomTopping(BasePizza basePizza){
        this.basePizza=basePizza;
    }

    @Override
    Integer getCost() {
        return basePizza.getCost()+20;
    }
}

public class DecoratorDesignPattern {

    public static void main(String [] args){
        BasePizza basePizza=new MainPizza();
        System.out.println("BASE PIZZA COST:"+basePizza.getCost());
        BasePizza cheeseToppingPizza=new CheeseTopping(basePizza);
        System.out.println("CHEESE TOPPING PIZZA COST:"+cheeseToppingPizza.getCost());
        BasePizza mushroomToppingPizza=new MushroomTopping(basePizza);
        System.out.println("MUSHROOM TOPPING PIZZA COST:"+mushroomToppingPizza.getCost());
        BasePizza mushroomAndCheeseToppingPizza=new MushroomTopping(cheeseToppingPizza);
        System.out.println("CHEESE AND MUSHROOM TOPPING PIZZA COST:"+mushroomAndCheeseToppingPizza.getCost());
    }
}
