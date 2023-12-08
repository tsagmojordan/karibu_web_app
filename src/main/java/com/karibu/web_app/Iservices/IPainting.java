package com.karibu.web_app.Iservices;


import java.util.Date;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.karibu.web_app.Entities.Painting;
import com.karibu.web_app.Enumeration.Theme;

 public interface IPainting {

    public boolean createPainting(Painting painting);

    public boolean deletePainting(Long paintingId) throws NotFoundException;

    public boolean updatePainting(Painting painting);

    public Painting searchPainting(Long paintingId);

    public List <Painting> searchPainting(String keyword); 

    public List <Painting> searchPaintingByTheme(Theme theme);

    public List <Painting> searchPaintingByLocationPrice(Long price);

    public List <Painting> searchPaintingBySellingPrice(Long price);

    public List <Painting> searchPaintingByTitle(String title);

    public List <Painting> searchPaintingByDateOfCreation(Date date);

    public boolean restoreDeletedPainting(String csvInformation);
    



}
