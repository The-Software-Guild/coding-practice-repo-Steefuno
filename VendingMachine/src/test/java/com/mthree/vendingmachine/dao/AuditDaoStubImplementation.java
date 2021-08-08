/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */

package com.mthree.vendingmachine.dao;

/**
 * 
 * @author Steven
 */
public class AuditDaoStubImplementation implements AuditDao {
    /**
     * Logs a message in the audit
     * @param message the message to log
     */
    public void log(String message) {
        // do nothing
    };
    
    /**
     * Closes the audit log
     */
    public void close() {
        // do nothing
    };
}