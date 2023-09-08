package com.todescoigor.importacaoxml.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.todescoigor.importacaoxml.pojos.Agente;
import com.todescoigor.importacaoxml.pojos.Agentes;

@Service
public class UploadService {
    public List<Agente> uploadFiles(List<MultipartFile> files) {
        removeArquivosNaosuportados(files);

        List<Agente> agentsList = files.stream()
            .map(this::processarArquivos)
            .filter(Objects::nonNull)
            .flatMap(agents -> agents.getAgent().stream())
            .collect(Collectors.toList());

        return agentsList.size() > 0 ? agentsList : null; 
    }

    private void removeArquivosNaosuportados(List<MultipartFile> files) {
        files.removeIf(f -> !f.getContentType().equals(MediaType.TEXT_XML_VALUE) && !f.getContentType().equals(MediaType.APPLICATION_XML_VALUE));
    }

    private Agentes processarArquivos(MultipartFile file) {
        Agentes agents = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Agentes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            agents = (Agentes) unmarshaller.unmarshal(file.getInputStream());
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }

        //RETORNAR O OBJETO EM ARQUIVO
        // try {
        //     processarObjetos(agents);
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        
        return agents;
    }

    private MultipartFile processarObjetos(Agentes agent) throws FileNotFoundException {
        MultipartFile file = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Agentes.class);
            Marshaller marshaller = context.createMarshaller();
            // StringWriter writer = new StringWriter();
            // MultipartFile multipartFile = new MockMultipartFile("test.xlsx", new FileInputStream(new File("/home/admin/test.xlsx")));
            marshaller.marshal(agent, new FileOutputStream("C:/Users/itodesco/Downloads/arquivo.xml"));
            // String xmlString = writer.toString(); 
            // System.out.println(xmlString);
    
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
