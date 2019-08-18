package br.com.joaopaulo.sicacontroleprocessos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.joaopaulo.sicacontroleprocessos.enumeration.NivelRisco;
import br.com.joaopaulo.sicacontroleprocessos.enumeration.Periodicidade;
import br.com.joaopaulo.sicacontroleprocessos.enumeration.Prioridade;
import br.com.joaopaulo.sicacontroleprocessos.model.Atividade;
import br.com.joaopaulo.sicacontroleprocessos.model.Processo;
import br.com.joaopaulo.sicacontroleprocessos.repository.ExecucaoProcessoRepository;
import br.com.joaopaulo.sicacontroleprocessos.repository.ProcessoRepository;

@SpringBootApplication
public class SicaControleProcessosApplication implements CommandLineRunner {

	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private ExecucaoProcessoRepository execucaoProcessoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SicaControleProcessosApplication.class, args);
	}
	
	@Override
	public void run(String...  args) throws Exception {
		resetaBanco();
	}

	private void resetaBanco() {
		processoRepository.deleteAll();
		execucaoProcessoRepository.deleteAll();
		
		Processo processo1 = new Processo();
		processo1.setTitulo("processo 1");
		processo1.setDescricao("esse é um proceso de teste feito especialmente para o trabalho de conclusão de curso da pós graduação em sistemas distribuídos na pontifícia universidade católica de minas gerais, por joão paulo de souza roberto");
		processo1.setPeriodicidade(Periodicidade.MENSAL);
		processo1.setAtivo(true);
		
		Atividade a1 = new Atividade();
		a1.setNome("atividade 1");
		a1.setDescricao("fazer assim assim e assado");
		a1.setHorarioExecucao("08:00");
		a1.setNivelRisco(NivelRisco.BAIXO);
		a1.setPrioridade(Prioridade.MEDIA);
		processo1.adicionarAtividade(a1);
		
		Atividade a2 = new Atividade();
		a2.setNome("atividade 2");
		a2.setDescricao("fazer dessde desse e desse jeito");
		a2.setHorarioExecucao("08:30");
		a2.setNivelRisco(NivelRisco.MEDIO);
		a2.setPrioridade(Prioridade.BAIXA);
		processo1.adicionarAtividade(a2);
		
		Atividade a3 = new Atividade();
		a3.setNome("atividade 3");
		a3.setDescricao("essa aqui é complicada");
		a3.setHorarioExecucao("08:15");
		a3.setNivelRisco(NivelRisco.MUITO_ALTO);
		a3.setPrioridade(Prioridade.MUITO_ALTA);
		processo1.adicionarAtividade(a3);
		
		processoRepository.save(processo1);
		
		Processo processo2 = new Processo();
		processo2.setTitulo("processo 2");
		processo2.setDescricao("esse é um segundo processo com nome menor");
		processo2.setPeriodicidade(Periodicidade.DIARIO);
		processo2.setAtivo(true);
		
		Atividade b1 = new Atividade();
		b1.setNome("atividade 1");
		b1.setDescricao("fazer assim assim e assado");
		b1.setHorarioExecucao("13:34");
		b1.setNivelRisco(NivelRisco.BAIXO);
		b1.setPrioridade(Prioridade.MEDIA);
		processo2.adicionarAtividade(b1);
		
		Atividade b2 = new Atividade();
		b2.setNome("atividade 2");
		b2.setDescricao("fazer dessde desse e desse jeito");
		b2.setHorarioExecucao("13:31");
		b2.setNivelRisco(NivelRisco.MEDIO);
		b2.setPrioridade(Prioridade.BAIXA);
		processo2.adicionarAtividade(b2);
		
		Atividade b3 = new Atividade();
		b3.setNome("atividade 3");
		b3.setDescricao("essa aqui é complicada");
		b3.setHorarioExecucao("07:00");
		b3.setNivelRisco(NivelRisco.MUITO_ALTO);
		b3.setPrioridade(Prioridade.MUITO_ALTA);
		processo2.adicionarAtividade(b3);
		
		processoRepository.save(processo2);
	}
}
