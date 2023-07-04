package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountNumberDTO {
    /**
     * Legal name of account holder; e.g. "Samuel Martha Smith".
     */
    private final String holderName;

    /**
     * Scheme for identification field; e.g. IBAN or SORTCODEACCOUNTNUMBER.
     */
    private final Scheme scheme;

    /**
     * The actual account number; Naming convention taken from OpenBanking specification.
     */
    private final String identification;

    /**
     * Optional secondary identification; To support the roll number for building societies in OpenBanking.
     */
    private String       secondaryIdentification;

    public enum Scheme {
        /**
         * The International Bank Account Number (IBAN) is an internationally agreed system of identifying bank accounts across national
         * borders to facilitate the communication and processing of cross border transactions with a reduced risk of transcription errors.
         * https://en.wikipedia.org/wiki/International_Bank_Account_Number
         */
        IBAN,
        /**
         * Sort Codes are a unique number assigned to branches of banks and financial institutions in the United Kingdom and Ireland. United
         * Kingdom's sort codes and bank accounts system provides a number of internal checksum validation methods which are used to verify
         * if a bank account number is correctly composed.
         * https://en.wikipedia.org/wiki/Sort_code
         */
        SORTCODEACCOUNTNUMBER
    }
}