import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response.dto';
import { tap } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { RegisterRequestDTO } from '../types/register-request.dto';
import { LoginRequestDTO } from '../types/login-request.dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  

  constructor(private httpClient: HttpClient) { }

  login(loginRequest: LoginRequestDTO){
    console.log(loginRequest)
    return this.httpClient.post<LoginResponse>(
      environment.apiUrl + "/auth/login", 
      loginRequest
    ).pipe(
      tap((value) => {
        sessionStorage.setItem("auth-token", value.token)
        sessionStorage.setItem("user", value.user)
      })
    )
  }

  register(userRegister: RegisterRequestDTO){
    console.log(userRegister)
    return this.httpClient.post<LoginResponse>(
      environment.apiUrl + "/auth/register", 
      userRegister
    ).pipe(tap((value) => {
        sessionStorage.setItem("auth-token", value.token)
        sessionStorage.setItem("user", value.user)
      })
    )
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    return token !== null;
  }

  getToken(): string {
    return sessionStorage.getItem('auth-token');
  }

}
