import { HttpHeaders } from "@angular/common/http"

export class Header {

    url = "http://localhost:8080/v1/api/";
    headers = new HttpHeaders({'Content-Type':'application/json'});

}
