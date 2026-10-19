                );
            },  
import org.opensearch.test.TestSearchContext;  
            put(LONG_FIELD, new NumberFieldMapper.NumberFieldType(LONG_FIELD, NumberFieldMapper.NumberType.LONG));  
            NONE_DECORATOR,
                );
        });
            }  
    }  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);
            MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("b|192.168.0.1"));
            iw.addDocument(  
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
        return Collections.unmodifiableList(  
            iw.addDocument(
import org.opensearch.index.query.QueryShardContext;  
        factory.terms(termsConfig);
                );
                    )
            vars -> ((Number) vars.get("_value")).doubleValue() + 1,
                    new NumericDocValuesField(INT_FIELD, 1),
            NONE_DECORATOR,  
                    )
    public void testIncludeExclude() throws IOException {  
                asList(
                iw.addDocument(  
            MatcherAssert.assertThat(h.getBuckets().get(6).getKey(), contains(equalTo("c"), equalTo(3L)));
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo(2L), equalTo(2L), equalTo(3.0), equalTo(3.0)));
        String v1 = UUID.randomUUID().toString();
                    )
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
        });
            multiTermsAggregationBuilder.size(10);  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(DATE_FIELD).setFormat("yyyy/MM/dd").build(),
                )
                );
        );
            multiTermsAggregationBuilder.size(3);
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f),
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));  
        BucketOrder order = mock(BucketOrder.class);  
    };
                iw.addDocument(  
            h -> {
        );
                    asList(
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.1"))))  
                asList(
    private void testAggregation(
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new FloatDocValuesField(FLOAT_FIELD, 2.0f)));  
            iw -> {
import org.opensearch.script.ScriptType;
    }
                );
                    new FloatDocValuesField(FLOAT_FIELD, 3.0f)
                );
            iw.addDocument(  
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
        return new DateFieldMapper.DateFieldType(  
import org.opensearch.index.mapper.MappedFieldType;
                iw.addDocument(  
            MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("c|192.168.0.2"));
                );
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
import org.apache.lucene.document.DoubleDocValuesField;
    public void testIpAndKeywordAscOrder() throws IOException {
                    )
                ));
                MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("2022-03-23|a"));  
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
    }
                        new StringField(KEYWORD_FIELD, "a", Field.Store.NO),
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
            put(GEO_POINT_FIELD, new GeoPointFieldMapper.GeoPointFieldType(GEO_POINT_FIELD));
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("a|false"));
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), NONE_DECORATOR, iw -> {
                asList(
import org.opensearch.index.mapper.NumberFieldMapper;
            List.of(),
                MatcherAssert.assertThat(h.getBuckets().get(3).getKey(), contains(equalTo("c"), equalTo(2L), equalTo(2.0)));
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
                    .setScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap()))
            MatcherAssert.assertThat(h.getBuckets(), hasSize(1));
            MatcherAssert.assertThat(h.getBuckets().get(3).getKeyAsString(), equalTo("b|true"));
                asList(
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
import org.opensearch.search.aggregations.AggregationBuilder;  
                    new SortedNumericDocValuesField(INT_FIELD, 1)  
                iw.addDocument(  
import org.opensearch.common.time.DateFormatter;
            );  
    private static final String DOUBLE_FIELD = "double";
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo(3L)));  
    };
        CardinalityUpperBound cardinality = CardinalityUpperBound.ONE;
                asList(
            new MatchAllDocsQuery(),  
            null,
        ipAndKeywordTest(multiTermsAggregationBuilder -> {
                )
                iw.addDocument(  
        );
            MatcherAssert.assertThat(h.getBuckets().get(3).getKey(), contains(equalTo("b"), equalTo(true)));  
        final MockScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, emptyMap());  
                        new SortedNumericDocValuesField(LONG_FIELD, 2L),  
        for (String term : terms) {
    }
                MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
            );
                        new SortedNumericDocValuesField(LONG_FIELD, 2L),
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.2"))))  
                iw.addDocument(  
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(false)));  
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(2L));  
    @Override
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
            h -> {
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                asList(
import org.opensearch.search.aggregations.support.ValuesSourceType;  
    }
        when(indexService.newQueryShardContext(0, null, () -> 0L, null)).thenReturn(queryShardContext);
                )
            MatcherAssert.assertThat(((InternalMax) (h.getBuckets().get(0).getAggregations().get("max"))).value(), closeTo(4.0f, 0.01));
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(2L));  
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, BOOL_FIELD)), NONE_DECORATOR, iw -> {
        }, IP_AND_KEYWORD_DESC_ORDER_VERIFY);  
            },
            put(FLOAT_FIELD, new NumberFieldMapper.NumberFieldType(FLOAT_FIELD, NumberFieldMapper.NumberType.FLOAT));
                    )
            iw.addDocument(
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                term(INT_FIELD)
    private static final String FIELD_NAME = "field";
    private static final Consumer<MultiTermsAggregationBuilder> NONE_DECORATOR = null;
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(4L)));
                    .setIncludeExclude(new IncludeExclude("a", null))
                iw.addDocument(  
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(INT_FIELD, 2)));
                iw.addDocument(  
            );
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
    private static final String VALUE_SCRIPT_NAME = "value_script";
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
    }
            FIELD_SCRIPT_NAME,
        ipAndKeywordTest(multiTermsAggregationBuilder -> {
            NONE_DECORATOR,  
                    )
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(2.0)));
import static org.hamcrest.Matchers.equalTo;  
    }  
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(2.0)));
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
        });  
        }, iw -> {
            },  
                asList(
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
            iw -> {
import org.opensearch.search.aggregations.AggregatorFactories;
            ),  
import org.opensearch.index.cache.IndexCache;  
            iw.addDocument(  
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
import org.opensearch.common.util.MockPageCacheRecycler;  
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("b"), equalTo(1L), equalTo(2.0)));
                )
                asList(
                );
            null
            asList(
                );
