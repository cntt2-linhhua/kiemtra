package vn.edu.leading.kiemtra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.kiemtra.model.SinhvienModel;

import java.util.List;

@Repository
public interface SinhvienRepository extends JpaRepository<SinhvienModel , Long> {
    List<SinhvienModel> findByTenContaining(String term);
}
