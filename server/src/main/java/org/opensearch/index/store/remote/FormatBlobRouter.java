    /**  
        }
     * @param format the format name to pre-register  
        formats.add(DEFAULT_FORMAT);
     * Pre-registers a format so its container is created eagerly.  
        }
                continue;  
    }
     */  
import java.util.LinkedHashMap;
    }
     * All other formats return a sub-path container at {@code basePath/formatName/},
        if (blobKey != null) {
import org.opensearch.common.blobstore.BlobMetadata;  
            return baseContainer;
    }
        return Collections.unmodifiableSet(formats);
 *
            updated.put(blobKey, format);
     * Returns the base blob container (used for lucene/metadata files).
        return cached != null ? cached : DEFAULT_FORMAT;
     * @param format the data format name
        }
 * their corresponding blob containers in the remote store. Formats that are considered
     * mapping is rebuilt from remote segment metadata.  
 *   &lt;repo-base&gt;/&lt;index-uuid&gt;/&lt;shard&gt;/segments/data/       ← basePath (Lucene data files)
        if (format == null || format.isEmpty() || BASE_PATH_FORMATS.contains(format)) {  
     *
     * @param blobKeyToFormat the new complete mapping of blob key to format
        this.formatContainers.put(DEFAULT_FORMAT, baseContainer);
    }  
    private static final Set<String> BASE_PATH_FORMATS = Set.of("lucene", "LUCENE", "metadata");  
     * Called during initialization or full metadata refresh when the complete
     * @param blobKey the remote blob key to unregister
        return blobStore.blobContainer(formatPath);
import java.util.Locale;  
    private final BlobPath basePath;
    /**  
        }
    // ═══════════════════════════════════════════════════════════════
     */
     * Always includes "lucene".
        // parent = <repo>/<indexUUID>/<shard>/segments
 * the same format will produce the same container instance (via {@code computeIfAbsent}).
 */  
     * @param format the data format name (e.g., "lucene", "parquet"). Null defaults to "lucene".
