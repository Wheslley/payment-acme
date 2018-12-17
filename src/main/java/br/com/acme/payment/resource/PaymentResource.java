package br.com.acme.payment.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.payment.model.OrderAcme;
import br.com.acme.payment.model.Payment;
import br.com.acme.payment.repository.OrderAcmeRepository;
import br.com.acme.payment.repository.PaymentRepository;

@RestController
public class PaymentResource {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderAcmeRepository orderAcmeRepository;

	@RequestMapping(value = "/payment/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Payment>> findAll() {

		List<Payment> listaPayment = this.paymentRepository.findAll();

		if (listaPayment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Payment>>(listaPayment, HttpStatus.OK);

	}

	@RequestMapping(value = "/payment/insert", method = RequestMethod.POST)
	public ResponseEntity<String> findInsert(@RequestParam("status") String status,
			@RequestParam("number_card") Long numberCard, @RequestParam("data") String data,
			@RequestParam("num_order") Integer numOrder) {

		Optional<OrderAcme> optionalOrderAcme = this.orderAcmeRepository.findById(numOrder);
		Payment payment = new Payment();

		if (optionalOrderAcme == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {

			Date inputDate = null;

			try {
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				inputDate = dateFormat.parse(data);
				
				payment.setData(inputDate);
				payment.setNumberCard(numberCard);
				payment.setStatus(status);
				payment.setOrder(optionalOrderAcme.get());

				this.paymentRepository.save(payment);

			} catch (ParseException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<String>("Insert payment success!", HttpStatus.OK);
		}
	}

}
