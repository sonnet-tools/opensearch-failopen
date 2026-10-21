        assertThat(processor.getTargetField(), equalTo("geoip"));
        config = new HashMap<>();
    }
        }
 * this work for additional information regarding copyright
        // fake the GeoIP2-City database
        assertThat(processor.getField(), equalTo("_field"));
        assertThat(
        // Loading another database reader instances, because otherwise we can't test lazy loading as the
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        asn.execute(document);
import java.nio.file.Path;
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        String processorTag = randomAlphaOfLength(10);
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
    }
    public void testLazyLoading() throws Exception {
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
import org.opensearch.test.StreamsUtils;
        config.put("field", "_field");
        final IOException e = expectThrows(IOException.class, () -> IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir));
        }
    }
        config.put("field", "_field");
        assertThat(processor.getTargetField(), equalTo("geoip"));
        config.put("field", "_field");
        // database readers used at class level are reused between tests. (we want to keep that otherwise running this
        final Path configDir = createTempDir();
            )
        final GeoIpProcessor city = factory.create(null, "_tag", null, config);
        assertThat(e, hasToString(containsString("expected database [" + databaseFilename + "] to exist in [" + geoIpDir + "]")));
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_COUNTRY_PROPERTIES));
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        assertFalse(processor.isIgnoreMissing());
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-City"));
        assertFalse(processor.isIgnoreMissing());
         */
        assertThat(processor.getField(), equalTo("_field"));
        Set<GeoIpProcessor.Property> properties = EnumSet.noneOf(GeoIpProcessor.Property.class);
    }
import java.util.Set;
 * this file be licensed under the Apache-2.0 license or a
        // the first ingest should trigger a database load
    }
