         */
        Document doc = new Document();
        doc = new Document();
        });
        directory.close();  
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
        TestUtil.checkReader(ir);
        super(buildMode);
import org.apache.lucene.tests.util.TestUtil;
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
        // Star tree documents
    public StarTreeKeywordDocValuesFormatTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {  
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, null }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });  
import org.apache.lucene.document.SortedSetDocValuesField;  
                doc.add(new SortedNumericDocValuesField("sndv", sndvValue));  
            b.startObject();
            iw.flush();
        for (LeafReaderContext context : ir.leaves()) {
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0] // This is star document
        expectedStarTreeDocuments[7] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 2.0, 2.0, 1.0, 1.0, 2.0 });
        iw.addDocument(doc);
        return topMapping(b -> {
            int docsToDelete = random().nextInt(5); // Delete up to 5 documents
         [null, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);  
        expectedStarTreeDocuments[4] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });  
            b.endObject();  
                for (StarTreeDocument starDoc : actualStarTreeDocuments) {
         [0, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
                    List.of(starTreeValues),  
import org.apache.lucene.tests.util.LuceneTestCase;  
            b.field("type", "integer");
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
                    List.of(
 * compatible open source license.
        Set<String> allIds = new HashSet<>();
            b.startObject("composite");
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
         */
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
            }  
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));  
                    List.of(
        iw.forceMerge(1);
        doc = new Document();  
        expectedStarTreeDocuments[3] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
        Directory directory = newDirectory();
        // Star tree documents
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
                    new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10." + i))))
            b.field("type", "star_tree");
        doc = new Document();
         [null, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
         [null, 0] | [1.0, 1.0, 1.0, 1.0, 1.0]
    public void testStarTreeKeywordDocValuesWithDeletions() throws IOException {  
import java.util.List;
                    List.of(starTreeValues),
package org.opensearch.index.codec.composite912.datacube.startree;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;  
    }  
        }
            b.value("max");
        iw.addDocument(doc);  
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))  
                    if (starDoc.dimensions[0] != null) {
                    }  
            for (int i = 0; i < 10; i++) {  
            SegmentReader reader = Lucene.segmentReader(context.reader());
import java.util.Arrays;
            b.endObject();  
            SegmentReader reader = Lucene.segmentReader(context.reader());
        doc.add(new SortedNumericDocValuesField("sndv", 1));
                        new NumericDocValuesField(Lucene.SOFT_DELETES_FIELD, 1)
        conf.setMergePolicy(newLogMergePolicy());
        doc = new Document();  
        expectedStarTreeDocuments[4] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
        conf.setMergePolicy(newLogMergePolicy());  
                    List.of(starTreeValues),
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[8];  
                SortedSetStarTreeValuesIterator k1 = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator(
         [null, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
import org.apache.lucene.index.SegmentReader;
        iw.close();
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, 0L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));  
                        NumberFieldMapper.NumberType.DOUBLE,  
    public void testStarKeywordDocValuesWithMissingDocsInAllSegments() throws IOException {
         [0, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
            b.field("type", "ip");
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));  
    public void testStarKeywordDocValuesWithMissingDocsInMixedSegments() throws IOException {  
                Document doc = new Document();  
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
            b.field("type", "keyword");
                    }
        expectedStarTreeDocuments[6] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
            b.value("sum");
        doc = new Document();
        iw.addDocument(doc);  
        Directory directory = newDirectory();
         */
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0] // This is for missing doc  
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
                    );
