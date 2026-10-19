            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("b"), equalTo(2L)));
                        new DoubleDocValuesField(DOUBLE_FIELD, 2.0d)
            iw.addDocument(
                NONE_DECORATOR,
                MatcherAssert.assertThat(h.getBuckets(), hasSize(2));
import org.apache.lucene.document.SortedNumericDocValuesField;
        });
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(BOOL_FIELD, 0)));
            null,
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
                    new NumericDocValuesField(INT_FIELD, 1),
    }
            iw.addDocument(
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c"))
    }
        testAggregation(
            MatcherAssert.assertThat(h.getBuckets().get(3).getKeyAsString(), equalTo("b|true"));
        MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
            put(BOOL_FIELD, new BooleanFieldMapper.BooleanFieldType(BOOL_FIELD));
                        new StringField(KEYWORD_FIELD, "a", Field.Store.NO),
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                );
            vars -> {
            MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("a|192.168.0.0"));
        );
        testAggregation(
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
            );
                iw.addDocument(
            new MatchAllDocsQuery(),
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            factory.showTermDocCountError(randomBoolean());
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new DoubleDocValuesField(DOUBLE_FIELD, 1.0d))
            );
    private static final String LONG_FIELD = "long";
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
    private static final String AGG_NAME = "_name";
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.2"))))
 * SPDX-License-Identifier: Apache-2.0
                        new SortedNumericDocValuesField(LONG_FIELD, 2L),
    }
    }
            },
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
    public void testEmptyAggregations() throws IOException {
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(FIELD_NAME, 1))
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            multiTermsAggregationBuilder.size(3);
            );
            factory.shardSize(randomIntBetween(10, Integer.MAX_VALUE));
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo("4")));
                    )
            NONE_DECORATOR,
}
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(true)));
        }
                final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
                    asList(
                CoreValuesSourceType.DATE,
                )
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(2.0)));
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
                f -> fail("should throw exception")
            iw.addDocument(
        }, h -> {
        Consumer<InternalMultiTerms> verify
                        new NumericDocValuesField(INT_FIELD, 1),
import org.opensearch.search.aggregations.metrics.InternalMax;
            MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
import org.opensearch.index.mapper.BooleanFieldMapper;
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD, FLOAT_FIELD)), NONE_DECORATOR, iw -> {
                asList(
    public void testIpAndKeywordAscOrder() throws IOException {
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                )
                iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo(3L)));
    private static final String FIELD_SCRIPT_NAME = "field_script";
                    new FloatDocValuesField(FLOAT_FIELD, 3.0f)
                    asList(
                );
    }
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                    )
                iw.addDocument(
                iw.addDocument(
                    asList(
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
        BucketOrder order = mock(BucketOrder.class);
            MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("c|192.168.0.2"));
                asList(
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)
            ),
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)
            }
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
import org.apache.lucene.document.StringField;
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("b"), equalTo(1L), equalTo(2.0)));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(false)));
                iw.addDocument(
                        new StringField(KEYWORD_FIELD, "a", Field.Store.NO),
            put(DATE_FIELD, dateFieldType(DATE_FIELD));
                MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("a"), equalTo("192.168.0.0")));
        MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("b|192.168.0.1"));
        });
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
                    .build(),
                ).setUserValueTypeHint(ValueType.LONG).build()
        );
            asList(
import org.opensearch.index.IndexService;
    private static final String BOOL_FIELD = "bool";
import org.apache.lucene.document.FloatDocValuesField;
            cardinality,
        return List.of(HllFieldMapper.CONTENT_TYPE);
        });
            iw -> {
                    new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap(FIELD_NAME, FIELD_NAME))
        );
    public void testValueScripts() throws IOException {
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            h -> {
            b.order(BucketOrder.aggregation("max", false));
    protected ScriptService getMockScriptService() {
            name,
            b.subAggregation(new MaxAggregationBuilder("max").field(FLOAT_FIELD));
        return createTestAggregatorBuilder(asList(term(fieldName), term(fieldName)));
import org.opensearch.index.mapper.MappedFieldType;
            ),
                        new FloatDocValuesField(FLOAT_FIELD, 3.0f),
            put(FIELD_NAME, new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.INTEGER));
    @Override
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(2.0)));
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
                    asList(
            List.of(),
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
            asList(
        SearchContext context = new TestSearchContext(bigArrays, indexService);
                iw.addDocument(
            true,
            iw -> {
    };
    };
        DocValueFormat format = mock(DocValueFormat.class);
import static org.hamcrest.Matchers.empty;
            iw.addDocument(
            )
            ),
        Aggregator parent = mock(Aggregator.class);
        List<MultiTermsValuesSourceConfig> terms,
                    )
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("a"), equalTo(3L)));
import org.opensearch.search.lookup.LeafDocLookup;
        MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo("192.168.0.2")));
            }
        testAggregation(
    }
        when(indexService.cache()).thenReturn(cache);
                    new NumericDocValuesField(INT_FIELD, 3),
        MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
