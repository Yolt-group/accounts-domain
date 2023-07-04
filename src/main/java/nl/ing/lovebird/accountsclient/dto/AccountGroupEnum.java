package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum AccountGroupEnum {
    CURRENT_ACCOUNT,
    CREDIT_CARD,
    SAVINGS_ACCOUNT,
    PREPAID_ACCOUNT,
    FOREIGN_CURRENCY,
    PENSION,
    INVESTMENT,
    UNKNOWN;

    @JsonCreator
    public static AccountGroupEnum fromString(final String stringValue) {
        try {
            return valueOf(stringValue);
        } catch (IllegalArgumentException e) {
            log.warn("Unrecognized enum: {}", stringValue);
            return UNKNOWN;
        }
    }

}
