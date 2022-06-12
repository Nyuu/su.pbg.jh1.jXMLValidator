package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesVerbose extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesVerbose(){
        super.setFULL_NAME("Verbose mode");
        super.setCALL_NAME_FULL("--verbose");
        super.setCALL_NAME_SHORT("-v");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(false);
        super.setOPTIONAL(true);
    }
}