import static java.util.Collections.singletonList;
                );
                    new FloatDocValuesField(FLOAT_FIELD, 4.0f)
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f)
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b"))
        );
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("2022-03-23|a"));
            }
                );
                        new SortedNumericDocValuesField(LONG_FIELD, 2L),
    private static final Map<String, MappedFieldType> mappedFieldTypeMap = new HashMap<String, MappedFieldType>() {
                )
            null,
                        new DoubleDocValuesField(DOUBLE_FIELD, 1.0d)
 * compatible open source license.
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(1.0)));
        for (String term : terms) {
import org.apache.lucene.search.MatchAllDocsQuery;
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            )
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(BOOL_FIELD, 0)));
    private void ipAndKeywordTest(Consumer<MultiTermsAggregationBuilder> builderDecorator, Consumer<InternalMultiTerms> verify)
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
 *
import org.opensearch.common.CheckedConsumer;
                );
        AggregatorFactories factories = AggregatorFactories.EMPTY;
            termConfigs.add(term(term));
            );
import static java.util.Arrays.asList;
                iw.addDocument(
        }, h -> {
                        new NumericDocValuesField(INT_FIELD, 2),
                );
    public void testMixNumberAndKeyword() throws IOException {
import org.opensearch.search.internal.SearchContext;
            );
    public void testNull() throws IOException {
            asList(
                    )
            MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("a|true"));
                    asList(
                    new NumericDocValuesField(INT_FIELD, 2),
import org.opensearch.script.ScriptType;
            MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
    private static final String KEYWORD_FIELD = "keyword";
        final MockScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, emptyMap());
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
                        new NumericDocValuesField(INT_FIELD, 2),
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-21")),
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            );
    }
                iw.addDocument(
                )
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(INT_FIELD, 2)));
                asList(
        ipAndKeywordTest(multiTermsAggregationBuilder -> {
            showTermDocCountError,
    }
            );
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(INT_FIELD, 2)
    ) throws IOException {
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(2L));
        when(indexService.getShardOrNull(0)).thenReturn(indexShard);
            iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
                        new FloatDocValuesField(FLOAT_FIELD, 3.0f),
            IllegalArgumentException.class,
import org.opensearch.search.aggregations.InternalAggregation;
                new MultiTermsValuesSourceConfig.Builder().setFieldName(INT_FIELD).setMissing(1).build(),
            iw -> {
                )
            NONE_DECORATOR,
import static org.hamcrest.Matchers.instanceOf;
            },
                final String fieldName = (String) vars.get(FIELD_NAME);
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(FIELD_NAME, 3))
            iw -> {
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("b"), equalTo(1L)));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
            );
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new FloatDocValuesField(FLOAT_FIELD, 2.0f)));
            );
                    new FloatDocValuesField(FLOAT_FIELD, 3.0f)
                        new DoubleDocValuesField(DOUBLE_FIELD, 3.0d)
        });
                ).build()
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
        }, iw -> {
                MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("2022-03-22|a"));
import org.opensearch.script.MockScriptEngine;
                iw.addDocument(
    private static final Consumer<MultiTermsAggregationBuilder> NONE_DECORATOR = null;
    public void testDates() throws IOException {
            MatcherAssert.assertThat(h.getBuckets().get(3).getKey(), contains(equalTo("b"), equalTo(1L)));
                MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("2022/03/21|c"));
            null,
        );
            List.of(),
            }
                MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
    @Override
            MatcherAssert.assertThat(h.getBuckets(), hasSize(7));
                iw.addDocument(
    public void testGeoPointField() {
    }
            }
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
                    asList(
        MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            },
