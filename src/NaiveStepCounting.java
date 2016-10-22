
public class NaiveStepCounting {

	/***
	 * 
	 * @param times
	 * @param sensorData
	 * @return
	 */
	private static int countSteps(double[] times, double[][] sensorData) {
		double[] magnitudes = calculateMagnitudesFor(sensorData);
		
		//accelerometer data
		for (int i = 0; i <= 2; i++) {
			double[][] accData = sensorData[0]
		}
	
		
		//gyro data
		for (int i = 3; i <= 5; i++) {
					
		}
		return 0;
	}

	/***
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static double calculateMagnitude(double x, double y, double z) {
		return Math.sqrt((x * x) + (y * y) + (z * z));
	}

	/***
	 * 
	 * @param sensorData
	 * @return
	 */
	private static double[] calculateMagnitudesFor(double[][] sensorData) {
		double[] mag = new double[sensorData.length];
		int col = 0;

		for (int row = 0; row < mag.length; row++) {
			double x = sensorData[row][col];
			double y = sensorData[row][col + 1];
			double z = sensorData[row][col + 2];
			
			mag[row] = calculateMagnitude(x, y, z);
		}
		return mag;
	}

	/***
	 * 
	 * @param arr
	 * @param mean
	 * @return
	 */
	private static double calculateStandardDeviation(double[] arr, double mean) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			double diff = Math.pow((arr[i] - mean), 2);
			sum += diff;
		}
		double num = sum / (arr.length - 1);
		return Math.sqrt(num);
	}

	/***
	 * 
	 * @param arr
	 * @return
	 */
	private static double calculateMean(double[] arr) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double) (sum / arr.length);
	}
}
