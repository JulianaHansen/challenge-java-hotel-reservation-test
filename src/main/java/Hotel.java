
public class Hotel {

	private String name;
	private int classification;
	private double regularPriceWeekdays;
	private double rewardPriceWeekdays;
	private double regularPriceWeekend;
	private double rewardPriceWeekend;

	public String getName() {
		return this.name;
	}

	public int getClassification() {
		return this.classification;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setClassification(int n) {
		this.classification = n;
	}

	public void setRegularPriceWeekdays(double n) {
		this.regularPriceWeekdays = n;
	}

	public void setRewardPriceWeekdays(double n) {
		this.rewardPriceWeekdays = n;
	}

	public void setRegularPriceWeekend(double n) {
		this.regularPriceWeekend = n;
	}

	public void setRewardPriceWeekend(double n) {
		this.rewardPriceWeekend = n;
	}

	double checkPrice(String userType, String dayOfTheWeek[]) {

		double totalPrice = 0;

		String weekDays = "mon tues wed thur fri";
		String weekendDays = "sun sat";

		for (int i = 0; i < dayOfTheWeek.length; i++) {

			if (userType.equals("Regular")) {
				if (weekDays.contains(dayOfTheWeek[i])) {
					totalPrice += this.regularPriceWeekdays;
				} else if (weekendDays.contains(dayOfTheWeek[i])) {
					totalPrice += this.regularPriceWeekend;
				}
			}

			else if (userType.equals("Reward")) {
				if (weekDays.contains(dayOfTheWeek[i])) {
					totalPrice += this.rewardPriceWeekdays;
				} else if (weekendDays.contains(dayOfTheWeek[i])) {
					totalPrice += this.rewardPriceWeekend;
				}
			}
		}
		return totalPrice;
	}

}
