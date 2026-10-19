import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
import org.opensearch.common.CheckedBiFunction;  
        this.readers = readers;
     * @param reader         DirectoryReader whose leaves' generations are the actual set
     */
     * {@link org.opensearch.be.lucene.index.LuceneWriter#WRITER_GENERATION_ATTRIBUTE} stamped
 * this file be licensed under the Apache-2.0 license or a
        return counts;
        }
            initialWrappedReader.decRef();
            }  
 * to {@link LuceneReader} so each snapshot gets the reader that was current
 * Lucene implementation of {@link EngineReaderManager}.  
    public void onFilesDeleted(Collection<String> files) throws IOException {
    public Map<Long, DocCounts> docCountsByGeneration(CatalogSnapshot catalogSnapshot) throws IOException {
        // Index leaves by writer generation → segment name.  
        Collection<Long> generationsReferenced = catalogSnapshot.getSegments().stream().map(Segment::generation).sorted().toList();
        for (Segment seg : catalogSnapshot.getSegments()) {
 * {@link LiveDocsSource}.
    private volatile DirectoryReader currentReader;
    public void onDeleted(CatalogSnapshot catalogSnapshot) throws IOException {
        }
import org.apache.logging.log4j.LogManager;
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
    }  
    private final DataFormat dataFormat;
     * Creates a new LuceneReaderManager.
            SegmentCommitInfo sci = segmentReader.getSegmentInfo();
            SegmentReader sr = (SegmentReader) lrc.reader();  
    public void beforeRefresh() throws IOException {
 *
    private static Map<Long, String> buildGenerationToSegmentName(CatalogSnapshot catalogSnapshot, List<LeafReaderContext> leaves) {
        assert OpenSearchDirectoryReader.unwrap(currentWrappedReader) == currentReader;
     * @param readerRefresher function that opens a refreshed reader given the current reader and new
        }  
        // Catches refresh/merge-apply races where the refreshed reader's leaves disagree
    }
 * <p>  
            }
    private final Map<Long, LuceneReader> readers;
            if (segName == null) {
 */
 * compatible open source license.
        ShardId shardId
import org.apache.lucene.index.SegmentCommitInfo;
    /**  
     * from both {@link #close()} and {@link #onDeleted(CatalogSnapshot)}.
                continue;  
     *
    }
    @Override  
    @Override  
import org.opensearch.index.engine.dataformat.DataFormat;  
        return reader.leaves().stream().map(lrc -> {  
        if (reader != null) {
     *
    private volatile DirectoryReader currentWrappedReader;  
     * @param readers         shared map of generation to DirectoryReader for segment-level reader reuse  
     */  
     */
                        + generationToLeafSegment.keySet()  
    }
            currentWrappedReader = OpenSearchDirectoryReader.wrap(currentReader, shardId);
        Map<Long, LuceneReader> readers,  
        LuceneReader reader = readers.get(catalogSnapshot.getId());
    }
        // with the catalog snapshot being registered.  
        this.currentWrappedReader = wrapped;  
    private final CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> readerRefresher;
        }  
    public LuceneReader getReader(CatalogSnapshot catalogSnapshot) throws IOException {
import org.opensearch.index.engine.exec.WriterFileSet;
     * with the wrong catalog snapshot.
    }
 * Constructed with a {@link DataFormat} and an initial {@link DirectoryReader}
        if (reader == null) {  
        }
     * Releases the initial wrapped reader's creation ref. Idempotent — safe to invoke  
public class LuceneReaderManager implements EngineReaderManager<LuceneReader>, LiveDocsSource {
        }
            if (genAttr == null) {
     *                               its value is not parseable as a long (indicates a segment
    private boolean readersAreSame(CatalogSnapshot catalogSnapshot, DirectoryReader reader) {
import java.io.IOException;
            currentReader = refreshed;
     *  
     * onto every Lucene segment at write time).  
            throw new IllegalStateException("No reader available for catalog snapshot [version=" + catalogSnapshot.getId() + "]");
        }).sorted().toList();
    }
