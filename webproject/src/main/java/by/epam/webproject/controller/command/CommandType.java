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
    TO_SIGN_UP{
        {
            this.command = new ToSignUpPageCommand();
        }
    };

    Command command;

    public Command getCommand(){
        return command;
    }
}