import org.opensearch.common.settings.Settings;  
    private static final String AGG_NAME = "_name";
    public void testEmpty() throws IOException {  
                    asList(
    }
            );
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
        MatcherAssert.assertThat(emptyAgg.getName(), equalTo(AGG_NAME));
                        new DoubleDocValuesField(DOUBLE_FIELD, 1.0d)
import static java.util.Collections.emptyMap;
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            );  
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("a"), equalTo("192.168.0.0")));  
                );
            metadata,  
import org.opensearch.search.aggregations.AggregatorTestCase;  
import org.opensearch.index.mapper.HllFieldMapper;
                )
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("b"), equalTo(false)));  
import java.util.Collections;
            iw.addDocument(
        MultiTermsAggregator.InternalValuesSource internalValuesSources = mock(MultiTermsAggregator.InternalValuesSource.class);
                asList(
import org.opensearch.script.Script;  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c"))  
            parent,
            collectMode,
                term(KEYWORD_FIELD)
            MatcherAssert.assertThat(((InternalMax) (h.getBuckets().get(2).getAggregations().get("max"))).value(), closeTo(3.0f, 0.01));
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import java.util.List;
            true,
                );
                    asList(
            );  
                iw.addDocument(  
            null,  
    private static final String LONG_FIELD = "long";
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(1.0)));
                iw.addDocument(singletonList(new SortedDocValuesField(UNRELATED_KEYWORD_FIELD, new BytesRef("unrelated"))));  
                asList(term(KEYWORD_FIELD), term(GEO_POINT_FIELD)),
                iw.addDocument(
    public void testMixKeywordAndBoolean() throws IOException {
    private static DateFieldMapper.DateFieldType dateFieldType(String name) {
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("c"), equalTo("192.168.0.2")));  
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
            new MatchAllDocsQuery(),
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(BOOL_FIELD, 0)));
                    asList(
                iw.addDocument(  
                final String fieldName = (String) vars.get(FIELD_NAME);
import org.apache.lucene.document.FloatDocValuesField;  
        testAggregation(
            cardinality,
        List<MultiTermsValuesSourceConfig> terms,
        }, IP_AND_KEYWORD_DESC_ORDER_VERIFY);
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
            ),  
            h -> {
                    new NumericDocValuesField(INT_FIELD, 2),
        InternalMultiTerms mt = (InternalMultiTerms) emptyAgg;
        testAggregation(
                new MatchAllDocsQuery(),
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(FIELD_NAME, 1))
import org.opensearch.search.internal.SearchContext;
import java.util.ArrayList;
        );
            IllegalArgumentException.class,
            iw -> {
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))  
                iw.addDocument(
            MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
            )  
                asList(  
                )  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c"))  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))  
    }
                    asList(  
            put(FIELD_NAME, new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.INTEGER));  
