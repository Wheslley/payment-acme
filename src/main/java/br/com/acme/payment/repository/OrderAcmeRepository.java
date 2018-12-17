package br.com.acme.payment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.payment.model.OrderAcme;

public interface OrderAcmeRepository extends JpaRepository<OrderAcme, Integer> {
	
	public List<OrderAcme> findAll();
	
	public Optional<OrderAcme> findById(Integer id);
	
	public List<OrderAcme> findByStatus(String status);
	
}
