package com.mhp.coding.challenges.mapping.models.db.blocks;

public class TextBlock extends ArticleBlock {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock map() {
        
        com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock blockDto
          = new com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock();

        blockDto.setSortIndex(this.getSortIndex());
        blockDto.setText(this.getText());
        
        return blockDto;
    }
}
