import { Component } from '@angular/core';
import { AuthLayoutComponent } from '../../components/auth-layout/auth-layout.component';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { InputComponent } from '../../components/input/input.component';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { LoginRequestDTO } from '../../types/login-request.dto';

interface LoginForm {
  user: FormControl,
  password: FormControl
}

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [AuthLayoutComponent,ReactiveFormsModule, InputComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm!: FormGroup<LoginForm>;

  constructor(
    private router: Router,
    private loginService: AuthService,
    private toastr: ToastrService
  ) {
    this.loginForm = new FormGroup({
      user: new FormControl('', [Validators.required, Validators.minLength(6)]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    })
  }

  submit(){
    this.loginService.login(this.createLoginRequestDTO()).subscribe({
      next: () => {
        this.toastr.success("Login feito com sucesso!")
        this.router.navigate(['payment'])
      },
      error: () => this.toastr.error("Erro inesperado! Tente novamente mais tarde")
    })
  }

  createLoginRequestDTO(): LoginRequestDTO {
    const request: LoginRequestDTO = {
      user: this.loginForm.value.user,
      password: this.loginForm.value.password,
    }
    return request;
  }

  navigate(){
    this.router.navigate(["register"])
  }
}
