package br.com.acme.payment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Payment implements Serializable {

	private static final long serialVersionUID = -5799864051570647615L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "status")
	private String status;

	@Column(name = "numberCard")
	private Long numberCard;

	@Column(name = "data")
	private Date data;

	@OneToOne
    @JoinTable(name="payment_rel_order", joinColumns=
    {@JoinColumn(name="id_payment")}, inverseJoinColumns=
      {@JoinColumn(name="id_order")})
	private OrderAcme order;

	public Payment(Integer id, String status, Long numberCard, Date data) {
		super();
		this.id = id;
		this.status = status;
		this.numberCard = numberCard;
		this.data = data;
	}

	public Payment() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(Long numberCard) {
		this.numberCard = numberCard;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public OrderAcme getOrder() {
		return order;
	}

	public void setOrder(OrderAcme order) {
		this.order = order;
	}

}