import org.opensearch.script.ScriptService;  
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)  
import static org.hamcrest.Matchers.closeTo;  
            factory.shardSize(randomIntBetween(10, Integer.MAX_VALUE));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(FIELD_NAME, 1))
        IndexService indexService = mock(IndexService.class);
        }, verify);  
                MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("a|02.00"));
import org.apache.lucene.document.Field;
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo(1L), equalTo(1L), equalTo(1.0), equalTo(1.0)));  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(FLOAT_FIELD).setMissing(2.0f).build()
        testAggregation(
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)  
                iw.addDocument(  
    private static final String BOOL_FIELD = "bool";  
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
        }, h -> {
        when(indexService.getShardOrNull(0)).thenReturn(indexShard);
                MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("2022-03-22|a"));
            iw.addDocument(asList(new NumericDocValuesField(INT_FIELD, 1), new FloatDocValuesField(FLOAT_FIELD, 2.0f)));
            null,
                CoreValuesSourceType.IP,
                iw.addDocument(  
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                    new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap(FIELD_NAME, FIELD_NAME))
                );
                        new StringField(KEYWORD_FIELD, "a", Field.Store.NO),
import org.apache.lucene.document.StringField;  
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), b -> b.minDocCount(2), iw -> {
    public void testScripts() throws IOException {
            DateFormatter.forPattern("date"),
                    asList(
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-22")),
        );
        });  
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD, FLOAT_FIELD)), NONE_DECORATOR, iw -> {
                    asList(
        when(indexService.cache()).thenReturn(cache);
            null,
                iw.addDocument(  
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));  
            );
                iw.addDocument(
    public void testEmptyAggregations() throws IOException {  
        MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo("192.168.0.0")));
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
    private static final Consumer<InternalMultiTerms> IP_AND_KEYWORD_DESC_ORDER_VERIFY = h -> {  
                    asList(  
                )
                );  
        Consumer<InternalMultiTerms> verify
            }  
            termConfigs.add(term(term));  
    public void testIpAndKeywordWithBucketCountGreaterThanSize() throws IOException {  
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                asList(
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f)  
        TermsAggregator.BucketCountThresholds bucketCountThresholds = mock(TermsAggregator.BucketCountThresholds.class);
    }  
 * SPDX-License-Identifier: Apache-2.0
            null,
                iw.addDocument(  
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(2L)));
                );
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("a"), equalTo(3L)));  
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));  
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(1L));
            );  
        }, h -> {
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
            ),
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                        new StringField(KEYWORD_FIELD, "a", Field.Store.NO),
            iw.addDocument(
                iw.addDocument(  
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(INT_FIELD, 1)));
                    )  
            put(DATE_FIELD, dateFieldType(DATE_FIELD));  
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));  
        });  
            iw.addDocument(
        MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                    )
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo(2L), equalTo(2L), equalTo(2.0), equalTo(2.0)));
            asList(term(KEYWORD_FIELD), new MultiTermsValuesSourceConfig.Builder().setFieldName(DOUBLE_FIELD).setFormat("00.00").build()),
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(1L));
                    )
                    new NumericDocValuesField(INT_FIELD, 1),  
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            MatcherAssert.assertThat(h.getBuckets().get(4).getDocCount(), equalTo(1L));
                );
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new DoubleDocValuesField(DOUBLE_FIELD, 2.0d))  
            vars -> {  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b"))  
                iw.addDocument(  
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(INT_FIELD, 2)));
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));  
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), NONE_DECORATOR, iw -> {
        }, h -> {  
            asList(
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f),  
    }
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(4.0)));
                    new NumericDocValuesField(INT_FIELD, 1),  
