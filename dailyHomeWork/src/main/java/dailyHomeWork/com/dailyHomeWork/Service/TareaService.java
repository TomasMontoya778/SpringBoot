package dailyHomeWork.com.dailyHomeWork.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dailyHomeWork.com.dailyHomeWork.Entity.Homework;
import dailyHomeWork.com.dailyHomeWork.Repository.HomeWorkRepositoy;

@Service
public class TareaService {
    @Autowired
    private HomeWorkRepositoy objTareaRepository;

    public Homework save(Homework objHomework) {
        return this.objTareaRepository.save(objHomework);
    }

    public List<Homework> findAll() {
        return this.objTareaRepository.findAll();
    }

    public void deleteTarea(Long id) {
        this.objTareaRepository.deleteById(id);
    }

    public Homework findByid(Long id) {
        if (id == null) {
            return null;
        }
        Optional<Homework> tarea = this.objTareaRepository.findById(id);
        return tarea.orElse(null);
    }

    public Homework updateTarea(Long id, Homework tarea) {
        Homework objHomeWork = this.findByid(id);
        if (objHomeWork == null) {
            return null;
        }
        objHomeWork = tarea;
        return this.objTareaRepository.save(objHomeWork);
    }
    public List<Homework> findByTitle(String titulo) {
        if (titulo == null) {
            return null;
        }
        Optional<List<Homework>> objTarea = Optional.ofNullable(objTareaRepository.findByTituloContains(titulo));
        return objTarea.orElse(null);
    }
}
