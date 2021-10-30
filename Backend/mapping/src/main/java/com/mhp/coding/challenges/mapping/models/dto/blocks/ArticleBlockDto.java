package com.mhp.coding.challenges.mapping.models.dto.blocks;

// implements Comparable so that Collections.sort() can be used
public class ArticleBlockDto implements Comparable<ArticleBlockDto> {
    public ArticleBlockDto() {}
   
    public ArticleBlockDto(ArticleBlockDto articleBlockDto) {
        this.setSortIndex(articleBlockDto.getSortIndex());
    }
    
    private int sortIndex;

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
    
    // this method is used to compare two ArticleBlockDtos for sorting
    @Override
	public int compareTo(ArticleBlockDto blockDto) {
	    if (this.getSortIndex() > blockDto.getSortIndex())
	        return 1;
	    else if (this.getSortIndex() < blockDto.getSortIndex())
	        return -1;
	    else
	        return 0;
    }
}
