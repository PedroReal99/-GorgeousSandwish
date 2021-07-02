import {Component, OnInit} from '@angular/core';
import {Sandwich} from '../../interfaces/sandwich';
import {SandwichService} from '../../services/sandwich.service';
import {ActivatedRoute} from '@angular/router';
import {Comment} from '../../interfaces/comment';
import {Designation} from '../../interfaces/designation';
import {Review} from '../../interfaces/review';

@Component({
  selector: 'app-sandwich-detail',
  templateUrl: './sandwich-detail.component.html',
  styleUrls: ['./sandwich-detail.component.sass']
})
export class SandwichDetailComponent implements OnInit {
  comments: Comment[] = [];
  sandwich: Sandwich;
  id: any;
  reviews: Review[] = [];

  constructor(private sandwichService: SandwichService, private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
    this.sandwich = {sandwichId: -1, designation: {designation: ''}, description: {description: ''}, type: {type: ''}};
  }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.sandwichService.getSandwichById(this.id).subscribe(sandwich => this.sandwich = sandwich/**{
      /**this.sandwich.sandwichId = sandwich.sandwichId;
      this.sandwich.designation.designation = sandwich.designation.designation;
      this.sandwich.description.description = sandwich.description.description;
      this.sandwich.type.type = sandwich.type.type;
    }*/);

    this.sandwichService.getCommentsBySandwichId(this.id).subscribe(comments => this.comments = comments/**comments.forEach(comment => {
        this.comments.push({
          description: comment.description.description,
          sandwichId: comment.sandwichId,
          userId: comment.userId,
        });
      }
    )*/);


    this.sandwichService.getReviewsBySandwichId(this.id).subscribe(reviews => this.reviews = reviews/**comments.forEach(comment => {
        this.comments.push({
          description: comment.description.description,
          sandwichId: comment.sandwichId,
          userId: comment.userId,
        });
      }
     )*/);


  }





}
