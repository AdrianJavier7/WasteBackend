package org.example.wasteback.Repositories;

import org.example.wasteback.Entitys.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {


}
