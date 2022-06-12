package su.pbg.jh1.jxmlvalidator.programlib;

/**
 * Restructure type definitions used to tell the program if or how a restructured file should be written.
 * 
 * @see DefinitionsRestructureTypes#NONE
 * @author Jaina Hanke <JainaO@yandex.com> <jh1@pbg.su>
 */
public abstract class DefinitionsRestructureTypes extends Definitions {
    
    /**
     * {@value DefinitionsRestructureTypes#NONE}
     */
    public static final byte NONE = 0;
    
    /**
     * {@value DefinitionsRestructureTypes#ONE_LINE}
     */
    public static final byte ONE_LINE = 1;
    
    /**
     * {@value DefinitionsRestructureTypes#CHILDLESS_LINE}
     */
    public static final byte CHILDLESS_LINE = 2;
    
    /**
     * {@value DefinitionsRestructureTypes#LINE_INDENT}
     */
    public static final byte LINE_INDENT = 3;
    
    /**
     * {@value DefinitionsRestructureTypes#STRICT_INDENT}
     */
    public static final byte STRICT_INDENT = 4;
    
    /**
     * {@value DefinitionsRestructureTypes#SPACED_ATTRIBUTE_BLOCKS}
     */
    public static final byte SPACED_ATTRIBUTE_BLOCKS= 5;
    
}
