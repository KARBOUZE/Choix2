package com.arithemetic;

import com.arithemetic.accessingdatamysql.controller.MainController;
import com.arithemetic.accessingdatamysql.services.Impl.NumerosServiceImpl;
import com.arithemetic.accessingdatamysql.services.Impl.OperatorServiceImpl;
import com.arithemetic.operations.ArithemeticOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.script.ScriptException;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws ScriptException {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        NumerosServiceImpl service = applicationContext.getBean(NumerosServiceImpl.class);
        OperatorServiceImpl service1 = applicationContext.getBean(OperatorServiceImpl.class);
        service.insertNumbers();
        service1.insertOperators();
        showMessage(applicationContext);
    }

    public static void showMessage(ApplicationContext applicationContext) throws ScriptException {
        Scanner sc = new Scanner(System.in);
        String qtNumber;
        MainController service = applicationContext.getBean(MainController.class);
        // choose question
        for(int i=0;i<37;i++){
            System.out.println("Choose a question number from the following questions: ");
            System.out.println("1_Question, Easy mode: ");
            System.out.println("2_Question, Hard mode: ");
            System.out.println("3_Question, Timer: ");
            qtNumber = sc.next();
            switch(qtNumber) {
                case "1":
                    ArithemeticOperations.question_1();
                    break;
                case "2":
                    ArithemeticOperations.question_2();
                    break;
                default:
                    System.out.println("Choose from 4- and 5- one question:");
                    qtNumber = sc.next();
                    switch(qtNumber) {
                        case "4":
                            (new ArithemeticOperations()).question_3();
                            break;
                        default:
                            service.question_4();
                            break;
                    }
            }
        }
    }
}

