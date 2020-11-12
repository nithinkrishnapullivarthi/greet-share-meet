import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Announcement } from './models/register.model';
import { TimelineService } from './services/timeline.service';


@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {

  public announcements : Announcement[];
  constructor(private timelineService: TimelineService) { }

  ngOnInit(): void {
    this.timelineService.getAnnouncements().subscribe(res=>{
        this.announcements = res;
    });
  }

}
