import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { DownstreamBackendService } from '../downstream-backend.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-dashboard-smart',
  templateUrl: './employee-dashboard-smart.component.html',
  styleUrls: ['./employee-dashboard-smart.component.css']
})
export class EmployeeDashboardSmartComponent implements OnInit {
  employee:any;
  @Output()  employeeEmit:EventEmitter<any>=new EventEmitter();
  constructor(private downstreamService:DownstreamBackendService,private route:ActivatedRoute) { }
  
  ngOnInit() {
    let employeeId;
    this.route.paramMap.subscribe(
      (params)=>{
       employeeId=params.get('id');
      }
    );
    this.downstreamService.getEmployee(employeeId).subscribe((data)=>{
      this.employee=data;
      console.log(this.employee);
      this.employeeEmit.emit(this.employee);
    });

  }

}
