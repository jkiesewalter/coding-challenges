package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;

import java.util.List;
import java.util.ArrayList;

public class GalleryBlock extends ArticleBlock {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
 
    @Override
    public GalleryBlockDto map() {
        GalleryBlockDto blockDto = new GalleryBlockDto();

        blockDto.setSortIndex(this.getSortIndex());
        
        // iterate over the images of this GalleryBlock and map each one
        List<ImageDto> imagesDto = new ArrayList<>();
        for (Image image : this.getImages()) {
            if (image != null)
                imagesDto.add(image.map());
            else
                imagesDto.add(new ImageDto());
        }
        blockDto.setImages(imagesDto);
        
        return blockDto;
    }
}
