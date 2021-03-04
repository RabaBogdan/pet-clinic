package service;

import model.Consult;
import model.Pet;
import model.Veterinarian;
import repository.ConsultDao;
import repository.PetDao;

import java.io.IOException;

import com.opencsv.CSVReader;
import repository.VeterinarianDao;

import java.io.FileReader;
import java.util.Scanner;

public class ImportCsv {

    public static void importCsvPet() throws IOException {
        System.out.println("Introduceti locatia fisierului");
        Scanner scanner = new Scanner(System.in);
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));

        StringBuffer buffer = new StringBuffer();
        String[] line;
        while ((line = csvReader.readNext()) != null) {

            PetDao petDao = new PetDao();
            Pet pet = new Pet();

            pet.setRace(line[0]);
            pet.setBirthDate(line[1]);
            pet.setVaccinated(Boolean.parseBoolean(line[2]));
            pet.setOwnerName(line[3]);
            petDao.createPet(pet);
            System.out.print(line + " ");

            System.out.println(" ");
        }
    }


    public static void importCsvVet() throws IOException {
        System.out.println("Introduceti locatia fisierului");
        Scanner scanner = new Scanner(System.in);
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        StringBuffer buffer1 = new StringBuffer();
        String[] line1;
        while ((line1 = csvReader.readNext()) != null) {

            VeterinarianDao veterinarianDao = new VeterinarianDao();
            Veterinarian veterinarian = new Veterinarian();

            veterinarian.setFirstName(line1[0]);
            veterinarian.setLastName(line1[1]);
            veterinarian.setAddress(line1[2]);
            veterinarian.setSpeciality(line1[3]);
            veterinarianDao.createVeterinarian(veterinarian);
            System.out.print(line1 + " ");

            System.out.println(" ");
        }
    }

    public static void importCsvConsult() throws IOException {
        System.out.println("Introduceti locatia fisierului");
        Scanner scanner = new Scanner(System.in);
        String location = scanner.next();
        CSVReader csvReader = new CSVReader(new FileReader(location));
        StringBuffer buffer1 = new StringBuffer();
        String[] line1;
        while ((line1 = csvReader.readNext()) != null) {

            ConsultDao consultDao = new ConsultDao();
            Consult consult = new Consult();
            VeterinarianDao veterinarianDao1 = new VeterinarianDao();
            PetDao petDao1 = new PetDao();
            consult.setDate(line1[0]);
            consult.setDescription(line1[1]);
            veterinarianDao1.findByIdVeterinarian(Long.parseLong(line1[2]));
            petDao1.findByIdPet(Long.parseLong(line1[3]));
            consultDao.createConsult(consult);
            System.out.print(line1 + " ");

            System.out.println(" ");
        }
    }
}


