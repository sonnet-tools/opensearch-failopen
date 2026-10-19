        StringTerms terms = (StringTerms) agg;  
        InternalAggregation agg = translator.toBucketAggregation(brandAgg, List.of());
import org.opensearch.index.mapper.NumberFieldMapper;  
        ConversionException e = expectThrows(ConversionException.class, () -> translator.validate(dateAgg));
            .order(BucketOrder.aggregation("avg_price", false));
    public void testGroupingReturnsFieldNameAsIs() {  
    public void testPushdownSumOtherDerivedFromTotals() {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> translator.toBucketAggregation(unknownAgg, entries, 1L));  
        assertEquals(TermsAggregationBuilder.class, translator.getAggregationType());  
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand")  
        TermsAggregationBuilder unknownAgg = new TermsAggregationBuilder("by_unknown").field("unknown");  
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(false));
    );
    }
    /** Under fetch pushdown the tail never leaves the engine — sum_other = eligible − Σ(rendered). */
    // SearchSourceConverterTests) — the translator no longer re-implements it.
    public void testReportsCorrectType() {
    /** Totals arithmetic applies to typed key paths too. */
        StringTerms terms = (StringTerms) translator.toBucketAggregation(ipAgg, entries, 5L);
        MappedFieldType nanosType = mock(MappedFieldType.class);
            )
    // ---- Pushdown mode: totals-derived sum_other_doc_count ----
        assertEquals(95L, terms.getSumOfOtherDocCounts());
        return mapperService;
        TermsBucketTranslator nanosTranslator = new TermsBucketTranslator(() -> mapperService);  
        when(mapperService.fieldType("created_nanos")).thenReturn(nanosType);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(7L, terms.getBuckets().get(1).getKey());  
        assertEquals(3, terms.getBuckets().get(0).getDocCount());
    }
    }
    public void testIntegralKeysProduceLongTermsWithNumericKeys() {
        numWithMeta.setMetadata(meta);  
        TermsAggregationBuilder badAgg = new TermsAggregationBuilder("by_bad").field("nonexistent");
        assertTrue(compound.orderElements().get(0) instanceof InternalOrder.Aggregation);
        InternalAggregation agg = translator.toBucketAggregation(brandAgg, entries, 5L);  
    public void testToBucketAggregationBuildsStringTerms() {  
        assertTrue(e.getMessage().contains("date field [created_nanos]"));  
                List.of(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) 0xff, (byte) 0xff, 10, 0, 0, 1 }),  
        MapperService mapperService = mock(MapperService.class);
    /** The engine returns date group keys as strings — reject at conversion with a clear 400. */
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> translator.toBucketAggregation(brandAgg, entries));
        MapperService mapperService = mock(MapperService.class);  
import org.opensearch.dsl.converter.ConversionException;
                List.of(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) 0xff, (byte) 0xff, 10, 0, 0, 2 }),
        // key(false) is a key order — stored directly, not wrapped in CompoundOrder
        new BooleanFieldMapper.BooleanFieldType("flag"),  
    }
        TermsAggregationBuilder numWithMeta = new TermsAggregationBuilder("by_price").field("price");
        assertEquals(2, compound.orderElements().size());  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;  
        assertEquals(0L, terms.getBuckets().get(1).getKey());  
        TermsAggregationBuilder dateAgg = new TermsAggregationBuilder("by_day").field("created");
