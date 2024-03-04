package by.clevertec.aspectlogger.logger;

import static by.clevertec.aspectlogger.util.Constant.EXITING_METHOD_WITH_RESULT;
import static by.clevertec.aspectlogger.util.Constant.RECEIVED_CALL_HTTP_METHOD_WITH_PATH;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* *..controller..*Controller.*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info(RECEIVED_CALL_HTTP_METHOD_WITH_PATH, request.getMethod(), request.getServletPath());
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info(EXITING_METHOD_WITH_RESULT, joinPoint.getSignature().getName(), result);
    }
}
