package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class PacientePossuiAgendaNaMesmaData {
    ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), dados.idMedico(), primeiroHorario, ultimoHorario);
        if (pacientePossuiConsulta){
            throw new ValidacaoException("Ja existe consulta neste dia e horário, tente novamente.");
        }
    }
}
