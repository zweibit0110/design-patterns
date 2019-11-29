package com.deloitte.training.oodesignpatterns.creational.singleton.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class SingletonSerializationTest {
    
    @After
    public void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get("bad-serialization-singleton.ser"));
        Files.deleteIfExists(Paths.get("well-serialization-singleton.ser"));
    }

    @Test
    public void duplicateSingletonInstanceUsingSerialization() {
        try {
            BadSerializationSingleton instanceOne = BadSerializationSingleton.getInstance();
            BadSerializationSingleton instanceTwo = (BadSerializationSingleton) serializeInstance(instanceOne, "bad-serialized-singleton.ser");

            assertNotEquals(instanceOne.hashCode(), instanceTwo.hashCode());
        } catch (IOException | ClassNotFoundException ex) {
            failWithExceptionAndMessage(ex);
        }
    }
    
    @Test
    public void sameSingletonInstanceUsingSerialization() {
        try {
            WellSerializationSingleton instanceOne = WellSerializationSingleton.getInstance();
            WellSerializationSingleton instanceTwo = (WellSerializationSingleton) serializeInstance(instanceOne, "well-serialized-singleton.ser");

            assertEquals(instanceOne.hashCode(), instanceTwo.hashCode());
        } catch (IOException | ClassNotFoundException ex) {
            failWithExceptionAndMessage(ex);
        }
    }

    private Object serializeInstance(Object instance, String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName));
                ObjectInput in = new ObjectInputStream(new FileInputStream(fileName));) {
            //write to file
            out.writeObject(instance);

            // then read from file
            return in.readObject();
        }
    }
    
    private void failWithExceptionAndMessage(Exception ex) {
        Logger.getLogger(SingletonSerializationTest.class.getName()).log(Level.SEVERE, null, ex);
        fail("Cannot build the second singleton instance using serialization.");
    }
    
}
