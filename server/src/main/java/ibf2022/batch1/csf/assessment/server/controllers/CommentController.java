package ibf2022.batch1.csf.assessment.server.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api/comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {
    
}
