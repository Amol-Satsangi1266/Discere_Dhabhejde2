package studteac.dhabhejde.Service;

import org.springframework.stereotype.Service;
import studteac.dhabhejde.Model.Submission;
import studteac.dhabhejde.Repository.SubmissionRepository;

import java.util.List;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Submission getSubmissionById(Long id) {
        return submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Submission gradeSubmission(Long id, Integer marks, String feedback) {
        Submission submission = getSubmissionById(id);

        submission.setMarks(marks);
        submission.setFeedback(feedback);

        return submissionRepository.save(submission);
    }
}
