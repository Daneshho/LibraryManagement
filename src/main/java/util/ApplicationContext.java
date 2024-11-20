package util;

import lombok.Getter;

import repository.impl.BookRepositoryImpl;
import repository.impl.LibrarianRepositoryImpl;
import repository.impl.MemberRepositoryImpl;
import service.impl.BookServiceImpl;
import service.impl.LibrarianServiceImpl;
import service.impl.MemberServiceImpl;

public class ApplicationContext {

    @Getter
    private static final BookRepositoryImpl bookRepository;
    @Getter
    private static final LibrarianRepositoryImpl librarianRepository;
    @Getter
    private static final MemberRepositoryImpl memberRepository;
    @Getter
    private static final BookServiceImpl bookService;
    @Getter
    private static final LibrarianServiceImpl librarianService;
    @Getter
    private static final MemberServiceImpl memberService;

    static {
        bookRepository = new BookRepositoryImpl();
        librarianRepository = new LibrarianRepositoryImpl();
        memberRepository = new MemberRepositoryImpl();
        bookService = new BookServiceImpl();
        librarianService = new LibrarianServiceImpl();
        memberService = new MemberServiceImpl();
    }
}