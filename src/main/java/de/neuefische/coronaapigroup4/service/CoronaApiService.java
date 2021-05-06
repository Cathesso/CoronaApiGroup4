package de.neuefische.coronaapigroup4.service;

import de.neuefische.coronaapigroup4.model.CoronaIncidence;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CoronaApiService {
    /*private final LocalDateTime dateTimeNow = LocalDateTime.now(); // Gets the current date and time
    private DateTimeFormatter formatterDay = DateTimeFormatter.forPattern("yyyy-MM-dd");
    private String todayDate = formatterDay.format(dateTimeNow);
    private DateTimeFormatter formatterTime = DateTimeFormatter.forPattern("HH:mm:ss");
    private String todayTime = formatterDay.format(dateTimeNow);
    private String searchDayTimeToday = todayDate + "T" + todayTime + "Z";*/
    


    private final String coronaIncidenceUrl = "https://api.covid19api.com/country/";
    private final String coronaIncidenceUrlRest = "/status/confirmed?from=2021-04-26T00:00:00Z&to=2021-04-28T23:59:59Z";
    private final RestTemplate restTemplate;// = new RestTemplate();

    @Autowired
    public CoronaApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<CoronaIncidence[]> getCasesByCountry(String country) {
        String coronaCountryIncidenceUrl = coronaIncidenceUrl + country + coronaIncidenceUrlRest;
        ResponseEntity<CoronaIncidence[]> response = restTemplate.getForEntity(coronaCountryIncidenceUrl, CoronaIncidence[].class);
        
        if(response.getBody() != null){
            return  Optional.of(response.getBody());
        }
        return Optional.empty();
    }
}
