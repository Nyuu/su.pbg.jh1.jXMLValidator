package su.pbg.jh1.jxmlvalidator.programlib;

//Import from same package done for better readability and understanding ^^
import java.util.ArrayList;
import su.pbg.jh1.jxmlvalidator.programlib.ValidatorRuntimeConfig;

public class ProgramInit {
    
    public static boolean programCalledWithSwitches(String[] initSwitches){
        if(initSwitches.length==0){
            return false;
        }
        return true;
    }
    
    public static boolean providedParamSwitchesIsValid(String[] initSwitches){
        
        boolean providedDebug = false;
        boolean providedVerbose = false;
        boolean providedVerify = false;
        boolean providedConformity = false;
        
        boolean providedRestructure = false;
        boolean providedConcurrency = false;
        boolean providedXSD = false;
        boolean providedXML = false;
        
        //If the first provided Element isn't a valid paramswitch, the program was not called correctly so we can quit right away ^^
        if(couldBeParamSwitch(initSwitches[0])){
            return false;
        }
        for(int i = 0; i > initSwitches.length; i++){
            
            
            
            
            
            
            
            
        }
        
        return false;
    }
    
    
    /*public static boolean providedParamSwitchesIsSane(String[] initSwitches){
        if(true){
            return false;
        }
        return true;
    }*/
    
    private static boolean couldBeLongParamSwitch(String isolatedParamSwitchArrayElement){
        if(!(isolatedParamSwitchArrayElement.length() >= 3)){
            return false;
        }
        if(isolatedParamSwitchArrayElement.charAt(1) == '-'){
            return true;
        }
        return false;
    }
    
    private static boolean couldBeParamSwitch(String isolatedParamSwitchArrayElement){
        if(!(isolatedParamSwitchArrayElement.length() >= 2)){
            return false;
        }
        if(isolatedParamSwitchArrayElement.charAt(0) == '-'){
            return true;
        }
        return false;
    }
    
    public static ValidatorRuntimeConfig createProgramConfig(String[] initSwitches){
        ValidatorRuntimeConfig configBeingPopulated = ValidatorRuntimeConfig.getInstance();
        return configBeingPopulated;
    }
    
    private static ArrayList<DefinitionsParamSwitches> getDefinedParamSwitches(){
        ArrayList<DefinitionsParamSwitches> currentDefinedValidParamSwitches = new ArrayList<>();
        
        
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesDebug());
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesVerbose());
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesVerify());
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesConformity());
        
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesRestructure());
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesConcurrency());
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesXSDFileInput());
        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesXMLFileInput());
        
        return currentDefinedValidParamSwitches;
    }
}