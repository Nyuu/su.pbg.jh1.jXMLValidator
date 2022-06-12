package su.pbg.jh1.jxmlvalidator.programlib;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashSet;
//Import from same package done for better readability and understanding ^^
import su.pbg.jh1.jxmlvalidator.programlib.ValidatorRuntimeConfig;

public class ProgramInit {
    
    public static ValidatorRuntimeConfig createProgramConfig(String[] initSwitches){
        ValidatorRuntimeConfig configBeingPopulated = ValidatorRuntimeConfig.getInstance();
        return configBeingPopulated;
    }
    
    public static boolean programCalledWithAllNecessarySwitches(String[] initSwitches){
        int requiredParamSwitches = getRequiredParamSwitches().size();
        int calledRequiredParamSwitches = 0;
        for(int i = 0; i < initSwitches.length; i++){
            if(isDefinedParamSwitch(initSwitches[i])){
                if(!getParamSwitchByFullName(getMatchedParamSwitchFullName(initSwitches[i])).isOPTIONAL()){
                    ++calledRequiredParamSwitches;
                }
            }
        }
        return (requiredParamSwitches == calledRequiredParamSwitches);
    }
    
    public static boolean programCalledWithSwitches(String[] initSwitches){
        if(initSwitches.length==0){
            return false;
        }
        return true;
    }
    
    public static boolean providedParamSwitchesIsValid(String[] initSwitches){
        //If the first provided Element isn't a valid paramswitch, the program was not called correctly so we can quit right away ^^
        if(!couldBeParamSwitch(initSwitches[0])){
            return false;
        }
        HashSet<String> providedParamSwitches = new HashSet<>();
        for(int i = 0; i < initSwitches.length; i++){
            if(isDefinedParamSwitch(initSwitches[i])){
                if(providedParamSwitches.contains(getMatchedParamSwitchFullName(initSwitches[i]))){
                    return false;
                }
                providedParamSwitches.add(getMatchedParamSwitchFullName(initSwitches[i]));
            }
        }
        return true;
    }
    
    public static boolean providedParamSwitchesIsSane(String[] initSwitches){
        for(int i = 0; i < initSwitches.length; i++){
            if(isDefinedParamSwitch(initSwitches[i])){
                if(getParamSwitchByFullName(getMatchedParamSwitchFullName(initSwitches[i])).isNEEDS_ADDITIONAL_ARGUMENTS()){
                    if(initSwitches.length <= (i+1)){
                        return false;
                    }
                    if(isDefinedParamSwitch(initSwitches[i+1])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean isDefinedParamSwitch(String isolatedParamSwitchArrayElement){
        if(!(couldBeParamSwitch(isolatedParamSwitchArrayElement))){
            return false;
        }
        return (getMatchedParamSwitchFullName(isolatedParamSwitchArrayElement) != null);
    }
    
    private static String getMatchedParamSwitchFullName(String isolatedParamSwitchArrayElement){
        ArrayList<DefinitionsParamSwitches> currentDefinedValidParamSwitches = getDefinedParamSwitches();
        for(DefinitionsParamSwitches currentlyIteratedParamSwitch : currentDefinedValidParamSwitches){
            if((currentlyIteratedParamSwitch.getCALL_NAME_FULL().equals(isolatedParamSwitchArrayElement)) || (currentlyIteratedParamSwitch.getCALL_NAME_SHORT().equals(isolatedParamSwitchArrayElement))){
                return currentlyIteratedParamSwitch.getFULL_NAME();
            }
        }
        return null;
    }
    
    private static DefinitionsParamSwitches getParamSwitchByFullName(String fullNameOfParamSwitch){
        ArrayList<DefinitionsParamSwitches> currentDefinedValidParamSwitches = getDefinedParamSwitches();
        for(DefinitionsParamSwitches currentlyIteratedParamSwitch : currentDefinedValidParamSwitches){
            if(currentlyIteratedParamSwitch.getFULL_NAME().equals(fullNameOfParamSwitch)){
                return currentlyIteratedParamSwitch;
            }
        }
        return null;
    }

    private static boolean couldBeParamSwitch(String isolatedParamSwitchArrayElement){
        if(!(isolatedParamSwitchArrayElement.length() >= 2)){
            return false;
        }
        return (isolatedParamSwitchArrayElement.charAt(0) == '-');
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
    
    private static ArrayList<DefinitionsParamSwitches> getRequiredParamSwitches(){
        ArrayList<DefinitionsParamSwitches> currentDefinedValidParamSwitches = getDefinedParamSwitches();
        ArrayList<DefinitionsParamSwitches> requiredParamSwitches = new ArrayList<>();
        
        for(DefinitionsParamSwitches currentlyIteratedParamSwitch : currentDefinedValidParamSwitches){
            if(!currentlyIteratedParamSwitch.isOPTIONAL()){
                requiredParamSwitches.add(0, currentlyIteratedParamSwitch);
            }
        }
        return requiredParamSwitches;
    }
}