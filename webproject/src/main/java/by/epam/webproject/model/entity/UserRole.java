package by.epam.webproject.model.entity;

public enum UserRole {
    USER{
        {
            this.roleId = 1;
            this.roleName = "user";
        }
    },
    BOOKMAKER{
        {
            this.roleId = 2;
            this.roleName = "bookmaker";
        }
    },
    ADMIN{
        {
            this.roleId = 3;
            this.roleName = "admin";
        }
    };

    int roleId;
    String roleName;

    UserRole() {
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
