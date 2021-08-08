/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

/**
 * 
 * @author Steven
 */
public interface AuditDao {
    /**
     * Logs a message in the audit
     * @param message the message to log
     */
    public void log(String message);
    
    /**
     * Closes the audit log
     */
    public void close();
}
