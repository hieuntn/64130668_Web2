package hieuntn.edu.vn.Services;

import hieuntn.edu.vn.Model.NKH;
import hieuntn.edu.vn.Model.TaiKhoan;
import hieuntn.edu.vn.Repository.NKHRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NKHService {
    
    @Autowired
    private NKHRepository nkhRepository;
    @Autowired
    private TaiKhoanService taiKhoanService;
   
    public List<NKH> getAllNKH() {
        return nkhRepository.findAll();
    }

    public NKH findById(int nkhId) {
        return nkhRepository.findById(nkhId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Nhà khoa học với ID: " + nkhId));
    }

    public NKH addNKH(NKH nkh) {
        TaiKhoan taiKhoan = taiKhoanService.findByTenTaiKhoan(nkh.getTaiKhoan().getTenTaiKhoan());
        if (taiKhoan != null) {
            nkh.setTaiKhoan(taiKhoan);
        }
        return nkhRepository.save(nkh);
    }

    public NKH updateNKH(int nkhId, NKH updatedNkh) {
        NKH existingNkh = findById(nkhId);

        existingNkh.setHoTen(updatedNkh.getHoTen());
        existingNkh.setGioiTinh(updatedNkh.getGioiTinh());
        existingNkh.setNamSinh(updatedNkh.getNamSinh());
        existingNkh.setEmail(updatedNkh.getEmail());
        existingNkh.setHocVi(updatedNkh.getHocVi());
        existingNkh.setNganhDaoTao(updatedNkh.getNganhDaoTao());
        existingNkh.setLinhVucNghienCuu(updatedNkh.getLinhVucNghienCuu());
        existingNkh.setChuyenMon(updatedNkh.getChuyenMon());
        existingNkh.setHinhAnh(updatedNkh.getHinhAnh());

        return nkhRepository.save(existingNkh);
    }

    // Phương thức xóa
    public void deleteNKH(int nkhId) {
        nkhRepository.deleteById(nkhId);
    }

    // Phương thức tìm kiếm
    public List<NKH> searchNKH(String keyword, String hocVi) {
        if ((keyword == null || keyword.trim().isEmpty()) && (hocVi == null || hocVi.isEmpty())) {
            return nkhRepository.findAll();
        }
        return nkhRepository.searchByKeywordAndHocVi(keyword == null ? "" : keyword, hocVi);
    }
    @Transactional
    public long getTongSoDeTaiByNkhId(Integer nkhId) {
        return nkhRepository.countDeTaiByNkhId(nkhId);
    }

    @Transactional
    public NKH getNkhById(Integer nkhId) {
        return nkhRepository.findById(nkhId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà khoa học với ID: " + nkhId));
    }
    
}