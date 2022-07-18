import beans.Album;
import beans.Artist;
import beans.Author;
import beans.Quote;

import java.util.ArrayList;
import java.util.Date;

public class BeanTest {
    public static void main(String[] args) {
        Artist migs = new Artist(1,"migs",false,"english");
        Album donda = new Album(1, migs, "billy gets" +
                " merked", new Date(-1995), 3.2, "rock");

        System.out.println(donda.getName()
        );

        Author miguel = new Author(1,"Miguel","Romero");
        Author ken = new Author(2,"Ken","Ren");
        Quote quote1 = new Quote(1,"I would care but it doesnt pay me",miguel);
        Quote quote2 = new Quote(2,"If it is then it was and it will be",miguel);
        Quote quote3 = new Quote(3,"Must be nice my boy",ken);

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote1);
        quotes.add(quote2);
        quotes.add(quote3);

        for (Quote quote: quotes){
            System.out.println(quote.getAuthor().getFirstName() + " " + quote.getAuthor().getLastName() +
                    " " +
                    "- " + quote.getContent()

            );
        }

    }
}
