package usermanagement.service;

import org.junit.Test;
import usermanagement.entity.Person;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransformServiceTest {

    private TransformService testClass = new TransformService();

    @Test
    public void test_toUserDomain() {
        Person person = new Person();
        person.setfName("parsa");
        person.setmName("junior");
        person.setlName("eskandar");
        person.setCompanyName("company");
        person.setPersonId(1);

        User testUser = testClass.toUserDomain(person);

        User testUser2 = new User();
        testUser2.setFirstName(person.getfName());
        testUser2.setLastName(person.getlName());
        testUser2.setUserId(person.getPersonId());
        testUser2.setCompanyName(person.getCompanyName());

        assertEquals(testUser, testUser2);

        assertEquals(testUser.getFirstName(), testUser2.getFirstName());
        assertEquals(testUser.getLastName(), testUser2.getLastName());
        assertEquals(testUser.getCompanyName(), testUser2.getCompanyName());
        assertEquals(testUser.getUserId(), testUser2.getUserId());

        assertEquals(testUser.hashCode(), testUser2.hashCode());
    }

    @Test
    public void test_toUserEntity() {
        User testUser = new User();
        testUser.setFirstName("parsa");
        testUser.setLastName("eskandar");
        testUser.setCompanyName("company");
        testUser.setUserId(1);

        Person person1 = testClass.toUserEntity(testUser);

        Person person2 = new Person();
        person2.setfName(testUser.getFirstName());
        person2.setlName(testUser.getLastName());
        person2.setPersonId(testUser.getUserId());
        person2.setCompanyName(testUser.getCompanyName());

        assertEquals(person1.getfName(), person2.getfName());
        assertEquals(person1.getlName(), person2.getlName());
        assertEquals(person1.getCompanyName(), person2.getCompanyName());
        assertEquals(person1.getPersonId(), person2.getPersonId());

    }
}
