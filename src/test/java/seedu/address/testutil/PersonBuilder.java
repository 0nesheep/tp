package seedu.address.testutil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Exam;
import seedu.address.model.person.Id;
import seedu.address.model.person.Log;
import seedu.address.model.person.LogList;
import seedu.address.model.person.Name;
import seedu.address.model.person.Payment;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Subject;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy See";
    public static final String DEFAULT_PHONE = "85355233";
    public static final String DEFAULT_EMAIL = "amysee@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 9, #08-111";
    public static final String DEFAULT_SUBJECT = "Math";
    public static final String DEAFULT_UNIQUEID = "12";
    public static final String DEAFULT_PAYMENT = "0.0";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private Subject subject;
    private Id uniqueId;
    private Set<Exam> exams;
    private Payment payment;
    //private Set<Exam> exams;
    private LogList logs;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        subject = new Subject(DEFAULT_SUBJECT);
        uniqueId = new Id(DEAFULT_UNIQUEID);
        exams = new HashSet<>();
        payment = new Payment(0.0);
        logs = new LogList(new ArrayList<>());
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        subject = personToCopy.getSubject();
        uniqueId = personToCopy.getUniqueId();
        exams = new HashSet<>(personToCopy.getExams());
        payment = personToCopy.getPayment();
        logs = new LogList(personToCopy.getLogs().getList());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Subject} of the {@code Person} that we are building.
     */
    public PersonBuilder withSubject(String subject) {
        this.subject = new Subject(subject);
        return this;
    }

    /**
     * Sets the {@code UniqueId} of the {@code Person} that we are building.
     */
    public PersonBuilder withUniqueId(String uniqueId) {
        this.uniqueId = new Id(uniqueId);
        return this;
    }

    /**
     * Parses the {@code exams} into a {@code Set<Exam>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withExams(Set<Exam> exams) {
        this.exams = new HashSet<>(exams); // Copy to ensure encapsulation
        return this;
    }

    /**
     * Sets the exams for the person being built using the provided array of exams.
     *
     * @param exams The exams to be associated with the person being built.
     * @return This {@code PersonBuilder} instance with the specified exams added.
     */
    public PersonBuilder withExams(Exam ... exams) {
        this.exams = SampleDataUtil.getSampleExams();
        return this;
    }

    /**
     * Sets the {@code Payment} of the {@code Person} that we are building.
     */
    public PersonBuilder withPayment(String payment) {
        this.payment = new Payment(payment);
        return this;
    }

    /**
     * Sets the {@code Payment} of the {@code Person} that we are building.
     */
    public PersonBuilder withPayment(Double payment) {
        this.payment = new Payment(payment);
        return this;
    }

    /**
     * Sets the logs for the person being built using the provided array of logs.
     *
     * @param logs The logs to be associated with the person being built.
     * @return This {@code PersonBuilder} instance with the specified logs added.
     */
    public PersonBuilder withLogs(Log ... logs) {
        this.logs = SampleDataUtil.getSampleLogs();
        return this;
    }

    /*public PersonBuilder withLogs(Log... newLogs) {
        List<Log> logList = Arrays.asList(newLogs);
        this.logs = new LogList(logList);
        return this;
    }*/

    /**
     * Sets the {@code LogList} of the {@code Person} that we are building to an empty list.
     */
    public PersonBuilder withEmptyLogs() {
        this.logs = new LogList(new ArrayList<>()); // Or use Collections.emptyList() if immutable list is preferred
        return this;
    }
    /**
     * Builds the person.
     */
    public Person build() {
        return new Person(name, phone, email, address, tags, subject, uniqueId, exams, payment, logs);
    }

}
