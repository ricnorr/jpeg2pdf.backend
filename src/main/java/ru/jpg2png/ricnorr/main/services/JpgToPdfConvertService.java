package ru.jpg2png.ricnorr.main.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class JpgToPdfConvertService {
    public byte[] jpgToPdfConvert(byte[] jpgBytes) {
        try {
            Document document = new Document();
            String outputFile = "output.pdf";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            document.newPage();
            Image image = Image.getInstance(jpgBytes);
            image.setAbsolutePosition(0, 0);
            image.setBorderWidth(0);
            image.scaleAbsolute(PageSize.A4);
            document.add(image);
            document.close();
            FileOutputStream fileOutputStream = new FileOutputStream("output.pdf");
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (BadElementException | IOException e) {
            throw new RuntimeException("e");
        } catch (DocumentException e) {
            throw new RuntimeException("e");
        }
    }


    public byte[] jpgToPdfConvert(List<byte[]> listJpgBytes) {
        try {
            Document document = new Document();
            String outputFile = "output.pdf";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            for (byte[] file : listJpgBytes) {
                document.newPage();
                Image image = Image.getInstance(file);
                image.setAbsolutePosition(0, 0);
                image.setBorderWidth(0);
                image.scaleAbsolute(PageSize.A4);
                document.add(image);
            }
            document.close();
            FileOutputStream fileOutputStream = new FileOutputStream("output.pdf");
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (BadElementException | IOException e) {
            throw new RuntimeException("e");
        } catch (DocumentException e) {
            throw new RuntimeException("e");
        }
    }


}
