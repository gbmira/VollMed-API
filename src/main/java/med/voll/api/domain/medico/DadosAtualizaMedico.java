package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizaMedico(String nome,
                                  String telefone,
                                  DadosEndereco endereco) {

}
