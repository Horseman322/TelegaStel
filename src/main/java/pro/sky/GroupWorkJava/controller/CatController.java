package pro.sky.GroupWorkJava.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import pro.sky.GroupWorkJava.model.Cat;
import pro.sky.GroupWorkJava.service.CatService;

import java.util.Collection;

@RestController
@RequestMapping("cat")
public class CatController {

    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @Operation(summary = "Получение питомца по id")
    @GetMapping("{id}")
    public Cat getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Создание питомца")
    @PostMapping()
    public Cat save(@RequestBody Cat cat) {
        return service.create(cat);
    }

    @Operation(summary = "Изменение данных у питомца")
    @PutMapping()
    public Cat update(@RequestBody Cat cat) {
        return service.update(cat);
    }

    @Operation(summary = "Удаление питомца по id")
    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        service.removeById(id);
    }

    @Operation(summary = "Просмотр всех питомцев")
    @GetMapping("all")
    public Collection<Cat> getAll() {
        return service.getAll();
    }
}