import org.opensearch.index.shard.IndexShard;
    }
                    asList(
            DateFieldMapper.Resolution.MILLISECONDS,
            multiTermsAggregationBuilder.order(BucketOrder.compound(BucketOrder.count(true)));
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), NONE_DECORATOR, iw -> {
            NONE_DECORATOR,
            iw -> {
                iw.addDocument(
            MatcherAssert.assertThat(((InternalMax) (h.getBuckets().get(2).getAggregations().get("max"))).value(), closeTo(3.0f, 0.01));
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c"))
        });
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(field).build();
            put(FLOAT_FIELD, new NumberFieldMapper.NumberFieldType(FLOAT_FIELD, NumberFieldMapper.NumberType.FLOAT));
        {
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo("192.168.0.1")));
        return factory;
            iw.addDocument(
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), b -> {
            );
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));
        when(cache.bitsetFilterCache()).thenReturn(null);
            iw.addDocument(
            MatcherAssert.assertThat(h.getBuckets().get(3).getKey(), contains(equalTo("b"), equalTo(true)));
import static java.util.stream.Collectors.toList;
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                )
    private static final Consumer<InternalMultiTerms> IP_AND_KEYWORD_DESC_ORDER_VERIFY = h -> {
import java.util.function.Function;
                iw.addDocument(
            fieldConfigs(asList(INT_FIELD, LONG_FIELD, FLOAT_FIELD, DOUBLE_FIELD)),
            MatcherAssert.assertThat(h.getBuckets().get(4).getDocCount(), equalTo(1L));
                );
        MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo("192.168.0.0")));
    private static final String UNRELATED_KEYWORD_FIELD = "unrelated";
            h -> {
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
import org.opensearch.search.aggregations.support.ValuesSourceType;
import org.opensearch.search.DocValueFormat;
                iw.addDocument(
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 2)));
import org.apache.lucene.document.NumericDocValuesField;
            asList(term(KEYWORD_FIELD), new MultiTermsValuesSourceConfig.Builder().setFieldName(DOUBLE_FIELD).setFormat("00.00").build()),
            );
                );
import org.opensearch.search.aggregations.AggregationBuilder;
import static org.hamcrest.Matchers.equalTo;
            vars -> ((Number) vars.get("_value")).doubleValue() + 1,
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        IndexShard indexShard = mock(IndexShard.class);
        IndexCache cache = mock(IndexCache.class);
    }
            new MatchAllDocsQuery(),
                iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                );
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
        MatcherAssert.assertThat(mt.getMetadata().keySet(), contains(k1));
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
            collectMode,
            MatcherAssert.assertThat(h.getBuckets().get(4).getKey(), contains(equalTo("b"), equalTo(2L)));
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
                        new StringField(KEYWORD_FIELD, "b", Field.Store.NO),
                )
