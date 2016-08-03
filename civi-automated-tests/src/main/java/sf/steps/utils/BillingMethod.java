package sf.steps.utils;

public enum BillingMethod {
	VISA("VISA", "4111111111111111"), 
	MASTERCARD("Master Card","5105105105105100"),
	DISCOVER_CARD("Discover Card", "6011111111111117"),
	PAYPAL("Paypal","qa-test-1@360training.com", "testqa@360"),
	AMERICAN_EXPRESS("American Express", "341111111111111"),
	PURCHASE_ORDER("Purchase Order","");

	String billingMethod;
	String cardNumber;
	String email;
	String passwrod;
	
	BillingMethod(String billingMethod, String cardNumber)
	{
		this.billingMethod = billingMethod;
		this.cardNumber = cardNumber;
	}
	
	BillingMethod(String billingMethod, String email, String password)
	{
		this.email = email;
		this.passwrod = password;
	}
	
	public String getBillingMethod()
	{
		return billingMethod;
	}
	
	public String getPaypalEmail()
	{
		return email;
	}
	
	public String getPaypalPassword()
	{
		return passwrod;
	}
	
	public String getCardNumber()
	{
		return cardNumber;
	}
}
