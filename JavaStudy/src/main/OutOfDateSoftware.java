package main;
/*  
 * Problem : Out of Date Software
 * 
 * Consider the file input.txt which contains all information about software
 * installed on various servers in a data center:
 * 
 * Server1, Database, MySQL, 5.5 Server2, Database, MySQL, 5.1 Server3, OS,
 * Ubuntu, 10.04 Server1, OS, Ubuntu, 10.04 Server2, OS, Ubuntu, 12.04 Server3,
 * Language, Python, 2.6.3
 * 
 * This file indicates that Server1, has version 5.5 of MySQL installed, and
 * Server2 has version 5.1 installed, and Server3 has version 10.04 of Ubuntu
 * installed. For the purposes of this program, assume that all version numbers
 * are of the form X.Y or X.Y.Z where X, Y, and Z are made up of only digits.
 * 
 * Write a Java program that reads this file (input.txt in the current
 * directory), and prints to file output.txt (in the current directory) a list
 * of software package names for which an out-of-date version (i.e. a version
 * which is not the latest version) is installed on at least 2 different
 * servers. Thus, in this case, the output of your program should be:
 * 
 * Ubuntu
 * 
 * Because Ubuntu 10.04 is an out-of-date version (the latest version is 12.04),
 * and it is installed on two servers (Server 3, and Server 1).
 * 
 * Your program must well designed, should use appropriate design patterns,
 * appropriate data-structures, appropriate unit tests, and should be efficient,
 * readable, and maintainable.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * This program is used to find the software which are out-of-date
 * version at least on 2 server. Program is tested on Java 8 version on windows 7
 * 
 * @author Ganesh Bhagat
 * @version 1.0
 * @since 27-07-2018
 */
public class OutOfDateSoftware {

