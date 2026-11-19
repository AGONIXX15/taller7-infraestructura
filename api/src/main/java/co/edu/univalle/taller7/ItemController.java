package co.edu.univalle.taller7;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemRepository repo;
    private final String pod = System.getenv().getOrDefault("HOSTNAME", "desconocido");

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/items")
    public Map<String, Object> listar() {
        return Map.of("pod", pod, "data", repo.findAll());
    }

    @PostMapping("/items")
    public Map<String, Object> crear(@RequestBody Item item) {
        return Map.of("pod", pod, "data", repo.save(item));
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of("pod", pod, "app", "taller7-api");
    }
}
