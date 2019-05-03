package pl.kocie_stopki.kocie.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatFactsApiClient {

    private String BaseUrl;
    private String ResponderUrl;
    private String responderParameters;

    public CatFactsApiClient() {

        this.BaseUrl = "https://cat-fact.herokuapp.com";
        this.ResponderUrl = "~api/search/room?action=GET";
        this.responderParameters = "fields=RowNumber%2CId%2CRoomName%2CRoomDescription%2CRoomNumber%2CRoomTypeName%2CBuildingCode%2CBuildingName%2CCampusName%2CCapacity%2CBuildingRoomNumberRoomName%2CCanEdit%2CCanDelete&sortOrder=%2BBuildingRoomNumberRoomName";



    }
}
