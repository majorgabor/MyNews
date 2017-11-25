import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { UiModule } from './modules/ui/ui.module';
import { AppRouterModule } from './modules/app-router/app-router.module';
import { HttpClientModule } from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { NewsComponent } from './components/news/news.component';
import { NewslistComponent } from './components/newslist/newslist.component';
import { NewsViewComponent } from './components/news-view/news-view.component';


@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    NewslistComponent,
    NewsViewComponent
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
