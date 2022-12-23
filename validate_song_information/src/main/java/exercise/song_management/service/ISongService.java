package exercise.song_management.service;

import exercise.song_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ISongService {
    Page<Song> finAll(Pageable pageable);
    void save (Song song);
    Song findById(Integer id);
}