import org.opensearch.script.MockScriptEngine;
            MatcherAssert.assertThat(h.getBuckets(), hasSize(7));
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)  
            DateFieldMapper.Resolution.MILLISECONDS,  
import java.util.function.Function;
            }  
                )  
        MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("c|192.168.0.2"));  
    }
                iw.addDocument(
                iw.addDocument(
                iw -> {},
                );
            bucketCountThresholds,
                    )
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
    }
                    new SortedNumericDocValuesField(INT_FIELD, 3)
            );
                    asList(  
        DocValueFormat format = mock(DocValueFormat.class);
    }
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),  
            iw.addDocument(  
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));  
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    new NumericDocValuesField(INT_FIELD, 3),
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(2L), equalTo(2.0)));
                MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("b|02.00"));  
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(FIELD_NAME, 3))
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), NONE_DECORATOR, iw -> {}, h -> {
                    new SortedNumericDocValuesField(INT_FIELD, 1),  
            asList(  
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
        ipAndKeywordTest(multiTermsAggregationBuilder -> {  
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
            new MatchAllDocsQuery(),  
            iw.addDocument(
                    )  
                    new FloatDocValuesField(FLOAT_FIELD, 4.0f)
                MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
            iw.addDocument(  
        CheckedConsumer<RandomIndexWriter, IOException> indexBuilder,  
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-21")),
        if (randomBoolean()) {  
                    )  
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(1.0)));  
            asList(
        );  
        String k1 = UUID.randomUUID().toString();  
            MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("a|true"));
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-21")),
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
    }
    ) throws IOException {
    }
    private static final String DATE_FIELD = "date";  
                        new NumericDocValuesField(INT_FIELD, 1),
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo(3.0)));  
        if (decorator != NONE_DECORATOR) {
            put(IP_FIELD, new IpFieldMapper.IpFieldType(IP_FIELD));
    }
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD)
                    new NumericDocValuesField(INT_FIELD, 1),
                )
            ),  
                asList(  
            false,  
                )
    }  
    private static final String GEO_POINT_FIELD = "geopoint";
                    new SortedNumericDocValuesField(INT_FIELD, 3)  
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            },  
package org.opensearch.search.aggregations.bucket.terms;
                );
            iw.addDocument(  
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(2.0)));
        MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("b|192.168.0.1"));  
                        new FloatDocValuesField(FLOAT_FIELD, 3.0f),  
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(2L));  
    public void testIpAndKeywordDefaultDescOrder() throws IOException {  
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(FIELD_NAME, 1))
                )
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
            List.of(format),
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),  
            asList(new MultiTermsValuesSourceConfig.Builder().setFieldName(DATE_FIELD).build(), term(KEYWORD_FIELD)),  
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
import org.opensearch.index.IndexService;
                );
            b.subAggregation(new MaxAggregationBuilder("max").field(FLOAT_FIELD));
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), b -> {
                )  
    }
            fieldConfigs(asList(KEYWORD_FIELD, FLOAT_FIELD)),
import org.opensearch.index.mapper.GeoPointFieldMapper;  
                iw.addDocument(
import org.opensearch.script.ScriptModule;
            }  
                    new NumericDocValuesField(INT_FIELD, 1),
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new DoubleDocValuesField(DOUBLE_FIELD, 1.0d))  
import java.util.UUID;  
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f)
import org.opensearch.search.lookup.LeafDocLookup;
                        new NumericDocValuesField(INT_FIELD, 1),  
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                    new NumericDocValuesField(INT_FIELD, 1),  
import org.opensearch.common.CheckedConsumer;
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo("192.168.0.1")));  
                iw.addDocument(
    public void testMissing() throws IOException {
import org.hamcrest.MatcherAssert;
            List.of(internalValuesSources),  
                MatcherAssert.assertThat(h.getBuckets().get(3).getKeyAsString(), equalTo("2022/03/23|b"));  
                NONE_DECORATOR,  
import org.apache.lucene.document.SortedNumericDocValuesField;
                    new SortedNumericDocValuesField(INT_FIELD, 1),
        );
            new MatchAllDocsQuery(),  
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD, FLOAT_FIELD)), NONE_DECORATOR, iw -> {
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
                f -> fail("should throw exception")
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));  
        MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo("192.168.0.2")));
                )  
            );
                asList(  
            iw -> {
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
    }
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
            h -> {
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            iw.addDocument(
            multiTermsAggregationBuilder.order(BucketOrder.compound(BucketOrder.count(true)));  
                )
            VALUE_SCRIPT_NAME,  
import java.util.function.Consumer;
            new MatchAllDocsQuery(),
            h -> {
                        new SortedNumericDocValuesField(LONG_FIELD, 1L),
            AGG_NAME,
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("a|01.00"));
            ),  
        return factory;  
            put(KEYWORD_FIELD, new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD));
            new MatchAllDocsQuery(),
            factory.size(randomIntBetween(10, Integer.MAX_VALUE));
