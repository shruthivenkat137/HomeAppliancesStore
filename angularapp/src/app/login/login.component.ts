import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Signup } from '../signup';
import { SignupService } from '../_services/signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:Signup=new Signup();
  constructor(private signupService:SignupService,private router:Router) { }

  ngOnInit(): void {
    
  }

  onSubmit(){
    console.log(this.user);
    this.login();
  }
  login() {
    this.signupService.login(this.user).subscribe(
      (data: any) => {
        console.log(data);
        if(data.roles[0]=="ROLE_CUSTOMER")
        {
          this.router.navigate(['/user/home']);
        }
        else if(data.roles[0]=="ROLE_ADMIN")
  
        {
          this.router.navigate(['/admin/home']);
        }

      },
      (error: any) => console.error(error)
    );
  }


}





