package su.pbg.jh1.jxmlvalidator.programlib;

import java.util.stream.Collectors;

public class Helper {

    private static final String HELP_LINE_FORMAT = "%1$2s, %2$-25s %3$1s";

    public String getHelp() {
        return ProgramInit.getDefinedParamSwitches().stream()
                .map(this::mapToHelpLine)
                .collect(Collectors.joining("\n"));
    }

    private String mapToHelpLine(DefinitionsParamSwitches definition) {
        return String.format(HELP_LINE_FORMAT,
                definition.getCALL_NAME_SHORT(),
                definition.getCALL_NAME_FULL(),
                definition.getFULL_NAME());
    }
}
