package vn.edu.leading.kiemtra.services;

import vn.edu.leading.kiemtra.model.SinhvienModel;

import java.util.List;

public interface SinhvienServices {
    List<SinhvienModel> findAll();

    List<SinhvienModel> search(String term);

    SinhvienModel findById(Long id);

    boolean update(SinhvienModel category);

    void save(SinhvienModel category);

    boolean delete(Long id);
}
