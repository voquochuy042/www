package entities;

import jakarta.persistence.*;

import java.util.Set;

public class Role {
    private int roleId;
    private String roleName;
    private String description;
    private Status status;


    public Role() {
    }

    public Role(int roleId, String roleName, String description, Status status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