import static org.hamcrest.Matchers.hasSize;
    }
            }
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
        );
            null,
                MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("b|02.00"));
                return lookup.get(fieldName).stream().map(value -> ((Number) value).longValue() + 1).collect(toList());
        metadata.put(k1, v1);
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new DoubleDocValuesField(DOUBLE_FIELD, 1.0d))
                    )
        testAggregation(
                MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("2022/03/22|a"));
                CoreValuesSourceType.IP,
            h -> {
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo("2")));
                iw.addDocument(
        }, IP_AND_KEYWORD_DESC_ORDER_VERIFY);
        if (randomBoolean()) {
    }
                iw.addDocument(
import java.util.function.Consumer;
        ipAndKeywordTest(NONE_DECORATOR, IP_AND_KEYWORD_DESC_ORDER_VERIFY);
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            multiTermsAggregationBuilder.minDocCount(0);
    }
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-22")),
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)
import org.apache.lucene.document.SortedSetDocValuesField;
                )
            },
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(BOOL_FIELD, 1)));
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), NONE_DECORATOR, iw -> {
import org.apache.lucene.document.SortedDocValuesField;
            MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
                );
                )
        }, h -> {
                iw.addDocument(
        MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("a|192.168.0.0"));
                new MultiTermsValuesSourceConfig.Builder().setScript(
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))
    private static final String GEO_POINT_FIELD = "geopoint";
        MatcherAssert.assertThat(mt.getBuckets(), empty());
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
    private MultiTermsAggregationBuilder createTestAggregatorBuilder(List<MultiTermsValuesSourceConfig> termsConfig) {
            put(UNRELATED_KEYWORD_FIELD, new KeywordFieldMapper.KeywordFieldType(UNRELATED_KEYWORD_FIELD));
    @Override
            h -> {
        }
    public void testMixNumberAndKeywordWithFilter() throws IOException {
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(4.0)));
                iw.addDocument(
    public void testIpAndKeywordDefaultDescOrder() throws IOException {
        return Collections.unmodifiableList(
            iw -> {
                    )
            iw.addDocument(
                    new SortedNumericDocValuesField(INT_FIELD, 3)
                iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo(2L), equalTo(2L), equalTo(3.0), equalTo(3.0)));
            MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("b|false"));
        MultiTermsAggregator mAgg = new MultiTermsAggregator(
                iw.addDocument(
import org.opensearch.script.ScriptModule;
            h -> {
        testAggregation(
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(INT_FIELD, 2)));
                    )
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
                    new NumericDocValuesField(INT_FIELD, 1),
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
            VALUE_SCRIPT_NAME,
import org.opensearch.search.aggregations.BucketOrder;
        testAggregation(
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(FIELD_NAME, 3))
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
                    new NumericDocValuesField(INT_FIELD, 1),
            MatcherAssert.assertThat(h.getName(), equalTo(AGG_NAME));
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("d")), new NumericDocValuesField(INT_FIELD, 3)));
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
                        new StringField(KEYWORD_FIELD, "a", Field.Store.NO),
            },
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))
import java.util.HashMap;
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-21")),
                asList(
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
import org.opensearch.common.util.BigArrays;
        String k1 = UUID.randomUUID().toString();
 * The OpenSearch Contributors require contributions made to
            }
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
                )
            NONE_DECORATOR,
            h -> {
        Query query,
        return new DateFieldMapper.DateFieldType(
        Aggregator.SubAggCollectionMode collectMode = Aggregator.SubAggCollectionMode.BREADTH_FIRST;
                        new NumericDocValuesField(INT_FIELD, 1),
            h -> {
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));
        factory.terms(termsConfig);
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
    public void testIncludeExclude() throws IOException {
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("b"), equalTo(false)));
import org.opensearch.index.mapper.KeywordFieldMapper;
    private void testAggregation(
                    new SortedNumericDocValuesField(INT_FIELD, 1)
                )
            false,
                    asList(
    @Override
import org.opensearch.script.Script;
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, BOOL_FIELD)), NONE_DECORATOR, iw -> {
            iw.addDocument(
import org.opensearch.index.mapper.NumberFieldMapper;
            ),
            ),
import org.opensearch.search.aggregations.CardinalityUpperBound;
    }
                iw.addDocument(
            null,
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(FIELD_NAME, 1))
                    new NumericDocValuesField(INT_FIELD, 1),
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            iw.addDocument(asList(new NumericDocValuesField(INT_FIELD, 1), new FloatDocValuesField(FLOAT_FIELD, 2.0f)));
            null,
            put(DOUBLE_FIELD, new NumberFieldMapper.NumberFieldType(DOUBLE_FIELD, NumberFieldMapper.NumberType.DOUBLE));
                CoreValuesSourceType.BYTES,
    }
        testCase(builder, query, indexBuilder, verify, mappedFieldTypeMap.values().toArray(new MappedFieldType[] {}));
import org.apache.lucene.util.BytesRef;
            },
import org.opensearch.script.ScriptService;
            h -> {
        }
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(2L)));
                new MultiTermsValuesSourceConfig.Builder().setFieldName(FLOAT_FIELD).setMissing(2.0f).build()
                );
                asList(
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(2L));
import org.opensearch.index.mapper.GeoPointFieldMapper;
        MatcherAssert.assertThat(mt.getMetadata().get(k1), equalTo(v1));
