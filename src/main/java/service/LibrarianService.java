package service;

import model.Librarian;
import model.dto.LibrarianDto;

public interface LibrarianService extends BaseService<Librarian> {

    LibrarianDto findByName(String name);

    LibrarianDto findByNationalCode(String nationalCode);

    LibrarianDto findById(Long id);

}
