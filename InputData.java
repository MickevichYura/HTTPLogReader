import java.io.File;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.Date;

public class InputData implements DateFormat {

	private String errorMessage = "";
	private int startLineNumber;
	private int amountOfLines;
	private String inputFilePath;
	private String outputFilePath;
	private int reportNumber;
	private Date startDate;
	private Date endDate;

	public InputData(String[] args) {
		if (args.length < 7) {
			errorMessage += "You must input the 7 parameters\n";
		}
		setStartLineNumber(args[0]);
		setAmountOfLines(args[1]);
		setInputFilePath(args[2]);
		setOutputFilePath(args[3]);
		setReportNumber(args[4]);
		setDateInterval(args[5], args[6]);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public int getStartLineNumber() {
		return startLineNumber;
	}

	private void setStartLineNumber(String startLineNumber) {
		try {
			this.startLineNumber = Integer.parseInt(startLineNumber);
			if (this.startLineNumber < 0) {
				errorMessage = "Number should be greater than 0\n";
				this.startLineNumber = 0;
			}
		} catch (NumberFormatException e) {
			errorMessage += e.toString() + "\n";
			this.startLineNumber = 0;
		}
	}

	public int getAmountOfLines() {
		return amountOfLines;
	}

	private void setAmountOfLines(String amountOfLines) {
		try {
			this.amountOfLines = Integer.parseInt(amountOfLines);
			if (this.amountOfLines < 0) {
				errorMessage = "Number should be greater than 0\n";
				this.amountOfLines = 0;
			}
		} catch (NumberFormatException e) {
			errorMessage += e.toString() + "\n";
			this.amountOfLines = 0;
		}
	}

	public String getInputFilePath() {
		return inputFilePath;
	}

	private void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		File file = new File(inputFilePath);
		if (!file.canRead()) {
			errorMessage += "Can't read file: " + file.getAbsolutePath() + "\n";

			try {
				file.createNewFile();
			} catch (IOException e) {
			}

		}
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	private void setOutputFilePath(String inputFilePath) {
		this.outputFilePath = inputFilePath;
		File file = new File(inputFilePath);
		if (!file.canWrite()) {
			errorMessage += "Can't write file: " + file.getAbsolutePath()
					+ "\n";
			file.setWritable(true);
		}
	}

	public int getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		try {
			this.reportNumber = Integer.parseInt(reportNumber);
			if (this.reportNumber < 0 || this.reportNumber > 3) {
				errorMessage = "Not correct report number\n";
				this.reportNumber = 0;
			}
		} catch (NumberFormatException e) {
			errorMessage += e.toString() + "\n";
			this.reportNumber = 0;
		}
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	private void setDateInterval(String startDate, String endDate) {
		this.startDate = DATE_FORMAT.parse(startDate, new ParsePosition(
				startDate.indexOf(TIMESTAMP_PATTERN.charAt(0))));
		this.endDate = DATE_FORMAT.parse(endDate, new ParsePosition(
				endDate.indexOf(TIMESTAMP_PATTERN.charAt(0))));
		
		try {
			if(this.startDate.after(this.endDate)){
				errorMessage += "Start date cannot be after end date\n";
			}
		} catch (NullPointerException e) {
			errorMessage += "Wrong date format\n";
		}
	}

	public boolean isCorrect() {

		return errorMessage.isEmpty();
	}

}