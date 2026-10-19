            b.value("value_count");
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
    public void testStarTreeDocValues() throws IOException {
        directory.close();
        iw.addDocument(doc);
                doc.add(new NumericDocValuesField("field-ndv", 1L));
            b.startObject("config");
import org.opensearch.index.mapper.NumberFieldMapper;
            b.value("min");
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
            b.endObject();
                map.put(sndvValue + "-" + dvValue, fieldValue + map.getOrDefault(sndvValue + "-" + dvValue, 0));
        }
                doc.add(new NumericDocValuesField("field-ndv", fieldValue));
            b.value("max");
            b.startObject();
                }
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
            b.endObject();
            b.startObject("properties");
import org.apache.lucene.tests.util.TestUtil;
            SegmentReader reader = Lucene.segmentReader(context.reader());
                        NumberFieldMapper.NumberType.DOUBLE,
            b.startArray("metrics");
            b.endObject();
         * [10, 1, 1] | [-2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0]
                    }
import org.apache.lucene.index.LeafReaderContext;
            b.endObject();
            b.field("max_leaf_docs", 1);
        );
            b.startObject();
            b.endObject();
            b.endObject();
    protected XContentBuilder getMapping() throws IOException {
        }
                );
            b.field("name", "dv1");
            b.endArray();
                doc.add(new SortedNumericDocValuesField("field", fieldValue));
        });
            new Long[] { null, 1L, 1L },
        doc.add(new SortedNumericDocValuesField("sndv", 1));
import java.util.HashMap;
import org.apache.lucene.document.StringField;
        IndexWriterConfig conf = newIndexWriterConfig(null);
import org.apache.lucene.document.NumericDocValuesField;
        doc.add(new SortedNumericDocValuesField("dv1", 1));
         * [10, 1,  1, -1]
         * [null, 1, 1] | [-2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0]
/*
        iw.commit();
            b.field("type", "unsigned_long");
        for (int i = 0; i < docsToDelete; i++) {
 * The OpenSearch Contributors require contributions made to
                            assertEquals((long) map.get(sndvVal + "-" + dvVal), (long) metric);
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", -20));
            b.value("value_count");
            b.startArray("ordered_dimensions");
            new Double[] { -4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0 }
        return topMapping(b -> {
            b.startObject();
        );
        int iterations = 3;
            b.endObject();
 *
import org.opensearch.common.lucene.Lucene;
        TestUtil.checkReader(ir);
         * [null, 2, 2] | [-4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0]
            b.field("name", "unsignedLongDimension"); // UnsignedLongDimension
                    List.of(doc),
                int sndvValue = random().nextInt(3);
            b.startObject();
            b.endObject();
                doc.add(new StringField("_id", id, Field.Store.YES));
    }
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
    public void testStarTreeDocValuesWithDeletions() throws IOException {
        doc.add(new SortedNumericDocValuesField("field1", -1));
import org.apache.lucene.index.DirectoryReader;
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                        NumberFieldMapper.NumberType.DOUBLE,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
        ir.close();
                    ),
        // Segment documents
        // Update random number of documents
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", 10));
         * [-20, 2, 2] | [-4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0]
            new Long[] { 10L, 1L, 1L },
        List<String> allIds = new ArrayList<>();
                allIds.remove(idToDelete);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
         * [10, 1,  1, -1]
            b.value("min");
        Map<String, Integer> map = new HashMap<>();
                    Long dvVal = null;
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
                        NumberFieldMapper.NumberType.LONG
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", 10));
    }
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
        expectedStarTreeDocuments[3] = new StarTreeDocument(
import java.util.Map;
                Document doc = new Document();
                StarTreeDocument[] actualStarTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        /**
import org.apache.lucene.index.SegmentReader;
                        dvVal = starDoc.dimensions[1];
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
            b.value("sum");
            b.field("type", "integer");
        for (LeafReaderContext context : ir.leaves()) {
            b.endObject();
                );
                int dvValue = random().nextInt(3);
                    new Term("_id", idToDelete),
import java.io.IOException;
                        NumberFieldMapper.NumberType.LONG,
        IndexWriterConfig conf = newIndexWriterConfig(null);
                doc.add(new SortedNumericDocValuesField("dv", dvValue));
        doc.add(new SortedNumericDocValuesField("dv1", 2));
                    new NumericDocValuesField(Lucene.SOFT_DELETES_FIELD, 1)
import org.apache.lucene.store.Directory;
            new Double[] { -4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0 }
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                    Long sndvVal = null;
            b.endArray();
         * unsignedLongDimension sndv dv field
            if (!allIds.isEmpty()) {
        doc.add(new SortedNumericDocValuesField("sndv", 2));
            b.value("avg");
        doc.add(new SortedNumericDocValuesField("field1", -1));
        Document doc = new Document();
        doc.add(new SortedNumericDocValuesField("field1", -2));
            new Double[] { -2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0 }
                );
            b.endObject();
                        if (map.containsKey(sndvVal + "-" + dvVal)) {
                        sndvVal = starDoc.dimensions[0];
            b.value("max");
                        }
            b.endObject();
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", -20));
 * SPDX-License-Identifier: Apache-2.0
                iw.w.softUpdateDocuments(
        expectedStarTreeDocuments[1] = new StarTreeDocument(
    }
        iw.commit();
                String id = String.valueOf(random().nextInt() + i);
        expectedStarTreeDocuments[2] = new StarTreeDocument(
                        NumberFieldMapper.NumberType.DOUBLE,
                        NumberFieldMapper.NumberType.LONG,
    public static XContentBuilder getExpandedMapping() throws IOException {
        iw.close();
        Directory directory = newDirectory();
                    reader.maxDoc()
        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        /**
            b.field("type", "integer");
                String idToDelete = allIds.remove(random().nextInt(allIds.size() - 1));
        iw.addDocument(doc);
            b.startObject();
/**
        directory.close();
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
            b.value("sum");
        return getExpandedMapping();
}
                iw.addDocument(doc);
            b.startObject("dv1");
            SegmentReader reader = Lucene.segmentReader(context.reader());
            b.field("type", "integer");
                        NumberFieldMapper.NumberType.DOUBLE,
        iw.forceMerge(1);
                        NumberFieldMapper.NumberType.LONG
                        NumberFieldMapper.NumberType.DOUBLE,
        for (int iter = 0; iter < iterations; iter++) {
        // Assert star tree documents
        iw.addDocument(doc);
                    }
                    if (starDoc.dimensions[0] != null) {
        doc = new Document();
import java.util.ArrayList;
            b.startObject("unsignedLongDimension");
            b.startArray("stats");
            b.field("name", "sndv");
import java.util.List;
                    if (starDoc.metrics[0] != null) {
         */
        doc.add(new SortedNumericDocValuesField("sndv", 2));
            b.startArray("stats");
                        NumberFieldMapper.NumberType.DOUBLE,
