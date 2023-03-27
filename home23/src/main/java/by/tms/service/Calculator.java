package by.tms.service;

public class Calculator {

    public String calculate(double num1, double num2, String type) {
        switch (type) {
            case "sum": return Double.toString(num1+num2);

            case "sub": return Double.toString(num1-num2);
            case "mul": return Double.toString(num1*num2);

            case "div":  return Double.toString(num1/num2);
        }
        return "нет такой операции";
    }
}