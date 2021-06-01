package my.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int passportId;

    @Column(name="sn")
    private String serialNumber;

    @Column(name="dn")
    private Date dateCreate;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id_fk", referencedColumnName = "id")
    private Person person;

    public Passport() {
    }

    public Passport(String serialNumber, Date dateCreate) {
        this.serialNumber = serialNumber;
        this.dateCreate = dateCreate;
    }

    public Passport(int id, String serialNumber, Date dateCreate) {
        this.passportId = id;
        this.serialNumber = serialNumber;
        this.dateCreate = dateCreate;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
