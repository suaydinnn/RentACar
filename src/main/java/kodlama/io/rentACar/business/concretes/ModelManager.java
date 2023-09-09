package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;


//ModelServiceImpl
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {


    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
      List<Model> models=modelRepository.findAll();

      List<GetAllModelsResponse> modelsResponses=models.stream()
                                                    .map(model->this.modelMapperService.forResponse()
                                                            .map(models, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponses;
    }
    
}
