        when(mapperService.fieldType(anyString())).thenAnswer(invocation -> FIELD_TYPES.get(invocation.<String>getArgument(0)));
import static org.mockito.ArgumentMatchers.anyString;
        assertNotNull(order);
import static org.mockito.Mockito.mock;
        TermsAggregationBuilder dateAgg = new TermsAggregationBuilder("by_day").field("created");
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
    public void testIntegralKeysProduceLongTermsWithNumericKeys() {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }
import org.opensearch.index.mapper.DateFieldMapper;
        assertEquals(2, terms.getBuckets().size());
    }
        TermsAggregationBuilder priceAgg = new TermsAggregationBuilder("by_price").field("price");
     */
        assertEquals("BrandA", terms.getBuckets().get(0).getKeyAsString());
        // Typed key paths echo meta too
    private final TermsAggregationBuilder brandAgg = new TermsAggregationBuilder("by_brand").field("brand");
                InternalAggregations.EMPTY
    public void testGroupingReturnsFieldNameAsIs() {
        assertTrue(agg instanceof LongTerms);
        "flag",
    public void testValidateRejectsDateField() {
    public void testFloatingKeysProduceDoubleTerms() {
    /** ip keys arrive as 16-byte encoded addresses and render through the mapping's IP format. */
    public void testToBucketAggregationBuildsStringTerms() {
                List.of(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) 0xff, (byte) 0xff, 10, 0, 0, 1 }),
        assertNotNull(order);
            new BucketEntry(List.of(42L), 3, InternalAggregations.EMPTY),
        assertTrue(InternalOrder.isKeyAsc(compound.orderElements().get(1)));
    }
        assertTrue(InternalOrder.isKeyOrder(order));
        TermsAggregationBuilder numWithMeta = new TermsAggregationBuilder("by_price").field("price");
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 100L);
        List<BucketEntry> entries = List.of(new BucketEntry(List.of(1.5), 3, InternalAggregations.EMPTY));
    public void testNonEmptyRenderWithoutTotalsFailsLoudly() {
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("BrandA"), 5, InternalAggregations.EMPTY));
                List.of(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) 0xff, (byte) 0xff, 10, 0, 0, 2 }),
                InternalAggregations.EMPTY
    // Null-key exclusion is a plan contract (pre-aggregate IS NOT NULL filter, see
/*
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> translator.toBucketAggregation(brandAgg, entries));
import org.opensearch.index.mapper.MappedFieldType;
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
        TermsAggregationBuilder dateAgg = new TermsAggregationBuilder("by_day").field("created_nanos");
            new BucketEntry(List.of("BrandA"), 5, InternalAggregations.EMPTY)
    public void testValidateAcceptsNonDateMappedField() throws Exception {
        assertEquals(0L, terms.getBuckets().get(1).getKey());
import java.util.Map;
import org.opensearch.index.mapper.IpFieldMapper;
    private final TermsBucketTranslator translator = new TermsBucketTranslator(TermsBucketTranslatorTests::mappedService);
        numWithMeta.setMetadata(meta);
        List<BucketEntry> entries = List.of(new BucketEntry(List.of(200L), 5, InternalAggregations.EMPTY));
        );
     * make the eligible count smaller than the rendered sum. Clamp instead of going negative.
    }
    public void testMetadataEchoedInBucketAggregation() {
        assertTrue(translator.getSubAggregations(brandAgg).isEmpty());
        // key(true) is already a key order — stored directly, not wrapped in CompoundOrder
    public void testValidateRejectsDateNanosField() {
        InternalAggregation agg = translator.toBucketAggregation(priceAgg, List.of());
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true));
        assertEquals(2, terms.getBuckets().get(1).getDocCount());
        assertTrue(agg instanceof StringTerms);
import org.opensearch.index.mapper.MapperService;
        aggWithMeta.setMetadata(meta);
    public void testEmptySubAggregations() {
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        assertFalse(InternalOrder.isKeyAsc(order));
        assertTrue(e.getMessage().contains("date field [created_nanos]"));
        // key(false) is a key order — stored directly, not wrapped in CompoundOrder
        "ip",
        List<BucketEntry> entries = List.of(
        BucketOrder order = translator.getBucketOrder(brandAgg);
    public void testEmptyBucketsAreTypedByMapping() {
        MappedFieldType nanosType = mock(MappedFieldType.class);
     * Every terms plan is bounded, so a non-empty render without plan totals means the sized
        assertNull(translator.toBucketAggregation(brandAgg, List.of()).getMetadata());
        assertEquals(2, compound.orderElements().size());
    }
            new BucketEntry(List.of(7), 2, InternalAggregations.EMPTY)
        InternalAggregation agg = translator.toBucketAggregation(priceAgg, entries, 5L);
        assertEquals(42L, terms.getBuckets().get(0).getKey());
        assertEquals("BrandB", terms.getBuckets().get(0).getKeyAsString());
            new BucketEntry(List.of(false), 2, InternalAggregations.EMPTY)
        assertEquals(3L, terms.getSumOfOtherDocCounts());
        List<BucketEntry> entries = List.of(
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
        assertEquals(7L, terms.getSumOfOtherDocCounts());
    /** Field types the mapped translator resolves, mirroring a real index mapping. */
        TermsAggregationBuilder dateAgg = new TermsAggregationBuilder("by_day").field("created");
        assertFalse(order instanceof InternalOrder.CompoundOrder);
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
            new BucketEntry(List.of("BrandA"), 3, InternalAggregations.EMPTY),
    }
