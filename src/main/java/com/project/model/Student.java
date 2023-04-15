package com.project.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Indeksujemy kolumny, które są najczęściej wykorzystywane do wyszukiwania studentów
@Table(name = "student",
	indexes = { @Index(name = "idx_nazwisko", columnList = "nazwisko", unique = false),
				@Index(name = "idx_nr_indeksu", columnList = "nr_indeksu", unique = true)})

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer studentId;

	@NotBlank(message = "Pole imie nie może być puste!")
	@Size(min = 3, max = 50, message = "Imie musi zawierać od {min} do {max} znaków!")
	@Column(nullable = false, length = 50)
	private String imie;

	@NotBlank(message = "Pole nazwisko nie może być puste!")
	@Size(min = 3, max = 100, message = "Nazwisko musi zawierać od {min} do {max} znaków!")
	@Column(nullable = false, length = 100)
	private String nazwisko;
	
	@NotBlank(message = "Pole nr indeksu nie może być puste!")
	@Size(min = 3, max = 20, message = "Nazwa nr indeksu zawierać od {min} do {max} znaków!")
	@Column(name = "nr_indeksu", nullable = false, length = 50)
	private String nrIndeksu;
	 
	@NotBlank(message = "Pole email nie może być puste!")
	@Size(min = 3, max = 50, message = "Email musi zawierać od {min} do {max} znaków!")
	@Column(nullable = false, length = 50)
	private String email;
	 
	@NotBlank(message = "Pole stacjonarny nie może być puste!")
	@Column(nullable = false)
	private Boolean stacjonarny;
	
	@ManyToMany(mappedBy = "studenci")
	private Set<Projekt> projekty;
	
	/* TODO Uzupełnij kod o zmienne reprezentujące pola tabeli student (patrz rys. 3.1),
	. następnie wygeneruj dla nich akcesory i mutatory (Source -> Generate Getters and Setters)
	*/
	public Student() {}
	
	public Student(String imie, String nazwisko, String nrIndeksu, Boolean stacjonarny) {
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.nrIndeksu = nrIndeksu;
	}
	
	public Student(String imie, String nazwisko, String nrIndeksu, String email, Boolean stacjonarny) {
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.nrIndeksu = nrIndeksu;
	this.email = email;
	this.stacjonarny = stacjonarny;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrIndeksu() {
		return nrIndeksu;
	}

	public void setNrIndeksu(String nrIndeksu) {
		this.nrIndeksu = nrIndeksu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStacjonarny() {
		return stacjonarny;
	}

	public void setStacjonarny(Boolean stacjonarny) {
		this.stacjonarny = stacjonarny;
	}

	
}