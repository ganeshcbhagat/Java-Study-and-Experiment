import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class LoginService {


constructor(private http: HttpClient) { }

signinUser(emaiID : string, password: string) {
    return this.http.get('https://*******');
  }

}