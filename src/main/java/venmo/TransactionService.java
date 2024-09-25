package venmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private WalletService walletService;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public PulsarProperties.Transaction transferFunds(Long senderId, Long receiverId, BigDecimal amount) {
        Wallet senderWallet = walletService.getUserWallet(senderId);
        Wallet receiverWallet = walletService.getUserWallet(receiverId);

        if (senderWallet.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient balance");
        }

        // Deduct from sender's wallet
        walletService.updateBalance(senderWallet.getId(), amount.negate());
        // Add to receiver's wallet
        walletService.updateBalance(receiverWallet.getId(), amount);

        // Record the transaction
        Transaction transaction = new Transaction(senderWallet.getId(), receiverWallet.getId(), amount);
        transactionRepository.save(transaction);

        return transaction;
    }
}

