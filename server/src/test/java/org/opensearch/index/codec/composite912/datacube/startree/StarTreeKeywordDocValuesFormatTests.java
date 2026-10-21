         */
            b.startObject("config");
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
        assertEquals(1, ir.leaves().size());
        Document doc = new Document();
                String keyword1Value = "text" + random().nextInt(3);
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
        Directory directory = newDirectory();
            b.endObject();
    public void testStarKeywordDocValuesWithMissingDocsInMixedSegments() throws IOException {
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0]
            b.startObject("startree");
        assertEquals(1, ir.leaves().size());
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
         */
                doc.add(new SortedSetDocValuesField("keyword1", new BytesRef(keyword1Value)));
                );
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        for (LeafReaderContext context : ir.leaves()) {
        iw.forceMerge(1);
        Document doc = new Document();
                        NumberFieldMapper.NumberType.DOUBLE,
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
        iw.forceMerge(1);
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
                    allIds.remove(idToDelete);
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
         [null, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
            b.field("max_leaf_docs", 1);
            for (int i = 0; i < docsToDelete; i++) {
        IndexWriterConfig conf = newIndexWriterConfig(null);
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0]
 * SPDX-License-Identifier: Apache-2.0
                        NumberFieldMapper.NumberType.DOUBLE,
import org.apache.lucene.document.StringField;
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
            }
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
        ir.close();
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0] // This is for missing doc
            b.endObject();
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
        doc.add(new SortedNumericDocValuesField("sndv", 1));
        Document doc = new Document();
            // Update random number of documents
        expectedStarTreeDocuments[6] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
                    List.of(
        expectedStarTreeDocuments[5] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
                        NumberFieldMapper.NumberType.LONG
        IndexWriterConfig conf = newIndexWriterConfig(null);
                if (!allIds.isEmpty()) {
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
        doc.add(new StringField("_id", "1", Field.Store.NO));
    @Override
        }
                        NumberFieldMapper.NumberType.LONG,
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[1];
        /**
        doc.add(new SortedNumericDocValuesField("sndv", 1));
                );
         [null, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
import org.opensearch.core.xcontent.XContentBuilder;
                        NumberFieldMapper.NumberType.LONG,
        iw.addDocument(doc);
            // Add 10 documents
                        new Term("_id", idToDelete),
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
 * this file be licensed under the Apache-2.0 license or a
                    List.of(
                        NumberFieldMapper.NumberType.LONG,
            iw.flush();
                SortedSetStarTreeValuesIterator k2 = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator("ip1");
            b.startObject("sndv");
                    ),
        iw.deleteDocuments(new Term("_id", "2"));
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
            b.value("max");
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
        // Star tree documents
                    Document doc = new Document();
        doc = new Document();
        TestUtil.checkReader(ir);
import java.io.IOException;
                iw.addDocument(doc);
                    documents.remove(idToDelete);
                    String keyword1 = null;
        iw.forceMerge(1);
        doc.add(new SortedNumericDocValuesField("sndv", 1));
import org.apache.lucene.document.SortedSetDocValuesField;
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, 0L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
            }
        directory.close();
            b.endObject();
        doc.add(new SortedNumericDocValuesField("sndv", 2));
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
                map.put(keyword1Value + "-" + keyword2Value, sndvValue + map.getOrDefault(keyword1Value + "-" + keyword2Value, 0));
                SortedSetStarTreeValuesIterator k1 = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator(
import org.apache.lucene.index.IndexWriterConfig;
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
                    List.of(
            b.startArray("metrics");
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
            b.field("type", "star_tree");
import org.apache.lucene.index.SegmentReader;
import java.net.InetAddress;
        iw.addDocument(doc);
        Set<String> allIds = new HashSet<>();
                    ),
import org.apache.lucene.index.DirectoryReader;
        assertEquals(1, ir.leaves().size());
        directory.close();
        TestUtil.checkReader(ir);
        iw.addDocument(doc);
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 2.0, 2.0, 1.0, 1.0, 2.0 });
            b.startObject("keyword1");
        doc.add(new SortedNumericDocValuesField("sndv", 2));
            }
import java.util.HashSet;
         [1, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
                    doc.add(new NumericDocValuesField("field-ndv", 1L));
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));
        for (LeafReaderContext context : ir.leaves()) {
        iw.addDocument(doc);
/*
            b.value("min");
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        Map<String, Integer> map = new HashMap<>();
        doc.add(new SortedNumericDocValuesField("sndv", 1));
import java.util.Map;
        directory.close();
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
import org.apache.lucene.tests.util.LuceneTestCase;
        // Assert star tree documents
package org.opensearch.index.codec.composite912.datacube.startree;
            }
         [null, 1] | [1.0, 1.0, 1.0, 1.0, 1.0]
 * Star tree doc values Lucene tests
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[7];
                );
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
public class StarTreeKeywordDocValuesFormatTests extends AbstractStarTreeDVFormatTests {
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
                String keyword2Value = "text" + random().nextInt(3);
         [1, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
        expectedStarTreeDocuments[5] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 2.0, 2.0, 1.0, 1.0, 2.0 });
import java.util.Set;
            b.endObject();
        directory.close();
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, null }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                );
                        assertEquals((int) map.get(keyword1 + "-" + keyword2), (int) metric);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
        IndexWriterConfig conf = newIndexWriterConfig(null);
                    new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10." + i))))
                        List.of(doc),
        expectedStarTreeDocuments[4] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedNumericDocValuesField("sndv", 2));
                    List.of(starTreeValues),
    }
        conf.setMergePolicy(newLogMergePolicy());
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
         [null, null] | [2.0, 2.0, 1.0, 1.0, 2.0]
                        NumberFieldMapper.NumberType.LONG,
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
                doc.add(new StringField("_id", id, Field.Store.YES));
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
            SegmentReader reader = Lucene.segmentReader(context.reader());
                    String idToDelete = allIds.iterator().next();
            b.endObject();
         */
 */
        iw.addDocument(doc);
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
                        new NumericDocValuesField(Lucene.SOFT_DELETES_FIELD, 1)
import org.apache.lucene.document.Document;
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
            b.field("name", "sndv");
    public void testStarKeywordDocValuesWithMissingDocsInAllSegments() throws IOException {
        ir.close();
        /**
            b.endArray();
        TestUtil.checkReader(ir);
import org.opensearch.common.network.InetAddresses;
                    List.of(
                        keyword1 = k1.lookupOrd(starDoc.dimensions[0]).utf8ToString();
         [1, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
            b.endObject();
        iw.addDocument(doc);
 */
import org.apache.lucene.document.Field;
import org.apache.lucene.tests.util.TestUtil;
                        NumberFieldMapper.NumberType.DOUBLE,
            SegmentReader reader = Lucene.segmentReader(context.reader());
                        NumberFieldMapper.NumberType.LONG
import org.opensearch.index.codec.composite.CompositeIndexReader;
                    );
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
            }
        doc = new Document();
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        // Star tree documents
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        iw.addDocument(doc);
                        );
        IndexWriterConfig conf = newIndexWriterConfig(null);
            b.startObject();
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        directory.close();
            b.field("type", "keyword");
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
                        NumberFieldMapper.NumberType.DOUBLE,
