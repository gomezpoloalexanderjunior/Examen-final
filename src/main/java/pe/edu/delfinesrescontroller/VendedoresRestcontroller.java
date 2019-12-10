package pe.edu.delfinesrescontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.services.Vendedorservice;



@RestController
@RequestMapping("/api/vendedores")
public class VendedoresRestcontroller {

	@Autowired
	private Vendedorservice vendedorService;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > fetchMedicos() {
		try {
			List<Vendedor> vendedor = vendedorService.findAll();
			return new ResponseEntity<List<Vendedor>>(vendedor, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > saveMedico(@RequestBody Vendedor vendedor) {
		try {
			Vendedor newvendedor = vendedorService.save(vendedor);
			return new ResponseEntity< Vendedor >(newvendedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Vendedor >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > updateMedico(@PathVariable("id") Integer id, 
			@RequestBody Vendedor vendedor) {
		try {
			if(id.equals(vendedor.getId())) {
				Optional<Vendedor> optional = vendedorService.findById("id");
				if(optional.isPresent()) {
					Vendedor updateVendedor = vendedorService.update(vendedor);
					return new ResponseEntity<Vendedor>(updateVendedor, 
							HttpStatus.OK);
				} else {
					return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
				}				
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	@GetMapping(path = "/{id}/vendedores")
	public ResponseEntity<List<Vendedor>> fetchPaciente(
			@PathVariable("id") Integer id){
		try {
			Optional<Vendedor> optional = vendedorService.findById("id");
			if(optional.isPresent()) {
				return new ResponseEntity<List<Vendedor>>(
						optional.get().getPacientes(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Vendedor>>(
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Vendedor> deleteMedico(@PathVariable("id") Integer id) {
		try {			
			Optional<Vendedor> optional = vendedorService.findById("id");
			if(optional.isPresent()) {
				vendedorService.deleteById("id");
				return new ResponseEntity<Vendedor>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
