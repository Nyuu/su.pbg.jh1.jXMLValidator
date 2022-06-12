package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesXSDFileInput extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesXSDFileInput(){
        super.setFULL_NAME("XSD path");
        super.setCALL_NAME_FULL("--schema-path");
        super.setCALL_NAME_SHORT("-s");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(true);
        super.setOPTIONAL(true);
    }
}