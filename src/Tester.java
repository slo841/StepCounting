
public class Tester {
	public static void main(String[] args) {
		String[] titles = {"time", "gyro-x", "gyro-y", "gyro-z"};
		CSVData data = new CSVData("CSVData//Test", titles, 0);
		System.out.println(data.getTitles());
	}
}
