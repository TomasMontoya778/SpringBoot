package com.riwi.primeraWeb.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraWeb.Entity.Coder;
import com.riwi.primeraWeb.Repository.CoderRepsitory;

@Service
public class CoderService {
    // @Autowired Registra la inyección de dependencias en Spring boot
    @Autowired
    private CoderRepsitory objCoderRepository;
     
    public List<Coder> findAll(){
        return this.objCoderRepository.findAll();
    }
    public Page<Coder> findAllPaginate(int page, int size){
        if (page < 0) {
            page = 0;
        }
        // Crear paginación
        Pageable objPage = PageRequest.of(page, size);
        return this.objCoderRepository.findAll(objPage);
    }
    // Método para crear un nuevo coder, se hace uso del repositorio y del método save, el cual se encarga de insertar en la base de datos
    public Coder save(Coder objCoder){
        return this.objCoderRepository.save(objCoder);
    }
    // Método para listar por id
    public Coder findById(Long idCoder){
        if (idCoder == null) {
            return null;
        }
        // Busca un coder por id y en caso de que no lo encuentre retorna nulo (NULL)
        Optional<Coder> opcionalCoder = this.objCoderRepository.findById(idCoder);
        return opcionalCoder.orElse(null);
    }
    // Método para eliminar un coder (DeleteById)
    public void deleteCoder(long id){
        this.objCoderRepository.deleteById(id);
    }
    // Método para actualizar un coder
    public Coder update(Long id, Coder coder){
        // buscar el coder por id
        Coder objCoderDB = this.findById(id);
        // verificamos que el coder si exista
        if (objCoderDB == null) return null;
        objCoderDB = coder;
        // El método save verifica si el objeto tiene llave primaria y si tiene, actualiza el coder, si no, crea un nuevo coder.
        return this.objCoderRepository.save(objCoderDB);
    }
}
