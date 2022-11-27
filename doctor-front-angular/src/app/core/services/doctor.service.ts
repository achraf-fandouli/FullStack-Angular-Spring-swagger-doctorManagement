import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {Doctor} from "../../shared/model/doctor";

@Injectable({
  //permet d'injecter ce service dans tous les composant
  providedIn: 'root'
})
export class DoctorService {

  private url = environment.baseUrl + '/doctors';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Doctor[]> {
    return this.httpClient.get<Doctor[]>(this.url);
  }

  delete(id:number): Observable<any> {
    return this.httpClient.delete(this.url+'/'+id);
  }

  save(doctor:Doctor):Observable<any>{
    return this.httpClient.post(this.url,doctor);
  }

  getById(id: number): Observable<Doctor>{
    return this.httpClient.get<Doctor>(this.url+'/'+id);
  }

  update(id:number,doctor: Doctor):Observable<any>{
    return this.httpClient.put(this.url+'/'+id,doctor);
  }

}
