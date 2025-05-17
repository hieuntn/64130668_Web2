package hieuntn.edu.vn.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hieuntn.edu.vn.Model.DeTaiKH;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTaiKH, String> {
	 @Query("SELECT d FROM DeTaiKH d LEFT JOIN FETCH d.nghienCuu")
	    List<DeTaiKH> getAllWithNghienCuu();
	 @Query("SELECT d FROM DeTaiKH d WHERE LOWER(d.tenDeTai) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    List<DeTaiKH> searchByKeyword(String keyword);
}