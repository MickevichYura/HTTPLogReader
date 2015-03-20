import java.io.File;
import java.io.IOException;

public class InputData {

	private String errorMessage = "";
	private int startLineNumber;
	private int amountOfLines;
	private String inputFilePath;
	private String outputFilePath;

	public InputData(String[] args) {
		if (args.length < 4) {
			errorMessage += "You must input the 4 parameters\n";
		}
		setStartLineNumber(args[0]);
		setAmountOfLines(args[1]);
		setInputFilePath(args[2]);
		setOutputFilePath(args[3]);
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

	public boolean isCorrect() {

		return errorMessage.isEmpty();
	}

}