        // Since testJavaPatternLocale is muted in FIPS mode, test that we can correctly parse dates in english
            randomAlphaOfLength(10),
        DateProcessor dateProcessor = new DateProcessor(
            );
        dateProcessor.execute(ingestDocument);
            "date_as_date"
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(e.getCause(), instanceOf(IllformedLocaleException.class));
            Collections.singletonList("iso8601"),
            assertThat(e.getCause().getMessage(), equalTo("Invalid format: [invalid pattern]: Unknown pattern letter: i"));
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
            "date_as_string",
            null,
            "date_as_string",
/*
 * license agreements. See the NOTICE file distributed with
            matchFormats,
}
import java.time.ZoneId;
            Collections.singletonList(format),
            null,
            document.put("date_as_string", "2010");
                randomAlphaOfLength(10),
            null,
            null,
            randomAlphaOfLength(10),
    public void testJavaPattern() {
            Collections.singletonList("yyyy dd MM HH:mm:ss"),
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
        dateProcessor.execute(ingestDocument);
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
            "date_as_date"
            assertThat(e.getMessage(), equalTo("unable to parse date [2010]"));
 *
/*
            templatize(Locale.ITALIAN),
        Map<String, Object> document = new HashMap<>();
    public void testInvalidLocale() {
import static org.hamcrest.CoreMatchers.containsString;
        );
        long nanosAfterEpoch = randomLongBetween(1, 999999);
        document.put("date_as_string", "2010");
            "date_as_string",
            Collections.singletonList("UNIX"),
        document.put("date_as_string", "2010 12 June");
            null,
            templatize(Locale.ENGLISH),
            null,
        dateProcessor.execute(ingestDocument);
    private TemplateScript.Factory templatize(ZoneId timezone) {
        );
import java.util.Map;
            "date_as_string",
 */
    }
            processor.execute(RandomDocumentPicks.randomIngestDocument(random(), document));
            randomAlphaOfLength(10),
            () -> processor.execute(RandomDocumentPicks.randomIngestDocument(random(), document))
import org.opensearch.ingest.TestTemplateService;
            Collections.singletonList("yyyy dd MMMM"),
            randomAlphaOfLength(10),
 */
import static org.hamcrest.CoreMatchers.instanceOf;
            Collections.singletonList("TAI64N"),
            "date_as_date"
            templatize(randomLocale(random())),
import java.util.Locale;
                templatize(ZoneOffset.UTC),
    public void testJavaPatternEnglishLocale() {
        try {
    }
 * Unless required by applicable law or agreed to in writing,
 *
 * Licensed to Elasticsearch under one or more contributor
        document.put("date_as_string", "2010 12 06");
 * specific language governing permissions and limitations
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
        String format = randomFrom("dd/MM", "8dd/MM");
        // output format is time only with nanosecond precision
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.ingest.IngestDocument;
 * software distributed under the License is distributed on an
    }
            "date_as_string",
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("1970-01-01T00:16:40.500Z"));
        DateProcessor dateProcessor = new DateProcessor(
                templatize(randomLocale(random())),
        DateProcessor dateProcessor = new DateProcessor(
        );
            templatize(ZoneId.of("Europe/Amsterdam")),
    }
