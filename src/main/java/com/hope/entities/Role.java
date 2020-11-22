package com.hope.entities;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "role")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
	private Set<Account> account;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role( String name, Set<Account> account) {
		super();
		this.name = name;
		this.account = account;
	}
	public Role() {}
	

}
