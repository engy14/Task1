package com.example.demo.Adminstration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "SC_ROLES", schema = "BPM_ADMINISTRATION")
@Proxy(lazy = false)
public class Role {
	@Column(name="ROLE_ID")
	@Id
	private Long RoleId;
	
	@Column(name="ROLE_NAME")
	private String RoleName;
	
	@Column(name="PARENT_ROLE_ID")
	private Long ParentRoleId;
	
	@Column(name="LAST_MODIFIED_BY")
	private String LastModifiedBy;
	
	@Column(name="DESCRIPTION")
	private String Description;
	
	public Role() {
		
	}

	public Role(Long roleId, String roleName, Long parentRoleId, String lastModifiedBy, String description) {
//		super();
		RoleId = roleId;
		RoleName = roleName;
		ParentRoleId = parentRoleId;
		LastModifiedBy = lastModifiedBy;
		Description = description;
	}

	@Override
	public String toString() {
		return "Role [RoleId=" + RoleId + ", RoleName=" + RoleName + ", ParentRoleId=" + ParentRoleId
				+ ", LastModifiedBy=" + LastModifiedBy + ", Description=" + Description + "]";
	}

	public Long getRoleId() {
		return RoleId;
	}

	public void setRoleId(Long roleId) {
		RoleId = roleId;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public Long getParentRoleId() {
		return ParentRoleId;
	}

	public void setParentRoleId(Long parentRoleId) {
		ParentRoleId = parentRoleId;
	}

	public String getLastModifiedBy() {
		return LastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	

}
