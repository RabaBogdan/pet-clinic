package service;

import model.Consult;
import model.Pet;
import model.Veterinarian;
import repository.ConsultDao;
import repository.PetDao;
import repository.VeterinarianDao;

import java.util.Scanner;

/**
 * 1.1 Introduceti un constraint pe campurile firstname, lastname din clasa Veterinarian case sa specifice ca
 * lungimea minima a strigului este de 3 caractere.2. Implementati o interfata la consola pentru applicatia pet clinic.
 * Va afisa un meniu cu urmatoarele optiuni:
 * 0. Exit
 * 1. Create
 * 2. Update
 * 3. Detele
 * 4. List/Find
 * Dupe selectia oricarei option utilizatorul va alege tabelul pentru care doreste sa faca aceasta operatie.
 * •	In cazul unui create utilizatorul va trebui sa introduca de la tastatura toare campurile necesare pentru
 * crearea acelei entitati.
 * •	In cazul unui update utilizatorul va selecta ce camp doreste sa updateze si va introduce noua valoare.
 * •	In cazul unui delete utilizatorul va introduce id-ul entitatii ce doreste sa o stearga.
 * •	In cazul unui list/find utilizatorul poate alege sa afiseze toate intrarile din db sau sa introduca id-ul
 * entitatii ce doreste sa o afiseze.
 */

public class PetClinicService {

