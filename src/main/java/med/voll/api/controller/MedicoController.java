package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao ){
        return repository.findAllStatusA(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody DadosAtualizaMedico dados){
        var medico = repository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
    }


    @DeleteMapping(value = "/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluirMedico();
    }

    /*
    @DeleteMapping(value = "/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
     */
}
