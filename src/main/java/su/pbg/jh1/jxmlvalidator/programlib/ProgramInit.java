package su.pbg.jh1.jxmlvalidator.programlib;

import su.pbg.jh1.jxmlvalidator.programlib.ValidatorRuntimeConfig;

public class ProgramInit {
    
    public static boolean programCalledwithSwitches(String[] initSwitches){
        if(initSwitches.length==0){
            return false;
        }
        return true;
    }
    
    public static ValidatorRuntimeConfig createProgramConfig(String[] initSwitches){
        ValidatorRuntimeConfig configBeingPopulated = ValidatorRuntimeConfig.getInstance();
        return configBeingPopulated;
    }
    
}