package com.kozlovruzudzhenkkovalova.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reader")
public class User implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "reader_id")
  private Long id;

  @Column(name = "full_name", length = 100)
  @Size(min = 3, max = 100)
  private String fullName;

  @Column(name = "birth")
  private Date birthDate;

  @Column(name = "address", length = 100)
  @Size(min = 5, max = 100)
  private String address;

  @Column(name = "passport", length = 50)
  @Size(min = 5, max = 50)
  private String passport;

  @Column(name = "phone", length = 15)
  @Size(min = 4, max = 15)
  private String phoneNumber;

  @Column(name = "login", unique = true, length = 25)
  @Size(min = 5, max = 25)
  private String username;

  @Column(name = "password")
  private String password;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
      name = "role_user",
      joinColumns = {@JoinColumn(name = "reader_id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")}
  )
  Set<Role> roles;

  @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  private Set<Review> reviews;

  @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  private Set<RentedEdition> rentedEditions;

}
