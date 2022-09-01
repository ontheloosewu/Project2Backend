package dev.thebrogrammers.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{
    Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("logJP()")
    public void logRequest(){logger.info("Request Handled");}

    @Pointcut("within(dev.thebrogrammers.controllers..*)")
    private void logJP(){}
}
