package su.pbg.jh1.jxmlvalidator.programlib;

/**
 * Lays out the properties for paramswitches to help check if the program was called in a sane state.
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public abstract class DefinitionsParamSwitches extends Definitions{
    
    /**
     * The full name of the paramswitch used in the documentation and in outputs.
     */
    private String FULL_NAME;
    
    /**
     * The full call name of the paramswitch.
     */
    private String CALL_NAME_FULL;
    
    /**
     * The short call name of the paramswitch or "handle".
     */
    private String CALL_NAME_SHORT;
    
    /**
     * With this attribute, we specify if the paramswitch just sets a flag, or if it does more complex things.
     */
    private boolean NEEDS_ADDITIONAL_ARGUMENTS;
    
    /**
     * With this attribute, we specify if the paramswitch is optional and if the program can function without it.
     */
    private boolean OPTIONAL;

    public String getFULL_NAME() {
        return FULL_NAME;
    }

    public String getCALL_NAME_FULL() {
        return CALL_NAME_FULL;
    }

    public String getCALL_NAME_SHORT() {
        return CALL_NAME_SHORT;
    }

    public boolean isNEEDS_ADDITIONAL_ARGUMENTS() {
        return NEEDS_ADDITIONAL_ARGUMENTS;
    }

    public boolean isOPTIONAL() {
        return OPTIONAL;
    }

    public void setFULL_NAME(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }

    public void setCALL_NAME_FULL(String CALL_NAME_FULL) {
        this.CALL_NAME_FULL = CALL_NAME_FULL;
    }

    public void setCALL_NAME_SHORT(String CALL_NAME_SHORT) {
        this.CALL_NAME_SHORT = CALL_NAME_SHORT;
    }

    public void setNEEDS_ADDITIONAL_ARGUMENTS(boolean NEEDS_ADDITIONAL_ARGUMENTS) {
        this.NEEDS_ADDITIONAL_ARGUMENTS = NEEDS_ADDITIONAL_ARGUMENTS;
    }

    public void setOPTIONAL(boolean OPTIONAL) {
        this.OPTIONAL = OPTIONAL;
    }
}