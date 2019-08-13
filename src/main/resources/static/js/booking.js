document.addEventListener("DOMContentLoaded", function(event) {
	setDay();
	
  });
/*
$(document).ready(function(){
//Do something here 
    setDay();
    alert("it's working ");
    
});
*/

/**
 * retrieve a list of Booking available  and fill on table 
 *  
 */
function getBookingAvailable()
{
	
    var dateA=document.getElementById("inputdate").value;
    
    
        var http= new XMLHttpRequest();
        var url="http://localhost:8080/availablesBookings?date="+dateA;
        http.open("GET",url,true);
        http.send();
        http.onload=function(){
            if(http.status=200)
            {
                var bookings=JSON.parse(http.responseText);
                
                var tbody="";

                for(i = 0; i<bookings.length ; i++ )
                {
                	tbody +="<tr> <th scope='row'> "+ bookings[i].id_booking  +"</th> <td class='boxBooking'>" +
                	bookings[i].date + "<br>"+
                    bookings[i].time + "</td>"+
                    "<td>"+
                    " <button onclick='passBooking()' type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#myModal'>Book</button>"+
                    " </td>"+
                    " </tr> ";
                }
                document.getElementById("idBody").innerHTML = tbody;
                //console.log(bookings);
            }
            else if(http.status=500){
               /* var data=JSON.parse(http.responseText);
                document.getElementById("msg").innerHTML="Unable to .." + http.status.message;
                */
            }
            else{
                //ocument.getElementById("").innerHTML="Server Error";
            }
        }
}

/**
 * current date and label by default
 */
function setDay(){

    document.getElementById("inputdate").valueAsDate=new Date();
    var lbDay=document.getElementById("inputdate").value;
    var dt=new Date(lbDay).getDay();
    document.getElementById("labelDay").innerHTML=getDayName(dt);
    //document.getElementById("inputdate").setAttribute("",'');
    //Find bookings
    getBookingAvailable();
}

//optional, no implemented
function nextdate(n)
{
    //Current date on inputDate
    var inputD= document.getElementById("inputdate").value;
    if(inputD != "")
    {
        var newDay=new Date(inputD);       
        // it increment day by one
        newDay.setDate(newDay.getDate()+1);
        //It put date into textbox inputDate
        document.getElementById("inputdate").valueAsDate= new Date(newDay);
        var dateNew = newDay.getDay();
        document.getElementById("labelDay").innerHTML=getDayName(dateNew);
        //console.log(CurrrenteDate);
    }
}

/**
 * 0 = decrease
 * 1 = increase
 * recibe a param as signel to do a specific job
 * Upgrade the label and input  date
 */
function changeDate(cd)
{
    //Current date on inputDate
    var inputD= document.getElementById("inputdate").value;
    if(inputD != "")
    {
        
        var newDay=new Date(inputD);
        // it increment day by one
        if(cd == 0){
            newDay.setDate(newDay.getDate()- 1);
        } else if(cd ==1){
            //it decreases the date by one    
            newDay.setDate(newDay.getDate()+1);
        }
       
        var dateNew = newDay.getDay();
            //upgrade the input date
        document.getElementById("inputdate").valueAsDate= new Date(newDay);
        //upgrade label for input date
        document.getElementById("labelDay").innerHTML=getDayName(dateNew);
        //console.log(CurrrenteDate);

      //call to function getBookingavailable() to retrieve and fill data
        getBookingAvailable();
        
    }
}

/**
 * event onChange 
 * it work when 
 *  */
function onChangeDate(){
    var inputD= document.getElementById("inputdate").value;
    if(inputD !="")
    {
        var newDay=new Date(inputD);
        var dateNew = newDay.getDay();
        document.getElementById("labelDay").innerHTML=getDayName(dateNew);    
        
        //call to function getBookingavailable() to retrieve and fill data
        getBookingAvailable();

    }else{document.getElementById("labelDay").innerHTML="Select a date";}
}

/**
 * param String Date
 * return Day
 */
function getDayName(dDate){
    var days=new Array(7);
    days[0]="Sunday";
    days[1]="Monday";
    days[2]="Tuesday";
    days[3]="Wednesday";
    days[4]="Thursday";
    days[5]="Friday";
    days[6]="Saturday";

    //var dDate=new Date();
    //return days[dDate.getDay()];
    return days[dDate];
   // return days;
}

//Pass data from the table to the form book
function passBooking()
{
    var tbl =document.getElementById("tableBooking");
    for(var i=1 ; i<tbl.rows.length;i++)
    {
        tbl.rows[i].onclick=function()
        {
        	document.getElementById("codeInput").value=this.cells[0].innerHTML;
        	document.getElementById("dateTime").innerHTML=this.cells[1].innerHTML;
        }
    }
}