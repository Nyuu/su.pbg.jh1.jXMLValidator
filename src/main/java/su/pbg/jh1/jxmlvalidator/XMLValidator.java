package su.pbg.jh1.jxmlvalidator;

import su.pbg.jh1.jxmlvalidator.programlib.ProgramInit;
import su.pbg.jh1.jxmlvalidator.programlib.ValidatorRuntimeConfig;
import su.pbg.jh1.jxmlvalidator.programlib.ExitCode;
/**
 * The class containing the main method, starting the program.
 * @author Jaina Hanke
 */
public class XMLValidator {
    
    static ValidatorRuntimeConfig validatorConfig;
    /**
     * Entry point for starting the XMLValidator program.
     * Should exit with code 0 for {@link su.pbg.jh1.jxmlvalidator.programlib.ExitCode#SUCCESS SUCCESS} when the application finished with the expected tasks successfully.
     * For other exit codes see class {@link su.pbg.jh1.jxmlvalidator.programlib.ExitCode ExitCode}.
     * @param initSwitches An array containing all the parameters and switches with which the program was called.
     */
    public static void main(String[] initSwitches) {
        if(!ProgramInit.programCalledwithSwitches(initSwitches)){
            System.err.println("No parameters/switches specified. Program will terminate");
            System.exit(ExitCode.GENERIC_FORESEEABLE_ERROR);
        }
        
        validatorConfig = ProgramInit.createProgramConfig(initSwitches);
        
        System.exit(ExitCode.SUCCESS);
    }

}