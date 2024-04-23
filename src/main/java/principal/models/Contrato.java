package principal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Entity
@Table(name = "contrato")
public class Contrato extends Entidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idUsuario;
	private int idTipoContrato;
	private String descripcion;
	private Float saldo, limite;
	private DateTime fechaFirma;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Float getLimite() {
		return limite;
	}

	public void setLimite(Float limite) {
		this.limite = limite;
	}

	public DateTime getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(DateTime fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(int idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", idUsuario=" + idUsuario + ", idTipoContrato=" + idTipoContrato
				+ ", descripcion=" + descripcion + ", saldo=" + saldo + ", limite=" + limite + ", fechaFirma="
				+ fechaFirma + "]";
	}

	public Contrato(int id, int idUsuario, int idTipoContrato, String descripcion, Float saldo, Float limite,
			DateTime fechaFirma) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idTipoContrato = idTipoContrato;
		this.descripcion = descripcion;
		this.saldo = saldo;
		this.limite = limite;
		this.fechaFirma = fechaFirma;
	}

}
