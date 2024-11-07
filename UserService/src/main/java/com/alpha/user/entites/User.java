package com.alpha.user.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "micro_users")
public class User {

	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "NAME", length = 20)
	private String name;
	@Column(name = "EMAIL", length = 20)
	private String email;
	@Column(name = "ABOUT", length = 20)
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList<Rating>();

}
