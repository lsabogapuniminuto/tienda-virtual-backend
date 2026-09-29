package edu.uniminuto.transacciones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniminuto.transacciones.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    Optional<Transaccion> findByIdTransaccion(String idTransaccion);
}
