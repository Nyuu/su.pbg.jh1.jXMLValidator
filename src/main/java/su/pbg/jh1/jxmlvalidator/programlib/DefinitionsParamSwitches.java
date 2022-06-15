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
     * With this attribute, we specify if the paramswitch just is a flag, or if it more and needs more arguments.
     */
    private boolean NEEDS_ADDITIONAL_ARGUMENTS;
    
    /**
     * With this attribute, we make sure that multi-argument paramswitches are evaluated correctly.
     */
    private boolean CAN_HAVE_MULTIPLE_ARGUMENTS;
    
    /**
     * With this attribute, we specify if the paramswitch is optional and if the program can function without it.
     */
    private boolean OPTIONAL;
    
    /**
     * 
     * @return returns the {@link #FULL_NAME} property.
     */
    public String getFULL_NAME() {
        return FULL_NAME;
    }
    
    /**
     * 
     * @return returns the {@link #CALL_NAME_FULL} property.
     */
    public String getCALL_NAME_FULL() {
        return CALL_NAME_FULL;
    }
    
    /**
     * 
     * @return returns the {@link #CALL_NAME_SHORT} property.
     */
    public String getCALL_NAME_SHORT() {
        return CALL_NAME_SHORT;
    }
    
    /**
     * 
     * @return returns the {@link #NEEDS_ADDITIONAL_ARGUMENTS} property.
     */
    public boolean isNEEDS_ADDITIONAL_ARGUMENTS() {
        return NEEDS_ADDITIONAL_ARGUMENTS;
    }
    
    /**
     * 
     * @return returns the {@link #CAN_HAVE_MULTIPLE_ARGUMENTS} property.
     */
    public boolean isCAN_HAVE_MULTIPLE_ARGUMENTS(){
        return CAN_HAVE_MULTIPLE_ARGUMENTS;
    }
    
    /**
     * 
     * @return returns the {@link #OPTIONAL} property.
     */
    public boolean isOPTIONAL() {
        return OPTIONAL;
    }
    
    /**
     * Sets the {@link #FULL_NAME} property.
     * @param FULL_NAME value to be set.
     */
    public void setFULL_NAME(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }
    
    /**
     * Sets the {@link #CALL_NAME_FULL} property.
     * @param CALL_NAME_FULL value to be set.
     */
    public void setCALL_NAME_FULL(String CALL_NAME_FULL) {
        this.CALL_NAME_FULL = CALL_NAME_FULL;
    }
    
    /**
     * Sets the {@link #CALL_NAME_SHORT} property.
     * @param CALL_NAME_SHORT value to be set.
     */
    public void setCALL_NAME_SHORT(String CALL_NAME_SHORT) {
        this.CALL_NAME_SHORT = CALL_NAME_SHORT;
    }
    
    /**
     * Sets the {@link #NEEDS_ADDITIONAL_ARGUMENTS} property.
     * @param NEEDS_ADDITIONAL_ARGUMENTS value to be set.
     */
    public void setNEEDS_ADDITIONAL_ARGUMENTS(boolean NEEDS_ADDITIONAL_ARGUMENTS) {
        this.NEEDS_ADDITIONAL_ARGUMENTS = NEEDS_ADDITIONAL_ARGUMENTS;
    }
    
    /**
     * Sets the {@link #CAN_HAVE_MULTIPLE_ARGUMENTS} property.
     * @param CAN_HAVE_MULTIPLE_ARGUMENTS value to be set.
     */
    public void setCAN_HAVE_MULTIPLE_ARGUMENTS(boolean CAN_HAVE_MULTIPLE_ARGUMENTS){
        this.CAN_HAVE_MULTIPLE_ARGUMENTS = CAN_HAVE_MULTIPLE_ARGUMENTS;
    }
    
    /**
     * Sets the {@link #OPTIONAL} property.
     * @param OPTIONAL value to be set.
     */
    public void setOPTIONAL(boolean OPTIONAL) {
        this.OPTIONAL = OPTIONAL;
    }
}