package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum AccountType {
    CURRENT_ACCOUNT,
    SAVINGS_ACCOUNT,
    CREDIT_CARD,
    PREPAID_ACCOUNT,
    PENSION,
    INVESTMENT,
    UNKNOWN;

    @JsonCreator
    public static AccountType fromString(final String stringValue) {
        try {
            return valueOf(stringValue);
        } catch (IllegalArgumentException e) {
            log.warn("Unrecognized enum: {}", stringValue);
            return UNKNOWN;
        }
    }
}