public class GeoIpProcessorFactoryTests extends OpenSearchTestCase {
        assertThat(processor.getField(), equalTo("_field"));
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_CITY_PROPERTIES));
        assertThat(processor.getTargetField(), equalTo("geoip"));
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
            fieldNames.add(property.name().toLowerCase(Locale.ROOT));
        assertNull(databaseReaders.get("GeoLite2-City.mmdb").databaseReader.get());
 * GitHub history for details.
    private static void copyDatabaseFiles(final Path path) throws IOException {
        assertThat(processor.getTargetField(), equalTo("geoip"));
        final Path geoIpDir = createTempDir();
/*
        final Map<String, Object> field = Collections.singletonMap("_field", "1.1.1.1");
        assertThat(processor.getTag(), equalTo(processorTag));
        city.execute(document);
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
    }
            e.getMessage(),
        config1.put("properties", Collections.singletonList("invalid"));
    }
        config.put("field", "_field");
        assertNotNull(databaseReaders.get("GeoIP2-City.mmdb").databaseReader.get());
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
        Map<String, Object> config1 = new HashMap<>();
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config1));
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
        copyDatabaseFiles(geoIpDir);
        final Map<String, DatabaseReaderLazyLoader> databaseReaders = IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir);
            }
        Files.createDirectories(geoIpConfigDir);
        final GeoIpProcessor country = factory.create(null, "_tag", null, config);
 */
        final Path geoIpDir = createTempDir();
            e.getMessage(),
        assertNotNull(databaseReaders.get("GeoLite2-Country.mmdb").databaseReader.get());
        // the first ingest should trigger a database load
import java.util.HashMap;
        assertThat(processor.getField(), equalTo("_field"));
        int counter = 0;
        assertThat(processor.getProperties(), equalTo(properties));
    public void testBuildWithAsnDbAndCityFields() throws Exception {
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-Country"));
 * You may obtain a copy of the License at
            equalTo(
    public void testBuildTargetField() throws Exception {
 * not use this file except in compliance with the License.
        assertThat(
        EnumSet<GeoIpProcessor.Property> asnOnlyProperties = EnumSet.copyOf(GeoIpProcessor.Property.ALL_ASN_PROPERTIES);
        for (DatabaseReaderLazyLoader reader : databaseReaders.values()) {
        config.put("database_file", "GeoLite2-Country.mmdb");
        GeoIpProcessor processor = factory.create(null, null, null, config);
 *
        Files.delete(geoIpDir.resolve(databaseFilename));
        final Path geoIpDir = createTempDir();
        copyDatabaseFiles(geoIpDir);
        String asnProperty = RandomPicks.randomFrom(Randomness.get(), asnOnlyProperties).toString();
        assertNotNull(databaseReaders.get("GeoLite2-ASN.mmdb").databaseReader.get());
        final Path configDir = createTempDir();
        assertThat(processor.getTag(), equalTo(processorTag));
        EnumSet<GeoIpProcessor.Property> cityOnlyProperties = EnumSet.copyOf(GeoIpProcessor.Property.ALL_CITY_PROPERTIES);
        }
        assertFalse(processor.isIgnoreMissing());
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
            equalTo(
        country.execute(document);
        // the first ingest should trigger a database load
        config.put("field", "_field");
    public void testSetIgnoreMissing() throws Exception {
    public void testBuildFields() throws Exception {
        // these are lazy loaded until first use so we expect null here
        config.put("field", "_field");
        Map<String, Object> config = new HashMap<>();
        assertNotNull(databaseReaders.get("GeoLite2-City.mmdb").databaseReader.get());
        copyDatabaseFile(geoIpConfigDir, databaseFilename);
        );
        config = new HashMap<>();
import static org.hamcrest.Matchers.hasToString;
        copyDatabaseFiles(geoIpDir);
        for (final String databaseFilename : IngestGeoIpModulePlugin.DEFAULT_DATABASE_FILENAMES) {
        config.put("field", "_field");
        );
    }
            copyDatabaseFile(path, databaseFilename);
        // these are lazy loaded until first use so we expect null here
        Map<String, Object> config = new HashMap<>();
        config2.put("properties", "invalid");
        config.put("properties", fieldNames);
        Map<String, Object> config2 = new HashMap<>();
import java.util.List;
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_CITY_PROPERTIES));
    }
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-ASN"));
    @BeforeClass
        Files.createDirectories(geoIpConfigDir);
        assertThat(e, hasToString(containsString("expected database [" + databaseFilename + "] to not exist in [" + geoIpConfigDir + "]")));
         * Loading another database reader instances, because otherwise we can't test lazy loading as the database readers used at class
        final IngestDocument document = new IngestDocument("index", "id", "routing", 1L, VersionType.EXTERNAL, field);
 * KIND, either express or implied.  See the License for the
        assertFalse(processor.isIgnoreMissing());
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        // the first ingest should trigger a database load
        String processorTag = randomAlphaOfLength(10);
         * level are reused between tests. (we want to keep that otherwise running this test will take roughly 4 times more time).
        final GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
    public void testLoadingCustomDatabase() throws IOException {
    }
    public static void loadDatabaseReaders() throws IOException {
        GeoIpProcessor processor = factory.create(null, null, null, config);
        final Path geoIpDir = createTempDir();
        final Path configDir = createTempDir();
        copyDatabaseFile(geoIpConfigDir, "GeoLite2-City.mmdb");
        Map<String, Object> config = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
        copyDatabaseFiles(geoIpDir);
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
/*
        String processorTag = randomAlphaOfLength(10);
                    + "COUNTRY_NAME, CONTINENT_NAME, REGION_ISO_CODE, REGION_NAME, CITY_NAME, TIMEZONE, LOCATION]"
        Map<String, DatabaseReaderLazyLoader> databaseReaders = IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir);
        config.put("field", "_field");
        assertThat(processor.getField(), equalTo("_field"));
    }
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_ASN_PROPERTIES));
        final IngestDocument document = new IngestDocument("index", "id", "routing", 1L, VersionType.EXTERNAL, field);
import java.io.ByteArrayInputStream;
                "[properties] illegal property value [invalid]. valid values are [IP, COUNTRY_ISO_CODE, "
        assertThat(processor.getTargetField(), equalTo("geoip"));
    }
        config.put("database_file", "GeoLite2-City.mmdb");
        config.put("database_file", "GeoIP2-City.mmdb");
    public void testCountryBuildDefaults() throws Exception {
        config.put("field", "_field");
        Map<String, Object> config = new HashMap<>();
import org.junit.AfterClass;
import java.util.Locale;
    public void testBuildDbFile() throws Exception {
                    + asnProperty
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        }
import static org.hamcrest.Matchers.equalTo;
        assertThat(processor.getTag(), equalTo(processorTag));
            assertNull(lazyLoader.databaseReader.get());
        Map<String, Object> config = new HashMap<>();
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        config2.put("field", "_field");
        // test will take roughly 4 times more time)
        assertNull(databaseReaders.get("GeoLite2-Country.mmdb").databaseReader.get());
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        }
        final GeoIpProcessor city = factory.create(null, "_tag", null, config);
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
    }
        assertThat(e.getMessage(), equalTo("[properties] property isn't a list, but of type [java.lang.String]"));
            )
            reader.close();
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-City"));
import org.opensearch.index.VersionType;
 *
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
 * ownership. Elasticsearch licenses this file to you under
 *
        final Map<String, Object> field = Collections.singletonMap("_field", "1.1.1.1");
        for (GeoIpProcessor.Property property : GeoIpProcessor.Property.ALL_CITY_PROPERTIES) {
                    + "]. valid values are [IP, COUNTRY_ISO_CODE, COUNTRY_NAME, CONTINENT_NAME]"
 * license agreements. See the NOTICE file distributed with
        databaseReaders = IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir);
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
    public void testDatabaseExistsInConfigDir() throws IOException {
        );
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
import java.util.Collections;
        final Path configDir = createTempDir();
        config.put("ignore_missing", true);
    public static void closeDatabaseReaders() throws IOException {
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> config = new HashMap<>();
            assertNull(lazyLoader.databaseReader.get());
        assertThat(processor.getField(), equalTo("_field"));
    }
    @AfterClass
        Map<String, Object> config = new HashMap<>();
import java.util.ArrayList;
import static org.hamcrest.Matchers.sameInstance;
    }
 */
import java.nio.file.Files;
        Map<String, Object> config = new HashMap<>();
        }
        config.put("target_field", "_field");
        final Path geoIpDir = createTempDir();
        Map<String, Object> config = new HashMap<>();
        for (DatabaseReaderLazyLoader lazyLoader : databaseReaders.values()) {
        final GeoIpProcessor asn = factory.create(null, "_tag", null, config);
        final Path configDir = createTempDir();
        Map<String, Object> config = new HashMap<>();
        assertFalse(processor.isIgnoreMissing());
        // these are lazy loaded until first use so we expect null here
    private static void copyDatabaseFile(final Path path, final String databaseFilename) throws IOException {
}
                "[properties] illegal property value ["
        final String databaseFilename = randomFrom(IngestGeoIpModulePlugin.DEFAULT_DATABASE_FILENAMES);
        assertThat(
        int numFields = scaledRandomIntBetween(1, GeoIpProcessor.Property.values().length);
import org.opensearch.OpenSearchParseException;
        asnOnlyProperties.remove(GeoIpProcessor.Property.IP);
        config.put("field", "_field");
import org.opensearch.test.OpenSearchTestCase;
        config.put("field", "_field");
import org.opensearch.common.Randomness;
        city.execute(document);
            e.getMessage(),
    }
        Files.createDirectories(geoIpConfigDir);
import static org.hamcrest.Matchers.containsString;
        assertThat(e.getMessage(), equalTo("[database_file] database file [does-not-exist.mmdb] doesn't exist"));
 * software distributed under the License is distributed on an
        String processorTag = randomAlphaOfLength(10);
        databaseReaders = null;
        cityOnlyProperties.remove(GeoIpProcessor.Property.IP);
 */
        Files.move(geoIpConfigDir.resolve("GeoLite2-City.mmdb"), geoIpConfigDir.resolve("GeoIP2-City.mmdb"));
        GeoIpProcessor processor = factory.create(null, null, null, config);
    public void testBuildIllegalFieldOption() throws Exception {
        assertThat(processor.getTargetField(), equalTo("_field"));
        // these are lazy loaded until first use so we expect null here
        config.put("field", "_field");
 * under the License.
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        config.put("database_file", "does-not-exist.mmdb");
        Map<String, Object> config = new HashMap<>();
            properties.add(property);
 * compatible open source license.
    public void testBuildNonExistingDbFile() throws Exception {
        config.put("database_file", "GeoLite2-ASN.mmdb");
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-Country"));
    public void testBuildWithCountryDbAndAsnFields() throws Exception {
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        Files.copy(new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/" + databaseFilename)), path.resolve(databaseFilename));
    }
        final IOException e = expectThrows(IOException.class, () -> IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir));
        config.put("properties", Collections.singletonList(cityProperty));
            if (++counter >= numFields) {
        config.put("database_file", "GeoLite2-ASN.mmdb");
        config.put("field", "_field");
        copyDatabaseFiles(geoIpDir);
        config.put("database_file", "GeoLite2-Country.mmdb");
        assertNull(databaseReaders.get("GeoLite2-ASN.mmdb").databaseReader.get());
        assertTrue(processor.isIgnoreMissing());
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(processor.isIgnoreMissing());
import java.io.IOException;
        String cityProperty = RandomPicks.randomFrom(Randomness.get(), cityOnlyProperties).toString();
        config.put("properties", Collections.singletonList(asnProperty));
                break;
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
import java.util.EnumSet;
        List<String> fieldNames = new ArrayList<>();
        config1.put("field", "_field");
        config.put("database_file", "GeoLite2-Country.mmdb");
        if (randomBoolean()) {
        assertThat(processor.getField(), equalTo("_field"));
    }
            Files.createDirectories(geoIpConfigDir);
        config.put("database_file", "GeoLite2-Country.mmdb");
            equalTo("[properties] illegal property value [" + cityProperty + "]. valid values are [IP, ASN, ORGANIZATION_NAME, NETWORK]")
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_COUNTRY_PROPERTIES));
import org.junit.BeforeClass;
    public void testDatabaseNotExistsInDir() throws IOException {
import org.opensearch.ingest.IngestDocument;
    public void testBuildDefaults() throws Exception {
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config2));
import java.util.Map;
/*
        assertThat(processor.getTag(), equalTo(processorTag));
        final String databaseFilename = randomFrom(IngestGeoIpModulePlugin.DEFAULT_DATABASE_FILENAMES);
        for (DatabaseReaderLazyLoader lazyLoader : databaseReaders.values()) {
    public void testAsnBuildDefaults() throws Exception {
        config.put("database_file", "GeoLite2-ASN.mmdb");
        Map<String, Object> config = new HashMap<>();
        Files.createDirectories(geoIpConfigDir);
    private static Map<String, DatabaseReaderLazyLoader> databaseReaders;
        /*
        config.put("field", "_field");
    }
package org.opensearch.ingest.geoip;
        assertNull(databaseReaders.get("GeoIP2-City.mmdb").databaseReader.get());
 * Licensed to Elasticsearch under one or more contributor
