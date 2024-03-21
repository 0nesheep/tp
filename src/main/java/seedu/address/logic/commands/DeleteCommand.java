package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person identified by their unique ID in the displayed person list.\n"
            + "Parameters: Their unique ID, (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 000001"; // Will try to change to make sure it can be done without the 0s

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    public static final String MESSAGE_PERSON_NOT_FOUND = "This person does not exist in the address book";

    public static final String MESSAGE_POSITIVE_INTEGER_AND_ZERO = "The unique ID must be a positive integer and/or zero";

    private final int targetUniqueId;

    /**
     * Creates a DeleteCommand to delete the person with the specified unique ID.
     */
    public DeleteCommand(int targetUniqueId) {
        requireNonNull(targetUniqueId);
        this.targetUniqueId = targetUniqueId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        Person personToDelete = lastShownList.get(targetUniqueId - 1);
        if (targetUniqueId >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        if (targetUniqueId < 0) { // Positive integer or 0, should discuss
            throw new CommandException(MESSAGE_POSITIVE_INTEGER_AND_ZERO);
        }
        if (personToDelete == null) {
            throw new CommandException(MESSAGE_PERSON_NOT_FOUND);
        }
        model.deletePerson(personToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, Messages.format(personToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof DeleteCommand
                && targetUniqueId == ((DeleteCommand) other).targetUniqueId);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetUniqueId", targetUniqueId)
                .toString();
    }
}
