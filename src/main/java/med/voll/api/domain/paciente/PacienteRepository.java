package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT m FROM Paciente m WHERE m.status = 'A'")
    Page<Paciente> findAllStatusA(Pageable paginacao);

    boolean findAtivoById(Long idPaciente);
}
