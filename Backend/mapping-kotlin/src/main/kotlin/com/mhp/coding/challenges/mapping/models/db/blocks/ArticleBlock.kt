package com.mhp.coding.challenges.mapping.models.db.blocks

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto

//open class ArticleBlock(
abstract class ArticleBlock(
    open val sortIndex: Int
) {
    abstract fun map(): ArticleBlockDto/* {
        val blockDto : ArticleBlockDto
        blockDto.sortIndex = sortIndex
        
        return blockDto
    }*/
}
