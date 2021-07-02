import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Sandwich} from '../interfaces/sandwich';
import {Comment} from '../interfaces/comment';
import {Review} from '../interfaces/review';

@Injectable({
  providedIn: 'root'
})
export class SandwichService {

  baseUrl = 'http://host.docker.internal:8085/gateway';

  constructor(private http: HttpClient) {
  }

  getAllSandwiches(): Observable<Sandwich[]> {
    return this.http.get<Sandwich[]>(this.baseUrl + '/sandwich');
  }

  getSandwichById(id: number): Observable<Sandwich> {
    return this.http.get<Sandwich>(this.baseUrl + '/sandwich/' + id);
  }

  getCommentsBySandwichId(id: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.baseUrl + '/comments/' + id);
  }

  getReviewsBySandwichId(id: number): Observable<Review[]> {
    return this.http.get<Review[]>(this.baseUrl + '/reviews/' + id);
  }
}
