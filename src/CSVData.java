/***
 * This is a helper class
 * 
 * @author Stephanie
 *
 */
public class CSVData {
	private double[][] data;
	private String[] columnNames;

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
	 * Returns an individual column in the data
	 * 
	 * @param arr
	 *            the data set
	 * @param column
	 *            the column of data you want to get
	 * @return a double array of the data in the column
	 */
	public double[] getColumn(int column) {
		return null;
	}

	/***
	 * Returns an individual column in the data
	 * 
	 * @param name
	 *            the name of the column you want to return
	 * @return a double array of the data in the column
	 */
	public double[] getColumn(String name) {
		return null;
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
		return null;
	}

	
	public double[] getRow(String name) {
		return null;
	}

	/***
	 * 
	 * @param arr
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public double[][] getRows(int startRow, int endRow) {
		return null;
	}

	public double[][] getRows(int[] rowIndexes) {
		return null;
	}
	
	public double[][] getRows(String[] rowNames) {
		return null;
	}

	/***
	 * 
	 * @param arr
	 * @param startCol
	 * @param endCol
	 * @return
	 */
	public double[][] getColumns(int startCol, int endCol) {
		return null;
	}

	public double[][] getColumns(int[] colIndexes) {
		return null;
	}

	public double[][] getColumns(String[] colNames) {
		return null;
	}

	/***
	 * 
	 * @param arr
	 * @param columnIndex
	 * @param vals
	 */
	public void setColumn(int columnIndex, double[] vals) {

	}

	/***
	 * 
	 * @param arr
	 * @param rowIndex
	 * @param vals
	 */
	public void setRow(int rowIndex, double[] vals) {

	}

	public void setValue(int rowIndex, int columnIndex, double[] vals) {

	}

	/***
	 * 
	 * @param arr
	 * @return
	 */
	public String getTitles() {
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
}
