package vn.edu.leading.kiemtra.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.edu.leading.kiemtra.model.SinhvienModel;
import vn.edu.leading.kiemtra.repositories.SinhvienRepository;

import java.util.List;


@Service

public class SinhvienServiceslmpl implements SinhvienServices {

    private final SinhvienRepository sinhvienRepository;

    public SinhvienServiceslmpl(SinhvienRepository sinhvienRepository) {
        this.sinhvienRepository = sinhvienRepository;
    }

    @Override
    public List<SinhvienModel> findAll() {
        return sinhvienRepository.findAll ();
    }

    @Override
    public List<SinhvienModel> search(String term) {
        return sinhvienRepository.findByTenContaining (term);
    }

    @Override
    public SinhvienModel findById(Long id) {
        return sinhvienRepository.findById (id).get ();
    }

    @Override
    public boolean update(SinhvienModel sinhvien) {
        SinhvienModel sinhvienModel = sinhvienRepository.findById(sinhvien.getId()).orElse(null);
        if (sinhvienModel == null)
            return false;
        sinhvienRepository.delete(sinhvienModel);
        return true;
    }

    @Override
    public void save(SinhvienModel sinhvien) {
        sinhvienRepository.save (sinhvien);
    }

    @Override
    public boolean delete(Long id) {
        SinhvienModel sinhvienModel = sinhvienRepository.findById(id).orElse(null);
        if (sinhvienModel == null)
            return false;
        sinhvienRepository.delete(sinhvienModel);
        return true;
    }
}
