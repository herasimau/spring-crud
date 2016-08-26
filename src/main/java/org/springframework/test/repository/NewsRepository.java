package org.springframework.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.test.entity.News;

/**
 * @author herasimau on 26.08.2016.
 */
public interface NewsRepository extends CrudRepository<News,Long> {
    News save(News news);
    void delete(Long id);
    Iterable<News> findAll();

}
