package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@SequenceGenerator(name="pas",sequenceName="SQ_T_PASSAGEIRO",allocationSize=1)
public class Passageiro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pas")
	@Column(name="CD_PASSAGEIRO")
	private int passageiro;
	
	@Column(name="NM_PASSAGEIRO",nullable=false,length=100)
	private String nomePassageiro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar nascimento;
	
	@Enumerated
	@Column(name="DS_GENERO")
	private Genero genero;

	@OneToMany(mappedBy="passageiro")
	private List<Corrida> corrida;

	
	
	
	public Passageiro() {
		super();
	}

	public Passageiro(String nomePassageiro, Calendar nascimento, Genero genero) {
		super();
		this.nomePassageiro = nomePassageiro;
		this.nascimento = nascimento;
		this.genero = genero;
	}

	public Passageiro(int passageiro, String nomePassageiro, Calendar nascimento, Genero genero,
			List<Corrida> corrida) {
		super();
		this.passageiro = passageiro;
		this.nomePassageiro = nomePassageiro;
		this.nascimento = nascimento;
		this.genero = genero;
		this.corrida = corrida;
	}

	public int getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(int passageiro) {
		this.passageiro = passageiro;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Corrida> getCorrida() {
		return corrida;
	}

	public void setCorrida(List<Corrida> corrida) {
		this.corrida = corrida;
	}
	
	
	
	
	
	
}
