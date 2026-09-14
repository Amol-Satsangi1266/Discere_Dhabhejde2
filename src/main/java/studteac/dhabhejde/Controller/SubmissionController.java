package studteac.dhabhejde.Controller;

import studteac.dhabhejde.Model.Submission;
import studteac.dhabhejde.Service.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public Submission createSubmission(
            @RequestBody Submission submission) {

        return submissionService.createSubmission(submission);
    }

    @GetMapping("/{id}")
    public Submission getSubmissionById(@PathVariable Long id) {
        return submissionService.getSubmissionById(id);
    }

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @PutMapping("/{id}/grade")
    public Submission gradeSubmission(
            @PathVariable Long id,
            @RequestParam Integer marks,
            @RequestParam String feedback) {

        return submissionService.gradeSubmission(
                id, marks, feedback
        );
    }
}