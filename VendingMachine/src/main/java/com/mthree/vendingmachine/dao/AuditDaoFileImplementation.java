/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 05 Aug 2021
 */

package com.mthree.vendingmachine.dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 
 * @author Steven
 */
public class AuditDaoFileImplementation implements AuditDao {
    final private ArrayList<String> auditLog;
    final private String path;
    
    public AuditDaoFileImplementation(String path) {
        this.path = path;
        auditLog = new ArrayList<String>();
    }
    
    /**
     * Logs a message in the audit
     * @param message the message to log
     */
    public void log(String message) {
        LocalDateTime timeOfLog;
        
        timeOfLog = LocalDateTime.now();
        message = timeOfLog + "\t" + message;
        
        auditLog.add(message);
    }
    
    /**
     * Closes the audit log saving to file
     */
    public void close() {
        PrintWriter writer;
        
        // Attempt to open the file
        try {
            writer = new PrintWriter(
                new FileWriter(path, true)
            );
        } catch (Exception ex) {
            System.out.println("Failed to write to audit file");
            System.exit(-1);
            return;
        }
        
        // Adds logs line by line into the file
        for (var message: auditLog) {
            writer.println(message);
        }
        writer.close();
    }
}
