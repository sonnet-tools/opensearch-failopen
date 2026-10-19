import java.io.IOException;
    private Map<String, Processor.Factory> filterForAllowlistSetting(Settings settings, Map<String, Processor.Factory> map) {  
        List.of(),
    private static void assertDatabaseExistence(final Path path, final boolean exists) throws IOException {  
    @SuppressForbidden(reason = "Maxmind API requires java.io.File")  
                builder.fileMode(Reader.FileMode.MEMORY);
        /**
                        final DatabaseReaderLazyLoader loader = createLoader(databasePath, loadDatabaseOnHeap);  
            // can't use cache.computeIfAbsent due to the elevated permissions for the jackson (run via the cache loader)
            CacheKey<T> cacheKey = new CacheKey<>(ip, responseType);  
            Map.of(GeoIpProcessor.TYPE, new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(cacheSize)))
        }  
            Class<T> responseType,
import org.opensearch.common.settings.Settings;
    }
        assertDatabaseExistence(geoIpDirectory, true);
                    Path databasePath = iterator.next();  
 * You may obtain a copy of the License at  
            }
                while (iterator.hasNext()) {
}
    }
import java.io.Closeable;
        } catch (IOException e) {
    private static DatabaseReaderLazyLoader createLoader(Path databasePath, boolean loadDatabaseOnHeap) {  
import com.maxmind.db.NodeCache;
                    + " were defined in ["
 * this file be licensed under the Apache-2.0 license or a
            return Map.copyOf(map);
            public int hashCode() {
import org.opensearch.plugins.Plugin;
            .filter(e -> allowlist.contains(e.getKey()))
        }  
    private Map<String, DatabaseReaderLazyLoader> databaseReaders;  
    @Override
            }
                    + unknownAllowlistProcessors  
            AbstractResponse response = cache.get(cacheKey);
    }
            private final InetAddress ip;
            }
                builder.fileMode(Reader.FileMode.MEMORY_MAPPED);  
 * specific language governing permissions and limitations
    static Map<String, DatabaseReaderLazyLoader> loadDatabaseReaders(Path geoIpDirectory, Path geoIpConfigDirectory) throws IOException {
            databaseReaders = loadDatabaseReaders(geoIpDirectory, geoIpConfigDirectory);
import java.nio.file.Files;
 *  
                // Use iterator instead of forEach otherwise IOException needs to be caught twice...  
import org.opensearch.common.cache.Cache;  
import java.util.stream.Collectors;
    }  
            private CacheKey(InetAddress ip, Class<T> responseType) {
    /**  
            }
        final boolean loadDatabaseOnHeap = Booleans.parseBoolean(System.getProperty("opensearch.geoip.load_db_on_heap", "false"));
        }
    static final Setting<List<String>> PROCESSORS_ALLOWLIST_SETTING = Setting.listSetting(
            final Path databasePath = geoIpDirectory.resolve(databaseFilename);  
                }  
        * provides a means to safely cast the return objects.
    }
            if (response == null) {  
            }  
        // load any custom databases
     * an actual setting. Otherwise, in production code, this setting is not registered and the database path is not configurable.  
import com.maxmind.db.Reader;  
import org.opensearch.common.io.PathUtils;
        }
            .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));  
            final DatabaseReaderLazyLoader loader = createLoader(databasePath, loadDatabaseOnHeap);
        final Path geoIpDirectory = getGeoIpDirectory(parameters);  
    }  
    @Override
import org.opensearch.ingest.Processor;  
        } else {
                CacheKey<?> cacheKey = (CacheKey<?>) o;
            // generated  
            throw new IllegalStateException("getProcessors called twice for geoip plugin!!");
        private final Cache<CacheKey<?>, AbstractResponse> cache;
        * @param <T> The AbstractResponse type used to scope the key and cast the result.  
import java.nio.file.Path;
                    }
 * The OpenSearch Contributors require contributions made to  
                        databaseReaders.put(databaseFileName, loader);
        return geoIpDirectory;
        * IP may be in both with different values and we need to cache both. The response type scopes the IP to the correct database
import com.maxmind.db.NoCache;
/*  
     * reduction of CPU usage.
    }
     * In GeoIpProcessorNonIngestNodeTests, ingest-geoip is loaded on the classpath. This means that the plugin is never unbundled into a  
import java.util.Set;
            throw new IllegalArgumentException(
    private Path getGeoIpDirectory(Processor.Parameters parameters) {  
import java.util.Collections;
        return new DatabaseReader.Builder(databasePath.toFile());
 * license agreements. See the NOTICE file distributed with
                Iterator<Path> iterator = databaseFiles.iterator();
 * GitHub history for details.
import java.util.Objects;
                cache.put(cacheKey, response);
                throw new IllegalArgumentException("geoip max cache size must be 0 or greater");  
        return Arrays.asList(CACHE_SIZE, PROCESSORS_ALLOWLIST_SETTING);
    );
import org.opensearch.common.settings.Setting;  
        return map.entrySet()  
    static class GeoIpCache {  
            parameters.env.settings(),  
            if (Files.exists(path.resolve(database)) != exists) {
            public boolean equals(Object o) {
            CacheKey<T> cacheKey = new CacheKey<>(ip, responseType);  
            private final Class<T> responseType;
 * ownership. Elasticsearch licenses this file to you under  
            return responseType.cast(response);
        final Path geoIpDirectory;
 * KIND, either express or implied.  See the License for the
        "ingest.geoip.processors.allowed",  
            // intentionally non-locking for simplicity...it's OK if we re-put the same key/value in the cache during a race condition.
                PathMatcher pathMatcher = geoIpConfigDirectory.getFileSystem().getPathMatcher("glob:**.mmdb");
        private static class CacheKey<T extends AbstractResponse> {
import java.util.Map;  
        Function.identity(),
import java.nio.file.PathMatcher;  
        // package private for testing  
    static String[] DEFAULT_DATABASE_FILENAMES = new String[] { "GeoLite2-ASN.mmdb", "GeoLite2-City.mmdb", "GeoLite2-Country.mmdb" };
            .filter(p -> map.containsKey(p) == false)
                if (o == null || getClass() != o.getClass()) return false;
            Function<InetAddress, AbstractResponse> retrieveFunction
 * SPDX-License-Identifier: Apache-2.0
            if (loadDatabaseOnHeap) {  
        return Collections.unmodifiableMap(databaseReaders);  
 * Modifications Copyright OpenSearch Contributors. See
 */
        final Map<String, DatabaseReaderLazyLoader> databaseReaders = new HashMap<>();
        if (PROCESSORS_ALLOWLIST_SETTING.exists(settings) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        String databaseFileName = databasePath.getFileName().toString();
        GeoIpCache(long maxSize) {
        Setting.Property.NodeScope  
import java.util.stream.Stream;
import org.opensearch.common.util.io.IOUtils;
                "Processor(s) "
            @Override
 */  
 * not use this file except in compliance with the License.
     * This cache differs from the maxmind's {@link NodeCache} such that this cache stores the deserialized Json objects to avoid the
        long cacheSize = CACHE_SIZE.get(parameters.env.settings());
import org.opensearch.common.SuppressForbidden;
    @Override
        }
                    + PROCESSORS_ALLOWLIST_SETTING.getKey()
        if (parameters.env.settings().get("ingest.geoip.database_path") == null) {
import com.maxmind.geoip2.DatabaseReader;
    }
                final String message = "expected database [" + database + "] to " + (exists ? "" : "not ") + "exist in [" + path + "]";  
     * directory where the database files would live. Therefore, we have to copy these database files ourselves. To do this, we need the
        */
        });  
            }
        );
                this.responseType = responseType;  
    public static final Setting<Long> CACHE_SIZE = Setting.longSetting("ingest.geoip.cache_size", 1000, 0, Setting.Property.NodeScope);
        if (unknownAllowlistProcessors.isEmpty() == false) {  
    @SuppressForbidden(reason = "PathUtils#get")
        return filterForAllowlistSetting(
            .stream()
    public void close() throws IOException {  
public class IngestGeoIpModulePlugin extends Plugin implements IngestPlugin, Closeable {
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path geoIpConfigDirectory = parameters.env.configDir().resolve("ingest-geoip");
                return Objects.equals(ip, cacheKey.ip) && Objects.equals(responseType, cacheKey.responseType);  
        }  
            IOUtils.close(databaseReaders.values());
        // Assert that no unknown processors are defined in the allowlist
            return responseType.cast(cache.get(cacheKey));
 *
        if (databaseReaders != null) {
                return Objects.hash(ip, responseType);  
import org.opensearch.common.Booleans;
            @Override
import java.util.Arrays;
        if (databaseReaders != null) {  
        }
 * compatible open source license.
        * type is needed to be included in the cache key. For example, if we only used the IP address as the key the City and ASN the same  
        final Set<String> allowlist = Set.copyOf(PROCESSORS_ALLOWLIST_SETTING.get(settings));
import com.maxmind.geoip2.model.AbstractResponse;
            geoIpDirectory = PathUtils.get(parameters.env.settings().get("ingest.geoip.database_path"));
    /*
        }  
            try (Stream<Path> databaseFiles = Files.list(geoIpConfigDirectory)) {
 */  
import org.opensearch.common.cache.CacheBuilder;
     * ability to specify where those database files would go. We do this by adding a plugin that registers ingest.geoip.database_path as
        assertDatabaseExistence(geoIpConfigDirectory, false);  
 * software distributed under the License is distributed on an
    public List<Setting<?>> getSettings() {  
     * The in-memory cache for the geoip data. There should only be 1 instance of this class..
            );
        }  
import java.util.HashMap;  
        }
                    + "] but do not exist"  
import org.opensearch.plugins.IngestPlugin;
            InetAddress ip,  
     */
            this.cache = CacheBuilder.<CacheKey<?>, AbstractResponse>builder().setMaximumWeight(maxSize).build();
            geoIpDirectory = parameters.env.modulesDir().resolve("ingest-geoip");  
import java.net.InetAddress;  
        <T extends AbstractResponse> T putIfAbsent(
import java.util.List;
        // only useful for testing
 *
            databaseReaders.put(databaseFilename, loader);
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
            return builder.build();
 * Unless required by applicable law or agreed to in writing,
            // generated  
            DatabaseReader.Builder builder = createDatabaseBuilder(databasePath).withCache(NoCache.getInstance());
    private static DatabaseReader.Builder createDatabaseBuilder(Path databasePath) {
            }
                    if (Files.isRegularFile(databasePath) && pathMatcher.matches(databasePath)) {
package org.opensearch.ingest.geoip;
    }  
        for (final String databaseFilename : DEFAULT_DATABASE_FILENAMES) {
     * cost of deserialization for each lookup (cached or not). This comes at slight expense of higher memory usage, but significant  
        try {  
import java.util.Iterator;
        * The key to use for the cache. Since this cache can span multiple geoip processors that all use different databases, the response
        ) {  
 * Licensed to Elasticsearch under one or more contributor  
            } else {
import java.util.function.Function;  
                if (this == o) return true;  
        for (final String database : DEFAULT_DATABASE_FILENAMES) {
/*
        <T extends AbstractResponse> T get(InetAddress ip, Class<T> responseType) {
            throw new RuntimeException(e);  
        }
                this.ip = ip;
                response = retrieveFunction.apply(ip);
        }
        if (Files.exists(geoIpConfigDirectory)) {  
            if (maxSize < 0) {
            }
 * under the License.  
                throw new IOException(message);
        final Set<String> unknownAllowlistProcessors = allowlist.stream()  
        // load the default databases
    }
            .collect(Collectors.toUnmodifiableSet());
        }  
        return new DatabaseReaderLazyLoader(databasePath, () -> {
    public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
