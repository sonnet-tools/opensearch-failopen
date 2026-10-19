        config1.put("field", "_field");
        /*
        config.put("field", "_field");  
            fieldNames.add(property.name().toLowerCase(Locale.ROOT));
            )
        assertThat(processor.getTargetField(), equalTo("geoip"));  
        assertThat(processor.getTag(), equalTo(processorTag));
                "[properties] illegal property value [invalid]. valid values are [IP, COUNTRY_ISO_CODE, "
        for (final String databaseFilename : IngestGeoIpModulePlugin.DEFAULT_DATABASE_FILENAMES) {
        Files.createDirectories(geoIpConfigDir);
 * software distributed under the License is distributed on an
        String processorTag = randomAlphaOfLength(10);  
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
        );  
        final Map<String, DatabaseReaderLazyLoader> databaseReaders = IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir);  
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        // database readers used at class level are reused between tests. (we want to keep that otherwise running this
            )
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
         */
    public void testBuildDefaults() throws Exception {  
        config.put("field", "_field");  
        final IngestDocument document = new IngestDocument("index", "id", "routing", 1L, VersionType.EXTERNAL, field);
    }
        Files.copy(new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/" + databaseFilename)), path.resolve(databaseFilename));  
import java.util.Collections;  
    }
    public void testBuildIllegalFieldOption() throws Exception {
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-Country"));
import java.util.List;  
 * KIND, either express or implied.  See the License for the
                    + asnProperty
        Map<String, Object> config = new HashMap<>();
        assertNotNull(databaseReaders.get("GeoLite2-ASN.mmdb").databaseReader.get());
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path configDir = createTempDir();
        String processorTag = randomAlphaOfLength(10);
        final GeoIpProcessor city = factory.create(null, "_tag", null, config);  
        EnumSet<GeoIpProcessor.Property> asnOnlyProperties = EnumSet.copyOf(GeoIpProcessor.Property.ALL_ASN_PROPERTIES);
import static org.hamcrest.Matchers.hasToString;
 */  
/*
        config2.put("properties", "invalid");  
        copyDatabaseFile(geoIpConfigDir, "GeoLite2-City.mmdb");
        assertThat(processor.getTargetField(), equalTo("geoip"));
        config.put("database_file", "GeoLite2-City.mmdb");
        assertNotNull(databaseReaders.get("GeoIP2-City.mmdb").databaseReader.get());  
                "[properties] illegal property value ["
        final IOException e = expectThrows(IOException.class, () -> IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir));
        assertThat(processor.getTargetField(), equalTo("_field"));
        config = new HashMap<>();
        config.put("field", "_field");
        assertThat(processor.getTargetField(), equalTo("geoip"));  
        final Path configDir = createTempDir();  
        // these are lazy loaded until first use so we expect null here  
        // fake the GeoIP2-City database
                    + "]. valid values are [IP, COUNTRY_ISO_CODE, COUNTRY_NAME, CONTINENT_NAME]"  
            e.getMessage(),
        assertNull(databaseReaders.get("GeoLite2-Country.mmdb").databaseReader.get());
        assertThat(
        final Path geoIpDir = createTempDir();
 * ownership. Elasticsearch licenses this file to you under  
            Files.createDirectories(geoIpConfigDir);
        assertThat(
        }  
         * level are reused between tests. (we want to keep that otherwise running this test will take roughly 4 times more time).
import java.nio.file.Files;  
        final Path geoIpDir = createTempDir();  
        for (DatabaseReaderLazyLoader lazyLoader : databaseReaders.values()) {
        copyDatabaseFile(geoIpConfigDir, databaseFilename);  
        assertThat(processor.getField(), equalTo("_field"));
/*  
        List<String> fieldNames = new ArrayList<>();
        assertNull(databaseReaders.get("GeoLite2-City.mmdb").databaseReader.get());  
    public void testBuildTargetField() throws Exception {  
        config.put("field", "_field");
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");  
        config.put("database_file", "GeoLite2-ASN.mmdb");  
        databaseReaders = null;  
        asn.execute(document);
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.equalTo;  
import java.util.ArrayList;
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        final Path configDir = createTempDir();
        assertThat(processor.getTag(), equalTo(processorTag));
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-City"));
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getField(), equalTo("_field"));
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_CITY_PROPERTIES));  
        config.put("field", "_field");
        // Loading another database reader instances, because otherwise we can't test lazy loading as the  
        int counter = 0;
 *
        copyDatabaseFiles(geoIpDir);
        config.put("field", "_field");
        final Path configDir = createTempDir();
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        );
        config.put("properties", Collections.singletonList(asnProperty));
    public void testCountryBuildDefaults() throws Exception {  
        config2.put("field", "_field");
import org.junit.AfterClass;
        String asnProperty = RandomPicks.randomFrom(Randomness.get(), asnOnlyProperties).toString();
 * this file be licensed under the Apache-2.0 license or a
        Files.createDirectories(geoIpConfigDir);
import org.opensearch.OpenSearchParseException;  
        final Path configDir = createTempDir();
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        assertFalse(processor.isIgnoreMissing());  
        GeoIpProcessor processor = factory.create(null, null, null, config);
        assertThat(processor.getField(), equalTo("_field"));  
    public void testDatabaseNotExistsInDir() throws IOException {  
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_COUNTRY_PROPERTIES));
            copyDatabaseFile(path, databaseFilename);
        final Path geoIpDir = createTempDir();
    }
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_CITY_PROPERTIES));
        config.put("field", "_field");
        Map<String, Object> config = new HashMap<>();
        }
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
    public void testBuildFields() throws Exception {
    public static void loadDatabaseReaders() throws IOException {  
    public void testBuildNonExistingDbFile() throws Exception {  
            e.getMessage(),
        assertThat(e, hasToString(containsString("expected database [" + databaseFilename + "] to not exist in [" + geoIpConfigDir + "]")));
        copyDatabaseFiles(geoIpDir);  
        Set<GeoIpProcessor.Property> properties = EnumSet.noneOf(GeoIpProcessor.Property.class);
        // the first ingest should trigger a database load  
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));  
        config.put("field", "_field");
        config = new HashMap<>();
    }
        GeoIpProcessor processor = factory.create(null, null, null, config);
import java.util.EnumSet;
        final GeoIpProcessor city = factory.create(null, "_tag", null, config);  
        // test will take roughly 4 times more time)
import org.opensearch.test.OpenSearchTestCase;
        if (randomBoolean()) {
        config.put("database_file", "GeoLite2-ASN.mmdb");
        }
            equalTo(
    }
        databaseReaders = IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir);
        // these are lazy loaded until first use so we expect null here
import java.nio.file.Path;
        config1.put("properties", Collections.singletonList("invalid"));  
        config.put("database_file", "GeoLite2-Country.mmdb");  
 * this work for additional information regarding copyright
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");
        Map<String, Object> config = new HashMap<>();  
    private static void copyDatabaseFile(final Path path, final String databaseFilename) throws IOException {
        Files.delete(geoIpDir.resolve(databaseFilename));  
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));  
        assertFalse(processor.isIgnoreMissing());  
            reader.close();
            assertNull(lazyLoader.databaseReader.get());  
    public void testSetIgnoreMissing() throws Exception {
        config.put("database_file", "does-not-exist.mmdb");
    }
        assertThat(  
    }  
import static org.hamcrest.Matchers.sameInstance;
        assertFalse(processor.isIgnoreMissing());  
        Files.move(geoIpConfigDir.resolve("GeoLite2-City.mmdb"), geoIpConfigDir.resolve("GeoIP2-City.mmdb"));  
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getField(), equalTo("_field"));  
        city.execute(document);
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        EnumSet<GeoIpProcessor.Property> cityOnlyProperties = EnumSet.copyOf(GeoIpProcessor.Property.ALL_CITY_PROPERTIES);
        copyDatabaseFiles(geoIpDir);
    @AfterClass
    public void testLoadingCustomDatabase() throws IOException {
        Map<String, Object> config = new HashMap<>();
    }  
    public void testBuildWithCountryDbAndAsnFields() throws Exception {  
        Map<String, DatabaseReaderLazyLoader> databaseReaders = IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir);  
        assertThat(processor.getField(), equalTo("_field"));
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        final Path geoIpDir = createTempDir();  
        assertFalse(processor.isIgnoreMissing());
        // the first ingest should trigger a database load
        assertThat(processor.getProperties(), equalTo(properties));  
        config.put("field", "_field");
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import org.junit.BeforeClass;
    public void testDatabaseExistsInConfigDir() throws IOException {
        config.put("field", "_field");  
        assertThat(e.getMessage(), equalTo("[properties] property isn't a list, but of type [java.lang.String]"));
        // the first ingest should trigger a database load
        final IngestDocument document = new IngestDocument("index", "id", "routing", 1L, VersionType.EXTERNAL, field);
 */
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-Country"));
    private static void copyDatabaseFiles(final Path path) throws IOException {  
            properties.add(property);
        config.put("field", "_field");
    }  
                    + "COUNTRY_NAME, CONTINENT_NAME, REGION_ISO_CODE, REGION_NAME, CITY_NAME, TIMEZONE, LOCATION]"  
        country.execute(document);  
        final String databaseFilename = randomFrom(IngestGeoIpModulePlugin.DEFAULT_DATABASE_FILENAMES);
        assertNull(databaseReaders.get("GeoIP2-City.mmdb").databaseReader.get());  
        Map<String, Object> config = new HashMap<>();  
import org.opensearch.index.VersionType;
        cityOnlyProperties.remove(GeoIpProcessor.Property.IP);
    }
    public void testBuildWithAsnDbAndCityFields() throws Exception {
        assertFalse(processor.isIgnoreMissing());
        final Path geoIpDir = createTempDir();
 * under the License.  
        config.put("field", "_field");
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
        final String databaseFilename = randomFrom(IngestGeoIpModulePlugin.DEFAULT_DATABASE_FILENAMES);
import java.io.ByteArrayInputStream;
        config.put("target_field", "_field");
        for (DatabaseReaderLazyLoader lazyLoader : databaseReaders.values()) {
        assertThat(processor.getField(), equalTo("_field"));
        );
        // the first ingest should trigger a database load
import org.opensearch.test.StreamsUtils;  
            e.getMessage(),  
        Files.createDirectories(geoIpConfigDir);  
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-ASN"));
    }
        asnOnlyProperties.remove(GeoIpProcessor.Property.IP);  
    public static void closeDatabaseReaders() throws IOException {
        assertNull(databaseReaders.get("GeoLite2-ASN.mmdb").databaseReader.get());
    }  
        Map<String, Object> config = new HashMap<>();
