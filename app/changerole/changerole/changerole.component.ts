import { Component, OnInit } from '@angular/core';
import { User } from '../../beans/user';
import { HttpClient } from '@angular/common/http';
import {Location} from '@angular/common';

@Component({
  selector: 'app-changerole',
  templateUrl: './changerole.component.html',
  styleUrls: ['./changerole.component.css']
})
export class ChangeroleComponent implements OnInit {
  UpdateRole = {
    reimb_id: 0,
    reimb_status_id: 0
  };

  users: Array<User> = [];

  constructor(private client: HttpClient, private _location: Location) { }

  ngOnInit() {
    this.client.get('http://localhost:8080/ExpenseReimbursement/changerole',
  {withCredentials: true})
  .subscribe(
    (succ: Array<User>) => {
      this.users = succ;
    },
    (err) => {
      console.log('failed to load users profile');
    }
  );
}
backClicked() {
this._location.back();
}

Approved(reimb_status_id: number, reimb_id: number) {
  this.UpdateRole.reimb_id = reimb_id;
  this.UpdateRole.reimb_status_id = reimb_status_id;
  this.client.post('http://localhost:8080/ExpenseReimbursement/approve', this.UpdateRole, {withCredentials: true }).subscribe(
 (succ) => {
   alert('Role has been changed');
   this.ngOnInit();
 },
 (err) => {
   alert('Failed to change role');
 }
  );
 }
 Denied(reimb_status_id: number, reimb_id: number) {
   this.UpdateRole.reimb_id = reimb_id;
   this.UpdateRole.reimb_status_id = reimb_status_id;
   this.client.post('http://localhost:8080/ExpenseReimbursement/approve', this.UpdateRole, {withCredentials: true }).subscribe(
  (succ) => {
    alert('user has been demoted');
    this.ngOnInit();
  },
  (err) => {
    alert('failed to demote user');
  }
   );
  }
 }
