/*window.onload=function(){
   console.log(getDayName("2019-08-06"));

   console.log(getDayName(new Date().setDate(new Date().getDate()+4)));
}
*/
function setMinMaxDate(minDate, maxDate)
{
    document.getElementById("datefield").setAttribute("min", minDate);
    document.getElementById("datefield").setAttribute("max", maxDate);
}

function getDayName(fecha){
    var days=new Array(7);
    days[0]="Sunday";
    days[1]="Monday";
    days[2]="Tuesday";
    days[3]="Wednesday";
    days[4]="Thursday";
    days[5]="Friday";
    days[6]="Saturday";
    var dDate=new Date(fecha);
    return days[dDate.getDay()];

}



