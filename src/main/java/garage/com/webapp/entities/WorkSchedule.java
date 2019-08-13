package garage.com.webapp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class WorkSchedule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weeknumber;

    private String date;

    private String startstime;
    
    private String endstime;

    @ManyToOne
    @JoinColumn(name = "id_person")
    public Person person;



    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(int weeknumber) {
        this.weeknumber = weeknumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartstime() {
        return startstime;
    }

    public void setStartstime(String startstime) {
        this.startstime = startstime;
    }

    public String getEndstime() {
        return endstime;
    }

    public void setEndstime(String endstime) {
        this.endstime = endstime;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    

}