import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAccount } from './user-account';
@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {

  constructor(private http:HttpClient) { }

  createAccount(newuser :UserAccount):Observable<number>{
    console.log(newuser);
    return this.http.post<number>("http://localhost:5020/api/create-account",newuser);
  }

  validateUser(username:string,password:string):Observable<boolean>{
    console.log("in validate user");
    return this.http.get<boolean>("http://localhost:5020/api"+"/"+username+"/"+password);
  }
  check()
  {
    console.log("in check");
    return this.http.get("http://localhost:5020/api/check");
  }


  showbalance(userid:string):Observable<string>{
    console.log("in service");
    return this.http.get<string>("http://localhost:5020/api/show-balance"+"/"+userid);
  }
  depositAmount(amount:number,userid:string):Observable<string>{
    return this.http.put<string>("http://localhost:5020/api/deposit"+"/"+userid,amount);
  }
  withdrawAmount(amount:number,userid:string):Observable<string>{
    return this.http.put<string>("http://localhost:5020/api/withdraw"+"/"+userid,amount);
  }
  fundTransfer(amount:number,userid:string):Observable<string>{
    return this.http.put<string>("http://localhost:5020/api/fund-transfer"+"/"+userid,amount);
  }
}
