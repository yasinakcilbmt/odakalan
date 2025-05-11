package com.bmt.odakalan.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
 // @Builder KALDIRILDI
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    @CreationTimestamp
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @ManyToMany
    @JoinTable(
            name = "room_members",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members = new HashSet<>();

     public Room() {
     }

     public Room(Long id, String name, String description, Instant createdAt, User creator, Set<User> members) {
         this.id = id;
         this.name = name;
         this.description = description;
         this.createdAt = createdAt;
         this.creator = creator;
         this.members = members;
     }

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public Instant getCreatedAt() {
         return createdAt;
     }

     public void setCreatedAt(Instant createdAt) {
         this.createdAt = createdAt;
     }

     public User getCreator() {
         return creator;
     }

     public void setCreator(User creator) {
         this.creator = creator;
     }

     public Set<User> getMembers() {
         return members;
     }

     public void setMembers(Set<User> members) {
         this.members = members;
     }

     public void addMember(User user) {
        members.add(user);
     }

     public void removeMember(User user) {
        members.remove(user);
     }
}

