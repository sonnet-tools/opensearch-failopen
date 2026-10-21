        return readTypedValue(in);
            );
            out.writeFloat(topDocs.maxScore);
import org.opensearch.common.SuppressForbidden;
import org.opensearch.common.Nullable;
            case 4 -> in.readFloat();
import org.apache.lucene.util.Version;
        SortField.Type sortType = readSortType(in);
    );
            return userData;
                    .setCommitOnClose(false) // no commits
            TopFieldDocs topFieldDocs = (TopFieldDocs) topDocs.topDocs;
                out.writeByte((byte) 7);
public class Lucene {
import java.util.ArrayList;
        };
                    // before exposing the hard-deletes, thus we can use the hard-delete count of SegmentInfos.
    public static Bits asSequentialAccessBits(final int maxDoc, @Nullable ScorerSupplier scorerSupplier, long estimatedGetCount)
            } else if (nonPruningSortField.getDelegate().getClass() == SortField.class) {
        if (topDocs.topDocs instanceof CollapseTopFieldDocs) {
    }
        }
                    final SegmentReader segmentReader = segmentReader(leaf);
                for (int i = 0; i < scoreDocs.length; i++) {
    }
    private static Comparable readTypedValue(StreamInput in) throws IOException {
            }
    public static void checkSegmentInfoIntegrity(final Directory directory) throws IOException {
import org.apache.lucene.util.BytesRef;
        final byte id = in.readByte();
     * files to ensure broken commits or corrupted indices will not be opened in the future. If any of the segment files can't be deleted
        Explanation[] subExplanations = explanation.getDetails();
            public boolean get(int index) {
        public boolean isDeleted() {
    public static SortField readSortField(StreamInput in) throws IOException {
     * The wrapped reader can be used to query all documents.
        out.writeFloat(scoreDoc.score);
    }
            final Bits liveDocs;
     * {@link IndexFormatTooOldException}, or {@link IndexFormatTooNewException} otherwise {@code false}.
import org.apache.lucene.index.IndexWriter;
                    try {
    }
        AnalyzerScope.GLOBAL,
                }
        } else {
            if (foundSegmentFiles == 0) {
            writeTotalHits(out, topDocs.topDocs.totalHits);
                 *
                return in.readDouble();
     */
            case 6 -> in.readByte();
    private static void writeMissingValue(StreamOutput out, Object missingValue) throws IOException {
            }
        }
    public static final String SOFT_DELETES_FIELD = "__soft_deletes";
            int size = in.readVInt();
    }
     * Reads the segments infos from the given segments file name, failing if it fails to load
    /**
        public static Version parse(String toParse, Version defaultValue) {
    public static int getNumDocs(SegmentInfos info) {
 *
        } else if (sortField instanceof NonPruningSortField) {
                            + "] while previously called on ["
import org.opensearch.common.util.iterable.Iterables;
    private static Number readExplanationValue(StreamInput in) throws IOException {
            for (int i = 0; i < fieldDocs.length; i++) {
     */
            return Explanation.noMatch(description, subExplanations);
            // this works since the SortField is only used for merging top docs
                /**
                try {
    public static DirectoryReader wrapAllDocsLive(DirectoryReader in) throws IOException {
 * not use this file except in compliance with the License.
    public static final ScoreDoc[] EMPTY_SCORE_DOCS = new ScoreDoc[0];
                }
 * @opensearch.internal
            throw new IllegalArgumentException("Cannot serialize SortField impl [" + sortField + "]");
import org.apache.lucene.search.TwoPhaseIterator;
    }
            case 1 -> in.readString();
                fieldDocs[i] = readFieldDoc(in);
    public static TopDocsAndMaxScore readTopDocs(StreamInput in) throws IOException {
    }
            for (ScoreDoc doc : topDocs.topDocs.scoreDocs) {
        try (
 * Modifications Copyright OpenSearch Contributors. See
        }
    /**
                    }
        private final Directory dir;
    }
    public static FieldDoc readFieldDoc(StreamInput in) throws IOException {
            out.writeFloat(topDocs.maxScore);
            SortField newSortField = new SortField(
        throws IOException {
    public static SegmentInfos pruneUnreferencedFiles(String segmentsFileName, Directory directory, boolean isParentFieldEnabled)
            return false;
import org.apache.lucene.store.IndexInput;
            LeafReaderWithLiveDocs(LeafReader in, Bits liveDocs, int numDocs) {
            out.writeFloat(topDocs.maxScore);
                 */
        }
     * Returns an iterable that allows to iterate over all files in this segments info
    public static void writeSortField(StreamOutput out, SortField sortField) throws IOException {
            writeSortType(out, comparatorSource.reducedType());
     */
    /**
                 * we could also use a deletion policy here but in the case of snapshot and restore
                int doc = iterator.docID();
        int numDocs = 0;
            segmentCount = infos.size();
 */
            out.writeByte((byte) 0);
    }
                    nonPruningSortField.getField(),
    public static boolean indexExists(final Directory directory) throws IOException {
            final int numDocs;
        }
            return segmentReader(FilterLeafReader.unwrap(fReader));
            SortField[] fields = in.readArray(Lucene::readSortField, SortField[]::new);
