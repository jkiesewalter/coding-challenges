package com.mhp.coding.challenges.mapping.models.db.blocks

class TextBlock(
    var text: String,
    override var sortIndex: Int = 0,
) : ArticleBlock(sortIndex) {

    override fun map():
        com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock {
    
        val textBlockDto =
            com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock(
        
            text = this.text,
            sortIndex = this.sortIndex
        )    
        
        return textBlockDto
    }
}
