package by.epam.webproject.model.entity;

public class UserRole {
    private int roleId;
    private String roleName;

    public UserRole(int roleId,String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        UserRole userRole = (UserRole) o;

        if (roleId != userRole.roleId) {return false;}
        return roleName.equals(userRole.roleName);
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + roleName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserRole{");
        sb.append("roleId=").append(roleId);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
