package hieuntn.edu.vn.Services;

import hieuntn.edu.vn.Model.TaiKhoan;
import hieuntn.edu.vn.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    public TaiKhoan findByTenTaiKhoan(String tenTaiKhoan) {
        return taiKhoanRepository.findById(tenTaiKhoan).orElse(null);
    }
}