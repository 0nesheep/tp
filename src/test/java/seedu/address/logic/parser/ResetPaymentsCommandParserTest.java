package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ResetPaymentsCommand;
import seedu.address.model.person.Id;

public class ResetPaymentsCommandParserTest {

    private ResetPaymentsCommandParser parser = new ResetPaymentsCommandParser();

    @Test
    public void parse_validArgs_returnsResetPaymentsCommand() {
        assertParseSuccess(parser, " -id 000003",
                new ResetPaymentsCommand(new Id("000003")));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, " -id ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ResetPaymentsCommand.MESSAGE_USAGE));

        assertParseFailure(parser, " -id 000003 extra-arg",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ResetPaymentsCommand.MESSAGE_USAGE));

        assertParseFailure(parser, " -id abc",
                Id.MESSAGE_CONSTRAINTS);
    }
}
