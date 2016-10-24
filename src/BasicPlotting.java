import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class BasicPlotting {
	public static void main(String[] args) {
//		int size = 100;

		String names = "time (ms),  accel x,  accel y,  accel z,  gryo x,  gyro y,  gyro z,  "
				+ "linear accel x,  linear accel y,  linear accel z, "
				+ " orientation x,  orientation y,  orientation z";
		String[] namesArray = names.split(",");
		CSVData data = CSVData.readCSVFile("C:\\Users\\slo841\\workspace\\CSVData\\data\\walkingSampleData-out.csv", 1,
				namesArray);

		double[] sample = data.getColumn(2);

		Plot2DPanel plot = new Plot2DPanel();

		// add a line plot to the PlotPanel
		plot.addLinePlot("Random signal", sample);

		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("Results");
		frame.setSize(800, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}

}
