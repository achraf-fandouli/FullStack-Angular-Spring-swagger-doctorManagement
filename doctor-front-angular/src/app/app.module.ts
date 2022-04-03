import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { DoctorComponent } from './doctor/doctor.component';
import {HttpClientModule} from "@angular/common/http";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {ConfirmationService, MessageService} from "primeng/api";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AddDoctorComponent } from './doctor/add-doctor/add-doctor.component';
import {InputTextModule} from "primeng/inputtext";
import {PasswordModule} from "primeng/password";
import {RadioButtonModule} from "primeng/radiobutton";
import {ToastModule} from "primeng/toast";

@NgModule({
  declarations: [
    AppComponent,
    DoctorComponent,
    AddDoctorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TableModule,
    ButtonModule,
    ConfirmDialogModule,
    BrowserAnimationsModule,
    InputTextModule,
    PasswordModule,
    RadioButtonModule,
    ToastModule
  ],
  providers: [ConfirmationService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