import org.apache.lucene.index.Term;
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),  
                MatcherAssert.assertThat(h.getBuckets(), hasSize(2));
    }
                        new SortedNumericDocValuesField(LONG_FIELD, 2L),
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))  
            );  
                iw.addDocument(  
 *
                )
    public void testNumberFieldFormat() throws IOException {
        InternalAggregation emptyAgg = mAgg.buildEmptyAggregation();  
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(BOOL_FIELD, 0)));
            new MatchAllDocsQuery(),
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(BOOL_FIELD, 1)));  
        );  
                )
        testAggregation(  
                );
                    asList(
                        new DoubleDocValuesField(DOUBLE_FIELD, 1.0d)  
    public void testOrderByMetrics() throws IOException {
        MultiTermsAggregationBuilder builder = createTestAggregatorBuilder(terms);  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(INT_FIELD).setMissing(1).build(),
            name,
import org.apache.lucene.document.NumericDocValuesField;
import org.opensearch.index.mapper.IpFieldMapper;
                    asList(
                iw.addDocument(  
        Aggregator.SubAggCollectionMode collectMode = Aggregator.SubAggCollectionMode.BREADTH_FIRST;
            }  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                // missing FLOAT_FIELD
                    asList(  
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f),
        testAggregation(
    }
        Aggregator parent = mock(Aggregator.class);  
            },
            asList(
            iw.addDocument(  
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo("2")));
                    new SortedNumericDocValuesField(INT_FIELD, 1),  
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
            NONE_DECORATOR,
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
        }, h -> {
                );
                new MultiTermsValuesSourceConfig.Builder().setScript(  
            iw.addDocument(  
                );
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
        final Map<String, Function<Map<String, Object>, Object>> scripts = Map.of(
import static java.util.Collections.singletonList;  
            );
            factory.showTermDocCountError(randomBoolean());
            true,
import static org.hamcrest.Matchers.hasSize;
    public void testDates() throws IOException {  
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));  
    private static final String INT_FIELD = "int";
                        new StringField(KEYWORD_FIELD, "b", Field.Store.NO),  
            MatcherAssert.assertThat(h.getBuckets(), hasSize(1));  
                ).build()
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(FIELD_NAME, 3))
import org.apache.lucene.search.MatchAllDocsQuery;
    private void ipAndKeywordTest(Consumer<MultiTermsAggregationBuilder> builderDecorator, Consumer<InternalMultiTerms> verify)  
                    asList(
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
import org.apache.lucene.util.BytesRef;  
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(1.0)));  
                iw.addDocument(
            iw.addDocument(  
            );
        }
import org.apache.lucene.document.SortedSetDocValuesField;
            h -> {
            order,  
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new DoubleDocValuesField(DOUBLE_FIELD, 2.0d))  
            multiTermsAggregationBuilder.minDocCount(0);
            );
            },  
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new DoubleDocValuesField(DOUBLE_FIELD, 1.0d))  
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo("3")));  
        );
                );  
            Collections.emptyMap()
                )
                        new SortedNumericDocValuesField(LONG_FIELD, 1L),
    private static final String IP_FIELD = "ip";
                        new NumericDocValuesField(INT_FIELD, 2),  
        );
