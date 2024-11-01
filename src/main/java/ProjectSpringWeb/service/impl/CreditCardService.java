package ProjectSpringWeb.service.impl;

import org.springframework.stereotype.Service;

@Service("creditCardService")
public class CreditCardService implements PaymentProcessor {
    @Override
    public String process() {
        return "Credit card transaction successfull";
    }
}
