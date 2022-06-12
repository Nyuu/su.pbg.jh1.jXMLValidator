package su.pbg.jh1.jxmlvalidator.programlib;

/**
 * Exit code definitions to signal program termination states to the system.
 * ZERO means the program finished every expected task successfully and without incidents.
 * Negative codes signal an abnormal, unforeseeable termination of the program.
 * Positive codes signal an abnormal termination that the caller can reasonably expect.
 * 
 * @author Jaina Hanke
 */
public abstract class DefinitionsExitCodes extends Definitions {
    
    /**
     * Default exit code
     */
    public static final byte SUCCESS = 0;
    
    //GENERIC ERROR CODES
    public static final byte GENERIC_FORESEEABLE_ERROR = 1;
    
    public static final byte GENERIC_UNFORESEEABLE_ERROR = -1;
    
    //Layer 8 Class Errorcodes
    public static final byte NO_PARAM_SWITCHES_PROVIDED_ERROR = 20;
    
    public static final byte INVALID_PARAM_SWITCHES_PROVIDED_ERROR = 21;
    
    public static final byte NOT_ENOUGH_PARAM_ARGUMENTS_ERROR = 22;
    
    public static final byte NO_XML_FILE_PROVIDED_ERROR = 23;
    
    public static final byte INVALID_XML_FILE_PROVIDED_ERROR = 24;
}