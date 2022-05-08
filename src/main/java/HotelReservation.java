import java.util.HashMap;
import java.util.ArrayList;

public class HotelReservation {

	public String getCheapestHotel(String input) {

		Hotel lakewood = new Hotel();
		lakewood.setClassification(3);
		lakewood.setName("Lakewood");
		lakewood.setRegularPriceWeekdays(110.00);
		lakewood.setRewardPriceWeekdays(80.00);
		lakewood.setRegularPriceWeekend(90.00);
		lakewood.setRewardPriceWeekend(80.00);

		Hotel bridgewood = new Hotel();
		bridgewood.setClassification(4);
		bridgewood.setName("Bridgewood");
		bridgewood.setRegularPriceWeekdays(160.00);
		bridgewood.setRewardPriceWeekdays(110.00);
		bridgewood.setRegularPriceWeekend(60.00);
		bridgewood.setRewardPriceWeekend(50.00);

		Hotel ridgewood = new Hotel();
		ridgewood.setClassification(5);
		ridgewood.setName("Ridgewood");
		ridgewood.setRegularPriceWeekdays(220.00);
		ridgewood.setRewardPriceWeekdays(100.00);
		ridgewood.setRegularPriceWeekend(150.00);
		ridgewood.setRewardPriceWeekend(40.00);

		input.replace(" ", "");
		String splitInput[] = input.split(":");
		String userType = splitInput[0];
		String dates[] = splitInput[1].split(",");
		for (int i = 0; i < dates.length; i++) {
			dates[i] = dates[i].substring(dates[i].indexOf("(") + 1, dates[i].indexOf(")"));
		}

		Hotel hotels[] = { lakewood, bridgewood, ridgewood };
		HashMap<Hotel, Double> prices = new HashMap<Hotel, Double>();
		for (int i = 0; i < hotels.length; i++) {
			prices.put(hotels[i], hotels[i].checkPrice(userType, dates));
		}

		double bestPrice = prices.get(hotels[0]);
		ArrayList<Hotel> bestHotels = new ArrayList<Hotel>();
		for (Hotel hotel : prices.keySet()) {
			if (prices.get(hotel) == bestPrice) {
				bestHotels.add(hotel);
			} else if (prices.get(hotel) < bestPrice) {
				bestPrice = prices.get(hotel);
				bestHotels.clear();
				bestHotels.add(hotel);
			}
		}

		Hotel bestHotel = bestHotels.get(0);
		for (Hotel hotel : bestHotels) {
			if (hotel.getClassification() > bestHotel.getClassification()) {
				bestHotel = hotel;
			}
		}

		return bestHotel.getName();
	}

}
