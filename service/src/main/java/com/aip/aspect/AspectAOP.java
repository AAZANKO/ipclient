package com.aip.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAOP {

//    @Pointcut("args()") // аргументы, параметры метода!
//    @Pointcut("@args()") // аргументы, параметры аннотации!
//    @Pointcut("@args()") // аргументы, параметры Аннотации! (@ - относится к аннотации метода)
//    @Pointcut("@within") // какая аннотация висит над классом
//    @Pointcut("within") // относится к пакету, на каком уровне на каком слое применять аннотацию
//    @Pointcut("@annotation()") // какая аннотация висит над методом
//    @Pointcut("@target()") // определяет, аннотация висит над прокси или над классом

    @Pointcut("execution(public * com.aip.service.service.*.*(..))")
    public void addLogging(){
    }


    // выполняется до метода
    @Before("addLogging()")
    public void loggingBefore(){
        System.out.println(" I want to log metchod... Before... ");
    }


    // выполняется после метода (Выполнится ВСЕГДА)
    @After("addLogging()")
    public void loggingAfter(){
        System.out.println(" I want to log metchod... After... ");
    }


    // выполняется после метода который вернет корректные данные, успешно завершился метод
    @AfterReturning("addLogging()")
    public void loggingAfterReturning(){
        System.out.println(" I want to log metchod... AfterReturning... ");
    }

    // выполняется песле метода который вернул ошибку
    @AfterThrowing("addLogging()")
    public void loggingAfterThrowing(){
        System.out.println(" I want to log metchod... AfterThrowing... ");
    }


//      лучше разделять @Pointcut и @Before

//    @Before("execution(public * com.aip.service.*.*(..))")
//    public void firstAdvance(){
//        System.out.println("I want to log metchod.. ");
//    }
}
