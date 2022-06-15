package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesRestructure extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesRestructure(){
        super.setFULL_NAME("Restructure mode");
        super.setCALL_NAME_FULL("--restructure-type");
        super.setCALL_NAME_SHORT("-r");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(true);
        super.setCAN_HAVE_MULTIPLE_ARGUMENTS(false);
        super.setOPTIONAL(true);
    }
}