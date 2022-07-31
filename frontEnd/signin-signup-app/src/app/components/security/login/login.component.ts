import { AuthenticationService } from './../../../services/security/authentication.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SpaceValidator } from 'src/app/model/space-validator';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formParentGroup : FormGroup;
  submitted = false;

  constructor(private formChildGroup: FormBuilder,
              private router: Router,
              private authenticationService: AuthenticationService
             ) { }

  ngOnInit(): void {
    this.myLoginForm();
  }

  myLoginForm(){
    this.formParentGroup = this.formChildGroup.group({
      user: this.formChildGroup.group({
        email: new FormControl('',[Validators.required,
                                  SpaceValidator.onlyContainSpace,
                                  Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$') ]),
        password: new FormControl('', [Validators.required])
      })
    })
  }

   get email(){
    return this.formParentGroup.get('user.email')
  }

  get password(){
    return this.formParentGroup.get('user.password')
  }



  login(){
    this.submitted = true;

        if(this.formParentGroup.invalid){
           this.formParentGroup.markAllAsTouched()
           return;
        }

        this.authenticationService.executeAuthentication(
          this.formParentGroup.controls['user'].value.email,
          this.formParentGroup.controls['user'].value.password
        ).subscribe({
          next: response =>{
            this.router.navigateByUrl("/product")
          },
          error: err =>{
            alert("Invalid Credentails")
          }
        })




  }



}
