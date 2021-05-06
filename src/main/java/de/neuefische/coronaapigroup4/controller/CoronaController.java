package de.neuefische.coronaapigroup4.controller;

import de.neuefische.coronaapigroup4.model.CoronaIncidence;
import de.neuefische.coronaapigroup4.service.CoronaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("corona")
public class CoronaController {

    private final CoronaApiService coronaApiService;

    @Autowired
    public CoronaController(CoronaApiService coronaApiService) {
        this.coronaApiService = coronaApiService;
    }

    @GetMapping("{country}")
    public CoronaIncidence[] getCasesByCountry(@PathVariable String country){
        Optional<CoronaIncidence[]> coronaOptional = coronaApiService.getCasesByCountry(country);
        if(coronaOptional.isPresent()){
            return coronaOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Das gesuchte Land hat kein Corona, oder es existiert nicht.");
    }

}
