package nl.ing.lovebird.accountsclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountGroupDTO {
    private AccountGroupEnum type;
    private List<AccountDTO> accounts;
    private List<TotalDTO> totals;
}
