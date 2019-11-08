package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.jws.WebMethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorController {
   
    
    private List<String> listaCor = new ArrayList<String>();
    private List<Carro> listaCarro = new ArrayList<Carro>();
    private List<Cliente> listaCliente = new ArrayList<Cliente>();
    
    //localhost:8080/lista_cores
    
    @RequestMapping("/lista_cores" )
    public List<String> getCor(){
    	return listaCor;
    }
    
    //http://localhost:8080/salva_cores?nome=vermelho
    @RequestMapping("/salva_cores")
    public void salvaCor(@RequestParam(value="nome") String nome){
    	listaCor.add(nome);
    }
    
    //http://localhost:8080/lista_carros
    @RequestMapping("/lista_carros")
    public List<Carro> getCarros(){
    	return listaCarro;
    }
    
 // http://localhost:8080/salva_carros?nome=gol&cor=vermelho&placa=irk1212&marca=ford
    @RequestMapping("/salva_carros")
    public void salvaCarros(@RequestParam(value="nome") String nome,
    		@RequestParam(value="cor") String cor,
    		@RequestParam(value="placa") String placa,
    		@RequestParam(value="marca") String marca){
    	Carro carro = new Carro();
    	carro.cor = cor;
    	carro.nome = nome;
    	carro.placa = placa;
    	carro.marca = marca;
    	listaCarro.add(carro);
    }
    
    
    @RequestMapping("/meu_nome")
    public String getMeuNome(){
        return "Fabiano Dutra";
    }
    
    // http://localhost:8080/calculadora?op1=2&op2=8
    @RequestMapping("/calculadora")
    public float calculadora(@RequestParam(value="op1") float op1,
    		@RequestParam(value="op2") float op2){
        return op1+op2;
    }
    
    
    @RequestMapping("/salva_cliente")
    public void salvarCliente( @RequestParam(value="nome") String nome,
                               @RequestParam(value="endereco") String endereco,
                               @RequestParam(value="data_nasc") String data_nasc){
        
        Cliente c = new Cliente();
        c.nome = nome;
        c.endereco = endereco;
        c.data_nasc = data_nasc;
        listaCliente.add(c);
       
    }
    
    
     
    
    
}