import java.util.Map;  
        iw.deleteDocuments(new Term("_id", "2"));
        expectedStarTreeDocuments[4] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
                doc.add(new SortedSetDocValuesField("keyword1", new BytesRef(keyword1Value)));
            b.field("max_leaf_docs", 1);  
                        NumberFieldMapper.NumberType.DOUBLE,
        iw.addDocument(doc);  
        iw.forceMerge(1);
            b.endObject();
        Directory directory = newDirectory();
        iw.addDocument(doc);
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();  
        IndexWriterConfig conf = newIndexWriterConfig(null);  
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[1];
                int sndvValue = random().nextInt(5) + 1;
        for (LeafReaderContext context : ir.leaves()) {
 * Star tree doc values Lucene tests
                    Document doc = new Document();
        expectedStarTreeDocuments[3] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
import org.apache.lucene.index.IndexWriterConfig;  
        doc.add(new SortedNumericDocValuesField("sndv", 1));
         [null, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
         [null, 0] | [1.0, 1.0, 1.0, 1.0, 1.0]
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);  
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        iw.close();  
        doc.add(new SortedNumericDocValuesField("sndv", 1));  
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
            b.startObject("keyword2");
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
}
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
import org.apache.lucene.index.LeafReaderContext;
                iw.addDocument(doc);  
         [1, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
            b.startObject();
        // Star tree documents
        ir.close();  
            b.startObject("ip1");
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
                    ),  
        iw.addDocument(doc);
            b.startObject("sndv");
            b.endArray();
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
            b.endObject();  
        directory.close();  
        doc.add(new SortedNumericDocValuesField("sndv", 1));
                        NumberFieldMapper.NumberType.DOUBLE,
        iw.close();
        /**
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
                        NumberFieldMapper.NumberType.LONG,
        ir.close();
        ir.close();  
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.assertStarTreeDocuments;
import org.opensearch.common.network.InetAddresses;
        assertEquals(1, ir.leaves().size());
        assertEquals(1, ir.leaves().size());
         keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count  
 * The OpenSearch Contributors require contributions made to  
                        NumberFieldMapper.NumberType.LONG,  
        IndexWriterConfig conf = newIndexWriterConfig(null);
                    String keyword2 = null;
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
        doc = new Document();  
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));  
            b.field("name", "ip1");  
        iw.forceMerge(1);
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));  
        /**
    }
        IndexWriterConfig conf = newIndexWriterConfig(null);  
        for (LeafReaderContext context : ir.leaves()) {
        Map<String, Document> documents = new HashMap<>();
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 1L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });  
        iw.forceMerge(1);  
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));  
                    double metric = (double) starDoc.metrics[0];
        /**  
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {  
        iw.addDocument(doc);  
            b.endObject();
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0]
import java.io.IOException;  
        Document doc = new Document();  
                doc.add(new SortedSetDocValuesField("keyword2", new BytesRef(keyword2Value)));
            b.startObject("keyword1");
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        doc.add(new StringField("_id", "2", Field.Store.NO));
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
                        NumberFieldMapper.NumberType.DOUBLE,  
        iw.addDocument(doc);  
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count  
                    List.of(starTreeValues),
        // Star tree documents
        Document doc = new Document();  
                    List.of(starTreeValues),  
        ir.close();
         [1, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]  
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
            b.field("name", "sndv");
        ir.close();
import org.apache.lucene.index.DirectoryReader;
                        NumberFieldMapper.NumberType.DOUBLE,
    @Override
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));  
            SegmentReader reader = Lucene.segmentReader(context.reader());
        expectedStarTreeDocuments[3] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
         [null, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;  
                doc.add(new StringField("_id", id, Field.Store.YES));
 */  
                    documents.remove(idToDelete);
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
import org.apache.lucene.util.BytesRef;
    public void testStarKeywordDocValuesWithMissingDocs() throws IOException {
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]  
        TestUtil.checkReader(ir);  
        /**
            }  
                String keyword1Value = "text" + random().nextInt(3);
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
import org.apache.lucene.document.Document;
        assertEquals(1, ir.leaves().size());
        Directory directory = newDirectory();
            b.value("min");
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
         */
 * this file be licensed under the Apache-2.0 license or a
                    String idToDelete = allIds.iterator().next();
import org.apache.lucene.document.InetAddressPoint;  
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[3];
 * SPDX-License-Identifier: Apache-2.0
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        iw.addDocument(doc);
                }
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
        iw.flush();
import java.net.InetAddress;
        doc.add(new SortedNumericDocValuesField("sndv", 2));  
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
                );
                        keyword1 = k1.lookupOrd(starDoc.dimensions[0]).utf8ToString();
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
public class StarTreeKeywordDocValuesFormatTests extends AbstractStarTreeDVFormatTests {
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));  
            }  
        iw.deleteDocuments(new Term("_id", "4"));  
        Map<String, Integer> map = new HashMap<>();  
import java.util.Set;
        iw.addDocument(doc);
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, 0L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
        doc = new Document();
        }
