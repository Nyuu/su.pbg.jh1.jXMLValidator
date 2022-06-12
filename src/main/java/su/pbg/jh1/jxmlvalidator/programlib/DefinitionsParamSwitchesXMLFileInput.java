package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesXMLFileInput extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesXMLFileInput(){
        super.setFULL_NAME("XML paths");
        super.setCALL_NAME_FULL("--input-files");
        super.setCALL_NAME_SHORT("-i");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(true);
        super.setOPTIONAL(false);
    }
}