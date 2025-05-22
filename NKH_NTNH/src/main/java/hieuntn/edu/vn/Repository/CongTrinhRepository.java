package hieuntn.edu.vn.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hieuntn.edu.vn.Model.CongTrinh;



@Repository
public interface CongTrinhRepository extends JpaRepository<CongTrinh, String> {
	@Query("SELECT d FROM CongTrinh d LEFT JOIN FETCH d.thamGia")
    List<CongTrinh> getAllWithThamGia();
	@Query("SELECT d FROM CongTrinh d WHERE LOWER(d.tenCongTrinh) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<CongTrinh> searchByKeyword(String keyword);
	

}
