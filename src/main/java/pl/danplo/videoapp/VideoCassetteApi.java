package pl.danplo.videoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {

    private List<VideoCassette> videoCassettes;

    public VideoCassetteApi() {
        videoCassettes = new ArrayList<>();

        videoCassettes.add(new VideoCassette(1L, "Chłopaki nie płaczą", LocalDate.of(2000, 6, 20)));
        videoCassettes.add(new VideoCassette(2L, "Bohemian Rhapsody", LocalDate.of(2018, 9, 10)));
        videoCassettes.add(new VideoCassette(3L, "Spectre", LocalDate.of(2015, 10, 23)));
        videoCassettes.add(new VideoCassette(4L, "Alternatywy 4", LocalDate.of(1984, 7, 5)));

    }

    @GetMapping("/all")//metoda odpowiada za pobieranie elementów z api
    public List<VideoCassette> getAll() {
        return videoCassettes;
    }

    @GetMapping("/all")
    public VideoCassette getById(@RequestParam int index) {
        Optional<VideoCassette> first = videoCassettes.stream().
                filter(element -> element.getId() == index).findFirst();
        return first.get();
        // jeżeli element ma takie samo ID jak to z indexu, to go pobieram
    }

}
