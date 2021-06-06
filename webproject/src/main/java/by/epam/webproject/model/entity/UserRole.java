package by.epam.webproject.model.entity;

/**
 * The {@code UserRole} enum represents role entity
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public enum UserRole {
    GUEST{
        {
            this.roleId = 0;
            this.roleName = "guest";
        }
    },
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
    /**
     * The value is used for role id storage.
     */
    int roleId;

    /**
     * The value is used for role name storage.
     */
    String roleName;

    UserRole() {
    }

    /**
     * Gets role id
     *
     * @return the role id
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Gets role name
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }
}