import static org.mockito.Mockito.when;
    public void testOrderByMetrics() throws IOException {
                );
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("b"), equalTo(1L), equalTo(2.0)));
        }, h -> {
            multiTermsAggregationBuilder.size(10);
                );
                        new NumericDocValuesField(INT_FIELD, 2),
                    new NumericDocValuesField(INT_FIELD, 1),
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(1.0)));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new DoubleDocValuesField(DOUBLE_FIELD, 2.0d))
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
    protected List<String> unsupportedMappedFieldTypes() {
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
import org.opensearch.script.ScriptEngine;
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(INT_FIELD, 1)));
                    new NumericDocValuesField(INT_FIELD, 3),
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")), new NumericDocValuesField(FIELD_NAME, 3))
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                new MultiTermsValuesSourceConfig.Builder().setScript(
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
import java.util.List;
    }
                iw.addDocument(
                iw.addDocument(
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
        );
                asList(
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo(2L), equalTo(2L), equalTo(2.0), equalTo(2.0)));
            }
                new MultiTermsValuesSourceConfig.Builder().setFieldName(FIELD_NAME)
    }
import org.apache.lucene.search.Query;
            decorator.accept(builder);
                        new SortedNumericDocValuesField(LONG_FIELD, 2L),
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(1.0)));
            );
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo(1L), equalTo(1L), equalTo(1.0), equalTo(1.0)));
        Map<String, Object> metadata = new HashMap<>();
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(FIELD_NAME, 1))
    public void testMinDocCount() throws IOException {
        }
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
            put(IP_FIELD, new IpFieldMapper.IpFieldType(IP_FIELD));
            fieldConfigs(asList(KEYWORD_FIELD, FLOAT_FIELD)),
                MatcherAssert.assertThat(h.getBuckets().get(3).getKeyAsString(), equalTo("2022-03-23|b"));
                );
            );
        return termConfigs;
                )
        ipAndKeywordTest(multiTermsAggregationBuilder -> {
                );
            new MatchAllDocsQuery(),
                iw.addDocument(
import org.apache.lucene.document.Field;
                        new NumericDocValuesField(INT_FIELD, 1),
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))
                iw.addDocument(
            },
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f),
                )
                    )
            put(GEO_POINT_FIELD, new GeoPointFieldMapper.GeoPointFieldType(GEO_POINT_FIELD));
        }, h -> {
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo("3")));
        when(indexService.newQueryShardContext(0, null, () -> 0L, null)).thenReturn(queryShardContext);
        }, h -> {
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(INT_FIELD, 1)));
                    )
                    asList(
                new MatchAllDocsQuery(),
                asList(
                iw.addDocument(
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.0"))))
            MatcherAssert.assertThat(h.getBuckets(), hasSize(0));
        });
    }
                        new SortedNumericDocValuesField(LONG_FIELD, 1L),
                iw.addDocument(
    }
                asList(
            put(LONG_FIELD, new NumberFieldMapper.NumberFieldType(LONG_FIELD, NumberFieldMapper.NumberType.LONG));
            iw -> {
        InternalAggregation emptyAgg = mAgg.buildEmptyAggregation();
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
import org.opensearch.test.TestSearchContext;
                        new NumericDocValuesField(INT_FIELD, 1),
import org.opensearch.search.aggregations.AggregatorTestCase;
                asList(
        );
            MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
import org.opensearch.index.cache.IndexCache;
                );
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), NONE_DECORATOR, iw -> {}, h -> {
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
        );
                    asList(
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
            iw.addDocument(
            new MatchAllDocsQuery(),
                    .setIncludeExclude(new IncludeExclude("a", null))
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
        CardinalityUpperBound cardinality = CardinalityUpperBound.ONE;
            iw.addDocument(
            new MatchAllDocsQuery(),
                    new SortedNumericDocValuesField(INT_FIELD, 2)
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(1L));
                asList(
                MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(2L)));
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(3L)));
                    new NumericDocValuesField(INT_FIELD, 1),
            AGG_NAME,
    }
        }
import org.opensearch.search.aggregations.Aggregator;
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                );
    public void testNumberFieldFormat() throws IOException {
                iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
    }
            }
            new MatchAllDocsQuery(),
                asList(
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("b"), equalTo(3.0)));
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
        );
                iw.addDocument(singletonList(new SortedDocValuesField(UNRELATED_KEYWORD_FIELD, new BytesRef("unrelated"))));
