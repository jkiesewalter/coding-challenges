package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public abstract class ArticleBlock {

    private int sortIndex;

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
    
    // This method is abstract to force subclasses of ArticleBlock to implement
    // their own version of it. 
    abstract public ArticleBlockDto map();
}
