            loader("/GeoLite2-City.mmdb"),
            null,
        assertThat(geoData.get("country_name"), equalTo("Netherlands"));
        Map<String, Object> location = new HashMap<>();
    public void testAsn() throws Exception {
                    } while (true);
            null,
        document.put("source_field", "80.231.5.0");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        processor.execute(ingestDocument);
            loader("/GeoLite2-Country.mmdb"),
            "target_field",
            "target_field",
    public void testListFirstOnly() throws Exception {
        GeoIpProcessor processor = new GeoIpProcessor(
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            "target_field",
        GeoIpProcessor processor = new GeoIpProcessor(
        processor.execute(ingestDocument);
            EnumSet.allOf(GeoIpProcessor.Property.class),
            "target_field",
        GeoIpProcessor processor = new GeoIpProcessor(
    public void testCountryWithMissingLocation() throws Exception {
        List<Map<String, Object>> geoData = (List<Map<String, Object>>) ingestDocument.getSourceAndMetadata().get("target_field");
    }
import java.io.InputStream;
            null,
            loader("/GeoLite2-City.mmdb"),
            "target_field",
                        final int read = is.read(bytes);
        processor.execute(ingestDocument);
            "source_field",
            loader("/GeoLite2-City.mmdb"),
            @Override
    }
            loader("/GeoLite2-City.mmdb"),
        Map<String, Object> document = new HashMap<>();
            null,
            new GeoIpCache(1000),
    }
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("82.170.213.79"));
        );
            false,
 * license agreements. See the NOTICE file distributed with
    public void testNullValueWithIgnoreMissing() throws Exception {
    public void testCityWithMissingLocation() throws Exception {
            false,
    public void testListFirstOnlyNoMatches() throws Exception {
        location.put("lat", 37.751d);
import java.util.HashMap;
        );
            random(),
            false,
        Map<String, Object> document = new HashMap<>();
        assertThat(geoData.size(), equalTo(1));
            false,
/*
            randomAlphaOfLength(10),
        assertThat(geoData.get(1).get("city_name"), equalTo("Hoensbroek"));
import org.opensearch.common.io.PathUtils;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            loader("/GeoLite2-City.mmdb"),
 */
            randomAlphaOfLength(10),
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
    public void testNonExistentWithIgnoreMissing() throws Exception {
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
    public void testListAllValid() throws Exception {
        assertThat(geoData.get("country_name"), equalTo("United States"));
 * Unless required by applicable law or agreed to in writing,
            randomAlphaOfLength(10),
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        assertThat(geoData.get("network"), equalTo("82.168.0.0/14"));
import java.util.Collections;
            new GeoIpCache(1000),
    public void testCity_withIpV6() throws Exception {
            false
            false
        assertFalse(ingestDocument.hasField("target_field"));
            randomAlphaOfLength(10),
            loader("/GeoLite2-City.mmdb"),
            @Override
            EnumSet.allOf(GeoIpProcessor.Property.class),
            false
            EnumSet.allOf(GeoIpProcessor.Property.class),
            new GeoIpCache(1000),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            "target_field",
        assertThat(geoData.size(), equalTo(9));
            long databaseFileSize() throws IOException {
        assertThat(geoData.get("location"), equalTo(location));
                        final byte[] bytes = new byte[1 << 10];
        assertThat(geoData.get("country_iso_code"), equalTo("NL"));
            false
            "target_field",
            new GeoIpCache(1000),
            null,
        Map<String, Object> document = new HashMap<>();
        document.put("source_field", "80.231.5.0");
 * the Apache License, Version 2.0 (the "License"); you may
        location.put("lat", 37.751d);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(geoData.size(), equalTo(4));
        );
        );
            new GeoIpCache(1000),
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
/*
 */
        GeoIpProcessor processor = new GeoIpProcessor(
            false
        Map<String, Object> document = new HashMap<>();
        GeoIpProcessor processor = new GeoIpProcessor(
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
        location.put("lat", 37.751d);
            randomAlphaOfLength(10),
        );
        processor.execute(ingestDocument);
        final Supplier<InputStream> databaseInputStreamSupplier = () -> GeoIpProcessor.class.getResourceAsStream(path);
        Map<String, Object> document = new HashMap<>();
        assertThat(geoData.get("continent_name"), equalTo("North America"));
            EnumSet.allOf(GeoIpProcessor.Property.class),
    public void testAddressIsNotInTheDatabase() throws Exception {
            "source_field",
            "source_field",
            InputStream databaseInputStream() throws IOException {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            randomAlphaOfLength(10),
        location.put("lat", 37.751d);
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        assertThat(geoData.get("timezone"), equalTo("America/New_York"));
            false,
            null,
    /** Don't silently do DNS lookups or anything trappy on bogus data */
import static org.hamcrest.Matchers.is;
 * specific language governing permissions and limitations
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
            false
    public void testListNoMatches() throws Exception {
        assertThat(geoData.get("ip"), equalTo("8.8.8.8"));
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            "source_field",
        document.put("source_field", "82.170.213.79");
            true,
            EnumSet.allOf(GeoIpProcessor.Property.class),
        @SuppressWarnings("unchecked")
    }
            false
 * KIND, either express or implied.  See the License for the
            false,
        GeoIpProcessor processor = new GeoIpProcessor(
            loader("/GeoLite2-City.mmdb"),
            "source_field",
import java.util.Arrays;
            false
            "source_field",
 * The OpenSearch Contributors require contributions made to
            null,
            EnumSet.allOf(GeoIpProcessor.Property.class),
        assertIngestDocument(originalIngestDocument, ingestDocument);
            false,
        assertThat(geoData.get(0).get("location"), equalTo(location));
        Exception e = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("target_field"), is(false));
            false
            "target_field",
        assertThat(geoData.size(), equalTo(1));
        GeoIpProcessor processor = new GeoIpProcessor(
public class GeoIpProcessorTests extends OpenSearchTestCase {
            Collections.singletonMap("source_field", null)
        );
 * Modifications Copyright OpenSearch Contributors. See
    }
            new GeoIpCache(1000),
        assertThat(geoData.get("country_iso_code"), equalTo("US"));
            "source_field",
    }
            true
        assertThat(geoData.get("ip"), equalTo(address));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(geoData.get("ip"), equalTo("80.231.5.0"));
        assertThat(geoData.get("region_iso_code"), equalTo("US-FL"));
        document.put("source_field", ip);
        document.put("source_field", address);
            "target_field",
        document.put("source_field", Arrays.asList("127.0.0.1", "127.0.0.2"));
                    do {
            false
        processor.execute(ingestDocument);
    }
            randomAlphaOfLength(10),
        );
        GeoIpProcessor processor = new GeoIpProcessor(
            false,
import org.opensearch.test.OpenSearchTestCase;
        Map<String, Object> location = new HashMap<>();
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("80.231.5.0"));
            false
        );
    public void testCity() throws Exception {
            false
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(geoData.get("ip"), equalTo("82.170.213.79"));
            new GeoIpCache(1000),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        assertThat(geoData.get("city_name"), equalTo("Homestead"));
        );
        @SuppressWarnings("unchecked")
            null,
            randomAlphaOfLength(10),
        processor.execute(ingestDocument);
            loader("/GeoLite2-City.mmdb"),
        assertIngestDocument(originalIngestDocument, ingestDocument);
 * compatible open source license.
        assertThat(geoData.get("region_name"), equalTo("Florida"));
            "target_field",
                        bytesRead += read;
            loader("/GeoLite2-City.mmdb"),
import static org.hamcrest.Matchers.nullValue;
            "source_field",
    public void testCountry() throws Exception {
            EnumSet.allOf(GeoIpProcessor.Property.class),
 * You may obtain a copy of the License at
            new GeoIpCache(1000),
        @SuppressWarnings("unchecked")
            "target_field",
 * SPDX-License-Identifier: Apache-2.0
            new GeoIpCache(1000),
            null,
        location.put("lon", -97.822d);
            randomAlphaOfLength(10),
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            "source_field",
            EnumSet.allOf(GeoIpProcessor.Property.class),
            EnumSet.allOf(GeoIpProcessor.Property.class),
        GeoIpProcessor processor = new GeoIpProcessor(
            new GeoIpCache(1000),
import com.maxmind.geoip2.DatabaseReader;
        );
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
            new GeoIpCache(1000),
        GeoIpProcessor processor = new GeoIpProcessor(
import org.opensearch.common.CheckedSupplier;
        Map<String, Object> location = new HashMap<>();
        );
            false,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        processor.execute(ingestDocument);
    }
        Map<String, Object> document = new HashMap<>();
        document.put("source_field", Arrays.asList("8.8.8.8", "82.171.64.0"));
        );
import java.util.List;
            false,
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        List<Map<String, Object>> geoData = (List<Map<String, Object>>) ingestDocument.getSourceAndMetadata().get("target_field");
            loader("/GeoLite2-Country.mmdb"),
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(ingestDocument.getSourceAndMetadata().containsKey("target_field"), is(false));
                try (InputStream is = databaseInputStreamSupplier.get()) {
            false
        document.put("source_field", Arrays.asList("127.0.0.1", "127.0.0.1"));
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        assertThat(geoData.get("timezone"), equalTo("America/Chicago"));
}
    private DatabaseReaderLazyLoader loader(final String path) {
/*
        GeoIpProcessor processor = new GeoIpProcessor(
            loader("/GeoLite2-City.mmdb"),
            randomAlphaOfLength(10),
        @SuppressWarnings("unchecked")
            randomAlphaOfLength(10),
            false,
            "target_field",
            null,
        Map<String, Object> document = new HashMap<>();
            loader("/GeoLite2-City.mmdb"),
        );
import java.util.EnumSet;
        document.put("source_field", Arrays.asList("8.8.8.8", "127.0.0.1"));
 *
            "source_field",
        assertThat(exception.getMessage(), equalTo("field [source_field] is null, cannot extract geoip information."));
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        assertThat(geoData.get("ip"), equalTo("80.231.5.0"));
            null,
        GeoIpProcessor processor = new GeoIpProcessor(
        );
            false
        location.put("lon", -97.822d);
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("8.8.8.8"));
        location.put("lat", 25.4573d);
            random(),
        processor.execute(ingestDocument);
            EnumSet.allOf(GeoIpProcessor.Property.class),
            loader("/GeoLite2-ASN.mmdb"),
        Map<String, Object> location = new HashMap<>();
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo("80.231.5.0"));
            "source_field",
        assertThat(geoData.size(), equalTo(4));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        );
        processor.execute(ingestDocument);
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        location.put("lon", -97.822d);
        processor.execute(ingestDocument);
            "source_field",
            "target_field",
package org.opensearch.ingest.geoip;
        assertThat(geoData.get("country_iso_code"), equalTo("US"));
                        if (read == -1) break;
            false,
        assertThat(geoData.get("asn"), equalTo(1136L));
            .build();
 * Licensed to Elasticsearch under one or more contributor
                }
        @SuppressWarnings("unchecked")
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
            true,
import java.io.IOException;
        Map<String, Object> location = new HashMap<>();
        assertThat(geoData.get("location"), equalTo(location));
        location.put("lon", -97.822d);
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo(ip));
        GeoIpProcessor processor = new GeoIpProcessor(
 * GitHub history for details.
            new GeoIpCache(1000),
            EnumSet.allOf(GeoIpProcessor.Property.class),
        assertThat(geoData.get("continent_name"), equalTo("Europe"));
        String address = "2602:306:33d3:8000::3257:9652";
    public void testNullWithoutIgnoreMissing() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        assertThat(geoData.get("organization_name"), equalTo("KPN B.V."));
            loader("/GeoLite2-City.mmdb"),
        assertThat(geoData.get(1), nullValue());
        Map<String, Object> document = new HashMap<>();
    }
        );
        Map<String, Object> document = new HashMap<>();
        return new DatabaseReaderLazyLoader(PathUtils.get(path), loader) {
        document.put("source_field", "8.8.8.8");
            EnumSet.allOf(GeoIpProcessor.Property.class),
        processor.execute(ingestDocument);
    }
    }
            "target_field",
            randomAlphaOfLength(10),
            EnumSet.allOf(GeoIpProcessor.Property.class),
        );
    }
        assertThat(e.getMessage(), containsString("not an IP string literal"));
            "source_field",
    }
        );
            loader("/GeoLite2-City.mmdb"),
        };
            "target_field",
            false
 * not use this file except in compliance with the License.
    }
            }
    }
            "target_field",
            randomAlphaOfLength(10),
        document.put("source_field", "127.0.0.1");
        processor.execute(ingestDocument);
            true
            EnumSet.allOf(GeoIpProcessor.Property.class),
    public void testInvalid() throws Exception {
        processor.execute(ingestDocument);
        assertThat(geoData.get("country_name"), equalTo("United States"));
 *
        assertThat(geoData.get("location"), equalTo(location));
            null,
        @SuppressWarnings("unchecked")
            new GeoIpCache(1000),
            "source_field",
            null,
 * software distributed under the License is distributed on an
            new GeoIpCache(1000),
            randomAlphaOfLength(10),
        );
    }
            EnumSet.allOf(GeoIpProcessor.Property.class),
            randomAlphaOfLength(10),
            false,
            false,
        String ip = "82.171.64.0";
            null,
            EnumSet.allOf(GeoIpProcessor.Property.class),
            false,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
import static org.hamcrest.Matchers.containsString;
    public void testListPartiallyValid() throws Exception {
        processor.execute(ingestDocument);
            loader("/GeoLite2-City.mmdb"),
import org.opensearch.ingest.IngestDocument;
            "source_field",
            "source_field",
 *
        assertThat(geoData.get("continent_name"), equalTo("North America"));
        location.put("lon", -80.4572d);
        assertThat(geoData.get("ip"), equalTo(ip));
        @SuppressWarnings("unchecked")
        document.put("source_field", Arrays.asList("8.8.8.8", "127.0.0.1"));
            null,
        Map<String, Object> document = new HashMap<>();
            new GeoIpCache(1000),
        final CheckedSupplier<DatabaseReader, IOException> loader = () -> new DatabaseReader.Builder(databaseInputStreamSupplier.get())
                    long bytesRead = 0;
        GeoIpProcessor processor = new GeoIpProcessor(
                    return bytesRead;
import org.opensearch.ingest.RandomDocumentPicks;
import java.util.Map;
            randomAlphaOfLength(10),
        GeoIpProcessor processor = new GeoIpProcessor(
            Collections.singletonMap("source_field", null)
        Map<String, Object> document = new HashMap<>();
        GeoIpProcessor processor = new GeoIpProcessor(
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
        @SuppressWarnings("unchecked")
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
import java.util.function.Supplier;
        assertThat(geoData.size(), equalTo(6));
        Map<String, Object> geoData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
            null,
            new GeoIpCache(1000),
            randomAlphaOfLength(10),
            null,
                return databaseInputStreamSupplier.get();
            new GeoIpCache(1000),
 * this work for additional information regarding copyright
        assertThat(geoData.get(0).get("location"), equalTo(location));
 * ownership. Elasticsearch licenses this file to you under
        Map<String, Object> document = new HashMap<>();
 */
            "source_field",
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        assertThat(exception.getMessage(), equalTo("field [source_field] not present as part of path [source_field]"));
            EnumSet.allOf(GeoIpProcessor.Property.class),
            "target_field",
        document.put("source_field", "www.google.com");
    public void testNonExistentWithoutIgnoreMissing() throws Exception {
        assertThat(ingestDocument.getSourceAndMetadata().get("source_field"), equalTo(address));
        @SuppressWarnings("unchecked")
        Map<String, Object> document = new HashMap<>();
        GeoIpProcessor processor = new GeoIpProcessor(
    }
