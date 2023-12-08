package com.karibu.web_app;


import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karibu.web_app.Entities.Painting;


@SpringBootTest
class WebAppApplicationTests {


    @Autowired
    private static final String DELIMITERFORAUTHORID = "_";
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
    private static String HEADER = "ID,LOCATION_PRICE,SELLING_PRICE,TITLE,DATE_OF_CREATION,THEME,STORY,AUTHOR_ID";
    private Painting painting;
	private List<String> authorId;
	


	@Test
	void contextLoads() {
	}

	 @Test
	void writeOnCsvFile1() {
		
		authorId.add("lkdjfqksdjfamjfieaoizfna");
        authorId.add("dskljfsgiozkk");
        try {         
            FileWriter file = new FileWriter("src/main/resources/static/csv/restorePainting.csv",true);
            //this.painting=new Painting(3L,100L,2003L,"Absddrico",new Date(),theme.NATURE,"ras",authorId);
          
          //this.painting1=new Painting(2L,1003L,2400L,"Abrico ùaro",new Date(),theme.NATURE,"ras",authorId);
          file.append(HEADER);
            file.append(SEPARATOR);
            file.append(Long.toString(painting.getId()));
            file.append(DELIMITER);
            file.append(Long.toString(painting.getLocationPrice()));
            file.append(DELIMITER);
            file.append(Long.toString(painting.getSellingPrice()));
            file.append(DELIMITER);
            file.append(painting.getTitle());
            file.append(DELIMITER);
            file.append(painting.getCreateAt().toString());
            file.append(DELIMITER);
            file.append(painting.getTheme().toString());
            file.append(DELIMITER);
            file.append(painting.getStory());
            file.append(DELIMITER);
            List<String> AuthorID=painting.getAuthorIdList();
            for (String author : AuthorID) {
                file.append(author+DELIMITERFORAUTHORID);
            }
            file.close();
        

        } catch (Exception e) {
            e.printStackTrace();
          
        }
       
    } 
    @Test
     void writeOnCSVFile(){
       // this.painting=new Painting(3L,10033L,32003L,"Arico",new Date(),theme.NATURE,"ras",authorId);
      File file= new File("src/main/resources/static/csv/restorePainting.csv");
      try {
         if(file.createNewFile()){
 
            FileWriter writeInFile = new FileWriter(file,true);
             writeInFile.append(HEADER);
             writeInFile.append(SEPARATOR);
             writeInFile.append(Long.toString(painting.getId()));
             writeInFile.append(DELIMITER);
             writeInFile.append(Long.toString(painting.getLocationPrice()));
             writeInFile.append(DELIMITER);
             writeInFile.append(Long.toString(painting.getSellingPrice()));
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getTitle());
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getCreateAt().toString());
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getTheme().toString());
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getStory());
             writeInFile.append(DELIMITER);
            List<String> AuthorID=painting.getAuthorIdList();
            for (String author : AuthorID) {
                 writeInFile.append(author+DELIMITERFORAUTHORID);
            } 
             writeInFile.close();
            
        
      }else{
         FileWriter writeInFile = new FileWriter(file,true);
    
             writeInFile.append(SEPARATOR);
             writeInFile.append(Long.toString(painting.getId()));
             writeInFile.append(DELIMITER);
             writeInFile.append(Long.toString(painting.getLocationPrice()));
             writeInFile.append(DELIMITER);
             writeInFile.append(Long.toString(painting.getSellingPrice()));
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getTitle());
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getCreateAt().toString());
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getTheme().toString());
             writeInFile.append(DELIMITER);
             writeInFile.append(painting.getStory());
             writeInFile.append(DELIMITER);
            List<String> AuthorID=painting.getAuthorIdList();
            for (String author : AuthorID) {
                 writeInFile.append(author+DELIMITERFORAUTHORID);
            }
             writeInFile.close();
            
      }

      } catch (Exception e) {
        // TODO: handle exception
      }
     
    }
    @Test
    void WriteInsideFile(){
        authorId.add("1gdd");
        authorId.add("dfd2");
        authorId.add("d3d");
        authorId.add("4sdg");

        //this.painting=new Painting(28L,10033L,32003L,"Arico",new Date(),theme.NATURE,"ras",authorId);
     //paintingImpl.writeInsideFile(painting);
       
    }

}
