package com.karibu.web_app.Iservices;

import com.karibu.web_app.Entities.Author;

interface IAuthorService {
    public boolean createAuthor(Author author);

    public boolean deleteAuthor(Long authorId);

    public boolean updateAuthor(Author author);

    public Author searchAuthor(Long authorId);

    public Author searchAuthor(String keyword); 
}
