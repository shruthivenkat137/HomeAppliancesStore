import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../address';
import { Contact } from '../contact';
import { ContactService } from '../_services/contact.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  contact:Contact=new Contact();
  address:Address=new Address();
  userId:any;
  constructor(private contactService:ContactService,private router:Router) { }

  ngOnInit(): void {
    this.userId= sessionStorage.getItem('userId');
    this.getContact();
    this.getAddress();
    
  }
  getAddress() {
    this.contactService.getAddress(this.userId).subscribe(
      (data: any) => {
        console.log(data);
    
       if(data!=null){
       this.address=data;}
      },
      (error: any) => console.error(error)
    );
  }
  getContact() {
    this.contactService.getContact(this.userId).subscribe(
      (data: any) => {
        console.log(data);
        if(data==null)
        {
          alert('Please update your profile');
        }
        else{this.contact=data;}
        
       
      },
      (error: any) => console.error(error)
    );
  }
onSubmit(){
  
  this.saveContact();
  this.saveAddress();

}
  saveAddress() {
    this.contactService.saveAddress(this.address,this.userId).subscribe(
      (data: any) => {
        console.log(data);
        alert('Profile updated!');
        this.router.navigate(['/user/home']);
       
      },
      (error: any) => console.error(error)
    );
    
  }
  saveContact() {
    this.contactService.saveContact(this.contact,this.userId).subscribe(
      (data: any) => {
        console.log(data);
        alert('Profile updated!');
        this.router.navigate(['/user/home']);
       
      },
      (error: any) => console.error(error)
    );
  }
  logout(){
    sessionStorage.clear();
  }
}

