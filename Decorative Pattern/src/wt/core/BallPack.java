package wt.core;

public class BallPack extends TennisDecorator {

	private CourtBooking courtBooking;

	public BallPack(CourtBooking courtBooking) {
		super();
		this.courtBooking = courtBooking;
	}

	@Override
	public Double getCost() {
		return courtBooking.getCost() + 333.3;
	}

}