import org.opensearch.test.OpenSearchTestCase;
    // Ordering, min_doc_count, and truncation are plan contracts (SORT, HAVING, and LIMIT baked
    }
        TermsAggregationBuilder ratingAgg = new TermsAggregationBuilder("by_rating").field("rating");
        assertEquals(0L, terms.getSumOfOtherDocCounts());
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
        TermsAggregationBuilder dateAgg = new TermsAggregationBuilder("by_day").field("created");  
        assertEquals(7L, terms.getSumOfOtherDocCounts());  
        // No meta on the request → none in the response
        assertNotNull(order);  
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 1L);  
        assertTrue(translator.getSubAggregations(brandAgg).isEmpty());
        assertNotNull(order);
        );  
        "ip",
    private final TermsBucketTranslator unmappedTranslator = new TermsBucketTranslator(() -> null);
    public void testToBucketAggregationEmptyBuckets() {  
    }  
                2,  
        assertFalse(order instanceof InternalOrder.CompoundOrder);  
    }  
    /**
    }
    public void testValidateRejectsDateNanosField() {
        assertNotNull(order);
     * dispatch was bypassed — an internal wiring bug. Truncating and tail-summing client-side
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true));
        assertEquals(2, terms.getBuckets().size());
    }  
    }  
    public void testGetBucketOrderReturnsCustomOrder() {  
        // metric order is not a key order — wrapped in CompoundOrder with _key asc tie-breaker
    }
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(true));  
        assertEquals("AQID", terms.getBuckets().get(0).getKeyAsString());
/*  
        TermsAggregationBuilder aggWithMeta = new TermsAggregationBuilder("by_brand").field("brand");  
    private final TermsBucketTranslator translator = new TermsBucketTranslator(TermsBucketTranslatorTests::mappedService);
     * would mask it with a silently wrong sum_other_doc_count; fail loudly instead.
import static org.mockito.Mockito.when;
    }
            new BucketEntry(List.of(42L), 3, InternalAggregations.EMPTY),
import org.opensearch.search.aggregations.InternalOrder;
     * make the eligible count smaller than the rendered sum. Clamp instead of going negative.
        assertTrue(order instanceof InternalOrder.CompoundOrder);
    // ---- validate(): date fields are rejected at conversion time ----
        assertTrue(order instanceof InternalOrder.CompoundOrder);
public class TermsBucketTranslatorTests extends OpenSearchTestCase {
        // Default terms order is compound: _count desc, _key asc
    public void testFloatingKeysProduceDoubleTerms() {  
        LongTerms terms = (LongTerms) agg;  
        assertTrue(agg instanceof DoubleTerms);  
    public void testPushdownSumOtherClampedAtZero() {  
package org.opensearch.dsl.aggregation.bucket;
    }  
    public void testMetadataEchoedInBucketAggregation() {
    public void testGetBucketOrderReturnsKeyDesc() {
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
    }
            ),  
        assertTrue(e.getMessage().contains("not present in the index mapping"));
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
            IllegalStateException.class,  
     * Every terms plan is bounded, so a non-empty render without plan totals means the sized  
        assertTrue(InternalOrder.isKeyOrder(order));  
    // Null-key exclusion is a plan contract (pre-aggregate IS NOT NULL filter, see  
                InternalAggregations.EMPTY
    public void testValidateAcceptsNonDateMappedField() throws Exception {
        when(mapperService.fieldType(anyString())).thenAnswer(invocation -> FIELD_TYPES.get(invocation.<String>getArgument(0)));
            new BucketEntry(List.of("BrandA"), 3, InternalAggregations.EMPTY),
import org.opensearch.index.mapper.DateFieldMapper;
        TermsAggregationBuilder priceAgg = new TermsAggregationBuilder("by_price").field("price");
 * compatible open source license.
    }
import org.opensearch.search.aggregations.BucketOrder;
        assertEquals(List.of("brand"), translator.getGrouping(brandAgg).getFieldNames());  
        IllegalStateException e = expectThrows(
        assertEquals(1L, terms.getBuckets().get(0).getKey());
        when(nanosType.typeName()).thenReturn(DateFieldMapper.DATE_NANOS_CONTENT_TYPE);  
    public void testGetBucketOrderReturnsCountAsc() {
import org.opensearch.index.mapper.MappedFieldType;
        assertEquals(2, compound.orderElements().size());
        TermsAggregationBuilder dateAgg = new TermsAggregationBuilder("by_day").field("created_nanos");
import org.opensearch.index.mapper.KeywordFieldMapper;  
        assertEquals("BrandB", terms.getBuckets().get(0).getKeyAsString());  
        assertEquals("42", terms.getBuckets().get(0).getKeyAsString());
    public void testGetSubAggregations() {  
        // key(true) is already a key order — stored directly, not wrapped in CompoundOrder
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 10L);
        List<BucketEntry> entries = List.of(new BucketEntry(List.of(new byte[] { 1, 2, 3 }), 1, InternalAggregations.EMPTY));
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("x"), 1, InternalAggregations.EMPTY));
import java.util.List;  
                3,
import org.opensearch.search.aggregations.InternalAggregation;
            () -> unmappedTranslator.toBucketAggregation(brandAgg, entries, 5L)
        unmappedTranslator.validate(dateAgg); // must not throw
        List<BucketEntry> numeric = List.of(new BucketEntry(List.of(1L), 1, InternalAggregations.EMPTY));
    /** A field the mapping does not know cannot be typed — rendering fails loudly. */
    }  
    public void testGetGrouping() {
    }  
