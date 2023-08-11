package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas {

    @Autowired
    MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        //medico opcional
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (medicoEstaAtivo == 'I'){
            throw new ValidacaoException("Medico escolhido não está ativo.");
        }
    }
}
