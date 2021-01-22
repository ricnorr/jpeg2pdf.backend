package ru.jpg2png.ricnorr.main.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class GeneratedPdf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TODO
    private long id;

    @Lob
    private byte[] pdfBytes;

    @CreationTimestamp
    private Date creationTime;

    public long getId() {
        return id;
    }

    public byte[] getPdfBytes() {
        return pdfBytes;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPdfBytes(byte[] pdfBytes) {
        this.pdfBytes = pdfBytes;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
