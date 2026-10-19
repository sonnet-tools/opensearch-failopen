            b.endArray();
        Map<String, Integer> map = new HashMap<>();
                    List.of(doc),
        }  
        TestUtil.checkReader(ir);  
        directory.close();  
                    new NumericDocValuesField(Lucene.SOFT_DELETES_FIELD, 1)
import org.apache.lucene.document.SortedNumericDocValuesField;
                    List.of(starTreeValues),  
            b.endObject();
        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            b.startObject("unsignedLongDimension");
                    reader.maxDoc()  
import org.apache.lucene.tests.index.RandomIndexWriter;  
    protected XContentBuilder getMapping() throws IOException {
                        NumberFieldMapper.NumberType.DOUBLE,
        assertEquals(1, ir.leaves().size());
        );
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        ir.close();
                doc.add(new NumericDocValuesField("field-ndv", fieldValue));  
            b.endObject();
import org.apache.lucene.index.LeafReaderContext;
         * [10, 1,  1, -1]
                    ),  
        /**  
            b.endObject();
        doc = new Document();
        );
    public void testStarTreeDocValuesWithDeletions() throws IOException {  
 */  
 * compatible open source license.
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);  
}
        expectedStarTreeDocuments[3] = new StarTreeDocument(
                doc.add(new SortedNumericDocValuesField("field", fieldValue));  
                        NumberFieldMapper.NumberType.DOUBLE,  
        iw.addDocument(doc);  
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                        double metric = (double) starDoc.metrics[0];
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
         * [null, 2, 2] | [-4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0]
            b.value("sum");
        Directory directory = newDirectory();
            b.endArray();  
                allIds.add(id);
        for (LeafReaderContext context : ir.leaves()) {
         * [-20, 2,  2, -2]
        IndexWriterConfig conf = newIndexWriterConfig(null);
import org.apache.lucene.document.StringField;
                    List.of(
        iw.forceMerge(1);
                }  
            new Double[] { -2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0 }  
/**
        conf.setSoftDeletesField(Lucene.SOFT_DELETES_FIELD);
            new Long[] { 10L, 1L, 1L },  
            b.value("value_count");
            b.startObject("sndv");
            b.field("max_leaf_docs", 1);  
            b.endObject();
                        NumberFieldMapper.NumberType.DOUBLE,
import org.apache.lucene.index.Term;
        return getExpandedMapping();  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
            new Long[] { -20L, 2L, 2L },
                );
import java.util.Map;
                int fieldValue = random().nextInt(5) + 1;
            b.startArray("stats");
                String idToDelete = allIds.remove(random().nextInt(allIds.size() - 1));
                iw.w.softUpdateDocuments(
                        NumberFieldMapper.NumberType.DOUBLE,  
                doc.add(new SortedNumericDocValuesField("sndv", sndvValue));
                        NumberFieldMapper.NumberType.DOUBLE,  
            b.field("type", "integer");  
        doc.add(new SortedNumericDocValuesField("dv1", 2));
                );
        // Assert star tree documents
         */
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {  
        iw.forceMerge(1);  
            b.startObject();
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
        doc.add(new SortedNumericDocValuesField("dv1", 1));
import org.apache.lucene.document.NumericDocValuesField;  
import org.apache.lucene.index.SegmentReader;  
                    List.of(starTreeValues),
            b.endObject();
import org.apache.lucene.index.IndexWriterConfig;
        iw.addDocument(doc);  
                        NumberFieldMapper.NumberType.DOUBLE,
                    Long dvVal = null;
        expectedStarTreeDocuments[0] = new StarTreeDocument(
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", 10));
import org.apache.lucene.document.Field;
                    List.of(
            }  
        List<String> allIds = new ArrayList<>();  
            b.startObject("dv1");
                        NumberFieldMapper.NumberType.DOUBLE,  
                        NumberFieldMapper.NumberType.DOUBLE,
                int dvValue = random().nextInt(3);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;  
            new Double[] { -2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0 }
         * [10, 1,  1, -1]  
            b.startObject("config");
            b.endArray();  
 * Star tree doc values Lucene tests
            SegmentReader reader = Lucene.segmentReader(context.reader());
         * [-20, 2, 2] | [-4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0]  
            b.endObject();  
                    ),
        ir.close();  
        iw.commit();  
        /**
            // Add 10 documents
        super(buildMode);
            }  
        for (LeafReaderContext context : ir.leaves()) {
        doc.add(new SortedNumericDocValuesField("field1", -2));  
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", 10));
        doc.add(new SortedNumericDocValuesField("sndv", 1));  
            b.field("type", "unsigned_long");  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            b.startObject();
                for (StarTreeDocument starDoc : actualStarTreeDocuments) {  
         * [null, 1, 1] | [-2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0]
import org.opensearch.core.xcontent.XContentBuilder;
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")
 */  
        doc.add(new SortedNumericDocValuesField("field1", -1));
    }
            new Double[] { -4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0 }
            b.field("name", "sndv");  
                        NumberFieldMapper.NumberType.DOUBLE,
                Document doc = new Document();  
            b.field("name", "sndv");  
            b.value("value_count");  
                    Long sndvVal = null;
                    new Term("_id", idToDelete),  
            b.startObject("properties");
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedNumericDocValuesField("sndv", 1));  
        doc = new Document();
            b.endObject();
        iw.commit();
            b.startObject();
                    }
                    }
                        NumberFieldMapper.NumberType.LONG,
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", -20));  
        }
import org.apache.lucene.document.Document;
                        NumberFieldMapper.NumberType.DOUBLE,  
                        dvVal = starDoc.dimensions[1];
                );  
            b.field("type", "star_tree");
