package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesConformity extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesConformity(){
        super.setFULL_NAME("Conformitycheck mode");
        super.setCALL_NAME_FULL("--conformity");
        super.setCALL_NAME_SHORT("-c");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(false);
        super.setCAN_HAVE_MULTIPLE_ARGUMENTS(false);
        super.setOPTIONAL(true);
    }
}