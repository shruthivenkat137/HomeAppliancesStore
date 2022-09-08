import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Signup } from '../signup';
import { SignupService } from '../_services/signup.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  
  user: Signup=new Signup();
  constructor(private signupService : SignupService, private router:Router
    ) { }
    ngOnInit(): void {
    }
    onSubmit(){
      this.saveUser();
   
      console.log(this.user);
      alert("User Signup successful");
      this.router.navigate(['login']);
      
    }
    saveUser(){
      this.signupService.createUser(this.user).subscribe(
        (data: any) => {
          console.log(data);
        },
        (error: any) => console.error(error)
      );
}
}