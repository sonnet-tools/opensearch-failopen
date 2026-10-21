import org.opensearch.index.engine.exec.EngineReaderManager;
    }
import org.apache.lucene.index.DirectoryReader;
     * list of writer generations drawn from the snapshot's {@link Segment Segments} against
import org.opensearch.common.SuppressForbidden;
            if (wfs == null) {
        LuceneReader reader = readers.remove(catalogSnapshot.getId());
     *                        {@link SegmentInfos}; returns {@code null} if no refresh is needed
                );
    public void close() throws IOException {
        for (LeafReaderContext lrc : leaves) {
                        + seg.generation()
     * <p>Used only in an {@code assert} to catch refresh/catalog drift in test builds — if
    }
     * onto every Lucene segment at write time).
        DirectoryReader refreshed = readerRefresher.apply(currentReader, LuceneReplicaCommitter.getSegmentInfos(catalogSnapshot));
        Map<Long, String> generationToSegmentName = buildGenerationToSegmentName(catalogSnapshot, currentReader.leaves());
 * Lucene implementation of {@link EngineReaderManager}.
        return reader.leaves().stream().map(lrc -> {
        if (refreshed != null) {
import org.opensearch.index.engine.dataformat.DataFormat;
    public void onDeleted(CatalogSnapshot catalogSnapshot) throws IOException {
    private final CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> readerRefresher;
        // no-op
    public void beforeRefresh() throws IOException {
     */
 * compatible open source license.
     * @param shardId         shard id for wrapping readers with OpenSearchDirectoryReader
            initialWrappedReader = null;
     *
     * @param readerRefresher function that opens a refreshed reader given the current reader and new
     * @param dataFormat      the data format this reader manager serves
     */
        LuceneReader reader = readers.get(catalogSnapshot.getId());
    }
        DirectoryReader readerForSnapshot;
        // Resolve each catalog segment carrying Lucene data to its leaf's segment name by generation.
    /**
     * Consistency check: verifies that the refreshed {@link DirectoryReader} reflects exactly
     * @return generations of all leaves, sorted ascending
        ShardId shardId
        }
        assert OpenSearchDirectoryReader.unwrap(currentWrappedReader) == currentReader;
        assert readersAreSame(catalogSnapshot, currentReader);
        releaseInitialReader();
import java.util.HashMap;
        this.readers = readers;
     *
 * <p>
            out.put(seg.generation(), segName);
     * with the wrong catalog snapshot.
            String segName = generationToLeafSegment.get(seg.generation());
        }
    @Override
        Map<Long, DocCounts> counts = new HashMap<>(leaves.size());
            }
            WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
        Objects.requireNonNull(initialReader, "initialReader must not be null");
package org.opensearch.be.lucene;
        DirectoryReader initialReader,
        Collection<Long> generationsReferenced = catalogSnapshot.getSegments().stream().map(Segment::generation).sorted().toList();
    ) throws IOException {
 * Lucene is where a shard records which rows are still reachable(live docs), so this manager is also a
    public LuceneReader getReader(CatalogSnapshot catalogSnapshot) throws IOException {
import org.opensearch.common.annotation.ExperimentalApi;
    private volatile DirectoryReader currentReader;
     * @throws ClassCastException    if any leaf reader is not a {@link SegmentReader}
import org.opensearch.index.engine.exec.WriterFileSet;
            readerForSnapshot = currentWrappedReader;
    @Override
     * Reads live and deleted counts straight off the reader registered for this snapshot.
    @Override
                        + ")"
    @Override
        Map<Long, LuceneReader> readers,
                        + generationToLeafSegment.keySet()
        }
        }
     * returns them as a sorted list. Each leaf's {@link SegmentReader} carries a
        readers.put(catalogSnapshot.getId(), new LuceneReader(readerForSnapshot, generationToSegmentName));
            SegmentReader segmentReader = (SegmentReader) lrc.reader();
@SuppressForbidden(reason = "reference counting is required here")
                );
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
     * @param readers         shared map of generation to DirectoryReader for segment-level reader reuse
                // Not written by LuceneWriter, so it cannot be attributed to a catalog generation.
        }
    private final DataFormat dataFormat;
    @Override
    }
import org.apache.logging.log4j.Logger;
            counts.put(Long.parseLong(genAttr), new DocCounts(lrc.reader().numDocs(), lrc.reader().numDeletedDocs()));
        return reader;
    public LuceneReaderManager(
    }
     * {@link org.opensearch.be.lucene.index.LuceneWriter#WRITER_GENERATION_ATTRIBUTE} when the
/**
        // no-op
                continue;
        }
            // Same reader reused — incRef for this snapshot.
        readers.clear();
    @Override
        this.dataFormat = dataFormat;
     * @throws NumberFormatException if a leaf is missing the writer-generation attribute or
        }).sorted().toList();
        this.initialWrappedReader = wrapped;
     */
    @Override
            generationToLeafSegment.put(Long.parseLong(genAttr), sci.info.name);
import java.util.Objects;
import org.opensearch.index.engine.exec.LiveDocsSource;
import org.opensearch.core.index.shard.ShardId;
        this.readerRefresher = readerRefresher;
        }
     * segment is written; parsing that attribute yields the generation that produced the leaf.
        // no-op
 * The OpenSearch Contributors require contributions made to
     * the sorted list of writer generations read off each leaf of the reader (via the
        Map<Long, String> generationToLeafSegment = new HashMap<>(leaves.size());
            return Map.of();
     * Creates a new LuceneReaderManager.
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
        this.currentWrappedReader = wrapped;
            return Long.parseLong(sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE));
import org.apache.lucene.index.LeafReaderContext;
        List<LeafReaderContext> leaves = reader.directoryReader().leaves();
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;
    private volatile DirectoryReader initialWrappedReader;
import org.opensearch.common.lucene.Lucene;
 * at the time of its refresh. On each {@link #afterRefresh}, the current reader is
     *                               not produced by {@link org.opensearch.be.lucene.index.LuceneWriter})
            initialWrappedReader.decRef();
     * Extracts the writer generation from each leaf of the given {@link DirectoryReader} and
    }
import org.opensearch.common.CheckedBiFunction;
            if (genAttr == null) {
    private static final Logger logger = LogManager.getLogger(LuceneReaderManager.class);
@ExperimentalApi
     * @param catalogSnapshot catalog snapshot whose referenced generations are the expected set
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * {@link WriterFileSet#files()} against each leaf's {@code SegmentCommitInfo.files()}.
                throw new IllegalStateException(
                continue;
            reader.directoryReader().decRef();
            currentReader = refreshed;
    @Override
                    "Catalog segment gen="
    /**
     *                               its value is not parseable as a long (indicates a segment
        DirectoryReader wrapped = OpenSearchDirectoryReader.wrap(initialReader, shardId);
 *
    private final Map<Long, LuceneReader> readers;
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
     * @param initialReader   the initial DirectoryReader, must not be null
 */
            }
        }
        return out;
        } else {
        LuceneReader reader = readers.get(catalogSnapshot.getId());
 * Constructed with a {@link DataFormat} and an initial {@link DirectoryReader}
        for (Segment seg : catalogSnapshot.getSegments()) {
import org.opensearch.index.engine.exec.Segment;
}
                    "Lucene leaf segment=" + sci.info.name + " is missing the " + WRITER_GENERATION_ATTRIBUTE + " attribute"
            logger.warn("No reader registered for catalog snapshot [version={}]; reporting no counts", catalogSnapshot.getId());
import java.util.Map;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        // Index leaves by writer generation → segment name.
            }
import org.apache.lucene.index.SegmentReader;
            currentWrappedReader.incRef();
            currentWrappedReader = OpenSearchDirectoryReader.wrap(currentReader, shardId);
 */
    /**
    public void onFilesAdded(Collection<String> files) throws IOException {
        releaseInitialReader();
        this.currentReader = initialReader;
 * to {@link LuceneReader} so each snapshot gets the reader that was current
import org.opensearch.index.engine.exec.DocCounts;
import org.apache.lucene.index.SegmentInfos;
    public void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) throws IOException {
import org.apache.lucene.index.SegmentCommitInfo;
    }
        if (reader != null) {
                throw new IllegalStateException(
        if (reader == null) {
     * @param reader the DirectoryReader to inspect
            SegmentCommitInfo sci = segmentReader.getSegmentInfo();
    }
        // Catches refresh/merge-apply races where the refreshed reader's leaves disagree
        }
        if (didRefresh == false || readers.containsKey(catalogSnapshot.getId())) {
 * refreshed via {@link DirectoryReader#openIfChanged} and paired with a
        }
 * (typically opened from an IndexWriter). Maintains a map of {@link CatalogSnapshot}
 * {@code writer_generation → leaf index} map built by matching the catalog's
        return counts;
 * <p>
    private boolean readersAreSame(CatalogSnapshot catalogSnapshot, DirectoryReader reader) {
        DataFormat dataFormat,
            readerForSnapshot = currentWrappedReader;
    }
    private final ShardId shardId;
    /**
            if (segName == null) {
 * @opensearch.experimental
    private static Map<Long, String> buildGenerationToSegmentName(CatalogSnapshot catalogSnapshot, List<LeafReaderContext> leaves) {
 * SPDX-License-Identifier: Apache-2.0
        if (initialWrappedReader != null) {
     *
        Map<Long, String> out = new HashMap<>();
    private Collection<Long> collectReferencedGenerations(DirectoryReader reader) {
public class LuceneReaderManager implements EngineReaderManager<LuceneReader>, LiveDocsSource {
        return generationsReferenced.equals(collectReferencedGenerations(reader));
import java.util.List;
    public Map<Long, DocCounts> docCountsByGeneration(CatalogSnapshot catalogSnapshot) throws IOException {
            // New wrapper — its creation ref (refCount=1) serves as the snapshot's ref.
        CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> readerRefresher,
     * @return {@code true} iff both lists contain the same generations in the same (sorted) order
    }
            return;
import java.util.Collection;
     */
import org.opensearch.be.lucene.index.LuceneReplicaCommitter;
            // no live doc reader fallback to all the docs marked as live docs
    }
     * @throws NullPointerException if initialReader or shardId is null
 *
            SegmentCommitInfo sci = sr.getSegmentInfo();
        // with the catalog snapshot being registered.
     */
            throw new IllegalStateException("No reader available for catalog snapshot [version=" + catalogSnapshot.getId() + "]");
    public void onFilesDeleted(Collection<String> files) throws IOException {
            reader.directoryReader().decRef();
                        + " has no matching Lucene leaf (leaf generations="
            }
     * {@link org.opensearch.be.lucene.index.LuceneWriter#WRITER_GENERATION_ATTRIBUTE} stamped
            SegmentReader sr = (SegmentReader) lrc.reader();
        if (reader == null) {
    }
        this.shardId = Objects.requireNonNull(shardId, "shardId must not be null");
 * {@link LiveDocsSource}.
     * @param reader         DirectoryReader whose leaves' generations are the actual set
     * this ever returns {@code false} in production, it means a Lucene reader has been paired
    /**
    private volatile DirectoryReader currentWrappedReader;
     *
     * Releases the initial wrapped reader's creation ref. Idempotent — safe to invoke
    private void releaseInitialReader() throws IOException {
/*
import org.apache.logging.log4j.LogManager;
        for (LuceneReader reader : readers.values()) {
            if (genAttr == null) {
     * from both {@link #close()} and {@link #onDeleted(CatalogSnapshot)}.
     * {@link SegmentCommitInfo} whose {@code SegmentInfo} is stamped with the
        for (LeafReaderContext lrc : leaves) {
     * the set of segments the given {@link CatalogSnapshot} references. Compares the sorted
    }
            SegmentCommitInfo sci = Lucene.segmentReader(lrc.reader()).getSegmentInfo();
