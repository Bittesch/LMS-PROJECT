import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {
  @Test
  public void testGetUserByUsername() {
    UserDAO userDAO = new UserDAO();
    User user = userDAO.getUserByUsername("testuser");
    assertNotNull(user);
  }
}