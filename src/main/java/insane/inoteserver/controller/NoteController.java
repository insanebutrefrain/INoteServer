package insane.inoteserver.controller;

import insane.inoteserver.model.Note;
import insane.inoteserver.model.NoteId;
import insane.inoteserver.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iNote/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/add")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.saveAndFlush(note);
    }

    @PutMapping("/update")
    public Note updateNote(@RequestBody Note note) {
        return noteRepository.saveAndFlush(note);
    }

    @PutMapping("/delete")
    public Boolean deleteNote(@RequestBody Note note) {
        try {
            NoteId id = new NoteId(note.getCreateTime(), note.getUser());
            noteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/getAll/{user}")
    public List<Note> getAllNotes(@PathVariable String user) {
        return noteRepository.findByUser(user);
    }
}
