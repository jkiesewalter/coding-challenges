package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;

public class ImageBlock extends ArticleBlock {

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    @Override
    public com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock map() {

        com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock blockDto
          = new com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock();

        blockDto.setSortIndex(this.getSortIndex());
        
        if (this.getImage() != null)
            blockDto.setImage(this.getImage().map());
        else
            blockDto.setImage(new ImageDto());
        
        return blockDto;
    }
}
