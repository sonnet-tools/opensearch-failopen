            false  
        location.put("lat", 25.4573d);  
            randomAlphaOfLength(10),
            EnumSet.allOf(GeoIpProcessor.Property.class),
        );  
        String address = "2602:306:33d3:8000::3257:9652";
        @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
            random(),
            false,  
            null,
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("80.231.5.0"));
            randomAlphaOfLength(10),  
        assertThat(exception.getMessage(), equalTo("field [source_field] is null, cannot extract geoip information."));
            false
            false,  
        assertThat(geoData.get("ip"), equalTo("80.231.5.0"));
            EnumSet.allOf(GeoIpProcessor.Property.class),
import static org.hamcrest.Matchers.nullValue;  
            loader("/GeoLite2-City.mmdb"),
            EnumSet.allOf(GeoIpProcessor.Property.class),  
        );
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
/*  
        document.put("source_field", "80.231.5.0");  
        assertThat(geoData.size(), equalTo(1));
        Map<String, Object> document = new HashMap<>();
        document.put("source_field", "www.google.com");  
        assertThat(geoData.get("timezone"), equalTo("America/Chicago"));  
        assertThat(geoData.get("region_iso_code"), equalTo("US-FL"));
            new GeoIpCache(1000),
import org.opensearch.test.OpenSearchTestCase;
        document.put("source_field", "8.8.8.8");  
            Collections.singletonMap("source_field", null)  
    }
            new GeoIpCache(1000),
        assertThat(geoData.get("continent_name"), equalTo("North America"));  
        assertThat(geoData.get("country_iso_code"), equalTo("US"));
    }
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        GeoIpProcessor processor = new GeoIpProcessor(  
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("80.231.5.0"));
        @SuppressWarnings("unchecked")  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
            new GeoIpCache(1000),  
    }
    public void testNonExistentWithoutIgnoreMissing() throws Exception {
        Map<String, Object> document = new HashMap<>();  
            null,
            EnumSet.allOf(GeoIpProcessor.Property.class),
        assertThat(geoData.get("asn"), equalTo(1136L));
    public void testNullValueWithIgnoreMissing() throws Exception {
import org.opensearch.ingest.IngestDocument;
            loader("/GeoLite2-City.mmdb"),  
                return databaseInputStreamSupplier.get();
        assertThat(geoData.size(), equalTo(4));  
        document.put("source_field", Arrays.asList("8.8.8.8", "127.0.0.1"));
 */  
        location.put("lon", -80.4572d);
        );
        );
            EnumSet.allOf(GeoIpProcessor.Property.class),
            randomAlphaOfLength(10),  
