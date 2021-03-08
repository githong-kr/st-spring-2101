package com.example.fwk.base;

import ch.qos.logback.classic.Logger;
import com.example.fwk.pojo.CommonArea;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class BaseController {
    protected final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
    protected CommonArea ca;

    public void setCa() {
        if( RequestContextHolder.getRequestAttributes().getAttribute("ca", RequestAttributes.SCOPE_REQUEST) != null) {
            ca = (CommonArea) RequestContextHolder.getRequestAttributes().getAttribute("ca", RequestAttributes.SCOPE_REQUEST);
        }
    }
}
