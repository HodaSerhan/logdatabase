package com.example.LOGdatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
public class Start {
	static Map<String, Integer> appsErrCounters=new HashMap<String,Integer>();
	static Map<String, Integer> severityErrorCounters=new HashMap<String,Integer>();
	static Map<String, Integer> appsErrorSeverityCounters=new HashMap<String,Integer>();
	static List<ErrorDescription> errorsDescriptions=new Vector<ErrorDescription>();

	public static void readLogs() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("C:\\Program Files\\CMServer.20170924_1557.log");
			@SuppressWarnings("resource")
			BufferedReader reader=new BufferedReader(fileReader);
			String readedLine= reader.readLine();
			while(readedLine != null) {
				if(readedLine.contains("Caused by:")) {
					String[] lineSplited=readedLine.split(" ");
					for(int i=0; i<lineSplited.length; i++) {
						if (lineSplited[i].startsWith("(") && lineSplited[i].endsWith(")")){
							ErrorDescription errorDescription=new ErrorDescription(readedLine);
							errorsDescriptions.add(errorDescription);
							break;
						}
					}
				}
				readedLine= reader.readLine();
			}
			
			
			
			
			if(appsErrCounters.size()!=0) {
				System.err.println("Some errors founded :");
				Iterator<ErrorDescription> iterator=errorsDescriptions.iterator();
				while(iterator.hasNext()) {
					System.out.println("------------------");
					ErrorDescription err=iterator.next();
					System.out.println("Error massage: " + err.getErrorMassage());
					if(err.getType()) 
						System.out.println("Error Type: Core\nAppError: " + err.getAppName() + "1-" + err.getErrorCode());
					else
						System.out.println("Error Type: Custom\nAppError: " + err.getAppName() + "-" + err.getErrorCode());
				}

				//printing appsErrCounters hashMap
				System.out.println("\n********************************");
				for (Map.Entry<String, Integer> entry : appsErrCounters.entrySet()) 
					System.out.println("AppError: " + entry.getKey() + " founded: " + entry.getValue() + " times.");
				
				//printing severityErrorCounters hashMap
				System.out.println("\n********************************");
				for (Map.Entry<String, Integer> entry : severityErrorCounters.entrySet()) 
					System.out.println("number of defects with severity of: " + entry.getKey() + " founded: " + entry.getValue() + " times.");

				//printing appsErrorSeverityCounters hashMap
				System.out.println("\n********************************");
				for (Map.Entry<String, Integer> entry : appsErrorSeverityCounters.entrySet()) 
					System.out.println("AppError with severity: " + entry.getKey() + " founded: " + entry.getValue() + " times.");
			}else
				System.out.println("No errors found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
