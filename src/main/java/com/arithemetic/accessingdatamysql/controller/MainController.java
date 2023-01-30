package com.arithemetic.accessingdatamysql.controller;

import com.arithemetic.accessingdatamysql.entities.Numeros;
import com.arithemetic.accessingdatamysql.entities.Operator;

import com.arithemetic.accessingdatamysql.services.NumerosService;
import com.arithemetic.accessingdatamysql.services.OperatorService;
import com.arithemetic.operations.ArithemeticOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

@Controller
public class MainController {

    @Autowired
    private NumerosService numerosService;

    @Autowired
    private OperatorService operatorService;

    private Random rand = new Random();
    private static Timer t;
    private static Toolkit tk;
    private static String[] opera;

    public void question_4(){
        //performs the specified task at certain intervals
        t = new Timer();
        tk = Toolkit.getDefaultToolkit();
        opera = ChooseOperatorsQ4();
        showessage();
        //initial delay and subsequent rate
        t.schedule(new rt(), 0, 1*1000);
        String[] sh = redlines();
        (new ArithemeticOperations()).check(opera[0],sh[0],opera[1],sh[1]);
    }

    public void showessage(){
        System.out.println("Choose two right operators from the following operators '+','-','*','/' ");
        System.out.println("You have 10 seconds to answer the question");

    }

    public String[] redlines(){
        Scanner sc = new Scanner(System.in);
        String response1 = sc.next();
        String response2 = sc.next();
        return new String[]{response1,response2};
    }

    public String[] ChooseOperatorsQ4(){
        Operator randomOper1 = operatorService.getOperator(rand.nextInt(4)+1);
        Operator randomOper2 = operatorService.getOperator(rand.nextInt(4)+1);
        Numeros randomNum1 = numerosService.getNumber(rand.nextInt(20) + 1);
        Numeros randomNum2 = numerosService.getNumber(rand.nextInt(20) + 1);
        Numeros randomNum3 = numerosService.getNumber(rand.nextInt(20) + 1);

        return (new ArithemeticOperations()).expression(randomOper1.getOperator(),randomOper2.getOperator(),randomNum1.getNumber(),randomNum2.getNumber(),randomNum3.getNumber());
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
