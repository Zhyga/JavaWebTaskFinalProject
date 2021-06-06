package by.epam.webproject.tags;


import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.Participant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code BetsTableTag} class represents bets table tag
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class BetsTableTag extends TagSupport {
    private static final Logger logger = LogManager.getLogger();
    private ArrayList<Participant> participants;
    private ArrayList<Bet> bets;

    /**
     * Sets participants
     *
     * @param participants the participants
     */
    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    /**
     * Sets bets
     *
     * @param bets the bets
     */
    public void setBets(ArrayList<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public int doStartTag() {
        try {
            for (int i = 0; i < participants.size(); i++) {
                pageContext.getOut().write("<tr style=\"vertical-align: middle\">\n" +
                        "<td>" + participants.get(i).getJockey() + "</td>\n" +
                        "<td>" + participants.get(i).getHorse() + "</td>\n" +
                        "<td>" + participants.get(i).getWeight() + "</td>\n");
                if (bets.size() != 0) {
                    pageContext.getOut().write("<td>" + bets.get(i).getFirstMultiplier() + "</td>\n" +
                            "<td>\n" +
                            "<form action=\"controller\" method=\"post\">\n" +
                            "<input type=\"text\" name=\"betSize\" title=\"Bet size\">\n" +
                            "<button type=\"submit\" name=\"command\" value=\"place_bet\">Bet</button>\n" +
                            "<input type=\"hidden\" name=\"betId\" value=" + bets.get(i).getBetId() + ">\n" +
                            " </form>\n" +
                            "</td>\n" +
                            "</tr>\n");
                }
            }
        } catch (IOException e) {
            logger.error("Error while writing to out stream", e);
        }
        return SKIP_BODY;
    }

}