import org.apache.lucene.search.Weight;
            out.writeByte((byte) 0);
        @Override
            public int numDocs() {
        String filename = IndexFileNames.fileNameFromGeneration(IndexFileNames.SEGMENTS, "", commit.getGeneration());
                out.writeBoolean((Boolean) field);
    public static IndexCommit getIndexCommit(SegmentInfos si, Directory directory) throws IOException {
                        numDocs = popCount(hardLiveDocs);
import org.apache.lucene.search.SortedSetSortField;
            public int length() {
            out.writeFloat(value.floatValue());
import org.apache.lucene.index.FilterDirectoryReader;
            // Here the underlying sort field is SortedSetSortField, therefore, we will follow the
        return si;
        }
     * This method removes all files from the given directory that are not referenced by the given segments file.
                    try {
            String field = in.readString();
                            + "Got called on ["
                        return isDerivedSourceEnabled(filterLeafReader.getDelegate());
import org.apache.lucene.index.IndexCommit;
    /**
            SortField[] fields = in.readArray(Lucene::readSortField, SortField[]::new);
            writeTotalHits(out, topDocs.topDocs.totalHits);
        return asSequentialAccessBits(maxDoc, scorerSupplier, 0L);
        if (twoPhase == null) {
import org.apache.lucene.index.FilterLeafReader;
            for (int i = 0; i < fieldDocs.length; i++) {
        out.writeVInt(fieldDoc.fields.length);
    }
        return ExceptionsHelper.unwrapCorruption(t) != null;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.IndexFileNames;
            TotalHits totalHits = readTotalHits(in);
import org.opensearch.ExceptionsHelper;
     * @return the deserialized Comparable value
                newSortField.setMissingValue(nonPruningSortField.getMissingValue());
            cFields[j] = readTypedValue(in);
            out.writeDouble(value.doubleValue());
     * Tries to extract a segment reader from the given index reader.
     */
                 * DerivedSourceLeafReader can be wrapped up by only FilterLeafReader.
            // do nothing and close this will kick off IndexFileDeleter which will remove all pending files
     * This method removes all lucene files from the given directory. It will first try to delete all commit points / segments
        } else if (reader instanceof FilterCodecReader) {
            public CacheHelper getReaderCacheHelper() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                out.writeShort((Short) field);
            sortField = newSortField;
                 * since checksums don's match anymore. that's why we prune the name here directly.
                try (IndexInput input = directory.openInput(segmentFileName, IOContext.READONCE)) {
            case 0:
        }.run();
        }
    }
     * all documents contained in the set.
    public static Iterable<String> files(SegmentInfos infos) throws IOException {
                throw new IOException("Can't handle sort field value of type [" + type + "]");
    /**
        private String segmentsFileName;
        if (sortField.getClass() == GEO_DISTANCE_SORT_TYPE_CLASS) {
            numDocs += si.info.maxDoc() - si.getDelCount() - si.getSoftDelCount();
                out.writeLong((Long) field);
            case 2:
                sortField.getReverse()
        } else {
            } else if (type == BigInteger.class) {
        "_whitespace",
            } else if (type == Double.class) {
    }
    private Lucene() {}
                 * We also want the caller to know if we were not able to remove a segments_N file.
        }
                out.writeDouble((Double) field);
    /**
            // do nothing and close this will kick of IndexFileDeleter which will remove all pending files
            return new TopDocsAndMaxScore(new TopFieldDocs(totalHits, fieldDocs, fields), maxScore);
            public Bits getLiveDocs() {
    private static SegmentInfos readSegmentInfos(String segmentsFileName, Directory directory) throws IOException {
        return Arrays.asList(fields1).equals(Arrays.asList(fields2).subList(0, fields1.length));
        return false;
    }
            float maxScore = in.readFloat();
 */
                    return reader.getSegmentInfo().info.getAttribute(CriteriaBasedCodec.BUCKET_NAME) != null;
 * compatible open source license.
            out.writeByte((byte) 1);
     * that are newer than the given segments file are removed forcefully to prevent problems with IndexWriter opening a potentially
     */
            int foundSegmentFiles = 0;
        out.writeVInt(scoreDoc.doc);
        } else if (reader instanceof FilterLeafReader) {
                out.writeBytesRef((BytesRef) field);
                return numDocs;
            @Override
    public static void writeExplanation(StreamOutput out, Explanation explanation) throws IOException {
    public static boolean isCorruptionException(Throwable t) {
    public static SegmentInfos readSegmentInfos(IndexCommit commit) throws IOException {
    }
        }
     */
                 * sometimes we restore an index and override files that were referenced by a "future"
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE) // force creation - don't append...
     */
        final TwoPhaseIterator twoPhase = scorer.twoPhaseIterator();
                 * @param reader the underlying leafReader.
            @Override
                writeScoreDoc(out, doc);
        for (SegmentCommitInfo info : infos) {
    public static Explanation readExplanation(StreamInput in) throws IOException {
import org.opensearch.common.lucene.index.DerivedSourceLeafReader;
        throws IOException {
 *
 * this file be licensed under the Apache-2.0 license or a
            default:
import java.util.Arrays;
            @Override
            } else if (type == Short.class) {
                    return false;
    private static int popCount(Bits bits) {
                out.writeByte((byte) 3);
            TotalHits totalHits = readTotalHits(in);
    private static Object readMissingValue(StreamInput in) throws IOException {
                directory,
    }
        for (LeafReaderContext context : searcher.getIndexReader().leaves()) {
     * Returns {@code true} iff the given exception or
        }
                        return new LeafReaderWithLiveDocs(leaf, null, leaf.maxDoc());
    /**
     * Returns the number of documents in the index referenced by this {@link SegmentInfos}
            case 3 -> in.readLong();
            sortField = newSortField;
 */
        return new ScoreDoc(in.readVInt(), in.readFloat());
                    directory.deleteFile(file); // remove all segment_N files
/*
            return segmentCount;
        } else {
            writeExplanation(out, subExp);
                return in.readGenericValue();
            } else if (type == BytesRef.class) {
    private static final class CommitPoint extends IndexCommit {
        switch (numberType) {
            }
        }
                if (index == previous) {
     * A variant of {@link #readSegmentInfos(Directory)} that supports reading indices written by
            out.writeArray(Lucene::writeSortField, collapseDocs.fields);
import org.apache.lucene.search.SortedNumericSortField;
     * <b>NOTE</b>: that the returned {@link Bits} instance MUST be consumed in order.
            @Override
import org.opensearch.core.common.io.stream.StreamOutput;
                        return new LeafReaderWithLiveDocs(segmentReader, hardLiveDocs, numDocs);
            assert SegmentInfos.getLastCommitSegmentsFileName(directory).equals(segmentsFileName);
            protected Object doBody(String segmentFileName) throws IOException {
        out.writeEnum(totalHits.relation());
            out.writeString(sortField.getField());
        for (int i = 0; i < bits.length(); i++) {
                sortField = newSortField;
        }
                    }
        DirectoryReaderWithAllLiveDocs(DirectoryReader in) throws IOException {
        }
            out.writeByte((byte) 0);
    /**
import org.apache.lucene.store.Lock;
    }
import org.apache.lucene.store.IOContext;
import java.util.Map;
            IndexFieldData.XFieldComparatorSource comparatorSource = (IndexFieldData.XFieldComparatorSource) sortField
            out.writeByte((byte) 2);
    /**
        }
        }
        // the scorer API should be more efficient at stopping after the first
    public static SegmentInfos readSegmentInfos(Directory directory, org.opensearch.Version minimumVersion) throws IOException {
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            if (nonPruningSortField.getDelegate().getClass() == SortedSetSortField.class) {
import org.apache.lucene.index.SegmentInfos;
        if (match) {
        if (missingValue != null) {
    }
        switch (id) {
                out.writeByte((byte) 5);
        return new Bits() {
                    } else if (reader instanceof DerivedSourceLeafReader) {
        new SegmentInfos.FindSegmentsFile(directory) {
    }
        byte type = in.readByte();
        } else if (sortField.getClass() == SortedSetSortField.class) {
            throw new IllegalArgumentException("This method can only be used to serialize a ScoreDoc, not a " + scoreDoc.getClass());
            FieldDoc[] fieldDocs = new FieldDoc[size];
import java.text.ParseException;
                return SortField.STRING_LAST;
                public LeafReader wrap(LeafReader leaf) {
            if (Strings.hasLength(toParse)) {
                throw new IOException("Unknown missing value id: " + id);
        out.writeFloat(fieldDoc.score);
        public String getSegmentsFileName() {
            case 1:
        }
                    throw new IllegalArgumentException(
            iwc.setParentField(Lucene.PARENT_FIELD);
            return "DirectoryReader.ReaderCommit(" + segmentsFileName + ")";
    }
        } else if (type == 1) {
     */
                return liveDocs;
    }
        public Directory getDirectory() {
    public static Comparable readSortValue(StreamInput in) throws IOException {
                // TODO: improve serialization of BigInteger
            final Bits liveDocs = context.reader().getLiveDocs();
            IndexWriter writer = new IndexWriter(
        return SegmentInfos.readCommit(directory, segmentsFileName);
            }
import org.apache.lucene.search.ScorerSupplier;
                return in.readFloat();
        public void delete() {
            newSortField.setMissingValue(sortField.getMissingValue());
            // for geo sorting, we replace the SortField with a SortField that assumes a double field.
                    }
            @Override
        final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
                private boolean isContextAwareEnabled(SegmentReader reader) {
                scoreDocs = new ScoreDoc[scoreDocCount];
                        "This Bits instance can only be consumed in order. "
        if (value instanceof Float) {
        if (sortField.getClass() != SortField.class) {
        }
 */
        return SegmentInfos.readLatestCommit(directory);
    private static void writeExplanationValue(StreamOutput out, Number value) throws IOException {
        }
    /**
    private static final class DirectoryReaderWithAllLiveDocs extends FilterDirectoryReader {
     * If no SegmentReader can be extracted an {@link IllegalStateException} is thrown.
 * this work for additional information regarding copyright
                this.numDocs = numDocs;
            return wrapAllDocsLive(in);
    /**
                return previousMatched = false;
import org.apache.lucene.search.Explanation;
            out.writeGenericValue(missingValue);
        };
                writeSortValue(out, collapseDocs.collapseValues[i]);
import org.apache.lucene.search.Scorer;
            final FilterLeafReader fReader = (FilterLeafReader) reader;
            if (scorer == null) {
                            + index
            out.writeByte((byte) 0);
    @SuppressForbidden(reason = "Version#parseLeniently() used in a central place")
            // for multi-valued sort field, we replace the SortedSetSortField with a simple SortField.
 *     http://www.apache.org/licenses/LICENSE-2.0
        SortField sortField = new SortField(field, sortType, reverse);
        }
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
     */
            return generation;
import org.apache.lucene.store.Directory;
     */
import org.apache.lucene.search.ScoreMode;
                    // Two scenarios that we have hard-deletes: (1) from old segments where soft-deletes was disabled,
            } else if (type == Long.class) {
                        return previousMatched = twoPhase == null || twoPhase.matches();
import org.opensearch.search.sort.SortedWiderNumericSortField;
        @Override
            out.writeByte((byte) 1);
                    if (hardLiveDocs == null) {
            @Override
import java.util.Collection;
    }
     */
            field = in.readString();
        if (sortField.getField() == null) {
                    return Version.parseLeniently(toParse);
            if (type == String.class) {
    }
        out.writeString(explanation.getDescription());
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            } else if (type == Integer.class) {
        out.writeVInt(subExplanations.length);
        if (sortField.getComparatorSource() != null) {
        boolean match = in.readBoolean();
     * @throws IOException if reading fails or type is unknown
        out.writeVInt(sortType.ordinal());
    public static void writeFieldDoc(StreamOutput out, FieldDoc fieldDoc) throws IOException {
    public static final String PARENT_FIELD = "__nested_parent";
    public static void writeTotalHits(StreamOutput out, TotalHits totalHits) throws IOException {
            Class type = field.getClass();
 * The OpenSearch Contributors require contributions made to
     */
                    CodecUtil.checksumEntireFile(input);
            writeMissingValue(out, sortField.getMissingValue());
            }
        String field = null;
                if (file.startsWith(IndexFileNames.SEGMENTS)) {
            final DocIdSetIterator iterator = scorer.iterator();
    public static void writeTopDocs(StreamOutput out, TopDocsAndMaxScore topDocs) throws IOException {
        }
 * the Apache License, Version 2.0 (the "License"); you may
            }
            out.writeByte((byte) 2);
        }
        static final class LeafReaderWithLiveDocs extends FilterLeafReader {
}
    }
        final DocIdSetIterator iterator;
            case 0 -> null;
                        FilterLeafReader filterLeafReader = (FilterLeafReader) reader;
     * a write lock from the directory while pruning unused files. This method expects an existing index in the given directory that has
                    assert numDocs == popCount(hardLiveDocs) : numDocs + " != " + popCount(hardLiveDocs);
                .getComparatorSource();
            float maxScore = in.readFloat();
            Object[] collapseValues = new Object[size];
        if (explanation.isMatch()) {
     * broken commit point / leftover.
            }
                        numDocs = segmentReader.maxDoc() - segmentReader.getSegmentInfo().getDelCount();
import org.apache.lucene.index.DirectoryReader;
     *
     *
                out.writeFloat((Float) field);
            .setCommitOnClose(false)
        return switch (type) {
            iterator = twoPhase.approximation();
    }
    }
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
                }
import org.apache.lucene.search.TopFieldDocs;
        }
        int onBits = 0;
                    if (reader instanceof SegmentReader) {
                );
     * Returns an index commit for the given {@link SegmentInfos} in the given directory.
            writeSortType(out, sortField.getType());
            if (bits.get(i)) {
     */
    }
        if (missingValue == SortField.STRING_FIRST) {
                @Override
                }
                            + previous
            return new TopDocsAndMaxScore(new TopDocs(totalHits, scoreDocs), maxScore);
import org.apache.lucene.index.CorruptIndexException;
        IndexWriterConfig iwc = new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
            }
        try (Lock writeLock = directory.obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
            }
import org.opensearch.index.fielddata.IndexFieldData;
                out.writeByte((byte) 4);
            )
                    SortField.Type.STRING,
                    throw new IndexOutOfBoundsException(index + " is out of bounds: [" + 0 + "-" + maxDoc + "[");
        return new DirectoryReaderWithAllLiveDocs(in);
                ((SortedNumericSortField) sortField).getNumericType(),
     * Check whether there is one or more documents matching the provided query.
        return LenientParser.parse(toParse, defaultValue);
     * Given a {@link ScorerSupplier}, return a {@link Bits} instance that will match
        final Scorer scorer = scorerSupplier.get(estimatedGetCount); // this never returns null
import org.apache.lucene.search.TotalHits;
        } else if (value instanceof Double) {
import org.opensearch.index.codec.CriteriaBasedCodec;
            // We will serialize the sort field based on the type of underlying sort field
            for (int i = 0; i < topDocs.topDocs.scoreDocs.length; i++) {
            @Override
            default:
            }
        return onBits;
                sortField.getField(),
        }
            return segmentReader(FilterCodecReader.unwrap(fReader));
                }
     * This method will open an IndexWriter and relies on index file deleter to remove all unreferenced files. Segment files
            default -> throw new IOException("Can't match type [" + type + "]");
        for (Object field : fieldDoc.fields) {
import org.apache.lucene.document.LatLonDocValuesField;
                throw new IOException("Unexpected number type: " + numberType);
            return new TopDocsAndMaxScore(new CollapseTopFieldDocs(field, totalHits, fieldDocs, fields, collapseValues), maxScore);
                }
                    } else {
/*
    /**
                        directory.deleteFile(file); // remove all segment_N files except of the one we wanna keep
 * under the License.
                    scoreDocs[i] = new ScoreDoc(in.readVInt(), in.readFloat());
                out.writeString(field.toString());
            float maxScore = in.readFloat();
        }
                    }
                if (index < 0 || index >= maxDoc) {
        }
    }
                 */
import org.opensearch.core.common.io.stream.StreamInput;
     * @return the wrapped reader
            }
    public static SortField.Type readSortType(StreamInput in) throws IOException {
     */
            }
     * this operation fails.
            iterator = scorer.iterator();
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
     * Whether a query sorted by {@code searchSort} can be early-terminated if the index is sorted by {@code indexSort}.
                    .setMergePolicy(NoMergePolicy.INSTANCE) // no merges
            } else {
                out.writeByte((byte) 9);
import org.apache.lucene.index.IndexWriterConfig;
    public static Bits asSequentialAccessBits(final int maxDoc, @Nullable ScorerSupplier scorerSupplier) throws IOException {
import org.apache.lucene.index.FilterCodecReader;
        // manually create the segment filename
        }
                sortField = nonPruningSortField.getDelegate();
     * or hard-deleted due to non-aborting exceptions during indexing.
    /**
        out.writeBoolean(explanation.isMatch());
                if (file.startsWith(IndexFileNames.SEGMENTS)) {
    public static TotalHits readTotalHits(StreamInput in) throws IOException {
import org.apache.lucene.index.IndexFormatTooNewException;
        }
        return SegmentInfos.readLatestCommit(directory, minSupportedLuceneMajor);
                scoreDocs = EMPTY_SCORE_DOCS;
    }
            case 10 -> new BigInteger(in.readString());
            // Which are through the SortField class or SortedSetSortField class
 *
            out.writeBoolean(false);
    public static SegmentInfos readSegmentInfos(Directory directory) throws IOException {
        try (Lock writeLock = directory.obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
        try (IndexWriter writer = new IndexWriter(directory, iwc)) {
        ) {
            return files;
        } else {
            throw new UnsupportedOperationException("This IndexCommit does not support deletions");
            out.writeVInt(topDocs.topDocs.scoreDocs.length);
        // Using commit.getSegmentsFileName() does NOT work here, have to
import java.util.Collections;
            final Scorer scorer = weight.scorer(context);
        Object missingValue = readMissingValue(in);
        list.add(Collections.singleton(infos.getSegmentsFileName()));
        private final Collection<String> files;
                if (doc < index) {
        for (Explanation subExp : subExplanations) {
    /**
    }
        for (int j = 0; j < cFields.length; j++) {
                return in.getCoreCacheHelper();
        }
                    }
        }
            if (scoreDocCount == 0) {
                }
            }
                    }
    public static void writeScoreDoc(StreamOutput out, ScoreDoc scoreDoc) throws IOException {
        @Override
        @Override
        return numDocs;
                    if (isDerivedSourceEnabled(leaf)) {
        }
                collapseValues[i] = readSortValue(in);
                 * @return whether derived source is enabled or not.
            } else if (type == Float.class) {
        @Override
                out.writeString((String) field);
                ScoreDoc doc = collapseDocs.scoreDocs[i];
            .setMergePolicy(NoMergePolicy.INSTANCE)
            files = Collections.unmodifiableCollection(infos.files(true));
            }
                }
            final ScoreDoc[] scoreDocs;
                    // pass to default
            writeExplanationValue(out, explanation.getValue());
    public static final NamedAnalyzer STANDARD_ANALYZER = new NamedAnalyzer("_standard", AnalyzerScope.GLOBAL, new StandardAnalyzer());
            }
            // There are 2 cases of how NonPruningSortField wraps around its underlying sort field.
            for (final String file : directory.listAll()) {
     */
        throw new IllegalStateException("Can not extract segment reader from given index reader [" + reader + "]");
        } else {
        return DirectoryReader.indexExists(directory);
        // Since we want bits, we need random-access
            return (SegmentReader) reader;
            writeMissingValue(out, comparatorSource.missingValue(sortField.getReverse()));
        return new CommitPoint(si, directory);
        }
 * KIND, either express or implied.  See the License for the
        }
