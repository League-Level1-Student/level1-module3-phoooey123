
public class Netflix {
	public static void main(String[] args) {
		Movie fancy = new Movie("Fancy Pants", 1);
		Movie happy = new Movie("Happy Gilimore", 5);
		Movie cool = new Movie("Camp Cool Kids", 2);
		Movie ex = new Movie("Expelled", 3);
		Movie Moana = new Movie("Moana", 4);

		System.out.println(happy.getTicketPrice());
		NetflixQueue nq = new NetflixQueue();
		nq.addMovie(fancy);
		nq.addMovie(happy);
		nq.addMovie(cool);
		nq.addMovie(ex);
		nq.addMovie(Moana);
		nq.printMovies();
		System.out.println("The best movie is " + nq.getBestMovie());
		System.out.println("The second best movie is " + nq.getMovie(1));
	}
}
