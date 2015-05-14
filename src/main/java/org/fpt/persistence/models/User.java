package org.fpt.persistence.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User implements Serializable {
	
	/**
	 * App-generated
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String name;
	private String password;
	private String role;
//	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	
	public User() {
		
	}
	
	public User(Integer id, String email, String name, String password) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public User(Integer id, String email, String name, String password, String role) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
//		this.userRoles = userRoles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "email", unique = true, nullable = false, length = 80)
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 41)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "role_name")
//	public Set<UserRole> getUserRoles() {
//		return this.userRoles;
//	}
//
//	public void setUserRoles(Set<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}