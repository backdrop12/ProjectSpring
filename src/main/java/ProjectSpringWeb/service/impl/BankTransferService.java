package ProjectSpringWeb.service.impl;

import org.springframework.stereotype.Service;

@Service
public class BankTransferService implements PaymentProcessor {
    @Override
    public String process() {
        return "Bank transfer transaction successfull";
    }
}
