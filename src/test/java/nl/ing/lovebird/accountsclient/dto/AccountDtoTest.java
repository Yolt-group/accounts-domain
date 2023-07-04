package nl.ing.lovebird.accountsclient.dto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class AccountDtoTest {

    @Test
    void whenAccountActive_isActiveShouldReturnTrue() {
        AccountDTO activeAccount = new AccountDTO();
        activeAccount.setStatus(AccountStatusCode.DATASCIENCE_FINISHED);
        activeAccount.setHidden(false);
        activeAccount.setClosed(false);

        assertThat(activeAccount.isAccountActive()).isTrue();
    }

    @Test
    void whenAccountStatusNotOk_isActiveShouldReturnFalse() {
        AccountDTO activeAccount = new AccountDTO();
        activeAccount.setStatus(AccountStatusCode.DELETED);
        activeAccount.setHidden(false);
        activeAccount.setClosed(false);

        assertThat(activeAccount.isAccountActive()).isFalse();
    }

    @Test
    void whenAccountHidden_isActiveShouldReturnFalse() {
        AccountDTO activeAccount = new AccountDTO();
        activeAccount.setStatus(AccountStatusCode.DATASCIENCE_FINISHED);
        activeAccount.setHidden(true);
        activeAccount.setClosed(false);

        assertThat(activeAccount.isAccountActive()).isFalse();
    }

    @Test
    void whenAccountClosed_isActiveShouldReturnTrue() {
        AccountDTO activeAccount = new AccountDTO();
        activeAccount.setStatus(AccountStatusCode.DATASCIENCE_FINISHED);
        activeAccount.setHidden(false);
        activeAccount.setClosed(true);

        assertThat(activeAccount.isAccountActive()).isFalse();
    }

    @Test
    void testAccountStatusOkay() {
        Set<AccountStatusCode> hiddenCodes = new HashSet<>(
                asList(AccountStatusCode.DELETED,
                        AccountStatusCode.DELETING,
                        AccountStatusCode.UNSUPPORTED_TYPE,
                        AccountStatusCode.HIDDEN));

        for (AccountStatusCode code : AccountStatusCode.values()) {
            assertThat(code.accountStatusOkay()).isEqualTo(!hiddenCodes.contains(code));
        }
    }

}
