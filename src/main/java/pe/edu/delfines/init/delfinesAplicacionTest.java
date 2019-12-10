package pe.edu.delfines.init;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;
@Service
public class delfinesAplicacionTest implements CommandLineRunner{

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
    private VendedorRepository vendedorrepository;
	
	@Autowired
    private ClienteRepository clienterepository;

	@Override
	public void run(String... args) throws Exception {
	
		this.habitacionRepository.deleteAll();
		this.tipoRepository.deleteAll();
		this.clienterepository.deleteAll();
		this.vendedorrepository.deleteAll();
		
		
	 Habitacion habitacion = new Habitacion();
	habitacion.setDescripcion("LIMPIA");;
	habitacion.setNumeroCamas(2);
	habitacion.getObservacion();
	habitacion.setPrecio(150F);
	
	Habitacion habitacion1 = new Habitacion();
	habitacion1.setDescripcion("feo");;
	habitacion1.setNumeroCamas(2);
	habitacion1.getObservacion();
	habitacion1.setPrecio(150F);
	
	Cliente cliente = new Cliente();
	cliente.setId(1);
	cliente.setNombre("solovino");
	cliente.setFechaNacimiento(new Date("17/12/2011"));
	cliente.setDocumento("DNI");
	cliente.setLugarNacimiento("LIMA");
		
	Cliente cliente2 = new Cliente();
	cliente2.setId(2);
	cliente2.setNombre("Juan");
	cliente2.setFechaNacimiento(new Date("17/12/2011"));
	cliente2.setDocumento("DNI");
	cliente2.setLugarNacimiento("LIMA");
	
	
	
    Tipo tipo = new Tipo();
	tipo.setId("H0001");
	tipo.setNombre("una estrella");
	
	Tipo tipo1 = new Tipo();
	tipo1.setId("H0002");
	tipo1.setNombre("una estrella");
	
	
    Vendedor vendedor =new Vendedor();
    vendedor.setId("V0001");   
	vendedor.setNombre("alexander");
	vendedor.setTelefono("123456789");
	vendedor.setDireccion("jrcelendin");
	vendedor.setObservacion("buena ");
	vendedor.setSueldo(1500f);
	
	 Vendedor vendedor1 =new Vendedor();
	vendedor1.setId("V0001");   
	vendedor1.setNombre("alexander");
	vendedor1.setTelefono("123456789");
	vendedor1.setDireccion("jrcelendin");
	vendedor1.setObservacion("buena ");
	vendedor1.setSueldo(1500f);
	
    
	}
}
