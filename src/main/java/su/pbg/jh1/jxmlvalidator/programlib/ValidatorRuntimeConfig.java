package su.pbg.jh1.jxmlvalidator.programlib;
/**
 *
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public class ValidatorRuntimeConfig {
    
    private boolean DEBUG_MODE;
    private boolean VERBOSE_MODE;
    private boolean VERIFY_MODE;
    private byte RESTRUCTURE_MODE;
    
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

    public byte getRESTRUCTURE_MODE() {
        return RESTRUCTURE_MODE;
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
