package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.ArrayList;

@Component
public class ArticleMapper {

    public ArticleDto map(Article article){
        //TODO -> done
        ArticleDto articleDto = new ArticleDto();
        
        if (article != null) {
            // use setters to map fields
            articleDto.setId(article.getId());
            articleDto.setTitle(article.getTitle());
            articleDto.setDescription(article.getDescription());
            articleDto.setAuthor(article.getAuthor());
            
            // iterate over ArticleBlocks and map each one
            ArrayList<ArticleBlockDto> blocksDto = new ArrayList<>();
            ArticleBlockDto blockDto;
            for (ArticleBlock block : article.getBlocks()) {
                blocksDto.add(block.map());
            }
            // sort the mapped ArticleBlockDto
            Collections.sort(blocksDto);
            articleDto.setBlocks(blocksDto);
        }
        
        return articleDto;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}
