package su.pbg.jh1.jxmlvalidator.programlib;
/**
 *
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public class ValidatorRuntimeConfig {
    /**
     * The debug flag, giving excessive output to stdout.
     * Implicitly sets the verbose flag.
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
     * {@see}
     */
    private byte RESTRUCTURE_TYPE;
    
    private short MAX_CONCURENT_FILE_PROCESSING;
    
    private String ABSOLUTE_VALIDATOR_OPERATING_PATH;
    
    private String RELATIVE_XSDFILE_PATH;
            
    private String[] RELATIVE_XMLFILES_PATH_ARRAY;
    
    
    
    void setConfigOptions(boolean debug,
            boolean verbose,
            boolean verify,
            byte restructureMode,
            short maxConcurentFileProcessing,
            String validatorPathAbsolute,
            String xsdFilePathRelative,
            String[] xmlFilesPathArrayRelative)
    {
        this.DEBUG_MODE = debug;
        this.VERBOSE_MODE = verbose;
        this.VERIFY_MODE = verify;
        this.MAX_CONCURENT_FILE_PROCESSING = maxConcurentFileProcessing;
        this.ABSOLUTE_VALIDATOR_OPERATING_PATH = validatorPathAbsolute;
        this.RELATIVE_XSDFILE_PATH = xsdFilePathRelative;
        this.RELATIVE_XMLFILES_PATH_ARRAY = xmlFilesPathArrayRelative;
    }
    
    private ValidatorRuntimeConfig() {
    }
    
    public static ValidatorRuntimeConfig getInstance() {
        return ValidatorRuntimeConfigHolder.INSTANCE;
    }
    
    private static class ValidatorRuntimeConfigHolder {
        private static final ValidatorRuntimeConfig INSTANCE = new ValidatorRuntimeConfig();
    }
    
    public boolean isDEBUG_MODE() {
        return DEBUG_MODE;
    }

    public boolean isVERBOSE_MODE() {
        return VERBOSE_MODE;
    }

    public boolean isVERIFY_MODE() {
        return VERIFY_MODE;
    }

    public byte getRESTRUCTURE_TYPE() {
        return RESTRUCTURE_TYPE;
    }

    public short getMAX_CONCURENT_FILE_PROCESSING() {
        return MAX_CONCURENT_FILE_PROCESSING;
    }

    public String getABSOLUTE_VALIDATOR_OPERATING_PATH() {
        return ABSOLUTE_VALIDATOR_OPERATING_PATH;
    }

    public String getRELATIVE_XSDFILE_PATH() {
        return RELATIVE_XSDFILE_PATH;
    }

    public String[] getRELATIVE_XMLFILES_PATH_ARRAY() {
        return RELATIVE_XMLFILES_PATH_ARRAY;
    }
    
}
