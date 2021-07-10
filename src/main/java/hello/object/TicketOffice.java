package hello.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket[] tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTickets() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount){
        this.amount+=amount;
    }

    public void sellTicketTo(Audience audience){
        this.plusAmount(audience.buy(this.getTickets()));
        //audience에 대한 의존성이 추가됨. 자율성을 얻는 대신 결합도가 높아짐
    }
}