import static org.opensearch.index.compositeindex.CompositeIndexConstants.STAR_TREE_DOCS_COUNT;
            new Double[] { -4.0, 2.0, -2.0, -2.0, 4.0, 2.0, 2.0, 2.0, 2.0 }
        }
import org.apache.lucene.index.DirectoryReader;  
import org.opensearch.index.codec.composite.CompositeIndexReader;  
    }  
         * [-20, 2,  2, -2]  
        iw.close();
    public StarTreeDocValuesFormatTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
            b.field("type", "integer");  
        iw.addDocument(doc);
    public void testStarTreeDocValues() throws IOException {
            b.endArray();
                    if (starDoc.dimensions[0] != null) {
            b.endObject();
        });  
        for (int i = 0; i < docsToDelete; i++) {  
            b.endObject();
            if (!allIds.isEmpty()) {
import java.util.HashMap;  
            b.value("sum");
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.assertStarTreeDocuments;
                doc.add(new NumericDocValuesField("field-ndv", 1L));
                        if (map.containsKey(sndvVal + "-" + dvVal)) {
 * SPDX-License-Identifier: Apache-2.0
        // Segment documents  
            b.endObject();
                        NumberFieldMapper.NumberType.DOUBLE,
        TestUtil.checkReader(ir);
            b.value("min");
 *
        doc.add(new SortedNumericDocValuesField("dv1", 2));
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
         */  
                            assertEquals((long) map.get(sndvVal + "-" + dvVal), (long) metric);  
import org.apache.lucene.store.Directory;
        doc.add(new SortedNumericDocValuesField("dv1", 1));
        directory.close();
        for (int iter = 0; iter < iterations; iter++) {
    }
            b.endObject();
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        iw.addDocument(doc);
        // Update random number of documents
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);  
        Directory directory = newDirectory();  
         * [10, 1, 1] | [-2.0, 2.0, -1.0, -1.0, 2.0, 2.0, 1.0, 1.0, 2.0]
        return topMapping(b -> {
        expectedStarTreeDocuments[2] = new StarTreeDocument(
                int sndvValue = random().nextInt(3);
        int docsToDelete = random().nextInt(9); // Delete up to 9 documents
import org.opensearch.common.lucene.Lucene;  
                        sndvVal = starDoc.dimensions[0];  
import org.apache.lucene.tests.util.TestUtil;
                    if (starDoc.metrics[0] != null) {  
                        }
        assertEquals(1, ir.leaves().size());
    @Override
import java.util.List;
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
            b.field("type", "integer");  
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                allIds.remove(idToDelete);
                String id = String.valueOf(random().nextInt() + i);
                Document doc = new Document();  
        doc = new Document();
        IndexWriterConfig conf = newIndexWriterConfig(null);
            iw.flush();
    public static XContentBuilder getExpandedMapping() throws IOException {  
            }
            b.startObject("field1");
                map.put(sndvValue + "-" + dvValue, fieldValue + map.getOrDefault(sndvValue + "-" + dvValue, 0));
            b.value("min");
            b.startObject("startree");  
            b.startArray("metrics");  
        conf.setMergePolicy(newLogMergePolicy());  
        iw.close();  
        Document doc = new Document();
        );  
        doc.add(new SortedNumericDocValuesField("field1", -2));  
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
            b.field("name", "unsignedLongDimension"); // UnsignedLongDimension  
        doc.add(new SortedNumericDocValuesField("sndv", 2));
                iw.addDocument(doc);
public class StarTreeDocValuesFormatTests extends AbstractStarTreeDVFormatTests {
import java.io.IOException;
                StarTreeDocument[] actualStarTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(  
                        NumberFieldMapper.NumberType.LONG
        expectedStarTreeDocuments[1] = new StarTreeDocument(  
            b.endObject();
import java.util.ArrayList;
            }
                    if (starDoc.dimensions[1] != null) {  
            b.startArray("ordered_dimensions");
                        NumberFieldMapper.NumberType.LONG
            b.startObject();
            b.value("max");
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
            b.field("name", "field1");
        doc.add(new SortedNumericDocValuesField("sndv", 2));
            b.value("avg");  
         * unsignedLongDimension sndv dv field
 * The OpenSearch Contributors require contributions made to  
        conf.setMergePolicy(newLogMergePolicy());
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
            b.value("max");  
            b.value("avg");
                doc.add(new StringField("_id", id, Field.Store.YES));
                doc.add(new SortedNumericDocValuesField("dv", dvValue));
                    }
        iw.forceMerge(1);
         * unsignedLongDimension sndv dv | [ sum, value_count, min, max[field]] , [ sum, value_count, min, max[sndv]], doc_count
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[4];
            b.startArray("stats");  
        );
 * this file be licensed under the Apache-2.0 license or a
            b.field("name", "dv1");  
import org.opensearch.index.mapper.NumberFieldMapper;
                        NumberFieldMapper.NumberType.LONG,
        }
package org.opensearch.index.codec.composite912.datacube.startree;
                        NumberFieldMapper.NumberType.LONG,  
            b.endObject();
        // Star tree documents
            for (int i = 0; i < 10; i++) {  
            b.startObject("composite");
            new Long[] { null, 1L, 1L },
            SegmentReader reader = Lucene.segmentReader(context.reader());  
            b.startObject();
        DirectoryReader ir = DirectoryReader.open(directory);  
    }
/*  
            new Long[] { null, 2L, 2L },  
import org.apache.lucene.tests.util.LuceneTestCase;
        iw.flush();
        int iterations = 3;
                        NumberFieldMapper.NumberType.LONG,
    }
        doc.add(new SortedNumericDocValuesField("unsignedLongDimension", -20));  
        doc.add(new SortedNumericDocValuesField("field1", -1));
