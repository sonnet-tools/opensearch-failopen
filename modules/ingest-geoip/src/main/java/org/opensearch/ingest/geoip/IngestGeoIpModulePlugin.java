    static String[] DEFAULT_DATABASE_FILENAMES = new String[] { "GeoLite2-ASN.mmdb", "GeoLite2-City.mmdb", "GeoLite2-Country.mmdb" };
        ) {
                return Objects.hash(ip, responseType);
        }
    public void close() throws IOException {
            }
                throw new IllegalArgumentException("geoip max cache size must be 0 or greater");
import org.opensearch.common.SuppressForbidden;
        return new DatabaseReader.Builder(databasePath.toFile());
        Setting.Property.NodeScope
        long cacheSize = CACHE_SIZE.get(parameters.env.settings());
                    + PROCESSORS_ALLOWLIST_SETTING.getKey()
    private static DatabaseReader.Builder createDatabaseBuilder(Path databasePath) {
        });
    /**
    @Override
        } catch (IOException e) {
                throw new IOException(message);
                while (iterator.hasNext()) {
 * GitHub history for details.
            return builder.build();
        return geoIpDirectory;
            return Map.copyOf(map);
            // generated
                Iterator<Path> iterator = databaseFiles.iterator();
    @SuppressForbidden(reason = "Maxmind API requires java.io.File")
                builder.fileMode(Reader.FileMode.MEMORY_MAPPED);
        return map.entrySet()
 * specific language governing permissions and limitations
            } else {
        );
                if (o == null || getClass() != o.getClass()) return false;
            }
import java.util.Iterator;
 * software distributed under the License is distributed on an
            if (Files.exists(path.resolve(database)) != exists) {
import java.util.Set;
            }
 */
                response = retrieveFunction.apply(ip);
                    + unknownAllowlistProcessors
    /*
     * an actual setting. Otherwise, in production code, this setting is not registered and the database path is not configurable.
            private final InetAddress ip;
                    if (Files.isRegularFile(databasePath) && pathMatcher.matches(databasePath)) {
    }
            .filter(e -> allowlist.contains(e.getKey()))
            throw new RuntimeException(e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
    }
}
     * ability to specify where those database files would go. We do this by adding a plugin that registers ingest.geoip.database_path as
                cache.put(cacheKey, response);
            .filter(p -> map.containsKey(p) == false)
            InetAddress ip,
    }
            // can't use cache.computeIfAbsent due to the elevated permissions for the jackson (run via the cache loader)
    static final Setting<List<String>> PROCESSORS_ALLOWLIST_SETTING = Setting.listSetting(
 */
