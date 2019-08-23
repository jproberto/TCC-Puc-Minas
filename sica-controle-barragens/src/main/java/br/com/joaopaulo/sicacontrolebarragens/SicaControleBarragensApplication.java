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
		l1.setCidade("cidade aaa");
		l1.setEstado("mg");
		l1.setLatitude(0D);
		l1.setLongitude(0D);
		l1.setReferência("xpto");
		
		Sensor s11 = new Sensor();
		s11.setAtivo(true);
		s11.setNome("sensor 1");
		s11.setCodigo("ABC11");
		s11.adicionarLeitura(4D);
		s11.adicionarLeitura(1D);
		s11.adicionarLeitura(2D);
		
		Sensor s12 = new Sensor();
		s12.setAtivo(true);
		s12.setNome("sensor 2");
		s12.setCodigo("XYZ789");
		s12.adicionarLeitura(1D);
		s12.adicionarLeitura(2D);
		s12.adicionarLeitura(3D);
		
//		Sensor s13 = new Sensor();
//		s13.setAtivo(true);
//		s13.setNome("sensor 3");
//		s13.setCodigo("A3G5H73F");
//		s13.adicionarLeitura(11D);
//		s13.adicionarLeitura(23D);
//		s13.adicionarLeitura(35D);
		
		Barragem b1 = new Barragem();
		b1.setNome("barragem 1");
		b1.setAtivo(true);
		b1.setCodigo("AAA1");
		b1.setLocalizacao(l1);
		b1.adicionarSensor(s11);
		b1.adicionarSensor(s12);
//		b1.adicionarSensor(s13);
		
		repository.save(b1);
		
		//Barragem 2
		Localizacao l2 = new Localizacao();
		l2.setCidade("cidade bbb");
		l2.setEstado("pa");
		l2.setLatitude(0D);
		l2.setLongitude(0D);
		l2.setReferência("xpasdto");
		
		Sensor s21 = new Sensor();
		s21.setAtivo(true);
		s21.setNome("sensor 4");
		s21.setCodigo("GGG23");
		s21.adicionarLeitura(7D);
		s21.adicionarLeitura(4.7);
		s21.adicionarLeitura(6.0);
		
		Sensor s22 = new Sensor();
		s22.setAtivo(true);
		s22.setNome("sensor 5");
		s22.setCodigo("234gg");
		s22.adicionarLeitura(14D);
		s22.adicionarLeitura(25.8);
		s22.adicionarLeitura(3D);
		
		Sensor s23 = new Sensor();
		s23.setAtivo(true);
		s23.setNome("sensor 6");
		s23.setCodigo("aaa");
		s23.adicionarLeitura(42.9);
		s23.adicionarLeitura(2.3);
		s23.adicionarLeitura(0.09);
		
		Barragem b2 = new Barragem();
		b2.setNome("barragem 2");
		b2.setAtivo(true);
		b2.setCodigo("VDESD23");
		b2.setLocalizacao(l2);
		b2.adicionarSensor(s21);
		b2.adicionarSensor(s22);
		b2.adicionarSensor(s23);
		
		repository.save(b2);
	}
}