import java.time.ZonedDateTime;
            "date_as_string",
    public void testInvalidTimezone() {
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T02:00:00.000Z"));
        dateProcessor.execute(ingestDocument);
    public void testTAI64N() {
        document.put("date_as_string", "2010");
        DateProcessor dateProcessor = new DateProcessor(
            randomAlphaOfLength(10),
                null,
        document.put("date_as_string", "2010");
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        matchFormats.add("dd-MM-yyyy");
        Map<String, Object> document = new HashMap<>();
import java.time.ZoneOffset;
        DateProcessor dateProcessor = new DateProcessor(
    public void testOutputFormat() {
            null,
        assertThat(
        document = new HashMap<>();
                "date_as_string",
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
import org.opensearch.script.TemplateScript;
        IllegalArgumentException e = expectThrows(
            randomAlphaOfLength(10),
            Collections.singletonList("yyyy dd MMMM"),
        String expectedDate = "00:00:00." + String.format(Locale.ROOT, "%09d", nanosAfterEpoch);
 *    http://www.apache.org/licenses/LICENSE-2.0
            templatize(ZoneOffset.UTC),
            templatize(ZoneId.of("Europe/Amsterdam")),
            templatize(ZoneId.of("Europe/Amsterdam")),
        document.put("date_as_string", "1000500");
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
        );
        );
    }
        );
            "date_as_date"
        Map<String, Object> document = new HashMap<>();
    }
        Map<String, Object> document = new HashMap<>();
            "date_as_string",
            "HH:mm:ss.SSSSSSSSS"
 *
            templatize(ZoneOffset.ofHours(2)),
            Collections.singletonList("UNIX_MS"),
        );
        String dateAsString = (randomBoolean() ? "@" : "") + "4000000050d506482dbdf024";
    }
        DateProcessor dateProcessor = new DateProcessor(
        dateProcessor.execute(ingestDocument);
                "date_as_date"
    public void testJavaPatternLocale() {
    public void testInvalidJavaPattern() {
            templatize(ZoneId.of("Europe/Amsterdam")),
        Map<String, Object> document = new HashMap<>();
            "date_as_string",
            fail("date processor execution should have failed");
                Collections.singletonList("invalid pattern"),
            templatize(ZoneId.of("Europe/Amsterdam")),
            templatize(Locale.ENGLISH),
        DateProcessor processor = new DateProcessor(
import java.time.Instant;
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("1970-01-01T00:16:40.500Z"));
    private TemplateScript.Factory templatize(Locale locale) {
        dateProcessor.execute(ingestDocument);
        } catch (IllegalArgumentException e) {
            "date_as_string",
            Map<String, Object> document = new HashMap<>();
            null,
        List<String> matchFormats = new ArrayList<>();
            assertThat(e.getMessage(), containsString("unable to parse date [2010]"));
 * under the License.
        try {
        document = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("1970-01-01T00:16:40.500Z"));
            Collections.singletonList("yyyy"),
            null,
package org.opensearch.ingest.common;
            null,
        assertThat(e.getMessage(), equalTo("unable to parse date [2010]"));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T00:00:00.000+02:00"));
        );
        assertThat(e.getMessage(), equalTo("unable to parse date [2010]"));
        );
            ingestDocument.getFieldValue("date_as_date", String.class),
            randomAlphaOfLength(10),
        Map<String, Object> document = new HashMap<>();
        document.put("date_as_string", "2010 12 06 00:00:00 -02:00");
    public void testJavaPatternMultipleFormats() {
import org.opensearch.ingest.RandomDocumentPicks;
 * not use this file except in compliance with the License.
            "date_as_string",
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
 * KIND, either express or implied.  See the License for the
    }
            randomAlphaOfLength(10),
            Collections.singletonList("yyyy"),
            "date_as_date"
    public void testJavaPatternDefaultYear() {
            "date_as_date",
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo(expectedDate));
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
import java.util.HashMap;
    public void testUnixMs() {
        return new TestTemplateService.MockTemplateScript.Factory(locale.getLanguage());
 */
            "date_as_string",
            new TestTemplateService.MockTemplateScript.Factory("invalid_locale"),
            IllegalArgumentException.class,
        );
            randomAlphaOfLength(10),
        DateProcessor dateProcessor = new DateProcessor(
            Arrays.asList("yyyy dd MM HH:mm:ss XXX"),
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document.put("date_as_string", dateAsString);
            "date_as_date"
        document = new HashMap<>();
        }
        document.put("date_as_string", Instant.EPOCH.plusNanos(nanosAfterEpoch).toString());
            templatize(randomLocale(random())),
import java.util.IllformedLocaleException;
        Map<String, Object> document = new HashMap<>();
 * You may obtain a copy of the License at
 * compatible open source license.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        DateProcessor processor = new DateProcessor(
            DateProcessor processor = new DateProcessor(
        Map<String, Object> document = new HashMap<>();
            templatize(randomLocale(random())),
        );
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2010-06-12T11:05:15.000+02:00"));
            randomAlphaOfLength(10),
            () -> processor.execute(RandomDocumentPicks.randomIngestDocument(random(), document))
        DateProcessor processor = new DateProcessor(
            "date_as_date"
        document = new HashMap<>();
            null,
    }
            null,
        Map<String, Object> document = new HashMap<>();
        matchFormats.add("yyyy dd MM");
            "date_as_date"
        } catch (IllegalArgumentException e) {
    }
            templatize(ZoneOffset.UTC),
        dateProcessor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        processor.execute(ingestDocument);
 * this file be licensed under the Apache-2.0 license or a
            new TestTemplateService.MockTemplateScript.Factory("invalid_timezone"),
        );
        document.put("date_as_string", "2010 12 giugno");
        document.put("date_as_string", 1000500L);
            "date_as_date"
    }
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            IllegalArgumentException.class,
            "date_as_date"
            randomAlphaOfLength(10),
        dateProcessor.execute(ingestDocument);
    }
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        );
        document.put("date_as_string", "12/06");
        document.put("date_as_string", "12-06-2010");
            "date_as_date"
    }
    }
import java.util.ArrayList;
 * the Apache License, Version 2.0 (the "License"); you may
            templatize(ZoneOffset.UTC),
            fail("processor should have failed due to not supported date format");
            randomAlphaOfLength(10),
import java.util.Collections;
            dateProcessor.execute(ingestDocument);
            equalTo(ZonedDateTime.now(ZoneId.of("Europe/Amsterdam")).getYear() + "-06-12T00:00:00.000+02:00")
        );
        DateProcessor dateProcessor = new DateProcessor(
public class DateProcessorTests extends OpenSearchTestCase {
import java.util.List;
        assertThat(e.getCause().getMessage(), equalTo("Unknown time-zone ID: invalid_timezone"));
        IllegalArgumentException e = expectThrows(
        dateProcessor.execute(ingestDocument);
        }
/*
    public void testJavaPatternNoTimezone() {
import java.util.Arrays;
        document.put("date_as_string", "2010 12 06 11:05:15");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            null,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document.put("date_as_string", "12/06/2010");
            templatize(Locale.ENGLISH),
    public void testUnix() {
        dateProcessor.execute(ingestDocument);
 * GitHub history for details.
        Map<String, Object> document = new HashMap<>();
            "date_as_string",
        matchFormats.add("dd/MM/yyyy");
        DateProcessor dateProcessor = new DateProcessor(
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            null,
import org.opensearch.test.OpenSearchTestCase;
        dateProcessor.execute(ingestDocument);
            null,
            null,
        document.put("date_as_string", "1000.5");
 * this work for additional information regarding copyright
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        );
            templatize(randomLocale(random())),
            templatize(Locale.ENGLISH),
        dateProcessor.execute(ingestDocument);
        assertThat(ingestDocument.getFieldValue("date_as_date", String.class), equalTo("2012-12-22T03:00:46.767+02:00"));
        return new TestTemplateService.MockTemplateScript.Factory(timezone.getId());
 * Modifications Copyright OpenSearch Contributors. See
