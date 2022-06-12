package su.pbg.jh1.jxmlvalidator.programlib;

public class DefinitionsParamSwitchesConcurrency extends DefinitionsParamSwitches{
    
    DefinitionsParamSwitchesConcurrency(){
        super.setFULL_NAME("Filethreadlimit");
        super.setCALL_NAME_FULL("--concurrency-limit");
        super.setCALL_NAME_SHORT("-t");
        super.setNEEDS_ADDITIONAL_ARGUMENTS(true);
        super.setOPTIONAL(true);
    }
}