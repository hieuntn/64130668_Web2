package hieuntn.edu.vn.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hieuntn.edu.vn.Model.NKH;
import hieuntn.edu.vn.Model.DeTaiKH;
import hieuntn.edu.vn.Repository.DeTaiRepository;
import hieuntn.edu.vn.Repository.NKHRepository;

import java.util.ArrayList;

@Service
public class DeTaiKHService {
	@Autowired
    private DeTaiRepository deTaiRepository;
    
	@Autowired
    private NKHRepository nkhRepository;
   
    public List<DeTaiKH> getAllDeTai() {
        return deTaiRepository.getAllWithNghienCuu();
    }
    public Optional<DeTaiKH> getDeTaiById(String id) {
        return deTaiRepository.findById(id);
    }
    
    @Transactional
    public DeTaiKH saveDeTaiKH(DeTaiKH deTaiKH, List<Integer> nkhIds) {
        if (deTaiRepository.existsById(deTaiKH.getId())) {
            throw new IllegalArgumentException("Đề tài với ID " + deTaiKH.getId() + " đã tồn tại.");
        }

        List<NKH> nghienCuu = new ArrayList<>();
        if (nkhIds != null && !nkhIds.isEmpty()) {

        	for (Integer nkhId : nkhIds) {
        	    Optional<NKH> optionalNkh = nkhRepository.findById(nkhId);
        	    
        	    if (optionalNkh.isPresent()) {
        	        NKH nkh = optionalNkh.get(); // Lấy ra nhà khoa học
        	        nkh.getNkh_nghiencuu().add(deTaiKH); // Thêm đề tài vào danh sách nghiên cứu
        	        nghienCuu.add(nkh); // Thêm nhà khoa học vào danh sách nghiên cứu
        	        nkhRepository.save(nkh); // Lưu lại vào cơ sở dữ liệu
        	    }
        	}

        }
        
        deTaiKH.setNghienCuu(nghienCuu);
        return deTaiRepository.save(deTaiKH);
    }
    public List<NKH> getAllNKH() {
        return nkhRepository.findAll();
    }
    @Transactional
    public DeTaiKH updateDeTaiKH(DeTaiKH deTaiKH, List<Integer> nkhIds) {
       
       
        DeTaiKH existingDeTai = deTaiRepository.findById(deTaiKH.getId()).get();

      
        existingDeTai.setTenDeTai(deTaiKH.getTenDeTai());
        existingDeTai.setCapDeTai(deTaiKH.getCapDeTai());
        existingDeTai.setDonViChuTri(deTaiKH.getDonViChuTri());
        existingDeTai.setMucTieu(deTaiKH.getMucTieu());
        existingDeTai.setNoiDung(deTaiKH.getNoiDung());
        existingDeTai.setKetQua(deTaiKH.getKetQua());
        existingDeTai.setNamBatDau(deTaiKH.getNamBatDau());
        existingDeTai.setNamKetThuc(deTaiKH.getNamKetThuc());
        existingDeTai.setTinhTrang(deTaiKH.getTinhTrang());
        existingDeTai.setXepLoai(deTaiKH.getXepLoai());

      
        List<NKH> currentNghienCuu = existingDeTai.getNghienCuu();
        
        for (NKH nkh : currentNghienCuu) {
            nkh.getNkh_nghiencuu().remove(existingDeTai);
            nkhRepository.save(nkh);
        }
        currentNghienCuu.clear();

      
        List<NKH> newNghienCuu = new ArrayList<>();
        if (nkhIds != null && !nkhIds.isEmpty()) {
            for (Integer nkhId : nkhIds) {
                Optional<NKH> optionalNkh = nkhRepository.findById(nkhId);
                if (optionalNkh.isPresent()) {
                    NKH nkh = optionalNkh.get();
                    nkh.getNkh_nghiencuu().add(existingDeTai);
                    newNghienCuu.add(nkh);
                    nkhRepository.save(nkh);
                }
            }
        }
        existingDeTai.setNghienCuu(newNghienCuu);

        return deTaiRepository.save(existingDeTai);
    }
    
    public List<DeTaiKH> searchProjects(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return deTaiRepository.findAll();
        }
        return deTaiRepository.searchByKeyword(keyword);
    }

    public List<DeTaiKH> getAllProjects() {
        return deTaiRepository.findAll();
    }
    @Transactional
    public void deleteDeTaiKH(String id) {
        Optional<DeTaiKH> optionalDeTai = deTaiRepository.findById(id);
        if (!optionalDeTai.isPresent()) {
            throw new IllegalArgumentException("Đề tài với ID " + id + " không tồn tại.");
        }

        DeTaiKH deTai = optionalDeTai.get();
        List<NKH> nghienCuu = deTai.getNghienCuu();
        
        if (nghienCuu != null) {
            for (NKH nkh : nghienCuu) {
                nkh.getNkh_nghiencuu().remove(deTai);
                nkhRepository.save(nkh);
            }
            deTai.getNghienCuu().clear();
        }

        deTaiRepository.delete(deTai);
    }
    
}
