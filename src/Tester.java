import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		String[] columnNames = {"time", "gyro-x", "gyro-y", "gyro-z"};
		CSVData data = new CSVData("C:\\Users\\slo841\\workspace\\CSVData\\Test", columnNames, 1);
		System.out.println(Arrays.toString(data.getColumn(3)));
	}
	
//	public static void print(CSVData data) {
//		String[][] a = readCSVFile();
//		for (int row = 0; row < data.getNumOfRows(); row++) {
//			for (int col = 0; col < data.getNumOfCols(); col++) {
//				System.out.println(data[row][col]);
//			}
//		}
//	}
 }
