import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-submitticket',
  templateUrl: './submitticket.component.html',
  styleUrls: ['./submitticket.component.css']
})
export class SubmitticketComponent implements OnInit {
  credential = {
    reimb_amount: null,
    reimb_description: '',
    type_id: 4
  };
  constructor(private client: HttpClient, private router: Router) { }

  ngOnInit() {
  }
submitticket() {
  console.log(this.credential);
  this.client.post('http://localhost:8080/ExpenseReimbursement/submitticket', this.credential, {withCredentials: true})
  .subscribe(
    succ => {
      alert('ticket has been submitted');
      this.router.navigateByUrl('home');
    },
    err => {
      alert('ticket was not submitted');
    }
  );
}
}