	public static void main(String[] args) {

		System.out.println("Program Start");

		List<SoftwareOnServer> inputData = new LinkedList<SoftwareOnServer>();
		String inputFileName = "input.txt";
		String outputFileName = "output.txt";

		Scanner scannerInput = null;
		PrintWriter printWriterOut = null;

		System.out.println("Put the " + inputFileName + " in same directory for processing");

		try {

			URI inputFileNameUri = OutOfDateSoftware.class.getResource(inputFileName).toURI();
			URI outputFileNameUri = OutOfDateSoftware.class.getResource(outputFileName).toURI();

			System.out.println("Took " + inputFileNameUri + " for processing");
			scannerInput = new Scanner(new BufferedReader(new FileReader(new File(inputFileNameUri))));
			// Read the the data from file
			while (scannerInput.hasNextLine()) {
				SoftwareOnServer softwareOnServerObj = parseInputString(scannerInput.nextLine());
				inputData.add(softwareOnServerObj);
			}

			// Process the data and get the map of it
			Map<String, SoftwareOnServer> outOfSoftwareVersionMap = processData(inputData);

			// Print the software name in file
			printWriterOut = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputFileNameUri))));
			Set<Entry<String, SoftwareOnServer>> keyset = outOfSoftwareVersionMap.entrySet();
			for (Entry<String, SoftwareOnServer> softwareOnServerEntry : keyset) {
				// printWriterOut.println(softwareOnServerEntry);
				printWriterOut.println(softwareOnServerEntry.getValue().getSoftwareName());
			}

			System.out.println("Please check the result in " + outputFileNameUri);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Closing the file in/out streams");
			try {
				if (scannerInput != null) {
					scannerInput.close();
				}
			} catch (Exception e) {
			}

			try {
				if (printWriterOut != null) {
					printWriterOut.close();
				}
			} catch (Exception e) {
			}
		}
		System.out.println("Program End");
	}

	/**
	 * This method is used to parse the input string and return the object the
	 * input string should consist of 4 part separated by ',' character
	 * 
	 * @param String This is a string as an input
	 * @return SoftwareOnServer This returns object after parsing the input string.
	 * @exception IllegalArgumentException, NullPointerException, NumberFormatException on input error.
	 * @see IllegalArgumentException, NullPointerException, NumberFormatException
	 */
	public static SoftwareOnServer parseInputString(String line)
			throws IllegalArgumentException, NullPointerException, NumberFormatException {

		System.out.println("Parsing [" + line + "] line start");

		String parts[] = line.split(",");

		if (parts.length < 4) {
			throw new IllegalArgumentException("Line details are insufficient");
		}
		if (!isValidPart(parts[0])) {
			throw new NullPointerException("Server name should not be null");
		}
		if (!isValidPart(parts[1])) {
			throw new NullPointerException("Server type should not be null");
		}
		if (!isValidPart(parts[2])) {
			throw new NullPointerException("Software name should not be null");
		}
		if (!isValidPart(parts[3])) {
			throw new NullPointerException("Software version should not be null");
		} else if (!isValidSoftwareVersion(parts[3])) {
			throw new NumberFormatException("Software version is not correct");
		}

		System.out.println("Parsing [" + line + "] line end");
		return new SoftwareOnServer(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
	}

	/**
	 * This method is used to validate the input string whether it is null or empty
	 * 
	 * @param String This is a string as an input
	 * @return boolean This returns true if the input is valid else false.
	 */
	public static boolean isValidPart(String part) {
		if (part == null || part.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * This method is used to validate the software version coming in x.y or x.y.z format
	 * 
	 * @param String This is a string as an input
	 * @return boolean This returns true if the input is valid else false.
	 */
	public static boolean isValidSoftwareVersion(String softwareVersion) {
		String parts[] = softwareVersion.split("\\.");
		if (parts.length >= 4) {
			return false;
		}
		return true;
	}

	/**
	 * This method is used to process the list of software
	 * 
	 * @param List<SoftwareOnServer> This is a list of software as an input
	 * @return Map<String, SoftwareOnServer> This returns map of object after processing the input list.
	 * @exception NullPointerException on input error.
	 * @see NullPointerException
	 */
	public static Map<String, SoftwareOnServer> processData(List<SoftwareOnServer> listOfSoftwareOnServer)
			throws NullPointerException {

		System.out.println("Processing input data start");

		if (listOfSoftwareOnServer == null) {
			throw new NullPointerException("List of software should not be null");
		}

		Map<String, SoftwareOnServer> outOfSoftwareVersionMap = new HashMap<String, SoftwareOnServer>();
		Map<String, Integer> typeAndSoftwareVersionMap = new HashMap<String, Integer>();

		for (SoftwareOnServer softwareOnServer : listOfSoftwareOnServer) {
			// Create a key by using software type and software name
			String softwareTypeNameKey = softwareOnServer.getSoftwareType() + "|" + softwareOnServer.getSoftwareName();

			if (outOfSoftwareVersionMap.get(softwareTypeNameKey) == null) {
				outOfSoftwareVersionMap.put(softwareTypeNameKey, softwareOnServer);
				typeAndSoftwareVersionMap.put(softwareTypeNameKey, new Integer(1));
			} else {
				SoftwareOnServer tempSoftwareOnServer = outOfSoftwareVersionMap.get(softwareTypeNameKey);
				Integer tempSoftwareVersion = new Integer(
						tempSoftwareOnServer.getSoftwareVersion().replaceAll("\\.", ""));
				Integer currentSoftwareVersion = new Integer(
						softwareOnServer.getSoftwareVersion().replaceAll("\\.", ""));

				// Captured the old version of software in map
				if (currentSoftwareVersion <= tempSoftwareVersion) {
					outOfSoftwareVersionMap.put(softwareTypeNameKey, softwareOnServer);
				}
				// Maintain the count of software type and software name
				typeAndSoftwareVersionMap.put(softwareTypeNameKey,
						typeAndSoftwareVersionMap.get(softwareTypeNameKey) + 1);
			}
		}

		// Remove the software which are installed only on one server
		for (String typeAndSoftwareVersionKey : typeAndSoftwareVersionMap.keySet()) {
			if (typeAndSoftwareVersionMap.get(typeAndSoftwareVersionKey) <= 1
					|| typeAndSoftwareVersionMap.get(typeAndSoftwareVersionKey) == 2) {
				outOfSoftwareVersionMap.remove(typeAndSoftwareVersionKey);
			}
		}
		System.out.println("Processing input data end");
		return outOfSoftwareVersionMap;
	}

	/**
	 * This class is used to hold the information of software details
	 * 
	 * @author Ganesh Bhagat
	 * @version 1.0
	 * @since 27-07-2018
	 */
	private static class SoftwareOnServer {
		private String serverName;
		private String softwareType;
		private String softwareName;
		private String softwareVersion;

		public SoftwareOnServer() {
			// Default constructor
		}

		public SoftwareOnServer(String serverName, String softwareType, String softwareName, String softwareVersion) {
			this.serverName = serverName;
			this.softwareType = softwareType;
			this.softwareName = softwareName;
			this.softwareVersion = softwareVersion;
		}

		public String getServerName() {
			return serverName;
		}

		public void setServerName(String serverName) {
			this.serverName = serverName;
		}

		public String getSoftwareType() {
			return softwareType;
		}

		public void setSoftwareType(String softwareType) {
			this.softwareType = softwareType;
		}

		public String getSoftwareName() {
			return softwareName;
		}

		public void setSoftwareName(String softwareName) {
			this.softwareName = softwareName;
		}

		public String getSoftwareVersion() {
			return softwareVersion;
		}

		public void setSoftwareVersion(String softwareVersion) {
			this.softwareVersion = softwareVersion;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SoftwareOnServer [");
			if (serverName != null) {
				builder.append("serverName=");
				builder.append(serverName);
				builder.append(", ");
			}
			if (softwareType != null) {
				builder.append("softwareType=");
				builder.append(softwareType);
				builder.append(", ");
			}
			if (softwareName != null) {
				builder.append("softwareName=");
				builder.append(softwareName);
				builder.append(", ");
			}
			if (softwareVersion != null) {
				builder.append("softwareVersion=");
				builder.append(softwareVersion);
			}
			builder.append("]");
			return builder.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((serverName == null) ? 0 : serverName.hashCode());
			result = prime * result + ((softwareName == null) ? 0 : softwareName.hashCode());
			result = prime * result + ((softwareVersion == null) ? 0 : softwareVersion.hashCode());
			result = prime * result + ((softwareType == null) ? 0 : softwareType.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SoftwareOnServer other = (SoftwareOnServer) obj;
			if (serverName == null) {
				if (other.serverName != null)
					return false;
			} else if (!serverName.equals(other.serverName))
				return false;
			if (softwareName == null) {
				if (other.softwareName != null)
					return false;
			} else if (!softwareName.equals(other.softwareName))
				return false;
			if (softwareVersion == null) {
				if (other.softwareVersion != null)
					return false;
			} else if (!softwareVersion.equals(other.softwareVersion))
				return false;
			if (softwareType == null) {
				if (other.softwareType != null)
					return false;
			} else if (!softwareType.equals(other.softwareType))
				return false;
			return true;
		}

	}

}