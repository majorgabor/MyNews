import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsViewComponent } from '../../components/news-view/news-view.component';
import { LoginViewComponent } from '../../components/login-view/login-view.component';
import { CommentonNewsViewComponent } from '../../components/commenton-news-view/commenton-news-view.component';
import { UserViewComponent } from '../../components/user-view/user-view.component';

const appRoutes: Routes = [
  {path: 'news', component: NewsViewComponent },
  {path: 'user', component: LoginViewComponent },
  {path: 'news/comments/:id', component: CommentonNewsViewComponent },
  {path: 'user/:id', component: UserViewComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRouterModule { }
