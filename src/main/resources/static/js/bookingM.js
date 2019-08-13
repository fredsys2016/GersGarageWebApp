/**
 * it won't start executing until the doc is completed (html file).
 */
$(document).ready(function(){
    /**Do something here */
        
    
        //Local date
        var today=new Date();
        CurrrenteDate=today.getFullYear() + "-"+ (today.getMonth() + 1) + "-" + today.getDate();
    
    });

var CurrrenteDate=new Date();


/**
 * pass the value of inputDate to the modal form to save A ne Booking
 */
function passDate()
{
    var dt=document.getElementById("dayBooking").value;
    if(dt !="")
    {
        document.getElementById("inputDate").valueAsDate=new Date(dt);
    }
}

/**
 * verifica en inputdate si tiene valores  ara activa el buton  Add new booking
 */
function activaBTN()
{
    var verDate=document.getElementById("dayBooking").value;
    if(verDate !="" && new Date(verDate) >= new Date(CurrrenteDate)){
        
        document.getElementById("openNewB").disabled=false;
    }
    else{
        document.getElementById("openNewB").disabled=true;
    }
    
    
}

//Ejemplo to access table
function passBooking()
{
    var tbl =document.getElementById("tableBooking");
    for(var i=1 ; i<tbl.rows.length;i++)
    {

        tbl.rows[i].onclick=function()
        {
            alert ("done: " + this.cells[0].innerHTML + this.cells[1].innerHTML);
        }
    }
}


/**
 * verifica que el usuario introdusca el tiempo correcto example (14:30 or 14:00)
 */
function CheckTime()
{
    console.log("Checking");
    var time=document.getElementById("inputTime").value;
    var inTime=time.split(":");
    var hr=inTime[0];
    var mt=inTime[1];

    if(hr >= 8 && hr <= 18)
    {
        
        console.log("Horario de trabajo")

        var newT="30";
        if(mt >= 0 && mt <= 20)
        { 
            newT="00";
        }
        hr += ":" + newT;
        document.getElementById("inputTime").value=hr;
        var dateBo=document.getElementById("inputDate").value;
        document.getElementById("cita").innerHTML="Date  :"+ dateBo +"Time  :" +hr; 
        document.getElementById("saveBooking").disabled=false;
    }
    else{
        //disable button save
        console.log("Fuera de Horario");
        document.getElementById("saveBooking").disabled=true;
        document.getElementById("cita").innerHTML="..";
    }
}



//No finished the code
function checkSatus()
{
    var tbl =document.getElementById("listBooking");
    var r=tbl.rows;
    for(var i=1;r.length;i++)
    {
        console.log("ingreso de del loop");
        var stat=r[i].cells[0].innerHTML;
        if(stat== "Available")
        {
            r[i].cells[4].disabled=true;
            alert("function");
        }

/*
     
$(r[i]).click(function(){
            alert("s");
        });
*/
     
        var rw=r[i];
        rw.onclick = function ()
        {
            var st = this.cells[0].innerHTML;
            if(st == "Available")
            {
                alert("You are allowed delete it");
                //put update booking function here
            }
        };
    }
}
/*

$("tr").click(function(){
    alert("Function");
})
  */  
    
