import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/***
 * This is a helper class.
 * 
 * @author Stephanie
 *
 */
public class CSVData {
	private double[][] data;
	private String[] columnNames;
	private String filePathToCSV;
	private int numRows;

	public CSVData(String filepath, String[] columnNames, int startRow) {
		this.filePathToCSV = filepath;

		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split("\n");

		// number of data points
		int n = lines.length - startRow;
		this.numRows = n;
		int numColumns = columnNames.length;

		// create storage for column names
		this.columnNames = columnNames;

		// create storage for data
		this.data = new double[n][numColumns];
		for (int i = 0; i < lines.length - startRow; i++) {
			String line = lines[startRow + i];
			String[] coords = line.split(",");
			for (int j = 0; j < numColumns; j++) {
				if (coords[j].endsWith("#"))
					coords[j] = coords[j].substring(0, coords[j].length() - 1);
				double val = Double.parseDouble(coords[j]);
				data[i][j] = val;
			}
		}
	}

	private String readFileAsString(String filepath) {
		StringBuilder output = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filepath))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				output.append(line + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	/***
	 * Returns a new CSVData object for a file ignoring lines at the top. It
	 * takes the names of the columns and stores the names with the data
	 * 
	 * @param filename
	 *            the file to read
	 * @param numLinesToIgnore
	 *            number of lines at the top to ignore
	 * @param columnNames
	 *            the names of each column of data
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] columnNames) {
		return null;
	}

	/***
	 * Returns a new CSVData object for a file ignoring lines at the top. It
	 * uses the first row as the column names. All other data is stored as
	 * doubles.
	 * 
	 * @param filename
	 *            the file to read
	 * @param numLinesToIgnore
	 *            number of lines at the top to ignore
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVFile(String filename, int numLinesToIgnore) {
		return null;
	}
	
	/***
	 * Saves the state of the data into a CSV file
	 * 
	 * @param filename
	 *            the name of the file that you save the data into
	 */
	public void saveToFile(String filename) {

	}

	/***
	 * Returns an individual column in the data
	 * 
	 * @param arr
	 *            the data set
	 * @param column
	 *            the column of data you want to get
	 * @return a double array of the data in the column
	 */
	public double[] getColumn(int column) {
		double[] cols = new double[data.length];
		for (int i = 0; i < cols.length; i++) {
			cols[i] = data[i][column];
		}
		return cols;
	}

	/***
	 * Returns an individual column in the data
	 * 
	 * @param name
	 *            the name of the column you want to return
	 * @return a double array of the data in the column
	 */
	public double[] getColumn(String name) {
		double[] cols = new double[data.length];
		for (int i = 0; i < columnNames.length; i++) {
			if (columnNames[i].equals(name)) {
				for (int j = 0; j < cols.length; j++) {
					cols[j] = data[j][i];
				}
			}
		}
		return cols;
	}

	/***
	 * Returns an individual row in the data
	 * 
	 * @param arr
	 *            the data set
	 * @param row
	 *            the row of data you want to get
	 * @return a double array of the data in the row
	 */
	public double[] getRow(int row) {
		double[] r = new double[data[0].length];
		for (int i = 0; i < r.length; i++) {
			r[i] = data[row][i];
		}
		return r;
	}

//	/***
//	 * might need to delete this
//	 * 
//	 * @param name
//	 * @return
//	 */
//	public double[] getRow(String name) {
//		double[] r = new double[data[0].length];
//		for (int i = 0; i < columnNames.length; i++) {
//			if (columnNames[i].equals(name)) {
//				for (int j = 0; j < r.length; j++) {
//					r[j] = data[j][i];
//				}
//			}
//		}
//		return r;
//	}

	/***
	 * Returns the 
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public double[][] getRows(int startRow, int endRow) {
		int numOfRows = endRow - startRow;
		double[][] rows = new double[numOfRows][data[0].length];
		for (int row = 0; row < numOfRows; row++) {
			for (int col = 0; col < data[0].length; col++) {
				rows[row][col] = data[row][col];
			}
		}
		return rows;
	}

	// public double[][] getRows(int[] rowIndexes) {
	// return null;
	// }

	public double[][] getRows(String[] rowNames) {
		double[][] rows = new double[rowNames.length][data[0].length];
		for (int i = 0; i < rowNames.length; i++) {
			String name = rowNames[i];
			if (rowNames[i].equals(name)) {
				for (int col = 0; col < data[0].length; col++) {
					rows[i][col] = data[i][col];
				}
			}
		}
		return rows;
	}

	/***
	 * 
	 * @param arr
	 * @param startCol
	 * @param endCol
	 * @return
	 */
	public double[][] getColumns(int startCol, int endCol) {
		int numOfCols = endCol - startCol;
		double[][] cols = new double[data.length][numOfCols];
		for (int col = 0; col < numOfCols; col++) {
			for (int row = 0; row < data.length; row++) {
				cols[row][col] = data[row][col];
			}
		}
		return cols;
	}

	// public double[][] getColumns(int[] colIndexes) {
	// return null;
	// }

	public double[][] getColumns(String[] colNames) {
		double[][] cols = new double[data.length][colNames.length];
		for (int i = 0; i < colNames.length; i++) {
			String name = colNames[i];
			if (colNames[i].equals(name)) {
				for (int row = 0; row < data.length; row++) {
					cols[row][i] = data[row][i];
				}
			}
		}
		return cols;
	}

	/***
	 * 
	 * @param arr
	 * @param columnIndex
	 * @param vals
	 */
	public void setColumn(int columnIndex, double[] vals) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < vals.length; j++) {
				data[i][columnIndex] = vals[j];
			}
		}
	}

	/***
	 * 
	 * @param arr
	 * @param rowIndex
	 * @param vals
	 */
	public void setRow(int rowIndex, double[] vals) {
		for (int i = 0; i < data[0].length; i++) {
			for (int j = 0; j < vals.length; j++) {
				data[rowIndex][i] = vals[j];
			}
		}
	}

	public void setValue(int rowIndex, int columnIndex, double[] vals) {
		for (int row = 0; row < rowIndex; row++) {
			for (int col = 0; col < columnIndex; col++) {
				for (int j = 0; j < vals.length; j++) {
					data[row][col] = vals[j];
				}
			}
		}
	}

	/***
	 * 
	 * @param arr
	 * @return
	 */
	public String getTitles() {
		String titles = "";
		for (int i = 0; i < columnNames.length; i++) {
			titles = titles + " " + columnNames[i];
		}
		return titles;
	}
}
