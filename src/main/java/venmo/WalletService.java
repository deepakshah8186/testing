package venmo;

import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    public Wallet getUserWallet(Long userId) {
        return walletRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));
    }
    public BigDecimal getBalance(Long userId) {
        Wallet wallet = getUserWallet(userId);
        return wallet.getBalance();
    }
    public void updateBalance(Long walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));
        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);
    }}