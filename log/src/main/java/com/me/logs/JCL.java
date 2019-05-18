package com.me.logs;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Jakarta  Commons-logging（JCL）
 *  LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
 *     private static final String[] classesToDiscover = {
 *             LOGGING_IMPL_LOG4J_LOGGER,
 *             "org.apache.commons.logging.impl.Jdk14Logger",
 *             "org.apache.commons.logging.impl.Jdk13LumberjackLogger",
 *             "org.apache.commons.logging.impl.SimpleLog"
 *     };
 *  同过如上顺序查找commons-logging的依赖
 *
 */
public class JCL {

    public static void main(String[] args) {

        //Log log = LogFactory.getLog("jcl");

        //log.info("commons-logging 桥接到哪了？");
    }
}
