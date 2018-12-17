package br.com.acme.payment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.payment.model.OrderItemAcme;

public interface OrderItemAcmeRepository extends JpaRepository<OrderItemAcme, Integer> {
	
	public List<OrderItemAcme> findAll();
	
	public Optional<OrderItemAcme> findById(Integer id);

}