import static org.mockito.ArgumentMatchers.anyString;  
    }  
        assertEquals(3L, terms.getSumOfOtherDocCounts());
    }
        assertEquals(2, terms.getBuckets().get(1).getDocCount());  
    /** User-supplied meta must be echoed back on the response aggregation, like classic search. */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.dsl.result.BucketEntry;
        LongTerms terms = (LongTerms) translator.toBucketAggregation(priceAgg, entries, 12L);
        assertTrue(InternalOrder.isKeyAsc(order));
        TermsAggregationBuilder boolAgg = new TermsAggregationBuilder("by_flag").field("flag");
        new NumberFieldMapper.NumberFieldType("rating", NumberFieldMapper.NumberType.DOUBLE),
    }
        assertNotNull(order);
        List<BucketEntry> entries = List.of(  
        TermsAggregationBuilder priceAgg = new TermsAggregationBuilder("by_price").field("price");  
        assertTrue(InternalOrder.isKeyOrder(order));
        TermsAggregationBuilder ipAgg = new TermsAggregationBuilder("by_ip").field("ip");  
        assertEquals("BrandA", terms.getBuckets().get(0).getKeyAsString());  
        assertTrue(InternalOrder.isKeyAsc(compound.orderElements().get(1)));  
        List<BucketEntry> entries = List.of(
            new BucketEntry(List.of(7), 2, InternalAggregations.EMPTY)  
        assertFalse(order instanceof InternalOrder.CompoundOrder);
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
        assertEquals("BrandA", terms.getBuckets().get(1).getKeyAsString());
        assertEquals("BrandB", terms.getBuckets().get(1).getKeyAsString());
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
    public void testRenderWithoutMapperServiceFailsLoudly() {
        assertTrue(e.getMessage().contains("date field [created]"));
    public void testUndecodableBinaryKeyFallsBackToBase64() {  
            new BucketEntry(List.of(false), 2, InternalAggregations.EMPTY)
            new BucketEntry(
    /** Mapping-dependent validation is skipped when no MapperService is supplied (conversion-only use). */  
    }
        List<BucketEntry> entries = List.of(
    /** Without a MapperService the key type cannot be resolved — rendering fails loudly. */
        assertEquals(2, terms.getBuckets().size());
    }  
        assertTrue(agg instanceof LongTerms);
        "created",  
    // into every plan) — the translator renders entries in received order and never re-filters,
        assertTrue(InternalOrder.isCountDesc(compound.orderElements().get(0)));
        LongTerms terms = (LongTerms) translator.toBucketAggregation(boolAgg, entries, 5L);
        InternalOrder.CompoundOrder compound = (InternalOrder.CompoundOrder) order;
        TermsAggregationBuilder priceAgg = new TermsAggregationBuilder("by_price").field("price");
    private static final Map<String, MappedFieldType> FIELD_TYPES = Map.of(
        TermsAggregationBuilder aggWithSub = new TermsAggregationBuilder("by_brand").field("brand")
        );
        ConversionException e = expectThrows(ConversionException.class, () -> nanosTranslator.validate(dateAgg));
        // Deliberately not in the default count-desc order: the translator must not re-sort.
        assertTrue(agg instanceof LongTerms);  
 *
        assertTrue(order instanceof InternalOrder.CompoundOrder);
import static org.mockito.Mockito.mock;
        assertTrue(agg instanceof StringTerms);
        List<BucketEntry> entries = List.of(  
    public void testEmptyBucketsAreTypedByMapping() {
     * The count plan and the main plan are separate engine queries — a refresh between them can  
        assertEquals(meta, translator.toBucketAggregation(numWithMeta, numeric, 1L).getMetadata());
    public void testGetBucketOrderReturnsDefault() {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, compound.orderElements().size());
    }
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("BrandA"), 5, InternalAggregations.EMPTY));
        assertTrue(e.getMessage().contains("index mapping unavailable"));
    }  
    public void testValidateRejectsDateField() {
            new BucketEntry(List.of(true), 3, InternalAggregations.EMPTY),
    }  
    private static MapperService mappedService() {
        assertEquals("10.0.0.2", terms.getBuckets().get(1).getKeyAsString());
        assertTrue(agg instanceof StringTerms);
                InternalAggregations.EMPTY
            new BucketEntry(List.of("BrandA"), 5, InternalAggregations.EMPTY)
        // count(true) is not a key order — wrapped in CompoundOrder with _key asc tie-breaker  
    public void testEmptySubAggregations() {
import org.opensearch.search.aggregations.InternalAggregations;  
        InternalOrder.CompoundOrder compound = (InternalOrder.CompoundOrder) order;  
    }  
        assertTrue(((StringTerms) agg).getBuckets().isEmpty());  
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 100L);
        new DateFieldMapper.DateFieldType("created")
        assertFalse(InternalOrder.isKeyAsc(order));
    /** An empty result renders through the mapping too — a numeric field yields empty LongTerms, not StringTerms. */  
import org.opensearch.index.mapper.IpFieldMapper;
            new BucketEntry(List.of("BrandA"), 3, InternalAggregations.EMPTY),
        new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG),
        aggWithMeta.setMetadata(meta);
        BucketOrder order = translator.getBucketOrder(aggWithOrder);  
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("BrandA"), 5, InternalAggregations.EMPTY));
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        assertEquals("10.0.0.1", terms.getBuckets().get(0).getKeyAsString());
            new BucketEntry(List.of("BrandB"), 2, InternalAggregations.EMPTY)  
 */  
    /**
        InternalAggregation agg = translator.toBucketAggregation(priceAgg, entries, 5L);  
    public void testNonEmptyRenderWithoutTotalsFailsLoudly() {
    public void testBooleanKeysRenderLikeClassicBooleanTerms() {
        new KeywordFieldMapper.KeywordFieldType("brand"),  
            new BucketEntry(List.of("BrandB"), 2, InternalAggregations.EMPTY),  
        List<BucketEntry> entries = List.of(
    }
        InternalOrder.CompoundOrder compound = (InternalOrder.CompoundOrder) order;  
        assertTrue(InternalOrder.isKeyAsc(compound.orderElements().get(1)));  
        );  
    public void testGetBucketOrderReturnsMetricOrder() {
        "flag",
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("BrandA"), 3, InternalAggregations.EMPTY));  
        // Typed key paths echo meta too
        List<BucketEntry> entries = List.of(new BucketEntry(List.of(200L), 5, InternalAggregations.EMPTY));
        );
    public void testSizedPathRendersEntriesAsReceived() {  
        assertNull(translator.toBucketAggregation(brandAgg, List.of()).getMetadata());
        // Translator just captures the field name; validation happens at build time in the builder  
    }
        assertEquals(1, translator.getSubAggregations(aggWithSub).size());
            new BucketEntry(
        assertEquals(BucketOrder.count(true), compound.orderElements().get(0));
import org.opensearch.index.mapper.BooleanFieldMapper;  
        translator.validate(brandAgg); // must not throw
    // ---- Mapping resolution is required for rendering ----
    }
     */  
    public void testPushdownNumericKeysUseTotals() {  
import java.util.Map;
        assertTrue(e.getMessage().contains("sized path"));  
        assertEquals(brandAgg.getName(), terms.getName());
    public void testValidateSkipsMappingChecksWithoutMapperService() throws Exception {
        );
        assertNotNull(order);  
    public void testBinaryKeysDecodeToIpAddressStrings() {
        assertEquals(42L, terms.getBuckets().get(0).getKey());
            new BucketEntry(List.of("BrandB"), 2, InternalAggregations.EMPTY)
        assertEquals(meta, translator.toBucketAggregation(aggWithMeta, List.of()).getMetadata());  
            .subAggregation(new AvgAggregationBuilder("avg_price").field("price"));
}  
    }
