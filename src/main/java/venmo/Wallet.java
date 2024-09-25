package venmo;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Column(nullable = false, unique = true)
    private Long userId;
    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
    public Wallet() {}
    public Wallet(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public void addBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }}