package com.mhp.coding.challenges.mapping.models.db.blocks

import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.dto.ImageDto

class ImageBlock(
    var image: Image?,
    override val sortIndex: Int = 0,
) : ArticleBlock(sortIndex) {

    override fun map():
        com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock {
    
        val _image : Image? = this.image
        val imageBlockDto =
            com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock(
            
            image = if (_image != null) _image.map() else ImageDto(0, "", ImageSize.SMALL),
            sortIndex = this.sortIndex
        )
        
        return imageBlockDto
    }
}
