package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // 아주 쉽게 얘기하면 데이터베이스 커넥션임

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member findMember = em.find(Member.class, 1L);

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(1)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = "+member.getName());
            }


            //업데이트임 따로 persist 안해도됌, 트랜잭션에 의해 commit 전에 업데이트 쿼리가 나감
//            findMember.setName("HelloJPA");

            //삭제
//            em.remove(findMember);

            //생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

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
