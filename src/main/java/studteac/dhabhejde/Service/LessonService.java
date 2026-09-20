package studteac.dhabhejde.Service;

import org.springframework.stereotype.Service;
import studteac.dhabhejde.Exception.ResourceNotFoundException;
import studteac.dhabhejde.Model.Lesson;
import studteac.dhabhejde.Repository.LessonRepository;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson updateLesson(Long id, Lesson lesson) {
        Lesson existingLesson = getLessonById(id);

        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setContent(lesson.getContent());
        existingLesson.setVideoUrl(lesson.getVideoUrl());
        existingLesson.setOrderNumber(lesson.getOrderNumber());

        return lessonRepository.save(existingLesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