import org.opensearch.common.lucene.Lucene;
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
        Document doc = new Document();
        doc = new Document();
        iw.addDocument(doc);
        /**
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
        iw.close();
                    iw.w.softUpdateDocuments(
        iw.flush();
                        NumberFieldMapper.NumberType.DOUBLE,
                    ),
            b.value("value_count");
        }
         [null, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
        IndexWriterConfig conf = newIndexWriterConfig(null);
            b.startObject();
        doc.add(new SortedNumericDocValuesField("sndv", 2));
    public void testStarKeywordDocValuesWithMissingDocs() throws IOException {
        iw.flush();
            SegmentReader reader = Lucene.segmentReader(context.reader());
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
            b.startObject();
        /**
                );
            for (int i = 0; i < 10; i++) {
                }
        ir.close();
        Map<String, Document> documents = new HashMap<>();
        doc.add(new SortedNumericDocValuesField("sndv", 1));
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text11")));
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
import java.util.HashMap;
            b.startObject("ip1");
        }
        iw.addDocument(doc);
        expectedStarTreeDocuments[3] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
        iw.close();
         [0, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
        iw.close();
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
                        NumberFieldMapper.NumberType.DOUBLE,
        for (LeafReaderContext context : ir.leaves()) {
        iw.close();
        assertEquals(1, ir.leaves().size());
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
            b.endObject();
        iw.addDocument(doc);
        iw.forceMerge(1);
        iw.addDocument(doc);
        doc = new Document();
import org.opensearch.index.mapper.NumberFieldMapper;
            b.endArray();
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
         [0, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
        // Star tree documents
        Directory directory = newDirectory();
import org.apache.lucene.index.LeafReaderContext;
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
                    }
         */
                documents.put(id, doc);
        // Star tree documents
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        Directory directory = newDirectory();
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
                StarTreeDocument[] actualStarTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
    }
         */
                        NumberFieldMapper.NumberType.LONG,
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
import static org.opensearch.index.compositeindex.CompositeIndexConstants.STAR_TREE_DOCS_COUNT;
         [null, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
import java.util.Arrays;
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));
         [null, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
                        NumberFieldMapper.NumberType.DOUBLE,
                        NumberFieldMapper.NumberType.DOUBLE,
    }
        iw.forceMerge(1);
        TestUtil.checkReader(ir);
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));
                    double metric = (double) starDoc.metrics[0];
}
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, 0L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
            b.endObject();
                String id = String.valueOf(random().nextInt() + 1);
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 4.0, 3.0, 1.0, 2.0, 3.0 });
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 1L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
            b.startObject("composite");
        doc.add(new StringField("_id", "2", Field.Store.NO));
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
                    if (starDoc.dimensions[1] != null) {
                        NumberFieldMapper.NumberType.DOUBLE,
        iw.close();
                        NumberFieldMapper.NumberType.LONG,
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        iw.forceMerge(1);
                Document doc = new Document();
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
                    "keyword1"
 * compatible open source license.
            }
                        NumberFieldMapper.NumberType.DOUBLE,
        Directory directory = newDirectory();
        iw.addDocument(doc);
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
        /**
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 1L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.10")))));
                        NumberFieldMapper.NumberType.LONG
        doc = new Document();
                );
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
import org.apache.lucene.tests.index.RandomIndexWriter;
        doc.add(new SortedNumericDocValuesField("sndv", 1));
        assertEquals(1, ir.leaves().size());
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        }
        doc = new Document();
            b.value("avg");
        iw.addDocument(doc);
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
            b.field("type", "integer");
        }
        iw.addDocument(doc);
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[3];
                }
                );
import java.util.List;
                        NumberFieldMapper.NumberType.DOUBLE,
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        for (LeafReaderContext context : ir.leaves()) {
                    String keyword2 = null;
        doc = new Document();
import org.apache.lucene.document.NumericDocValuesField;
        });
        iw.addDocument(doc);
                doc.add(
        expectedStarTreeDocuments[2] = new StarTreeDocument(new Long[] { null, 0L }, new Double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
        expectedStarTreeDocuments[7] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 2.0, 2.0, 1.0, 1.0, 2.0 });
        iw.flush();
        directory.close();
         [null, 0] | [1.0, 1.0, 1.0, 1.0, 1.0]
                        InetAddress address = InetAddressPoint.decode(
        }
import org.apache.lucene.document.SortedNumericDocValuesField;
    protected XContentBuilder getMapping() throws IOException {
        conf.setMergePolicy(newLogMergePolicy());
            b.startObject("properties");
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        expectedStarTreeDocuments[4] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                        BytesRef encoded = k2.lookupOrd(starDoc.dimensions[1]);
        iw.forceMerge(1);
        iw.flush();
            b.startArray("ordered_dimensions");
                doc.add(new SortedNumericDocValuesField("sndv", sndvValue));
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
            iw.flush();
        super(buildMode);
            b.startObject("keyword2");
    public void testStarTreeKeywordDocValuesWithDeletions() throws IOException {
                    List.of(starTreeValues),
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
            b.field("name", "keyword1");
         [null, 1] | [3.0, 2.0, 1.0, 2.0, 2.0]
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        // Star tree documents
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
        iw.addDocument(doc);
        }
        doc.add(new SortedNumericDocValuesField("sndv", 1));
                    if (starDoc.dimensions[0] != null) {
         * keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
        IndexWriterConfig conf = newIndexWriterConfig(null);
            }
        for (int iter = 0; iter < iterations; iter++) {
        conf.setMergePolicy(newLogMergePolicy());
        ir.close();
         [null, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
                    List.of(starTreeValues),
         [0, 0] | [2.0, 1.0, 2.0, 2.0, 1.0]
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
        int iterations = 3;
        iw.addDocument(doc);
    }
                    }
                        NumberFieldMapper.NumberType.LONG
                    List.of(
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
    public StarTreeKeywordDocValuesFormatTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
                );
        iw.close();
                StarTreeValues starTreeValues = (StarTreeValues) starTreeDocValuesReader.getCompositeIndexValues(compositeIndexFieldInfo);
        DirectoryReader ir = maybeWrapWithMergingReader(DirectoryReader.open(directory));
        for (LeafReaderContext context : ir.leaves()) {
            b.endObject();
        Directory directory = newDirectory();
                        NumberFieldMapper.NumberType.LONG
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
            b.endObject();
        iw.addDocument(doc);
        ir.close();
                        keyword2 = InetAddresses.toAddrString(address);
                doc.add(new SortedSetDocValuesField("keyword2", new BytesRef(keyword2Value)));
        assertEquals(1, ir.leaves().size());
        doc = new Document();
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new StringField("_id", "4", Field.Store.NO));
            b.startArray("stats");
        expectedStarTreeDocuments[0] = new StarTreeDocument(new Long[] { 0L, 0L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
         [null, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]
        expectedStarTreeDocuments[4] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 2.0, 1.0, 2.0, 2.0, 1.0 });
                        NumberFieldMapper.NumberType.DOUBLE,
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedNumericDocValuesField("sndv", 2));
                    List.of(starTreeValues),
        doc.add(new SortedNumericDocValuesField("sndv", 2));
            SegmentReader reader = Lucene.segmentReader(context.reader());
 *
            SegmentReader reader = Lucene.segmentReader(context.reader());
 * The OpenSearch Contributors require contributions made to
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[8];
        doc = new Document();
            b.field("type", "keyword");
                            Arrays.copyOfRange(encoded.bytes, encoded.offset, encoded.offset + encoded.length)
        expectedStarTreeDocuments[3] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
        doc = new Document();
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
                    if (map.containsKey(keyword1 + "-" + keyword2)) {
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")
                    ),
        ir.close();
        return topMapping(b -> {
         [0, 0] | [3.0, 2.0, 1.0, 2.0, 2.0]
        doc = new Document();
        doc.add(new StringField("_id", "3", Field.Store.NO));
        doc = new Document();
            b.endArray();
            b.field("name", "ip1");
            SegmentReader reader = Lucene.segmentReader(context.reader());
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
            List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        conf.setMergePolicy(newLogMergePolicy());
    }
        doc.add(new SortedNumericDocValuesField("sndv", 1));
        TestUtil.checkReader(ir);
            b.value("sum");
        doc.add(new SortedSetDocValuesField("keyword1", new BytesRef("text1")));
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
        TestUtil.checkReader(ir);
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text2")));
            for (CompositeIndexFieldInfo compositeIndexFieldInfo : compositeIndexFields) {
                    List.of(starTreeValues),
    public void testStarKeywordDocValuesWithMissingDocsInSegment() throws IOException {
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
            }
        conf.setMergePolicy(newLogMergePolicy());
         [1, 1] | [2.0, 1.0, 2.0, 2.0, 1.0]
                    List.of(
        StarTreeDocument[] expectedStarTreeDocuments = new StarTreeDocument[5];
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0] // This is star document
        doc.add(new SortedNumericDocValuesField("sndv", 1));
    }
                    }
                        NumberFieldMapper.NumberType.LONG
import org.apache.lucene.store.Directory;
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.assertStarTreeDocuments;
    public void testStarTreeKeywordDocValues() throws IOException {
                    ),
import org.apache.lucene.index.Term;
                        NumberFieldMapper.NumberType.DOUBLE,
            int docsToDelete = random().nextInt(5); // Delete up to 5 documents
            b.field("type", "ip");
                StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
        Document doc = new Document();
        expectedStarTreeDocuments[6] = new StarTreeDocument(new Long[] { null, null }, new Double[] { 6.0, 4.0, 1.0, 2.0, 4.0 });
import org.apache.lucene.util.BytesRef;
        doc.add(new SortedNumericDocValuesField("sndv", 2));
        iw.addDocument(doc);
        doc.add(new SortedNumericDocValuesField("sndv", 2));
         [null, 1] | [1.0, 1.0, 1.0, 1.0, 1.0]
        Directory directory = newDirectory();
/**
        iw.deleteDocuments(new Term("_id", "4"));
                assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocuments);
        doc.add(new SortedSetDocValuesField("keyword2", new BytesRef("text22")));
                int sndvValue = random().nextInt(5) + 1;
                    Integer.parseInt(starTreeValues.getAttributes().get(STAR_TREE_DOCS_COUNT))
        for (LeafReaderContext context : ir.leaves()) {
        doc.add(new SortedNumericDocValuesField("sndv", 1));
    }
        iw.addDocument(doc);
    }
                        NumberFieldMapper.NumberType.DOUBLE,
        doc.add(new SortedSetDocValuesField("ip1", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("10.10.10.11")))));
        iw.forceMerge(1);
                allIds.add(id);
                for (StarTreeDocument starDoc : actualStarTreeDocuments) {
                    List.of(starTreeValues),
        iw.forceMerge(1);
        iw.forceMerge(1);
                    ),
        doc = new Document();
            b.endObject();
         [null, null] | [6.0, 4.0, 1.0, 2.0, 4.0]
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
import org.apache.lucene.document.InetAddressPoint;
        expectedStarTreeDocuments[3] = new StarTreeDocument(new Long[] { null, 1L }, new Double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
        expectedStarTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 1L }, new Double[] { 3.0, 2.0, 1.0, 2.0, 2.0 });
         keyword1 keyword2 | [ sum, value_count, min, max[sndv]] , doc_count
            CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
         [null, 0] | [1.0, 1.0, 1.0, 1.0, 1.0]
        doc = new Document();
        doc = new Document();
        conf.setMergePolicy(newLogMergePolicy());