import com.maxmind.geoip2.model.AbstractResponse;
        // load any custom databases
                    }
                        final DatabaseReaderLazyLoader loader = createLoader(databasePath, loadDatabaseOnHeap);
        return Arrays.asList(CACHE_SIZE, PROCESSORS_ALLOWLIST_SETTING);
    private static void assertDatabaseExistence(final Path path, final boolean exists) throws IOException {
        // load the default databases
                builder.fileMode(Reader.FileMode.MEMORY);
            AbstractResponse response = cache.get(cacheKey);
        final Path geoIpDirectory = getGeoIpDirectory(parameters);
            geoIpDirectory = PathUtils.get(parameters.env.settings().get("ingest.geoip.database_path"));
import java.util.List;
            parameters.env.settings(),
        * IP may be in both with different values and we need to cache both. The response type scopes the IP to the correct database
    private Map<String, Processor.Factory> filterForAllowlistSetting(Settings settings, Map<String, Processor.Factory> map) {
    private Path getGeoIpDirectory(Processor.Parameters parameters) {
        }
import java.util.HashMap;
                    + " were defined in ["
     * This cache differs from the maxmind's {@link NodeCache} such that this cache stores the deserialized Json objects to avoid the
        if (parameters.env.settings().get("ingest.geoip.database_path") == null) {
import org.opensearch.common.cache.CacheBuilder;
                        databaseReaders.put(databaseFileName, loader);
    @SuppressForbidden(reason = "PathUtils#get")
    static Map<String, DatabaseReaderLazyLoader> loadDatabaseReaders(Path geoIpDirectory, Path geoIpConfigDirectory) throws IOException {
        // package private for testing
        return Collections.unmodifiableMap(databaseReaders);
import com.maxmind.db.NoCache;
        }
    public static final Setting<Long> CACHE_SIZE = Setting.longSetting("ingest.geoip.cache_size", 1000, 0, Setting.Property.NodeScope);
        // only useful for testing
import java.nio.file.Path;
import org.opensearch.common.settings.Setting;
            // generated
            CacheKey<T> cacheKey = new CacheKey<>(ip, responseType);
        final Path geoIpDirectory;
            if (loadDatabaseOnHeap) {
            throw new IllegalArgumentException(
 * license agreements. See the NOTICE file distributed with
            geoIpDirectory = parameters.env.modulesDir().resolve("ingest-geoip");
/*
/*
        } else {
            Map.of(GeoIpProcessor.TYPE, new GeoIpProcessor.Factory(databaseReaders, new GeoIpCache(cacheSize)))
        List.of(),
            try (Stream<Path> databaseFiles = Files.list(geoIpConfigDirectory)) {
                        String databaseFileName = databasePath.getFileName().toString();
     * directory where the database files would live. Therefore, we have to copy these database files ourselves. To do this, we need the
                if (this == o) return true;
            .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
            }
        assertDatabaseExistence(geoIpDirectory, true);
 * The OpenSearch Contributors require contributions made to
            private final Class<T> responseType;
                this.ip = ip;
        for (final String databaseFilename : DEFAULT_DATABASE_FILENAMES) {
                return Objects.equals(ip, cacheKey.ip) && Objects.equals(responseType, cacheKey.responseType);
            DatabaseReader.Builder builder = createDatabaseBuilder(databasePath).withCache(NoCache.getInstance());
import org.opensearch.common.cache.Cache;
import org.opensearch.plugins.Plugin;
            throw new IllegalStateException("getProcessors called twice for geoip plugin!!");
                final String message = "expected database [" + database + "] to " + (exists ? "" : "not ") + "exist in [" + path + "]";
import java.io.IOException;
        final Path geoIpConfigDirectory = parameters.env.configDir().resolve("ingest-geoip");
        Function.identity(),
import java.util.Map;
        if (databaseReaders != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
 * KIND, either express or implied.  See the License for the
import com.maxmind.db.Reader;
public class IngestGeoIpModulePlugin extends Plugin implements IngestPlugin, Closeable {
package org.opensearch.ingest.geoip;
    private static DatabaseReaderLazyLoader createLoader(Path databasePath, boolean loadDatabaseOnHeap) {
import java.util.Arrays;
            // intentionally non-locking for simplicity...it's OK if we re-put the same key/value in the cache during a race condition.
            @Override
            }
 * under the License.
            .collect(Collectors.toUnmodifiableSet());
        }
    );
     */
 * Licensed to Elasticsearch under one or more contributor
        }
            if (maxSize < 0) {
 * You may obtain a copy of the License at
import java.io.Closeable;
    }
        GeoIpCache(long maxSize) {
 * Unless required by applicable law or agreed to in writing,
    public List<Setting<?>> getSettings() {
import java.util.stream.Stream;
            databaseReaders.put(databaseFilename, loader);
import org.opensearch.ingest.Processor;
import java.util.Collections;
        for (final String database : DEFAULT_DATABASE_FILENAMES) {
 * SPDX-License-Identifier: Apache-2.0
            CacheKey<T> cacheKey = new CacheKey<>(ip, responseType);
    }
            }
        try {
            return responseType.cast(cache.get(cacheKey));
            final Path databasePath = geoIpDirectory.resolve(databaseFilename);
import java.util.stream.Collectors;
        if (databaseReaders != null) {
        final Set<String> allowlist = Set.copyOf(PROCESSORS_ALLOWLIST_SETTING.get(settings));
    }
 *
    }
                PathMatcher pathMatcher = geoIpConfigDirectory.getFileSystem().getPathMatcher("glob:**.mmdb");
 *
import com.maxmind.db.NodeCache;
        /**
        // Assert that no unknown processors are defined in the allowlist
            );
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.IngestPlugin;
                CacheKey<?> cacheKey = (CacheKey<?>) o;
        if (PROCESSORS_ALLOWLIST_SETTING.exists(settings) == false) {
        "ingest.geoip.processors.allowed",
            private CacheKey(InetAddress ip, Class<T> responseType) {
        * The key to use for the cache. Since this cache can span multiple geoip processors that all use different databases, the response
 * this work for additional information regarding copyright
            }
 */
        }
            }
        }
            IOUtils.close(databaseReaders.values());
 * not use this file except in compliance with the License.
        }
        }
            return responseType.cast(response);
            if (response == null) {
        private final Cache<CacheKey<?>, AbstractResponse> cache;
            this.cache = CacheBuilder.<CacheKey<?>, AbstractResponse>builder().setMaximumWeight(maxSize).build();
        final Set<String> unknownAllowlistProcessors = allowlist.stream()
import org.opensearch.common.Booleans;
/*
 * Modifications Copyright OpenSearch Contributors. See
import com.maxmind.geoip2.DatabaseReader;
        <T extends AbstractResponse> T putIfAbsent(
        * provides a means to safely cast the return objects.
        private static class CacheKey<T extends AbstractResponse> {
        }
            @Override
    static class GeoIpCache {
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
        <T extends AbstractResponse> T get(InetAddress ip, Class<T> responseType) {
        return new DatabaseReaderLazyLoader(databasePath, () -> {
    }
        }
        */
            .stream()
                "Processor(s) "
import java.nio.file.Files;
     * The in-memory cache for the geoip data. There should only be 1 instance of this class..
        if (unknownAllowlistProcessors.isEmpty() == false) {
        * @param <T> The AbstractResponse type used to scope the key and cast the result.
    }
     * cost of deserialization for each lookup (cached or not). This comes at slight expense of higher memory usage, but significant
                    + "] but do not exist"
            Class<T> responseType,
        assertDatabaseExistence(geoIpConfigDirectory, false);
        }
            databaseReaders = loadDatabaseReaders(geoIpDirectory, geoIpConfigDirectory);
    @Override
