package spring.aop.lab5.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import spring.aop.lab5.exception.AopIsAwesomeHeaderException;

@Aspect
@Component
public class HeaderDetectAspect {
    @Before("execution(* spring.aop.lab5.service.*.*(..))")
    public void throwExceptionIfHeaderNotExist() throws AopIsAwesomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        var header = request.getHeader("AOP-IS-AWESOME");
        if (request.getMethod().equals("POST") && header == null) {
            throw new AopIsAwesomeHeaderException("Header not found");
        }
    }
}
