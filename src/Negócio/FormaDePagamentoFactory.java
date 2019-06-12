package Negócio;

public class FormaDePagamentoFactory {

	public FormaDePagamentoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public FormaPagamento createInstance(TipoPagamento t) {
        switch(t) {
            case CREDITO:
                return new PagamentoCredito();
            case DEBITO:
                return new PagamentoDebito();
            case BOLETO:
                return new PagamentoBoleto();
            case PAYPAL:
                return new PagamentoPayPal();
        }
        return null;
    }
}
