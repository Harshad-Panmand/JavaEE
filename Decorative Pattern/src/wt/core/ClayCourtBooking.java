package wt.core;

public class ClayCourtBooking implements CourtBooking {

	@Override
	public String getInfo() {
		return "This is clay court";
	}

	@Override
	public Double getCost() {
		return 2000.0;
	}

}
