package exercise.song_management.controller;

import exercise.song_management.dto.SongDto;
import exercise.song_management.model.Song;
import exercise.song_management.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showList(@PageableDefault(5) Pageable pageable, Model model) {
        model.addAttribute("songs", songService.finAll(pageable));
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto,
                         BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
//        new SongDto().validate(songDto, bindingResult);
//        lấy dữ liệu từ songdto qua song bởi vì chỉ entity mới thao tác dc với dữ liệu
        if (!bindingResult.hasErrors()) {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Added song successfully");
            return "redirect:/";
        } else {
            model.addAttribute("message", "Add new song failure");
            return "song/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "song/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            model.addAttribute("message", "Create new song successfully");
            return "redirect:/";
        } else {
            model.addAttribute("message", "Create new song failure");
            return "song/edit";
        }
    }
}
