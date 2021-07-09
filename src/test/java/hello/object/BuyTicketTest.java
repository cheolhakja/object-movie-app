package hello.object;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BuyTicketTest {

    @Test
    void buyTicketByInvitation(){
        Ticket[] tickets = new Ticket[100];
        Arrays.fill(tickets, new Ticket());
        Theater theater = new Theater(new TicketSeller(new TicketOffice(10000L, tickets)));
        Audience audience = new Audience(new Bag(1000L, new Invitation()));
        theater.enter(audience);

        Assertions.assertThat(audience.getBag().hasTicket()).isEqualTo(true);
    }
}
