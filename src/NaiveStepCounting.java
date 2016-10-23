
public class NaiveStepCounting {

	/***
	 * 
	 * @param times
	 * @param sensorData
	 * @return
	 */
	private static int countSteps(double[] times, double[][] sensorData) {
		double[] accData = new double[3];
		double[] gyroData = new double[3];
		int stepCount = 0;
		
		//accelerometer data		
		for (int row = 0; row < sensorData.length; row++) {
			for (int col = 0; col <= 2; col++) {
				accData = calculateMagnitudesFor(sensorData);
			}	
		}
		
		double accStandardDev = calculateStandardDeviation(accData, calculateMean(accData));
		
		for (int i = 0; i < accData.length; i++) {
			if (accData[i] > accData[i - 1] && accData[i] > accData[i + 1]) {
				if (accData[i] > accStandardDev + 2) {
					stepCount++;
				}
			}
		}
		
		//gyro data
		for (int row = 0; row < sensorData.length; row++) {
			for (int col = 3; col <= 5; col++) {
				gyroData = calculateMagnitudesFor(sensorData);
			}	
		}
		
		double gyroStandardDev = calculateStandardDeviation(accData, calculateMean(accData));
		
		for (int i = 0; i < gyroData.length; i++) {
			if (gyroData[i] > gyroData[i - 1] && gyroData[i] > gyroData[i + 1]) {
				if (gyroData[i] > gyroStandardDev + 2) {
					stepCount++;
				}
			}
		}
		return stepCount;
	}

	/***
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	private static double calculateMagnitude(double x, double y, double z) {
		return Math.sqrt((x * x) + (y * y) + (z * z));
	}

	/***
	 * 
	 * @param sensorData
	 * @return
	 */
	public static double[] calculateMagnitudesFor(double[][] sensorData) {
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
	public static double calculateStandardDeviation(double[] arr, double mean) {
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
	public static double calculateMean(double[] arr) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double) (sum / arr.length);
	}
}
