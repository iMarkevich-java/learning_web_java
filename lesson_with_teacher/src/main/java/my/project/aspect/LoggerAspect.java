package my.project.aspect;

import my.project.entity.Person;
import my.project.exceptions.PersonWebException;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggerAspect {

    final static Logger logger = Logger.getLogger(LoggerAspect.class);

    public static void main(String[] args) {
        logger.fatal("Fatal level");
        logger.error("Error level");
        logger.warn("Warning level");
        logger.info("Info level");
        logger.debug("Debug level");
        logger.trace("Trace level");

    }

    @Around("execution(* my.project.controller.*.*(..))")
    public Object doSomethingBefore2(ProceedingJoinPoint joinPoint) {
        String shortName = joinPoint.getSignature().toShortString();
        String[] arrayName = shortName.split("\\.");
        String methodName = arrayName[0];
        String className = arrayName[1];
        logger.info("trying invoke method " + methodName + "in class " + className);
        Object returnObj = null;
        try {
            returnObj = joinPoint.proceed();

        } catch (Throwable throwable) {
            logger.error(throwable.getMessage() + "error in method" + methodName + " of class " + className);
        }
        logger.info("method " + methodName + "in class " + className + " invoke successfully");
        
        return returnObj;
    }

    @Before("execution(* my.project.controller.*.*(..))")
    public void doSomethingBefore1(JoinPoint joinPoint) {

        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");

    }

    @After("execution(* my.project.controller.*.*(..))")
    public void doSomethingAfter(JoinPoint joinPoint) {

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

    }

    @Before("execution(* my.project.controller.PersonRestController.bum(..))")
    public void doSomethingBum(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        String word = arg.toString();
        Object number = args[1];
        int age = Integer.parseInt(number.toString());
        args[0] = "bbbbb";
        args[1] = 1000;
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

    }

    @Around("execution(* my.project.service.PersonService.readPersonById(..))")
    public void doSomethingGym(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object arg1 = args[0];
        int age = Integer.parseInt(arg1.toString());
        age += 1000;
        args[0] = age;
        try {
            Object returnResult = joinPoint.proceed(args);
            Person person = (Person) returnResult;
            System.out.println();
        } catch (PersonWebException pex) {
            throw pex;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    @Around("execution(* my.project.*.*Person*.*Dao(..))")
    public List<Person> doSomethingAround(ProceedingJoinPoint proceedingJoinPoint) {

        List<Person> persons = null;
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        try {
            persons = (List<Person>) proceedingJoinPoint.proceed();


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("11111111111111111111111111111111111111111111111111111111111");
        return persons;
    }

//
//    @Before("execution(* *.PersonController.*(..))")
//    public void doSomethingBefore(JoinPoint joinPoint) {
//
//        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//
//    }
//
//
//    @Before("execution(* *.PersonService.*(..))")
//    public void doSomethingBefore2(JoinPoint joinPoint) {
//
//        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//
//    }

//    @Before("execution(* my.project.controller.PersonRestController.*(..))")
//    public void doSomethingBefore2() {
//
//        System.out.println("2222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
//
//    }

}