import java.io.IOException;
    }
     * Reads the segments infos from the given commit, failing if it fails to load
        // match than the bulk scorer API
        }
            } else {
            // It works because the sort field is only used to merge results from different shards.
     * older major versions of Lucene. This leverages Lucene's "expert" readLatestCommit API. The
                 * commit. If such a commit is opened by the IW it would likely throw a corrupted index exception
                    return previousMatched;
            }
import org.apache.lucene.codecs.CodecUtil;
import org.apache.lucene.search.TopDocs;
        out.writeBoolean(sortField.getReverse());
            subExplanations[i] = readExplanation(in);
        }
import org.apache.lucene.search.Query;
            out.writeVInt(topDocs.topDocs.scoreDocs.length);
            out.writeZLong(value.longValue());
import org.apache.lucene.document.NumericDocValuesField;
     * @param in the input stream
     * @param estimatedGetCount an estimation of the number of times that {@link Bits#get} will get called
                }
 * ownership. Elasticsearch licenses this file to you under
        }
        public Map<String, String> getUserData() {
 * Main lucene class.
import org.apache.lucene.search.DocIdSetIterator;
            TotalHits totalHits = readTotalHits(in);
            out.writeBoolean(true);
        Comparable[] cFields = new Comparable[in.readVInt()];
 * specific language governing permissions and limitations
            for (ScoreDoc doc : topFieldDocs.scoreDocs) {
            out.writeVInt(topDocs.topDocs.scoreDocs.length);
            out.writeByte((byte) 2);
        } else {
            sortField.setMissingValue(missingValue);
        if (isParentFieldEnabled) {
            // It works because the sort field is only used to merge results from different shards.
    }
                SortField newSortField = new SortField(
        out.writeVInt(fieldDoc.doc);
                        return false;
        }
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
        if (!scoreDoc.getClass().equals(ScoreDoc.class)) {
            userData = infos.getUserData();
     * @see #asSequentialAccessBits(int, ScorerSupplier, long)
    }
        @Override
                    return true;
            }
            SortField newSortField = new SortField(sortField.getField(), SortField.Type.DOUBLE);
                throw new IllegalStateException("no commit found in the directory");
    }
        return new TotalHits(totalHits, totalHitsRelation);
                public boolean isDerivedSourceEnabled(LeafReader reader) {
        @Override
import java.math.BigInteger;
        long totalHits = in.readVLong();
                    nonPruningSortField.getReverse()
                    );
                return SortField.STRING_FIRST;
                    } catch (IOException e) {
                    // we cache whether it matched because it is illegal to call
            CollapseTopFieldDocs collapseDocs = (CollapseTopFieldDocs) topDocs.topDocs;
                        doc = iterator.advance(index);
    }
        private final Map<String, String> userData;
            boolean previousMatched = false;
            case 9 -> in.readBytesRef();
        return SegmentInfos.readCommit(commit.getDirectory(), filename);
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.core.common.Strings;
import org.opensearch.index.analysis.NamedAnalyzer;
                previous = index;
                    if (isContextAwareEnabled(segmentReader)) {
    }
