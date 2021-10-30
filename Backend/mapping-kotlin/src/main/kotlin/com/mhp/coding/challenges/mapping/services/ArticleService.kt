package com.mhp.coding.challenges.mapping.services

import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import com.mhp.coding.challenges.mapping.mappers.ArticleMapper
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.models.db.Article

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
class ArticleService(
    private val mapper: ArticleMapper,
) {
    fun list(): List<ArticleDto> {
        val articles = ArticleRepository.all()
        //TODO -> done
        // map each of the articles in the list and add them to a new list
        val articlesDto = ArrayList<ArticleDto>()
        for (article in articles) {
            articlesDto.add(mapper.map(article))
        }
        
        return articlesDto
    }

    fun articleForId(id: Long): ArticleDto {
        val article : Article? = ArticleRepository.findBy(id)
        //TODO -> done
        if (article == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND,
                "article with ID " + id + " not found");
        }
        
        return mapper.map(article)
    }

    fun create(articleDto: ArticleDto): ArticleDto {
        val article = mapper.map(articleDto)
        ArticleRepository.create(article)
        return mapper.map(article)
    }
}
