package String;

public class StringJustify {

	public static final String SPACE = "#";

	public static void main(String[] args) {

		String line = "What must be acknowledgement shall be";
		String line2 = "This is an example of text justification";
		String line3 = "Science is what we understand well enough to explain to a computer. Art is everything else we do";
		String[] input = line3.split("\\s");

		String[] output = justify(input, 20);
		for (String s : output) {
			if (s != null) {
				System.out.println(s + " " + s.length());
			}
		}
	}

	public static String[] justify(String[] words, int maxWidth) {
		String[] output = new String[words.length];

		StringBuilder stringBuilder = new StringBuilder();
		int k = 0;
		int characterCount = 0;
		boolean isLastLine = false;
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1)
				isLastLine = true;

			while (i <= words.length - 1 && characterCount + getCharacterCount(words[i]) < maxWidth) {
				stringBuilder.append(words[i]);
				stringBuilder.append(SPACE);
				characterCount += getCharacterCount(words[i]) + 1;
				i++;
			}

			if (i <= words.length - 1 && characterCount + getCharacterCount(words[i]) == maxWidth) {
				stringBuilder.append(words[i]);
				stringBuilder.append(SPACE);
				output[k] = stringBuilder.toString();
				stringBuilder = new StringBuilder();
				characterCount = 0;
				output[k] = addpadding(output[k], maxWidth, isLastLine);
				k++;
			}
			else {
				output[k] = stringBuilder.toString();
				if (i < words.length) {
					characterCount = words[i].length() + 1;
					stringBuilder = new StringBuilder();
					stringBuilder.append(words[i]);
					stringBuilder.append(SPACE);
				}
				output[k] = addpadding(output[k], maxWidth, isLastLine);
				k++;
			}
		}
		if (output[k - 1] == null || !stringBuilder.toString().trim().equals(output[k - 1].trim()))
			output[k] = addpadding(stringBuilder.toString(), maxWidth, true);
		return output;
	}

	private static String addpadding(String s, int maxWidth, boolean isLastLine) {
		String[] strings = s.split(SPACE);

		//left justified
		if (isLastLine || strings.length == 1) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (String word : strings) {
				sb.append(word);
				sb.append(SPACE);
				count += getCharacterCount(word) + 1;
			}
			while (count < maxWidth) {
				sb.append(SPACE);
				count++;
			}
			return sb.toString();
		}
		//Justify
		else {
			int count = 0;
			maxWidth = maxWidth - strings[strings.length - 1].length();
			for (int i = 0; i < strings.length; i++) {
				if (i != strings.length - 1) {
					strings[i] = strings[i] + SPACE;
					count += strings[i].length();
				}
			}
			int i = 0;
			while (count < maxWidth && i < strings.length) {
				if (i != strings.length - 1) {
					strings[i] = strings[i] + SPACE;
					count++;
					i++;
				}
				else {
					i = 0;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (String string : strings) {
				sb.append(string);
			}
			return sb.toString();
		}
	}

	public static int getCharacterCount(String word) {
		return word.length();
	}
}
