package org.example.wasteback.Repositories;

import org.example.wasteback.Entitys.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {

     List<Gasto> findAllByGrupo_Id(Integer id);

}