import org.opensearch.search.aggregations.InternalAggregation;
    }
        assertEquals(7L, terms.getBuckets().get(1).getKey());
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 1L);
    }
        assertNotNull(order);
        assertTrue(agg instanceof DoubleTerms);
    }
        assertEquals(3, terms.getBuckets().get(0).getDocCount());
     */
    // SearchSourceConverterTests) — the translator no longer re-implements it.
     * would mask it with a silently wrong sum_other_doc_count; fail loudly instead.
        assertTrue(order instanceof InternalOrder.CompoundOrder);
        new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG),
        );
    public void testGetGrouping() {
    }
        assertTrue(InternalOrder.isKeyAsc(compound.orderElements().get(1)));
            new BucketEntry(List.of("BrandB"), 2, InternalAggregations.EMPTY)
        assertEquals(1, translator.getSubAggregations(aggWithSub).size());
    }
    public void testGetBucketOrderReturnsKeyDesc() {
        TermsBucketTranslator nanosTranslator = new TermsBucketTranslator(() -> mapperService);
    // Ordering, min_doc_count, and truncation are plan contracts (SORT, HAVING, and LIMIT baked
        InternalAggregation agg = translator.toBucketAggregation(brandAgg, List.of());
        );
 * The OpenSearch Contributors require contributions made to
        assertTrue(e.getMessage().contains("not present in the index mapping"));
    public void testGetBucketOrderReturnsCountAsc() {
import static org.mockito.Mockito.when;
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(false));
    // ---- Mapping resolution is required for rendering ----
        );
        assertEquals(95L, terms.getSumOfOtherDocCounts());
    }
        InternalOrder.CompoundOrder compound = (InternalOrder.CompoundOrder) order;
            ),
            new BucketEntry(List.of("BrandB"), 2, InternalAggregations.EMPTY),
    /** A field the mapping does not know cannot be typed — rendering fails loudly. */
        TermsAggregationBuilder priceAgg = new TermsAggregationBuilder("by_price").field("price");
        assertTrue(e.getMessage().contains("index mapping unavailable"));
    );
        assertTrue(order instanceof InternalOrder.CompoundOrder);
        assertTrue(InternalOrder.isKeyAsc(order));
        IllegalStateException e = expectThrows(
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand")
            new BucketEntry(
        // Default terms order is compound: _count desc, _key asc
    }
        new KeywordFieldMapper.KeywordFieldType("brand"),
        assertNotNull(order);
        "created",
        assertTrue(((StringTerms) agg).getBuckets().isEmpty());
    }
        Map<String, Object> meta = Map.of("source", "dashboard");
    }
    }
        BucketOrder order = translator.getBucketOrder(aggWithOrder);
