import { Component, OnInit, OnDestroy} from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Review } from '../models/review';
import { NycMovieService } from '../services/nycservice';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  movieName="";
  params$ !: Subscription;
  reviews !: Review[];
  
  

  constructor( private nycMovieSvc: NycMovieService, private actRoute: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
    this.params$ = this.actRoute.params.subscribe(
      async (params) => {
        this.movieName = params['movieName'];
        //console.log(this.movieName);
        const r = await this.nycMovieSvc.searchMovie(this.movieName);
        console.log(r);
        if(r === undefined || r.length == 0)
        {
          this.router.navigate(['/review',"movieNotFound"]);
        }
        else
        {
          this.reviews = r;
        }
        
      }
    )
    //console.log(this.reviews);
  }

  back()
  {
    this.router.navigate(['/']);
  }

  goComment(movName:string)
  {
    //const queryParams: Params = { charParam: this.movieName+ '|' + movName };
    //this.router.navigate(['/comment'], {queryParams : queryParams})
  }
}
