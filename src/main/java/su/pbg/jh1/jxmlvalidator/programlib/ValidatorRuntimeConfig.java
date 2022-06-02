package su.pbg.jh1.jxmlvalidator.programlib;

/**
 *A singleton class containing necessary flags, parameters and values for the program to function properly.
 * 
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public class ValidatorRuntimeConfig {
    
    /**
     * The debug flag, giving excessive output to stdout.
     * Implicitly sets the verbose {@link #VERBOSE_MODE} flag.
     */
    private boolean DEBUG_MODE;
    
    /**
     * The verbose flag, giving some useful output to stdout.
     */
    private boolean VERBOSE_MODE;
    
    /**
     * The verify flag, making the program just quickly check if XML files are sane.
     */
    private boolean VERIFY_MODE;
    
    /**
     * The structure type for XML files that the program will output
     * @see su.pbg.jh1.jxmlvalidator.programlib.DefinitionsRestructureTypes
     */
    private byte RESTRUCTURE_TYPE;
    
    /**
     * The maximum number of concurrent files that are being processed.
     */
    private short MAX_CONCURRENT_FILE_PROCESSING;
    
    /**
     * Absolute path where the XMLValidator program is called from
     */
    private String ABSOLUTE_VALIDATOR_OPERATING_PATH;
    
    /**
     * Relative path of a XSD file if provided
     */
    private String RELATIVE_XSDFILE_PATH;
    
    /**
     * Array of relative paths of provided XML files
     */
    private String[] RELATIVE_XMLFILES_PATH_ARRAY;
    
    /**
     * Called once during the initial program startup after the paramswitch logic to set the program runtime config.
     * 
     * @param debug sets {@link #DEBUG_MODE}
     * @param verbose sets {@link #VERBOSE_MODE}
     * @param verify sets {@link #VERIFY_MODE}
     * @param restructureType sets {@link #RESTRUCTURE_TYPE}
     * @param maxConcurrentFileProcessing sets {@link #MAX_CONCURRENT_FILE_PROCESSING}
     * @param validatorPathAbsolute sets {@link #ABSOLUTE_VALIDATOR_OPERATING_PATH}
     * @param xsdFilePathRelative sets {@link #RELATIVE_XSDFILE_PATH}
     * @param xmlFilesPathArrayRelative sets {@link #RELATIVE_XMLFILES_PATH_ARRAY}
     */
    void setConfigOptions(boolean debug, boolean verbose, boolean verify,
                          byte restructureType, short maxConcurrentFileProcessing,
                          String validatorPathAbsolute, String xsdFilePathRelative,
                          String[] xmlFilesPathArrayRelative)
    {    
        this.DEBUG_MODE = debug;
        this.VERBOSE_MODE = verbose;
        this.VERIFY_MODE = verify;
        this.RESTRUCTURE_TYPE = restructureType;
        this.MAX_CONCURRENT_FILE_PROCESSING = maxConcurrentFileProcessing;
        this.ABSOLUTE_VALIDATOR_OPERATING_PATH = validatorPathAbsolute;
        this.RELATIVE_XSDFILE_PATH = xsdFilePathRelative;
        this.RELATIVE_XMLFILES_PATH_ARRAY = xmlFilesPathArrayRelative;
    }
    
    private ValidatorRuntimeConfig() {
    }
    
    //Used to make this class a singleton
    public static ValidatorRuntimeConfig getInstance() {
        return ValidatorRuntimeConfigHolder.INSTANCE;
    }
    //Used to make this class a singleton
    private static class ValidatorRuntimeConfigHolder {
        private static final ValidatorRuntimeConfig INSTANCE = new ValidatorRuntimeConfig();
    }
    
    /**
     * 
     * @return returns the {@link #DEBUG_MODE} flag
     */
    public boolean isDEBUG_MODE() {
        return DEBUG_MODE;
    }
    
    /**
     * 
     * @return returns the {@link #VERBOSE_MODE} flag
     */
    public boolean isVERBOSE_MODE() {
        return VERBOSE_MODE;
    }

    /**
     * 
     * @return returns the {@link #VERIFY_MODE} flag
     */
    public boolean isVERIFY_MODE() {
        return VERIFY_MODE;
    }

    /**
     * 
     * @return returns the {@link #RESTRUCTURE_TYPE}
     */
    public byte getRESTRUCTURE_TYPE() {
        return RESTRUCTURE_TYPE;
    }

    /**
     * 
     * @return returns the {@link #MAX_CONCURRENT_FILE_PROCESSING} number
     */
    public short getMAX_CONCURRENT_FILE_PROCESSING() {
        return MAX_CONCURRENT_FILE_PROCESSING;
    }

    /**
     * 
     * @return returns the {@link #ABSOLUTE_VALIDATOR_OPERATING_PATH}
     */
    public String getABSOLUTE_VALIDATOR_OPERATING_PATH() {
        return ABSOLUTE_VALIDATOR_OPERATING_PATH;
    }

    /**
     * 
     * @return returns the {@link #RELATIVE_XSDFILE_PATH}
     */
    public String getRELATIVE_XSDFILE_PATH() {
        return RELATIVE_XSDFILE_PATH;
    }

    /**
     * 
     * @return returns the {@link #RELATIVE_XMLFILES_PATH_ARRAY}
     */
    public String[] getRELATIVE_XMLFILES_PATH_ARRAY() {
        return RELATIVE_XMLFILES_PATH_ARRAY;
    }
    
}