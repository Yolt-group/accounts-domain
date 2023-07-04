package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum AccountStatusCode {

    TRANSACTIONS_EXPECTED("Transactions are expected for this account. They should arrive within a minute or so."),
    PROCESSING_TRANSACTIONS_FINISHED("New transactions were successfully added."),
    PROCESSING_TRANSACTIONS_FAILED("New transactions could not be added."),
    PROCESSING_TRANSACTIONS_TIMED_OUT("It took too long to process the transactions."),
    UNSUPPORTED_TYPE("The account is of an unsupported type. Transactions will not be processed."),
    DATASCIENCE_EXPECTED("Datascience is asked to do it's number-crunching. New data expected soon."),
    DATASCIENCE_FINISHED("Datascience has crunched the numbers. All is up to date."),
    DATASCIENCE_FAILED("Datascience failed to crunch the numbers."),
    DATASCIENCE_TIMED_OUT("It took too long for datascience to crunch the nubers."),
    UNKNOWN("We could not determine the status."),
    DELETING("This account is being deleted."),
    DELETED("This account is deleted."),
    HIDDEN("This account is currently not visible for the user. It is excluded from any calculations."),
    UNHIDDEN("This account has just been un-hidden and will be updated on next refresh.");

    final String description;

    AccountStatusCode(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name(), description);
    }

    @JsonCreator
    public static AccountStatusCode fromString(final String stringValue) {
        try {
            return valueOf(stringValue);
        } catch (IllegalArgumentException e) {
            log.warn("Unrecognized enum: {}", stringValue);
            return UNKNOWN;
        }
    }

    /**
     * Returns true if the AccountStatusCode's value means the account is active and can be displayed.
     *
     * @return true if the account is active.
     */
    @JsonIgnore
    public boolean accountStatusOkay() {
        switch (this) {
            case DELETED:
            case HIDDEN:
            case UNSUPPORTED_TYPE:
            case DELETING:
                return false;
            default:
                return true;
        }
    }

}
