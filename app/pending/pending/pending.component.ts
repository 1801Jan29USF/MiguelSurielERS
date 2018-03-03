import { Component, OnInit } from '@angular/core';
import { Ticket } from '../../beans/ticket';
import { HttpClient } from '@angular/common/http';
import {Location} from '@angular/common';
import { CookieService } from 'angular2-cookie/services/cookies.service';


@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css']
})
export class PendingComponent implements OnInit {
  UpdateTicket = {
    reimb_id: 0,
    reimb_status_id: 0
  };

  tickets: Array<Ticket> = [];
  constructor(private client: HttpClient, private _location: Location) { }

  ngOnInit() {
    this.client.get('http://localhost:8080/ExpenseReimbursement/pending',
    {withCredentials: true})
    .subscribe(
      (succ: Array<Ticket>) => {
        this.tickets = succ;
      },
      (err) => {
        console.log('failed to load tickets');
      } );
}
backClicked() {
  this._location.back();
}
Approved(reimb_status_id: number, reimb_id: number) {
 this.UpdateTicket.reimb_id = reimb_id;
 this.UpdateTicket.reimb_status_id = reimb_status_id;
 this.client.post('http://localhost:8080/ExpenseReimbursement/approve', this.UpdateTicket, {withCredentials: true }).subscribe(
(succ) => {
  alert('Approved');
  this.ngOnInit();
},
(err) => {
  alert('Failed to Approve');
}
 );
}
Denied(reimb_status_id: number, reimb_id: number) {
  this.UpdateTicket.reimb_id = reimb_id;
  this.UpdateTicket.reimb_status_id = reimb_status_id;
  this.client.post('http://localhost:8080/ExpenseReimbursement/approve', this.UpdateTicket, {withCredentials: true }).subscribe(
 (succ) => {
   alert('Denied');
   this.ngOnInit();
 },
 (err) => {
   alert('Failed to Deny');
 }
  );
 }


}


