package kodlama.io.rentACar.webApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping(value="")
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    
    @PostMapping(value="/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody  @Valid() CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
    
}