/*
        }
            return null; // Modifying liveDocs
import org.apache.lucene.index.SegmentReader;
     */
import org.apache.lucene.search.Sort;
                fieldDocs[i] = readFieldDoc(in);
import org.apache.lucene.search.FieldDoc;
     * Reads the segments infos, failing if it fails to load
            public CacheHelper getCoreCacheHelper() {
            case 5 -> in.readDouble();
                out.writeByte((Byte) field);
import org.opensearch.index.fielddata.plain.NonPruningSortedSetOrdinalsIndexFieldData.NonPruningSortField;
            segmentsFileName = infos.getSegmentsFileName();
                    int numDocs;
        }
            list.add(info.files());
        } else if (topDocs.topDocs instanceof TopFieldDocs) {
            sortField = newSortField;
                }
     * @param in the input directory reader
            out.writeByte((byte) 1);
        return sortField;
                writeFieldDoc(out, (FieldDoc) doc);
            FieldDoc[] fieldDocs = new FieldDoc[in.readVInt()];
        } else if (missingValue == SortField.STRING_LAST) {
                    // We are using attribute value here to identify whether segment has CAS enabled or not.
import org.apache.lucene.index.IndexFormatTooOldException;
                return maxDoc;
                return in.readZLong();
            }
                        throw new IllegalStateException("Cannot validate match", e);
                out.writeByte((byte) 10);
        } else if (type == 2) {
        }
     * Wraps a directory reader to make all documents live except those were rolled back
                return null; // Modifying liveDocs
            NonPruningSortField nonPruningSortField = (NonPruningSortField) sortField;
        private final long generation;
        }
    }
                    // With CAS enabled segments, hard deletes can also be present, so correcting numDocs.
        // early termination is possible if fields1 is a prefix of fields2
                writeFieldDoc(out, (FieldDoc) doc);
                out.writeInt((Integer) field);
        public int getSegmentCount() {
    public static final NamedAnalyzer KEYWORD_ANALYZER = new NamedAnalyzer("_keyword", AnalyzerScope.GLOBAL, new KeywordAnalyzer());
    }
        assert bits != null;
     * <b>NOTE</b>: that the returned {@link Bits} instance MUST be consumed in order.
        String description = in.readString();