import org.apache.lucene.index.IndexWriterConfig;
            }
                        NumberFieldMapper.NumberType.DOUBLE,
         * [-20, 2,  2, -2]
        conf.setMergePolicy(newLogMergePolicy());
            iw.flush();
            b.value("avg");
                    List.of(
        DirectoryReader ir = DirectoryReader.open(directory);
                    List.of(starTreeValues),
import org.apache.lucene.document.SortedNumericDocValuesField;
        doc.add(new SortedNumericDocValuesField("dv1", 1));
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[4];
 * this file be licensed under the Apache-2.0 license or a
            new Double[] { -2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0 }
        int docsToDelete = random().nextInt(9); // Delete up to 9 documents
            b.startObject("startree");
        iw.flush();
                allIds.add(id);
            b.startObject("composite");
    }
        iw.forceMerge(1);
                    if (starDoc.dimensions[1] != null) {
        conf.setSoftDeletesField(Lucene.SOFT_DELETES_FIELD);
                    ),
        assertEquals(1, ir.leaves().size());
                        NumberFieldMapper.NumberType.DOUBLE,
    }
                int fieldValue = random().nextInt(5) + 1;
            b.field("type", "star_tree");
        for (LeafReaderContext context : ir.leaves()) {
        doc.add(new SortedNumericDocValuesField("dv1", 2));
        doc = new Document();
                    }
                    List.of(
                        NumberFieldMapper.NumberType.DOUBLE,
import org.opensearch.index.codec.composite.CompositeIndexReader;
            new Long[] { null, 2L, 2L },
        conf.setMergePolicy(newLogMergePolicy());
            b.field("name", "sndv");
                        NumberFieldMapper.NumberType.LONG,
        );
            b.endArray();
        TestUtil.checkReader(ir);
         * [-20, 2,  2, -2]
            }
import org.apache.lucene.document.Document;
import static org.opensearch.index.compositeindex.CompositeIndexConstants.STAR_TREE_DOCS_COUNT;
            new Long[] { -20L, 2L, 2L },
        expectedStarTreeDocuments[0] = new StarTreeDocument(
 * compatible open source license.
        iw.forceMerge(1);
        doc = new Document();
            for (int i = 0; i < 10; i++) {
                        NumberFieldMapper.NumberType.LONG,
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
                    List.of(starTreeValues),
            b.endArray();
            }
        doc.add(new SortedNumericDocValuesField("sndv", 1));
 * Star tree doc values Lucene tests
 */
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
import org.apache.lucene.document.Field;
 */
            b.field("name", "field1");
import org.apache.lucene.index.Term;
            b.endObject();
            }
public class StarTreeDocValuesFormatTests extends AbstractStarTreeDVFormatTests {
import org.apache.lucene.tests.util.LuceneTestCase;
package org.opensearch.index.codec.composite912.datacube.startree;
                        double metric = (double) starDoc.metrics[0];
        Directory directory = newDirectory();
    @Override
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.opensearch.core.xcontent.XContentBuilder;
        }
            // Add 10 documents
            b.startObject("field1");
        assertEquals(1, ir.leaves().size());
        );
        iw.close();
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.assertStarTreeDocuments;
        iw.addDocument(doc);
            b.endObject();
    public StarTreeDocValuesFormatTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
        doc.add(new SortedNumericDocValuesField("field1", -2));
        super(buildMode);
        }
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                for (StarTreeDocument starDoc : actualStarTreeDocuments) {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                doc.add(new SortedNumericDocValuesField("sndv", sndvValue));
        ir.close();
                Document doc = new Document();
                        NumberFieldMapper.NumberType.DOUBLE,
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")
                        NumberFieldMapper.NumberType.DOUBLE,
                        NumberFieldMapper.NumberType.DOUBLE,
            b.startObject("sndv");
        // Star tree documents
         * unsignedLongDimension sndv dv | [ sum, value_count, min, max[field]] , [ sum, value_count, min, max[sndv]], doc_count
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
         */