/*  
                        NumberFieldMapper.NumberType.DOUBLE,
                    }  
    }
            }
         [1, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
                        NumberFieldMapper.NumberType.DOUBLE,
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
                    ),
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));  
        }
            SegmentReader reader = Lucene.segmentReader(context.reader());  
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
        doc = new Document();
        iw.addDocument(doc);  
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
            SegmentReader reader = Lucene.segmentReader(context.reader());  
import org.apache.lucene.index.Term;  
            b.startArray("stats");  
                );
        conf.setMergePolicy(newLogMergePolicy());
                    List.of(
                    List.of(starTreeValues),  
        }
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 2.0, 2.0, 1.0, 1.0, 2.0 });  
import org.opensearch.index.codec.composite.CompositeIndexReader;
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
            // Update random number of documents  
                        NumberFieldMapper.NumberType.LONG
         */  
        iw.addDocument(doc);
                String id = String.valueOf(random().nextInt() + 1);
    }
            b.field("name", "keyword1");  
                        NumberFieldMapper.NumberType.LONG,  
    protected XContentBuilder getMapping() throws IOException {  
        assertEquals(1, ir.leaves().size());  
        doc = new Document();  
    public void testStarKeywordDocValuesWithMissingDocsInSegment() throws IOException {
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        iw.addDocument(doc);  
import java.util.HashSet;
                        BytesRef encoded = k2.lookupOrd(starDoc.dimensions[1]);
                StarTreeDocument[] actualStarTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        iw.addDocument(doc);  
                        NumberFieldMapper.NumberType.DOUBLE,
        doc = new Document();
                        NumberFieldMapper.NumberType.DOUBLE,  
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[5];
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
        doc = new Document();
        doc = new Document();
        TestUtil.checkReader(ir);
         [null, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
                        new Term("_id", idToDelete),
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(  
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        doc = new Document();  
        iw.addDocument(doc);
                );  
        iw.addDocument(doc);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
import org.opensearch.common.lucene.Lucene;  
                    iw.w.softUpdateDocuments(
                allIds.add(id);
            b.value("value_count");
import org.apache.lucene.document.Field;
                        NumberFieldMapper.NumberType.DOUBLE,
        conf.setMergePolicy(newLogMergePolicy());
            b.endArray();
        for (LeafReaderContext context : ir.leaves()) {
                        assertEquals((int) map.get(keyword1 + "-" + keyword2), (int) metric);  
            b.endObject();
        assertEquals(1, ir.leaves().size());  
        }  
        iw.close();
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        iw.addDocument(doc);
        TestUtil.checkReader(ir);
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 1L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
                    "keyword1"
        iw.flush();  
            b.startArray("metrics");  
                    if (map.containsKey(keyword1 + "-" + keyword2)) {
    }  
        expectedStarTreeDocuments[5] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 2.0, 2.0, 1.0, 1.0, 2.0 });  
            b.startObject("config");
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 1L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
        ir.close();
        Document doc = new Document();  
                );
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
        iw.forceMerge(1);
                );  
            b.endObject();
import static org.opensearch.index.compositeindex.CompositeIndexConstants.STAR_TREE_DOCS_COUNT;  
        TestUtil.checkReader(ir);  
        for (LeafReaderContext context : ir.leaves()) {  
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedNumericDocValuesField("sndv", 1));  
            b.endArray();  
import java.util.HashMap;  
            b.startObject("properties");  
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));  
        for (int iter = 0; iter < iterations; iter++) {
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedNumericDocValuesField("sndv", 1));
            // Add 10 documents
                    allIds.remove(idToDelete);  
        iw.close();
