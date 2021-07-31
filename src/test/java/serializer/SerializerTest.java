package serializer;

import org.junit.Test;
import sample.Generator;
import stubs.Laptop;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class SerializerTest {

    @Test
    void writeAndReadBinaryFile() throws IOException {
        String binaryFile = "laptop.bin";
        Laptop laptop1 = new Generator().newLaptop();

        Serializer serializer = new Serializer();
        serializer.writeBinaryFile(laptop1, binaryFile);

        Laptop laptop2 = serializer.readBinaryFile(binaryFile);
        assertThat(laptop1).isEqualTo(laptop2);
    }
}