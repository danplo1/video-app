package pl.danplo.videoapp.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.danplo.videoapp.dao.VideoCassetteRepo;
import pl.danplo.videoapp.dao.entity.VideoCassette;

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

    public Iterable<VideoCassette> findAll(Long id) {
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

}
