package ru.jpg2png.ricnorr.main.services;

import org.springframework.stereotype.Service;
import ru.jpg2png.ricnorr.main.model.GeneratedPdf;
import ru.jpg2png.ricnorr.main.repository.GeneratedPdfRepository;

@Service
public class GeneratedPdfService {
    GeneratedPdfRepository generatedPdfRepository;

    public GeneratedPdfService(GeneratedPdfRepository generatedPdfRepository) {
        this.generatedPdfRepository = generatedPdfRepository;
    }

    public GeneratedPdf save(byte[] pdfBytes) {
        GeneratedPdf generatedPdf = new GeneratedPdf();
        generatedPdf.setPdfBytes(pdfBytes);
        return generatedPdfRepository.save(generatedPdf);
    }
}