import org.apache.lucene.util.Bits;
            writeSortValue(out, field);
    }
        out.writeVLong(totalHits.value());
    public static Version parseVersionLenient(String toParse, Version defaultValue) {
    public static void writeSortValue(StreamOutput out, Object field) throws IOException {
     * the given segments file.
        boolean reverse = in.readBoolean();
                super(in);
    }
                 * A FilterCodecReader can never accept a DerivedSourceLeafReader as a delegate as it is IndexReader.
    public static final NamedAnalyzer WHITESPACE_ANALYZER = new NamedAnalyzer(
        public Collection<String> getFileNames() {
                    }
 * license agreements. See the NOTICE file distributed with
        return new NumericDocValuesField(SOFT_DELETES_FIELD, 1);
            out.writeString(collapseDocs.field);
    /**
import org.apache.lucene.index.SegmentCommitInfo;
            throw new IllegalStateException("Unknown type " + type);
            this.dir = dir;
                }
    /**
        }
                }
 * GitHub history for details.
     */
        if (scorerSupplier == null) {
        return Iterables.flatten(list);
            return defaultValue;
     * Returns a numeric docvalues which can be used to soft-delete documents.
     * {@link org.opensearch.Version} parameter determines the minimum supported Lucene major version.
        @Override
            newSortField.setMissingValue(sortField.getMissingValue());
        if (field == null) {
            case 8 -> in.readBoolean();
 *
                if (index == doc) {
                }
                return null;
            }
                out.writeByte((byte) 2);
            case 0:
            generation = infos.getGeneration();
                out.writeByte((byte) 1);
            for (int doc = iterator.nextDoc(); doc != DocIdSetIterator.NO_MORE_DOCS; doc = iterator.nextDoc()) {
    }
            }
            case 7 -> in.readShort();
     * Return a {@link Bits} view of the provided scorer.
import org.apache.lucene.search.ScoreDoc;
            return dir;
        return new FieldDoc(in.readVInt(), in.readFloat(), cFields);
    public static boolean canEarlyTerminate(Sort searchSort, Sort indexSort) {
    }
        public String toString() {
 * You may obtain a copy of the License at
        }
        if (in.readBoolean()) {
        if (type == 0) {
                    // Once soft-deletes is enabled, we no longer hard-update or hard-delete documents directly.
    }
            case 1:
                this.liveDocs = liveDocs;
                    final Bits hardLiveDocs = segmentReader.getHardLiveDocs();
                        throw new IllegalStateException("Cannot advance iterator", e);
        private final int segmentCount;
    /**
    /**
                        return true;
                    } catch (IOException e) {
        @Override
            out.writeArray(Lucene::writeSortField, topFieldDocs.fields);
        }
            .setIndexCommit(cp)
        } else {
                }
        final List<Collection<String>> list = new ArrayList<>();
    public static final String LATEST_CODEC = "Lucene104";
    public static void cleanLuceneIndex(Directory directory) throws IOException {
            case 2:
    private static final class LenientParser {
import java.util.List;
            for (final String file : directory.listAll()) {
            } else if (type == Byte.class) {
                } catch (ParseException e) {
 * software distributed under the License is distributed on an
        final SortField[] fields1 = searchSort.getSort();
    public static boolean exists(IndexSearcher searcher, Query query) throws IOException {
    public static SegmentReader segmentReader(LeafReader reader) {
        if (reader instanceof SegmentReader) {
        }
            } else if (type == Boolean.class) {
    public static NumericDocValuesField newSoftDeletesField() {
            // for multi-valued sort field, we replace the SortedNumericSortField/SortedWiderNumericSortField with a simple SortField.
                    // (2) when IndexWriter hits non-aborted exceptions. These two cases, IW flushes SegmentInfos
                if (index < previous) {
    private static final Class<?> GEO_DISTANCE_SORT_TYPE_CLASS = LatLonDocValuesField.newDistanceSort("some_geo_field", 0, 0).getClass();
     * Reads a typed value from the stream based on a type byte prefix.
            }
                    foundSegmentFiles++;
     * <b>Note:</b> this method will fail if there is another IndexWriter open on the given directory. This method will also acquire
     */
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        public CacheHelper getReaderCacheHelper() {
 * Licensed to Elasticsearch under one or more contributor
                            + "]"
                onBits++;
                if (liveDocs == null || liveDocs.get(doc)) {
            writeTotalHits(out, topDocs.topDocs.totalHits);
     */
     * Parses the version string lenient and returns the default value if the given string is null or empty
                    } else if (reader instanceof FilterLeafReader) {
        }
    public static ScoreDoc readScoreDoc(StreamInput in) throws IOException {
            // logic in serializing SortedSetSortField and also unwrap the SortField case.
    }
        }
            return Explanation.match(readExplanationValue(in), description, subExplanations);
        final int numberType = in.readByte();
    public static final TopDocs EMPTY_TOP_DOCS = new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), EMPTY_SCORE_DOCS);
        final SegmentInfos si = readSegmentInfos(segmentsFileName, directory);
        final IndexCommit cp = getIndexCommit(si, directory);
                /*
import org.apache.lucene.index.NoMergePolicy;
                    } else {
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.AnalyzerScope;
import org.apache.lucene.search.SortField;
import org.apache.lucene.index.LeafReader;
    }
    // LUCENE 4 UPGRADE: We might want to maintain our own ordinal, instead of Lucene's ordinal
        // hard fail - we can't get a SegmentReader
            int previous = -1;
            }
        for (int i = 0; i < subExplanations.length; ++i) {
            final FilterCodecReader fReader = (FilterCodecReader) reader;
        return SortField.Type.values()[in.readVInt()];
        byte type = in.readByte();
                out.writeByte((byte) 8);
                    // twoPhase.matches() twice
        } else {
        private CommitPoint(SegmentInfos infos, Directory dir) throws IOException {
            return segmentsFileName;
     * one of it's causes is an instance of {@link CorruptIndexException},
 * Unless required by applicable law or agreed to in writing,
            });
                continue;
            final int scoreDocCount = in.readVInt();
        @Override
        if (fields1.length > fields2.length) {
        final Explanation[] subExplanations = new Explanation[in.readVInt()];
        }
        public long getGeneration() {
        new WhitespaceAnalyzer()
            return false;
/**
            newSortField.setMissingValue(sortField.getMissingValue());
        } else {
                        return new LeafReaderWithLiveDocs(leaf, hardLiveDocs, numDocs);
            case 2 -> in.readInt();
        } else if (sortField.getClass() == SortedNumericSortField.class || sortField.getClass() == SortedWiderNumericSortField.class) {
    /**
            return new Bits.MatchNoBits(maxDoc);
            SortField newSortField = new SortField(sortField.getField(), SortField.Type.STRING, sortField.getReverse());
                out.writeByte((byte) 6);
            .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
        final SortField[] fields2 = indexSort.getSort();
        @Override
        final int minSupportedLuceneMajor = minimumVersion.minimumIndexCompatibilityVersion().luceneVersion.major;
                    if (file.equals(si.getSegmentsFileName()) == false) {
package org.opensearch.common.lucene;
        for (SegmentCommitInfo si : info) {
            }
    }
            super(in, new SubReaderWrapper() {
        TotalHits.Relation totalHitsRelation = in.readEnum(TotalHits.Relation.class);
    public static void writeSortType(StreamOutput out, SortField.Type sortType) throws IOException {
