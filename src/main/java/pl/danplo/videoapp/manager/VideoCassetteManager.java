package pl.danplo.videoapp.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.danplo.videoapp.dao.VideoCassetteRepo;
import pl.danplo.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    //pobieranie
    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    //zapisywanie
    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    //usuwanie
    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)//wywołana jest kiedy uruchamiana jest aplikacja
    public void fillDB(){

        save(new VideoCassette(1L, "Chłopaki nie płaczą", LocalDate.of(2000, 6, 20)));
        save(new VideoCassette(2L, "Bohemian Rhapsody", LocalDate.of(2018, 9, 10)));
        save(new VideoCassette(3L, "Spectre", LocalDate.of(2015, 10, 23)));
        save(new VideoCassette(4L, "Alternatywy 4", LocalDate.of(1984, 7, 5)));
    }

}
