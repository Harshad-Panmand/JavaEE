package wt.core;

public class Coaching extends TennisDecorator {

	private CourtBooking courtBooking;

	public Coaching(CourtBooking courtBooking) {
		super();
		this.courtBooking = courtBooking;
	}

	@Override
	public Double getCost() {
		return courtBooking.getCost() + 111.1;
	}

}
