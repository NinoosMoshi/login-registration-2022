import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SpaceValidator } from 'src/app/model/space-validator';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  formParentGroup : FormGroup;

  constructor(private formChildGroup: FormBuilder,private router: Router) { }

  ngOnInit(): void {
    this.mySignupForm();
  }

  mySignupForm(){
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


  signup(){
    if(this.formParentGroup.invalid){
      this.formParentGroup.markAllAsTouched()
      return;
   }
  }



}