import java.io.InputStream;
            randomAlphaOfLength(10),  
        location.put("lon", -97.822d);
            "target_field",
        );  
            EnumSet.allOf(GeoIpProcessor.Property.class),
            false,
    public void testInvalid() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        );  
            new GeoIpCache(1000),
            null,
            null,  
        document.put("source_field", Arrays.asList("8.8.8.8", "127.0.0.1"));  
        assertThat(geoData.get("country_name"), equalTo("United States"));
        Map<String, Object> document = new HashMap<>();
        processor.execute(ingestDocument);
        Map<String, Object> document = new HashMap<>();
        processor.execute(ingestDocument);
    }  
            "target_field",
            true,  
        assertThat(geoData.get("country_name"), equalTo("Netherlands"));  
            randomAlphaOfLength(10),  
        assertIngestDocument(originalIngestDocument, ingestDocument);
            "source_field",
        assertThat(e.getMessage(), containsString("not an IP string literal"));  
                try (InputStream is = databaseInputStreamSupplier.get()) {  
import org.opensearch.ingest.RandomDocumentPicks;  
            new GeoIpCache(1000),
        assertThat(geoData.get("organization_name"), equalTo("KPN B.V."));  
            true
        );  
        List<Map<String, Object>> geoData = (List<Map<String, Object>>) ingestDocument.getSourceAndMetadata().get("target_field");
            "source_field",
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
            loader("/GeoLite2-City.mmdb"),  
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");  
            loader("/GeoLite2-City.mmdb"),  
            new GeoIpCache(1000),
            false,  
            null,  
        location.put("lat", 37.751d);
        );  
        GeoIpProcessor processor = new GeoIpProcessor(
            false,  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
                        bytesRead += read;  
package org.opensearch.ingest.geoip;
        GeoIpProcessor processor = new GeoIpProcessor(
    public void testCityWithMissingLocation() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            false
            "source_field",
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            false,
 *
            randomAlphaOfLength(10),  
        assertThat(geoData.get(0).get("location"), equalTo(location));  
            InputStream databaseInputStream() throws IOException {
            loader("/GeoLite2-City.mmdb"),  
            false
 * ownership. Elasticsearch licenses this file to you under  
            loader("/GeoLite2-City.mmdb"),
            randomAlphaOfLength(10),  
            loader("/GeoLite2-City.mmdb"),  
 * You may obtain a copy of the License at  
            null,
            random(),
 * The OpenSearch Contributors require contributions made to  
        assertThat(geoData.get(1).get("city_name"), equalTo("Hoensbroek"));
            "source_field",
            false
import java.util.function.Supplier;  
 *  
            randomAlphaOfLength(10),  
            "target_field",  
            "target_field",
    public void testListAllValid() throws Exception {  
    }
            false,  
        processor.execute(ingestDocument);
        GeoIpProcessor processor = new GeoIpProcessor(
        };
        List<Map<String, Object>> geoData = (List<Map<String, Object>>) ingestDocument.getSourceAndMetadata().get("target_field");  
        );  
            false,
/*
        );
            false
            false
            null,
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");  
            null,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
            "target_field",  
        location.put("lat", 37.751d);
        location.put("lat", 37.751d);
            new GeoIpCache(1000),
            randomAlphaOfLength(10),  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        GeoIpProcessor processor = new GeoIpProcessor(
import static org.hamcrest.Matchers.equalTo;
            null,
            EnumSet.allOf(GeoIpProcessor.Property.class),
        processor.execute(ingestDocument);  
            null,
        assertThat(geoData.get("ip"), equalTo("8.8.8.8"));
        processor.execute(ingestDocument);
        assertThat(geoData.get(1), nullValue());
        Map<String, Object> location = new HashMap<>();  
        @SuppressWarnings("unchecked")  
                    do {
        document.put("source_field", ip);
            EnumSet.allOf(GeoIpProcessor.Property.class),
import java.util.Map;
import java.util.Collections;
            EnumSet.allOf(GeoIpProcessor.Property.class),
        GeoIpProcessor processor = new GeoIpProcessor(
            "source_field",
        return new DatabaseReaderLazyLoader(PathUtils.get(path), loader) {
        GeoIpProcessor processor = new GeoIpProcessor(
        final Supplier<InputStream> databaseInputStreamSupplier = () -> GeoIpProcessor.class.getResourceAsStream(path);
/*  
            randomAlphaOfLength(10),  
                        final byte[] bytes = new byte[1 << 10];  
            EnumSet.allOf(GeoIpProcessor.Property.class),  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    /** Don't silently do DNS lookups or anything trappy on bogus data */  
        assertThat(geoData.get("country_iso_code"), equalTo("NL"));
        Map<String, Object> document = new HashMap<>();
        assertThat(geoData.get("country_name"), equalTo("United States"));
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        processor.execute(ingestDocument);
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        GeoIpProcessor processor = new GeoIpProcessor(
    public void testAsn() throws Exception {
            Collections.singletonMap("source_field", null)  
        );  
            loader("/GeoLite2-City.mmdb"),  
import com.maxmind.geoip2.DatabaseReader;
            EnumSet.allOf(GeoIpProcessor.Property.class),
 *
        document.put("source_field", Arrays.asList("127.0.0.1", "127.0.0.1"));  
            "target_field",
        assertThat(geoData.get("region_name"), equalTo("Florida"));
            "source_field",
            loader("/GeoLite2-City.mmdb"),  
        document.put("source_field", "82.170.213.79");
        Map<String, Object> location = new HashMap<>();
        assertThat(geoData.get("location"), equalTo(location));
        location.put("lon", -97.822d);  
        assertThat(geoData.get("continent_name"), equalTo("North America"));
            false
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));  
        assertThat(geoData.get("ip"), equalTo(ip));
    public void testListNoMatches() throws Exception {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        assertThat(exception.getMessage(), equalTo("field [source_field] not present as part of path [source_field]"));
    public void testAddressIsNotInTheDatabase() throws Exception {
            "target_field",
            EnumSet.allOf(GeoIpProcessor.Property.class),
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.containsString;  
        assertThat(geoData.get(0).get("location"), equalTo(location));
            new GeoIpCache(1000),
        assertFalse(ingestDocument.hasField("target_field"));
            null,  
            "target_field",
        processor.execute(ingestDocument);
 */  
    }  
 * GitHub history for details.
            EnumSet.allOf(GeoIpProcessor.Property.class),
        document.put("source_field", Arrays.asList("8.8.8.8", "82.171.64.0"));
        assertThat(geoData.size(), equalTo(1));
        GeoIpProcessor processor = new GeoIpProcessor(
        assertThat(geoData.get("ip"), equalTo("82.170.213.79"));
        );  
            false
            randomAlphaOfLength(10),  
            "source_field",
}
        );  
        assertThat(geoData.size(), equalTo(6));
            new GeoIpCache(1000),
        document.put("source_field", "127.0.0.1");  
