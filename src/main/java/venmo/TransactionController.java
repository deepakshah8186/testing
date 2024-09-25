package venmo;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam BigDecimal amount) {
        transactionService.transferFunds(senderId, receiverId, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
