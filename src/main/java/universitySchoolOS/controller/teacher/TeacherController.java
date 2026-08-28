package universitySchoolOS.controller.teacher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/teacher")
public class TeacherController {

    @GetMapping
    public String teacher() {
        return "teacher controller";
    }
}
