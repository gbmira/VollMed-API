package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf,
                                        Endereco endereco, Character status) {

    public DadosDetalhamentoPaciente(Paciente p) {
        this(p.getId(), p.getNome(), p.getEmail(), p.getTelefone(), p.getCpf(), p.getEndereco(), p.getStatus());
    }
}
