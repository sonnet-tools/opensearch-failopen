        out.writeVLong(totalHits.value());
            out.writeByte((byte) 0);
            writeTotalHits(out, topDocs.topDocs.totalHits);
     * @see #asSequentialAccessBits(int, ScorerSupplier, long)
    }
        public String getSegmentsFileName() {  
                public boolean isDerivedSourceEnabled(LeafReader reader) {  
        return si;  
            return false;
            boolean previousMatched = false;
    }  
        for (Explanation subExp : subExplanations) {
            for (final String file : directory.listAll()) {
    }
        ) {
     * This method will open an IndexWriter and relies on index file deleter to remove all unreferenced files. Segment files
    }  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
                return SortField.STRING_FIRST;
     * Returns a numeric docvalues which can be used to soft-delete documents.
            throw new IllegalArgumentException("This method can only be used to serialize a ScoreDoc, not a " + scoreDoc.getClass());  
        byte type = in.readByte();
     * Parses the version string lenient and returns the default value if the given string is null or empty  
        public Directory getDirectory() {
     * This method removes all lucene files from the given directory. It will first try to delete all commit points / segments
     * older major versions of Lucene. This leverages Lucene's "expert" readLatestCommit API. The
     */  
     * @param in the input directory reader  
        for (SegmentCommitInfo info : infos) {
            Object[] collapseValues = new Object[size];  
            for (int i = 0; i < topDocs.topDocs.scoreDocs.length; i++) {  
            });  
                    nonPruningSortField.getField(),
                out.writeByte((byte) 7);
                 * @return whether derived source is enabled or not.
        }  
                    return Version.parseLeniently(toParse);
            } else if (type == BytesRef.class) {  
import org.apache.lucene.index.NoMergePolicy;
            return segmentReader(FilterLeafReader.unwrap(fReader));  
            out.writeDouble(value.doubleValue());
        static final class LeafReaderWithLiveDocs extends FilterLeafReader {
                private boolean isContextAwareEnabled(SegmentReader reader) {
                }  
            iterator = scorer.iterator();  
        throws IOException {  
    public static SegmentInfos readSegmentInfos(Directory directory) throws IOException {
            case 0:
            // It works because the sort field is only used to merge results from different shards.  
import org.apache.lucene.index.DirectoryReader;
            int previous = -1;
        }
                 * commit. If such a commit is opened by the IW it would likely throw a corrupted index exception
            float maxScore = in.readFloat();
                 * sometimes we restore an index and override files that were referenced by a "future"
            out.writeArray(Lucene::writeSortField, topFieldDocs.fields);  
            out.writeVInt(topDocs.topDocs.scoreDocs.length);
                    return reader.getSegmentInfo().info.getAttribute(CriteriaBasedCodec.BUCKET_NAME) != null;
        }
     *
import org.opensearch.ExceptionsHelper;
                }
            TotalHits totalHits = readTotalHits(in);  
                    } else {
import java.math.BigInteger;
                out.writeByte((Byte) field);
        }  
        SortField.Type sortType = readSortType(in);
        out.writeVInt(sortType.ordinal());  
        return LenientParser.parse(toParse, defaultValue);  
                if (doc < index) {  
    private static final class CommitPoint extends IndexCommit {
                writeFieldDoc(out, (FieldDoc) doc);
            }  
    public static void writeExplanation(StreamOutput out, Explanation explanation) throws IOException {  
     * one of it's causes is an instance of {@link CorruptIndexException},
            return false;  
            if (Strings.hasLength(toParse)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final FilterLeafReader fReader = (FilterLeafReader) reader;
            writeSortType(out, sortField.getType());
        return DirectoryReader.indexExists(directory);
    public static TotalHits readTotalHits(StreamInput in) throws IOException {  
            out.writeArray(Lucene::writeSortField, collapseDocs.fields);  
                throw new IOException("Can't handle sort field value of type [" + type + "]");
        if (sortField.getComparatorSource() != null) {
                        return isDerivedSourceEnabled(filterLeafReader.getDelegate());
        }
            if (foundSegmentFiles == 0) {
                    int numDocs;
            segmentsFileName = infos.getSegmentsFileName();
     * Reads the segments infos from the given commit, failing if it fails to load
                }
            final int scoreDocCount = in.readVInt();  
                }
        for (int i = 0; i < bits.length(); i++) {
            }  
            sortField = newSortField;
        return SegmentInfos.readLatestCommit(directory);  
     */
     */  
            case 2 -> in.readInt();  
        } else {
import java.util.List;
    }
    public static Iterable<String> files(SegmentInfos infos) throws IOException {
    @SuppressForbidden(reason = "Version#parseLeniently() used in a central place")  
     */
import org.apache.lucene.search.ScoreDoc;
        }  
                    } catch (IOException e) {  
        String field = null;  
    }  
     * the given segments file.  
            iwc.setParentField(Lucene.PARENT_FIELD);
                if (index < 0 || index >= maxDoc) {  
    public static void writeFieldDoc(StreamOutput out, FieldDoc fieldDoc) throws IOException {
                scoreDocs = EMPTY_SCORE_DOCS;  
        if (explanation.isMatch()) {
        if (in.readBoolean()) {
     * <b>NOTE</b>: that the returned {@link Bits} instance MUST be consumed in order.
            for (ScoreDoc doc : topDocs.topDocs.scoreDocs) {  
    }
        public long getGeneration() {  
import org.opensearch.search.sort.SortedWiderNumericSortField;
        }
            int size = in.readVInt();
            } else if (type == Byte.class) {  
                out.writeString(field.toString());  
    public static Version parseVersionLenient(String toParse, Version defaultValue) {
import org.apache.lucene.search.SortedSetSortField;  
                int doc = iterator.docID();
     * Returns {@code true} iff the given exception or  
    }  
        out.writeVInt(scoreDoc.doc);
            out.writeGenericValue(missingValue);
        } else {  
                ((SortedNumericSortField) sortField).getNumericType(),  
     * or hard-deleted due to non-aborting exceptions during indexing.  
import org.apache.lucene.index.FilterLeafReader;
            return generation;
            if (scorer == null) {
            case 9 -> in.readBytesRef();
        } else if (sortField.getClass() == SortedSetSortField.class) {
                    directory.deleteFile(file); // remove all segment_N files
        }
     */
            // logic in serializing SortedSetSortField and also unwrap the SortField case.
        switch (numberType) {  
            final DocIdSetIterator iterator = scorer.iterator();
import org.opensearch.core.common.Strings;
        }
        DirectoryReaderWithAllLiveDocs(DirectoryReader in) throws IOException {  
    public static TopDocsAndMaxScore readTopDocs(StreamInput in) throws IOException {  
    public static final String PARENT_FIELD = "__nested_parent";
            if (scoreDocCount == 0) {
            case 1:
                            + index
                );
import org.apache.lucene.index.SegmentCommitInfo;  
package org.opensearch.common.lucene;
     * Reads the segments infos from the given segments file name, failing if it fails to load
    }
import org.apache.lucene.search.Query;
                        numDocs = segmentReader.maxDoc() - segmentReader.getSegmentInfo().getDelCount();
            writeExplanation(out, subExp);  
                public LeafReader wrap(LeafReader leaf) {  
            return segmentReader(FilterCodecReader.unwrap(fReader));  
            newSortField.setMissingValue(sortField.getMissingValue());  
 * specific language governing permissions and limitations
                }  
    /**  
            }
import org.apache.lucene.search.Explanation;
            public boolean get(int index) {
            final FilterCodecReader fReader = (FilterCodecReader) reader;
                out.writeInt((Integer) field);
        } else if (reader instanceof FilterCodecReader) {
        @Override
    public static FieldDoc readFieldDoc(StreamInput in) throws IOException {  
     * that are newer than the given segments file are removed forcefully to prevent problems with IndexWriter opening a potentially
                        doc = iterator.advance(index);
     * Whether a query sorted by {@code searchSort} can be early-terminated if the index is sorted by {@code indexSort}.
        final SegmentInfos si = readSegmentInfos(segmentsFileName, directory);
     */  
 */  
            public Bits getLiveDocs() {
            field = in.readString();
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
                out.writeByte((byte) 5);
     */  
        }  
            segmentCount = infos.size();
        if (fields1.length > fields2.length) {
        if (value instanceof Float) {  
    /**  
            } else if (nonPruningSortField.getDelegate().getClass() == SortField.class) {
                return null;
                 * @param reader the underlying leafReader.
            }
    private static Object readMissingValue(StreamInput in) throws IOException {
            }  
     * If no SegmentReader can be extracted an {@link IllegalStateException} is thrown.
}
                out.writeFloat((Float) field);
        }  
            }
 * this work for additional information regarding copyright
        if (isParentFieldEnabled) {  
                    final Bits hardLiveDocs = segmentReader.getHardLiveDocs();
        // Using commit.getSegmentsFileName() does NOT work here, have to
        if (missingValue == SortField.STRING_FIRST) {
                writeFieldDoc(out, (FieldDoc) doc);
import org.apache.lucene.store.IndexInput;  
            writeTotalHits(out, topDocs.topDocs.totalHits);  
        new WhitespaceAnalyzer()
                }
    /**
            );
                if (index < previous) {  
        final List<Collection<String>> list = new ArrayList<>();
        try (
    public static final String SOFT_DELETES_FIELD = "__soft_deletes";  
    public static final NamedAnalyzer WHITESPACE_ANALYZER = new NamedAnalyzer(
                @Override
                 */
        }
                out.writeByte((byte) 6);
    }
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
                out.writeBoolean((Boolean) field);
            final Scorer scorer = weight.scorer(context);  
                        throw new IllegalStateException("Cannot validate match", e);
 *  
                for (int i = 0; i < scoreDocs.length; i++) {  
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;  
    public static DirectoryReader wrapAllDocsLive(DirectoryReader in) throws IOException {  
                sortField = nonPruningSortField.getDelegate();  
            }  
        final int numberType = in.readByte();
        return SegmentInfos.readLatestCommit(directory, minSupportedLuceneMajor);
        String filename = IndexFileNames.fileNameFromGeneration(IndexFileNames.SEGMENTS, "", commit.getGeneration());  
            }  
            return Explanation.noMatch(description, subExplanations);
        } else {  
        return SegmentInfos.readCommit(directory, segmentsFileName);
    public static boolean indexExists(final Directory directory) throws IOException {
            case 6 -> in.readByte();
     * files to ensure broken commits or corrupted indices will not be opened in the future. If any of the segment files can't be deleted  
                    return previousMatched;
        @Override  
 * software distributed under the License is distributed on an
                    // With CAS enabled segments, hard deletes can also be present, so correcting numDocs.
    );  
import org.apache.lucene.index.IndexFileNames;
import org.apache.lucene.store.IOContext;
import org.opensearch.core.common.io.stream.StreamInput;  
     */
                out.writeByte((byte) 9);
                fieldDocs[i] = readFieldDoc(in);
            case 2:  
            case 1:  
                }
        private CommitPoint(SegmentInfos infos, Directory dir) throws IOException {
        public boolean isDeleted() {
        if (sortField.getField() == null) {
        public String toString() {
                    }
            )  
import org.apache.lucene.index.IndexWriter;
        }
        "_whitespace",  
            case 10 -> new BigInteger(in.readString());
                        "This Bits instance can only be consumed in order. "
                ScoreDoc doc = collapseDocs.scoreDocs[i];
    }
                return null; // Modifying liveDocs
            return "DirectoryReader.ReaderCommit(" + segmentsFileName + ")";  
            out.writeByte((byte) 2);
        out.writeBoolean(sortField.getReverse());
    /**
    public static NumericDocValuesField newSoftDeletesField() {
        }  
    }
        out.writeFloat(fieldDoc.score);
import org.apache.lucene.document.NumericDocValuesField;  
        }  
            }  
        if (sortField.getClass() != SortField.class) {
import org.opensearch.common.lucene.index.DerivedSourceLeafReader;
                this.liveDocs = liveDocs;
    public static final ScoreDoc[] EMPTY_SCORE_DOCS = new ScoreDoc[0];
                }
            String field = in.readString();  
                continue;
    }
     */
            writeMissingValue(out, comparatorSource.missingValue(sortField.getReverse()));
        int onBits = 0;
        } else if (sortField instanceof NonPruningSortField) {
            return segmentCount;
 *     http://www.apache.org/licenses/LICENSE-2.0
                fieldDocs[i] = readFieldDoc(in);  
    public static ScoreDoc readScoreDoc(StreamInput in) throws IOException {
        out.writeEnum(totalHits.relation());  
     * {@link IndexFormatTooOldException}, or {@link IndexFormatTooNewException} otherwise {@code false}.
     * @return the deserialized Comparable value
                    // (2) when IndexWriter hits non-aborted exceptions. These two cases, IW flushes SegmentInfos
import org.apache.lucene.index.SegmentInfos;
        }  
        }
            out.writeVInt(topDocs.topDocs.scoreDocs.length);
            out.writeFloat(value.floatValue());
        }
        final DocIdSetIterator iterator;
        byte type = in.readByte();
            TotalHits totalHits = readTotalHits(in);  
                if (file.startsWith(IndexFileNames.SEGMENTS)) {  
        return Arrays.asList(fields1).equals(Arrays.asList(fields2).subList(0, fields1.length));
    private static void writeMissingValue(StreamOutput out, Object missingValue) throws IOException {  
                 * DerivedSourceLeafReader can be wrapped up by only FilterLeafReader.
        final TwoPhaseIterator twoPhase = scorer.twoPhaseIterator();  
                if (file.startsWith(IndexFileNames.SEGMENTS)) {  
            .setCommitOnClose(false)  
 * the Apache License, Version 2.0 (the "License"); you may
    }
            }
            out.writeString(sortField.getField());
            LeafReaderWithLiveDocs(LeafReader in, Bits liveDocs, int numDocs) {  
    public static Comparable readSortValue(StreamInput in) throws IOException {
     */  
    }
        assert bits != null;  
            out.writeString(collapseDocs.field);
                    }  
            final Bits liveDocs = context.reader().getLiveDocs();
    public static SegmentInfos pruneUnreferencedFiles(String segmentsFileName, Directory directory, boolean isParentFieldEnabled)
        public static Version parse(String toParse, Version defaultValue) {
    }
    public static final String LATEST_CODEC = "Lucene104";
 *
            newSortField.setMissingValue(sortField.getMissingValue());
        } else if (type == 2) {
            float maxScore = in.readFloat();
    }  
                out.writeByte((byte) 4);
    private static final class LenientParser {
    private static Comparable readTypedValue(StreamInput in) throws IOException {
        return new FieldDoc(in.readVInt(), in.readFloat(), cFields);
                out.writeLong((Long) field);
                    return false;
            } else {
                try (IndexInput input = directory.openInput(segmentFileName, IOContext.READONCE)) {
                if (index == previous) {
        out.writeFloat(scoreDoc.score);  
            .setMergePolicy(NoMergePolicy.INSTANCE)
    }
            SortField newSortField = new SortField(sortField.getField(), SortField.Type.STRING, sortField.getReverse());
 *  
            @Override
            if (bits.get(i)) {  
 *
        int numDocs = 0;
        final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
            case 0:
        }
                            + "Got called on ["  
import org.apache.lucene.search.DocIdSetIterator;  
            }
                    SortField.Type.STRING,  
     */
        final SortField[] fields2 = indexSort.getSort();
 * KIND, either express or implied.  See the License for the
    /**
     * @throws IOException if reading fails or type is unknown
    public static SortField.Type readSortType(StreamInput in) throws IOException {
                 * We also want the caller to know if we were not able to remove a segments_N file.
        @Override  
        return onBits;
import org.apache.lucene.index.LeafReader;  
    public static Explanation readExplanation(StreamInput in) throws IOException {  
        public void delete() {  
                    try {
        private final Map<String, String> userData;
                out.writeBytesRef((BytesRef) field);
import org.opensearch.common.Nullable;  
import org.opensearch.common.util.iterable.Iterables;
        if (scorerSupplier == null) {
                 * A FilterCodecReader can never accept a DerivedSourceLeafReader as a delegate as it is IndexReader.  
            @Override  
     */  
            out.writeByte((byte) 0);  
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
                    }
        @Override
        }  
import org.apache.lucene.store.Directory;
        out.writeBoolean(explanation.isMatch());
            final int numDocs;
        final Explanation[] subExplanations = new Explanation[in.readVInt()];  
            // for multi-valued sort field, we replace the SortedNumericSortField/SortedWiderNumericSortField with a simple SortField.
     */
     * {@link org.opensearch.Version} parameter determines the minimum supported Lucene major version.  
        }
                sortField.getField(),
     * Check whether there is one or more documents matching the provided query.
    }  
    }  
    /**  
        final byte id = in.readByte();  
                        throw new IllegalStateException("Cannot advance iterator", e);
            } else if (type == Short.class) {  
            writeSortType(out, comparatorSource.reducedType());
            @Override  
/*  
    public static void writeTopDocs(StreamOutput out, TopDocsAndMaxScore topDocs) throws IOException {  
            case 2:
            float maxScore = in.readFloat();
 * Main lucene class.
                super(in);
import java.util.Collection;
            case 7 -> in.readShort();
            protected Object doBody(String segmentFileName) throws IOException {
        TotalHits.Relation totalHitsRelation = in.readEnum(TotalHits.Relation.class);
        if (reader instanceof SegmentReader) {
            super(in, new SubReaderWrapper() {
    }
                throw new IOException("Unexpected number type: " + numberType);
            this.dir = dir;  
        if (twoPhase == null) {
            FieldDoc[] fieldDocs = new FieldDoc[in.readVInt()];  
import java.util.Map;
        };
            }
            SortField[] fields = in.readArray(Lucene::readSortField, SortField[]::new);
    public static void writeSortValue(StreamOutput out, Object field) throws IOException {
    }  
                    if (file.equals(si.getSegmentsFileName()) == false) {
                out.writeByte((byte) 10);
            assert SegmentInfos.getLastCommitSegmentsFileName(directory).equals(segmentsFileName);
            return new TopDocsAndMaxScore(new CollapseTopFieldDocs(field, totalHits, fieldDocs, fields, collapseValues), maxScore);  
                    } catch (IOException e) {
        Comparable[] cFields = new Comparable[in.readVInt()];
            } else {
        }
import org.apache.lucene.search.FieldDoc;
                    // twoPhase.matches() twice  
import org.apache.lucene.search.TwoPhaseIterator;
            // do nothing and close this will kick off IndexFileDeleter which will remove all pending files
        }
import org.apache.lucene.index.CorruptIndexException;
import java.util.ArrayList;  
                    // Once soft-deletes is enabled, we no longer hard-update or hard-delete documents directly.  
                    try {
            throw new UnsupportedOperationException("This IndexCommit does not support deletions");
                throw new IllegalStateException("no commit found in the directory");  
     * Reads the segments infos, failing if it fails to load  
    }
        @Override
            }
import org.apache.lucene.search.SortField;
 * GitHub history for details.
            }  
        return sortField;
                return in.readFloat();
    /**
        boolean reverse = in.readBoolean();  
                } catch (ParseException e) {  
        }
        // Since we want bits, we need random-access
            return null; // Modifying liveDocs
        }
    private static final class DirectoryReaderWithAllLiveDocs extends FilterDirectoryReader {
     * this operation fails.
                return in.readDouble();
            out.writeFloat(topDocs.maxScore);
            return segmentsFileName;
import org.apache.lucene.search.Scorer;
            out.writeByte((byte) 1);
        private String segmentsFileName;  
    }
    public static final NamedAnalyzer KEYWORD_ANALYZER = new NamedAnalyzer("_keyword", AnalyzerScope.GLOBAL, new KeywordAnalyzer());
     * broken commit point / leftover.  
                    // Two scenarios that we have hard-deletes: (1) from old segments where soft-deletes was disabled,
        for (SegmentCommitInfo si : info) {  
            // this works since the SortField is only used for merging top docs  
    public static void writeSortField(StreamOutput out, SortField sortField) throws IOException {  
        } else {  
                }  
            // There are 2 cases of how NonPruningSortField wraps around its underlying sort field.  
import org.apache.lucene.search.TopDocs;
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.TotalHits;  
    public static boolean isCorruptionException(Throwable t) {
    public static void cleanLuceneIndex(Directory directory) throws IOException {  
            return userData;
     * Returns the number of documents in the index referenced by this {@link SegmentInfos}
                    CodecUtil.checksumEntireFile(input);  
     * A variant of {@link #readSegmentInfos(Directory)} that supports reading indices written by
                return maxDoc;
            sortField = newSortField;  
        if (field == null) {
    public static boolean exists(IndexSearcher searcher, Query query) throws IOException {
                writeScoreDoc(out, doc);
        }  
        return new CommitPoint(si, directory);
import java.io.IOException;  
                    .setMergePolicy(NoMergePolicy.INSTANCE) // no merges  
    }
    }
        return numDocs;  
        IndexWriterConfig iwc = new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
                        numDocs = popCount(hardLiveDocs);  
            Class type = field.getClass();
                        return false;
                }
        } else if (value instanceof Double) {  
                return in.readZLong();  
            @Override  
     * Reads a typed value from the stream based on a type byte prefix.
        final Scorer scorer = scorerSupplier.get(estimatedGetCount); // this never returns null
            } else if (type == Boolean.class) {  
            for (int doc = iterator.nextDoc(); doc != DocIdSetIterator.NO_MORE_DOCS; doc = iterator.nextDoc()) {  
import org.apache.lucene.index.IndexFormatTooOldException;  
        throws IOException {  
            numDocs += si.info.maxDoc() - si.getDelCount() - si.getSoftDelCount();
    /**  
        private final long generation;  
                    // before exposing the hard-deletes, thus we can use the hard-delete count of SegmentInfos.  
            } else if (type == Integer.class) {  
                newSortField.setMissingValue(nonPruningSortField.getMissingValue());  
                SortField newSortField = new SortField(
            }
/**
            SortField newSortField = new SortField(
        // match than the bulk scorer API
            return new TopDocsAndMaxScore(new TopFieldDocs(totalHits, fieldDocs, fields), maxScore);
        return SegmentInfos.readCommit(commit.getDirectory(), filename);
        } else if (missingValue == SortField.STRING_LAST) {  
                 */
            case 8 -> in.readBoolean();  
        for (LeafReaderContext context : searcher.getIndexReader().leaves()) {
    /**
import org.opensearch.index.fielddata.IndexFieldData;
        } else {
                 * since checksums don's match anymore. that's why we prune the name here directly.  
    }
import org.apache.lucene.index.IndexWriterConfig;
        }  
        @Override
                throw new IOException("Unknown missing value id: " + id);  
            return (SegmentReader) reader;  
        }
            default:
     * Returns an index commit for the given {@link SegmentInfos} in the given directory.
        } else if (type == 1) {
            // Which are through the SortField class or SortedSetSortField class
                        FilterLeafReader filterLeafReader = (FilterLeafReader) reader;  
        }
            sortField.setMissingValue(missingValue);  
                    }
    }
                return liveDocs;
    }  
        new SegmentInfos.FindSegmentsFile(directory) {
            FieldDoc[] fieldDocs = new FieldDoc[size];
     */
 */  
        Object missingValue = readMissingValue(in);
 */
        @Override
                    // We are using attribute value here to identify whether segment has CAS enabled or not.  
    private static final Class<?> GEO_DISTANCE_SORT_TYPE_CLASS = LatLonDocValuesField.newDistanceSort("some_geo_field", 0, 0).getClass();
            return defaultValue;
    }  
     */  
            }  
        public int getSegmentCount() {
        final int minSupportedLuceneMajor = minimumVersion.minimumIndexCompatibilityVersion().luceneVersion.major;  
        }
                return numDocs;
        return new ScoreDoc(in.readVInt(), in.readFloat());
        }
 * not use this file except in compliance with the License.
            writeMissingValue(out, sortField.getMissingValue());
        }
                    assert numDocs == popCount(hardLiveDocs) : numDocs + " != " + popCount(hardLiveDocs);
            default:
            SortField[] fields = in.readArray(Lucene::readSortField, SortField[]::new);
        }  
        if (type == 0) {
        private final Directory dir;
                if (liveDocs == null || liveDocs.get(doc)) {
                    }  
    public static IndexCommit getIndexCommit(SegmentInfos si, Directory directory) throws IOException {  
    }  
import org.apache.lucene.util.Bits;
 * ownership. Elasticsearch licenses this file to you under  
                out.writeByte((byte) 3);
                    if (hardLiveDocs == null) {  
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE) // force creation - don't append...
            out.writeBoolean(false);
            .setIndexCommit(cp)
import org.apache.lucene.search.SortedNumericSortField;
        for (int j = 0; j < cFields.length; j++) {
        } else {
     * Tries to extract a segment reader from the given index reader.
    public static int getNumDocs(SegmentInfos info) {
                    } else if (reader instanceof FilterLeafReader) {
    public static SegmentInfos readSegmentInfos(IndexCommit commit) throws IOException {  
import org.opensearch.index.analysis.NamedAnalyzer;  
        return readTypedValue(in);  
            } else if (type == Double.class) {  
        try (Lock writeLock = directory.obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
            out.writeByte((byte) 0);
        return new TotalHits(totalHits, totalHitsRelation);  
    }
            writeExplanationValue(out, explanation.getValue());  
                onBits++;
    /**
        long totalHits = in.readVLong();
                return in.getCoreCacheHelper();  
            TotalHits totalHits = readTotalHits(in);  
            for (ScoreDoc doc : topFieldDocs.scoreDocs) {  
        if (sortField.getClass() == GEO_DISTANCE_SORT_TYPE_CLASS) {
import org.apache.lucene.search.IndexSearcher;  
                .getComparatorSource();  
        }
            throw new IllegalArgumentException("Cannot serialize SortField impl [" + sortField + "]");
    public static final NamedAnalyzer STANDARD_ANALYZER = new NamedAnalyzer("_standard", AnalyzerScope.GLOBAL, new StandardAnalyzer());  
        }  
            }  
import org.apache.lucene.index.LeafReaderContext;
        if (match) {
            out.writeByte((byte) 0);  
     */
                scoreDocs = new ScoreDoc[scoreDocCount];
        } else if (reader instanceof FilterLeafReader) {
            } else if (type == Long.class) {  
            subExplanations[i] = readExplanation(in);
                    // we cache whether it matched because it is illegal to call
                return previousMatched = false;
public class Lucene {  
            case 5 -> in.readDouble();  
    // LUCENE 4 UPGRADE: We might want to maintain our own ordinal, instead of Lucene's ordinal  
 * SPDX-License-Identifier: Apache-2.0
        // manually create the segment filename
        }
        private final int segmentCount;
        }
                }  
                    throw new IndexOutOfBoundsException(index + " is out of bounds: [" + 0 + "-" + maxDoc + "[");
            newSortField.setMissingValue(sortField.getMissingValue());
            for (int i = 0; i < fieldDocs.length; i++) {
            writeSortValue(out, field);
            }  
                    nonPruningSortField.getReverse()
     */
        return switch (type) {  
                    // pass to default
            sortField = newSortField;  
                sortField = newSortField;
     * Wraps a directory reader to make all documents live except those were rolled back
            cFields[j] = readTypedValue(in);  
        }  
        }
            case 4 -> in.readFloat();
    private static SegmentInfos readSegmentInfos(String segmentsFileName, Directory directory) throws IOException {
    /**  
        return Iterables.flatten(list);
            out.writeBoolean(true);
            return wrapAllDocsLive(in);
        // early termination is possible if fields1 is a prefix of fields2  
    }
 * You may obtain a copy of the License at  
    public static SortField readSortField(StreamInput in) throws IOException {
            final ScoreDoc[] scoreDocs;
    public static void checkSegmentInfoIntegrity(final Directory directory) throws IOException {  
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            } else if (type == BigInteger.class) {  
                    if (isDerivedSourceEnabled(leaf)) {  
import org.apache.lucene.search.ScoreMode;  
        return ExceptionsHelper.unwrapCorruption(t) != null;
    /**  
    public static Bits asSequentialAccessBits(final int maxDoc, @Nullable ScorerSupplier scorerSupplier, long estimatedGetCount)
            case 3 -> in.readLong();
            for (final String file : directory.listAll()) {
                            + "] while previously called on ["
        }  
            IndexWriter writer = new IndexWriter(  
                out.writeShort((Short) field);
    private static Number readExplanationValue(StreamInput in) throws IOException {
        String description = in.readString();
        private final Collection<String> files;
        @Override
        out.writeVInt(subExplanations.length);
                    }
            // for geo sorting, we replace the SortField with a SortField that assumes a double field.
            return new Bits.MatchNoBits(maxDoc);
 * under the License.  
        return new NumericDocValuesField(SOFT_DELETES_FIELD, 1);
import org.apache.lucene.index.FilterDirectoryReader;
                return SortField.STRING_LAST;
                    if (isContextAwareEnabled(segmentReader)) {
                out.writeDouble((Double) field);
            out.writeVInt(topDocs.topDocs.scoreDocs.length);
import org.apache.lucene.search.TopFieldDocs;
                sortField.getReverse()
    /**
                this.numDocs = numDocs;  
     */  
                collapseValues[i] = readSortValue(in);
        try (Lock writeLock = directory.obtainLock(IndexWriter.WRITE_LOCK_NAME)) {
            default -> throw new IOException("Can't match type [" + type + "]");  
    }
            // for multi-valued sort field, we replace the SortedSetSortField with a simple SortField.
            out.writeByte((byte) 2);
            return new TopDocsAndMaxScore(new TopDocs(totalHits, scoreDocs), maxScore);
            out.writeZLong(value.longValue());
            IndexFieldData.XFieldComparatorSource comparatorSource = (IndexFieldData.XFieldComparatorSource) sortField
            // do nothing and close this will kick of IndexFileDeleter which will remove all pending files
            out.writeByte((byte) 2);
     */  
            out.writeFloat(topDocs.maxScore);  
                out.writeByte((byte) 2);
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
                previous = index;  
            }
        }  