import org.opensearch.core.xcontent.XContentBuilder;
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
         [null, 1] | [1.0, 1.0, 1.0, 1.0, 1.0]  
        conf.setMergePolicy(newLogMergePolicy());
        doc.add(new SortedNumericDocValuesField("sndv", 2));
                        NumberFieldMapper.NumberType.DOUBLE,
            b.endObject();
                map.put(keyword1Value + "-" + keyword2Value, sndvValue + map.getOrDefault(keyword1Value + "-" + keyword2Value, 0));
                        NumberFieldMapper.NumberType.DOUBLE,  
                    List.of(
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));  
import org.apache.lucene.store.Directory;
        iw.addDocument(doc);
 *
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
                        keyword2 = InetAddresses.toAddrString(address);
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")  
                        NumberFieldMapper.NumberType.LONG  
        doc = new Document();
        // Assert star tree documents  
                        NumberFieldMapper.NumberType.LONG  
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
        directory.close();
                );
                );  
            SegmentReader reader = Lucene.segmentReader(context.reader());
        Directory directory = newDirectory();  
                        NumberFieldMapper.NumberType.LONG,
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));
            b.field("type", "keyword");
        int iterations = 3;  
        doc = new Document();
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
                        NumberFieldMapper.NumberType.DOUBLE,
                    List.of(
         [null, 1] | [1.0, 1.0, 1.0, 1.0, 1.0]
                        NumberFieldMapper.NumberType.DOUBLE,  
        iw.flush();
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
            b.startObject();
         [null, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]
                SortedSetStarTreeValuesIterator k2 = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator("ip1");
        doc.add(new SortedNumericDocValuesField("sndv", 2));
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0]  
    }
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
        for (LeafReaderContext context : ir.leaves()) {
                        NumberFieldMapper.NumberType.LONG
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(  
import org.apache.lucene.tests.index.RandomIndexWriter;
            for (int i = 0; i < docsToDelete; i++) {
                        NumberFieldMapper.NumberType.LONG
            b.endObject();  
        expectedStarTreeDocuments[6] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
        expectedStarTreeDocuments[5] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });  
                    ),
                    List.of(  
                        NumberFieldMapper.NumberType.LONG,  
        IndexWriterConfig conf = newIndexWriterConfig(null);
                    if (starDoc.dimensions[1] != null) {  
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        doc.add(new StringField("_id", "4", Field.Store.NO));
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))  
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                        NumberFieldMapper.NumberType.DOUBLE,
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, 0L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
    public void testStarTreeKeywordDocValues() throws IOException {
            b.startObject("startree");  
import org.apache.lucene.document.NumericDocValuesField;
        doc.add(new SortedNumericDocValuesField("sndv", 1));
        doc.add(new SortedNumericDocValuesField("sndv", 2));
                    doc.add(new NumericDocValuesField("field-ndv", 1L));  
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
        doc.add(new SortedNumericDocValuesField("sndv", 1));
        iw.addDocument(doc);
        iw.forceMerge(1);
    }  
        doc.add(new SortedNumericDocValuesField("sndv", 2));  
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);  
                    ),
                        NumberFieldMapper.NumberType.LONG,
        assertEquals(1, ir.leaves().size());
        iw.forceMerge(1);
                if (!allIds.isEmpty()) {  
import org.apache.lucene.document.SortedNumericDocValuesField;
        doc.add(new SortedNumericDocValuesField("sndv", 1));
            }
                );  
/**  
        }  
    }
import org.opensearch.index.mapper.NumberFieldMapper;
 */
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0]  
                        NumberFieldMapper.NumberType.LONG  
        Directory directory = newDirectory();
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {  
         [0, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]
         [0, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]  
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                    ),
        doc.add(new SortedNumericDocValuesField("sndv", 2));  
        TestUtil.checkReader(ir);
        doc.add(new StringField("_id", "3", Field.Store.NO));
            b.endObject();
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
        iw.forceMerge(1);
            b.endObject();  
        directory.close();
            }  
                    String keyword1 = null;  
            b.value("avg");  
                            Arrays.copyOfRange(encoded.bytes, encoded.offset, encoded.offset + encoded.length)  
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
        IndexWriterConfig conf = newIndexWriterConfig(null);
        /**  
        doc.add(new StringField("_id", "1", Field.Store.NO));
        iw.flush();
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[7];  
        IndexWriterConfig conf = newIndexWriterConfig(null);  
                }
         [1, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
        iw.forceMerge(1);
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {  
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
        directory.close();
                        List.of(doc),  
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        conf.setMergePolicy(newLogMergePolicy());  
         [null, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]  
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 4.0, 3.0, 1.0, 2.0, 3.0 });
import org.apache.lucene.document.StringField;
        Document doc = new Document();
                        InetAddress address = InetAddressPoint.decode(
            b.startArray("ordered_dimensions");
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
            }
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
                    ),
        iw.forceMerge(1);  
        iw.close();  
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        doc.add(new SortedNumericDocValuesField("sndv", 1));  
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });  
                documents.put(id, doc);
                doc.add(  
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
            iw.flush();
                        );
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });  
        // Star tree documents  
        }  
        iw.addDocument(doc);  
                String keyword2Value = "text" + random().nextInt(3);
            }
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));  
        directory.close();
