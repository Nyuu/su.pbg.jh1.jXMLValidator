package su.pbg.jh1.jxmlvalidator.programlib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * Utility class with functions for the program initialisation.
 * Here parameter switch logic is done, the runtime configuration is created/populated and some sanity checking is done.
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public class ProgramInit {
    
    public static ValidatorRuntimeConfig createProgramConfig(String[] initSwitches){
        ValidatorRuntimeConfig configBeingPopulated = ValidatorRuntimeConfig.getInstance();
        
        
        
        
        
        
        
        return configBeingPopulated;
    }
    
    /**
     * Quick check to see if program got called with any arguments (paramswitches).
     * @param initSwitches paramswitch array from program call.
     * @return TRUE if any arguments were provided<br/>FALSE if no arguments were provided.
     */
    public static boolean programCalledWithSwitches(String[] initSwitches){
        return initSwitches.length != 0;
    }
    
    /**
     * Thorough check to prevent duplicates and to see if the provided paramswitches are valid as defined.
     * @param initSwitches paramswitch array from program call.
     * @return TRUE if all paramswitches are valid as defined and no duplicates were found<br/>FALSE if at least one duplicate or a non-defined paramswitch was found.
     */
    public static boolean providedParamSwitchesIsValid(String[] initSwitches){
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
    
    
    /**
     * Thorough check against definitions to see if paramswitches that need additional arguments have them and in correct numbers.
     * @param initSwitches paramswitch array from program call.
     * @return TRUE if all paramswitches are sane<br/>FALSE if at least one paramswitch is not sane.
     */
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
                    if(!getParamSwitchByFullName(getMatchedParamSwitchFullName(initSwitches[i])).isCAN_HAVE_MULTIPLE_ARGUMENTS()){
                        if(!(initSwitches.length <= (i+2))){
                            if(!isDefinedParamSwitch(initSwitches[i+2])){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * Check against defined mandatory paramswitches to see if they are contained in initSwitches[].
     * @param initSwitches paramswitch array from program call.
     * @return TRUE if all defined mandatory paramswitches are provided<br/>FALSE if at least one mandatory paramswitch is missing.
     */
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
    
    /**
     * Thorough check by lookup, if the provided String is a valid, defined paramswitch.
     * @param isolatedParamSwitchArrayElement String element from initSwitches[].
     * @return TRUE if the provided String element is a valid, defined paramswitch<br/>FALSE if the provided String element is not a valid, defined paramswitch.
     */
    private static boolean isDefinedParamSwitch(String isolatedParamSwitchArrayElement){
        if(!(couldBeParamSwitch(isolatedParamSwitchArrayElement))){
            return false;
        }
        return (getMatchedParamSwitchFullName(isolatedParamSwitchArrayElement) != null);
    }
    
    /**
     * Quick check if the provided String could be a paramswitch.
     * @param isolatedParamSwitchArrayElement String element from initSwitches[].
     * @return TRUE if the String looks like it could be a paramswitch<br/>FALSE if it does not look like a paramswitch.
     */
    private static boolean couldBeParamSwitch(String isolatedParamSwitchArrayElement){
        if(!(isolatedParamSwitchArrayElement.length() >= 2)){
            return false;
        }
        return (isolatedParamSwitchArrayElement.charAt(0) == '-');
    }
    
    /**
     * Gets the associated paramswitch {@link DefinitionsParamSwitches#FULL_NAME} from the provided String.
     * @param paramSwitchArrayElement Expects either {@link DefinitionsParamSwitches#CALL_NAME_FULL} or {@link DefinitionsParamSwitches#CALL_NAME_SHORT} String for a paramswitch.
     * @return NULL if associating a FULL_NAME to the provided String failed.<br/>FULL_NAME associated with the provided paramSwitchArrayElement from the paramswitch definitions.
     */
    private static String getMatchedParamSwitchFullName(String paramSwitchArrayElement){
        List<DefinitionsParamSwitches> currentDefinedValidParamSwitches = getDefinedParamSwitches();
        for(DefinitionsParamSwitches currentlyIteratedParamSwitch : currentDefinedValidParamSwitches){
            if((currentlyIteratedParamSwitch.getCALL_NAME_FULL().equals(paramSwitchArrayElement)) || (currentlyIteratedParamSwitch.getCALL_NAME_SHORT().equals(paramSwitchArrayElement))){
                return currentlyIteratedParamSwitch.getFULL_NAME();
            }
        }
        return null;
    }
    
    /**
     * Gets the associated paramswitch object from the provided {@link DefinitionsParamSwitches#FULL_NAME} String.
     * @param fullNameOfParamSwitch
     * @return NULL if associating a paramSwitch to the provided FULL_NAME is not possible<br/>{@link DefinitionsParamSwitches} associated with the provided full name.
     */
    private static DefinitionsParamSwitches getParamSwitchByFullName(String fullNameOfParamSwitch){
        List<DefinitionsParamSwitches> currentDefinedValidParamSwitches = getDefinedParamSwitches();
        for(DefinitionsParamSwitches currentlyIteratedParamSwitch : currentDefinedValidParamSwitches){
            if(currentlyIteratedParamSwitch.getFULL_NAME().equals(fullNameOfParamSwitch)){
                return currentlyIteratedParamSwitch;
            }
        }
        return null;
    }
    
    /**
     * Get a list containing all mandatory paramswitches as defined.
     * @return {@link java.util.List} with {@link DefinitionsParamSwitches} elements.
     */
    private static List<DefinitionsParamSwitches> getRequiredParamSwitches(){
        List<DefinitionsParamSwitches> currentDefinedValidParamSwitches = getDefinedParamSwitches();
        List<DefinitionsParamSwitches> requiredParamSwitches = new ArrayList<>();
        
        for(DefinitionsParamSwitches currentlyIteratedParamSwitch : currentDefinedValidParamSwitches){
            if(!currentlyIteratedParamSwitch.isOPTIONAL()){
                requiredParamSwitches.add(0, currentlyIteratedParamSwitch);
            }
        }
        return requiredParamSwitches;
    }
    
    /**
     * Get a list containing all defined paramswitches.
     * @return {@link java.util.List} with {@link DefinitionsParamSwitches} elements.
     */
     static List<DefinitionsParamSwitches> getDefinedParamSwitches(){
        List<DefinitionsParamSwitches> currentDefinedValidParamSwitches = new ArrayList<>();

        currentDefinedValidParamSwitches.add(0, new DefinitionsParamSwitchesHelp());
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

    public static boolean programCalledWithHelpSwitch(String[] initSwitches) {
        DefinitionsParamSwitchesHelp help = new DefinitionsParamSwitchesHelp();
        String fullName = help.getCALL_NAME_FULL();
        String shortName = help.getCALL_NAME_SHORT();
        return Stream.of(initSwitches).anyMatch(s -> fullName.equals(s) || shortName.equals(s));
    }
}