package org.opensearch.search.aggregations.bucket.terms;
                MatcherAssert.assertThat(h.getBuckets().get(3).getKeyAsString(), equalTo("2022/03/23|b"));
                        new DoubleDocValuesField(DOUBLE_FIELD, 3.0d)
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
import org.apache.lucene.index.Term;
import static java.util.Collections.emptyMap;
            factory.size(randomIntBetween(10, Integer.MAX_VALUE));
        throws IOException {
            );
        MultiTermsAggregationBuilder factory = new MultiTermsAggregationBuilder(AGG_NAME);
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD)), b -> b.minDocCount(2), iw -> {
import org.apache.lucene.tests.index.RandomIndexWriter;
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, IP_FIELD)), builderDecorator, iw -> {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        assertThrows(
    }
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
    }
    public void testIpAndKeywordWithBucketCountSameAsSize() throws IOException {
                )
        CheckedConsumer<RandomIndexWriter, IOException> indexBuilder,
    }
                    )
                asList(
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(1L));
                );
    private static DateFieldMapper.DateFieldType dateFieldType(String name) {
        if (decorator != NONE_DECORATOR) {
            MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(2L), equalTo(2.0)));
                    asList(
                )
                MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("a|01.00"));
                )
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).build(),
            iw.addDocument(
                    )
            FIELD_SCRIPT_NAME,
            Collections.emptyMap()
            iw.addDocument(
                );
