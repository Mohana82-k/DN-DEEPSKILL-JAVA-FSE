/*
 * Exercise 4 : Adapter Pattern
 * Author : Mohana Priya K
 */

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {

    public void makePayPalPayment(double amount) {
        System.out.println("PayPal Payment: ₹" + amount);
    }
}

class StripeGateway {

    public void payViaStripe(double amount) {
        System.out.println("Stripe Payment: ₹" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayPalPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.payViaStripe(amount);
    }
}

public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        paypal.processPayment(5000);
        stripe.processPayment(8000);
    }
}