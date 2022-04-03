import { Component, OnInit } from '@angular/core';
import { Doctor } from "../../shared/model/doctor";
import { DoctorService } from "../../core/services/doctor.service";
import { MessageService } from "primeng/api";
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor = new Doctor();

  constructor(private doctorService: DoctorService, private messageService: MessageService, private router: Router) {
  }

  ngOnInit(): void {
  }

  add() {
    this.doctorService.save(this.doctor).subscribe(res => {
      console.log(res);
      if (res.success) {
        this.router.navigate(['/doctors']);
        this.messageService.add({
          severity: 'success',
          summary: res.message,
          detail: res.detail
        });

      }
      else {
        this.messageService.add({
          severity: 'warn',
          summary: res.message,
          detail: res.detail
        });
        //summary:res.message / summary:'Warning'

      }
    }, ex => {
      console.log(ex);
      this.messageService.add({
        severity: 'error',
        summary: ex.message,
        detail: ex.detail
      });

    })
  }

}
