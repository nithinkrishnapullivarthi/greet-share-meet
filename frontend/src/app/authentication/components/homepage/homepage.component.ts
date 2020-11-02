import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  public cards = [
    {
      name: 'Pururaj',
      description: 'Some quick example text to build on the card title and make up the bulk of the card content',
      buttonText: 'Connect',
      volunteer: 'volunteer',
      activities: 'running, guitar, machine learning'
    },
    {
      name: 'Batman',
      description: 'Some quick example text to build on the card title and make up the bulk of the card content',
      buttonText: 'Connect',
      volunteer: 'volunteer',
      activities: 'running, basketball, cricket'
    },
    {
      name: 'Robin',
      description: 'Some quick example text to build on the card title and make up the bulk of the card content',
      buttonText: 'Connect',
      volunteer: 'volunteer',
      activities: 'running, football,piano'
    },
    {
      name: 'Night wing',
      description: 'Some quick example text to build on the card title and make up the bulk of the card content',
      buttonText: 'Connect',
      volunteer: 'volunteer',
      activities: 'running, swimming'
    }

  ];
}
