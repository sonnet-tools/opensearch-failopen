import org.opensearch.index.fielddata.IndexFieldDataService;
    }
    public void testNonPruningSortedSetOrdinalsIndexFieldDataSorting() throws IOException {
import org.opensearch.index.IndexService;  
        super.setUp();  
    IndexService indexService;  
    IndicesService indicesService;
 *
 */  
        assertTrue(field.getComparator(0, Pruning.NONE) instanceof FieldComparator);
        ifdService = new IndexFieldDataService(  
package org.opensearch.index.fielddata.plain;
import org.opensearch.index.fielddata.IndexFieldData;
            indexService.getIndexSettings(),
        assertTrue(field.getIndexSorter() instanceof IndexSorter);  
            indexService.mapperService(),
}
        indexService = createIndex("test");
        assertFalse(field.getOptimizeSortWithPoints());
        indicesService = getInstanceFromNode(IndicesService.class);
import org.opensearch.index.mapper.MappedFieldType;
    public void testNonPruningSortedSetOrdinalsIndexFieldDataComparator() throws IOException {  
            Objects.hash(field.getField(), field.getType(), field.getReverse(), field.getComparatorSource(), field.getMissingValue()),  
import org.apache.lucene.index.IndexSorter;
 * this file be licensed under the Apache-2.0 license or a
    MappedFieldType stringMapper;
    }  
import java.io.IOException;
import org.opensearch.indices.IndicesService;
        assertTrue(field.getIndexSorter() instanceof IndexSorter);
/*  
    public void setUp() throws Exception {
import org.apache.lucene.search.FieldComparator;
        ctx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));
        field.setOptimizeSortWithPoints(false);
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        ifdService.clear();  
            indicesService.getIndicesFieldDataCache(),
    BuilderContext ctx;  
 * compatible open source license.
import org.opensearch.search.MultiValueMode;
        IndexFieldData<?> fd = ifdService.getForField(stringMapper, "test", () -> { throw new UnsupportedOperationException(); });
import org.opensearch.index.mapper.ContentPath;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public void testNonPruningSortedSetOrdinalsIndexFieldDataEquality() throws IOException {  
import org.opensearch.index.mapper.Mapper.BuilderContext;
        assertFalse(field.equals(field));
        assertFalse(field.getOptimizeSortWithIndexedData());  
import org.opensearch.index.mapper.WildcardFieldMapper;  
        field.setOptimizeSortWithIndexedData(false);
            indexService.getThreadPool()
        assertNotEquals(
    public void testNonPruningSortedSetOrdinalsIndexFieldDataSerialization() throws IOException {
import org.apache.lucene.search.Pruning;  
        );  
import org.apache.lucene.search.SortField;
import java.util.Objects;  
 * The OpenSearch Contributors require contributions made to  
    }  
    IndexFieldDataService ifdService;
public class NonPruningSortedSetOrdinalsIndexFieldDataTests extends OpenSearchSingleNodeTestCase {
        stringMapper = new WildcardFieldMapper.Builder("string").docValues(true).build(ctx).fieldType();
    SortField field;
        assertEquals("<sortedset: \"string\"> missingValue=SortField.STRING_FIRST selector=MAX", field.toString());  
        assertFalse(field.needsScores());
    }
        );
            indicesService.getCircuitBreakerService(),  
            field.hashCode()
    }  
        field.setMissingValue(SortedSetSortField.STRING_FIRST);  
import org.apache.lucene.search.SortedSetSortField;
        field = ((NonPruningSortedSetOrdinalsIndexFieldData) fd).sortField(null, MultiValueMode.MAX, null, false);
