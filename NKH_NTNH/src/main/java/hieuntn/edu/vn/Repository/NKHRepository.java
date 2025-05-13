package hieuntn.edu.vn.Repository;
import hieuntn.edu.vn.Model.NKH;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NKHRepository extends JpaRepository<NKH,Integer> {
	@Query("SELECT n FROM NKH n WHERE " +
	           "(LOWER(n.hoTen) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "CAST(n.nkhId AS string) LIKE CONCAT('%', :keyword, '%') OR " +
	           "LOWER(n.email) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
	           "(n.hocVi = :hocVi OR :hocVi IS NULL OR :hocVi = '')")
	    List<NKH> searchByKeywordAndHocVi(String keyword, String hocVi);
	@Query("SELECT COUNT(dt) FROM NKH nkh JOIN nkh.nkh_nghiencuu dt WHERE nkh.nkhId = :nkhId")
    int countDeTaiByNkhId(@Param("nkhId") int nkhId);
}
