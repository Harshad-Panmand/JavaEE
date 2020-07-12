package wt.core;

public class GrassCourtBooking implements CourtBooking {

	@Override
	public String getInfo() {
		return "This is grass court";
	}

	@Override
	public Double getCost() {
		return 3000.0;
	}
}
