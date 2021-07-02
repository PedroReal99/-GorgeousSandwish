import {Component, OnInit} from '@angular/core';
import {Sandwich} from '../../interfaces/sandwich';
import {SandwichService} from '../../services/sandwich.service';
import {ActivatedRoute} from '@angular/router';
import {Comment} from '../../interfaces/comment';

@Component({
  selector: 'app-sandwich-detail',
  templateUrl: './sandwich-detail.component.html',
  styleUrls: ['./sandwich-detail.component.sass']
})
export class SandwichDetailComponent implements OnInit {
  comments: Comment[] = [];
  sandwich: Sandwich;
  id: any;

  constructor(private sandwichService: SandwichService, private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
    this.sandwich = {sandwichId: -1, designation: '', description: '', type: ''};
  }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.sandwichService.getSandwichById(this.id).subscribe(sandwich => this.sandwich = sandwich);
    this.sandwichService.getCommentsBySandwichId(this.id).subscribe(comments => this.comments = comments);
  }


}
