import {Component, OnInit} from '@angular/core';
import {Sandwich} from '../../interfaces/sandwich';
import {SandwichService} from '../../services/sandwich.service';

@Component({
  selector: 'app-view-sandwiches',
  templateUrl: './view-sandwiches.component.html',
  styleUrls: ['./view-sandwiches.component.sass']
})
export class ViewSandwichesComponent implements OnInit {
  public sandwichesList: Sandwich[] = [];

  constructor(private sandwichService: SandwichService) {
  }

  ngOnInit(): void {
    this.sandwichService.getAllSandwiches().subscribe(data => {
      console.log(data);
      this.sandwichesList = data;
    });

  }

}
