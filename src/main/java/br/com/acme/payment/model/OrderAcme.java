package br.com.acme.payment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class OrderAcme implements Serializable {

	private static final long serialVersionUID = -5799864051570647612L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "address")
	private String address;

	@Column(name = "data")
	private Date data;

	@Column(name = "status")
	private String status;

	@ManyToMany
    @JoinTable(name="order_rel_order_item_acme", joinColumns=
    {@JoinColumn(name="id_order")}, inverseJoinColumns=
      {@JoinColumn(name="id_order_item")})
	private List<OrderItemAcme> orderItemAcme;

	public OrderAcme(Integer id, String address, Date data, String status) {
		super();
		this.id = id;
		this.address = address;
		this.data = data;
		this.status = status;
		this.orderItemAcme = new ArrayList<>();
	}

	public OrderAcme() {
		super();
		this.orderItemAcme = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItemAcme> getOrderItemAcme() {
		return orderItemAcme;
	}

	public void setOrderItemAcme(List<OrderItemAcme> orderItemAcme) {
		this.orderItemAcme = orderItemAcme;
	}

}
