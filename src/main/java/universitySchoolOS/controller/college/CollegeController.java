package universitySchoolOS.controller.college;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/college")
public class CollegeController {

    @GetMapping
    public String college() {
        return "college controller";
    }
}
