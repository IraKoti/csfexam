import { Component,OnInit } from '@angular/core';
import { FormGroup,FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{
  searchForm!: FormGroup;
  movieName?: String;

  constructor( private formBuilder: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.searchForm = this.createForm();
  }

  private createForm():FormGroup
  {
    return this.formBuilder.group({
      movieName: this.formBuilder.control('',[ Validators.required, Validators.minLength(2) ])
    })
  }
  
  search()
  {
    const movieName = this.searchForm?.value['movieName'];
    this.router.navigate(['/review',movieName]);
  }

  formInvalid(): boolean {
		return this.searchForm.invalid;
	}
}
