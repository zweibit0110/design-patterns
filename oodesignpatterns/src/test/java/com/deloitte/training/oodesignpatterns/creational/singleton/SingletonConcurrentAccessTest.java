package com.deloitte.training.oodesignpatterns.creational.singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class SingletonConcurrentAccessTest {

    private ExecutorService executorService;

    @Before
    public void setup() throws InterruptedException {
        executorService = Executors.newFixedThreadPool(2);
    }

    @After
    public void tearDown() {
        executorService.shutdown();
    }

    @Test
    public void compareTwoInstancesOfEagerInitializedSingleton() {
        Supplier<String> hashcodeSupplier = () -> EagerInitializedSingleton.getInstance().hashCode() + "";

        createAndCompareSingletonInstances(hashcodeSupplier);
    }

    private void createAndCompareSingletonInstances(Supplier<String> supplier) {
        CompletableFuture<String> firstInstanceHashcode = CompletableFuture.supplyAsync(supplier, executorService);
        CompletableFuture<String> secondInstanceHashcode = CompletableFuture.supplyAsync(supplier, executorService);

        CompletableFuture.allOf(firstInstanceHashcode, secondInstanceHashcode);

        try {
            assertEquals(firstInstanceHashcode.get(), secondInstanceHashcode.get());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(SingletonConcurrentAccessTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(String.format("Exception occured when getting instance hashcodes: %s", ex.getMessage()));
        }
    }


    @Test
    public void compareTwoInstancesOfStaticBlockSingleton() {
        Supplier<String> hashCodeSupplier = () -> StaticBlockSingleton.getInstance().hashCode() + "";
        createAndCompareSingletonInstances(hashCodeSupplier);
    }

    @Test
    public void compareTwoInstancesOfLazyInitializedSingleton() {
        Supplier<String> hashCodeSupplier = () -> LazyInitializedSingleton.getInstance().hashCode() + "";
        createAndCompareSingletonInstances(hashCodeSupplier);

    }

    @Test
    public void compareTwoInstancesOfThreadSafeSingleton() {
        Supplier<String> hashcodeSupplier = () -> ThreadSafeSingleton.getInstance().hashCode() + "";
        createAndCompareSingletonInstances(hashcodeSupplier);
    }

    @Test
    public void compareTwoInstancesOfThreadSafeWithDoubleCheckedLockingSingleton() {
        Supplier<String> hashcodeSupplier = () -> ThreadSafeWithDoubleCheckedLockingSingleton.getInstance().hashCode() + "";
        createAndCompareSingletonInstances(hashcodeSupplier);
    }

    @Test
    public void compareTwoInstancesOfBillPughSingleton() {
        Supplier<String> hashcodeSupplier = () -> BillPughSingleton.getInstance().hashCode() + "";
        createAndCompareSingletonInstances(hashcodeSupplier);
    }

    @Test
    public void compareTwoInstancesOfEnumSingleton() {
        Supplier<String> hashcodeSupplier = () -> EnumSingleton.INSTANCE.hashCode() + "";
        createAndCompareSingletonInstances(hashcodeSupplier);
    }
    
}
