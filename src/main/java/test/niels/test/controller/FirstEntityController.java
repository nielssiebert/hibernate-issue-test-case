package test.niels.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.niels.test.model.FirstEntity;
import test.niels.test.service.FirstEntityService;

@Controller
@RequestMapping(path = "/rest/first")
@RequiredArgsConstructor
@Slf4j
public class FirstEntityController {

    private final FirstEntityService firstEntityService;

    @GetMapping(path = "find/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FirstEntity getFirstEntity(@PathVariable("id") String id) {
        log.info(id);
        return firstEntityService.findFirstEntity(id);
    }

    @GetMapping(path = "findall", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FirstEntity> getAllFirstEntity() {
        return firstEntityService.findAll();
    }

    @PostMapping(path = "save")
    @ResponseBody
    public FirstEntity saveFirstEntity(@RequestBody FirstEntity firstEntity) {
        return firstEntityService.saveFirstEntity(firstEntity);
    }
}
