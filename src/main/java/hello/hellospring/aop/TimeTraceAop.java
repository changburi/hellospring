package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // SpringConfig에 bean을 등록하거나 component를 등록
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint jointPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + jointPoint.toString());
        try {
            return jointPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + jointPoint.toString() + "" + timeMs + "ms");
        }
    }
}
