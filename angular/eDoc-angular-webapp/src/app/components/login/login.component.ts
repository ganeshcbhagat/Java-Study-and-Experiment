import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

users$: Object;

  constructor(private login: LoginService) { }

  ngOnInit() {
     /*this.login.getUsers().subscribe(
      data => this.users$ = data
    );*/
  }

}