/*
                    )
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
import org.opensearch.search.aggregations.support.ValueType;
        testAggregation(
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f)
import org.hamcrest.MatcherAssert;
            iw -> {
    private static final String INT_FIELD = "int";
            }
                    asList(
            iw.addDocument(
                );
                );
                    new FloatDocValuesField(FLOAT_FIELD, 1.0f)
import org.opensearch.search.aggregations.AggregatorFactories;
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            order,
import java.util.ArrayList;
    private static final String FIELD_NAME = "field";
                );
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.1"))))
        ipAndKeywordTest(multiTermsAggregationBuilder -> {
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                    new SortedNumericDocValuesField(INT_FIELD, 1),
    }
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
import org.opensearch.common.util.MockPageCacheRecycler;
            put(INT_FIELD, new NumberFieldMapper.NumberFieldType(INT_FIELD, NumberFieldMapper.NumberType.INTEGER));
                MatcherAssert.assertThat(h.getBuckets().get(3).getKey(), contains(equalTo("c"), equalTo(2L), equalTo(2.0)));
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("c")),
            null,
                asList(
            asList(
                iw.addDocument(
            MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                );
        final Map<String, Function<Map<String, Object>, Object>> scripts = Map.of(
                    asList(
import static org.hamcrest.Matchers.closeTo;
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-22")),
                    new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap(FIELD_NAME, FIELD_NAME))
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f)
import static java.util.Collections.singletonMap;
            iw.addDocument(
                );
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new NumericDocValuesField(FIELD_NAME, 2))
        InternalMultiTerms mt = (InternalMultiTerms) emptyAgg;
    }
        BigArrays bigArrays = new BigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService(), "");
            new MatchAllDocsQuery(),
    public void testMultiValuesField() throws IOException {
            bucketCountThresholds,
import org.opensearch.common.time.DateFormatter;
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                CoreValuesSourceType.BOOLEAN
                );
            () -> testAggregation(
            iw -> {
            asList(
            multiTermsAggregationBuilder.minDocCount(0);
            iw.addDocument(
    public void testMissing() throws IOException {
        MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                asList(
                    )
            },
                )
    }
                    asList(
    public void testNumbers() throws IOException {
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
        });
        );
            new MatchAllDocsQuery(),
        testAggregation(
            null
            multiTermsAggregationBuilder.order(BucketOrder.compound(BucketOrder.count(false)));
                CoreValuesSourceType.NUMERIC,
                iw.addDocument(
                asList(
            MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("a|false"));
            iw.addDocument(
    private static final String DOUBLE_FIELD = "double";
        );
                    new NumericDocValuesField(INT_FIELD, 1),
                    .setScript(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap()))
import org.opensearch.common.settings.Settings;
                    )
        IndexService indexService = mock(IndexService.class);
        });
    private static final String IP_FIELD = "ip";
                    )
            },
            factories,
        }, h -> {
                iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(INT_FIELD, 1)));
                    new NumericDocValuesField(INT_FIELD, 2),
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("c"), equalTo("192.168.0.2")));
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
                term(KEYWORD_FIELD)
        testAggregation(
                );
                MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
            MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("b|192.168.0.1"));
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f),
            MatcherAssert.assertThat(h.getBuckets().get(5).getKey(), contains(equalTo("c"), equalTo(1L)));
            MatcherAssert.assertThat(h.getBuckets(), hasSize(1));
            iw.addDocument(
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
import java.util.UUID;
                iw.addDocument(
                    .build()
        });
                    )
            List.of(format),
        Consumer<MultiTermsAggregationBuilder> decorator,
            multiTermsAggregationBuilder.size(3);
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")),
        }
                    asList(
        }, h -> {
                MatcherAssert.assertThat(h.getBuckets(), hasSize(1));
            new MatchAllDocsQuery(),
        }, verify);
    public void testScripts() throws IOException {
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
            );
    }
                iw.addDocument(
                        // missing KEYWORD_FIELD
            MatcherAssert.assertThat(((InternalMax) (h.getBuckets().get(0).getAggregations().get("max"))).value(), closeTo(4.0f, 0.01));
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
        TermsAggregator.BucketCountThresholds bucketCountThresholds = mock(TermsAggregator.BucketCountThresholds.class);
        boolean showTermDocCountError = true;
            MatcherAssert.assertThat(h.getBuckets().get(5).getDocCount(), equalTo(1L));
                    asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b")), new DoubleDocValuesField(DOUBLE_FIELD, 2.0d))
    private static final String VALUE_SCRIPT_NAME = "value_script";
import org.apache.lucene.document.DoubleDocValuesField;
        );
                )
        MatcherAssert.assertThat(emptyAgg, instanceOf(InternalMultiTerms.class));
                MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("2022-03-21|c"));
            asList(
            },
                    new SortedNumericDocValuesField(INT_FIELD, 3)
            metadata,
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L), equalTo(1.0)));
                    )
                );
    private List<MultiTermsValuesSourceConfig> fieldConfigs(List<String> terms) {
import java.io.IOException;
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
            DateFormatter.forPattern("date"),
                );
                );
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
        String v1 = UUID.randomUUID().toString();
                MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                asList(
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
        MultiTermsAggregationBuilder builder = createTestAggregatorBuilder(terms);
            MatcherAssert.assertThat(h.getBuckets(), hasSize(1));
            iw.addDocument(
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))
            MatcherAssert.assertThat(h.getBuckets().get(6).getKey(), contains(equalTo("c"), equalTo(3L)));
                );
        MultiTermsAggregator.InternalValuesSource internalValuesSources = mock(MultiTermsAggregator.InternalValuesSource.class);
            new TermQuery(new Term(KEYWORD_FIELD, "a")),
public class MultiTermsAggregatorTests extends AggregatorTestCase {
                ));
                iw.addDocument(
                );
    }
        if (randomBoolean()) {
                )
            MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("a"), equalTo(3L)));
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
                asList(term(KEYWORD_FIELD), term(GEO_POINT_FIELD)),
import org.opensearch.index.mapper.DateFieldMapper;
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(2L));
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD).setMissing("a").build(),
            MatcherAssert.assertThat(h.getBuckets().get(6).getDocCount(), equalTo(1L));
                )
                iw.addDocument(
            );
                MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
            MatcherAssert.assertThat(h.getBuckets().get(0).getDocCount(), equalTo(2L));
                        new DoubleDocValuesField(DOUBLE_FIELD, 1.0d)
                asList(
                MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(2.0)));
                    asList(
                MatcherAssert.assertThat(h.getBuckets().get(0).getKeyAsString(), equalTo("2022/03/23|a"));
        );
                MatcherAssert.assertThat(h.getBuckets(), hasSize(4));
                );
    public void testMixKeywordAndBoolean() throws IOException {
                asList(
                );
                asList(
import org.opensearch.index.mapper.IpFieldMapper;
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
            h -> {
                    asList(
                    new NumericDocValuesField(INT_FIELD, 2),
import org.apache.lucene.document.InetAddressPoint;
            h -> {
                iw.addDocument(
                    new FloatDocValuesField(FLOAT_FIELD, 2.0f)
                    new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
            multiTermsAggregationBuilder.order(BucketOrder.compound(BucketOrder.count(false)));
                    )
                );
import static org.hamcrest.Matchers.contains;
                iw.addDocument(
                MatcherAssert.assertThat(h.getBuckets().get(1).getDocCount(), equalTo(1L));
            );
            true,
    }
import java.util.Collections;
    private MultiTermsValuesSourceConfig term(String field) {
        );
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
        MatcherAssert.assertThat(emptyAgg.getName(), equalTo(AGG_NAME));
            put(KEYWORD_FIELD, new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD));
        testAggregation(new MatchAllDocsQuery(), fieldConfigs(asList(KEYWORD_FIELD, INT_FIELD, FLOAT_FIELD)), NONE_DECORATOR, iw -> {
                        new FloatDocValuesField(FLOAT_FIELD, 2.0f)
 * this file be licensed under the Apache-2.0 license or a
            asList(
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(2L));
                        new SortedNumericDocValuesField(LONG_FIELD, 1L),
                    asList(
                    new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
                MatcherAssert.assertThat(h.getBuckets().get(1).getKeyAsString(), equalTo("a|02.00"));
                    asList(
                MatcherAssert.assertThat(h.getBuckets(), hasSize(3));
                        new SortedNumericDocValuesField(DATE_FIELD, dateFieldType(DATE_FIELD).parse("2022-03-23")),
        }, IP_AND_KEYWORD_DESC_ORDER_VERIFY);
 */
        MatcherAssert.assertThat(h.getBuckets().get(2).getKeyAsString(), equalTo("c|192.168.0.2"));
