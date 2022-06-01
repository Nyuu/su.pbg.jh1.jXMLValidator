package su.pbg.jh1.jxmlvalidator.programlib;
/**
 *
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public class ValidatorRuntimeConfig {
    
    public final boolean DEBUG;
    public final boolean VERBOSE;
    
    public final byte RESTRUCTURE_MODE;
    
    public final short MAX_CONCURENT_FILE_PROCESSING;
    
    public final String ABSOLUTE_VALIDATOR_OPERATING_PATH;
    
    public final String RELATIVE_XSDFILE_PATH;
            
    public final String[] RELATIVE_XMLFILES_PATH_ARRAY;
    
    private ValidatorRuntimeConfig() {
    }
    
    public static ValidatorRuntimeConfig getInstance() {
        return ValidatorRuntimeConfigHolder.INSTANCE;
    }
    
    private static class ValidatorRuntimeConfigHolder {
        private static final ValidatorRuntimeConfig INSTANCE = new ValidatorRuntimeConfig();
    }
}
