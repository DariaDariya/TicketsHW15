import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    private TicketRepository repo = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, "MSK", "SPB", 200, 93);
    private Ticket ticket2 = new Ticket(2, "MSK", "SPB", 300, 97);
    private Ticket ticket3 = new Ticket(3, "MSK", "UFA", 400, 125);
    private Ticket ticket4 = new Ticket(4, "MSK", "LA", 500, 133);
    private Ticket ticket5 = new Ticket(5, "NEW", "SPB", 600, 116);

    @BeforeEach
    public void setup() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
    }

    @Test
    public void testGetTicket() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);


        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testRemoveNotExistedId() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    public void testRemoveId() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.removeById(ticket2.getId());


        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findAllTickets() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test

    public void shouldLongestDuration() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.findById(ticket3.getDuration());

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test

    public void shouldAddNewTicket() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

}
