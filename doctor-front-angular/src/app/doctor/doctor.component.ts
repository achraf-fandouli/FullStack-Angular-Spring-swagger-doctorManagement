import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8081/doctors').toPromise()
      .then(data=>console.table(data))
      .catch(ex=>console.log(ex));
  }

}
