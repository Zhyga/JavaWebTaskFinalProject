package by.epam.webproject.controller.command;

import by.epam.webproject.controller.command.impl.*;

/**
 * The {@code CommandType} enum represents command type
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
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
    DEPOSIT{
        {
            this.command = new DepositCommand();
        }
    },
    WITHDRAW{
        {
            this.command = new WithdrawCommand();
        }
    },
    CHANGE_PASSWORD{
        {
            this.command = new ChangePasswordCommand();
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
    ADD_ODD{
        {
            this.command = new AddOddCommand();
        }
    },
    ADD_PARTICIPANT{
        {
            this.command = new AddParticipant();
        }
    },
    CONFIRM_EMAIL{
        {
            this.command = new ConfirmEmailCommand();
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
    PLACE_BET{
        {
            this.command = new PlaceBetCommand();
        }
    },
    CALCULATE_WINNER{
        {
            this.command = new CalculateWinnerCommand();
        }
    },
    TO_MAIN{
        {
            this.command = new ToMainPageCommand();
        }
    },
    TO_ADMIN_PARTICIPANTS{
        {
            this.command = new ToAdminParticipantsPageCommand();
        }
    },
    TO_ADD_PARTICIPANT{
        {
            this.command = new ToAddParticipantPageCommand();
        }
    },
    TO_EDIT_PARTICIPANT{
        {
            this.command = new ToAdminEditParticipantPage();
        }
    },
    EDIT_PARTICIPANT{
        {
            this.command = new EditParticipantCommand();
        }
    },
    DELETE_PARTICIPANT{
        {
            this.command = new DeleteParticipantCommand();
        }
    },
    TO_PROFILE{
        {
            this.command = new ToProfilePageCommand();
        }
    },
    TO_CHANGE_PASSWORD{
        {
            this.command = new ToChangePasswordPageCommand();
        }
    },
    TO_ADD_BALANCE{
        {
            this.command = new ToBalanceEnrichPageCommand();
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
    },
    TO_BOOKMAKER_RACES{
        {
            this.command = new ToBookmakerRacesPageCommand();
        }
    };;

    Command command;

    /**
     * Gets command
     *
     * @return the command
     */
    public Command getCommand(){
        return command;
    }
}