import org.opensearch.search.aggregations.InternalAggregations;
    }
        assertEquals("10.0.0.2", terms.getBuckets().get(1).getKeyAsString());
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("BrandA"), 5, InternalAggregations.EMPTY));
    }
    private static MapperService mappedService() {
    }
            new BucketEntry(
    }
        InternalAggregation agg = translator.toBucketAggregation(ratingAgg, entries, 3L);
        assertEquals(meta, translator.toBucketAggregation(aggWithMeta, List.of()).getMetadata());
        assertEquals("10.0.0.1", terms.getBuckets().get(0).getKeyAsString());
        assertTrue(((LongTerms) agg).getBuckets().isEmpty());
        // metric order is not a key order — wrapped in CompoundOrder with _key asc tie-breaker
        List<BucketEntry> entries = List.of(
 * compatible open source license.
        translator.validate(brandAgg); // must not throw
    private final TermsBucketTranslator unmappedTranslator = new TermsBucketTranslator(() -> null);
        return mapperService;
    }
        new IpFieldMapper.IpFieldType("ip"),
        assertTrue(InternalOrder.isCountDesc(compound.orderElements().get(0)));
    }
        // count(true) is not a key order — wrapped in CompoundOrder with _key asc tie-breaker
        TermsAggregationBuilder boolAgg = new TermsAggregationBuilder("by_flag").field("flag");
    }
    /** Binary keys under a RAW-formatted (keyword) mapping render as address strings or Base64. */
        // No meta on the request → none in the response
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 10L);
    /** An empty result renders through the mapping too — a numeric field yields empty LongTerms, not StringTerms. */
        "price",
        InternalOrder.CompoundOrder compound = (InternalOrder.CompoundOrder) order;
        assertTrue(compound.orderElements().get(0) instanceof InternalOrder.Aggregation);
    }
        assertEquals(2, compound.orderElements().size());
    // ---- validate(): date fields are rejected at conversion time ----
        assertEquals(List.of("nonexistent"), translator.getGrouping(badAgg).getFieldNames());
        when(nanosType.typeName()).thenReturn(DateFieldMapper.DATE_NANOS_CONTENT_TYPE);
        new BooleanFieldMapper.BooleanFieldType("flag"),
    }
        assertEquals(1L, terms.getBuckets().get(0).getKey());
    // ---- Pushdown mode: totals-derived sum_other_doc_count ----
        TermsAggregationBuilder ipAgg = new TermsAggregationBuilder("by_ip").field("ip");
        assertEquals(0L, terms.getSumOfOtherDocCounts());
    /** Under fetch pushdown the tail never leaves the engine — sum_other = eligible − Σ(rendered). */
                3,
        assertTrue(InternalOrder.isKeyOrder(order));
    /** The sized path renders entries as received — plan order and truncation are authoritative. */
        List<BucketEntry> entries = List.of(
    public void testGetBucketOrderReturnsDefault() {
        );
        List<BucketEntry> entries = List.of(
            new BucketEntry(List.of(true), 3, InternalAggregations.EMPTY),
        // Translator just captures the field name; validation happens at build time in the builder
import org.opensearch.search.aggregations.InternalOrder;
     * dispatch was bypassed — an internal wiring bug. Truncating and tail-summing client-side
    public void testBooleanKeysRenderLikeClassicBooleanTerms() {
public class TermsBucketTranslatorTests extends OpenSearchTestCase {
        assertTrue(e.getMessage().contains("sized path"));
    public void testValidateSkipsMappingChecksWithoutMapperService() throws Exception {
            new BucketEntry(List.of("BrandA"), 3, InternalAggregations.EMPTY),
        unmappedTranslator.validate(dateAgg); // must not throw
        );
        new DateFieldMapper.DateFieldType("created")
        ConversionException e = expectThrows(ConversionException.class, () -> translator.validate(dateAgg));
        new NumberFieldMapper.NumberFieldType("rating", NumberFieldMapper.NumberType.DOUBLE),
            .subAggregation(new AvgAggregationBuilder("avg_price").field("price"));
        assertEquals("true", terms.getBuckets().get(0).getKeyAsString());
        assertEquals(2, compound.orderElements().size());
    public void testUndecodableBinaryKeyFallsBackToBase64() {
    public void testSizedPathRendersEntriesAsReceived() {
            new BucketEntry(List.of("BrandB"), 2, InternalAggregations.EMPTY)
        assertEquals("BrandA", terms.getBuckets().get(1).getKeyAsString());
import org.opensearch.dsl.result.BucketEntry;
        assertTrue(agg instanceof LongTerms);
            () -> unmappedTranslator.toBucketAggregation(brandAgg, entries, 5L)
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("x"), 1, InternalAggregations.EMPTY));
    /** The engine returns date group keys as strings — reject at conversion with a clear 400. */
        List<BucketEntry> entries = List.of(
            IllegalStateException.class,
            )
    public void testRenderOfUnmappedFieldFailsLoudly() {
        LongTerms terms = (LongTerms) agg;
        assertEquals("AQID", terms.getBuckets().get(0).getKeyAsString());
        TermsAggregationBuilder ratingAgg = new TermsAggregationBuilder("by_rating").field("rating");
        TermsAggregationBuilder aggWithSub = new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals(brandAgg.getName(), terms.getName());
        MapperService mapperService = mock(MapperService.class);
        TermsAggregationBuilder aggWithMeta = new TermsAggregationBuilder("by_brand").field("brand");
    /**
import org.opensearch.index.mapper.BooleanFieldMapper;
        assertEquals(List.of("brand"), translator.getGrouping(brandAgg).getFieldNames());
        when(mapperService.fieldType("created_nanos")).thenReturn(nanosType);
    }
        assertEquals("42", terms.getBuckets().get(0).getKeyAsString());
        TermsAggregationBuilder priceAgg = new TermsAggregationBuilder("by_price").field("price");
import org.opensearch.index.mapper.NumberFieldMapper;
        List<BucketEntry> entries = List.of(new BucketEntry(List.of("BrandA"), 3, InternalAggregations.EMPTY));
    }
                2,
        MapperService mapperService = mock(MapperService.class);
        ConversionException e = expectThrows(ConversionException.class, () -> nanosTranslator.validate(dateAgg));
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(2, terms.getBuckets().size());
    }
        StringTerms terms = (StringTerms) translator.toBucketAggregation(brandAgg, entries, 2L);
        assertFalse(order instanceof InternalOrder.CompoundOrder);
    /** User-supplied meta must be echoed back on the response aggregation, like classic search. */
    public void testBinaryKeysDecodeToIpAddressStrings() {
    private static final Map<String, MappedFieldType> FIELD_TYPES = Map.of(
        List<BucketEntry> numeric = List.of(new BucketEntry(List.of(1L), 1, InternalAggregations.EMPTY));
        TermsAggregationBuilder aggWithOrder = new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(true));
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        assertEquals("false", terms.getBuckets().get(1).getKeyAsString());
        "brand",
    // re-sorts, or truncates.
        assertTrue(InternalOrder.isKeyAsc(compound.orderElements().get(1)));
        assertEquals(TermsAggregationBuilder.class, translator.getAggregationType());
    public void testGetBucketOrderReturnsMetricOrder() {
        assertEquals(meta, translator.toBucketAggregation(numWithMeta, numeric, 1L).getMetadata());
    /** Totals arithmetic applies to typed key paths too. */
}
    }
        "rating",
    public void testRenderWithoutMapperServiceFailsLoudly() {
        LongTerms terms = (LongTerms) translator.toBucketAggregation(boolAgg, entries, 5L);
    public void testReportsCorrectType() {
        InternalOrder.CompoundOrder compound = (InternalOrder.CompoundOrder) order;
    public void testPushdownNumericKeysUseTotals() {
        assertNotNull(order);
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
 * this file be licensed under the Apache-2.0 license or a
        );
 * SPDX-License-Identifier: Apache-2.0
     * The count plan and the main plan are separate engine queries — a refresh between them can
    /** Mapping-dependent validation is skipped when no MapperService is supplied (conversion-only use). */
    public void testPushdownSumOtherDerivedFromTotals() {
 */
    public void testPushdownSumOtherClampedAtZero() {
        assertTrue(agg instanceof StringTerms);
        assertEquals("BrandB", terms.getBuckets().get(1).getKeyAsString());
        TermsAggregationBuilder unknownAgg = new TermsAggregationBuilder("by_unknown").field("unknown");
    /**
import org.opensearch.dsl.converter.ConversionException;
        assertEquals(BucketOrder.count(true), compound.orderElements().get(0));
import java.util.List;
        LongTerms terms = (LongTerms) translator.toBucketAggregation(priceAgg, entries, 12L);
    public void testToBucketAggregationEmptyBuckets() {
        StringTerms terms = (StringTerms) agg;
        assertEquals(1.5, ((DoubleTerms) agg).getBuckets().get(0).getKey());
            .order(BucketOrder.aggregation("avg_price", false));
        assertTrue(order instanceof InternalOrder.CompoundOrder);
        // Deliberately not in the default count-desc order: the translator must not re-sort.
    /** Without a MapperService the key type cannot be resolved — rendering fails loudly. */
        StringTerms terms = (StringTerms) translator.toBucketAggregation(ipAgg, entries, 5L);
    public void testGetSubAggregations() {
        assertTrue(e.getMessage().contains("date field [created]"));
        TermsAggregationBuilder badAgg = new TermsAggregationBuilder("by_bad").field("nonexistent");
 *
package org.opensearch.dsl.aggregation.bucket;
        List<BucketEntry> entries = List.of(new BucketEntry(List.of(new byte[] { 1, 2, 3 }), 1, InternalAggregations.EMPTY));
        InternalAggregation agg = translator.toBucketAggregation(brandAgg, entries, 5L);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> translator.toBucketAggregation(unknownAgg, entries, 1L));
    }
    // into every plan) — the translator renders entries in received order and never re-filters,
import org.opensearch.search.aggregations.BucketOrder;
    }
    public void testGetBucketOrderReturnsCustomOrder() {
