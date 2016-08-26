package org.springframework.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.entity.News;
import org.springframework.test.repository.NewsRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @author herasimau on 26.08.2016.
 */

@RestController
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    //Получить все новости
    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public Iterable<News> getNews() {
        return newsRepository.findAll();
    }

    //Добавить новость
    @RequestMapping(value = "/news",method = RequestMethod.POST,consumes = "application/json")
    public News addNews(@RequestBody String content) {
        News news = new News();
        news.setContent(content);
        return newsRepository.save(news);
    }

    //Удалить новость по ID
    @RequestMapping(value = "/news/{id}",method = RequestMethod.DELETE)
    public News deleteNews(@PathVariable("id") Long newsId) {
        News news = newsRepository.findOne(newsId);
        if (news != null) {
            newsRepository.delete(newsId);
        }
        return news;
    }

    //Обновить новость по ID
    @RequestMapping(value = "/news/{id}",method = RequestMethod.POST,consumes = "application/json")
    public News updateNews(@PathVariable("id") Long newsId,@RequestBody String content) {
        News news = newsRepository.findOne(newsId);
        if (news != null) {
            news.setContent(content);
            newsRepository.save(news);
        }
        return news;
    }

}