import org.opensearch.index.shard.IndexShard;
        IndexCache cache = mock(IndexCache.class);  
                return lookup.get(fieldName).stream().map(value -> ((Number) value).longValue() + 1).collect(toList());  
        MatcherAssert.assertThat(emptyAgg, instanceOf(InternalMultiTerms.class));  
    }
        }, h -> {
        );  
    public void testMixNumberAndKeyword() throws IOException {
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));  
        MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("a|192.168.0.0"));  
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(2L));
        testAggregation(
                    new SortedNumericDocValuesField(INT_FIELD, 2)
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
import java.util.Map;
        );  
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
        when(cache.bitsetFilterCache()).thenReturn(null);
                        new DoubleDocValuesField(DOUBLE_FIELD, 3.0d)  
        ipAndKeywordTest(NONE_DECORATOR, IP_AND_KEYWORD_DESC_ORDER_VERIFY);
            b.order(BucketOrder.aggregation("max", false));  
                iw.addDocument(  
                iw.addDocument(  
import java.io.IOException;  
            asList(  
                MatcherAssert.assertThat(h.getBuckets().get(3).getKeyAsString(), equalTo("2022-03-23|b"));  
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
        Map<String, Object> metadata = new HashMap<>();
            }  
import org.opensearch.search.aggregations.Aggregator;
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),  
        return createTestAggregatorBuilder(asList(term(fieldName), term(fieldName)));  
            }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
                asList(
import static org.hamcrest.Matchers.contains;
            ),  
                iw.addDocument(  
            );  
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("b"), equalTo(2L)));
            put(UNRELATED_KEYWORD_FIELD, new KeywordFieldMapper.KeywordFieldType(UNRELATED_KEYWORD_FIELD));
            decorator.accept(builder);
        });
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),  
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f)
            MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("b|false"));
import org.opensearch.search.aggregations.support.ValueType;
                    new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap(FIELD_NAME, FIELD_NAME))
        }  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),  
                    new NumericDocValuesField(INT_FIELD, 3),
        Consumer<MultiTermsAggregationBuilder> decorator,
                        // missing KEYWORD_FIELD  
import org.opensearch.search.aggregations.metrics.InternalMax;
    @Override
    }
            context,  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
                );
                        new DoubleDocValuesField(DOUBLE_FIELD, 2.0d)
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));  
            new MatchAllDocsQuery(),
        });
        throws IOException {
    public void testScriptsWithoutValueTypeHint() throws IOException {
                    )
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(BOOL_FIELD, 1)));  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).setMissing("a").build(),  
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                )
        return List.of(HllFieldMapper.CONTENT_TYPE);
                MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("2022-03-21|c"));
            multiTermsAggregationBuilder.order(BucketOrder.compound(BucketOrder.count(false)));
                    )
        }
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    asList(
                iw.addDocument(  
        metadata.put(k1, v1);
 * The OpenSearch Contributors require contributions made to  
            }
                    new NumericDocValuesField(INT_FIELD, 2),  
import static java.util.stream.Collectors.toList;
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
        MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                        new FloatDocValuesField(FLOAT_FIELD, 3.0f),
import org.opensearch.common.util.BigArrays;
                asList(  
                CoreValuesSourceType.NUMERIC,
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b"))  
                );
                MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
            );
        MultiTermsAggregator mAgg = new MultiTermsAggregator(
            multiTermsAggregationBuilder.minDocCount(0);
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(2L)));
    }
                iw.addDocument(
            null,
            h -> {  
import java.util.HashMap;  
    private static final String FLOAT_FIELD = "float";  
                );
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-22")),
                );
