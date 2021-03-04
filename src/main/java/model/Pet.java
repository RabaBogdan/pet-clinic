package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPet;

    @Column(name = "race")
    private String race;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "is_vaccinated")
    private boolean isVaccinated;

    @Column(name = "owner_name")
    private String ownerName;

    @OneToMany(mappedBy="pet")
    private List<Consult> consults;

//    @ManyToOne
//    @JoinColumn(name = "owner_id")
//    private Owner owner;


    public Pet() {
    }

    public Pet(String race, String birthDate, boolean isVaccinated, String ownerName) {
        this.race = race;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.ownerName = ownerName;
    }

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", birthDate='" + birthDate + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}