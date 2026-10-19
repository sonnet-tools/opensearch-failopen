        private final long generation;
        }
        private static final Map<String, String> EMPTY_DIAGNOSTICS = Map.of();
            return 0;
     * @param segments        the current list of segments
     * @param mergePolicy the Lucene merge policy to delegate candidate selection to  
     * @return a list of segment groups, each group representing one merge operation
import java.util.HashMap;
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
        SegmentInfos segmentInfos = convertToSegmentInfos(segments, segmentMap);
                    Version.LATEST,
     * @param mergeSpecification the Lucene merge specification (may be {@code null})  
    private long calculateNumDocs(Segment segment) {
    public static class DataFormatMergeContext implements org.apache.lucene.index.MergePolicy.MergeContext {
    }  
        } catch (Exception e) {
            this.generation = segment.generation();
     * @param segments the current list of segments
        this.sharedDirectory = new ByteBuffersDirectory();  
        }  
        }
            this.totalSizeBytes = totalSizeBytes;
        @Override
        Map<SegmentCommitInfo, Segment> segmentMap = new HashMap<>();
    private long calculateTotalSize(Segment segment) {  
        org.apache.lucene.index.MergePolicy.MergeSpecification mergeSpecification,
     */
import java.util.Set;
    /**
    @Override
    }  
        return new SegmentWrapper(sharedDirectory, segment, calculateTotalSize(segment), calculateNumDocs(segment));  
            mergeContext.removeMergingSegment(createWrapper(segment));
        public int numDeletedDocs(SegmentCommitInfo segmentCommitInfo) {  
        public synchronized Set<SegmentCommitInfo> getMergingSegments() {
        }
                    "segment_" + segment.generation(),
                maxSegmentCount,
 * SPDX-License-Identifier: Apache-2.0
                    DUMMY_ID,
    }  
        @Override  
            return this.infoStream;  
        this.luceneMergePolicy = mergePolicy;
     * {@link Segment} instances using the reverse mapping.
import org.apache.lucene.index.SegmentInfos;  
     *
            throw new RuntimeException("Error finding merge candidates", e);
                    false,
 *
     *
        }
        public InfoStream getInfoStream() {
     * Registers segments as currently merging so the merge policy excludes them from future candidates.  
}
            segmentInfos.add(wrapper);
import org.apache.lucene.index.SegmentCommitInfo;
    private SegmentWrapper createWrapper(Segment segment) {
import org.apache.lucene.codecs.Codec;  
            );
                @Override
     * A {@link org.apache.lucene.index.MergePolicy.MergeContext} implementation that tracks merging segments
     * @param segments   the segments to convert
     * <p>
        }
 * <p>
    public List<List<Segment>> findMergeCandidates(List<Segment> segments) throws IOException {  
     * Creates a {@link SegmentWrapper} for the given segment.  
    }
     * and provides info-stream logging for the Lucene merge policy.  
     * @throws IOException if an I/O error occurs during candidate selection  
        private static final Map<String, String> EMPTY_ATTRIBUTES = Map.of();  
                public void close() throws IOException {}
import java.util.Objects;  
     */  
@ExperimentalApi
                }  
     * @param maxSegmentCount the target maximum number of segments after merging
 * @opensearch.experimental  
    private final DataFormatMergeContext mergeContext;
import org.opensearch.common.annotation.ExperimentalApi;
 * Adapts a Lucene {@link org.apache.lucene.index.MergePolicy} to work with the data-format-aware segment model.
     * @param shardId     the shard ID for logging context
                segmentInfos,
     */  
                public void message(String component, String message) {
                DUMMY_ID
     * Converts a list of {@link Segment} instances into a Lucene {@link SegmentInfos}
import org.opensearch.index.engine.exec.WriterFileSet;  
import org.apache.lucene.store.Directory;
    }  
    /**
                List<Segment> segmentMerge = new ArrayList<>();  
        this.logger = Loggers.getLogger(getClass(), shardId);
        List<List<Segment>> merges = new ArrayList<>();
 */
     * and populates the reverse mapping from wrapper to original segment.
    /**
     * @throws IOException if an I/O error occurs during candidate selection
     * Removes segments from the currently-merging set after a merge completes or fails.  
            return false;  
    private final Directory sharedDirectory;  
     * @return a list of segment groups, each representing one merge operation
                -1,
     * @param segments the segments to remove
    @Override
        @Override  
     *  
            return convertMergeSpecification(mergeSpec, segmentMap);
        Map<SegmentCommitInfo, Segment> segmentMap  
     *
    private List<List<Segment>> convertMergeSpecification(
        }  
     */
        segmentInfos.forEach(seg -> segmentsToMerge.put(seg, true));  
    }  
        return segment.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::getTotalSize).sum();
        private final InfoStream infoStream;
     *
    /**  
        SegmentInfos segmentInfos = new SegmentInfos(Version.LATEST.major);  
            return Set.copyOf(mergingSegments);
            org.apache.lucene.index.MergePolicy.MergeSpecification mergeSpec = luceneMergePolicy.findForcedMerges(  
        if (mergeSpecification != null) {
    private static class SegmentWrapper extends SegmentCommitInfo {  
        try {
            for (org.apache.lucene.index.MergePolicy.OneMerge merge : mergeSpecification.merges) {
            return convertMergeSpecification(mergeSpec, segmentMap);  
                    logger.debug(() -> new ParameterizedMessage("[DF_MERGE_POLICY] Merge [{}]: {}", component, message));
            );  
            mergingSegments.add(segment);  
     * Constructs a DataFormatAwareMergePolicy.
            return 0;  
    ) {
        private static final byte[] DUMMY_ID = new byte[16];
    @Override
 * compatible open source license.
                }  
            segmentMap.put(wrapper, segment);
        return segmentInfos;
 */  
                merges.add(segmentMerge);
                for (SegmentCommitInfo segment : merge.segments) {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.engine.dataformat.merge;
     *  
import org.apache.lucene.util.Version;
                return generation == other.generation;
                    EMPTY_ATTRIBUTES,  
import java.io.IOException;
                -1,  
            logger.error("Error finding merge candidates", e);  
     * @return a list of segment groups, each group representing one merge operation  
        }
