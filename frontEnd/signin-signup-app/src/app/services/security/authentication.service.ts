import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // http://localhost:8080/login
  executeAuthentication(email:string, password:string):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/login`,{email,password}).pipe(
      map(response =>{
        return response
      })
    );
  }


}
