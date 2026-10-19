        assertThat(
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.core.common.unit.ByteSizeValue;
        long randomNumber = randomLongBetween(1, Long.MAX_VALUE / ByteSizeUnit.PB.toBytes(1));
 * Unless required by applicable law or agreed to in writing,
 */
    @Override
import org.opensearch.ingest.RandomDocumentPicks;
        assertThat(exception.getMessage(), CoreMatchers.containsString("unit is missing or unrecognized"));  
    public void testMissingUnits() {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
    @Override
        Processor processor = newProcessor(fieldName, randomBoolean(), fieldName);
            exception.getCause().getMessage(),  
        assertThat(
            CoreMatchers.equalTo("failed to parse setting [Ingest Field] with value [8912pb] as a size in bytes")  
    }  
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> processor.execute(ingestDocument));
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> processor.execute(ingestDocument));  
}  
import org.opensearch.ingest.Processor;  
 * this work for additional information regarding copyright
import org.hamcrest.CoreMatchers;
import org.opensearch.OpenSearchParseException;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }
    public void testFractional() {  
            e.getMessage(),  
    protected String modifyInput(String input) {
        assertThat(
/*  
    @Override  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "1.1kb");
        modifiedInput = randomNumber + randomUnit.getSuffix();  
    protected Class<Long> expectedResultType() {
 * Modifications Copyright OpenSearch Contributors. See
        Processor processor = newProcessor(fieldName, randomBoolean(), fieldName);
 * The OpenSearch Contributors require contributions made to  
        ByteSizeUnit randomUnit = randomFrom(ByteSizeUnit.values());
 */  
    }
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> processor.execute(ingestDocument));
        Processor processor = newProcessor(fieldName, randomBoolean(), fieldName);  
        Processor processor = newProcessor(fieldName, randomBoolean(), fieldName);
import org.opensearch.core.common.unit.ByteSizeUnit;  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 *  
 * this file be licensed under the Apache-2.0 license or a
        return ByteSizeValue.parseBytesSizeValue(modifiedInput, null, "").getBytes();  
    private String modifiedInput;  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
            CoreMatchers.containsString(
    @Override
public class BytesProcessorTests extends AbstractStringProcessorTestCase<Long> {
 *
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
import org.opensearch.ingest.IngestDocument;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "junk");
 * license agreements. See the NOTICE file distributed with
 * under the License.  
            exception.getMessage(),
/*  
    public void testNotBytes() {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "8912pb");
    }
/*
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * Licensed to Elasticsearch under one or more contributor  
        );
        return modifiedInput;
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected AbstractStringProcessor<Long> newProcessor(String field, boolean ignoreMissing, String targetField) {  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "1");  
    }  
        // largest value that allows all results < Long.MAX_VALUE bytes  
        );
        );
    public void testTooLarge() {
    protected Long expectedResult(String input) {
                "Fractional bytes values have been deprecated since Legacy 6.2. " + "Use non-fractional bytes values instead:"
import org.opensearch.OpenSearchException;
 * specific language governing permissions and limitations
 *
        return Long.class;
        assertThat(exception.getMessage(), CoreMatchers.equalTo("failed to parse [junk]"));
 */  
        OpenSearchException exception = expectThrows(OpenSearchException.class, () -> processor.execute(ingestDocument));  
 * GitHub history for details.
            CoreMatchers.containsString("Values greater than 9223372036854775807 bytes are not supported")
    }
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        return new BytesProcessor(randomAlphaOfLength(10), null, field, ignoreMissing, targetField);
            )  
package org.opensearch.ingest.common;
