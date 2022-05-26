
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaskJsonHandler {

	private static String JSON_FILE = "mask.json";
	private List<Pharmacy> pharmacyList;

	private String produceStringFromFile(String fileName) throws IOException {
		InputStream is = new FileInputStream(fileName);
		BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		buf.close();
		return sb.toString();
	}

	private List<Pharmacy> convertToObjects(String jsonData) {

		Gson gson = new Gson();
		ArrayList<Pharmacy> clinicList = new ArrayList<Pharmacy>();

		try {
			Type listType = new TypeToken<List<Pharmacy>>() {
			}.getType();
			clinicList = gson.fromJson(jsonData, listType);
		} catch (Exception e) {
			System.err.println("Exception: " + e);
		}
		return clinicList;
	}

	public List<Pharmacy> findPharmacies(String queryName, String queryAddress) {
		List<Pharmacy> matchingElements = pharmacyList.stream().filter(
				str -> str.getName().trim().contains(queryName) && str.getAddress().trim().contains(queryAddress))
				.collect(Collectors.toList());

		return matchingElements;
	}

	public void initialize() throws IOException {

		String maskDataJson = produceStringFromFile(JSON_FILE);
		pharmacyList = convertToObjects(maskDataJson);
	}

}
