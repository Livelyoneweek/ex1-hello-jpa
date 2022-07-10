package hellojpa;

import hellojpa.domain.Address;
import hellojpa.domain.Child;
import hellojpa.domain.Movie;
import hellojpa.domain.Parent;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // 아주 쉽게 얘기하면 데이터베이스 커넥션임

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city", "street", "zipCode");

            Member member1 = new Member();
            member1.setUsername("hello");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address newAddress = new Address("newCity", address.getStreet(), address.getZipCode());
            member1.setHomeAddress(newAddress); //값 바꿀려면 통쨰로 바꿔라
            // 값, 객체 타입은 그냥 불변으로 만들 것!!!

            //커밋해줘야 디비 반영
            tx.commit();


        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close(); //꼭 닫아야함
        }

        emf.close();
    }
}
