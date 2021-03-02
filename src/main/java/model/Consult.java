package model;

import javax.persistence.*;

@Entity
@Table(name = "consult")

public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idConsult;

    @Column(name = "date")
    private String date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Consult() {
    }

    public Consult(String date, String description, Veterinarian veterinarian, Pet pet) {
        this.date = date;
        this.description = description;
        this.veterinarian = veterinarian;
        this.pet = pet;
    }

    public Long getIdConsult() {
        return idConsult;
    }

    public void setIdConsult(Long idConsult) {
        this.idConsult = idConsult;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "idConsult=" + idConsult +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", veterinarian=" + veterinarian +
                ", pet=" + pet +
                '}';
    }
}