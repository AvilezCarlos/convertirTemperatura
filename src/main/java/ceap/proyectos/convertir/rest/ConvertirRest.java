package ceap.proyectos.convertir.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ceap.proyectos.convertir.business.Business;
import ceap.proyectos.convertir.dto.Datos;
import ceap.proyectos.convertir.dto.Response;

@RestController
public class ConvertirRest {
    
    @Autowired
    private Business business;

    @GetMapping("/celsiusAFahrenheit")
    public ResponseEntity<Response> celsiusAFahrenheit(@RequestBody String datos) {
        Gson gson = new Gson();
        Datos datosJson = gson.fromJson(datos, Datos.class);
        Response response = business.centigradosAFahrenheit(datosJson.getTempratura());
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @GetMapping("/fahrenheitACelsius")
    public ResponseEntity<Response> fahrenheitACentigrados(@RequestBody String datos) {
        Gson gson = new Gson();
        System.out.println(datos);
        Datos datosJson = gson.fromJson(datos, Datos.class);
        Response response = business.fahrenheitACentigrados(datosJson.getTempratura());
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
