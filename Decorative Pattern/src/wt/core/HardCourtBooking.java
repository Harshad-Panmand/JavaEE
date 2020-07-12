package wt.core;

public class HardCourtBooking implements CourtBooking {

	@Override
	public String getInfo() {
		return "This is hard court";
	}

	@Override
	public Double getCost() {
		return 1000.0;
	}

}
