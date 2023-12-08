package com.karibu.web_app.Services_Impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.karibu.web_app.Entities.Painting;
import com.karibu.web_app.Enumeration.Theme;
import com.karibu.web_app.Iservices.IPainting;
import com.karibu.web_app.Repositories.PaintingRepository;

@Service
public class PaintingImpl implements IPainting{
    
    private final PaintingRepository paintingRepository;
    private static String HEADER = "ID,LOCATION_PRICE,SELLING_PRICE,TITLE,DATE_OF_CREATION,THEME,STORY,AUTHOR_ID";
   
    


    public PaintingImpl(PaintingRepository paintingRepo){

        this.paintingRepository = paintingRepo;
    }

    public String ConvertPaintingtoCsv(Painting painting){

      return Long.toString(painting.getId())+","+

             Long.toString(painting.getLocationPrice())+","+

             Long.toString(painting.getSellingPrice())+","+

             painting.getTitle()+","+

             painting.getCreateAt().toString()+","+

             painting.getTheme().toString()+","+

             painting.getStory()+","+

             painting.getImageList().toString()+","+
             
             painting.getAuthorIdList().toString();

    }

    public boolean writeInsideFile(Painting painting){

        try {

            File fichier=new File("src/main/resources/static/csv/restorePainting.csv");

            if (!fichier.createNewFile()) {

                BufferedWriter file = new BufferedWriter(new FileWriter("src/main/resources/static/csv/restorePainting.csv",true));

                file.newLine();

                file.write(ConvertPaintingtoCsv(painting));

                file.close();

            }
            
            else{

                BufferedWriter file = new BufferedWriter(new FileWriter("src/main/resources/static/csv/restorePainting.csv",false));

                file.write(HEADER);

                file.newLine();

                file.write(ConvertPaintingtoCsv(painting));

                file.close();

            }  

            return true;  

        } 
        catch (Exception e) {

            e.printStackTrace();

            return false;

        }
       
    }  
    @Override
    public boolean createPainting(Painting painting) {
        
        if (painting != null) {

            paintingRepository.save(painting);

            return true;

        }
        else{

            return false;
        }

        
    }
        /*
         * nous ne supprimons pas réellement une oeuvre mais nous transferons ces
         * information dans un fichier csv accessible uniquement par le superAdmin
         */
    @Override
    public boolean deletePainting(Long paintingId) {

        Painting painting = paintingRepository.findById(paintingId).get();

        if (writeInsideFile(painting)) {

            paintingRepository.deleteById(paintingId);

            return true;

        }
        
        else{

            return false;
        }
        
       
    }
    @Override
    public boolean updatePainting(Painting painting) {

        Painting mypainting=searchPainting(painting.getId());

        mypainting.setTitle(painting.getTitle());

        mypainting.setLocationPrice(painting.getLocationPrice());

        mypainting.setSellingPrice(painting.getSellingPrice());

        mypainting.setCreateAt(painting.getCreateAt());

        mypainting.setAuthorIdList(painting.getAuthorIdList());

        mypainting.setImageList(painting.getImageList());

        mypainting.setStory(painting.getStory());

        createPainting(mypainting);

        return true;



    }
    @Override
    public Painting searchPainting(Long paintingId) {
      return paintingRepository.findById(paintingId).get();
    }


    @Override
    public List<Painting> searchPaintingByLocationPrice(Long price) {
        return paintingRepository.findByLocationPrice(price);
    }

    @Override
    public List<Painting> searchPaintingBySellingPrice(Long price) {
       return paintingRepository.findBySellingPrice(price);
    }

    @Override
    public List<Painting> searchPaintingByTitle(String title) {
        return paintingRepository.findByTitle(title);
    }

    @Override
    public List<Painting> searchPaintingByDateOfCreation(Date date) {
        return paintingRepository.findByCreateAt(date);
    }

    @Override
    public List<Painting> searchPainting(String keyword) {
        return paintingRepository.findByKeword(keyword);
    }

    @Override
    public List<Painting> searchPaintingByTheme(Theme theme) {
        return paintingRepository.findByTheme(theme);
    }

    @Override
    public boolean restoreDeletedPainting(String csvInformation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'restoreDeletedPainting'");
    }

 
}
