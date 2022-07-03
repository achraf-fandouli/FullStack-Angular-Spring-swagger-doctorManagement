import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DoctorComponent} from "./doctor/doctor.component";
import {AddDoctorComponent} from "./doctor/add-doctor/add-doctor.component";

const routes: Routes = [
  {path: 'doctors', component: DoctorComponent},
  {path: 'doctors/new', component: AddDoctorComponent},
  {path: 'doctors/edit/:id', component: AddDoctorComponent},
  {path: '', redirectTo: 'doctors', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
