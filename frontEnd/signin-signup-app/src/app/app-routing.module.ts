import { ProductComponent } from './components/product/product.component';

import { RegistrationComponent } from './components/security/registration/registration.component';
import { LoginComponent } from './components/security/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RouteActivateService } from './services/security/canActive/route-activate.service';
import { LoginActivateService } from './services/security/canActive/login-activate.service';

const routes: Routes = [
  {path:"login",component:LoginComponent, canActivate:[LoginActivateService]},
  {path:"registration",component:RegistrationComponent, canActivate:[LoginActivateService]},
  {path:"product",component:ProductComponent, canActivate:[RouteActivateService]},
  {path:"",redirectTo:"/login",pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
