            dateProcessor.execute(ingestDocument);
        DateProcessor dateProcessor = new DateProcessor(
/*
        DateProcessor dateProcessor = new DateProcessor(  
        document.put("date_as_string", "2010");
        document.put("date_as_string", Instant.EPOCH.plusNanos(nanosAfterEpoch).toString());
            "date_as_date"  
        // Since testJavaPatternLocale is muted in FIPS mode, test that we can correctly parse dates in english
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> document = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
            null,  
                "date_as_string",  
            matchFormats,
import static org.hamcrest.CoreMatchers.containsString;
            "date_as_string",
        assertThat(e.getMessage(), equalTo("unable to parse date [2010]"));
            Collections.singletonList("iso8601"),
        document.put("date_as_string", "2010 12 06 00:00:00 -02:00");
    public void testOutputFormat() {  
        } catch (IllegalArgumentException e) {
            templatize(randomLocale(random())),  
        dateProcessor.execute(ingestDocument);
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            "date_as_string",
        DateProcessor dateProcessor = new DateProcessor(
            null,  
        );
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
    }  
            randomAlphaOfLength(10),  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
        document.put("date_as_string", "2010");
            DateProcessor processor = new DateProcessor(
        matchFormats.add("dd-MM-yyyy");
    public void testJavaPattern() {
    }
            "date_as_date"
            randomAlphaOfLength(10),
    private TemplateScript.Factory templatize(ZoneId timezone) {  
                randomAlphaOfLength(10),
 * this work for additional information regarding copyright
        );
    }
        );
 *
    }
/*  
            null,
        );
            Collections.singletonList("yyyy"),  
            "date_as_string",  
            null,
    public void testJavaPatternDefaultYear() {
        Map<String, Object> document = new HashMap<>();  
import java.time.ZoneId;
        long nanosAfterEpoch = randomLongBetween(1, 999999);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            templatize(ZoneId.of("Europe/Amsterdam")),  
 * KIND, either express or implied.  See the License for the
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo(expectedDate));  
        DateProcessor dateProcessor = new DateProcessor(
            templatize(ZoneId.of("Europe/Amsterdam")),
        processor.execute(ingestDocument);  
            randomAlphaOfLength(10),  
        assertThat(e.getMessage(), equalTo("unable to parse date [2010]"));  
        );  
            "date_as_string",
            null,
            "date_as_string",
            templatize(ZoneId.of("Europe/Amsterdam")),  
            templatize(randomLocale(random())),
            Map<String, Object> document = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2012-12-22T03:00:46.767+02:00"));
            null,
    }
            templatize(ZoneOffset.ofHours(2)),
        dateProcessor.execute(ingestDocument);
    public void testInvalidTimezone() {
    public void testJavaPatternNoTimezone() {
            templatize(ZoneId.of("Europe/Amsterdam")),  
    }
            "date_as_date"
            null,
        Map<String, Object> document = new HashMap<>();  
                null,  
 * under the License.  
        Map<String, Object> document = new HashMap<>();
            "date_as_date",  
    }
        document.put("date_as_string", "2010 12 June");
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
        DateProcessor dateProcessor = new DateProcessor(  
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("1970-01-01T00:16:40.500Z"));
import org.opensearch.ingest.RandomDocumentPicks;
    }  
            "date_as_string",
                "date_as_date"
            randomAlphaOfLength(10),
            assertThat(e.getMessage(), equalTo("unable to parse date [2010]"));  
        dateProcessor.execute(ingestDocument);
        );
import java.util.Arrays;  
            "date_as_date"
 * The OpenSearch Contributors require contributions made to  
            null,
        document.put("date_as_string", "1000.5");
public class DateProcessorTests extends OpenSearchTestCase {  
    public void testUnix() {  
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> document = new HashMap<>();
        return new TestTemplateService.MockTemplateScript.Factory(locale.getLanguage());  
        dateProcessor.execute(ingestDocument);  
            null,
}
            templatize(ZoneId.of("Europe/Amsterdam")),
            () -> processor.execute(RandomDocumentPicks.randomIngestDocument(random(), document))  
            "date_as_date"  
        assertThat(
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document = new HashMap<>();  
        );
import java.time.ZonedDateTime;
 * specific language governing permissions and limitations
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T02:00:00.000Z"));
    }
            templatize(randomLocale(random())),
            randomAlphaOfLength(10),
    public void testUnixMs() {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            processor.execute(RandomDocumentPicks.randomIngestDocument(random(), document));  
            Collections.singletonList("yyyy dd MMMM"),  
        String expectedDate = "00:00:00." + String.format(Locale.ROOT, "%09d", nanosAfterEpoch);
        matchFormats.add("dd/MM/yyyy");  
            "date_as_string",
            assertThat(e.getCause().getMessage(), equalTo("Invalid format: [invalid pattern]: Unknown pattern letter: i"));
    }
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("1970-01-01T00:16:40.500Z"));  
            templatize(ZoneOffset.UTC),
            Collections.singletonList("yyyy dd MM HH:mm:ss"),
import org.opensearch.ingest.IngestDocument;
            templatize(Locale.ENGLISH),
        document = new HashMap<>();  
            equalTo(ZonedDateTime.now(ZoneId.of("Europe/Amsterdam")).getYear() + "-06-12T00:00:00.000+02:00")  
package org.opensearch.ingest.common;
    }
            null,
        DateProcessor processor = new DateProcessor(
            "HH:mm:ss.SSSSSSSSS"
        dateProcessor.execute(ingestDocument);  
        Map<String, Object> document = new HashMap<>();
            templatize(ZoneOffset.UTC),
            "date_as_string",
            new TestTemplateService.MockTemplateScript.Factory("invalid_locale"),  
    public void testTAI64N() {
        DateProcessor dateProcessor = new DateProcessor(  
        );
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        matchFormats.add("yyyy dd MM");
 */  
        document.put("date_as_string", "2010");  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, Object> document = new HashMap<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        return new TestTemplateService.MockTemplateScript.Factory(timezone.getId());
        dateProcessor.execute(ingestDocument);
            "date_as_date"  
 * not use this file except in compliance with the License.
            "date_as_date"
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            () -> processor.execute(RandomDocumentPicks.randomIngestDocument(random(), document))
        DateProcessor dateProcessor = new DateProcessor(
            templatize(ZoneOffset.UTC),
import org.opensearch.script.TemplateScript;
        String format = randomFrom("dd/MM", "8dd/MM");
        DateProcessor dateProcessor = new DateProcessor(  
 * ownership. Elasticsearch licenses this file to you under  
        dateProcessor.execute(ingestDocument);
            randomAlphaOfLength(10),
            "date_as_date"  
        assertThat(e.getCause().getMessage(), equalTo("Unknown time-zone ID: invalid_timezone"));
            randomAlphaOfLength(10),
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
            null,
 * compatible open source license.
        DateProcessor processor = new DateProcessor(
        document.put("date_as_string", "12-06-2010");
            IllegalArgumentException.class,
                Collections.singletonList("invalid pattern"),
        IllegalArgumentException e = expectThrows(
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
import java.util.List;
        );
import java.util.HashMap;
            "date_as_date"  
            "date_as_string",
        );
 * Unless required by applicable law or agreed to in writing,
        }
        // output format is time only with nanosecond precision
        Map<String, Object> document = new HashMap<>();  
import java.util.IllformedLocaleException;  
        DateProcessor dateProcessor = new DateProcessor(
            null,
        document.put("date_as_string", dateAsString);
            "date_as_string",
import java.util.Map;  
        } catch (IllegalArgumentException e) {  
            randomAlphaOfLength(10),  
            null,  
        document = new HashMap<>();  
            templatize(Locale.ENGLISH),  
        try {  
import static org.hamcrest.CoreMatchers.instanceOf;
        IllegalArgumentException e = expectThrows(
            randomAlphaOfLength(10),  
        dateProcessor.execute(ingestDocument);  
        );
            randomAlphaOfLength(10),  
        );
            randomAlphaOfLength(10),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("1970-01-01T00:16:40.500Z"));  
        document.put("date_as_string", "2010 12 06");
            assertThat(e.getMessage(), containsString("unable to parse date [2010]"));
            Collections.singletonList("UNIX_MS"),
import java.util.Locale;
            new TestTemplateService.MockTemplateScript.Factory("invalid_timezone"),  
            "date_as_date"
            Collections.singletonList("TAI64N"),
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
 * GitHub history for details.
 *
            Collections.singletonList(format),  
            );  
import java.time.Instant;
 * SPDX-License-Identifier: Apache-2.0
        dateProcessor.execute(ingestDocument);  
            "date_as_date"
            null,
            Arrays.asList("yyyy dd MM HH:mm:ss XXX"),  
        );
 * Modifications Copyright OpenSearch Contributors. See
        dateProcessor.execute(ingestDocument);  
            Collections.singletonList("UNIX"),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, Object> document = new HashMap<>();  
