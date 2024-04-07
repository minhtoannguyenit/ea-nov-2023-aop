package spring.aop.lab5.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import spring.aop.lab5.entity.ActivityLog;
import spring.aop.lab5.repository.ActivityLogRepo;

import static java.time.LocalDate.now;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityAspect {
    private final ActivityLogRepo activityLogRepo;

    @Around("@annotation(ExecutionTime)")
    public Object calcTimeExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object process = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
        ActivityLog entity = new ActivityLog();
        entity.setDate(now());
        entity.setOperation(joinPoint.getSignature().getName());
        entity.setDuration((int) (end - start));
        activityLogRepo.save(entity);
        return process;
    }


//    @Before("execution(* spring.aop.lab5.service.*.*(..))")
//    public Object testHeader(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
//        var process = joinPoint.getArgs();
//        System.out.println("request.toString()");
//        String headerValue = request.getHeader("Your-Header-Name");
//        System.out.println("Received header value: " + headerValue);
//        System.out.println(request.toString());
//        return process;
//    }
}
