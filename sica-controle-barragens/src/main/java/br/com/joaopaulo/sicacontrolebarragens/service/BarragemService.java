package br.com.joaopaulo.sicacontrolebarragens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.sicacontrolebarragens.enumeration.TipoAlerta;
import br.com.joaopaulo.sicacontrolebarragens.model.Barragem;
import br.com.joaopaulo.sicacontrolebarragens.model.Sensor;
import br.com.joaopaulo.sicacontrolebarragens.repository.BarragemRepository;

@Service
public class BarragemService {

	@Autowired
	private BarragemRepository repository;
	
	@Autowired
	private AlertaService alertaService;
	
	public List<Barragem> getBarragens() {
		return repository.findAll();
	}
	
	public Barragem getBarragemByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}

	public void checaBarragem(Barragem barragem) {
		TipoAlerta tipo = TipoAlerta.INFORMACAO;
		String sensorProblematico = "";
		
		String leituras = "";
		for (Sensor sensor : barragem.getSensores()) {
			if (sensor.getAtivo()) {
				leituras += sensor.getNome() + "[" + sensor.getCodigo() + "]" + ": ";
				
				for (Double leitura : sensor.getLeituras()) {
					leituras += leitura + ", "; 
					
					if (leitura > 10D) {
						tipo = TipoAlerta.EVACUACAO;
						sensorProblematico = sensor.getNome() + "[" + sensor.getCodigo() + "]";
					} else if (leitura > 7D) {
						tipo = TipoAlerta.RECOMENDACAO;
						sensorProblematico = sensor.getNome() + "[" + sensor.getCodigo() + "]";
					} else if (leitura > 5D) {
						tipo = TipoAlerta.AVISO;
						sensorProblematico = sensor.getNome() + "[" + sensor.getCodigo() + "]";
					}
				}
				
				leituras = leituras.substring(0, leituras.length() - 1) + "; \n";
			}
		}
		
		String mensagem = "Seguem abaixo as leituras dos sensores da barragem [" + barragem.getCodigo() + "] " + barragem.getNome() + ". \n \n";

		switch (tipo) {
			case AVISO :
				mensagem += "Dentre elas, o sensor " + sensorProblematico + " apresentou leituras maiores que o normal, mas ainda dentro do limite aceitável. \n \n";
				break;
			case RECOMENDACAO :
				mensagem += "Dentre elas, o sensor " + sensorProblematico + " apresentou leituras maiores que o limite mínimo e por isso recomenda-se atenção. \n \n";
				break;
			case EVACUACAO :
				mensagem = "ALERTA DE EVACUAÇÃO \n \n" +
							" O sensor " + sensorProblematico + " apresentou leituras maiores que o limite máximo e a evacuação deve ser imediata! \n \n";
				break;
		}
		
		mensagem += leituras;
		
		alertaService.enviaAlerta(barragem, mensagem, tipo);
	}
}
