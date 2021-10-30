package com.mhp.coding.challenges.mapping.models.dto.blocks

// implements Comparable so that Collections.sort() can be used
interface ArticleBlockDto : Comparable<ArticleBlockDto> {
    val sortIndex: Int
    
    // this method is used to compare two ArticleBlockDtos for sorting
    override fun compareTo(other: ArticleBlockDto): Int {
	    if (this.sortIndex > other.sortIndex)
	        return 1;
	    else if (this.sortIndex < other.sortIndex)
	        return -1;
	    else
	        return 0;
    }
}
