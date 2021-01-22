package ru.jpg2png.ricnorr.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jpg2png.ricnorr.main.model.GeneratedPdf;

public interface GeneratedPdfRepository extends JpaRepository<GeneratedPdf, Long> {
    GeneratedPdf findById(long id);
}
