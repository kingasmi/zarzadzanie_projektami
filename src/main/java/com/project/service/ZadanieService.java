package com.project.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.model.Zadanie;

public interface ZadanieService {
	Optional<Zadanie> getZadanie(Integer zadanieId);
	Zadanie setZadanie(Zadanie zadanie);
	void deleteZadanie(Integer zadanieId);
	Page<Zadanie> getZadania(Pageable pageable);
	Page<Zadanie> searchByNazwa(String nazwa, Pageable pageable);

}
