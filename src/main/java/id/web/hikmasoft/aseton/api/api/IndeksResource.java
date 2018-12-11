package id.web.hikmasoft.aseton.api.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndeksResource {

    @GetMapping
    public Map<String, String> home() {
        HashMap<String, String> respon = new HashMap<>();
        respon.put("Halo", "Dunia");
        return respon;
    }
}