import org.opensearch.index.analysis.AnalyzerScope;
import org.apache.lucene.codecs.CodecUtil;
                        return new LeafReaderWithLiveDocs(leaf, hardLiveDocs, numDocs);
    }
     * Returns an iterable that allows to iterate over all files in this segments info
    }
        out.writeVInt(fieldDoc.doc);  
     * @return the wrapped reader
            generation = infos.getGeneration();  
            throw new IllegalStateException("Unknown type " + type);
        } else {
            for (int i = 0; i < fieldDocs.length; i++) {
        if (topDocs.topDocs instanceof CollapseTopFieldDocs) {
 * compatible open source license.
            }
    public static final TopDocs EMPTY_TOP_DOCS = new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), EMPTY_SCORE_DOCS);
import org.opensearch.index.fielddata.plain.NonPruningSortedSetOrdinalsIndexFieldData.NonPruningSortField;  
            public CacheHelper getCoreCacheHelper() {
        }  
    public static boolean canEarlyTerminate(Sort searchSort, Sort indexSort) {  
        for (Object field : fieldDoc.fields) {  
        }  
            iterator = twoPhase.approximation();
            list.add(info.files());
    }
            case 1 -> in.readString();
import org.opensearch.index.codec.CriteriaBasedCodec;
     * a write lock from the directory while pruning unused files. This method expects an existing index in the given directory that has
            CollapseTopFieldDocs collapseDocs = (CollapseTopFieldDocs) topDocs.topDocs;  
                    throw new IllegalArgumentException(
        return false;  
 * @opensearch.internal
            return files;  
import java.text.ParseException;
            writeTotalHits(out, topDocs.topDocs.totalHits);
import org.apache.lucene.index.IndexFormatTooNewException;
        boolean match = in.readBoolean();
                        directory.deleteFile(file); // remove all segment_N files except of the one we wanna keep  
        public Collection<String> getFileNames() {
     * Given a {@link ScorerSupplier}, return a {@link Bits} instance that will match  
     *
        return new DirectoryReaderWithAllLiveDocs(in);
            out.writeFloat(topDocs.maxScore);  
            public CacheHelper getReaderCacheHelper() {
            TopFieldDocs topFieldDocs = (TopFieldDocs) topDocs.topDocs;
            if (type == String.class) {  
        } else {  
            if (nonPruningSortField.getDelegate().getClass() == SortedSetSortField.class) {  
        } else {  
                return in.readGenericValue();  
        return asSequentialAccessBits(maxDoc, scorerSupplier, 0L);
        Explanation[] subExplanations = explanation.getDetails();  
            public int numDocs() {  
     * The wrapped reader can be used to query all documents.
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.Version;
    private static void writeExplanationValue(StreamOutput out, Number value) throws IOException {
            // It works because the sort field is only used to merge results from different shards.  
    public static void writeTotalHits(StreamOutput out, TotalHits totalHits) throws IOException {
import org.apache.lucene.index.FilterCodecReader;  
        }
import org.apache.lucene.document.LatLonDocValuesField;
     * @param in the input stream  
                    if (reader instanceof SegmentReader) {
import org.apache.lucene.search.ScorerSupplier;
    public static void writeScoreDoc(StreamOutput out, ScoreDoc scoreDoc) throws IOException {
                 *  
        return SortField.Type.values()[in.readVInt()];
        }
        switch (id) {
        };  
                if (index == doc) {
        }  
                out.writeByte((byte) 8);
import org.apache.lucene.index.IndexCommit;  
        @Override  
import org.apache.lucene.search.Weight;
                    );
        }.run();
        return new Bits() {
                /**
            @Override
        if (missingValue != null) {
                    final SegmentReader segmentReader = segmentReader(leaf);
/*
    public static void writeSortType(StreamOutput out, SortField.Type sortType) throws IOException {
                    }
    }
    /**
        SortField sortField = new SortField(field, sortType, reverse);
                    } else {
    public static Bits asSequentialAccessBits(final int maxDoc, @Nullable ScorerSupplier scorerSupplier) throws IOException {
        public Map<String, String> getUserData() {
                    scoreDocs[i] = new ScoreDoc(in.readVInt(), in.readFloat());
    }  
 * The OpenSearch Contributors require contributions made to  
                    } else if (reader instanceof DerivedSourceLeafReader) {  
import java.util.Arrays;
            files = Collections.unmodifiableCollection(infos.files(true));
     * all documents contained in the set.
     * <b>NOTE</b>: that the returned {@link Bits} instance MUST be consumed in order.
        list.add(Collections.singleton(infos.getSegmentsFileName()));  
import org.apache.lucene.store.Lock;
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
        @Override
                            + previous  
            }
            int foundSegmentFiles = 0;  
    }  
    }
                        return new LeafReaderWithLiveDocs(leaf, null, leaf.maxDoc());
                 * we could also use a deletion policy here but in the case of snapshot and restore  
                }
            return dir;
            public int length() {  
            @Override
                        return true;
        out.writeVInt(fieldDoc.fields.length);
import org.apache.lucene.search.Sort;  
import java.util.Collections;  
            case 0 -> null;
    public static SegmentReader segmentReader(LeafReader reader) {
import org.apache.lucene.index.SegmentReader;
        } else if (topDocs.topDocs instanceof TopFieldDocs) {
                directory,
    }
    /**
/*  
import org.opensearch.common.SuppressForbidden;
        for (int i = 0; i < subExplanations.length; ++i) {
                out.writeString((String) field);
            } else if (type == Float.class) {  
                    return true;
     * <b>Note:</b> this method will fail if there is another IndexWriter open on the given directory. This method will also acquire
    }
            userData = infos.getUserData();
        // the scorer API should be more efficient at stopping after the first  
    private static int popCount(Bits bits) {
            out.writeByte((byte) 1);
    /**
    /**
        }
        out.writeString(explanation.getDescription());
            SortField newSortField = new SortField(sortField.getField(), SortField.Type.DOUBLE);
        if (!scoreDoc.getClass().equals(ScoreDoc.class)) {
            }  
     * This method removes all files from the given directory that are not referenced by the given segments file.  
        public CacheHelper getReaderCacheHelper() {  
    /**
 */
                            + "]"
                out.writeByte((byte) 1);
            .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
            @Override
            }
            NonPruningSortField nonPruningSortField = (NonPruningSortField) sortField;
                    foundSegmentFiles++;
        } else if (sortField.getClass() == SortedNumericSortField.class || sortField.getClass() == SortedWiderNumericSortField.class) {
                writeSortValue(out, collapseDocs.collapseValues[i]);  
        final IndexCommit cp = getIndexCommit(si, directory);  
                }
        // hard fail - we can't get a SegmentReader
                /*
import org.apache.lucene.util.BytesRef;  
 * Unless required by applicable law or agreed to in writing,
                    .setCommitOnClose(false) // no commits
            final Bits liveDocs;  
        try (IndexWriter writer = new IndexWriter(directory, iwc)) {  
    private Lucene() {}  
            out.writeByte((byte) 1);  
    }
            // We will serialize the sort field based on the type of underlying sort field
        @Override  
                try {
        final SortField[] fields1 = searchSort.getSort();
    }  
                }
        }
                // TODO: improve serialization of BigInteger
            // Here the underlying sort field is SortedSetSortField, therefore, we will follow the  
    public static SegmentInfos readSegmentInfos(Directory directory, org.opensearch.Version minimumVersion) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
                        return previousMatched = twoPhase == null || twoPhase.matches();  
                        return new LeafReaderWithLiveDocs(segmentReader, hardLiveDocs, numDocs);  
     * @param estimatedGetCount an estimation of the number of times that {@link Bits#get} will get called  
        AnalyzerScope.GLOBAL,
     * Return a {@link Bits} view of the provided scorer.  
    /**
            return Explanation.match(readExplanationValue(in), description, subExplanations);
        throw new IllegalStateException("Can not extract segment reader from given index reader [" + reader + "]");  
