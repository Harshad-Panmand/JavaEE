package wt.core;

public class Main {
	public static void main(String[] args) {
		CourtBooking courtBooking = new GrassCourtBooking();
		System.out.println(courtBooking.getInfo());
		System.out.println(courtBooking.getCost());

		courtBooking = new BallPack(courtBooking);
		System.out.println(courtBooking.getInfo());
		System.out.println(courtBooking.getCost());

		courtBooking = new Rackets(courtBooking);
		System.out.println(courtBooking.getInfo());
		System.out.println(courtBooking.getCost());

		courtBooking = new BallPack(courtBooking);
		System.out.println(courtBooking.getInfo());
		System.out.println(courtBooking.getCost());
	}
}
