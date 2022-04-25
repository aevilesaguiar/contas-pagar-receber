package br.com.aeviles.contas.services;

import br.com.aeviles.contas.model.Contas;
import br.com.aeviles.contas.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional //esse anottation
public class ContasService {

    @Autowired
    ContasRepository contasRepository;

    public List<Contas> listAll(){
        return  contasRepository.findAll();

    }

    public void save(Contas contas){
        contasRepository.save(contas);
    }

    public Contas getContaId(Long id){
        return contasRepository.getById(id);
    }

    public void deleteConta(Long id){
        contasRepository.deleteById(id);
    }



}
