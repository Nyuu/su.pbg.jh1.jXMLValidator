package su.pbg.jh1.jxmlvalidator;

import su.pbg.jh1.jxmlvalidator.programlib.DefinitionsExitCodes;
import su.pbg.jh1.jxmlvalidator.programlib.Helper;
import su.pbg.jh1.jxmlvalidator.programlib.ProgramInit;
import su.pbg.jh1.jxmlvalidator.programlib.ValidatorRuntimeConfig;

/**
 * The class containing the main method, starting the program and, if necessary, terminating it.
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public class XMLValidator {

    static ValidatorRuntimeConfig validatorConfig;

    /**
     * Entry point for starting the XMLValidator program.
     * Should exit with code 0 for {@link su.pbg.jh1.jxmlvalidator.programlib.DefinitionsExitCodes#SUCCESS SUCCESS} when the application finished with the expected tasks successfully.
     * For other exit codes see class {@link su.pbg.jh1.jxmlvalidator.programlib.DefinitionsExitCodes DefinitionsExitCodes}.
     * @param initSwitches An array containing all the arguments (parameters and switches) with which the program was called.
     */
    public static void main(String[] initSwitches) {
        if (ProgramInit.programCalledWithHelpSwitch(initSwitches)) {
            System.out.println(new Helper().getHelp());
            terminateProgramWithExitCode(DefinitionsExitCodes.SUCCESS);
        }

        checkParamSwitchesRoutine(initSwitches);
        //validatorConfig = ProgramInit.createProgramConfig(initSwitches);
        terminateProgramWithExitCode(DefinitionsExitCodes.SUCCESS);
    }

    private static void checkParamSwitchesRoutine(String[] initSwitches){
        if(!ProgramInit.programCalledWithSwitches(initSwitches)){
            terminateProgramForeseeable(DefinitionsExitCodes.NO_PARAM_SWITCHES_PROVIDED_ERROR, "No parameters/switches specified. The program will terminate.");
        }

        if(!ProgramInit.providedParamSwitchesIsValid(initSwitches)){
            terminateProgramForeseeable(DefinitionsExitCodes.INVALID_PARAM_SWITCHES_PROVIDED_ERROR, "An invalid parameter/switch was provided. The program will terminate.");
        }

        if(!ProgramInit.providedParamSwitchesIsSane(initSwitches)){
            terminateProgramForeseeable(DefinitionsExitCodes.ADDITIONAL_PARAM_ARGUMENTS_ERROR, "A parameter was expecting more arguments or you provided too much arguments to a single argument parameter. The program will terminate.");
        }

        if(!ProgramInit.programCalledWithAllNecessarySwitches(initSwitches)){
            terminateProgramForeseeable(DefinitionsExitCodes.GENERIC_FORESEEABLE_ERROR, "Not all necessary parameters for the program start were provided");
        }
    }

    /**
     *
     * Implicitly calls {@link #terminateProgramWithExitCode(byte) }after writing to stderr
     * @param exitCode
     * @param stderrMessage
     */
    private static void terminateProgramForeseeable(byte exitCode, String stderrMessage){
        terminateProgramWithMessage(exitCode, stderrMessage);
    }

    /**
     *
     * Implicitly calls {@link #terminateProgramWithExitCode(byte) }after writing to stderr
     * @param exitCode
     * @param stderrMessage
     */
    private static void terminateProgramUnforeseeable(byte exitCode, String stderrMessage){
        terminateProgramWithMessage(exitCode, stderrMessage);
    }

    /**
     *
     * Implicitly calls {@link #terminateProgramWithExitCode(byte) }after writing to stderr
     * @param exitCode
     * @param stderrMessage
     */
    private static void terminateProgramWithMessage(byte exitCode, String stderrMessage){
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