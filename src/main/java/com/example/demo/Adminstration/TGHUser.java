package com.example.demo.Adminstration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="SC_USERS", schema = "BPM_ADMINISTRATION")
public class TGHUser {
	
	@Column(name="USER_NAME")
	private String UserName;
	
	@Column(name="EMAIL_ADDRESS")
	private String EmailAddress;
	
	@Column(name="USER_ID")
	@Id
	private Long UserId;
	
	@Column(name="DISPLAY_NAME")
	private String DisplayName;
	
	@Column(name="LAST_MODIFIED_BY")
	private String LastModifiedBy;
	
	@Column(name="ORG_UNIT_ID")
	private Long OrgUnitId;
	
	@Column(name="USER_PASSWORD")
	private String UserPassword;
	
	@Column(name="PASSWORD_ENC")
	private String PasswordEnc;
	
	@Column(name="ENABLED")
	private Integer Enabled;
	
	@Column(name="ACTIVE")
	private Integer Active;
	
	@Column(name="USER_TYPE")
	private String UserType;
	
	@Transient
	private List<Role> roles;
	
	@Transient
	private List<UserPermission> permissions;
	
	public TGHUser() {
		
	}

	public TGHUser(String userName, String emailAddress, Long userId, String displayName, String lastModifiedBy,
			Long orgUnitId, String userPassword, String passwordEnc, Integer enabled, Integer active, String userType,
			List<com.example.demo.Adminstration.Role> roles,
			List<com.example.demo.Adminstration.UserPermission> permissions) {
//		super();
		UserName = userName;
		EmailAddress = emailAddress;
		UserId = userId;
		DisplayName = displayName;
		LastModifiedBy = lastModifiedBy;
		OrgUnitId = orgUnitId;
		UserPassword = userPassword;
		PasswordEnc = passwordEnc;
		Enabled = enabled;
		Active = active;
		UserType = userType;
		this.roles = roles;
		this.permissions = permissions;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public String getDisplayName() {
		return DisplayName;
	}

	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}

	public String getLastModifiedBy() {
		return LastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}

	public Long getOrgUnitId() {
		return OrgUnitId;
	}

	public void setOrgUnitId(Long orgUnitId) {
		OrgUnitId = orgUnitId;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getPasswordEnc() {
		return PasswordEnc;
	}

	public void setPasswordEnc(String passwordEnc) {
		PasswordEnc = passwordEnc;
	}

	public Integer getEnabled() {
		return Enabled;
	}

	public void setEnabled(Integer enabled) {
		Enabled = enabled;
	}

	public Integer getActive() {
		return Active;
	}

	public void setActive(Integer active) {
		Active = active;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<UserPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<UserPermission> permissions) {
		this.permissions = permissions;
	}
	
	public List<String> getPermissionsStrings() {
		
		List<String> permissionsStrings = new ArrayList<String>();
		permissions.forEach( permission -> {
			permissionsStrings.add(permission.getPERMISSION_NAME());
		});
		
		return permissionsStrings;
	}
	
	public List<String> getRolesStrings() {
		
		List<String> rolesStrings = new ArrayList<String>();
		roles.forEach( role -> {
			rolesStrings.add(role.getRoleName());
		});
		
		return rolesStrings;
	}


	@Override
	public String toString() {
		return "TGHUser [UserName=" + UserName + ", EmailAddress=" + EmailAddress + ", UserId=" + UserId
				+ ", DisplayName=" + DisplayName + ", LastModifiedBy=" + LastModifiedBy + ", OrgUnitId=" + OrgUnitId
				+ ", UserPassword=" + UserPassword + ", PasswordEnc=" + PasswordEnc + ", Enabled=" + Enabled
				+ ", Active=" + Active + ", UserType=" + UserType + ", roles=" + roles + ", permissions=" + permissions
				+ "]";
	}
	
	

}
