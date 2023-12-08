package com.karibu.web_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.karibu.web_app.Entities.Painting;
import com.karibu.web_app.Enumeration.Theme;
import java.util.List;


@Repository
public interface PaintingRepository extends JpaRepository<Painting , Long>{

    List<Painting> findByTitle(String title);

    List<Painting> findBySellingPrice(Long price);

    List<Painting> findByLocationPrice(Long price);

    List<Painting> findByTheme(Theme theme);

    List<Painting> findByCreateAt(java.util.Date date);

    List<Painting> findByKeword(String keyword);

  
}

