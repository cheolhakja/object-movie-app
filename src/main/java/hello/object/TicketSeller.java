package hello.object;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = this.ticketOffice.getTickets();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket=this.ticketOffice.getTickets();
            audience.getBag().minusAmount(ticket.getFee());
            this.ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