import org.opensearch.index.engine.exec.Segment;
            super(  
                new org.apache.lucene.index.SegmentInfo(
     *
import org.apache.logging.log4j.Logger;
     * size and doc-count information to the underlying merge policy.
                public boolean isEnabled(String component) {  
        synchronized void addMergingSegment(SegmentCommitInfo segment) {
    private final Logger logger;
        }
        }
                ),
     * Lucene {@link SegmentCommitInfo} wrapper that exposes segment  
            return totalSizeBytes;
            return 0;
                    false,
            throw new RuntimeException("Error finding force merge candidates", e);  
        Map<SegmentCommitInfo, Segment> segmentMap = new HashMap<>();
    }
public class DataFormatAwareMergePolicy implements MergeHandler.MergePolicy, MergeHandler.MergeListener {  
     */
     * @return the Lucene segment infos  
                    (int) Math.min(totalNumDocs, Integer.MAX_VALUE),  
     * @param segmentMap         the wrapper → original segment mapping
        private final long totalSizeBytes;  
import org.opensearch.core.index.shard.ShardId;
    }
            this.infoStream = new InfoStream() {
    public void removeMergingSegment(Collection<Segment> segments) {
        return merges;
                0,  
        @Override  
                }
        for (Segment segment : segments) {  
            return Objects.hashCode(generation);
            SegmentWrapper wrapper = createWrapper(segment);  
                segmentInfos,
                MergeTrigger.COMMIT,  
    /**  
        return segment.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::numRows).findFirst().orElse(0L);  
                    directory,
        public long sizeInBytes() {  
        @Override  
                mergeContext
     */  
     */
    /**
        this.mergeContext = new DataFormatMergeContext(logger);
        try {
    }
        public int hashCode() {
        for (Segment segment : segments) {  
    public void addMergingSegment(Collection<Segment> segments) {
 * wrappers so the underlying merge policy can select merge candidates.
            if (this == o) return true;
     * @return a Lucene-compatible {@link SegmentCommitInfo} wrapper  
                    segmentMerge.add(segmentMap.get(segment));
        }  
/**  
        SegmentInfos segmentInfos = convertToSegmentInfos(segments, segmentMap);  
import java.util.HashSet;  
import org.apache.lucene.store.ByteBuffersDirectory;
        @Override
                    null
     * from the same {@link Segment} are equal.
     *
        }  
    private final org.apache.lucene.index.MergePolicy luceneMergePolicy;
    /**
    public List<List<Segment>> findForceMergeCandidates(List<Segment> segments, int maxSegmentCount) throws IOException {
import java.util.Collection;
            };  
        }
     */  
                0,
     * @opensearch.experimental
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
/*  
 *
            );  
    }  
                    Version.LATEST,  
            mergingSegments.remove(segment);
    private SegmentInfos convertToSegmentInfos(List<Segment> segments, Map<SegmentCommitInfo, Segment> segmentMap) {
        public int getDelCount() {
    /**
        @Override
    /**
        Map<SegmentCommitInfo, Boolean> segmentsToMerge = new HashMap<>();
    @Override  
import org.apache.lucene.util.InfoStream;  
     * Identity is based on segment generation so that wrappers created  
            if (o instanceof SegmentWrapper other) {  
    }
                    EMPTY_DIAGNOSTICS,
     * Converts a Lucene {@link org.apache.lucene.index.MergePolicy.MergeSpecification} back into groups of  
                    Codec.getDefault(),  
            }
        public boolean equals(Object o) {
    /**
                segmentsToMerge,  
        @Override
                    return logger.isDebugEnabled();
    }
        synchronized void removeMergingSegment(SegmentCommitInfo segment) {  
import java.util.List;
     */
        }
                @Override  
            logger.error("Error finding force merge candidates", e);
import org.apache.lucene.index.MergeTrigger;
            }
import java.util.ArrayList;  
 * Converts {@link Segment} instances into Lucene {@link SegmentCommitInfo}  
            org.apache.lucene.index.MergePolicy.MergeSpecification mergeSpec = luceneMergePolicy.findMerges(
     * Finds merge candidates from the given segments using the configured Lucene merge policy.
        public DataFormatMergeContext(Logger logger) {
            mergeContext.addMergingSegment(createWrapper(segment));
     * @param segments the segments being merged
        }
    public DataFormatAwareMergePolicy(org.apache.lucene.index.MergePolicy mergePolicy, ShardId shardId) {  
     */
        }  
import org.opensearch.common.logging.Loggers;  
     * Finds force-merge candidates from the given segments, targeting the specified maximum segment count.
                0,
     * @param segmentMap populated with wrapper → original segment mappings
        public SegmentWrapper(Directory directory, Segment segment, long totalSizeBytes, long totalNumDocs) {
                @Override
     * @param segment the segment to wrap
        public int numDeletesToMerge(SegmentCommitInfo segmentCommitInfo) throws IOException {
        for (Segment segment : segments) {
        }  
     *  
        } catch (Exception e) {
                mergeContext
    @ExperimentalApi
        private final HashSet<SegmentCommitInfo> mergingSegments = new HashSet<>();
