package com.quaatso.facebook.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvTestData {

	public static void main(String[] args) throws IOException {
		getCsvData();
	}
	/*
	 * 1. Read file 2. read each row 3. split row by "," --------------- 4.
	 * Store above data in array List 4. Covert above in 2d array
	 * 
	 */

	public static Object[][] getCsvData() throws IOException {

		ArrayList<String> dataList = new ArrayList<String>();
		// create stream
		File f = new File("D:\\Student\\csvData.csv");
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr);
		// read data and save into list
		String line = null;
		int rows = 0;
		int columns = 0;
		while ((line = reader.readLine()) != null) {
			// first row is header
			if(rows==0)
				continue;
			// skip any test data
			if (line.charAt(0) == '#')
				continue;

			String[] lineArray = line.split(",");
			columns = lineArray.length;
			for (int i = 0; i < lineArray.length; i++) {
				String data = lineArray[i];
				dataList.add(data);
			}
			rows++;
		}
		reader.close();
		// convert above list into 2d array
		Object[][] csvDataArray = new Object[rows][columns];
		int index = 0;
		for (int i = 0; i < csvDataArray.length; i++) {
			for (int j = 0; j < csvDataArray[i].length; j++) {
				csvDataArray[i][j] = dataList.get(index);
				index++;
			}
		}
		// just for testing this code
		for (int i = 0; i < csvDataArray.length; i++) {
			for (int j = 0; j < csvDataArray[i].length; j++) {
				System.out.print(csvDataArray[i][j] + "\t");
			}
			System.out.println();
		}

		return csvDataArray;
	}

}