import org.opensearch.common.CheckedSupplier;  
            }  
            "source_field",
            loader("/GeoLite2-City.mmdb"),  
 * Modifications Copyright OpenSearch Contributors. See
        );  
            EnumSet.allOf(GeoIpProcessor.Property.class),
        processor.execute(ingestDocument);
            @Override  
            new GeoIpCache(1000),
            new GeoIpCache(1000),
        processor.execute(ingestDocument);  
        );
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document.put("source_field", Arrays.asList("127.0.0.1", "127.0.0.2"));  
            .build();
        assertThat(geoData.get("network"), equalTo("82.168.0.0/14"));
            false  
    }  
 * this work for additional information regarding copyright
            "source_field",  
        final CheckedSupplier<DatabaseReader, IOException> loader = () -> new DatabaseReader.Builder(databaseInputStreamSupplier.get())  
            null,
            randomAlphaOfLength(10),
            null,
    public void testCity_withIpV6() throws Exception {
            false,  
import org.opensearch.common.io.PathUtils;
            false,
            false,  
            randomAlphaOfLength(10),
        );  
        processor.execute(ingestDocument);
            randomAlphaOfLength(10),  
 * Unless required by applicable law or agreed to in writing,
            "target_field",
import java.util.EnumSet;
        location.put("lon", -97.822d);
        GeoIpProcessor processor = new GeoIpProcessor(
import java.io.IOException;
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
            false
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        assertIngestDocument(originalIngestDocument, ingestDocument);
        GeoIpProcessor processor = new GeoIpProcessor(
    public void testCity() throws Exception {
            "source_field",
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo(ip));  
                    return bytesRead;
    public void testCountry() throws Exception {  
        );
                }  
        document.put("source_field", address);
            new GeoIpCache(1000),  
        location.put("lat", 37.751d);  
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
        assertThat(geoData.get("country_iso_code"), equalTo("US"));  
            EnumSet.allOf(GeoIpProcessor.Property.class),
        Map<String, Object> document = new HashMap<>();  
        assertThat(geoData.get("location"), equalTo(location));
            new GeoIpCache(1000),
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("target_field"), is(false));
        Map<String, Object> document = new HashMap<>();
            true
        assertThat(geoData.get("continent_name"), equalTo("Europe"));
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
            "target_field",
