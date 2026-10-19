     *
            return false;
     *
                }
                public void message(String component, String message) {
    private List<List<Segment>> convertMergeSpecification(
        }
                DUMMY_ID
    }
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.Map;
     *
        return segment.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::numRows).findFirst().orElse(0L);
        }
     *
    /**
 * SPDX-License-Identifier: Apache-2.0
            }
        return segment.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::getTotalSize).sum();
                public void close() throws IOException {}
    private SegmentWrapper createWrapper(Segment segment) {
            segmentInfos.add(wrapper);
                    logger.debug(() -> new ParameterizedMessage("[DF_MERGE_POLICY] Merge [{}]: {}", component, message));
                0,
 * <p>
     * Registers segments as currently merging so the merge policy excludes them from future candidates.
 * @opensearch.experimental
     * and populates the reverse mapping from wrapper to original segment.
 * compatible open source license.
        }
    }
     * Converts a Lucene {@link org.apache.lucene.index.MergePolicy.MergeSpecification} back into groups of
     * Converts a list of {@link Segment} instances into a Lucene {@link SegmentInfos}
        for (Segment segment : segments) {
                return generation == other.generation;
                mergeContext
     * and provides info-stream logging for the Lucene merge policy.
                    Version.LATEST,
            return 0;
            super(
     *
            return Set.copyOf(mergingSegments);
import org.opensearch.common.logging.Loggers;
            this.totalSizeBytes = totalSizeBytes;
        }
import java.util.Collection;
    @ExperimentalApi
import java.util.Objects;
        public int numDeletesToMerge(SegmentCommitInfo segmentCommitInfo) throws IOException {
    private SegmentInfos convertToSegmentInfos(List<Segment> segments, Map<SegmentCommitInfo, Segment> segmentMap) {
     * @param segments   the segments to convert
        this.mergeContext = new DataFormatMergeContext(logger);
    }
     */
        public int numDeletedDocs(SegmentCommitInfo segmentCommitInfo) {
        try {
        private static final Map<String, String> EMPTY_ATTRIBUTES = Map.of();
     *
import org.apache.lucene.util.Version;
    private final org.apache.lucene.index.MergePolicy luceneMergePolicy;
import org.opensearch.index.engine.exec.Segment;
     */
                    EMPTY_ATTRIBUTES,
        private final long totalSizeBytes;
import java.io.IOException;
 */
        } catch (Exception e) {
        @Override
    /**
            SegmentWrapper wrapper = createWrapper(segment);
    }
                -1,
    private final DataFormatMergeContext mergeContext;
     * @param segment the segment to wrap
        }
import org.apache.lucene.index.MergeTrigger;
                ),
@ExperimentalApi
     * @opensearch.experimental
     * @param shardId     the shard ID for logging context
     * @param segments the current list of segments
 *
                    (int) Math.min(totalNumDocs, Integer.MAX_VALUE),
            return this.infoStream;
            this.infoStream = new InfoStream() {
    @Override
            mergingSegments.add(segment);
        Map<SegmentCommitInfo, Segment> segmentMap
     */
        Map<SegmentCommitInfo, Boolean> segmentsToMerge = new HashMap<>();
import org.apache.lucene.index.SegmentInfos;
    public List<List<Segment>> findForceMergeCandidates(List<Segment> segments, int maxSegmentCount) throws IOException {
        private static final Map<String, String> EMPTY_DIAGNOSTICS = Map.of();
                    null
    /**
import org.apache.lucene.index.SegmentCommitInfo;
import java.util.List;
        private final InfoStream infoStream;
     * Lucene {@link SegmentCommitInfo} wrapper that exposes segment
                @Override
     */
     * Identity is based on segment generation so that wrappers created
        this.luceneMergePolicy = mergePolicy;
            };
                for (SegmentCommitInfo segment : merge.segments) {
     * size and doc-count information to the underlying merge policy.
     * @param segments the segments to remove
                mergeContext
        }
                0,
    }
        if (mergeSpecification != null) {
     * Creates a {@link SegmentWrapper} for the given segment.
                    directory,
     */
 * wrappers so the underlying merge policy can select merge candidates.
                @Override
            return totalSizeBytes;
        }
    ) {
            throw new RuntimeException("Error finding force merge candidates", e);
        }
        @Override
        List<List<Segment>> merges = new ArrayList<>();
        public long sizeInBytes() {
        SegmentInfos segmentInfos = new SegmentInfos(Version.LATEST.major);
     */
            if (o instanceof SegmentWrapper other) {
     * @param segments        the current list of segments
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if an I/O error occurs during candidate selection
     * <p>
import org.apache.logging.log4j.message.ParameterizedMessage;
        Map<SegmentCommitInfo, Segment> segmentMap = new HashMap<>();
        public DataFormatMergeContext(Logger logger) {
     * @return a Lucene-compatible {@link SegmentCommitInfo} wrapper
                0,
     *
    private final Directory sharedDirectory;
     * @return a list of segment groups, each representing one merge operation
 *
        }
        }
     * @throws IOException if an I/O error occurs during candidate selection
import org.apache.lucene.codecs.Codec;
    }
        this.logger = Loggers.getLogger(getClass(), shardId);
    public static class DataFormatMergeContext implements org.apache.lucene.index.MergePolicy.MergeContext {
import java.util.Set;
    /**
                    Codec.getDefault(),
    }
    @Override
        public SegmentWrapper(Directory directory, Segment segment, long totalSizeBytes, long totalNumDocs) {
    /**
        } catch (Exception e) {
            logger.error("Error finding force merge candidates", e);
     * @param segmentMap populated with wrapper → original segment mappings
        return merges;
public class DataFormatAwareMergePolicy implements MergeHandler.MergePolicy, MergeHandler.MergeListener {
        }
     *
import java.util.HashSet;
     * @param mergePolicy the Lucene merge policy to delegate candidate selection to
            for (org.apache.lucene.index.MergePolicy.OneMerge merge : mergeSpecification.merges) {
 * Adapts a Lucene {@link org.apache.lucene.index.MergePolicy} to work with the data-format-aware segment model.
    public List<List<Segment>> findMergeCandidates(List<Segment> segments) throws IOException {
    public void addMergingSegment(Collection<Segment> segments) {
                    DUMMY_ID,
    public void removeMergingSegment(Collection<Segment> segments) {
                segmentInfos,
import java.util.HashMap;
            return 0;
        }
            org.apache.lucene.index.MergePolicy.MergeSpecification mergeSpec = luceneMergePolicy.findForcedMerges(
        @Override
import org.apache.lucene.store.Directory;
     * from the same {@link Segment} are equal.
        this.sharedDirectory = new ByteBuffersDirectory();
     * @param segments the segments being merged
            this.generation = segment.generation();
     * Finds force-merge candidates from the given segments, targeting the specified maximum segment count.
            return 0;
        public int getDelCount() {
        @Override
    }
import org.apache.lucene.store.ByteBuffersDirectory;
        public int hashCode() {
    /**
}
                    segmentMerge.add(segmentMap.get(segment));
     */
import org.opensearch.core.index.shard.ShardId;
    public DataFormatAwareMergePolicy(org.apache.lucene.index.MergePolicy mergePolicy, ShardId shardId) {
        @Override
     * @return the Lucene segment infos
     * Finds merge candidates from the given segments using the configured Lucene merge policy.
        @Override
     * Constructs a DataFormatAwareMergePolicy.
        @Override
            logger.error("Error finding merge candidates", e);
     *
            mergeContext.removeMergingSegment(createWrapper(segment));
        public InfoStream getInfoStream() {
        private final long generation;
        }
            org.apache.lucene.index.MergePolicy.MergeSpecification mergeSpec = luceneMergePolicy.findMerges(
        synchronized void removeMergingSegment(SegmentCommitInfo segment) {
                    return logger.isDebugEnabled();
     */
                    false,
        synchronized void addMergingSegment(SegmentCommitInfo segment) {
            throw new RuntimeException("Error finding merge candidates", e);
     * @param mergeSpecification the Lucene merge specification (may be {@code null})
                    false,
                    Version.LATEST,
import org.apache.logging.log4j.Logger;
import org.opensearch.index.engine.exec.WriterFileSet;
 * The OpenSearch Contributors require contributions made to
    /**
                merges.add(segmentMerge);
        }
    @Override
        for (Segment segment : segments) {
                maxSegmentCount,
                new org.apache.lucene.index.SegmentInfo(
/**
    private final Logger logger;
     */
/*
    }
                segmentsToMerge,
     * {@link Segment} instances using the reverse mapping.
        }
        }
     * @param maxSegmentCount the target maximum number of segments after merging
            );
            );
                -1,
        private final HashSet<SegmentCommitInfo> mergingSegments = new HashSet<>();
     * @return a list of segment groups, each group representing one merge operation
    @Override
            segmentMap.put(wrapper, segment);
     * @param segmentMap         the wrapper → original segment mapping
 * Converts {@link Segment} instances into Lucene {@link SegmentCommitInfo}
                public boolean isEnabled(String component) {
        org.apache.lucene.index.MergePolicy.MergeSpecification mergeSpecification,
            }
            return Objects.hashCode(generation);
     */
        public boolean equals(Object o) {
                    "segment_" + segment.generation(),
        }
        SegmentInfos segmentInfos = convertToSegmentInfos(segments, segmentMap);
import java.util.ArrayList;
            if (this == o) return true;
package org.opensearch.index.engine.dataformat.merge;
     * Removes segments from the currently-merging set after a merge completes or fails.
        private static final byte[] DUMMY_ID = new byte[16];
            return convertMergeSpecification(mergeSpec, segmentMap);
    }
        @Override
        return segmentInfos;
            return convertMergeSpecification(mergeSpec, segmentMap);
    private long calculateTotalSize(Segment segment) {
                segmentInfos,
                List<Segment> segmentMerge = new ArrayList<>();
    private long calculateNumDocs(Segment segment) {
        public synchronized Set<SegmentCommitInfo> getMergingSegments() {
import org.apache.lucene.util.InfoStream;
        }
                }
    }
    /**
                }
    /**
     * A {@link org.apache.lucene.index.MergePolicy.MergeContext} implementation that tracks merging segments
        for (Segment segment : segments) {
 */
            mergeContext.addMergingSegment(createWrapper(segment));
    /**
            );
        return new SegmentWrapper(sharedDirectory, segment, calculateTotalSize(segment), calculateNumDocs(segment));
        Map<SegmentCommitInfo, Segment> segmentMap = new HashMap<>();
                @Override
        SegmentInfos segmentInfos = convertToSegmentInfos(segments, segmentMap);
     * @return a list of segment groups, each group representing one merge operation
            mergingSegments.remove(segment);
                MergeTrigger.COMMIT,
        try {
    }
                    EMPTY_DIAGNOSTICS,
    private static class SegmentWrapper extends SegmentCommitInfo {
        segmentInfos.forEach(seg -> segmentsToMerge.put(seg, true));
