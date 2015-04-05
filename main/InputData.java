package main;

import java.io.File;
import java.text.ParsePosition;
import java.util.Date;

public class InputData implements DateFormat {

	private StringBuilder errorMessage = new StringBuilder();
	private int startLineNumber;
	private int amountOfLines;
	private String inputFilePath;
	private String outputFilePath;
	private int reportNumber;
	private Date startDate;
	private Date endDate;

	public InputData(String[] args) {
		if (args.length < 7) {
			errorMessage.append("You must input the 7 parameters\n");
		}
		setStartLineNumber(args[0]);
		setAmountOfLines(args[1]);
		setInputFilePath(args[2]);
		setOutputFilePath(args[3]);
		setReportNumber(args[4]);
		setDateInterval(args[5], args[6]);
	}

	public String getErrorMessage() {
		return errorMessage.toString();
	}

	public int getStartLineNumber() {
		return startLineNumber;
	}

	private void setStartLineNumber(String startLineNumber) {
		try {
			this.startLineNumber = Integer.parseInt(startLineNumber);
			if (this.startLineNumber < 0) {
				errorMessage.append("Number should be greater than 0\n");
				this.startLineNumber = 0;
			}
		} catch (NumberFormatException e) {
			errorMessage.append(e.toString() + "\n");
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
				errorMessage.append("Number should be greater than 0\n");
				this.amountOfLines = 0;
			}
		} catch (NumberFormatException e) {
			errorMessage.append(e.toString() + "\n");
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
			errorMessage.append("Can't read file: " + file.getAbsolutePath()
					+ "\n");
		}
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	private void setOutputFilePath(String inputFilePath) {
		this.outputFilePath = inputFilePath;
		File file = new File(inputFilePath);
		if (!file.canWrite()) {
			errorMessage.append("Can't write file: " + file.getAbsolutePath()
					+ "\n");
		}
	}

	public int getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		try {
			this.reportNumber = Integer.parseInt(reportNumber);
			if (this.reportNumber < 0 || this.reportNumber > 3) {
				errorMessage.append("Not correct report number\n");
			}
		} catch (NumberFormatException e) {
			errorMessage.append(e.toString() + "\n");
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
				startDate.indexOf(DATE_FORMAT_PATTERN.charAt(0))));
		this.endDate = DATE_FORMAT.parse(
				endDate,
				new ParsePosition(
						endDate.indexOf(DATE_FORMAT_PATTERN.charAt(0))));

		try {
			if (this.startDate.after(this.endDate)) {
				errorMessage.append("Start date cannot be after end date\n");
			}
		} catch (NullPointerException e) {
			errorMessage.append("Wrong date format\n");
		}
	}

	public boolean isCorrect() {
		return errorMessage.toString().isEmpty();
	}
}
