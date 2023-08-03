package th.mfu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    String hello() {
        return "Hello World!";
    }

    @GetMapping("/hi/{name}")
    String hi(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/sum/{num1}/{num2}")
    Integer sum(@PathVariable Integer num1, @PathVariable Integer num2) {
        return num1 + num2;
    }

}
