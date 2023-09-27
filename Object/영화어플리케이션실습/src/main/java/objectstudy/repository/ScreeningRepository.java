package objectstudy.repository;

import objectstudy.Screening;

import java.util.LinkedHashMap;
import java.util.Optional;

public class ScreeningRepository {

    private Long screeningId = 1L;
    private LinkedHashMap<Long, Screening> screeningDict = new LinkedHashMap<>();

    public void save(Screening screening) {
        screeningDict.put(screeningId++,screening );
    }

    public Optional<Screening> findById(Long screeningId) {
        return Optional.of(screeningDict.get(screeningId));
    }

    public Screening findByMovieNameAndSequence(String movieName, int sequence){

        for (Screening screening : screeningDict.values()) {

            if (screening.getMovie().getTitle().equals(movieName) && screening.isSequence(sequence)) {
                return screening;
            }

        }
         return null;
    }

    public LinkedHashMap<Long, Screening> findAll()
    {
        return (LinkedHashMap<Long, Screening>) screeningDict.clone();
    }
}
