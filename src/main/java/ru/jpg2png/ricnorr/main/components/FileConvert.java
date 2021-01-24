package ru.jpg2png.ricnorr.main.components;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.jpg2png.ricnorr.main.model.GeneratedPdf;
import ru.jpg2png.ricnorr.main.services.GeneratedPdfService;
import ru.jpg2png.ricnorr.main.services.JpgToPdfConvertService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileConvert {

    private final JpgToPdfConvertService jpgToPdfConvertService = new JpgToPdfConvertService();
    private final GeneratedPdfService generatedPdfService;

    public FileConvert(GeneratedPdfService generatedPdfService) {
        this.generatedPdfService = generatedPdfService;
    }

    @PostMapping(value = "/convertFile", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] jpgUpload(@RequestParam("file") MultipartFile[] multipartFiles, HttpSession session, HttpServletResponse response) {
        byte[] pdfBytes = jpgToPdfConvertService.jpgToPdfConvert(Arrays.stream(multipartFiles).map((file) -> {
            try {
                return (file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList()));
        session.setAttribute("file", pdfBytes);
        response.setHeader("sessionId", session.getId());
        generatedPdfService.save(pdfBytes);
        return pdfBytes;
    }
}
