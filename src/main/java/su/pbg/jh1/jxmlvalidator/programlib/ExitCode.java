package su.pbg.jh1.jxmlvalidator.programlib;
/**
 * Exit code definitions to signal program termination states to the system.
 * ZERO means the program finished every expected task successfully and without incidents.
 * Negative codes signal an abnormal, unforeseeable termination of the program.
 * Positive codes signal an abnormal termination that the caller can reasonably expect.
 * @author Jaina Hanke
 */
public final class ExitCode {
    /**
     * Default exit code
     */
    public static final byte SUCCESS = 0;
    
    public static final byte GENERIC_FORESEEABLE_ERROR = 1;
    
    public static final byte GENERIC_UNFORESEEABLE_ERROR = -1;
    
}