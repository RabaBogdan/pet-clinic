package testing.consult;

import model.Consult;
import org.junit.jupiter.api.BeforeEach;
import repository.ConsultDao;

public class ConsultTest {
    Consult consult;
    ConsultDao consultDao;

    @BeforeEach
    void setUp() {
        consult = new Consult();
        consult.setDate("Roxana");
        consultDao = new ConsultDao();
    }
}
