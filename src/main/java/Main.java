import model.Consult;
import model.Veterinarian;
import repository.VeterinarianDao;
import service.PetClinicService;
import utility.HibernateUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PetClinicService.showOption(1);
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        System.out.println(option);
        PetClinicService.showOption(option);


        HibernateUtil.shutdown();

    }
}
