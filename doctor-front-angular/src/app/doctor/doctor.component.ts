import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DoctorService} from "../core/services/doctor.service";
import {ConfirmationService} from "primeng/api";
import {Doctor} from "../shared/model/doctor";

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  public doctors: any;

  constructor(private doctorServie: DoctorService, private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {

    this.getAll();

  }

  getAll() {
    this.doctorServie.getAll().subscribe(data => {
        this.doctors = data;
      }, ex =>
        console.log(ex)
    );
  }

  delete(id: number) {
    this.confirmationService.confirm({
      message: 'Are you sure that you want to delete this doctor?',
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.doctorServie.delete(id).subscribe(res => {
          if (res.success = true) {
            this.getAll();
          }
          console.log(res);

        }, ex => console.log(ex));
      }
    });
  }
}
