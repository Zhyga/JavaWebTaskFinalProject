package by.epam.webproject.controller.command;

import by.epam.webproject.controller.command.impl.*;

public enum CommandType {
    SIGN_IN{
        {
            this.command = new SignInCommand();
        }
    },
    SIGN_UP{
        {
            this.command = new SignUpCommand();
        }
    },
    CHANGE_BALANCE{
        {
            this.command = new ChangeBalanceCommand();
        }
    },
    LOG_OUT{
        {
            this.command = new LogoutCommand();
        }
    },
    SWITCH_LOCALE{
        {
            this.command = new SwitchLocaleCommand();
        }
    },
    CHANGE_ROLE{
        {
            this.command = new ChangeRoleCommand();
        }
    },
    DELETE_RACE{
        {
            this.command = new DeleteRaceCommand();
        }
    },
    CREATE_RACE{
        {
            this.command = new CreateRaceCommand();
        }
    },
    FIND_ALL_USERS{
        {
            this.command = new FindAllUsersCommand();
        }
    },
    FIND_BY_EMAIL{
        {
            this.command = new FindByEmailCommand();
        }
    },
    FIND_ALL_RACES{
        {
            this.command = new FindAllRacesCommand();
        }
    },
    TO_MAIN{
        {
            this.command = new ToMainPageCommand();
        }
    },
    TO_PROFILE{
        {
            this.command = new ToProfilePageCommand();
        }
    },
    TO_BET_PAGE{
        {
            this.command = new ToBetPageCommand();
        }
    },
    TO_ADMIN_USERS{
        {
            this.command = new ToAdminUsersPageCommand();
        }
    },
    TO_ADMIN_RACES{
        {
            this.command = new ToAdminRacesPageCommand();
        }
    },
    TO_ADD_RACE{
        {
            this.command = new ToAddRacePageCommand();
        }
    },
    TO_SIGN_UP{
        {
            this.command = new ToSignUpPageCommand();
        }
    },
    TO_SIGN_IN{
        {
            this.command = new ToSignInPageCommand();
        }
    };;

    Command command;

    public Command getCommand(){
        return command;
    }
}
