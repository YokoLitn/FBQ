package org.example.quixkata;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transform")
public class FBQController {


    @GetMapping("/{number}")
    public ResponseEntity<String> transformNumber(@PathVariable int number) {
        String result = TransformAlgo.transformNumberToString(number);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}