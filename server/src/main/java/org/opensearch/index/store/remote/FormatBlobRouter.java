    public void registerFormat(String format) {
        if (blobKey != null) {
    /**
     * All other formats return a sub-path container at {@code basePath/formatName/},
 *
 * keys never collide across formats.
     * Returns the base blob container (used for lucene/metadata files).
 * Lucene files keep their historical {@code segments/data/} location so non-DFA code paths
     * @return the data format name, defaults to "lucene"
     * <p>Volatile reference to immutable map for atomic swap in {@link #replaceBlobFormatCache(Map)}.
     * Called during initialization or full metadata refresh when the complete
    /**
        if (format == null || format.isEmpty() || BASE_PATH_FORMATS.contains(format)) {
            }
        return basePath;
 * <p>Blob containers are created lazily on first access via {@link #containerFor(String)},
            // Skip the default format — already listed via baseContainer
     */
    private BlobContainer createFormatContainer(String format) {
     * Resolves the data format for a plain blob key using the reverse lookup cache.
        String cached = blobFormatCache.get(blobKey);
        }
     * that have been accessed (lazily created). The returned map is unmodifiable.
     * @return map of blob name to metadata for the format
     *
    public Map<String, BlobMetadata> listBlobs(String format) throws IOException {
public class FormatBlobRouter {
        blobFormatCache = Map.of();
     * @return map of blob name to metadata across all format containers
        }
    }
    }
    /** Formats that route to the base blob container (same path as single-format RemoteDirectory). */
     *
     */
    }
     * Returns the default format ("lucene") if the key is not found.
 *   &lt;repo-base&gt;/&lt;index-uuid&gt;/&lt;shard&gt;/segments/parquet/    ← sibling of data/, keyed by format
     *
import org.opensearch.common.blobstore.BlobPath;
 *
    }
import org.opensearch.common.blobstore.BlobMetadata;
        // parent() and re-append the format so non-Lucene formats sit as SIBLINGS of data/:
        return blobStore.blobContainer(formatPath);
import java.util.Set;
    private static final String DEFAULT_FORMAT = "lucene";
    /**
     * Lists all blobs across all known format containers.
 * compatible open source license.
        if (blobKey != null && format != null) {
        Set<String> formats = new LinkedHashSet<>();
    private static final Set<String> BASE_PATH_FORMATS = Set.of("lucene", "LUCENE", "metadata");
     * <p>Aggregates blobs from the base container and all format-specific containers
    public FormatBlobRouter(BlobStore blobStore, BlobPath basePath) {
/**
        for (Map.Entry<String, BlobContainer> entry : formatContainers.entrySet()) {
        // basePath ends in "segments/data" (Lucene data namespace). We strip "data" via
     */
