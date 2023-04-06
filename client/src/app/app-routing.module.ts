import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchComponent } from './components/search.component';
import { ReviewComponent } from './components/review.component';
import { PostcommentComponent } from './components/postcomment.component';

const routes: Routes = [
  { path:'', component:SearchComponent },
  { path: 'review/:movieName', component:ReviewComponent},
  { path: 'comment/:commentMovie', component:PostcommentComponent},
  { path: '**', redirectTo: '', pathMatch: 'full'} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
