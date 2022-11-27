import { Component, OnInit } from '@angular/core';
import { Doctor } from "../../shared/model/doctor";
import { DoctorService } from "../../core/services/doctor.service";
import { MessageService } from "primeng/api";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor = new Doctor();
  idDoctor: any;
  oldDoctorName:any;
  oldDoctorlastName:any;

  constructor(private doctorService: DoctorService, private messageService: MessageService, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    //get('id') --> the id that declared in the Routes(appRroutingModule)
    this.idDoctor = this.activatedRoute.snapshot.paramMap.get('id');
    if(this.idDoctor){
      this.getDoctorById(this.idDoctor);

      //this.update(this.idDoctor, this.doctor);
    }

  }

  getDoctorById(id: number) {
    this.doctorService.getById(id).subscribe(res => {
      this.doctor = res;
      this.oldDoctorName=this.doctor?.nom;
      this.oldDoctorlastName=this.doctor?.lastname;
    }, ex =>
      console.log(ex));
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
  update(id : number, doctor: Doctor) {
    this.doctorService.update(id, doctor).subscribe(res => {
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
