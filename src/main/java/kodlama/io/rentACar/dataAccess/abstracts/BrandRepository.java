package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

//Dao 
public interface BrandRepository  extends JpaRepository<Brand,Integer>{

    // List<Brand> getAll();
}
