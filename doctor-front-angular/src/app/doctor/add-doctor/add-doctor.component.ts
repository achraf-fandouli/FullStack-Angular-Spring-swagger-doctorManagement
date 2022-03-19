import {Component, OnInit} from '@angular/core';
import {Doctor} from "../../shared/model/doctor";
import {DoctorService} from "../../core/services/doctor.service";

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor = new Doctor();

  constructor(private doctorService: DoctorService) {
  }

  ngOnInit(): void {
  }

  add() {
    this.doctorService.save(this.doctor).subscribe(res => {
      console.log(res);
    }, ex => {
      console.log(ex);
    })
  }

}
