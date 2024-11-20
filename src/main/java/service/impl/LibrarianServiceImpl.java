package service.impl;

import exception.RequestFailedException;
import model.Librarian;
import model.dto.LibrarianDto;
import repository.impl.LibrarianRepositoryImpl;
import service.LibrarianService;
import util.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class LibrarianServiceImpl implements LibrarianService {

    LibrarianRepositoryImpl librarianRepository = ApplicationContext.getLibrarianRepository();

    @Override
    public LibrarianDto findByName(String name) {
        LibrarianDto librarianDto = null;
        try {
            Optional<Librarian> byName = librarianRepository.findByFirstName(name);
            if (byName.isPresent()) {
                librarianDto = new LibrarianDto();
                librarianDto.setName(byName.get().getFirstName());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return librarianDto;
    }

    @Override
    public LibrarianDto findByNationalCode(String nationalCode) {
        LibrarianDto librarianDto = null;
        try {
            Optional<Librarian> byNationalCode = librarianRepository.findByNationalCode(nationalCode);
            if (byNationalCode.isPresent()) {
                librarianDto = new LibrarianDto();
                librarianDto.setName(byNationalCode.get().getFirstName());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return librarianDto;
    }

    @Override
    public void save(Librarian object) {
        try {
            librarianRepository.save(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long object) {
        try {
            librarianRepository.delete(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Librarian object) {
        try {
            librarianRepository.update(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public LibrarianDto findById(Long id) {
        LibrarianDto librarianDto = null;
        try {
            Optional<Librarian> byId = librarianRepository.findById(id);
            if (byId.isPresent()) {
                librarianDto = new LibrarianDto();
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return librarianDto;
    }

    @Override
    public List<Librarian> getAll() {
        try {
            librarianRepository.getAll();
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return librarianRepository.getAll();
    }
}
