import { EmployeeComponent } from './components/employee/employee.component';
import { RegistrationComponent } from './components/security/registration/registration.component';
import { LoginComponent } from './components/security/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"registration",component:RegistrationComponent},
  {path:"employee",component:EmployeeComponent},
  {path:"",redirectTo:"/login",pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