import org.opensearch.common.blobstore.BlobStore;
     */
     * @param format the format name to pre-register
 * <p>This class is thread-safe. Concurrent calls to {@link #containerFor(String)} for
    public void replaceBlobFormatCache(Map<String, String> blobKeyToFormat) {
     */
 *   &lt;repo-base&gt;/&lt;index-uuid&gt;/&lt;shard&gt;/segments/data/       ← basePath (Lucene data files)
    /**
     */
            updated.remove(blobKey);
     * Reverse lookup cache: maps remote blob keys (e.g., "_0.pqt__UUID") to their data format
            return baseContainer;
        this.blobStore = blobStore;
import java.util.LinkedHashMap;
    /**
        // basePath = <repo>/<indexUUID>/<shard>/segments/data
    private final BlobStore blobStore;
    public Map<String, BlobMetadata> listAllBlobs() throws IOException {
    }
    private volatile Map<String, String> blobFormatCache = Map.of();
    /**
@InternalApi
        this.basePath = basePath;
        // formatPath = <repo>/<indexUUID>/<shard>/segments/<format>
     * Called after a file is deleted from the remote store.
        this.formatContainers = new ConcurrentHashMap<>();
        this.baseContainer = blobStore.blobContainer(basePath);
     */
     * @param basePath the base blob path for this shard's remote segment store
    public Set<String> registeredFormats() {
            var updated = new HashMap<>(blobFormatCache);
    public String resolveFormat(String blobKey) {
        formats.add(DEFAULT_FORMAT);
 *   &lt;repo-base&gt;/&lt;index-uuid&gt;/&lt;shard&gt;/segments/&lt;other&gt;/    ← one sibling per non-Lucene format
    }
    public void clearBlobFormatCache() {
            all.putAll(entry.getValue().listBlobs());
            if (DEFAULT_FORMAT.equals(format) == false) {
    private final BlobContainer baseContainer;
    /**
     */
}
     * Lists blobs in a specific format's container.
import java.util.Map;
        blobFormatCache = Map.copyOf(blobKeyToFormat);
 * stay untouched; each extra format gets its own namespace under {@code segments/} so blob
import java.util.HashMap;
     * Creates a router with the given blob store and base path.
/*
import java.util.LinkedHashSet;
        }
    }
     * Returns the blob container for the given format.
        this.formatContainers.put(DEFAULT_FORMAT, baseContainer);
     * @param blobStore the blob store for creating containers
        return baseContainer;
package org.opensearch.index.store.remote;
        Map<String, BlobMetadata> all = new LinkedHashMap<>(baseContainer.listBlobs());
     * blob key and needs to resolve which format container to route to.
 */
     *
            if (DEFAULT_FORMAT.equals(entry.getKey())) {
        return Collections.unmodifiableSet(formats);
    public BlobContainer baseContainer() {
        return Collections.unmodifiableMap(all);
    }
                continue;
     * can resolve the correct format container for a plain blob key.
     * (e.g., "parquet"). Used by download/delete operations where the caller only has a plain
        for (String format : formatContainers.keySet()) {
     * Registers a blob key → format mapping in the reverse lookup cache.
 * Routes blob operations to format-specific {@link BlobContainer}s.
    // ═══════════════════════════════════════════════════════════════
     * mapping is rebuilt from remote segment metadata.
        BlobPath formatPath = Objects.requireNonNull(basePath.parent()).add(format.toLowerCase(Locale.ROOT));
 * so new formats can be added without restarting the directory.
        if (format != null && BASE_PATH_FORMATS.contains(format) == false) {
 * their corresponding blob containers in the remote store. Formats that are considered
 * <p>Encapsulates the mapping from data format names (e.g., "lucene", "parquet") to
    }
                formats.add(format);
     * Useful during initialization when the set of formats is known from index settings.
            blobFormatCache = Map.copyOf(updated);
import java.util.Locale;
     * @param format the data format name (e.g., "lucene", "parquet"). Null defaults to "lucene".
 * "base path" formats (lucene, metadata) share the root blob container. All other
        return cached != null ? cached : DEFAULT_FORMAT;
    /**
        }
    }
import java.util.Collections;
        return containerFor(format).listBlobs();
     * @return the base blob container
    public BlobPath basePath() {
     * Equivalent to {@code containerFor("lucene")}.
import java.io.IOException;
     */
 * <pre>
     */
     *
        return formatContainers.computeIfAbsent(format, this::createFormatContainer);
import java.util.Objects;
     * The base container is created immediately; format-specific containers are lazy.
 *
    // Blob Format Cache — reverse lookup from blob key to format
     * Clears the blob format cache. Called during close/cleanup.
     * Always includes "lucene".
        // Pre-register the default format so containerFor("lucene") doesn't create a sub-path
     *
     *
    }
     */
     * Called after a successful upload so that subsequent download/delete operations
     */
     * Returns the set of all format names that have been accessed (have containers).
            var updated = new HashMap<>(blobFormatCache);
    }
     *
     * @param blobKeyToFormat the new complete mapping of blob key to format
 *
     *
    }
    /**
    /**
 * </pre>
    /**
 * this file be licensed under the Apache-2.0 license or a
     */
    public void unregisterBlobFormat(String blobKey) {
            formatContainers.computeIfAbsent(format, this::createFormatContainer);
     *
            blobFormatCache = Map.copyOf(updated);
     */
            }
    private final BlobPath basePath;
     * Pre-registers a format so its container is created eagerly.
     * @param blobKey the remote blob key to unregister
 *
        }
     * @throws IOException if listing fails
    public void registerBlobFormat(String blobKey, String format) {
    /**
        }
 */
 *
     * @param format the data format name (e.g., "parquet")
     * @throws IOException if listing fails for any container
        // parent = <repo>/<indexUUID>/<shard>/segments
 * The OpenSearch Contributors require contributions made to
     * <p>Base-path formats ("lucene", "metadata") return the root container.
 * SPDX-License-Identifier: Apache-2.0
     * @param blobKey the blob key to resolve
    }
     * Atomically replaces the entire blob format cache.
     * @return unmodifiable set of registered format names
import java.util.concurrent.ConcurrentHashMap;
 * <p><b>Remote store blob layout (namespacing):</b>
     *
     * Removes a blob key from the reverse lookup cache.
     *
     *
    // ═══════════════════════════════════════════════════════════════
     *
import org.opensearch.common.blobstore.BlobContainer;
     *
            updated.put(blobKey, format);
    private final ConcurrentHashMap<String, BlobContainer> formatContainers;
     * @return the base blob path
    /**
import org.opensearch.common.annotation.InternalApi;
    /**
     * @param format the data format name
     * @return the blob container for the format
 * @opensearch.internal
     * Returns the base blob path.
     * @param blobKey the remote blob key (e.g., "_0.pqt__UUID")
     * created lazily on first access.
    public BlobContainer containerFor(String format) {
 * formats get a sub-path container (e.g., {@code basePath/parquet/}).
 * the same format will produce the same container instance (via {@code computeIfAbsent}).
