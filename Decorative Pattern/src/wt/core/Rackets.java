package wt.core;

public class Rackets extends TennisDecorator {

	private CourtBooking courtBooking;

	public Rackets(CourtBooking courtBooking) {
		super();
		this.courtBooking = courtBooking;
	}

	@Override
	public Double getCost() {
		return courtBooking.getCost() + 222.2;
	}

}
