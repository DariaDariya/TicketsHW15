import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);
    private Ticket ticket1 = new Ticket(1, "MSK", "SPB", 200, 93);
    private Ticket ticket2 = new Ticket(2, "MSK", "SPB", 300, 97);
    private Ticket ticket3 = new Ticket(3, "MSK", "UFA", 400, 125);
    private Ticket ticket4 = new Ticket(4, "MSK", "LA", 500, 133);
    private Ticket ticket5 = new Ticket(5, "NEW", "SPB", 600, 116);


    @Test
    public void testSortTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.findAll("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindOneTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("MSK", "LA");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindMostExpensiveTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("NEW", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }
}













































