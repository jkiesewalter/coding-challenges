package com.mhp.coding.challenges.mapping.models.db.blocks

class VideoBlock(
    var url: String,
    var type: VideoBlockType,
    override val sortIndex: Int = 0,
) : ArticleBlock(sortIndex) {

    override fun map():
        com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock {
    
        val videoBlockDto =
            com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock(
            
            url = this.url,
            type = this.type,
            sortIndex = this.sortIndex    
        )
        
        return videoBlockDto
    }
}

enum class VideoBlockType {
    YOUTUBE,
    VIMEO,
    TWITCH,
}
