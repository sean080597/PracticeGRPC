package serializer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sample.Generator;
import stubs.Laptop;

import java.io.IOException;

class SerializerTest {

    @Test
    void writeAndReadBinaryFile() throws IOException {
        String binaryFile = "laptop.bin";
        Laptop laptop1 = new Generator().newLaptop();

        Serializer serializer = new Serializer();
        serializer.writeBinaryFile(laptop1, binaryFile);

        Laptop laptop2 = serializer.readBinaryFile(binaryFile);
        Assert.assertEquals(laptop1, laptop2);
    }
}