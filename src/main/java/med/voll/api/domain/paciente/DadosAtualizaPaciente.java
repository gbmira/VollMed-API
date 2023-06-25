package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizaPaciente(String nome, String telefone, DadosEndereco endereco) {
}
