            fields.add(null);
        Processor processorWithIgnoreMissing = createFingerprintProcessor(  
    /**
        );
                                }
        List<String> excludeFields = null;
                            doneLatch.countDown();  
            excludeFields.add("");
            targetField = randomAlphaOfLength(10);
import java.util.concurrent.Executors;
import java.util.Map;  
        String targetField,
        );
            Processor processor = createFingerprintProcessor(List.of(fieldName), null, targetField, hashMethod, false);
            true
        }
     * {@code execute()} calls raced on the shared digest, corrupting its internal state and producing
            }  
            .map(IngestDocument.Metadata::getFieldName)
public class FingerprintProcessorTests extends OpenSearchTestCase {
 * compatible open source license.
        assertThat(ingestDocument.hasField(targetField), equalTo(false));
     */  
        Processor processor = createFingerprintProcessor(nonExistingFields, null, "fingerprint", randomFrom(hashMethods), false);
            IllegalArgumentException.class,
        String hashMethod,
        if (randomBoolean()) {  
import java.util.concurrent.TimeUnit;
            CountDownLatch startLatch = new CountDownLatch(1);
            processor.execute(seed);
import java.util.concurrent.CopyOnWriteArrayList;
        String targetField = "fingerprint";
            fields.add("");  
import static org.hamcrest.Matchers.equalTo;
                            }
            assertThat("all concurrent fingerprints must match the sequential result for " + hashMethod, mismatches, equalTo(List.of()));  
                                );
        } else {
        }
                        } catch (Throwable e) {  
        excludeFields.add(randomAlphaOfLength(10));
            CountDownLatch doneLatch = new CountDownLatch(threadCount);
        processor = createFingerprintProcessor(List.of(existingFieldName), null, targetField, algorithm, false);
        List<String> excludeFields,  
import org.opensearch.ingest.IngestDocument;
     * Regression test for the thread-safety defect where the {@code HashMethod} enum cached a single
                List.of(randomAlphaOfLength(10)),
            } finally {
            List<Throwable> failures = new CopyOnWriteArrayList<>();  
                fields.add(RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10)));
            IllegalArgumentException.class,
    }  
                        } finally {
    public void testIgnoreMetadataFields() throws Exception {
        }
        assertThrows(  
        if (randomBoolean()) {
     * either wrong fingerprints or an ArrayIndexOutOfBoundsException from the native crypto provider.
        if (randomBoolean()) {
        String nonExistingFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
 */  
            String fieldName = "content";
            fields = new ArrayList<>();  
    }
            "hash method must be MD5@2.16.0, SHA-1@2.16.0, SHA-256@2.16.0 or SHA3-256@2.16.0",
        }  
        String targetField = "fingerprint";
    ) {
        processor.execute(ingestDocument);
            () -> createFingerprintProcessor(null, excludeFields, null, randomFrom(hashMethods), false)  
            "field name in [fields] cannot be null nor empty",
            .keySet()
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String targetField = "fingerprint";
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
import org.opensearch.test.OpenSearchTestCase;
        Processor processor = createFingerprintProcessor(fields, excludeFields, targetField, hashMethod, false);
            }  
        String hashMethod = randomFrom(hashMethods);
            fields = new ArrayList<>();  
                            failures.add(e);
            .collect(Collectors.toList());
import java.util.Collections;
import java.util.concurrent.ExecutorService;  
        return new FingerprintProcessor(randomAlphaOfLength(10), null, fields, excludeFields, targetField, hashMethod, ignoreMissing);
            excludeFields = new ArrayList<>();
                        }
                    executor.execute(() -> {
                List.of(randomAlphaOfLength(10)),
        assertThat(ingestDocument.getFieldValue(targetField, String.class), equalTo(fingerprint));
        assertThrows(
            )  
                                    mismatches.add(actual);  
            IllegalArgumentException.class,
 * The OpenSearch Contributors require contributions made to  
            () -> createFingerprintProcessor(  
        boolean ignoreMissing  
        List<String> fields = List.of(existingFieldName, metadataFields.get(randomIntBetween(0, metadataFields.size() - 1)));
            List<String> mismatches = new CopyOnWriteArrayList<>();
                            for (int i = 0; i < iterationsPerThread; i++) {
            // Compute the expected fingerprint on a single thread first.
                startLatch.countDown();
        Processor processor = createFingerprintProcessor(fields, null, targetField, algorithm, false);  
                randomFrom(hashMethods),
package org.opensearch.ingest.common;
            excludeFields = new ArrayList<>();
                        try {
        String algorithm = randomFrom(hashMethods);
                    });
                                    new java.util.HashMap<>(Map.of(fieldName, fieldValue)),  
                assertTrue("concurrent fingerprint execution timed out", doneLatch.await(60, TimeUnit.SECONDS));  
        Processor processor = createFingerprintProcessor(fields, excludeFields, targetField, hashMethod, false);
        List<String> fields = new ArrayList<>();
            IngestDocument seed = new IngestDocument(new java.util.HashMap<>(Map.of(fieldName, fieldValue)), new java.util.HashMap<>());  
        }
        } else {
    private FingerprintProcessor createFingerprintProcessor(
import java.util.List;
        List<String> excludeFields = null;
import java.util.concurrent.CountDownLatch;
    private final List<String> hashMethods = List.of("MD5@2.16.0", "SHA-1@2.16.0", "SHA-256@2.16.0", "SHA3-256@2.16.0");
import java.util.stream.Collectors;  
            targetField = randomAlphaOfLength(10);  
        String existingFieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10));
            () -> createFingerprintProcessor(fields, null, null, randomFrom(hashMethods), false)
        if (randomBoolean()) {
    }  
            }
        if (randomBoolean()) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
                executor.shutdownNow();
            IllegalArgumentException.class,  
            IllegalArgumentException.class,
            try {
            () -> createFingerprintProcessor(Collections.emptyList(), null, "fingerprint", randomAlphaOfLength(10), false)  
                }  
        List<String> excludeFields = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);  
            .stream()  
        }  
     * {@link java.security.MessageDigest} instance and shared it across all ingest threads. Concurrent  
        processor.execute(ingestDocument);  
            nonExistingFields,
            excludeFields.add(null);  
        }  
        String fingerprint = ingestDocument.getFieldValue(targetField, String.class);  
        } else {
        );
            String fieldValue = randomAlphaOfLength(64);
        processor.execute(ingestDocument);
        } else {
                                if (expectedFingerprint.equals(actual) == false) {
        );  
    public void testGenerateFingerprint() throws Exception {
    }
                null,  
            null,
    public void testEmptyFieldAndExcludeFields() throws Exception {
        List<String> nonExistingFields = List.of(nonExistingFieldName);  
        assertThrows(
        assertThrows(  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(ingestDocument.hasField(targetField), equalTo(true));  
    }
        );
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < randomIntBetween(1, 10); i++) {  
    }
            for (int i = 0; i < randomIntBetween(1, 10); i++) {
            "fingerprint",  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
    public void testIgnoreMissing() throws Exception {  
/*  
import java.util.ArrayList;  
                                String actual = doc.getFieldValue(targetField, String.class);
            () -> processor.execute(ingestDocument)
        );  
                // Release all threads at once to maximize contention on the digest.
        if (randomBoolean()) {  
                for (int t = 0; t < threadCount; t++) {  
        fields.add(randomAlphaOfLength(10));
import org.opensearch.ingest.RandomDocumentPicks;  
            "field name in [exclude_fields] cannot be null nor empty",
        List<String> fields,
                                    new java.util.HashMap<>()
}
                false
            "either fields or exclude_fields can be set",
        List<String> metadataFields = ingestDocument.getMetadata()
        processor.execute(ingestDocument);  
            int threadCount = 16;
                                processor.execute(doc);  
    public void testCreateFingerprintProcessorFailed() {
            "field [" + nonExistingFieldName + "] doesn't exist",  
        assertThat(ingestDocument.hasField(targetField), equalTo(true));
    }
        for (String hashMethod : hashMethods) {
            assertThat("no exceptions expected during concurrent execution for " + hashMethod, failures, equalTo(List.of()));
        List<String> fields = null;  
        String hashMethod = randomFrom(hashMethods);  
                            startLatch.await();  
                excludeFields.add(RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10)));
        assertThrows(  
        processorWithIgnoreMissing.execute(ingestDocument);
 *
                                IngestDocument doc = new IngestDocument(
    public void testConcurrentExecuteIsThreadSafe() throws Exception {
import org.opensearch.ingest.Processor;
            String targetField = "fingerprint";  
        List<String> fields = null;  
            String expectedFingerprint = seed.getFieldValue(targetField, String.class);
            int iterationsPerThread = 200;
            randomFrom(hashMethods),
        String targetField = "fingerprint";