import org.opensearch.index.query.QueryShardContext;
            );
                // missing FLOAT_FIELD
                );
            MatcherAssert.assertThat(h.getBuckets().get(2).getDocCount(), equalTo(1L));
                    )
                new MultiTermsValuesSourceConfig.Builder().setFieldName(DATE_FIELD).setFormat("yyyy/MM/dd").build(),
    private static final String FLOAT_FIELD = "float";
    public void testIpAndKeywordWithBucketCountGreaterThanSize() throws IOException {
                    asList(
    public void testScriptsWithoutValueTypeHint() throws IOException {
        List<MultiTermsValuesSourceConfig> termConfigs = new ArrayList<>();
import org.opensearch.common.network.InetAddresses;
            List.of(internalValuesSources),
                MatcherAssert.assertThat(h.getBuckets().get(2).getKey(), contains(equalTo("c"), equalTo(4L)));
                    )
                    new SortedNumericDocValuesField(INT_FIELD, 1),
    public void testDatesFieldFormat() throws IOException {
            );
                    new SortedNumericDocValuesField(INT_FIELD, 1),
    }
            iw.addDocument(
import org.apache.lucene.search.TermQuery;
            iw -> {
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a"))
        MatcherAssert.assertThat(h.getBuckets().get(1).getKey(), contains(equalTo("b"), equalTo("192.168.0.1")));
                    asList(
                asList(
                    asList(
            MatcherAssert.assertThat(((InternalMax) (h.getBuckets().get(1).getAggregations().get("max"))).value(), closeTo(3.0f, 0.01));
                term(INT_FIELD)
                        // missing INT_FIELD
                );
            );
                MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
            parent,
            asList(new MultiTermsValuesSourceConfig.Builder().setFieldName(DATE_FIELD).build(), term(KEYWORD_FIELD)),
            MatcherAssert.assertThat(h.getBuckets().get(0).getKey(), contains(equalTo("a"), equalTo(1L)));
            multiTermsAggregationBuilder.minDocCount(0);
    private static final String DATE_FIELD = "date";
                iw.addDocument(
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")),
import org.opensearch.index.mapper.HllFieldMapper;
        if (randomBoolean()) {
                new MultiTermsValuesSourceConfig.Builder().setFieldName(KEYWORD_FIELD)
                    new SortedDocValuesField(IP_FIELD, new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.0.0"))))
                );
    public void testEmpty() throws IOException {
    }
import java.util.Map;
            context,
                        new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("b"))
                MatcherAssert.assertThat(h.getBuckets().get(3).getDocCount(), equalTo(1L));
                );
            }
                iw.addDocument(
                    )
import static org.mockito.Mockito.mock;
        testAggregation(
            iw.addDocument(asList(new SortedDocValuesField(KEYWORD_FIELD, new BytesRef("a")), new NumericDocValuesField(BOOL_FIELD, 1)));
                        new FloatDocValuesField(FLOAT_FIELD, 1.0f),
            ),
                    )
                iw -> {},