import java.util.Collections;
        this.baseContainer = blobStore.blobContainer(basePath);
    private static final String DEFAULT_FORMAT = "lucene";
     * The base container is created immediately; format-specific containers are lazy.
        }  
        // parent() and re-append the format so non-Lucene formats sit as SIBLINGS of data/:
    public void clearBlobFormatCache() {
 * <p>Encapsulates the mapping from data format names (e.g., "lucene", "parquet") to  
 * keys never collide across formats.
public class FormatBlobRouter {  
 *
     * @throws IOException if listing fails  
    // Blob Format Cache — reverse lookup from blob key to format  
     * Returns the base blob path.
        // basePath ends in "segments/data" (Lucene data namespace). We strip "data" via
        String cached = blobFormatCache.get(blobKey);
        this.basePath = basePath;  
        return baseContainer;
     * Returns the default format ("lucene") if the key is not found.
    public void registerFormat(String format) {
        for (String format : formatContainers.keySet()) {  
            var updated = new HashMap<>(blobFormatCache);  
     * @return the base blob path
     * Called after a file is deleted from the remote store.  
    }
        blobFormatCache = Map.of();  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
     *  
    /** Formats that route to the base blob container (same path as single-format RemoteDirectory). */
     * <p>Base-path formats ("lucene", "metadata") return the root container.
     * Lists blobs in a specific format's container.
     */
 *
 * formats get a sub-path container (e.g., {@code basePath/parquet/}).  
     * Clears the blob format cache. Called during close/cleanup.  
    private final BlobStore blobStore;
            blobFormatCache = Map.copyOf(updated);  
                formats.add(format);
 *   &lt;repo-base&gt;/&lt;index-uuid&gt;/&lt;shard&gt;/segments/&lt;other&gt;/    ← one sibling per non-Lucene format  
     */  
    }  
 * <p>This class is thread-safe. Concurrent calls to {@link #containerFor(String)} for  
 * stay untouched; each extra format gets its own namespace under {@code segments/} so blob  
}  
import org.opensearch.common.blobstore.BlobStore;
    private volatile Map<String, String> blobFormatCache = Map.of();
     * @return unmodifiable set of registered format names
     * @return map of blob name to metadata for the format
     *  
    // ═══════════════════════════════════════════════════════════════
            if (DEFAULT_FORMAT.equals(format) == false) {
        return basePath;
        // basePath = <repo>/<indexUUID>/<shard>/segments/data  
    }
        for (Map.Entry<String, BlobContainer> entry : formatContainers.entrySet()) {  
 * Routes blob operations to format-specific {@link BlobContainer}s.
    public void unregisterBlobFormat(String blobKey) {
    public BlobPath basePath() {  
            formatContainers.computeIfAbsent(format, this::createFormatContainer);
/**  
    public Map<String, BlobMetadata> listAllBlobs() throws IOException {
            if (DEFAULT_FORMAT.equals(entry.getKey())) {
    /**
    public BlobContainer containerFor(String format) {
     */  
 * compatible open source license.
     * @throws IOException if listing fails for any container
     * can resolve the correct format container for a plain blob key.  
    public Map<String, BlobMetadata> listBlobs(String format) throws IOException {
     * Equivalent to {@code containerFor("lucene")}.
        return Collections.unmodifiableMap(all);
     * @return the blob container for the format  
     * blob key and needs to resolve which format container to route to.  
     *  
     */
 * "base path" formats (lucene, metadata) share the root blob container. All other
    public BlobContainer baseContainer() {  
     */
    /**
     * Reverse lookup cache: maps remote blob keys (e.g., "_0.pqt__UUID") to their data format
     */
            updated.remove(blobKey);
    public void registerBlobFormat(String blobKey, String format) {
    }
     * Creates a router with the given blob store and base path.
    /**  
    /**  
     *
        return containerFor(format).listBlobs();  
import org.opensearch.common.blobstore.BlobContainer;
            // Skip the default format — already listed via baseContainer
    /**
        if (blobKey != null && format != null) {  
     * Useful during initialization when the set of formats is known from index settings.
 * <p>Blob containers are created lazily on first access via {@link #containerFor(String)},  
    }
     *  
     *
    }  
     * Returns the blob container for the given format.
    }  
    }
     * that have been accessed (lazily created). The returned map is unmodifiable.
     *
     *  
     * @param format the data format name (e.g., "parquet")  
        this.formatContainers = new ConcurrentHashMap<>();
        if (format != null && BASE_PATH_FORMATS.contains(format) == false) {  
 * Lucene files keep their historical {@code segments/data/} location so non-DFA code paths
        return formatContainers.computeIfAbsent(format, this::createFormatContainer);  
    private final BlobContainer baseContainer;  
     *  
     * @return map of blob name to metadata across all format containers
     * Returns the set of all format names that have been accessed (have containers).
    public FormatBlobRouter(BlobStore blobStore, BlobPath basePath) {
            var updated = new HashMap<>(blobFormatCache);
            blobFormatCache = Map.copyOf(updated);
        this.blobStore = blobStore;
        Map<String, BlobMetadata> all = new LinkedHashMap<>(baseContainer.listBlobs());
import org.opensearch.common.annotation.InternalApi;
 * so new formats can be added without restarting the directory.
            }  
     * @param basePath the base blob path for this shard's remote segment store
 * @opensearch.internal  
    /**
import org.opensearch.common.blobstore.BlobPath;
    }
import java.util.Set;  
     * created lazily on first access.  
     */  
/*  
     * @param blobKey the blob key to resolve  
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
    private BlobContainer createFormatContainer(String format) {  
 *
    public String resolveFormat(String blobKey) {  
        BlobPath formatPath = Objects.requireNonNull(basePath.parent()).add(format.toLowerCase(Locale.ROOT));  
@InternalApi
     *  
     * @return the base blob container
    /**
     *
     * (e.g., "parquet"). Used by download/delete operations where the caller only has a plain
import java.util.concurrent.ConcurrentHashMap;
     *  
     *
    /**
 * <pre>  
     */
    /**
     * @return the data format name, defaults to "lucene"
 */
import java.util.Objects;
            all.putAll(entry.getValue().listBlobs());
    }
     * Resolves the data format for a plain blob key using the reverse lookup cache.  
     * Removes a blob key from the reverse lookup cache.
    /**  
            }
    public void replaceBlobFormatCache(Map<String, String> blobKeyToFormat) {
     * Registers a blob key → format mapping in the reverse lookup cache.
 *
    public Set<String> registeredFormats() {  
     * @param blobKey the remote blob key (e.g., "_0.pqt__UUID")
     */
     * @param blobStore the blob store for creating containers
 * </pre>
     * Called after a successful upload so that subsequent download/delete operations
        blobFormatCache = Map.copyOf(blobKeyToFormat);
     */
        // formatPath = <repo>/<indexUUID>/<shard>/segments/<format>
     * Atomically replaces the entire blob format cache.
     * Lists all blobs across all known format containers.
package org.opensearch.index.store.remote;
 * <p><b>Remote store blob layout (namespacing):</b>
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
import java.util.LinkedHashSet;
        Set<String> formats = new LinkedHashSet<>();
 *   &lt;repo-base&gt;/&lt;index-uuid&gt;/&lt;shard&gt;/segments/parquet/    ← sibling of data/, keyed by format
     * <p>Volatile reference to immutable map for atomic swap in {@link #replaceBlobFormatCache(Map)}.
 *
    /**
    /**  
     *
     */
     * <p>Aggregates blobs from the base container and all format-specific containers
        // Pre-register the default format so containerFor("lucene") doesn't create a sub-path  
    private final ConcurrentHashMap<String, BlobContainer> formatContainers;
     */  
        }  
