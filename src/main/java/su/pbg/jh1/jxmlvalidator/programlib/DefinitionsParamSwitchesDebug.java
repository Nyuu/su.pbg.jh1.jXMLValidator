package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesDebug extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesDebug(){
        super.setFULL_NAME("Debug mode");
        super.setCALL_NAME_FULL("--debug");
        super.setCALL_NAME_SHORT("-d");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(false);
        super.setCAN_HAVE_MULTIPLE_ARGUMENTS(false);
        super.setOPTIONAL(true);
    }
}