import static org.hamcrest.Matchers.empty;
                MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("2022/03/22|a"));
            }
                    new NumericDocValuesField(INT_FIELD, 1),  
    public void testMixNumberAndKeywordWithFilter() throws IOException {
import static org.mockito.Mockito.mock;  
}
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
        }, h -> {  
            )
    public void testGeoPointField() {  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))  
            iw -> {  
    }  
                    asList(
    private MultiTermsValuesSourceConfig term(String field) {
            multiTermsAggregationBuilder.size(3);
import static org.hamcrest.Matchers.instanceOf;
                asList(
        AggregatorFactories factories = AggregatorFactories.EMPTY;
        MatcherAssert.assertThat(mt.getMetadata().keySet(), contains(k1));  
                    asList(
        }
                    asList(
            null,
            new TermQuery(new Term(KEYWORD_FIELD, "a")),  
            put(DOUBLE_FIELD, new NumberFieldMapper.NumberFieldType(DOUBLE_FIELD, NumberFieldMapper.NumberType.DOUBLE));
    private static final Map<String, MappedFieldType> mappedFieldTypeMap = new HashMap<String, MappedFieldType>() {  
        testCase(builder, query, indexBuilder, verify, mappedFieldTypeMap.values().toArray(new MappedFieldType[] {}));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(FIELD_NAME, 3))
                asList(
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("b"), equalTo(1L)));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(1.0)));
import static java.util.Collections.singletonMap;
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                    asList(
            },  
        }
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                    )
            iw -> {
                    )
            iw.addDocument(
            );
        }, h -> {
            h -> {
            }
            MatcherAssert.assertThat(h.getBuckets().get(3).getKey(), contains(equalTo("b"), equalTo(1L)));
            iw -> {
                )
            MatcherAssert.assertThat(h.getBuckets().get(5).getKey(), contains(equalTo("c"), equalTo(1L)));  
        BigArrays bigArrays = new BigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService(), "");  
            MatcherAssert.assertThat(h.getBuckets().get(4).getKey(), contains(equalTo("b"), equalTo(2L)));
import org.apache.lucene.document.SortedDocValuesField;  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))  
            () -> testAggregation(  
import org.apache.lucene.document.InetAddressPoint;
import org.opensearch.search.aggregations.InternalAggregation;  
    public void testDatesFieldFormat() throws IOException {  
    }
            put(BOOL_FIELD, new BooleanFieldMapper.BooleanFieldType(BOOL_FIELD));  
                final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
            iw.addDocument(
 * compatible open source license.
    }
                iw.addDocument(  
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(3L)));
        });  
        IndexShard indexShard = mock(IndexShard.class);
    public void testMinDocCount() throws IOException {
        MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
 */  
import org.apache.lucene.search.Query;  
                );
    public void testNull() throws IOException {
            MatcherAssert.assertThat(h.getBuckets(), hasSize(0));  
            );  
                );
    @Override  
import org.apache.lucene.tests.index.RandomIndexWriter;
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
        {
                        new NumericDocValuesField(INT_FIELD, 1),  
                    )
                iw.addDocument(
                )
            put(INT_FIELD, new NumberFieldMapper.NumberFieldType(INT_FIELD, NumberFieldMapper.NumberType.INTEGER));
                );
                MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
            );
                CoreValuesSourceType.BYTES,  
    private static final String UNRELATED_KEYWORD_FIELD = "unrelated";
