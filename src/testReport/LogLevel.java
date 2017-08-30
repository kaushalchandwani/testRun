
package testReport;

/**
 * Sets the maximum logging level for the log events
 * 
 * ALLOW_ALL: default setting which passes all log events to the report
 * FAIL:  Allows FAIL and FATAL events sent to the report
 * WARNING:  Allows WARNING and FAIL events to be sent to the report
 * ERROR:  Allows ERROR and FAIL events to be sent to the report
 * ERRORS_AND_WARNING:  Allows Errors, Warnings and FAIL/FATAL events 
 * OFF:  No events are allowed to be written to the report  
 * 
 * 
 *
 */
public enum LogLevel {
	ALLOW_ALL, FAIL, WARNING, ERROR, ERRORS_AND_WARNINGS, OFF
}