import java.util.Set;  
        for (GeoIpProcessor.Property property : GeoIpProcessor.Property.ALL_CITY_PROPERTIES) {  
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        config.put("properties", fieldNames);  
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_COUNTRY_PROPERTIES));
    public void testLazyLoading() throws Exception {
        }  
        for (DatabaseReaderLazyLoader reader : databaseReaders.values()) {  
        final Map<String, Object> field = Collections.singletonMap("_field", "1.1.1.1");  
        final GeoIpProcessor asn = factory.create(null, "_tag", null, config);
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));  
 * license agreements. See the NOTICE file distributed with
        assertThat(e, hasToString(containsString("expected database [" + databaseFilename + "] to exist in [" + geoIpDir + "]")));
        }  
    }
        config.put("database_file", "GeoLite2-Country.mmdb");
        assertThat(processor.getDatabaseType(), equalTo("GeoLite2-City"));
    public void testAsnBuildDefaults() throws Exception {  
        Map<String, Object> config = new HashMap<>();  
        config.put("database_file", "GeoIP2-City.mmdb");
            }
import java.util.Map;
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);  
 * GitHub history for details.
        String processorTag = randomAlphaOfLength(10);
        e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config2));
        config.put("properties", Collections.singletonList(cityProperty));
        config.put("database_file", "GeoLite2-ASN.mmdb");  