    public static void showMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Create");
        System.out.println("\t 2 - Update");
        System.out.println("\t 3 - Delete");
        System.out.println("\t 4 - List/Find");
    }

    public static void showOption(int option) {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Enter your choice: ");
        option = scanner.nextInt();

        switch (option) {
            case 0:
                quit = true;
                break;
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                find();
                break;

        }
    }

    public static void create() {

        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Create Veterinarian");
        System.out.println("\t 2 - Create Pet");
        System.out.println("\t 3 - Create Consult");
        System.out.println("\t 4 - return to main menu");

        System.out.println("Enter your choice: ");
        int createOption;

        Scanner scanner = new Scanner(System.in);
        createOption = scanner.nextInt();
        boolean quit = false;

        switch (createOption) {
            case 0:
                quit = true;
                break;
            case 1:
                createVeterinarian(scanner);
                break;
            case 2:
                createPet(scanner);
                break;
            case 3:
                createConsult(scanner);
                break;
            case 4:
                System.out.println("Enter your choice: ");
                showMenu();
                int x = scanner.nextInt();
                showOption(x);
                break;
        }
    }

    private static void createConsult(Scanner scanner) {
        System.out.println("Introduceti data consultatiei");
        String consultDate = scanner.next();
        System.out.println("Introduceti descrierea");
        String description = scanner.next();
        VeterinarianDao veterinarianDao1 = new VeterinarianDao();
        PetDao petDao1 = new PetDao();
        System.out.println("Introduceti id-ul veterinarului");
        long idVeterinar = scanner.nextLong();
        System.out.println("Introduceti id-ul animalului");
        long idPet = scanner.nextLong();

        ConsultDao consultDao = new ConsultDao();
        Consult consult = new Consult(consultDate, description, veterinarianDao1.findByIdVeterinarian(idVeterinar), petDao1.findByIdPet(idPet));
        consultDao.createConsult(consult);
    }

    private static void createPet(Scanner scanner) {
        System.out.println("Introduceti rasa animaluluii");
        String rasa = scanner.next();
        System.out.println("Introduceti data nastere");
        String birthdate = scanner.next();
        System.out.println("Este vaccinat? (true sau false )");
        boolean isVaccinated = scanner.nextBoolean();
        System.out.println("Introduceti numele propietarului");
        String ownerName = scanner.next();

        PetDao petDao = new PetDao();
        Pet pet = new Pet(rasa, birthdate, isVaccinated, ownerName);
        petDao.createPet(pet);
    }

    private static void createVeterinarian(Scanner scanner) {
        System.out.println("Introduceti numele veterinarului");
        String nume = scanner.next();
        System.out.println("Introduceti prenumele");
        String prenume = scanner.next();
        System.out.println("Introduceti adresa");
        String address = scanner.next();
        System.out.println("Introduceti specialitatea");
        String speciality = scanner.next();

        VeterinarianDao veterinarianDao = new VeterinarianDao();
        Veterinarian veterinarian = new Veterinarian(nume, prenume, address, speciality);
        veterinarianDao.createVeterinarian(veterinarian);
    }


    public static void update() {
        int updateOption;
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Update Veterinarian");
        System.out.println("\t 2 - Update Pet");
        System.out.println("\t 3 - Update Consult");
        System.out.println("\t 4 - Return to main menu");

        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        updateOption = scanner.nextInt();

        switch (updateOption) {
            case 0:
                break;
            case 1:
                updateVeterinarian(scanner);
                break;
            case 2:
                updatePet(scanner);
                break;
            case 3:
                updateConsult(scanner);
                break;
        }
    }

    private static void updateConsult(Scanner scanner) {
        System.out.println("Update consult");
        ConsultDao consultDao = new ConsultDao();
        System.out.println("Introduceti id-ul consultatiei care vreti sa o modificati ");
        Long idConsult = scanner.nextLong();
        Consult consult = consultDao.findByIdConsult(idConsult);
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Set date");
        System.out.println("\t 2 - Set Description");
        System.out.println("\t 3 - Return to main menu");

        System.out.println("\t Enter your choice: ");
        int updateConsult = scanner.nextInt();

        switch (updateConsult) {
            case 0:
                return;
            case 1:
                setDate(scanner, consultDao, consult);
                break;
            case 2:
                setDescription(scanner, consultDao, consult);
                break;
            case 3:
                System.out.println("Enter your choice: ");
                showMenu();
                int x = scanner.nextInt();
                showOption(x);
                break;
        }
    }

    private static void setDescription(Scanner scanner, ConsultDao consultDao, Consult consult) {
        System.out.println("Introduceti description");
        consult.setDescription(scanner.next());
        consultDao.updateConsult(consult);
    }

    private static void setDate(Scanner scanner, ConsultDao consultDao, Consult consult) {
        System.out.println("Introduceti data");
        consult.setDate(scanner.next());
        consultDao.updateConsult(consult);
    }

    private static void updatePet(Scanner scanner) {
        System.out.println("update Pet");
        PetDao petDao = new PetDao();
        System.out.println("Introduceti id-ul animalului care vreti sa il modificati ");
        Long idPet = scanner.nextLong();
        Pet pet = petDao.findByIdPet(idPet);
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Update Race");
        System.out.println("\t 2 - Update BirthDate");
        System.out.println("\t 3 - Update isVaccinated");
        System.out.println("\t 4 - Update ownerName");
        System.out.println("\t 5 - return to main menu");

        System.out.println("\t Enter your choice: ");
        int updatePet = scanner.nextInt();

        switch (updatePet) {
            case 0:
                return;
            case 1:
                rasePet(scanner, petDao, pet);
                break;
            case 2:
                birthDatePet(scanner, petDao, pet);
                break;
            case 3:
                isVacinated(scanner, petDao, pet);
                break;
            case 4:
                ownerName(scanner, petDao, pet);
                break;
            case 5:
                System.out.println("Enter your choice: ");
                showMenu();
                int x = scanner.nextInt();
                showOption(x);
                break;
        }
    }

    private static void ownerName(Scanner scanner, PetDao petDao, Pet pet) {
        System.out.println("Introduceti propietarul");
        pet.setOwnerName(scanner.next());
        petDao.updatePet(pet);
    }

    private static void isVacinated(Scanner scanner, PetDao petDao, Pet pet) {
        System.out.println("este vaccinat?");
        pet.setVaccinated(scanner.nextBoolean());
        petDao.updatePet(pet);
    }

    private static void birthDatePet(Scanner scanner, PetDao petDao, Pet pet) {
        System.out.println("Introduceti Birthdate");
        pet.setBirthDate(scanner.next());
        petDao.updatePet(pet);
    }

    private static void rasePet(Scanner scanner, PetDao petDao, Pet pet) {
        System.out.println("Introduceti rasa animalului");
        pet.setRace(scanner.next());
        petDao.updatePet(pet);
    }

    private static void updateVeterinarian(Scanner scanner) {
        System.out.println("Update veterinarian");
        VeterinarianDao veterinarianDao = new VeterinarianDao();
        System.out.println("Introduceti id-ul veterinarului care vreti sa il modificati ");
        Long idVeterinar = scanner.nextLong();
        Veterinarian veterinarian1 = veterinarianDao.findByIdVeterinarian(idVeterinar);
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Update FirstName");
        System.out.println("\t 2 - Update lastName");
        System.out.println("\t 3 - Update address");
        System.out.println("\t 4 - Update speciality");
        System.out.println("\t 5 - Return to main menu");

        System.out.println("\t Enter your choice: ");
        int updateVeterinarian = scanner.nextInt();

        switch (updateVeterinarian) {
            case 0:
                return;
            case 1:
                firstNameVeterinarian(scanner, veterinarianDao, veterinarian1);
                break;
            case 2:
                lastNameVeterinarian(scanner, veterinarianDao, veterinarian1);
                break;
            case 3:
                adressVeterinarian(scanner, veterinarianDao, veterinarian1);
                break;
            case 4:
                speciality(scanner, veterinarianDao, veterinarian1);
                break;
            case 5:
                System.out.println("Enter your choice: ");
                showMenu();
                int x = scanner.nextInt();
                showOption(x);
                break;
        }
    }

    private static void speciality(Scanner scanner, VeterinarianDao veterinarianDao, Veterinarian veterinarian1) {
        System.out.println("Introduceti specialitatea");
        veterinarian1.setSpeciality(scanner.next());
        veterinarianDao.updateVeterinarian(veterinarian1);
    }

    private static void adressVeterinarian(Scanner scanner, VeterinarianDao veterinarianDao, Veterinarian veterinarian1) {
        System.out.println("Introduceti adresa");
        veterinarian1.setAddress(scanner.next());
        veterinarianDao.updateVeterinarian(veterinarian1);
    }

    private static void lastNameVeterinarian(Scanner scanner, VeterinarianDao veterinarianDao, Veterinarian veterinarian1) {
        System.out.println("Introduceti numele");
        veterinarian1.setLastName(scanner.next());
        veterinarianDao.updateVeterinarian(veterinarian1);
    }

    private static void firstNameVeterinarian(Scanner scanner, VeterinarianDao veterinarianDao, Veterinarian veterinarian1) {
        System.out.println("Introduceti prenumele veterinarului");
        veterinarian1.setFirstName(scanner.next());
        veterinarianDao.updateVeterinarian(veterinarian1);
    }

    public static void delete() {
        int deleteOption;
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Delete Veterinar");
        System.out.println("\t 2 - Delete Pet");
        System.out.println("\t 3 - Delete Consult");
        System.out.println("\t 4 - return to main menu");

        System.out.println("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        deleteOption = scanner.nextInt();

        switch (deleteOption) {
            case 0:
                return;
            case 1:
                deleteIdVeterinarian(scanner);
                break;
            case 2:
                deleteIdPet(scanner);
                break;
            case 3:
                deleteIdConsult(scanner);
                break;
        }
    }

    private static void deleteIdConsult(Scanner scanner) {
        System.out.println("Introduceti id-ul consultatiei care vreti sa o stergeti");
        ConsultDao consultDao = new ConsultDao();
        long idcon = scanner.nextLong();
        Consult c1 = consultDao.findByIdConsult(idcon);
        consultDao.deleteConsult(c1);
    }

    private static void deleteIdPet(Scanner scanner) {
        System.out.println("Introduceti id-ul animalului care vreti sa il stergeti");
        PetDao petDao = new PetDao();
        long idpet = scanner.nextLong();
        Pet p1 = petDao.findByIdPet(idpet);
        petDao.deletePet(p1);
    }

    private static void deleteIdVeterinarian(Scanner scanner) {
        System.out.println("Introduceti id-ul veterinarului care vreti sa il stergeti");
        VeterinarianDao veterinarianDao = new VeterinarianDao();
        long idvet = scanner.nextLong();
        Veterinarian v1 = veterinarianDao.findByIdVeterinarian(idvet);
        veterinarianDao.deleteVeterinarian(v1);
    }


    public static void find() {
        int findOption;
        System.out.println("\nPress ");
        System.out.println("\t 0 - Exit.");
        System.out.println("\t 1 - Find Veterinar");
        System.out.println("\t 2 - Find Pet");
        System.out.println("\t 3 - Find Consult");
        System.out.println("\t 4 - return to main menu");

        System.out.println("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        findOption = scanner.nextInt();

        switch (findOption) {
            case 0:
                return;
            case 1:
                fiindIdVeterianrian(scanner);
                break;
            case 2:
                fiindIdPet(scanner);
                break;
            case 3:
                fiindIdConsult(scanner);
                break;
        }
    }

    private static void fiindIdConsult(Scanner scanner) {
        System.out.println("Introduceti id-ul consultatiei care vreti sa o afisati");
        ConsultDao consultDao = new ConsultDao();
        long idcon = scanner.nextLong();
        Consult c1 = consultDao.findByIdConsult(idcon);
        System.out.println(c1);
    }

    private static void fiindIdPet(Scanner scanner) {
        System.out.println("Introduceti id-ul animalului care vreti sa il afisati");
        PetDao petDao = new PetDao();
        long idpet = scanner.nextLong();
        Pet p1 = petDao.findByIdPet(idpet);
        System.out.println(p1);
    }

    private static void fiindIdVeterianrian(Scanner scanner) {
        System.out.println("Introduceti id-ul veterinarului care vreti sa il afisati");
        VeterinarianDao veterinarianDao = new VeterinarianDao();
        long idvet = scanner.nextLong();
        Veterinarian v1 = veterinarianDao.findByIdVeterinarian(idvet);
        System.out.println(v1);
    }
}