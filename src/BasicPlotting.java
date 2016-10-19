import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class BasicPlotting {
	public static void main(String[] args) {
		int size = 100;
		
		double[] sample1 = new double[size];
		double[] sample2 = new double[size];
		
		for (int i = 0; i < size; i++) {
			sample2[i] = i;
			sample1[i] = 10;
		}
		
		addNoise(sample1, 1, 7);
		addNoise(sample2, 0, 5);
		
		Plot2DPanel plot = new Plot2DPanel();
		
		// add a line plot to the PlotPanel
		plot.addLinePlot("Random signal", sample1);
		plot.addLinePlot("y = x + noise", sample2);
		
		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("Results");
		frame.setSize(800, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}

	private static void addNoise(double[] sample, int start, int end) {
		String names = "time (ms),  accel x,  accel y,  accel z,  gryo x,  gyro y,  gyro z,  "
				+ "linear accel x,  linear accel y,  linear accel z, "
				+ " orientation x,  orientation y,  orientation z";
		String[] namesArray = names.split(",");
		CSVData data = CSVData.readCSVFile("walkingSampleData-out.csv", 1, namesArray);
		
		for (int i = 0; i < sample.length; i++) {
			for (int j = start; j < end; j++) {
				double[] col = data.getColumn(j);
				
				for (int row = 1; row < data.getNumOfRows(); row++) {
					sample[i] += col[row];
				}
			}
		}
	}
}
