import { Component, OnInit, OnDestroy} from '@angular/core';
import { FormGroup,FormBuilder, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { NycMovieService } from '../services/nycservice';
import { Comment } from '../models/comment';

@Component({
  selector: 'app-postcomment',
  templateUrl: './postcomment.component.html',
  styleUrls: ['./postcomment.component.css']
})
export class PostcommentComponent implements OnInit{

  commentForm!: FormGroup;
  commentMovie="";
  params$ !: Subscription;
  comment !: Comment;
  charParam!: any;  

  constructor( private nycMovieSvc: NycMovieService, private actRoute: ActivatedRoute,
    private router: Router, private formBuilder: FormBuilder) {}
  ngOnInit(): void {
    this.commentForm = this.createForm();
    this.params$ = this.actRoute.params.subscribe(
      async (params) => {
       this.commentMovie = params['commentMovie'];       
     }
   );
    console.log(this.params$);
  }

  private createForm():FormGroup
  {
    return this.formBuilder.group({
      posterName: this.formBuilder.control('',[ Validators.required, Validators.minLength(3) ]),
      commentRating: this.formBuilder.control(1,[ Validators.required ]),
      comment: this.formBuilder.control('',[ Validators.required ]),
    })
  }

  postComment()
  {
    const commentFormVal = this.commentForm?.value['comment'];
    const c = {} as Comment;
    c.comment_movie = this.commentMovie;
    c.poster_name = this.commentForm.value['posterName'];
    c.comment_rating = this.commentForm.value['commentRating'];
    c.comment = this.commentForm.value['comment'];
    console.log(c);
    this.nycMovieSvc.saveComment(c);
    this.router.navigate(['/']);
  }

  back()
  {

  }
  formInvalid(): boolean {
		return this.commentForm.invalid;
	}
}
