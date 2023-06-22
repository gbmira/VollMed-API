package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizaPaciente(String nome, String telefone, DadosEndereco endereco) {
}
