import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-time-slots',
  templateUrl: './view-time-slots.component.html',
  styleUrls: ['./view-time-slots.component.scss']
})
export class ViewTimeSlotsComponent implements OnInit {
  UserDetails: string;

  details1 = [
  {name:'shashank',
  interest:'running',
  sdate:'10/20/2020',
  edate:'10/26/2020',
  stime:'11:30 AM',
  etime:'2:30 PM',
  email:'ponugotishashank@gmail.com'
  } 
  ];;
  details2 = [
    {name:'prasad',
    interest:'Physics',
    sdate:'10/20/2020',
    edate:'10/26/2020',
    stime:'1:30 PM',
    etime:'5:30 PM',
    email:'prasad@gmail.com'
    } 
    ];;
  ngOnInit(): void {
    
  }

}