import org.opensearch.index.mapper.MapperService;
        List<BucketEntry> entries = List.of(new BucketEntry(List.of(1.5), 3, InternalAggregations.EMPTY));
        List<BucketEntry> entries = List.of(
        assertEquals("true", terms.getBuckets().get(0).getKeyAsString());
    public void testRenderOfUnmappedFieldFailsLoudly() {
    /** Binary keys under a RAW-formatted (keyword) mapping render as address strings or Base64. */
        assertEquals(1.5, ((DoubleTerms) agg).getBuckets().get(0).getKey());
    private final TermsAggregationBuilder brandAgg = new TermsAggregationBuilder("by_brand").field("brand");  
        );
    /** Field types the mapped translator resolves, mirroring a real index mapping. */  
     */
        BucketOrder order = translator.getBucketOrder(brandAgg);  
        assertTrue(InternalOrder.isKeyAsc(compound.orderElements().get(1)));
        "price",
        );  
        assertEquals(List.of("nonexistent"), translator.getGrouping(badAgg).getFieldNames());
        new IpFieldMapper.IpFieldType("ip"),
    /** The sized path renders entries as received — plan order and truncation are authoritative. */
    /** ip keys arrive as 16-byte encoded addresses and render through the mapping's IP format. */
        "rating",  
        assertEquals("false", terms.getBuckets().get(1).getKeyAsString());
        assertTrue(((LongTerms) agg).getBuckets().isEmpty());
    }
        Map<String, Object> meta = Map.of("source", "dashboard");
        "brand",
        InternalAggregation agg = translator.toBucketAggregation(ratingAgg, entries, 3L);
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 2L);  
    // re-sorts, or truncates.  
        InternalAggregation agg = translator.toBucketAggregation(priceAgg, List.of());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
