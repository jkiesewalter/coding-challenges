package com.mhp.coding.challenges.mapping.services;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        // fill the repository with dummy objects to test for the 404
        repository.fillWithDummyArticles();
    }

    public List<ArticleDto> list() {
        final List<Article> articles = repository.all();
        //TODO -> done
        // map each of the articles in the list and add them to a new list
        List<ArticleDto> articlesDto = new ArrayList<>();
        for (Article article : articles) {
            articlesDto.add(mapper.map(article));
        }
        return articlesDto;
    }

    public ArticleDto articleForId(Long id) {
        final Article article = repository.findBy(id);
        //TODO -> done
        /*
         * The gradle and spring boot versions were changed to
         * make this way of throwing an exception work.
         * This is not a good idea in general because of potential 
         * dependencies. It was the easiest solution for this
         * specific case, however.
         */
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "article with ID " + id + " not found");
        }
        return mapper.map(article);
    }

    public ArticleDto create(ArticleDto articleDto) {
        final Article create = mapper.map(articleDto);
        repository.create(create);
        return mapper.map(create);
    }
}
