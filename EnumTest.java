
public class EnumTest {

	public static void main(String[] args) {
		
		DayEnum dayEnum = DayEnum.THURSDAY;
		
		switch(dayEnum) {
			case MONDAY:
				System.out.println(DayEnum.MONDAY.code);
				break;
			case TUESDAY:
				System.out.println(DayEnum.TUESDAY.code);
				break;
			case WEDNESDAY:
				System.out.println(DayEnum.WEDNESDAY.code);
				break;
			case THURSDAY:
				System.out.println(DayEnum.THURSDAY.code);
				break;
			case FRIDAY:
				System.out.println(DayEnum.FRIDAY.code);
				break;
			case SATURDAY:
				System.out.println(DayEnum.SATURDAY.code);
				break;
			case SUNDAY:
				System.out.println(DayEnum.SUNDAY.code);
			default:
				System.out.println("Invalid");
				
		}
		
		for(DayEnum day : DayEnum.values()) {
			System.out.println(day.name() + " -> " + day.code);
		}
		
	}

}
