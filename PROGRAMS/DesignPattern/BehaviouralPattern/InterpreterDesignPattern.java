package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;


interface Expression{
    Integer interpret();
}

class NumberExpression implements Expression{

    private Integer number;

    public NumberExpression(Integer number){
        this.number=number;
    }

    @Override
    public Integer interpret() {
        return this.number;
    }
}

class AddExpression implements Expression{
    private Integer number1;
    private Integer number2;

    public AddExpression(Integer number1, Integer number2){
        this.number1=number1;
        this.number2=number2;
    }

    @Override
    public Integer interpret() {
        return this.number1+this.number2;
    }
}

class SubtractExpression implements Expression{
    private Integer number1;
    private Integer number2;

    public SubtractExpression(Integer number1, Integer number2){
        this.number1=number1;
        this.number2=number2;
    }

    @Override
    public Integer interpret() {
        return this.number1-this.number2;
    }
}

class MultiplyExpression implements Expression{
    private Integer number1;
    private Integer number2;

    public MultiplyExpression(Integer number1, Integer number2){
        this.number1=number1;
        this.number2=number2;
    }

    @Override
    public Integer interpret() {
        return this.number1*this.number2;
    }
}


// It Provides grammar to evaluate and interpreting the expression
public class InterpreterDesignPattern {

    public static  void main(String [] args){
        // (7+3)*(8-2)
        //(7+3)
        Expression addExpression=new AddExpression(new NumberExpression(7).interpret(),new NumberExpression(3).interpret());
        //(8-2)
        Expression subtractExpression=new SubtractExpression(new NumberExpression(8).interpret(),new NumberExpression(2).interpret());

        Expression multiplyExpression=new MultiplyExpression(addExpression.interpret(),subtractExpression.interpret());

        System.out.println(multiplyExpression.interpret());
    }
}
