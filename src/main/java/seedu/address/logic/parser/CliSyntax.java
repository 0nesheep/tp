package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("-name");
    public static final Prefix PREFIX_PHONE = new Prefix("-phone");
    public static final Prefix PREFIX_EMAIL = new Prefix("-email");
    public static final Prefix PREFIX_ADDRESS = new Prefix("-address");
    public static final Prefix PREFIX_ID = new Prefix("-id");
    public static final Prefix PREFIX_SUBJECT = new Prefix("-subject");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_STYLE = new Prefix("-style");
    public static final Prefix PREFIX_HOURS = new Prefix("-hours");
    public static final Prefix PREFIX_NOTES = new Prefix("-notes");
    public static final Prefix PREFIX_CONTENT = new Prefix("-content");

}
