package com.mhp.coding.challenges.mapping.models.db.blocks;

public class VideoBlock extends ArticleBlock {

    private String url;

    private VideoBlockType type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoBlockType getType() {
        return type;
    }

    public void setType(VideoBlockType type) {
        this.type = type;
    }
    
    @Override
    public com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock map() {
        
        com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock blockDto
          = new com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock();

        blockDto.setSortIndex(this.getSortIndex());
        blockDto.setUrl(this.getUrl());
        blockDto.setType(this.getType());
        
        return blockDto;
    }
}
