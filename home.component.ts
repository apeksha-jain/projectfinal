import { Component, OnInit } from '@angular/core';
import { ProjectServiceService } from '../project-service.service';
import { TokenizeResult } from '@angular/compiler/src/ml_parser/lexer';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private projectservice:ProjectServiceService) { }
  /* valid:boolean; */
  ngOnInit() {
  }
  checkLogin()
  {
    console.log("in check login");
    let username=(<HTMLInputElement>document.getElementById('username')).value;
    let password=(<HTMLInputElement>document.getElementById('pwd')).value;
    var valid;
    this.projectservice.validateUser(username,password).subscribe(data=>valid=data);
     console.log(valid);
   /* if(valid===true)
    {
        alert("login sucessfull");
    }
    else{
     alert("login unsuccessfull");
    } */
  }
}
