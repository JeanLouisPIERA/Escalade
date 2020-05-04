package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation implements Serializable {
	
	@Id @GeneratedValue
	private Long numReservation;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="d MMM yyyy")
	private Date dateDemande; 
	
	private ReservationReponse ReservationReponse;
	
	@ManyToOne
	@JoinColumn(name="USER")
	private User user; 
	
	@ManyToOne
	@JoinColumn(name="TOPO")
	private Topo topo;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long numReservation, Date dateDemande,
			fr.jeanlouispiera.entities.ReservationReponse reservationReponse, User user, Topo topo) {
		super();
		this.numReservation = numReservation;
		this.dateDemande = dateDemande;
		ReservationReponse = reservationReponse;
		this.user = user;
		this.topo = topo;
	}

	public Reservation(Date dateDemande, fr.jeanlouispiera.entities.ReservationReponse reservationReponse, User user,
			Topo topo) {
		super();
		this.dateDemande = dateDemande;
		ReservationReponse = reservationReponse;
		this.user = user;
		this.topo = topo;
	}

	public Long getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(Long numReservation) {
		this.numReservation = numReservation;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public ReservationReponse getReservationReponse() {
		return ReservationReponse;
	}

	public void setReservationReponse(ReservationReponse reservationReponse) {
		ReservationReponse = reservationReponse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	} 

}
