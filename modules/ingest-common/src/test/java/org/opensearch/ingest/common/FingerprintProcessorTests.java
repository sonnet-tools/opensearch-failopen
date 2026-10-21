            .collect(Collectors.toList());
            nonExistingFields,
     * either wrong fingerprints or an ArrayIndexOutOfBoundsException from the native crypto provider.
            IllegalArgumentException.class,
        Processor processor = createFingerprintProcessor(nonExistingFields, null, "fingerprint", randomFrom(hashMethods), false);
import org.opensearch.ingest.Processor;
            List<Throwable> failures = new CopyOnWriteArrayList<>();
            fields.add(null);
        );
            IllegalArgumentException.class,
                                String actual = doc.getFieldValue(targetField, String.class);
import java.util.concurrent.CopyOnWriteArrayList;
            String fieldValue = randomAlphaOfLength(64);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String targetField = "fingerprint";
        processor.execute(ingestDocument);
     * {@code execute()} calls raced on the shared digest, corrupting its internal state and producing
                excludeFields.add(RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10)));
 * this file be licensed under the Apache-2.0 license or a
            excludeFields = new ArrayList<>();
import static org.hamcrest.Matchers.equalTo;
    }
     * {@link java.security.MessageDigest} instance and shared it across all ingest threads. Concurrent
                false
        processor.execute(ingestDocument);
        List<String> excludeFields,
            assertThat("no exceptions expected during concurrent execution for " + hashMethod, failures, equalTo(List.of()));
        List<String> fields = new ArrayList<>();
    public void testGenerateFingerprint() throws Exception {
                        } catch (Throwable e) {
        }
    private FingerprintProcessor createFingerprintProcessor(
            "field [" + nonExistingFieldName + "] doesn't exist",
        String existingFieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10));
        if (randomBoolean()) {
        List<String> fields = null;
public class FingerprintProcessorTests extends OpenSearchTestCase {
            // Compute the expected fingerprint on a single thread first.
            () -> createFingerprintProcessor(fields, null, null, randomFrom(hashMethods), false)
            "field name in [fields] cannot be null nor empty",
                            failures.add(e);
        List<String> fields,
            try {
        }
            Processor processor = createFingerprintProcessor(List.of(fieldName), null, targetField, hashMethod, false);
        String targetField = "fingerprint";
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Processor processor = createFingerprintProcessor(fields, excludeFields, targetField, hashMethod, false);
        for (String hashMethod : hashMethods) {
    public void testIgnoreMissing() throws Exception {
            null,
        String nonExistingFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
            }
            int threadCount = 16;
                        } finally {
        } else {
    ) {
 *
        Processor processor = createFingerprintProcessor(fields, null, targetField, algorithm, false);
                    executor.execute(() -> {
 * compatible open source license.
            true
import java.util.Collections;
        assertThrows(
        String hashMethod = randomFrom(hashMethods);
 * The OpenSearch Contributors require contributions made to
            "field name in [exclude_fields] cannot be null nor empty",
        assertThrows(
    public void testIgnoreMetadataFields() throws Exception {
        );
        assertThat(ingestDocument.hasField(targetField), equalTo(true));
     * Regression test for the thread-safety defect where the {@code HashMethod} enum cached a single
            } finally {
                executor.shutdownNow();
package org.opensearch.ingest.common;
            "fingerprint",
            IngestDocument seed = new IngestDocument(new java.util.HashMap<>(Map.of(fieldName, fieldValue)), new java.util.HashMap<>());
                                    mismatches.add(actual);
        assertThrows(
        if (randomBoolean()) {
            () -> createFingerprintProcessor(Collections.emptyList(), null, "fingerprint", randomAlphaOfLength(10), false)
            CountDownLatch doneLatch = new CountDownLatch(threadCount);
            () -> processor.execute(ingestDocument)
        List<String> excludeFields = new ArrayList<>();
                                    new java.util.HashMap<>(Map.of(fieldName, fieldValue)),
        List<String> fields = List.of(existingFieldName, metadataFields.get(randomIntBetween(0, metadataFields.size() - 1)));
                            doneLatch.countDown();
        );
                for (int t = 0; t < threadCount; t++) {
                        try {
                fields.add(RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10)));
    public void testConcurrentExecuteIsThreadSafe() throws Exception {
 */
    public void testEmptyFieldAndExcludeFields() throws Exception {
        }
        assertThat(ingestDocument.hasField(targetField), equalTo(true));
                randomFrom(hashMethods),
            excludeFields.add("");
        if (randomBoolean()) {
            fields.add("");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
                            startLatch.await();
    private final List<String> hashMethods = List.of("MD5@2.16.0", "SHA-1@2.16.0", "SHA-256@2.16.0", "SHA3-256@2.16.0");
            int iterationsPerThread = 200;
        boolean ignoreMissing
                }
                startLatch.countDown();
        } else {
            processor.execute(seed);
import java.util.concurrent.TimeUnit;
    }
import java.util.ArrayList;
                                );
            String expectedFingerprint = seed.getFieldValue(targetField, String.class);
/*
            randomFrom(hashMethods),
            }
            excludeFields.add(null);
            )
                                IngestDocument doc = new IngestDocument(
            for (int i = 0; i < randomIntBetween(1, 10); i++) {
     */
            fields = new ArrayList<>();
                List.of(randomAlphaOfLength(10)),
        fields.add(randomAlphaOfLength(10));
    }
        String targetField = "fingerprint";
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
                                processor.execute(doc);
            "either fields or exclude_fields can be set",
        processor.execute(ingestDocument);
            for (int i = 0; i < randomIntBetween(1, 10); i++) {
        );
            CountDownLatch startLatch = new CountDownLatch(1);
                                    new java.util.HashMap<>()
        List<String> metadataFields = ingestDocument.getMetadata()
            () -> createFingerprintProcessor(null, excludeFields, null, randomFrom(hashMethods), false)
            .stream()
import java.util.List;
        String hashMethod = randomFrom(hashMethods);
        String targetField = "fingerprint";
                assertTrue("concurrent fingerprint execution timed out", doneLatch.await(60, TimeUnit.SECONDS));
        List<String> excludeFields = null;
            .keySet()
        List<String> excludeFields = null;
            IllegalArgumentException.class,
    }
                List.of(randomAlphaOfLength(10)),
            () -> createFingerprintProcessor(
        if (randomBoolean()) {
            assertThat("all concurrent fingerprints must match the sequential result for " + hashMethod, mismatches, equalTo(List.of()));
        if (randomBoolean()) {
                // Release all threads at once to maximize contention on the digest.
import org.opensearch.ingest.RandomDocumentPicks;
    }
        } else {
        String targetField,
        assertThrows(
        if (randomBoolean()) {
        );
        assertThrows(
        }
        }
            }
            targetField = randomAlphaOfLength(10);
    /**
}
import java.util.Map;
        processor = createFingerprintProcessor(List.of(existingFieldName), null, targetField, algorithm, false);
        processorWithIgnoreMissing.execute(ingestDocument);
                                }
                    });
        Processor processorWithIgnoreMissing = createFingerprintProcessor(
        excludeFields.add(randomAlphaOfLength(10));
        List<String> nonExistingFields = List.of(nonExistingFieldName);
            IllegalArgumentException.class,
            .map(IngestDocument.Metadata::getFieldName)
                null,
import org.opensearch.test.OpenSearchTestCase;
        assertThat(ingestDocument.getFieldValue(targetField, String.class), equalTo(fingerprint));
                        }
                                if (expectedFingerprint.equals(actual) == false) {
        }
            targetField = randomAlphaOfLength(10);
        processor.execute(ingestDocument);
        String hashMethod,
            fields = new ArrayList<>();
        String algorithm = randomFrom(hashMethods);
            IllegalArgumentException.class,
        List<String> fields = null;
            excludeFields = new ArrayList<>();
            "hash method must be MD5@2.16.0, SHA-1@2.16.0, SHA-256@2.16.0 or SHA3-256@2.16.0",
import java.util.concurrent.ExecutorService;
    }
                            }
            List<String> mismatches = new CopyOnWriteArrayList<>();
                            for (int i = 0; i < iterationsPerThread; i++) {
import java.util.concurrent.CountDownLatch;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        } else {
        String fingerprint = ingestDocument.getFieldValue(targetField, String.class);
    }
        Processor processor = createFingerprintProcessor(fields, excludeFields, targetField, hashMethod, false);
            String fieldName = "content";
    public void testCreateFingerprintProcessorFailed() {
            String targetField = "fingerprint";
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
 * SPDX-License-Identifier: Apache-2.0
        return new FingerprintProcessor(randomAlphaOfLength(10), null, fields, excludeFields, targetField, hashMethod, ignoreMissing);
        }
import org.opensearch.ingest.IngestDocument;
        assertThat(ingestDocument.hasField(targetField), equalTo(false));
        );
