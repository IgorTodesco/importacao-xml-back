package com.todescoigor.importacaoxml.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.todescoigor.importacaoxml.pojos.Agente;
import com.todescoigor.importacaoxml.services.UploadService;


@RestController
@RequestMapping("/upload")
@CrossOrigin("http://localhost:4200")
public class UploadController {
    
    private final UploadService service;

    public UploadController(UploadService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void upload(@RequestPart List<MultipartFile> files){
        List<Agente> lista = service.uploadFiles(files);
        lista.stream().forEach(dados -> System.out.println("Código: " + dados.getCode()));
    }
}
