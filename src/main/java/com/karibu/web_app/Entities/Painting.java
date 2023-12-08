package com.karibu.web_app.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.karibu.web_app.Enumeration.Theme;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Painting implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private Long locationPrice;
    private Long sellingPrice;
    private String title;
    private Date createAt;
    private Theme theme;
    private String story;//describre the story share by the painting
    private List<String> imageList;
    private List<String> authorIdList;
  
    
}
