package hieuntn.edu.vn.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hieuntn.edu.vn.Model.CongTrinh;

import hieuntn.edu.vn.Model.NKH;
import hieuntn.edu.vn.Repository.CongTrinhRepository;
import hieuntn.edu.vn.Repository.NKHRepository;

@Service
public class CongTrinhService {
	@Autowired
	private CongTrinhRepository congTrinhRepository;
	
	@Autowired
	private NKHRepository nkhRepository;
	// chức năng hiện thị danh sách công trình
	 public List<CongTrinh> getAllCongTrinh() {
	        return congTrinhRepository.getAllWithThamGia();
	 }
	 // chức năng thêm 1 công trình
	        public Optional<CongTrinh> getCongTrinhById(String id) {
	            return congTrinhRepository.findById(id);
	        }

	        @Transactional
	        public CongTrinh saveCongTrinh(CongTrinh congTrinh, List<Integer> nkhIds) {
	            if (congTrinhRepository.existsById(congTrinh.getCongTrinhID())) {
	                throw new IllegalArgumentException("Công trình với ID " + congTrinh.getCongTrinhID() + " đã tồn tại.");
	            }

	            List<NKH> thamGia = new ArrayList<>();
	            if (nkhIds != null && !nkhIds.isEmpty()) {
	                for (Integer nkhId : nkhIds) {
	                    Optional<NKH> optionalNkh = nkhRepository.findById(nkhId);
	                    if (optionalNkh.isPresent()) {
	                        NKH nkh = optionalNkh.get();
	                        nkh.getNkh_thamgiacongtrinh().add(congTrinh); 
	                        thamGia.add(nkh);
	                        nkhRepository.save(nkh); 
	                    }
	                }
	            }

	            congTrinh.setThamGia(thamGia);
	            return congTrinhRepository.save(congTrinh);
	        } 
	        
	        public List<NKH> getAllNKH() {
	            return nkhRepository.findAll();
	        }
	        // xử lí chức năng edit
	        @Transactional
	        public CongTrinh updateCongTrinh(CongTrinh congTrinh, List<Integer> nkhIds) {
	           
	           
	            CongTrinh existingCongTrinh = congTrinhRepository.findById(congTrinh.getCongTrinhID()).get();

	          
	            existingCongTrinh.setTenCongTrinh(congTrinh.getTenCongTrinh());
	            existingCongTrinh.setHinhThuc(congTrinh.getHinhThuc());
	            existingCongTrinh.setQuyMo(congTrinh.getQuyMo());
	            existingCongTrinh.setNoiApDung(congTrinh.getNoiApDung());
	            existingCongTrinh.setNamBatDau(congTrinh.getNamBatDau());
	            existingCongTrinh.setNamKetThuc(congTrinh.getNamKetThuc());
	            

	          
	            List<NKH> dangThamGia = existingCongTrinh.getThamGia();
	            
	            for (NKH nkh : dangThamGia) {
	                nkh.getNkh_thamgiacongtrinh().remove(existingCongTrinh);
	                nkhRepository.save(nkh);
	            }
	            dangThamGia.clear();

	          
	            List<NKH> newThamGia = new ArrayList<>();
	            if (nkhIds != null && !nkhIds.isEmpty()) {
	                for (Integer nkhId : nkhIds) {
	                    Optional<NKH> optionalNkh = nkhRepository.findById(nkhId);
	                    if (optionalNkh.isPresent()) {
	                        NKH nkh = optionalNkh.get();
	                        nkh.getNkh_thamgiacongtrinh().add(existingCongTrinh);
	                        newThamGia.add(nkh);
	                        nkhRepository.save(nkh);
	                    }
	                }
	            }
	            existingCongTrinh.setThamGia(newThamGia);

	            return congTrinhRepository.save(existingCongTrinh);
	        }
	        //hàm xử lí chức năng tìm kiếm
	        public List<CongTrinh> timKiemCongTrinh(String keyword) {
	            if (keyword == null || keyword.trim().isEmpty()) {
	                return congTrinhRepository.findAll();
	            }
	            return congTrinhRepository.searchByKeyword(keyword);
	        }

	        public List<CongTrinh> getAllProjects() {
	            return congTrinhRepository.findAll();
	        }
	        
	        // hàm xử lí chức năng xóa
	        @Transactional
	        public void deleteCongTrinh(String id) {
	            Optional<CongTrinh> ct = congTrinhRepository.findById(id);
	            if (!ct.isPresent()) {
	                throw new IllegalArgumentException("Công trinh với ID " + id + " không tồn tại.");
	            }

	            CongTrinh congTrinh = ct.get();
	            List<NKH> thamGia = congTrinh.getThamGia();
	            
	            if (thamGia != null) {
	                for (NKH nkh : thamGia) {
	                    nkh.getNkh_thamgiacongtrinh().remove(congTrinh);
	                    nkhRepository.save(nkh);
	                }
	                congTrinh.getThamGia().clear();
	            }

	            congTrinhRepository.delete(congTrinh);
	        
}
}
