package universitySchoolOS.controller.staff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/staff")
public class StaffController {

    @GetMapping
    public String staff() {
        return "staff controller";
    }
}
