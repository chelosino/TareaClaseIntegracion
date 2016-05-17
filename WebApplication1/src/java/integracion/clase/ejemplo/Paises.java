/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.clase.ejemplo;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author marcelbehar
 */
@WebService(serviceName = "Paises")
public class Paises {

    /**
     * This is a sample web service operation
     * @param pais
     * @return 
     */
    @WebMethod(operationName = "obtenerCiudades")
    public String[] obtenerCiudades(@WebParam(name = "pais") String pais) {
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwsoap = gw.getGlobalWeatherSoap();
        Airport air = new Airport();
        AirportSoap airsoap= air.getAirportSoap();
        String airports = airsoap.getAirportInformationByCountry(pais);
        String cities = gwsoap.getCitiesByCountry(pais);
        String[] cityairport = new String[2];
        cityairport[0] = cities;
        cityairport[1] = airports;
        return cityairport;
    }
}
