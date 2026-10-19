 * software distributed under the License is distributed on an
                    + indexNameFormat
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        IngestDocument document = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("_field", "1000.5"));  
            null,  
 *  
            document.getSourceAndMetadata().get("_index"),
        dateProcessor.execute(document);  
            Collections.singletonMap("_field", "2016-04-25T12:24:20.101Z")  
            Collections.singletonList(function),
    ) {
 * Unless required by applicable law or agreed to in writing,
        );
 * not use this file except in compliance with the License.
 * compatible open source license.
import java.util.List;  
                    + DateFormatter.forPattern(indexNameFormat).format(dateTimeFunction.apply(date))  
        );
import java.time.ZoneOffset;  
        );
            "yyyyMMdd"
            )  
            Collections.singletonList(function),  
            "y",  
        dateProcessor.execute(document);  
                    + indexNamePrefix
package org.opensearch.ingest.common;
 * SPDX-License-Identifier: Apache-2.0
    }
        dateProcessor.execute(document);
import org.opensearch.common.time.DateFormatter;  
            "_field",
/*
        );
            null,
 */
        );
        Function<String, ZonedDateTime> dateTimeFunction = DateFormat.Unix.getFunction(null, ZoneOffset.UTC, null);
            "_id",
        return new DateIndexNameProcessor(  
            dateRounding,
public class DateIndexNameProcessorTests extends OpenSearchTestCase {  
            Collections.singletonList(function),
 * Licensed to Elasticsearch under one or more contributor  
            "_field",
import java.time.ZoneId;
            ZoneOffset.UTC,
            new TestTemplateService.MockTemplateScript.Factory(indexNamePrefix),  
        String date = Integer.toString(randomInt());  
            "yyyyMMdd"
/*  
            randomAlphaOfLength(10),
            Collections.singletonList(function),  
            new TestTemplateService.MockTemplateScript.Factory(dateRounding),
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        );
        String indexNamePrefix = randomAlphaOfLength(10);  
        assertThat(document.getSourceAndMetadata().get("_index"), equalTo("<events-{19700101||/m{yyyyMMdd|UTC}}>"));
            new TestTemplateService.MockTemplateScript.Factory(indexNameFormat)
 * this file be licensed under the Apache-2.0 license or a
        IngestDocument document = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("_field", date));  
            "_index",
                    + "{"  
    }  
                    + "{"
import java.time.ZonedDateTime;
            ZoneOffset.UTC,
        document = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("_field", 1000500L));  
        Function<String, ZonedDateTime> function = DateFormat.UnixMs.getFunction(null, ZoneOffset.UTC, null);
            equalTo(
import org.opensearch.test.OpenSearchTestCase;  
        String indexNameFormat
        assertThat(document.getSourceAndMetadata().get("_index"), equalTo("<events-{20121222||/m{yyyyMMdd|UTC}}>"));
            indexNameFormat  
                    + dateRounding
        Function<String, ZonedDateTime> function = DateFormat.Unix.getFunction(null, ZoneOffset.UTC, null);  
    public void testUnixMs() throws Exception {
    }
                    + "||/"
        );  
        DateIndexNameProcessor dateProcessor = createProcessor(
            null,  
    public void testTAI64N() throws Exception {  
        String field,
 * KIND, either express or implied.  See the License for the
            ZoneOffset.UTC,  
        );
            ZoneOffset.UTC,
        List<Function<String, ZonedDateTime>> dateFormats,  
            timezone,
    }  
            "_field",
            "_field",  
            ZoneOffset.UTC,  
            dateFormats,
        DateIndexNameProcessor processor = createProcessor(
        dateProcessor.execute(document);
 * specific language governing permissions and limitations
            null,
 *    http://www.apache.org/licenses/LICENSE-2.0
            null,
            Collections.singletonMap("_field", (randomBoolean() ? "@" : "") + "4000000050d506482dbdf024")
            "m",  
        String dateRounding = randomFrom("y", "M", "w", "d", "h", "m", "s");
            null,
    public void testJavaPattern() throws Exception {
            "m",
    }
            "yyyyMMdd"  
import org.opensearch.ingest.TestTemplateService;
            Collections.singletonList(dateTimeFunction),
    private DateIndexNameProcessor createProcessor(
import static org.hamcrest.CoreMatchers.equalTo;
        IngestDocument document = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("_field", "1000500"));
        String indexNameFormat = randomFrom("yyyy-MM-dd'T'HH:mm:ss.SSSZZ", "yyyyMMdd", "MM/dd/yyyy");
 */
        DateIndexNameProcessor dateProcessor = createProcessor(
/*
        String dateRounding,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testUnix() throws Exception {
            field,  
        IngestDocument document = new IngestDocument(  
                "<"  
import java.util.function.Function;
        String indexNamePrefix,
            "events-",  
        processor.execute(document);
        );  
 *
}
 *
        IngestDocument document = new IngestDocument(
            "_id",  
 * You may obtain a copy of the License at  
            "events-",
            null,
            indexNamePrefix,
            "_field",
        ZoneId timezone,
 * The OpenSearch Contributors require contributions made to  
        dateProcessor.execute(document);
        Function<String, ZonedDateTime> function = DateFormat.Tai64n.getFunction(null, ZoneOffset.UTC, null);
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(document.getSourceAndMetadata().get("_index"), equalTo("<events-{19700101||/m{yyyyMMdd|UTC}}>"));
 * Modifications Copyright OpenSearch Contributors. See  
            "yyyyMMdd"
            "events-",
                    + "|UTC}}>"
        assertThat(document.getSourceAndMetadata().get("_index"), equalTo("<events-{19700101||/m{yyyyMMdd|UTC}}>"));
        assertThat(document.getSourceAndMetadata().get("_index"), equalTo("<events-{20160425||/y{yyyyMMdd|UTC}}>"));  
        DateIndexNameProcessor dateProcessor = createProcessor(  
    public void testTemplatedFields() throws Exception {
        Function<String, ZonedDateTime> function = DateFormat.Java.getFunction("yyyy-MM-dd'T'HH:mm:ss.SSSXX", ZoneOffset.UTC, Locale.ROOT);  
            "_index",
    }
        DateIndexNameProcessor dateProcessor = createProcessor(  
import java.util.Locale;
            "m",
        assertThat(  
import java.util.Collections;
            "events-",
import org.opensearch.ingest.IngestDocument;
 * GitHub history for details.
