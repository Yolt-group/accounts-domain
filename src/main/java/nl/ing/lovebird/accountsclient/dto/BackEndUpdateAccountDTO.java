package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * This DTO is used to update accounts from other BE services.
 * Only the fields provided can be updated, and will be, when not null.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BackEndUpdateAccountDTO {
    private AccountStatusCode status;
    private UserSiteDTO userSite;
    private Boolean hidden;
    private Boolean closed;
    private String accountMaskedIdentification;
    private AccountNumberDTO accountNumber;
    private String externalId;
}