import java.util.HashMap;  
        Map<String, Object> location = new HashMap<>();
            "target_field",
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(geoData.get("city_name"), equalTo("Homestead"));  
        GeoIpProcessor processor = new GeoIpProcessor(  
            false,
            new GeoIpCache(1000),
            null,
            "source_field",
        assertThat(geoData.get("ip"), equalTo(address));  
        @SuppressWarnings("unchecked")
                        final int read = is.read(bytes);
                        if (read == -1) break;
    }
        assertThat(geoData.get("location"), equalTo(location));
        @SuppressWarnings("unchecked")  
        Map<String, Object> location = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
        processor.execute(ingestDocument);  
        GeoIpProcessor processor = new GeoIpProcessor(
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("8.8.8.8"));
    private DatabaseReaderLazyLoader loader(final String path) {
            new GeoIpCache(1000),  
    }
            loader("/GeoLite2-City.mmdb"),  
        assertThat(geoData.size(), equalTo(9));
            "target_field",
            false
            loader("/GeoLite2-Country.mmdb"),  
            "source_field",
 * the Apache License, Version 2.0 (the "License"); you may
            "target_field",
        String ip = "82.171.64.0";  
 * license agreements. See the NOTICE file distributed with
            "source_field",
    }
        document.put("source_field", "80.231.5.0");
    }
            loader("/GeoLite2-Country.mmdb"),
            }
                    } while (true);
            randomAlphaOfLength(10),
        processor.execute(ingestDocument);
            null,
            false,  
            EnumSet.allOf(GeoIpProcessor.Property.class),
            long databaseFileSize() throws IOException {
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo(address));
 * software distributed under the License is distributed on an
    }
 * compatible open source license.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            null,
    public void testListFirstOnly() throws Exception {
            false
        assertThat(geoData.get("ip"), equalTo("80.231.5.0"));  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            "target_field",
 * under the License.  
        );
    public void testCountryWithMissingLocation() throws Exception {
        GeoIpProcessor processor = new GeoIpProcessor(
            "source_field",
import java.util.Arrays;  
            randomAlphaOfLength(10),  
import java.util.List;
    public void testNonExistentWithIgnoreMissing() throws Exception {
            @Override
    }
        processor.execute(ingestDocument);  
        assertThat(geoData.get("timezone"), equalTo("America/New_York"));
            "source_field",
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
 * not use this file except in compliance with the License.
            false
import static org.hamcrest.Matchers.is;
            false,  
                    long bytesRead = 0;
    public void testListPartiallyValid() throws Exception {
            false,  
        @SuppressWarnings("unchecked")
 */
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        processor.execute(ingestDocument);  
            null,
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));  
        @SuppressWarnings("unchecked")
            new GeoIpCache(1000),
            "source_field",  
    public void testListFirstOnlyNoMatches() throws Exception {
            "target_field",
    }  
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("target_field"), is(false));  
        GeoIpProcessor processor = new GeoIpProcessor(
            true,  
            "target_field",
        Map<String, Object> document = new HashMap<>();  
        location.put("lon", -97.822d);  
 * specific language governing permissions and limitations
    public void testNullWithoutIgnoreMissing() throws Exception {
        Exception e = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
 * Licensed to Elasticsearch under one or more contributor  
    }
            "target_field",  
            loader("/GeoLite2-ASN.mmdb"),
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
            randomAlphaOfLength(10),
    }
            EnumSet.allOf(GeoIpProcessor.Property.class),
            new GeoIpCache(1000),
            loader("/GeoLite2-City.mmdb"),
            loader("/GeoLite2-City.mmdb"),  
            "source_field",
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
        @SuppressWarnings("unchecked")
        GeoIpProcessor processor = new GeoIpProcessor(
 * this file be licensed under the Apache-2.0 license or a
public class GeoIpProcessorTests extends OpenSearchTestCase {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
            loader("/GeoLite2-City.mmdb"),  
        Map<String, Object> location = new HashMap<>();
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("82.170.213.79"));  
        GeoIpProcessor processor = new GeoIpProcessor(
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
    }
        assertThat(geoData.size(), equalTo(4));  
            false
    }
