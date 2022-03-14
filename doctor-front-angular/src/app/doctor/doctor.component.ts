import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DocrtorService} from "../core/services/docrtor.service";

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
public doctors:any;
  constructor(private doctorServie: DocrtorService) {
  }

  ngOnInit(): void {

    this.doctorServie.getAll().subscribe(data => {
        this.doctors=data;
      }, ex =>
        console.log(ex)
    );
  }

}