import java.util.ArrayList;
    public void testJavaPatternMultipleFormats() {  
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T11:05:15.000+02:00"));  
 */  
/*  
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            templatize(Locale.ENGLISH),  
            ingestDocument.getFieldValue("date_as_date", String.class),
            "date_as_string",
        document.put("date_as_string", 1000500L);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            Collections.singletonList("yyyy dd MMMM"),  
            fail("date processor execution should have failed");
            null,
                templatize(ZoneOffset.UTC),
            "date_as_string",
            templatize(Locale.ENGLISH),
        Map<String, Object> document = new HashMap<>();
    private TemplateScript.Factory templatize(Locale locale) {
        List<String> matchFormats = new ArrayList<>();
        Map<String, Object> document = new HashMap<>();  
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
        }
 * software distributed under the License is distributed on an
        dateProcessor.execute(ingestDocument);  
                templatize(randomLocale(random())),
        DateProcessor processor = new DateProcessor(  
import static org.hamcrest.CoreMatchers.equalTo;  
    }  
        document.put("date_as_string", "12/06");
    public void testJavaPatternEnglishLocale() {
            templatize(randomLocale(random())),  
            null,
        document = new HashMap<>();
            templatize(Locale.ITALIAN),
        );
import org.opensearch.ingest.TestTemplateService;  
    public void testInvalidLocale() {
 * Licensed to Elasticsearch under one or more contributor  
 *  
    public void testJavaPatternLocale() {
    }  
import java.time.ZoneOffset;  
        try {  
        document.put("date_as_string", "12/06/2010");
        document.put("date_as_string", "2010 12 06 11:05:15");  
        );
import java.util.Collections;
        document.put("date_as_string", "1000500");  
        dateProcessor.execute(ingestDocument);  
            fail("processor should have failed due to not supported date format");
import org.opensearch.test.OpenSearchTestCase;
            Collections.singletonList("yyyy"),
 */
        document.put("date_as_string", "2010 12 giugno");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        assertThat(e.getCause(), instanceOf(IllformedLocaleException.class));  
            IllegalArgumentException.class,  
    public void testInvalidJavaPattern() {
            randomAlphaOfLength(10),  
        String dateAsString = (randomBoolean() ? "@" : "") + "4000000050d506482dbdf024";  
            document.put("date_as_string", "2010");
