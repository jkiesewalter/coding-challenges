package com.mhp.coding.challenges.mapping.models.db.blocks

import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto
import com.mhp.coding.challenges.mapping.models.dto.ImageDto
import com.mhp.coding.challenges.mapping.models.db.Image

class GalleryBlock(
    var images: List<Image?>,
    override val sortIndex: Int = 0,
) : ArticleBlock(sortIndex) {
    
    override fun map(): GalleryBlockDto {
        var blockDto = GalleryBlockDto(
            images = ArrayList<ImageDto>(),
            sortIndex = this.sortIndex
        )
        
        // iterate over Image list and map each image
        var imagesDto = ArrayList<ImageDto>()
        for (image in images) {
            if (image != null)
                imagesDto.add(image.map())
        }
        blockDto.images = imagesDto
        
        return blockDto
    }
}