@ExperimentalApi  
        return reader;  
    @Override
        Map<Long, DocCounts> counts = new HashMap<>(leaves.size());  
        this.dataFormat = dataFormat;
    @Override
        for (LeafReaderContext lrc : leaves) {
/*  
            counts.put(Long.parseLong(genAttr), new DocCounts(lrc.reader().numDocs(), lrc.reader().numDeletedDocs()));
            SegmentCommitInfo sci = sr.getSegmentInfo();
        if (didRefresh == false || readers.containsKey(catalogSnapshot.getId())) {
        for (LeafReaderContext lrc : leaves) {
     * @param dataFormat      the data format this reader manager serves
 * {@code writer_generation → leaf index} map built by matching the catalog's
        }
            reader.directoryReader().decRef();
                    "Lucene leaf segment=" + sci.info.name + " is missing the " + WRITER_GENERATION_ATTRIBUTE + " attribute"
     * <p>Used only in an {@code assert} to catch refresh/catalog drift in test builds — if
        DataFormat dataFormat,
     * Reads live and deleted counts straight off the reader registered for this snapshot.
    ) throws IOException {  
     *                               not produced by {@link org.opensearch.be.lucene.index.LuceneWriter})
            SegmentReader segmentReader = (SegmentReader) lrc.reader();
import org.apache.lucene.index.SegmentReader;
     * segment is written; parsing that attribute yields the generation that produced the leaf.
     */
            if (wfs == null) {  
import org.apache.lucene.index.DirectoryReader;  
        Map<Long, String> out = new HashMap<>();  
    }
     * @param reader the DirectoryReader to inspect
        }
    public LuceneReaderManager(  
        if (reader == null) {  
                continue;
     *  
            generationToLeafSegment.put(Long.parseLong(genAttr), sci.info.name);
                throw new IllegalStateException(
     * Extracts the writer generation from each leaf of the given {@link DirectoryReader} and
            // Same reader reused — incRef for this snapshot.
        this.readerRefresher = readerRefresher;  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
}  
     * @param shardId         shard id for wrapping readers with OpenSearchDirectoryReader  
import org.opensearch.common.SuppressForbidden;
            // no live doc reader fallback to all the docs marked as live docs
import org.opensearch.index.engine.exec.LiveDocsSource;  
 * at the time of its refresh. On each {@link #afterRefresh}, the current reader is
import org.opensearch.core.index.shard.ShardId;
     * list of writer generations drawn from the snapshot's {@link Segment Segments} against  
                throw new IllegalStateException(
    private volatile DirectoryReader initialWrappedReader;
            }
        return generationsReferenced.equals(collectReferencedGenerations(reader));  
        DirectoryReader initialReader,
        Objects.requireNonNull(initialReader, "initialReader must not be null");  
        }  
            readerForSnapshot = currentWrappedReader;
        if (initialWrappedReader != null) {
import java.util.Map;  
 * Lucene is where a shard records which rows are still reachable(live docs), so this manager is also a
     * the sorted list of writer generations read off each leaf of the reader (via the
 * refreshed via {@link DirectoryReader#openIfChanged} and paired with a  
import org.apache.lucene.index.SegmentInfos;  
        this.currentReader = initialReader;
import java.util.HashMap;
    /**  
     * @param initialReader   the initial DirectoryReader, must not be null
            // New wrapper — its creation ref (refCount=1) serves as the snapshot's ref.  
        releaseInitialReader();
        assert readersAreSame(catalogSnapshot, currentReader);
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;  
     *                        {@link SegmentInfos}; returns {@code null} if no refresh is needed
        LuceneReader reader = readers.get(catalogSnapshot.getId());
            SegmentCommitInfo sci = Lucene.segmentReader(lrc.reader()).getSegmentInfo();
 * The OpenSearch Contributors require contributions made to  
        // no-op  
                        + ")"
        for (LuceneReader reader : readers.values()) {
            logger.warn("No reader registered for catalog snapshot [version={}]; reporting no counts", catalogSnapshot.getId());
            return Map.of();  
    /**
 * {@link WriterFileSet#files()} against each leaf's {@code SegmentCommitInfo.files()}.
        Map<Long, String> generationToSegmentName = buildGenerationToSegmentName(catalogSnapshot, currentReader.leaves());
import org.opensearch.common.annotation.ExperimentalApi;
     * this ever returns {@code false} in production, it means a Lucene reader has been paired  
 * @opensearch.experimental
            return;  
    }
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);  
        DirectoryReader wrapped = OpenSearchDirectoryReader.wrap(initialReader, shardId);
import org.apache.logging.log4j.Logger;
import org.opensearch.index.engine.exec.Segment;
    @Override  
import org.opensearch.index.engine.exec.DocCounts;
        releaseInitialReader();
     * returns them as a sorted list. Each leaf's {@link SegmentReader} carries a
     */
import org.apache.lucene.index.LeafReaderContext;
     * Consistency check: verifies that the refreshed {@link DirectoryReader} reflects exactly
     * @throws NumberFormatException if a leaf is missing the writer-generation attribute or  
            readerForSnapshot = currentWrappedReader;  
                    "Catalog segment gen="  
    }
        CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> readerRefresher,
package org.opensearch.be.lucene;
     * @throws NullPointerException if initialReader or shardId is null
    @Override
import org.opensearch.index.engine.exec.EngineReaderManager;
     * the set of segments the given {@link CatalogSnapshot} references. Compares the sorted
 * <p>
        } else {  
                        + seg.generation()
     * {@link SegmentCommitInfo} whose {@code SegmentInfo} is stamped with the  
            initialWrappedReader = null;  
        if (refreshed != null) {
        Map<Long, String> generationToLeafSegment = new HashMap<>(leaves.size());
import org.opensearch.common.lucene.Lucene;  
                );  
        this.initialWrappedReader = wrapped;
        List<LeafReaderContext> leaves = reader.directoryReader().leaves();
        return out;  
 * (typically opened from an IndexWriter). Maintains a map of {@link CatalogSnapshot}  
        DirectoryReader readerForSnapshot;  
    /**
        readers.put(catalogSnapshot.getId(), new LuceneReader(readerForSnapshot, generationToSegmentName));
        LuceneReader reader = readers.remove(catalogSnapshot.getId());  
        readers.clear();
            out.put(seg.generation(), segName);
                        + " has no matching Lucene leaf (leaf generations="
        this.shardId = Objects.requireNonNull(shardId, "shardId must not be null");
/**
    }  
        // no-op  
            return Long.parseLong(sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE));  
import java.util.Objects;
     * @return {@code true} iff both lists contain the same generations in the same (sorted) order
    /**  
 * SPDX-License-Identifier: Apache-2.0
        }  
@SuppressForbidden(reason = "reference counting is required here")
     * @param catalogSnapshot catalog snapshot whose referenced generations are the expected set  
     * @throws ClassCastException    if any leaf reader is not a {@link SegmentReader}  
                // Not written by LuceneWriter, so it cannot be attributed to a catalog generation.
    private static final Logger logger = LogManager.getLogger(LuceneReaderManager.class);  
    public void onFilesAdded(Collection<String> files) throws IOException {
            reader.directoryReader().decRef();
 *  
    }  
     * @return generations of all leaves, sorted ascending
    private Collection<Long> collectReferencedGenerations(DirectoryReader reader) {
            currentWrappedReader.incRef();
    public void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) throws IOException {
 */  
     * {@link org.opensearch.be.lucene.index.LuceneWriter#WRITER_GENERATION_ATTRIBUTE} when the
    @Override  
        DirectoryReader refreshed = readerRefresher.apply(currentReader, LuceneReplicaCommitter.getSegmentInfos(catalogSnapshot));
    private void releaseInitialReader() throws IOException {  
import java.util.Collection;  
            }
            if (genAttr == null) {  
            WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(LuceneDataFormat.LUCENE_FORMAT_NAME);
    public void close() throws IOException {  
                );
    @Override
    private final ShardId shardId;  
import java.util.List;
    }
import org.opensearch.be.lucene.index.LuceneReplicaCommitter;
        // no-op
        // Resolve each catalog segment carrying Lucene data to its leaf's segment name by generation.
            String segName = generationToLeafSegment.get(seg.generation());  
