package com.himalaya.jpa_basic_programming.relation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member2 member2 = new Member2();
            member2.setUsername("member1");
            member2.changeTeam(team);
            member2.setCreateBy("Lee");
            member2.setCreateDateTime(LocalDateTime.now() );
            member2.setHomeAddress(new Address2("city", "street", "10"));
            member2.setPeriod(new Period());

            member2.getAddressHistory().add(new AddressEntity("old1", "street1", "1"));
            member2.getAddressHistory().add(new AddressEntity("old2", "street2", "2"));

            member2.getFavoriteFoods().add("치킨");
            member2.getFavoriteFoods().add("족발");
            member2.getFavoriteFoods().add("피자");

            System.out.println("1. member2 = " + member2.getId());
            em.persist(member2);

            System.out.println("2. member2 = " + member2.getId());
            em.flush();
            em.clear();

            System.out.println("3. member2 = " + member2.getId());

            System.out.println("===========================");
            Member2 findMember2 = em.find(Member2.class, member2.getId());
            System.out.println("findMember2 = " + findMember2.getId());
            Address2 homeAddress = findMember2.getHomeAddress();
            findMember2.setHomeAddress(new Address2("newCity", homeAddress.getStreet(), homeAddress.getZipcode()));

            //치킨 -> 한식
            findMember2.getFavoriteFoods().remove("치킨");
            findMember2.getFavoriteFoods().add("한식");

            //old1 -> new1
            findMember2.getAddressHistory().remove(new AddressEntity("old1", "street1", "1"));
            findMember2.getAddressHistory().add(new AddressEntity("new1", "street1", "1"));

//            team.getMembers().add(member2);

//            em.flush();
//            em.clear();

            Member2 findMember = em.find(Member2.class, member2.getId());
            Team findTeam = findMember.getTeam();
            List<Member2> members = findTeam.getMembers();

//            for (Member2 member : members) {
//                System.out.println("m = " + member.getUsername());
//            }
            members.stream().forEach(m -> System.out.println("m = " + m.getUsername()));


            System.out.println("findTeam = " + findTeam.getName());



            //

            Movie2 movie = new Movie2();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
