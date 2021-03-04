import model.Consult;
import model.Veterinarian;
import repository.VeterinarianDao;
import service.PetClinicService;
import utility.HibernateUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        PetClinicService.showOption();
        Scanner scanner = new Scanner(System.in);




        HibernateUtil.shutdown();

    }
}
