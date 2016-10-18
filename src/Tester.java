import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		String[] columnNames = {"time", "gyro-x", "gyro-y", "gyro-z"};
		CSVData data = new CSVData("C:\\Users\\slo841\\workspace\\CSVData\\Test", columnNames, 1);
		System.out.println((data));
	}
 }