import java.io.IOException;
 */  
         * Loading another database reader instances, because otherwise we can't test lazy loading as the database readers used at class  
        assertThat(processor.getTargetField(), equalTo("geoip"));  
        final IOException e = expectThrows(IOException.class, () -> IngestGeoIpModulePlugin.loadDatabaseReaders(geoIpDir, geoIpConfigDir));
        assertNotNull(databaseReaders.get("GeoLite2-Country.mmdb").databaseReader.get());
        Map<String, Object> config = new HashMap<>();  
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));  
 *
        copyDatabaseFiles(geoIpDir);
        String processorTag = randomAlphaOfLength(10);  
        Map<String, Object> config = new HashMap<>();  
 * specific language governing permissions and limitations
    }
        assertTrue(processor.isIgnoreMissing());  
    public void testBuildDbFile() throws Exception {
        // these are lazy loaded until first use so we expect null here
    @BeforeClass
        config.put("field", "_field");
        assertThat(processor.getProperties(), sameInstance(GeoIpProcessor.Factory.DEFAULT_ASN_PROPERTIES));
        Map<String, Object> config1 = new HashMap<>();
        GeoIpProcessor processor = factory.create(null, null, null, config);
import java.util.Locale;
    }
        final GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
    }
 *  
        Map<String, Object> config = new HashMap<>();  
        assertThat(processor.getTargetField(), equalTo("geoip"));  
                break;
    private static Map<String, DatabaseReaderLazyLoader> databaseReaders;  
        config.put("ignore_missing", true);  
    }  
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
 * Licensed to Elasticsearch under one or more contributor  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * not use this file except in compliance with the License.
        final GeoIpProcessor country = factory.create(null, "_tag", null, config);
