package dailyHomeWork.com.dailyHomeWork.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dailyHomeWork.com.dailyHomeWork.Entity.Homework;
import java.util.List;


public interface HomeWorkRepositoy extends JpaRepository<Homework, Long> {
    List<Homework> findByTituloContains(String titulo);
}
