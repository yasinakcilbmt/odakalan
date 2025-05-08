package com.bmt.odakalan.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

     // @Builder KALDIRILDI
@Entity @Table(name = "users")
public class User extends Auditable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 60)
    private String displayName;

    @ManyToMany(mappedBy = "members")
    private Set<Room> rooms = new HashSet<>();

         public User() {
         }

         public User(Long id, String email, String password, String displayName, Set<Room> rooms) {
             this.id = id;
             this.email = email;
             this.password = password;
             this.displayName = displayName;
             this.rooms = rooms;
         }

         public Long getId() {
             return id;
         }

         public void setId(Long id) {
             this.id = id;
         }

         public String getEmail() {
             return email;
         }

         public void setEmail(String email) {
             this.email = email;
         }

         public String getPassword() {
             return password;
         }

         public void setPassword(String password) {
             this.password = password;
         }

         public String getDisplayName() {
             return displayName;
         }

         public void setDisplayName(String displayName) {
             this.displayName = displayName;
         }

         public Set<Room> getRooms() {
             return rooms;
         }

         public void setRooms(Set<Room> rooms) {
             this.rooms = rooms;
         }
     }