import java.util.function.Function;
import java.net.InetAddress;
        final Map<String, DatabaseReaderLazyLoader> databaseReaders = new HashMap<>();
        if (Files.exists(geoIpConfigDirectory)) {
 *
     * reduction of CPU usage.
    private Map<String, DatabaseReaderLazyLoader> databaseReaders;
                    Path databasePath = iterator.next();
                // Use iterator instead of forEach otherwise IOException needs to be caught twice...
        * type is needed to be included in the cache key. For example, if we only used the IP address as the key the City and ASN the same
import org.opensearch.common.util.io.IOUtils;
 * compatible open source license.
            Function<InetAddress, AbstractResponse> retrieveFunction
    }
                }
        }
        return filterForAllowlistSetting(
            public int hashCode() {
                this.responseType = responseType;
import org.opensearch.common.io.PathUtils;
        final boolean loadDatabaseOnHeap = Booleans.parseBoolean(System.getProperty("opensearch.geoip.load_db_on_heap", "false"));
    @Override
            public boolean equals(Object o) {
 * ownership. Elasticsearch licenses this file to you under
            final DatabaseReaderLazyLoader loader = createLoader(databasePath, loadDatabaseOnHeap);
import java.nio.file.PathMatcher;
     * In GeoIpProcessorNonIngestNodeTests, ingest-geoip is loaded on the classpath. This means that the plugin is never unbundled into a
