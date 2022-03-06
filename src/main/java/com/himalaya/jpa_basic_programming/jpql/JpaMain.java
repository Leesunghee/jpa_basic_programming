package com.himalaya.jpa_basic_programming.jpql;

import com.himalaya.jpa_basic_programming.jpashop.domain.Book;
import com.himalaya.jpa_basic_programming.jpashop.domain.Order;
import com.himalaya.jpa_basic_programming.jpashop.domain.OrderItem;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member3 member3 = new Member3();
//            member3.setUsername("member1");
//            member3.setAge(10);
//            em.persist(member3);
//
//            TypedQuery<Member3> query = em.createQuery("select m from Member3 m", Member3.class);
//            List<Member3> resultList = query.getResultList();
//            resultList.stream().forEach(member -> System.out.println("member = " + member.getUsername()));
////            Query query1 = em.createQuery("select m.username, m.age from Member3 m");
//
//            Member3 singleResult = em.createQuery("select m from Member3 m where m.username = :username", Member3.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult.getUsername() = " + singleResult.getUsername());;
//
//            List<MemberDTO> resultList1 = em.createQuery("select new com.himalaya.jpa_basic_programming.jpql.MemberDTO(m.username, m.age) from Member3 as m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = resultList1.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getAge());

//            for (int i = 0; i < 100; i++) {
//                Member3 member = new Member3();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }

//            List<Member3> resultList2 = em.createQuery("select m from Member3 m order by m.age desc", Member3.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            resultList2.stream().forEach(m -> System.out.println("member = " + m.toString()));

            em.flush();
            em.clear();

//            Team3 team = new Team3();
//            team.setName("team1");
//            em.persist(team);
//
//            Member3 member = new Member3();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setTeam(team);
//            em.persist(member);
//
////            String query2 = "select m from Member3 m left outer join m.team t";
//            String query2 = "select m from Member3 m, Team3 t where m.username = t.name";
//            List<Member3> result = em.createQuery(query2, Member3.class)
//                    .getResultList();


            em.flush();
            em.clear();

            Team3 teamA = new Team3();
            teamA.setName("팀A");
            em.persist(teamA);

            Team3 teamB = new Team3();
            teamB.setName("팀B");
            em.persist(teamB);

            Member3 member31 = new Member3();
            member31.setUsername("회원1");
            member31.setTeam(teamA);
            em.persist(member31);

            Member3 member32 = new Member3();
            member32.setUsername("회원2");
            member32.setTeam(teamA);
            em.persist(member32);

            Member3 member33 = new Member3();
            member33.setUsername("회원3");
            member33.setTeam(teamB);
            em.persist(member33);

            em.flush();
            em.clear();

            String q = "select m from Member3 m join fetch m.team t";
            List<Member3> results = em.createQuery(q, Member3.class)
                    .getResultList();

            for (Member3 m : results) {
                System.out.println("member = " + m.getUsername() + ", " + m.getTeam().getName());
            }

            em.flush();
            em.clear();

            List<Member3> resultList = em.createNamedQuery("Member3.findByUsername", Member3.class)
                    .setParameter("username", "회원1")
                    .getResultList();

            for (Member3 member3 : resultList) {
                System.out.println("member3 = " + member3);
            }

            //벌크 연산 flush 자동 호출
            int resultCount = em.createQuery("update Member3 m set m.age = 20")
                    .executeUpdate();

            em.clear();

            Member3 findMember3 = em.find(Member3.class, member31.getId());
            System.out.println("findMember3.getAge() = " + findMember3.getAge());

            System.out.println("resultCount = " + resultCount);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
