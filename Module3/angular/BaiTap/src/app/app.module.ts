import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { CalculatorComponent } from "./calculator/calculator.component";
import { ColorPickerComponent } from "./color-picker/color-picker.component";
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownComponent } from './countdown/countdown.component';

@NgModule({
  declarations: [AppComponent, CalculatorComponent, ColorPickerComponent, RatingBarComponent, CountdownComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
