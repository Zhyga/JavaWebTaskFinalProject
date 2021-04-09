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
    LOG_OUT{
        {
            this.command = new LogoutCommand();
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
    TO_MAIN{
        {
            this.command = new ToMainPageCommand();
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
