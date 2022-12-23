package exercise.song_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Integer id;

    @NotBlank(message = "Title is required")
    @Size(max = 800, message = "Title is less than 800 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Title does not contain special characters")
    private String title;

    @NotBlank(message = "Artist's name is required")
    @Size(max = 800, message = "Artist's name is less than 300 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Artist's name does not contain special characters")
    private String artist;

    @NotBlank(message = "Kind Of Music is required")
    @Size(max = 300, message = "Kind Of Music is less than 300 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\,]*$", message = "Does not contain any special characters except the ampersand ,")
    private String kindOfMusic;

    public SongDto() {
    }

    public SongDto(Integer id, String title, String artist, String kindOfMusic) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
    }
}
