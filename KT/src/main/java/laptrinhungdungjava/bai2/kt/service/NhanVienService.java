package laptrinhungdungjava.bai2.kt.service;


import laptrinhungdungjava.bai2.kt.model.NhanVien;
import laptrinhungdungjava.bai2.kt.model.PhongBan;
import laptrinhungdungjava.bai2.kt.repository.NhanVienRepository;
import laptrinhungdungjava.bai2.kt.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<NhanVien> findAllNhanViens() {
        return nhanVienRepository.findAll();
    }

    public NhanVien findNhanVienById(String id) {
        return nhanVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid NhanVien Id: " + id));
    }

    public NhanVien saveNhanVien(NhanVien nhanVien, String phongBanId) {
        PhongBan phongBan = phongBanRepository.findById(phongBanId).orElseThrow(() -> new IllegalArgumentException("Invalid PhongBan Id: " + phongBanId));
        nhanVien.setPhongBan(phongBan);
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid NhanVien Id: " + id));
        nhanVienRepository.delete(nhanVien);
    }

    public List<PhongBan> findAllPhongBans() {
        return phongBanRepository.findAll();
    }
}
