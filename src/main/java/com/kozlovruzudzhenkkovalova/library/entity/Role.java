package com.kozlovruzudzhenkkovalova.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "role_id")
  private Long id;

  @Column(name = "role_name", nullable = false, unique = true, length = 35)
  @Size(min = 3, max = 35)
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;
}
