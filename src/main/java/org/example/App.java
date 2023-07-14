package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
       Email emailAdress = new SimpleEmail();
        Writer writer = new FileWriter("data.csv");
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Value 1", "Value 2", "Value 3");
        printer.printRecord("Value 4", "Value 5", "Value 6");
        printer.close();
    }
}
