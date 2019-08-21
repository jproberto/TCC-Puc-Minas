package br.com.joaopaulo.sicasegurancacomunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoLocalidade;
import br.com.joaopaulo.sicasegurancacomunicacao.enumeration.TipoMensagem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Barragem;
import br.com.joaopaulo.sicasegurancacomunicacao.model.Destinatario;
import br.com.joaopaulo.sicasegurancacomunicacao.model.LocalidadeProxima;
import br.com.joaopaulo.sicasegurancacomunicacao.model.ProcedimentoEvacuacao;
import br.com.joaopaulo.sicasegurancacomunicacao.repository.BarragemRepository;

@SpringBootApplication
public class SicaSegurancaComunicacaoApplication implements CommandLineRunner {

	@Autowired
	private BarragemRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SicaSegurancaComunicacaoApplication.class, args);
	}

	@Override
	public void run(String...  args) throws Exception {
		resetaBanco();
	}

	private void resetaBanco() {
		repository.deleteAll();
		
		ProcedimentoEvacuacao procedimento1 = new ProcedimentoEvacuacao();
		procedimento1.setContatoEmergencia("Joe Doe");
		procedimento1.setDescricaoProcedimento("Proin auctor vitae nulla in faucibus. Pellentesque eget magna id neque varius tristique ac in elit. Duis dictum ultricies lorem in lobortis. Nullam sit amet lorem nibh. Aliquam tincidunt scelerisque gravida. Mauris ex mi, auctor sed eros a, suscipit interdum lorem. Nunc posuere lobortis metus id ullamcorper. Curabitur ut ex id ante maximus commodo pellentesque ac leo. Vestibulum sagittis lacus id massa porttitor, eget venenatis nisi mollis. Pellentesque ultrices eros ut sapien congue fringilla.\n" + 
				"\n" + 
				"Nulla tristique libero at mauris mattis, hendrerit egestas ligula ultrices. Curabitur et ante a nisl auctor hendrerit. Curabitur ut dictum turpis, tristique rutrum mauris. Nunc dictum hendrerit aliquet. Nulla congue ut dolor quis tempus. Sed varius dolor felis, quis tincidunt massa lobortis nec. Quisque placerat urna tristique urna laoreet aliquam. Vivamus id felis magna. Quisque condimentum semper sem, nec varius neque laoreet at. Nulla dolor purus, posuere ac varius in, tempor at neque. In elit elit, interdum et imperdiet in, interdum a elit. Nulla elementum, nulla a pellentesque pellentesque, lorem mi lobortis enim, at tempor nulla ex eu lorem.");
		
		Destinatario destinatario1 = new Destinatario();
		destinatario1.setTipoMensagem(TipoMensagem.EMAIL);
		destinatario1.setNomeResponsavel("Rita de Cássia");
		destinatario1.setTelefone("1234455");
		destinatario1.setEmail("jp_legiao@hotmail.com");
		
		Destinatario destinatario2 = new Destinatario();
		destinatario2.setTipoMensagem(TipoMensagem.EMAIL);
		destinatario2.setNomeResponsavel("João Paulo");
		destinatario2.setTelefone("1234455");
		destinatario2.setEmail("joaopsroberto@gmail.com");
		
		LocalidadeProxima localidade1 = new LocalidadeProxima();
		localidade1.setNome("Summoners Rift");
		localidade1.setQuantidadeHabitantes(1000L);
		localidade1.setTipo(TipoLocalidade.CIDADE_PEQUENA);
		localidade1.setProcedimentoEvacuacao(procedimento1);
		localidade1.adicionaDestinatario(destinatario1);
		localidade1.adicionaDestinatario(destinatario2);
		
		//
		
		ProcedimentoEvacuacao procedimento2 = new ProcedimentoEvacuacao();
		procedimento2.setContatoEmergencia("Janny Doe");
		procedimento2.setDescricaoProcedimento("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue bibendum sapien, nec vehicula lectus facilisis et. Duis pharetra risus a purus iaculis congue. Curabitur tempor volutpat urna in sollicitudin. Fusce malesuada, felis sed ullamcorper dignissim, eros nibh laoreet arcu, fermentum cursus massa felis quis mauris. Donec vitae magna ac lectus pulvinar fermentum ut nec sem. Donec a condimentum nisl, vitae pharetra lorem. Duis non mi sed nisi dictum vulputate vel ut velit. Quisque non pulvinar elit. Praesent vel urna consequat diam tempus viverra. Sed sollicitudin nunc vel iaculis luctus. Duis ut justo nec tellus scelerisque varius at nec augue. Donec massa nibh, tempus in leo posuere, rhoncus feugiat lectus. Pellentesque ac mattis sapien, at vestibulum magna.");
	
		LocalidadeProxima localidade2 = new LocalidadeProxima();
		localidade2.setNome("Disney");
		localidade2.setQuantidadeHabitantes(12381239L);
		localidade2.setTipo(TipoLocalidade.CIDADE_GRANDE);
		localidade2.setProcedimentoEvacuacao(procedimento2);
		localidade2.adicionaDestinatario(destinatario2);
		
		//
		
		Barragem barragem1 = new Barragem();
		barragem1.setCodigo("ABC123");
		barragem1.setNome("Barragem Barrosa");
		barragem1.adicionaLocalidadeProxima(localidade1);
		barragem1.adicionaLocalidadeProxima(localidade2);
		
		repository.save(barragem1);
	}
}
