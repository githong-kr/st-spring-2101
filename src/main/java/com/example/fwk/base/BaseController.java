package com.example.fwk.base;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    protected final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
}
