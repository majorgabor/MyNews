import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { UiModule } from './modules/ui/ui.module';
import { AppRouterModule } from './modules/app-router/app-router.module';
import { HttpClientModule } from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { NewsComponent } from './components/news/news.component';
import { NewslistComponent } from './components/newslist/newslist.component';
import { NewsViewComponent } from './components/news-view/news-view.component';
import { AddnewsformComponent } from './components/addnewsform/addnewsform.component';
import { LoginViewComponent } from './components/login-view/login-view.component';
import { LoginformComponent } from './components/loginform/loginform.component';


@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    NewslistComponent,
    NewsViewComponent,
    AddnewsformComponent,
    LoginViewComponent,
    LoginformComponent,
  ],
  imports: [
    BrowserModule,
    UiModule,
    AppRouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
