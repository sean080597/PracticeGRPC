package serializer;

import com.google.protobuf.util.JsonFormat;
import stubs.Laptop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Serializer {

    public void writeBinaryFile(Laptop laptop, String filename) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filename);
        laptop.writeTo(outputStream);
        outputStream.close();
    }

    public Laptop readBinaryFile(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(filename);
        Laptop laptop = Laptop.parseFrom(inputStream);
        inputStream.close();
        return laptop;
    }

    public void writeJSONFile(Laptop laptop, String filename) throws IOException{
        JsonFormat.Printer printer = JsonFormat.printer()
                .includingDefaultValueFields()
                .preservingProtoFieldNames();

        String jsonString = printer.print(laptop);

        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(jsonString.getBytes());
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        Serializer serializer = new Serializer();
        Laptop laptop = serializer.readBinaryFile("laptop.bin");
        serializer.writeJSONFile(laptop, "laptop.json");
    }
}
