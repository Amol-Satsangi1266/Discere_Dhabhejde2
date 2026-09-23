package studteac.dhabhejde.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import studteac.dhabhejde.Model.Lesson;
import studteac.dhabhejde.Service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Lesson APIs", description = "APIs for managing Lessons")
@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(
            @PathVariable Long id,
            @RequestBody Lesson lesson) {

        return lessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}