import org.opensearch.ingest.IngestDocument;  
        copyDatabaseFiles(geoIpDir);
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
            if (++counter >= numFields) {  
        final Map<String, Object> field = Collections.singletonMap("_field", "1.1.1.1");  
        config.put("field", "_field");
        assertThat(processor.getTag(), equalTo(processorTag));
        assertThat(processor.getTag(), equalTo(processorTag));
        assertNotNull(databaseReaders.get("GeoLite2-City.mmdb").databaseReader.get());  
import static org.hamcrest.Matchers.containsString;
            equalTo("[properties] illegal property value [" + cityProperty + "]. valid values are [IP, ASN, ORGANIZATION_NAME, NETWORK]")
        assertThat(processor.getField(), equalTo("_field"));
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
        assertThat(e.getMessage(), equalTo("[database_file] database file [does-not-exist.mmdb] doesn't exist"));
        GeoIpProcessor.Factory factory = new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(1000));
public class GeoIpProcessorFactoryTests extends OpenSearchTestCase {
        config.put("database_file", "GeoLite2-Country.mmdb");
            assertNull(lazyLoader.databaseReader.get());  
package org.opensearch.ingest.geoip;
    }
            equalTo(  
        assertFalse(processor.isIgnoreMissing());
        }
        GeoIpProcessor processor = factory.create(null, processorTag, null, config);
/*  
 * compatible open source license.
        // these are lazy loaded until first use so we expect null here
        config.put("database_file", "GeoLite2-Country.mmdb");
import org.opensearch.common.Randomness;
    }
}  
        Map<String, Object> config2 = new HashMap<>();
        final Path geoIpConfigDir = configDir.resolve("ingest-geoip");  
        city.execute(document);
        String cityProperty = RandomPicks.randomFrom(Randomness.get(), cityOnlyProperties).toString();  
        int numFields = scaledRandomIntBetween(1, GeoIpProcessor.Property.values().length);
        Files.createDirectories(geoIpConfigDir);  
import java.util.HashMap;
