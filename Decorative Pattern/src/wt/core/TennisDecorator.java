package wt.core;

public abstract class TennisDecorator implements CourtBooking {

	@Override
	public String getInfo() {
		return "This is decorator class";
	}

	@Override
	public abstract Double getCost();
}
