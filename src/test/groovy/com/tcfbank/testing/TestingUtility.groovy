package com.tcfbank.testing

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import groovy.lang.Closure

class TestingUtility {
    
    static final Logger LOGGER = LoggerFactory.getLogger("test:")

    // TODO JM - helpful future tool: http://sujitpal.blogspot.com/2007/03/accessing-spring-beans-from-legacy-code.html
    
    /**
     * For the given closure, asserts that when executed the closure throws an exception matching
     * exceptionClass type and that exception has a message that contains messageFragment.
     * @param messageFragment - the exception thrown by the closure should have a message that contains this fragment
     * @param exceptionClass - the class of the exception that should be thrown when the closure runs
     * @param closure - the code to be executed and test
     */
    static void assertFailsWith(String messageFragment, Class exceptionClass, Closure closure) {
        boolean threwException = false
        try {
            closure.call()
        }
        catch(exception) {
            threwException = true
            def expected = exceptionClass.toString() - "class "
            assert expected == exception.class.name, "thrown exception of type '${exception.class.name}' does not match expected type '$expected'"
            assert exception.message.contains(messageFragment), "thrown exception did not contain '$messageFragment'"
        }
        assert threwException, "closure did not throw an exception"
    }
    
    /**
     * For the given closure, asserts that when executed the closure throws an exception matching
     * exceptionClass type.
     * Use this method when testing for exceptions that are outside of our control. For our own exceptions use
     * the version that includes a message fragment.
     * @param exceptionClass - the class of the exception that should be thrown when the closure runs
     * @param closure - the code to be executed and test
     */
    static void assertFailsWith(Class exceptionClass, Closure closure) {
        assertFailsWith("", exceptionClass, closure)
    }
    
    /**
     * log anything (including string) to the console
     */
    static void log(Object object) {
        if(object != null) {
            LOGGER.info(object.toString())
        }
        else {
            LOGGER.info("null")
        }
    }

}
