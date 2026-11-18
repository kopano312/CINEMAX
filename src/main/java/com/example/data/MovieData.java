package com.example.data;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Movie;

public class MovieData {

    public static List<Movie> getActionMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("The Dark Knight", "Action", 2008, "EXeTwQWrcwY", "https://image.tmdb.org/t/p/w300/qJ2tW6WMUDux911r6m7haRef0WH.jpg", "Batman faces the Joker in a battle for Gotham's soul."));
        list.add(new Movie("Mad Max: Fury Road", "Action", 2015, "hEJnMQG9ev8", "https://image.tmdb.org/t/p/w300/hA2ple9q4qnwxp3hKVNhroipsir.jpg", "In a post-apocalyptic wasteland, Max joins Furiosa to flee a tyrant."));
        list.add(new Movie("John Wick", "Action", 2014, "C0BMx-qxsP4", "https://image.tmdb.org/t/p/w300/fZPSd91yGE9fCcCe6OoQr6E3Bev.jpg", "A retired hitman returns to the underworld to avenge his dog."));
        list.add(new Movie("Gladiator", "Action", 2000, "owK1qxDselE", "https://image.tmdb.org/t/p/w300/ty8TGRuvJLPUmAR1H1nRIsgwvim.jpg", "A Roman general seeks revenge against the emperor who betrayed him."));
        list.add(new Movie("Die Hard", "Action", 1988, "jaJuwKCmJbY", "https://image.tmdb.org/t/p/w300/vF2r0Kg8X0a0n0x0x0x0x0x0x.jpg", "An NYPD officer battles terrorists in a Los Angeles skyscraper."));
        list.add(new Movie("Inception", "Action", 2010, "YoHD9XEInc0", "https://image.tmdb.org/t/p/w300/oYuLEt3zVCKq57qu2F8dT7NIa6f.jpg", "A thief enters dreams to steal secrets and plant an idea."));
        list.add(new Movie("The Matrix", "Action", 1999, "vKQi3bBA1y8", "https://image.tmdb.org/t/p/w300/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg", "A hacker discovers reality is a simulation and joins the resistance."));
        list.add(new Movie("Top Gun: Maverick", "Action", 2022, "qSqVVswa420", "https://image.tmdb.org/t/p/w300/62HCnUTziyWcpDaBO2i1DX17ljH.jpg", "Maverick trains a new generation of pilots for a dangerous mission."));
        return list;
    }

    public static List<Movie> getComedyMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("The Grand Budapest Hotel", "Comedy", 2014, "1Fg5iWmQjwk", "https://image.tmdb.org/t/p/w300/eWdyYQreja6JGCzqHWXpWHDrrPo.jpg", "A concierge and his lobby boy become embroiled in a caper."));
        list.add(new Movie("Superbad", "Comedy", 2007, "4eaZ_48ZYog", "https://image.tmdb.org/t/p/w300/ek8e8txUyUwd2BNqj6lFEerJfbq.jpg", "Two high school friends try to make the most of their last party."));
        list.add(new Movie("The Hangover", "Comedy", 2009, "tcdUhdOlz9M", "https://image.tmdb.org/t/p/w300/uluhlXubGu1VxU63X9VHCLWDAYP.jpg", "Three friends wake up in Vegas with no memory of the night before."));
        list.add(new Movie("Deadpool", "Comedy", 2016, "ONHBaC-pfsk", "https://image.tmdb.org/t/p/w300/fSRb7vyIP8rQpL0I47P3qUsEKX3.jpg", "A mercenary gains healing powers and a dark sense of humor."));
        list.add(new Movie("Bridesmaids", "Comedy", 2011, "FNppLrmdyE0", "https://image.tmdb.org/t/p/w300/gJtA7hYsBMQbDx8X0v0x0x0x0x.jpg", "A woman's life unravels as she serves as her best friend's maid of honor."));
        list.add(new Movie("Anchorman", "Comedy", 2004, "MtN1YnoL46Q", "https://image.tmdb.org/t/p/w300/v0x0x0x0x0x0x0x0x0x0x0x0x0x0x.jpg", "A San Diego news anchor clashes with his female co-anchor."));
        list.add(new Movie("Groundhog Day", "Comedy", 1993, "GncQtURdcE4", "https://image.tmdb.org/t/p/w300/gCgt1WARPZaXnq523ySQEUKinCs.jpg", "A weatherman relives the same day over and over again."));
        list.add(new Movie("Crazy Rich Asians", "Comedy", 2018, "ZQ-YX-5bAs0", "https://image.tmdb.org/t/p/w300/1XxL4LJ5Dl8X0x0x0x0x0x0x0x0x0.jpg", "A woman discovers her boyfriend's family is incredibly wealthy."));
        return list;
    }

    public static List<Movie> getSciFiMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Interstellar", "Sci-Fi", 2014, "zSWdZVtXT7E", "https://image.tmdb.org/t/p/w300/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg", "Explorers travel through a wormhole to find a new home for humanity."));
        list.add(new Movie("Blade Runner 2049", "Sci-Fi", 2017, "gCcx85zbxz4", "https://image.tmdb.org/t/p/w300/aM0VYp0X0x0x0x0x0x0x0x0x0x0x.jpg", "A young blade runner uncovers a secret that could plunge society into chaos."));
        list.add(new Movie("Dune", "Sci-Fi", 2021, "n9xhJrPXop4", "https://image.tmdb.org/t/p/w300/d5NXSklXo0qyIYkgV94XAgMIckC.jpg", "Paul Atreides unites with the Fremen to avenge his family."));
        list.add(new Movie("The Martian", "Sci-Fi", 2015, "ej3ioOneTy8", "https://image.tmdb.org/t/p/w300/5BHuvQ6p9kfc091Z8RiFNhCwL4b.jpg", "An astronaut stranded on Mars must use science to survive."));
        list.add(new Movie("Arrival", "Sci-Fi", 2016, "tFMo3UJ4B4g", "https://image.tmdb.org/t/p/w300/x2FJsf1ElAgr63Y3PNPtJrcmpoe.jpg", "A linguist races to communicate with alien visitors before time runs out."));
        list.add(new Movie("Ex Machina", "Sci-Fi", 2014, "EoQuVnKhxaM", "https://image.tmdb.org/t/p/w300/btbRB7BrD887j5NrvjxceRDmaot.jpg", "A programmer is invited to test a highly advanced humanoid AI."));
        list.add(new Movie("Gravity", "Sci-Fi", 2013, "OiTiKOy59o4", "https://image.tmdb.org/t/p/w300/kZ2nZw8D681aphje8NJi8EfbL1U.jpg", "Two astronauts fight to survive after debris destroys their shuttle."));
        list.add(new Movie("Tenet", "Sci-Fi", 2020, "LdOM0x0XDMo", "https://image.tmdb.org/t/p/w300/k68nPLbIST6NP96JmTxmZijEvCA.jpg", "A protagonist learns to manipulate the flow of time to prevent a war."));
        return list;
    }

    public static List<Movie> getHorrorMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("The Conjuring", "Horror", 2013, "k10ETZ41q5o", "https://image.tmdb.org/t/p/w300/wVYREutTvI2tmxr6ujrHT704wGF.jpg", "Paranormal investigators help a family terrorized by a dark presence."));
        list.add(new Movie("Get Out", "Horror", 2017, "DzfpyUB60YY", "https://image.tmdb.org/t/p/w300/tFXcEccSQMf3lfhfXKSU9iRBpa3.jpg", "A young man uncovers a disturbing secret during a weekend getaway."));
        list.add(new Movie("A Quiet Place", "Horror", 2018, "WR7cc5t7tv8", "https://image.tmdb.org/t/p/w300/nAU74GmpUk7t5iklEp3bufwDq4n.jpg", "A family lives in silence to hide from creatures that hunt by sound."));
        list.add(new Movie("Hereditary", "Horror", 2018, "V6wWKNij_1M", "https://image.tmdb.org/t/p/w300/p9fmuz2Oj3HtEJEqbIwkFGUhVXD.jpg", "A grieving family is haunted by tragic and disturbing occurrences."));
        list.add(new Movie("It", "Horror", 2017, "xKJmEC5ieOk", "https://image.tmdb.org/t/p/w300/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg", "A group of bullied kids band together to destroy a shape-shifting monster."));
        list.add(new Movie("The Shining", "Horror", 1980, "5Cb3ik6zP2I", "https://image.tmdb.org/t/p/w300/b6ko0IKC8MdYBBPkkA1aBPLe2yz.jpg", "A family heads to an isolated hotel for the winter where a sinister presence influences the father."));
        list.add(new Movie("Halloween", "Horror", 2018, "T5k8B3W4YzM", "https://image.tmdb.org/t/p/w300/r1yazVQOdDfwqE0g5j0G4V1WqXy.jpg", "Laurie Strode comes to her final confrontation with Michael Myers."));
        list.add(new Movie("The Exorcist", "Horror", 1973, "5x0Q6Z1w7s4", "https://image.tmdb.org/t/p/w300/4ucLGcXVVSVnsfkGtbLY4XAius8.jpg", "When a young girl is possessed by a mysterious entity, her mother seeks the help of two priests."));
        return list;
    }

    public static List<Movie> getDramaMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("The Shawshank Redemption", "Drama", 1994, "6hB3S9bIaco", "https://image.tmdb.org/t/p/w300/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg", "Two imprisoned men bond over a number of years, finding solace and eventual redemption."));
        list.add(new Movie("The Godfather", "Drama", 1972, "sY1S34973zA", "https://image.tmdb.org/t/p/w300/3bhkrj58Vtu7enYsRolD1fZdja1.jpg", "The aging patriarch of an organized crime dynasty transfers control to his reluctant son."));
        list.add(new Movie("Fight Club", "Drama", 1999, "qtRKdVHc-cE", "https://image.tmdb.org/t/p/w300/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg", "An insomniac office worker and a soap salesman form an underground fight club."));
        list.add(new Movie("Forrest Gump", "Drama", 1994, "bLvqoHBptjg", "https://image.tmdb.org/t/p/w300/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg", "The presidencies of Kennedy and Johnson, the Vietnam War, and other historical events unfold through the perspective of an Alabama man."));
        list.add(new Movie("The Green Mile", "Drama", 1999, "Ki4haFrqSrw", "https://image.tmdb.org/t/p/w300/velWPhVMQeQKcxggNEU8YmIo52R.jpg", "The lives of guards on Death Row are affected by one of their charges."));
        list.add(new Movie("Goodfellas", "Drama", 1990, "qo5jJpHtI1Y", "https://image.tmdb.org/t/p/w300/aKuFiU82s5ISJpGZp7YkIr3kCUd.jpg", "The story of Henry Hill and his life in the mob."));
        list.add(new Movie("Schindler's List", "Drama", 1993, "gG22XNhtnoY", "https://image.tmdb.org/t/p/w300/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg", "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce."));
        list.add(new Movie("Whiplash", "Drama", 2014, "7d_jQycdQGo", "https://image.tmdb.org/t/p/w300/7fn624j5lj3xTme2SgiLCeuedmO.jpg", "A promising young drummer enrolls at a cut-throat music conservatory."));
        return list;
    }

    public static List<Movie> getTvShows() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Stranger Things", "Sci-Fi", 2016, "b9EkMc79ZSU", "https://image.tmdb.org/t/p/w300/49WJfeN0moxb9IPfGn8AIqMGskD.jpg", "When a young boy vanishes, a small town uncovers a mystery involving secret experiments."));
        list.add(new Movie("Breaking Bad", "Drama", 2008, "HhesaQXLuRY", "https://image.tmdb.org/t/p/w300/3xnWaLQjelJDDF7LT1WBo6f4BRe.jpg", "A high school chemistry teacher turned methamphetamine manufacturer."));
        list.add(new Movie("The Mandalorian", "Action", 2019, "aOC8E8z_ifw", "https://image.tmdb.org/t/p/w300/eU1i6eHXlzMOlEq0ku1Rzq7Y4wA.jpg", "The travels of a lone bounty hunter in the outer reaches of the galaxy."));
        list.add(new Movie("Game of Thrones", "Fantasy", 2011, "KPLWWIOCOOQ", "https://image.tmdb.org/t/p/w300/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg", "Nine noble families fight for control over the lands of Westeros."));
        list.add(new Movie("The Witcher", "Fantasy", 2019, "ndl1W4ltcmg", "https://image.tmdb.org/t/p/w300/7vjaCdMw15FEbXyLcQ1vC5Vj0Mc.jpg", "Geralt of Rivia, a solitary monster hunter, struggles to find his place in a world."));
        list.add(new Movie("The Office", "Comedy", 2005, "LHOtME2DL4g", "https://image.tmdb.org/t/p/w300/7DJKHzAi83BmQrWLrYYOqcoKfhR.jpg", "A mockumentary on a group of typical office workers."));
        list.add(new Movie("Friends", "Comedy", 1994, "hDNNmeeJs1Q", "https://image.tmdb.org/t/p/w300/f496cm9enuEsZkSPzCwnTESEK5s.jpg", "Follows the personal and professional lives of six twenty to thirty-something-year-old friends."));
        list.add(new Movie("The Last of Us", "Drama", 2023, "uLtkt8BonwM", "https://image.tmdb.org/t/p/w300/uKvVjHNqB5VmOrdxqAt2F7J78ED.jpg", "After a global pandemic destroys civilization, a hardened survivor takes charge of a 14-year-old girl."));
        return list;
    }

    public static List<Movie> getAllMovies() {
        List<Movie> all = new ArrayList<>();
        all.addAll(getActionMovies());
        all.addAll(getComedyMovies());
        all.addAll(getSciFiMovies());
        all.addAll(getHorrorMovies());
        all.addAll(getDramaMovies());
        all.addAll(getTvShows());
        return all;
    }

    // ENHANCEMENT #3: Smarter Search Logic
    public static boolean matchesQuery(Movie movie, String query) {
        String lowerQuery = query.toLowerCase().trim();
        return movie.getTitle().toLowerCase().contains(lowerQuery) ||
               movie.getGenre().toLowerCase().contains(lowerQuery) ||
               String.valueOf(movie.getYear()).contains(lowerQuery);
    }
}