package dumcalls;

import Intuit.Photographer;
import Intuit.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dums.PhotographerService;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
public class PhotographerController {

    @Autowired
    PhotographerService service;

    @GetMapping("v1/photographers")
    public ResponseEntity getPhotographers(){
        List<Photographer> list = service.getPhotographers();
        return ResponseEntity.ok(list);
    };

    @GetMapping("/users/")
    public ResponseEntity getAllUsers(@RequestBody User user){
        List<Photographer> list = service.getPhotographers();
        return ResponseEntity.ok(list);
    }
}
