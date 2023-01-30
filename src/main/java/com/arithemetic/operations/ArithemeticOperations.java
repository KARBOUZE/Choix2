package com.arithemetic.operations;

import com.arithemetic.CountDownTimerExample;
import com.arithemetic.accessingdatamysql.controller.MainController;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ArithemeticOperations {

    private static Random rand = new Random();
    //declare the interval i and timer t
    private static int i;
    private static Timer t;
    private static Toolkit tk;
    private static String[] opera;

    public static void question_1() throws ScriptException {
        Scanner sc = new Scanner(System.in);
        int randomNum1 = rand.nextInt(10) + 1;
        int randomNum2 = rand.nextInt(10) + 1;
        int randomOper = rand.nextInt(2);
        int oprResult;
        String operand;

        if(randomOper == 0){
            oprResult = randomNum1 - randomNum2;
            operand = "-";
        }else{
            oprResult = randomNum1 + randomNum2;
            operand = "+";
        }
        System.out.println(randomNum1 +"."+randomNum2+"="+oprResult);
        System.out.println("Choose the right operator from the following operators '+','-' ");
        String response = sc.next();
        if(operand.equals(response)){
            System.out.println("Your response is correct");
        }else{
            System.out.println("Your response is not correct");
            System.out.println("The correct answer is: " + operand);
        }
    }

    public static void question_2(){
        String[] vals = ChooseOperators();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose two right operators from the following operators '+','-','*','/' ");
        String response1 = sc.next();
        String response2 = sc.next();
        check(vals[0],response1,vals[1],response2);
    }

    public static String[] ChooseOperators(){
        int randomNum1 = rand.nextInt(20) + 1;
        int randomNum2 = rand.nextInt(20) + 1;
        int randomNum3 = rand.nextInt(20) + 1;
        int randomOper1 = rand.nextInt(4);
        int randomOper2 = rand.nextInt(4);
        String[] operators = {"+","-","*","/"};

        return expression(operators[randomOper1],operators[randomOper2],randomNum1,randomNum2,randomNum3);
    }

    public static String[] expression(String randomOper1,String randomOper2,double randomNum1,double randomNum2,double randomNum3){

        Expression e = new ExpressionBuilder("x" + randomOper1 + "y" + randomOper2 + "z")
                .variables("x","y","z")
                .build()
                .setVariable("x", randomNum1)
                .setVariable("y", randomNum2)
                .setVariable("z", randomNum3);
        double result = e.evaluate();
        System.out.println(randomNum1 +"."+randomNum2+"."+randomNum3+"="+result);

        return new String[]{randomOper1,randomOper2};
    }

    public static void check(String opeRandom1,String response1,String opeRandom2,String response2){

        if(opeRandom1.equals(response1) && opeRandom2.equals(response2)){
            System.out.println("Your response is correct");
        }else{
            System.out.println("Your response is not correct");
            System.out.println("The correct answer is: " + opeRandom1 + " followed by " + opeRandom2);
        }
        //AWT thread stops
        System.exit(0);
    }

    public void question_3(){
        //performs the specified task at certain intervals
        t = new Timer();
        tk = Toolkit.getDefaultToolkit();
        opera = ChooseOperators();
        MainController mc = new MainController();
        mc.showessage();
        //initial delay and subsequent rate
        t.schedule(new rt(), 0, 1*1000);
        String[] sh = mc.redlines();
        check(opera[0],sh[0],opera[1],sh[1]);
    }

    class rt extends TimerTask {
        //declare a variable beep
        int beep = 10;
        //task to be performed
        public void run() {
            //if BEEP VARIABLE IS GREATER THAN ZERO
            if (beep > 0) {
                //print after each second
                //System.out.print(beep + "\n");
                //decrement the value beep
                beep--;
            }
            //if beep variable is less than zero
            else {
                tk.beep();
                System.out.println("The Time's over. . .!");
                System.out.println("The correct answer is: " + opera[0] + " followed by " + opera[1]);
                //AWT thread stops
                System.exit(0);
            }
        }
    }

}
