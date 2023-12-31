package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m FROM Medico m WHERE m.status = 'A'")
    Page<Medico> findAllStatusA(Pageable paginacao);

    @Query("""
            select m from Medico m 
            where 
            m.status = 'A' 
            and 
            m.especialidade = :especialidade 
            and 
            m.id not in(
               select c.medico.id from Consulta c 
               where 
               c.data = :data 
            ) 
            order by rand() 
            limit 1
            """)
    Medico medicoAleatorioLivre(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.status
            from Medico m
            where
            m.id = :id
            """)
    Character findAtivoById(Long id);
}
