package pl.pjatk.adrwoj.MovieService;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    List<Movie> findAll();

    @Override
    <S extends Movie> S saveAndFlush(S s);

    @Override
    <S extends Movie> S save(S s);

    @Override
    Optional<Movie> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    void delete(Movie movie);

    @Override
    <S extends Movie> Optional<S> findOne(Example<S> example);
}
