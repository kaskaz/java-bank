package backup.controller.transaction;

public class WithdrawalController extends AbstractAccountTransactionController {

    @Override
    public void submitTransaction(int accountId, double amount) {
        accountService.withdraw(accountId, amount);
    }
}