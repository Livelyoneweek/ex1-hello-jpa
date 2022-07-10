package hellojpa;

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
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);




//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team team2 = new Team();
//            team.setName("team2");
//            em.persist(team2);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeam(team2);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

//            System.out.println("~~~~~~~~~~~~~~~~~~");
//            m.getTeam().getName(); // 이 순간 초기화
//            System.out.println("~~~~~~~~~~~~~~~~~~");

            //커밋해줘야 디비 반영
            tx.commit();

//            Movie movie = new Movie();
//            movie.setDirctor("aaa");
//            movie.setActor("bbb");
//            movie.setName("바람과함께");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());




//            //팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//            //회원 저장
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
//            em.persist(member);


//            Member findMember = em.find(Member.class, 1L);

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = "+member.getName());
//            }


            //업데이트임 따로 persist 안해도됌, 트랜잭션에 의해 commit 전에 업데이트 쿼리가 나감
//            findMember.setName("HelloJPA");

            //삭제
//            em.remove(findMember);

            //생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);


        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close(); //꼭 닫아야함
        }

        emf.close();
    }
}
