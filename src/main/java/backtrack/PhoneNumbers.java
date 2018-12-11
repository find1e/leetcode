package backtrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumbers {
	private int suffixLength; // 后缀长度
	private char target[]; // 后缀字符候选集
	private char phoneChar[] = new char[11];
	private List<String> numbers = new LinkedList<>(); // 手机号结果暂存容器
	private long threshold;
	private String storePath;
	private int fileCount = 0;
	private long fileSize = 0;

	public PhoneNumbers(int suffixLength, char[] target, long threshold, String storePath) {
		this.target = target;
		this.suffixLength = suffixLength;
		this.threshold = threshold;
		this.fileSize = threshold * 256;
		this.storePath = storePath;
		phoneChar[0] = '1';
	}

	public void doBruteForce() {
		bt(0);
	}

	public void bt(int n) {
		if (n >= suffixLength) {
			numbers.add(new String(phoneChar));
			if (numbers.size() >= threshold) {
				// 到达阈值，批量存储
				flushToFileIO(storePath + (++fileCount) + ".txt", numbers, fileSize);
				// 处理完后清理
				numbers.clear();
			}
		} else {
			for (int i = 0; i < target.length; i++) {
				phoneChar[n + 2] = target[i]; // +2跳过prefix
				bt(n + 1);
			}
		}
	}

	public static void main(String[] args) {
		char[] secondaryNumbers = {'3', '4', '5', '7', '8'};
		char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		PhoneNumbers phoneNumbers =
				new PhoneNumbers(5, numbers, 10000, "/Users/fubaokui/Documents/phoneNumbers/");
		for (char secondary : secondaryNumbers) {
			phoneNumbers.setSecondary(secondary);
			phoneNumbers.doBruteForce();
			if (phoneNumbers.numbers.size() > 0) {
				flushToFileIO(phoneNumbers.storePath + (++phoneNumbers.fileCount) + ".txt",
						phoneNumbers.numbers, phoneNumbers.fileSize);
			}
		}
		readFile("/Users/fubaokui/Documents/phoneNumbers/1.txt");
	}

	private void setSecondary(char secondary) {
		phoneChar[1] = secondary;
	}

	public static String repeat(final char ch, final int repeat) {
		final char[] buf = new char[repeat];
		for (int i = repeat - 1; i >= 0; i--) {
			buf[i] = ch;
		}
		return new String(buf);
	}

	public static void flushToFile(String filePath, List<String> phoneNumbers, long fileSize) {
		try {
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
			MappedByteBuffer mappedByteBuffer =
					randomAccessFile.getChannel().map(MapMode.READ_WRITE, 0, fileSize);
			for (String phoneNumber : phoneNumbers) {
				mappedByteBuffer.put((phoneNumber + System.lineSeparator()).getBytes());
			}
			randomAccessFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void flushToFileIO(String filePath, List<String> phoneNumbers, long fileSize) {
		try {
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			for (String phoneNumber : phoneNumbers) {
				bufferedWriter.write(phoneNumber);
				bufferedWriter.write(System.lineSeparator());
			}
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 测试写入数据
	public static void readFile(String filePath) {
		try {
			FileReader fileReader = new FileReader(new File(filePath));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String str = bufferedReader.readLine();
			while (str != null) {
				System.out.println(str);
				str = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
