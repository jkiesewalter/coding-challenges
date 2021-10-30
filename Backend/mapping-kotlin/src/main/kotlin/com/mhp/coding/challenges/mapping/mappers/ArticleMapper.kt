package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleMapper {
    // removed "?" so article cannot be null (null-safety)
    fun map(article: Article): ArticleDto {
        //TODO -> done
        val _description : String? = article.description
        val _author : String? = article.author
        // map fields
        var articleDto = ArticleDto(
            id = article.id,
            title = article.title,
            description = if (_description != null) _description else "",
            author = if (_author != null) _author else "",
            blocks = ArrayList<ArticleBlockDto>()
        )
        
        // iterate over ArticleBlocks and map each one
        var blocksDto = ArrayList<ArticleBlockDto>()
        for (block in article.blocks) {
            blocksDto.add(block.map())
        }
        // sort the mapped ArticleBlockDto
        Collections.sort(blocksDto);
        articleDto.blocks = blocksDto
        
        return articleDto;
    }

    // Not part of the challenge / Nicht Teil dieser Challenge.
    fun map(articleDto: ArticleDto?): Article = Article(
        title = "An Article",
        blocks = emptySet(),
        id = 1,
        lastModified = Date()
    )
}
