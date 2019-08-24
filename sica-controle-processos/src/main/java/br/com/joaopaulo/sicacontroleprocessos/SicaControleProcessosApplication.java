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
		processo1.setTitulo("Processo 1");
		processo1.setDescricao("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit");
		processo1.setPeriodicidade(Periodicidade.MENSAL);
		processo1.setAtivo(true);
		
		Atividade a1 = new Atividade();
		a1.setNome("Atividade 1");
		a1.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum egestas lorem eget blandit aliquet. Vivamus id leo sit amet eros pretium imperdiet. Phasellus nec nunc ac justo lacinia fermentum in et mauris. Morbi vel velit eu diam tempor tincidunt. Aliquam condimentum nunc in ex rutrum, at aliquet risus placerat. Donec pretium mauris ligula, quis pretium metus lacinia eget. Mauris interdum mattis felis, vitae sollicitudin est consectetur non. Sed quis venenatis tortor, ut tempor ligula.");
		a1.setHorarioExecucao("08:00");
		a1.setNivelRisco(NivelRisco.BAIXO);
		a1.setPrioridade(Prioridade.MEDIA);
		processo1.adicionarAtividade(a1);
		
		Atividade a2 = new Atividade();
		a2.setNome("Atividade 2");
		a2.setDescricao("Pellentesque eu fermentum ante. Proin scelerisque sit amet nunc non convallis. Aenean quis auctor leo. Aenean non varius velit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus bibendum, libero vel luctus maximus, turpis turpis rutrum justo, id scelerisque ex dolor eget lacus. Cras at interdum mi, id scelerisque magna. Vivamus congue interdum egestas. Maecenas eget convallis velit. Maecenas tincidunt nisl quis lorem vehicula eleifend. Integer cursus libero quam, faucibus volutpat orci dictum ac. Vivamus ultrices aliquam orci, eget semper metus posuere ac. Duis facilisis arcu eget tortor suscipit, sed elementum justo accumsan.");
		a2.setHorarioExecucao("08:30");
		a2.setNivelRisco(NivelRisco.MEDIO);
		a2.setPrioridade(Prioridade.BAIXA);
		processo1.adicionarAtividade(a2);
		
		Atividade a3 = new Atividade();
		a3.setNome("Atividade 3");
		a3.setDescricao("Morbi pharetra, nisi in sodales dapibus, arcu metus tristique diam, vel viverra magna velit dignissim nisi. Morbi sit amet est sit amet nulla ultrices sagittis at in tortor. Praesent ultricies risus nibh, vel tempor erat dictum quis. Nunc odio metus, fermentum vel metus quis, tempus molestie ipsum. Suspendisse potenti. Praesent ultrices laoreet posuere. Aliquam nec odio lorem. Fusce eu rutrum ante. Donec ultricies accumsan varius. Duis lobortis lobortis lectus in auctor. Sed tempor sem arcu, quis volutpat lacus fringilla nec. Fusce ut consequat dui. Integer finibus porta mollis. Donec eu hendrerit nisl, a semper turpis.");
		a3.setHorarioExecucao("08:45");
		a3.setNivelRisco(NivelRisco.MUITO_ALTO);
		a3.setPrioridade(Prioridade.MUITO_ALTA);
		processo1.adicionarAtividade(a3);
		
		Atividade a4 = new Atividade();
		a4.setNome("Atividade 4");
		a4.setDescricao("Duis rhoncus gravida dolor sollicitudin viverra. Praesent tristique arcu eu ultrices dignissim. Vivamus condimentum quam ligula, a porttitor augue fermentum quis. Sed aliquet facilisis elementum. Vivamus ullamcorper feugiat tempor. Integer velit mi, ullamcorper et eleifend ut, suscipit at metus. Aenean suscipit augue turpis, sit amet varius felis eleifend et. Maecenas consectetur dapibus est, sit amet tempus eros eleifend vitae. Sed porttitor condimentum mi. Proin velit diam, mattis et ornare et, finibus id urna. Aliquam sapien ligula, rutrum ac nisi vel, imperdiet suscipit tellus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec viverra massa. Aenean facilisis augue ac erat lobortis luctus.");
		a4.setHorarioExecucao("09:50");
		a4.setNivelRisco(NivelRisco.MUITO_ALTO);
		a4.setPrioridade(Prioridade.MUITO_ALTA);
		processo1.adicionarAtividade(a4);
		
		Atividade a5 = new Atividade();
		a5.setNome("Atividade 5");
		a5.setDescricao("Duis commodo purus risus, nec convallis orci elementum id. Nam porttitor, magna nec egestas bibendum, urna tortor egestas ipsum, vel auctor felis leo nec turpis. Praesent finibus mauris nec ligula fermentum bibendum. In tincidunt aliquet sodales. Morbi sed dignissim magna. Nullam sit amet rhoncus dolor, sit amet vehicula tellus. Nam rhoncus, orci quis tempus egestas, magna turpis laoreet magna, sed laoreet libero metus vitae mi. Cras vitae tincidunt nulla. Nam ullamcorper quam ut facilisis interdum. Proin ut elit rutrum, sagittis turpis et, finibus dui. Nam iaculis feugiat felis a fermentum. Nulla eget tellus neque. Pellentesque vitae mollis lacus, et euismod orci. Duis eu vestibulum libero. Phasellus tempor massa sit amet dui vestibulum, pretium porttitor lorem consequat. Mauris eu tristique tellus, et sagittis eros.");
		a5.setHorarioExecucao("10:30");
		a5.setNivelRisco(NivelRisco.MUITO_ALTO);
		a5.setPrioridade(Prioridade.MUITO_ALTA);
		processo1.adicionarAtividade(a5);
		
		processoRepository.save(processo1);
		
		Processo processo2 = new Processo();
		processo2.setTitulo("Processo 2");
		processo2.setDescricao("Esse é um segundo processo com nome menor");
		processo2.setPeriodicidade(Periodicidade.DIARIO);
		processo2.setAtivo(true);
		
		Atividade b1 = new Atividade();
		b1.setNome("Atividade 1");
		b1.setDescricao("Atividade de teste 1");
		b1.setHorarioExecucao("13:34");
		b1.setNivelRisco(NivelRisco.BAIXO);
		b1.setPrioridade(Prioridade.MEDIA);
		processo2.adicionarAtividade(b1);
		
		Atividade b2 = new Atividade();
		b2.setNome("atividade 2");
		b2.setDescricao("Atividade de teste 2");
		b2.setHorarioExecucao("14:31");
		b2.setNivelRisco(NivelRisco.MEDIO);
		b2.setPrioridade(Prioridade.BAIXA);
		processo2.adicionarAtividade(b2);
		
		Atividade b3 = new Atividade();
		b3.setNome("Atividade 3");
		b3.setDescricao("Atividade de teste 3");
		b3.setHorarioExecucao("19:00");
		b3.setNivelRisco(NivelRisco.MUITO_ALTO);
		b3.setPrioridade(Prioridade.MUITO_ALTA);
		processo2.adicionarAtividade(b3);
		
		processoRepository.save(processo2);
	}
}
