import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { DoctorService } from "../core/services/doctor.service";
import { ConfirmationService, MessageService } from "primeng/api";
import { Doctor } from "../shared/model/doctor";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  public doctors: any;

  constructor(private doctorServie: DoctorService, private confirmationService: ConfirmationService, private messageService: MessageService, private router :Router) {
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
          this.getAll();
          if (res.success = true) {
            this.messageService.add({
              severity: 'success',
              summary: res.message, detail: res.detail
            });
          }
          else {
            this.messageService.add({
              severity: 'warn',
              summary: res.message, detail: res.detail
            });
          }
          console.log(res);

        }, ex => {
          console.log(ex);
          this.messageService.add({
            severity: 'error',
            summary: ex.message,
            detail: ex.detail
          });

        });
      }
    });
  }

  editDoctor(id: number){
    this.router.navigate(['/doctors/edit', id]);
  }
}