import org.opensearch.search.aggregations.BucketOrder;
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
    private MultiTermsAggregationBuilder createTestAggregatorBuilder(List<MultiTermsValuesSourceConfig> termsConfig) {
            },
            MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
 * this file be licensed under the Apache-2.0 license or a
            asList(
        List<MultiTermsValuesSourceConfig> termConfigs = new ArrayList<>();
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
                new MultiTermsValuesSourceConfig.Builder().setFieldName(FIELD_NAME)  
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
                );
                    new FloatDocValuesField(FLOAT_FIELD, 3.0f)  
                );  
            iw -> {
    }  
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, IP_FIELD)), builderDecorator, iw -> {
        );  
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo("4")));
    @Override
    private static final String FIELD_SCRIPT_NAME = "field_script";  
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
                );
    public void testMultiValuesField() throws IOException {  
                        new NumericDocValuesField(INT_FIELD, 1),
                );
        SearchContext context = new TestSearchContext(bigArrays, indexService);  
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.0"))))  
        );
                );  
            showTermDocCountError,
            MatcherAssert.assertThat(((InternalMax) (h.getBuckets().get(1).getAggregations().get("max"))).value(), closeTo(3.0f, 0.01));
            h -> {  
import static org.mockito.Mockito.when;
                asList(
        testAggregation(
import org.opensearch.index.mapper.BooleanFieldMapper;
        });
                iw.addDocument(
            },  
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
                );
        }
            factories,  
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("2022/03/23|a"));  
                    )
                    new NumericDocValuesField(INT_FIELD, 2),
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
                    )
            List.of(),
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            iw -> {
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(true)));  
import org.opensearch.search.DocValueFormat;
import org.opensearch.script.ScriptEngine;
        MatcherAssert.assertThat(mt.getMetadata().get(k1), equalTo(v1));
                    )
            MatcherAssert.assertThat(h.getBuckets().get(6).getDocCount(), equalTo(1L));  
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
                iw.addDocument(  
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("d")), new NumericDocValuesField(INT_FIELD, 3)));
                iw.addDocument(
import org.opensearch.common.network.InetAddresses;
                );
    }  
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),  
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(field).build();
            },  
        MatcherAssert.assertThat(mt.getBuckets(), empty());
                    .build()
                        new NumericDocValuesField(INT_FIELD, 2),
            iw.addDocument(
    public void testValueScripts() throws IOException {
                        // missing INT_FIELD
                    asList(
                CoreValuesSourceType.BOOLEAN  
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(3L)));
    private List<MultiTermsValuesSourceConfig> fieldConfigs(List<String> terms) {  
        testAggregation(  
    }  
/*  
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))  
            multiTermsAggregationBuilder.order(BucketOrder.compound(BucketOrder.count(false)));
        if (randomBoolean()) {  
                iw.addDocument(  
    protected List<String> unsupportedMappedFieldTypes() {  
            );
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
        testAggregation(
        );
                new MultiTermsValuesSourceConfig.Builder().setScript(  
    public void testNumbers() throws IOException {
                    asList(
                iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
                CoreValuesSourceType.DATE,
                MatcherAssert.assertThat(h.getBuckets(), hasSize(4));  
        MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("b"), equalTo("192.168.0.1")));
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)
    private static final String KEYWORD_FIELD = "keyword";
            MatcherAssert.assertThat(h.getBuckets().get(5).getDocCount(), equalTo(1L));
public class MultiTermsAggregatorTests extends AggregatorTestCase {  
        boolean showTermDocCountError = true;  
            h -> {
            new MatchAllDocsQuery(),
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(INT_FIELD, 2)  
        Query query,  
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.0"))))  
    }
                    )
    }
            }
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
        MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
            MatcherAssert.assertThat(h.getName(), equalTo(AGG_NAME));
                MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("2022/03/21|c"));
                        new NumericDocValuesField(INT_FIELD, 2),
            iw -> {
            fieldConfigs(asList(INT_FIELD, LONG_FIELD, FLOAT_FIELD, DOUBLE_FIELD)),
            MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("a|192.168.0.0"));
        if (randomBoolean()) {  
                MatcherAssert.assertThat(h.getBuckets(), hasSize(1));
                    asList(
import static java.util.Arrays.asList;
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
        }, h -> {  
        testAggregation(  
import org.opensearch.index.mapper.DateFieldMapper;
    public void testIpAndKeywordWithBucketCountSameAsSize() throws IOException {
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(INT_FIELD, 1)));  
        return termConfigs;
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 2)));
                );
import org.opensearch.index.mapper.KeywordFieldMapper;  
        assertThrows(
    protected ScriptService getMockScriptService() {
                asList(  
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
                );
            MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));  
                    asList(
import org.apache.lucene.search.TermQuery;
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("b"), equalTo(1L), equalTo(2.0)));
                asList(
                    .build(),  
        MultiTermsAggregationBuilder factory = new MultiTermsAggregationBuilder(AGG_NAME);  
                        new DoubleDocValuesField(DOUBLE_FIELD, 3.0d)
            iw.addDocument(  
                    )  
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));  
                ).setUserValueTypeHint(ValueType.LONG).build()
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            multiTermsAggregationBuilder.minDocCount(0);  
