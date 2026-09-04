package universitySchoolOS.controller.university;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/university")
public class UniversityController {

    @GetMapping
    public String university() {
        return "university controller";
    }

//    @PostMapping("/createUser")
//    public ResponseEntity<Users> createUser(@RequestBody CreateUserDTO createUserDTO) {
//
//        return null;
//    }
}
