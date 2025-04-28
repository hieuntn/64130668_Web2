package hieuntn.edu.vn.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import hieuntn.edu.vn.model.SinhVien;
import org.springframework.stereotype.Service;
import hieuntn.edu.vn.repositories.SinhVienRepository;
@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll(); 
    }
}