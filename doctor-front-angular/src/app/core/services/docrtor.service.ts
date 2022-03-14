import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  //permet d'injecter ce service dans tous les composant
  providedIn: 'root'
})
export class DocrtorService {

  private url = environment.baseUrl + '/doctors';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.httpClient.get(this.url);
  }
}
