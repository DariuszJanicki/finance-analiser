package parser;

import factory.EntryFactory;
import model.Entry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void main(String[] args) {

        String csvFile = "transactions.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            List<Entry> entryList = new ArrayList<>();

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] country = line.split(cvsSplitBy);

                if (country.length == 15 && !country[0].equals("Data transakcji")) {
                    entryList.add(EntryFactory.factory.createEntry(country));
                }

            }

            entryList.forEach(System.out::println);
            EntryFactory.factory.getAccountsList().getSorted().forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
