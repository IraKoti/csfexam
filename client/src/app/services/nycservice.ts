import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Review } from '../models/review';
import { Comment } from '../models/comment';

@Injectable({
    providedIn: 'root',
  })

export class NycMovieService {

    private API_URL: string = "/api/search"
    private API_COM: string = "/api/comment"
    constructor( private httpClient: HttpClient) { }

    searchMovie(movieName:string): Promise<any>
    {
        const params = new HttpParams()
            .set("query",movieName);

        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        return lastValueFrom(this.httpClient
            .get<Review[]>(this.API_URL,{params: params, headers: headers}));
    }

    saveComment(c: Comment)
    {
        const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
        const body=JSON.stringify(c);
        console.log("save comment !");
        return lastValueFrom(this.httpClient.post<Comment>(this.API_COM, body, {headers: headers}));
    }
}