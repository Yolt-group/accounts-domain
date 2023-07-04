package nl.ing.lovebird.accountsclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalDTO {
    private Currency currencyCode;
    private BigDecimal total;
}

