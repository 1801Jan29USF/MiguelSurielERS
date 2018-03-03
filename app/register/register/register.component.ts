import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  credential = {
    firstname: '',
    lastname: '',
    username: '',
    password: '',
    email: '',
    userrole: 2
  };

  constructor(private client: HttpClient, private router: Router ) { }

  ngOnInit() {
  }
register() {
  this.client.post('http://localhost:8080/ExpenseReimbursement/register', this.credential, {withCredentials: true})
  .subscribe(
    succ => {
    },
    err => {
      alert('Congratulations your account has been registered');
      this.router.navigateByUrl('employee');
    }
  );
}
}

