package hieuntn.edu.vn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hieuntn.edu.vn.Model.DeTaiKH;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTaiKH, String> {
    
}