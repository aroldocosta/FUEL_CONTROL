import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {

  constructor() {

  }

    // $("#menu-toggle").click(function(e) {
    //     e.preventDefault();
    //     $("#wrapper").toggleClass("toggled");
    // });
    
    // For v2 [data-toggle="dropdown"] is required for [data-submenu].
    // For v2 .dropdown-submenu > [data-toggle="dropdown"] is forbidden.
    //  $('[data-submenu]').submenupicker();
     
/* 	$(document).ready(function(){
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body"; 
        $('.datepicker').datepicker({
            format:  "dd/mm/yyyy",
            language: "pt-BR",
            todayBtn: true,
            container: container,
            todayHighlight: true,
            autoclose: true,
        });
    }); */
}
