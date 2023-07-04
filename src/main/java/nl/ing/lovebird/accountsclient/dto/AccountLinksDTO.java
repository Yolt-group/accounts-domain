package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountLinksDTO {
    private LinkDTO updateAccount;
    private LinkDTO hideAccounts;
    private LinkDTO transactions;
    private LinkDTO logo;
    private LinkDTO icon;
    private LinkDTO userSite;
}
