import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginButtonComponent } from './login-button/login-button.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FinanceService } from './services/finance.service';
import { ProductDashboardComponent } from './product-dashboard/product-dashboard.component';
import { BuyProductComponent } from './buy-product/buy-product.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CarddetailsComponent } from './carddetails/carddetails.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserActivationComponent } from './user-activation/user-activation.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { FileUploadModule } from 'ng2-file-upload';


@NgModule({
  declarations: [
    AppComponent,
    LoginButtonComponent,
    ForgotPasswordComponent,
    RegistrationComponent,
    AdminComponent,
    ProductDashboardComponent,
    BuyProductComponent,
    AdminLoginComponent,
    NavbarComponent,
    UserActivationComponent,
    UpdateUserComponent,
    CarddetailsComponent,
    HomePageComponent,
    UserActivationComponent


  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatIconModule,
    AppRoutingModule,
    FileUploadModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [FinanceService],
  bootstrap: [AppComponent]
})
export class AppModule {

 }
