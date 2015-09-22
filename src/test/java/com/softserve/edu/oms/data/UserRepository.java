package com.softserve.edu.oms.data;



public class UserRepository {

   // public static IUser getAdminUser() {
//        return new User("iva", "ivanka", "horoshko", "qwerty",
//                "mail@gmail.com", "West", "Administrator");
//        User user=new User();
//        user.setLogin("iva");
//        user.setFirstname("ivanka");
//        user.setLastname("horoshko");
//        user.setPassword("qwerty");
//        user.setEmail("mail@gmail.com");
//        user.setRegion("West");
//        user.setRole("Administrator");
//        return user;
//        return new User()
//             .setLogin("iva")
//             .setFirstname("ivanka")
//             //.setLastname("horoshko")
//             .setPassword("qwerty")
//             .setEmail("mail@gmail.com")
//             .setRegion("West")
//             .setRole("Administrator");
//        return User.get()
//                .setLogin("iva")
//                .setFirstname("ivanka")
//                .setLastname("horoshko")
//                .setPassword("qwerty")
//                .setEmail("mail@gmail.com")
//                .setRegion("West")
//                .setRole("Administrator")
//                .build();
//    }

    public static IUser getAdminUserYura() {
      return User.get()
              .setLogin("myroslav")
              .setFirstname("myroslav")
              .setLastname("shram")
              .setPassword("qwerty")
              .setEmail("mail@gmail.com")
              .setRegion("South")
              .setRole("Administrator")
              .build();
  }

    public static IUser getCustomerUser() {
        return User.get()
                .setLogin("nonelogin1")
                .setFirstname("nonefirstName1")
                .setLastname("nonelastName1")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("East")
                .setRole("Customer")
                .build();
    }

    public static IUser getInvalidUser() {
//        return new User("abcd", "abcd", "abcd", "abcd",
//                "abcd@gmail.com", "West", "Administrator");
//        User user=new User();
//        user.setLogin("abcd");
//        user.setFirstname("abcd");
//        user.setLastname("abcd");
//        user.setPassword("abcd");
//        user.setEmail("abcd@gmail.com");
//        user.setRegion("West");
//        user.setRole("Administrator");
//        return user;
        return User.get()
                .setLogin("abcd")
                .setFirstname("abcd")
                .setLastname("abcd")
                .setPassword("abcd")
                .setEmail("abcd@gmail.com")
                .setRegion("West")
                .setRole("Administrator")
                .build();
    }
    
    public static IUser getUser() {
        return User.get()
                .setLogin("orest")
                .setFirstname("orest")
                .setLastname("vovchack")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("West")
                .setRole("Administrator")
                .build();
    }

    public static IUser getAdminUser() {
        return User.get()
                .setLogin("myroslav")
                .setFirstname("myroslav")
                .setLastname("shram")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("South")
                .setRole("Administrator")
                .build();
    }


    
    public static IUser getNewUser(){
        return User.get()
                .setLogin("mistergowp")
                .setFirstname("Petro")
                .setLastname("Andrushchak")
                .setPassword("qwerty")
                .setEmail("nazarpetro@mail.com")
                .setRegion("South")
                .setRole("Administrator")
                .build();
    }

}
