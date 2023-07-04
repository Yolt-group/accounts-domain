package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private UUID id;
    private String externalId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private Date lastRefreshed;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private Date updated;
    private AccountStatusCode status;
    private UserSiteDTO userSite;
    private String name;
    private AccountType type;
    private Currency currencyCode;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private Boolean hidden;
    private Boolean closed;
    private Boolean migrated;
    private AccountNumberDTO accountNumber;
    private AccountNumberDTO customAccountNumber;
    private String accountMaskedIdentification;
    private String nickname;
    @JsonProperty("_links")
    private AccountLinksDTO links;
    private String yoltAccountType;
    private String linkedAccount;
    private Map<String, String> bankSpecific;

    /**
     * Checks if provided account is active
     *
     * @return - true if the account is active, otherwise false
     */
    @JsonIgnore
    public boolean isAccountActive() {
        return this.getStatus().accountStatusOkay() && !this.getHidden() && !this.getClosed();
    }
}
