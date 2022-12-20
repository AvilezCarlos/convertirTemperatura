package ceap.proyectos.convertir.business;

import org.springframework.stereotype.Component;

import ceap.proyectos.convertir.dto.Response;

@Component
public class Business {
    
    public Response centigradosAFahrenheit(double centigrados) {
        Response response = new Response();
        response.setConvertido((centigrados * 9/5) + 32);
        return response;
    }

    public Response fahrenheitACentigrados(double fahrenheit) {
        Response response = new Response();
        response.setConvertido((fahrenheit - 32) * (9/5));
        return response;
    }
    
}
