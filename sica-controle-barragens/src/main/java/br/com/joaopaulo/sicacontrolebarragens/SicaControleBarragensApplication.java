package br.com.joaopaulo.sicacontrolebarragens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import br.com.joaopaulo.sicacontrolebarragens.model.Barragem;
import br.com.joaopaulo.sicacontrolebarragens.model.Localizacao;
import br.com.joaopaulo.sicacontrolebarragens.model.Sensor;
import br.com.joaopaulo.sicacontrolebarragens.repository.BarragemRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class SicaControleBarragensApplication implements CommandLineRunner {

	@Autowired
	private BarragemRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SicaControleBarragensApplication.class, args);
	}

	@Override
	public void run(String...  args) throws Exception {
		resetaBanco();
	}
	
	private void resetaBanco() {
		repository.deleteAll();
		
		//Barragem 1
		Localizacao l1 = new Localizacao();
		l1.setCidade("Itabira");
		l1.setEstado("MG");
		l1.setLatitude(-19.647199);
		l1.setLongitude(-43.2630833);
		l1.setReferência("Quadrilátero ferrífero mineiro");
		
		Sensor s11 = new Sensor();
		s11.setAtivo(true);
		s11.setNome("Sensor de Nível de Detritos");
		s11.setCodigo("S11");
		s11.adicionarLeitura(6.4);
		s11.adicionarLeitura(1.98);
		s11.adicionarLeitura(2.001);
		
		Sensor s12 = new Sensor();
		s12.setAtivo(true);
		s12.setNome("Sensor de Quantidade de Água");
		s12.setCodigo("S12");
		s12.adicionarLeitura(1.21);
		s12.adicionarLeitura(2.22);
		s12.adicionarLeitura(3.23);
		
		Sensor s13 = new Sensor();
		s13.setAtivo(false);
		s13.setNome("Sensor de Radioatividade");
		s13.setCodigo("S13");
		s13.adicionarLeitura(0D);
		s13.adicionarLeitura(0D);
		s13.adicionarLeitura(0D);
		
		Barragem b1 = new Barragem();
		b1.setNome("Barragem Barrosa");
		b1.setAtivo(true);
		b1.setCodigo("BB1");
		b1.setLocalizacao(l1);
		b1.adicionarSensor(s11);
		b1.adicionarSensor(s12);
		b1.adicionarSensor(s13);
		
		repository.save(b1);
		
		//Barragem 2
		Localizacao l2 = new Localizacao();
		l2.setCidade("Jacarecanga");
		l2.setEstado("PA");
		l2.setLatitude(-6.2785204);
		l2.setLongitude(-57.6605458);
		l2.setReferência("Rio Tapajós");
		
		Sensor s21 = new Sensor();
		s21.setAtivo(true);
		s21.setNome("Sensor de Toxicidade");
		s21.setCodigo("S12");
		s21.adicionarLeitura(17.99);
		s21.adicionarLeitura(4.5);
		s21.adicionarLeitura(0.03);
		
		Sensor s22 = new Sensor();
		s22.setAtivo(true);
		s22.setNome("Sensor de Restos de Minério");
		s22.setCodigo("S22");
		s22.adicionarLeitura(4.5);
		s22.adicionarLeitura(0.8);
		s22.adicionarLeitura(3.1);
		
		Sensor s23 = new Sensor();
		s23.setAtivo(true);
		s23.setNome("sensor 6");
		s23.setCodigo("aaa");
		s23.adicionarLeitura(2.9);
		s23.adicionarLeitura(2.3);
		s23.adicionarLeitura(0.09);
		
		Barragem b2 = new Barragem();
		b2.setNome("Barragem Barrística");
		b2.setAtivo(true);
		b2.setCodigo("BB2");
		b2.setLocalizacao(l2);
		b2.adicionarSensor(s21);
		b2.adicionarSensor(s22);
		b2.adicionarSensor(s23);
		
		repository.save(b2);
	}
}
