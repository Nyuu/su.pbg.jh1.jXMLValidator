package su.pbg.jh1.jxmlvalidator;

import su.pbg.jh1.jxmlvalidator.programlib.ProgramInit;
import su.pbg.jh1.jxmlvalidator.programlib.ValidatorRuntimeConfig;
import su.pbg.jh1.jxmlvalidator.programlib.DefinitionsExitCodes;

/**
 * The class containing the main method, starting the program and, if necessary, terminating it.
 * @author Jaina Hanke
 */
public class XMLValidator {
    
    static ValidatorRuntimeConfig validatorConfig;
    
    /**
     * Entry point for starting the XMLValidator program.
     * Should exit with code 0 for {@link su.pbg.jh1.jxmlvalidator.programlib.DefinitionsExitCodes#SUCCESS SUCCESS} when the application finished with the expected tasks successfully.
     * For other exit codes see class {@link su.pbg.jh1.jxmlvalidator.programlib.DefinitionsExitCodes DefinitionsExitCodes}.
     * @param initSwitches An array containing all the parameters and switches with which the program was called.
     */
    public static void main(String[] initSwitches) {
        
        if(!ProgramInit.programCalledWithSwitches(initSwitches)){
            terminateProgramForeseeable(DefinitionsExitCodes.GENERIC_FORESEEABLE_ERROR, "No parameters/switches specified. Program will terminate");
        }
        
        validatorConfig = ProgramInit.createProgramConfig(initSwitches);
        
        terminateProgramWithExitCode(DefinitionsExitCodes.SUCCESS);
    }
    
    /**
     * 
     * Implicitly calls {@link #terminateProgramWithExitCode(byte) }after writing to stderr
     * @param exitCode
     * @param stderrMessage 
     */
    private static void terminateProgramForeseeable(byte exitCode, String stderrMessage){
        System.err.println(stderrMessage);
        terminateProgramWithExitCode(exitCode);
    }
    
    /**
     * Terminates the program
     * @param exitCode 
     */
    private static void terminateProgramWithExitCode(byte exitCode){
        System.exit(exitCode);
    }
}