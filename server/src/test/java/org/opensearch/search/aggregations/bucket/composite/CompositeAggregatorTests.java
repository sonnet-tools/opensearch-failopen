            )
                .missingOrder(MissingOrder.FIRST);
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            assertEquals("{keyword=bar}", result.getBuckets().get(0).getKeyAsString());
                        new TermsValuesSourceBuilder("keyword").field("keyword")
                )
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
        dataset.addAll(
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
                createDocument("keyword", "c", "long", Arrays.asList(100L, 0L, 10L)),
                createDocument("keyword", "e", "long", 100L, "foo", "bar"),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
        dataset.addAll(
            }
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
                assertEquals(1, subTerms.getBuckets().size());
                assertEquals(1, result.getBuckets().size());
         */
        );
                assertEquals("{keyword=d, unmapped=null}", result.getBuckets().get(2).getKeyAsString());
                )
        String field,
                )
            )
            assertEquals("{keyword=bar}", result.afterKey().toString());
                new TopHitsAggregationBuilder("top_hits").storedField("_none_")
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                            .subAggregation(new MaxAggregationBuilder("max").field("long"))
    public void testWithKeywordAndDateHistogram() throws IOException {
                Arrays.asList(
            }
        );
                assertEquals("{keyword=c, price=100.0}", result.getBuckets().get(3).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                createDocument("keyword", Arrays.asList("d", "d"), "long", Arrays.asList(10L, 100L, 1000L)),
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                        .missingBucket(true)
                createDocument("keyword", "c")
import org.apache.lucene.index.Term;
                assertEquals(6L, result.getBuckets().get(2).getDocCount());
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                Collections.singletonMap("keyword", null)
                        .interval(10)
import java.util.Set;
                assertEquals("{keyword=c, date_histo=1508457600000}", result.getBuckets().get(3).getKeyAsString());
                )
    }
    }
                    .calendarInterval(DateHistogramInterval.days(1));
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());
                            .calendarInterval(DateHistogramInterval.days(1)),
            ),
            dataset,
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                assertEquals("{price=null}", result.afterKey().toString());
            (result) -> assertEquals(0, result.getBuckets().size())
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                new CompositeAggregationBuilder(
         * why we support both things.
        final String mappedFieldName = "price";
 * KIND, either express or implied.  See the License for the
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
        );
            (result) -> {
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
/*
            ),
            (result) -> {
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
import org.apache.lucene.search.MatchAllDocsQuery;
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            Arrays.asList(
                Arrays.asList(
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
                    assertEquals("{date=1591142400000, keyword=90640}", result.getBuckets().get(1).getKeyAsString());
         */
        dataset.addAll(
        );
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true).missingOrder(MissingOrder.LAST)
                TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
            () -> {
                    .calendarInterval(DateHistogramInterval.days(1));
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            () -> new CompositeAggregationBuilder(
 *
            builders.add(new TermsValuesSourceBuilder("duplicate1").field("bar"));
                new MatchAllDocsQuery(),
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                assertEquals("{date=1474329600000, keyword=z}", result.getBuckets().get(2).getKeyAsString());
                        .missingBucket(true)
        }, (result) -> {
                createDocument("keyword", "c"),
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
                "filter_mcmilterface",
        testSearchCase(
            )
            ),
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
                        .calendarInterval(DateHistogramInterval.days(1)),
                Collections.singletonMap("keyword", "c")
                Arrays.asList(
            Arrays.asList(new MatchAllDocsQuery()),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
        testSearchCase(
            dataset,
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            Arrays.asList(
import org.opensearch.search.sort.SortOrder;
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
        dataset.addAll(
                new FieldExistsQuery("date"),
            dataset,
                "name",
                createDocument("keyword", "a"),
                assertEquals("{price=100.0, unmapped=null}", result.afterKey().toString());
    public void testMultiValuedWithKeywordAndLong() throws Exception {
                createDocument("double", 0.4d, "keyword", Arrays.asList("a", "c")),
        }, (result) -> {
            Arrays.asList(
            ),
                assertEquals(78L, (long) max.getValue());
            assertEquals(1L, result.getBuckets().get(4).getDocCount());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                assertEquals("y", subTerms.getBuckets().get(0).getKeyAsString());
                    .calendarInterval(DateHistogramInterval.days(1));
                "name",
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                createDocument("long", 4L)
                assertEquals(2, result.getBuckets().size());
                createDocument("date", asLong("2017-10-20T06:09:24")),
                assertEquals("{keyword=c, long=0, double=0.4}", result.getBuckets().get(6).getKeyAsString());
                createDocument("keyword", "d"),
            () -> {
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=z, price=50.0}", result.afterKey().toString());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                createDocument("date", asLong("2016-09-20T11:34:00")),
                return new CompositeAggregationBuilder("name", Collections.singletonList(source)).subAggregation(
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
import static org.hamcrest.Matchers.instanceOf;
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
                LongPoint.newRangeQuery("date", asLong("2016-09-20T11:34:00"), asLong("2017-10-20T06:09:24"))
    }
        testSearchCase(
                assertEquals("{histo=0.4, keyword=c}", result.getBuckets().get(2).getKeyAsString());
        );
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=g, date_histo=1508371200000}", result.getBuckets().get(2).getKeyAsString());
            return filterAggregatorBuilder;
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
                    createAfterKey("date", 1474329600000L) // 2016-09-20T00:00:00
                        .interval(10)
            }
        }, (result) -> {
                createDocument("keyword", "a", "long", 0L),
                assertEquals(3L, result.getBuckets().get(0).getDocCount());
                        .order(SortOrder.DESC)
            filterAggregatorBuilder.subAggregation(
                createDocument("keyword", "c", "terms", "d", "long", 78L),
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped").calendarInterval(DateHistogramInterval.days(1))
                createDocument("price", 105L, "keyword", Arrays.asList("a", "d")),
                }
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
                createDocument("keyword", "c"),
            assertEquals(2, result.getBuckets().size());
        for (Aggregator.SubAggCollectionMode mode : Aggregator.SubAggCollectionMode.values()) {
                assertEquals("{date=1508457600000, keyword=a}", result.getBuckets().get(4).getKeyAsString());
                    Arrays.asList(
            assertEquals("{keyword=a}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                            .field("terms")
                .missingBucket(true)
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
    public void testWithHistogramAndKeyword() throws IOException {
                assertEquals("{keyword=c, long=10}", result.getBuckets().get(5).getKeyAsString());
        testSearchCase(
        }
                createDocument("keyword", "c", "long", 100L),
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
        }, (result) -> {
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("terms").field("keyword");
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
    public void testRandomStrings() throws IOException {
                assertEquals(4, result.getBuckets().size());
            ).aggregateAfter(createAfterKey("keyword", "c", "long", null)),
                Arrays.asList(
                        "compo",
            ),
                assertEquals("{keyword=z, long=0}", result.afterKey().toString());
                    );
    public void testWithKeywordAndTopHits() throws Exception {
                )
            )
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=c, long=100, double=0.4}", result.afterKey().toString());
            dataset,
                    assertThat(bucket.getDocCount(), equalTo(expectedDocCounts.get(term).get()));
                    V term = transformKey.apply(bucket.getKey().get(field));
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                "name",
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(1).getKeyAsString());
            assertEquals(4, result.getBuckets().size());
                assertEquals("{keyword=d, long=100}", result.getBuckets().get(2).getKeyAsString());
import java.util.HashMap;
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                )
            Arrays.asList(
            ),
                createDocument("keyword", "foo"),
                createDocument("long", 100L)
                createDocument("keyword", "b", "long", 10L, "foo", "bar"),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals("{date=1508371200000, unmapped=null}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{keyword=b, long=100}", result.getBuckets().get(2).getKeyAsString());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
            ),
                assertEquals("{price=70.0}", result.getBuckets().get(0).getKeyAsString());
            () -> new CompositeAggregationBuilder(
            assertEquals("{keyword=a}", result.getBuckets().get(2).getKeyAsString());
                createDocument("date", asLong("2016-09-20T09:00:34"), "keyword", Arrays.asList("b", "c")),
        );
            dataset,
            dataset,
            () -> new CompositeAggregationBuilder(
                createDocument("ip", InetAddress.getByName("::1")),
        testSearchCase(
        }
            )
            },
                createDocument("keyword", Arrays.asList("a", "z"), "long", Arrays.asList(0L, 100L)),
        }, (result) -> {
        );
        dataset.addAll(
                assertEquals("{keyword=g, price=20.0}", result.getBuckets().get(2).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
        Set<T> valuesSet = new HashSet<>(); // how many different values
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            assertEquals("{keyword=a}", result.afterKey().toString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
    public void testWithTermsSubAggExecutionMode() throws Exception {
                createDocument("keyword", Arrays.asList("a", "z"), "long", Arrays.asList(0L, 100L)),
            ).aggregateAfter(createAfterKey("price", null)),
                assertEquals(2, result.getBuckets().size());
                Collections.singletonList(createDocument()),
            }
                assertEquals(3, result.getBuckets().size());
                Arrays.asList(
                    assertEquals("{date=1591142400000, keyword=31640}", result.afterKey().toString());
                assertEquals("{date=1508457600000}", result.afterKey().toString());
        dataset.addAll(
                Collections.singletonMap("keyword", "b")
        /*
                assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());
            assertEquals("{keyword=zoo}", result.getBuckets().get(3).getKeyAsString());
                assertEquals("{keyword=a, price=100.0}", result.getBuckets().get(0).getKeyAsString());
            () -> new CompositeAggregationBuilder(
            terms.add(randomSupplier.get());
            assertEquals("{keyword=b}", result.getBuckets().get(1).getKeyAsString());
    public void testNullSourceNonNullCollection() {
        });
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                createDocument("date", asLong("2016-09-20T09:00:34")),
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
        );
            )
                assertEquals("{keyword=d, unmapped=null}", result.afterKey().toString());
                )
            dataset,
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                        .missingBucket(true)
                            .order(order)
            dataset.add(Collections.singletonMap(field, new ArrayList<>(values)));
                        .collectMode(mode)
            assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
            });
            assertEquals("{keyword=d}", result.afterKey().toString());
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
            (result) -> {
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
                        .interval(10)
                )
                assertEquals(2, result.getBuckets().size());
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                "name",
            Arrays.asList(new MatchAllDocsQuery()),
            testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
            (result) -> assertEquals(0, result.getBuckets().size())
        );
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
 * this work for additional information regarding copyright
            }
                createDocument(mappedFieldName, 56),
    public void testWithKeywordAndMissingBucket() throws Exception {
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
            );
                assertEquals("{keyword=c, long=0, double=0.4}", result.getBuckets().get(2).getKeyAsString());
                    afterKey = Collections.singletonMap(field, seen.get(seen.size() - 1));
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals("{keyword=b, date_histo=1474329600000}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(2).getKeyAsString());
                        .interval(10)
        );
        }, (result) -> {
                assertEquals("{price=70.0}", result.getBuckets().get(3).getKeyAsString());
            ),
            dataset,
        testSearchCase(
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
            () -> new CompositeAggregationBuilder("name", Arrays.asList(new TermsValuesSourceBuilder("unmapped").field("unmapped"))),
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            assertEquals("{keyword=a}", result.afterKey().toString());
                );
                createDocument("ip", InetAddress.getByName("127.0.0.1")),
            assertEquals("{keyword=a}", result.afterKey().toString());
        );
                Arrays.asList(new TermsValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true))
                createDocument("keyword", "a", "long", 100L),
            FilterAggregationBuilder filterAggregatorBuilder = new FilterAggregationBuilder(
            assertEquals(5, result.getBuckets().size());
         */
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
    public void testUnmappedFieldWithHistogram() throws Exception {
                        .order(SortOrder.DESC)
                assertEquals("{date=1508472000000}", result.getBuckets().get(2).getKeyAsString());
                new MatchAllDocsQuery(),
                createDocument("keyword", "c", "long", Arrays.asList(100L, 0L, 10L), "double", 0.09d),
                createDocument("date", asLong("2017-10-20T06:09:24")),
        testSearchCase(
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(1).getKeyAsString());
                    assertEquals("{date=1591142400000, keyword=31640}", result.getBuckets().get(2).getKeyAsString());
                    new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING)
        List<Comparable<T>> seen = new ArrayList<>();
            (result) -> assertEquals(0, result.getBuckets().size())
            ).aggregateAfter(createAfterKey("keyword", "c", "long", null)),
            (result) -> {
        );
        dataset.addAll(
                InternalMax max = subTerms.getBuckets().get(0).getAggregations().get("max");
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                createDocument("price", 50, "long", 1L),
                true,
        );
            assertEquals("{keyword=c}", result.getBuckets().get(0).getKeyAsString());
                createDocument(mappedFieldName, asLong("2016-09-20T11:34:00")),
import java.time.ZoneId;
            ),
                createDocument("keyword", Arrays.asList("a", "b", "c"), "long", 100L, "double", 0.4d),
            (result) -> {
                createDocument("keyword", "a", "long", 100L, "foo", "bar"),
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST),
            Arrays.asList(
                    return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).subAggregation(
            Arrays.asList(
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=c, date_histo=1508457600000}", result.getBuckets().get(0).getKeyAsString());
            () -> new CompositeAggregationBuilder(
            for (int j = 0; j < numValues; j++) {
        );
        }, (ic) -> {});
                "name",
                StringTerms subTerms = result.getBuckets().get(0).getAggregations().get("terms");
                        .missingBucket(true)
        );
        testSearchCase(
        );
                assertEquals("{date=1508457600000, keyword=d}", result.afterKey().toString());
                "name",
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                () -> new CompositeAggregationBuilder(
            }
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("price")),
            }
        // sort descending, null bucket is first
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    assertEquals("{date=1591142400000, keyword=11640}", result.getBuckets().get(0).getKeyAsString());
                createDocument("keyword", "c", "long", 100L, "foo", "bar"),
    public void testDateHistogramSourceWithDocCountField() throws IOException {
        );
                assertEquals("{date=1508457600000}", result.afterKey().toString()); // 2017-10-20T00:00:00
                    new HistogramValuesSourceBuilder("price").field("price")
                        .missingBucket(true)
            topHits = result.getBuckets().get(2).getAggregations().get("top_hits");
        dataset.addAll(
        }
                createDocument("double", 0.8d, "keyword", Arrays.asList("b", "z")),
                createDocument("keyword", Arrays.asList("d", "d"), "long", Arrays.asList(10L, 100L, 1000L), "double", 1.0d),
            }
            );
                assertEquals("{keyword=a, long=100, double=0.09}", result.getBuckets().get(2).getKeyAsString());
            (result) -> {
        testSearchCase(
        // sort ascending, null bucket is first, same as default.
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
                "name",
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(4).getKeyAsString());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                        .missingOrder(MissingOrder.FIRST)
 * SPDX-License-Identifier: Apache-2.0
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
import java.util.ArrayList;
            ).aggregateAfter(createAfterKey("price", 60.0)),
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                "name",
        Map<Comparable<?>, AtomicLong> expectedDocCounts = new HashMap<>(); // how many docs for each value
            (result) -> {
                new FieldExistsQuery("date"),
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                createDocument("keyword", "c"),
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=z, long=100}", result.getBuckets().get(5).getKeyAsString());
                )
        );
                Arrays.asList(
            DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                            .collectMode(mode)
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            TopHits topHits = result.getBuckets().get(0).getAggregations().get("top_hits");
                Arrays.asList(
                assertEquals("{keyword=c, long=0}", result.getBuckets().get(3).getKeyAsString());
                assertEquals("{date=1508324400000}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(4, result.getBuckets().size());
            (result) -> {
                assertEquals("{price=50.0}", result.afterKey().toString());
                createDocument("date", asLong("2020-06-03T01:22:10"), "keyword", "90640"),
    public void testMultiValuedWithKeywordAndLongDesc() throws Exception {
                assertEquals(3, result.getBuckets().size());
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(5).getKeyAsString());
                assertEquals("{keyword=null, long=null}", result.afterKey().toString());
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(3).getKeyAsString());
    public void testMultiValuedWithKeyword() throws Exception {
        }, (result) -> {
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(1).getKeyAsString());
            )
            ).aggregateAfter(createAfterKey("keyword", "z", "long", 100L)),
                assertEquals(3, result.getBuckets().size());
        testSearchCase(
                max = subTerms.getBuckets().get(0).getAggregations().get("max");
                assertEquals("{keyword=g, price=20.0}", result.getBuckets().get(5).getKeyAsString());
                assertEquals("{date=1508457600000, keyword=d}", result.getBuckets().get(2).getKeyAsString());
            }
                assertEquals(1, result.getBuckets().size());
                new MatchAllDocsQuery(),
        }, (result) -> {
                assertEquals("{histo=0.9, keyword=d}", result.afterKey().toString());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(3).getKeyAsString());
                    new HistogramValuesSourceBuilder("histo").field("double").interval(0.1),
        testSearchCase(
                createDocument("date", asLong("2020-06-03T01:54:10"), "keyword", "31640")
        e = expectThrows(IllegalArgumentException.class, () -> new CompositeAggregationBuilder("foo", null));
            () -> {
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                createDocument("long", 4L)
                createDocument("date", asLong("2017-10-19T06:09:24")),
            (result) -> {
                createDocument("keyword", Arrays.asList("a", "b", "c"), "long", 100L),
            (result) -> {
        );
        // just unmapped = no results
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
        );
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), dataset, () -> {
            },
                    createAfterKey("date", "now")
            }
                Arrays.asList(
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            ),
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                        .calendarInterval(DateHistogramInterval.days(1))
import java.util.HashSet;
                    valuesSet.add(terms.get(rand));
                    new HistogramValuesSourceBuilder("price").field("price")
                assertEquals("{price=50.0}", result.getBuckets().get(2).getKeyAsString());
                createDocument("date", asLong("2016-09-20T09:00:34")),
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=d, long=1000, double=1.0}", result.getBuckets().get(8).getKeyAsString());
            dataset,
        );
                createDocument("keyword", Arrays.asList("b", "d")),
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals("{keyword=c, long=100, double=0.09}", result.getBuckets().get(8).getKeyAsString());
            assertEquals("{date=2016-09-20}", result.getBuckets().get(0).getKeyAsString());
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
        // sort ascending, null bucket is last.
            Arrays.asList(
            Arrays.asList(
                assertEquals(7, result.getBuckets().size());
                assertEquals(1, result.getBuckets().size());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                Arrays.asList(
                Arrays.asList(
            (result) -> {
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(0).getKeyAsString());
            List<CompositeValuesSourceBuilder<?>> builders = new ArrayList<>();
            List<CompositeValuesSourceBuilder<?>> builders = new ArrayList<>();
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true);
    }
                assertEquals("{keyword=z, long=0}", result.getBuckets().get(9).getKeyAsString());
                        .missingOrder(MissingOrder.FIRST)
                assertEquals("{keyword=z, long=0, double=0.09}", result.afterKey().toString());
                            .calendarInterval(DateHistogramInterval.days(1)),
            dataset,
        });
                assertEquals("{date=1508371200000}", result.getBuckets().get(0).getKeyAsString());
                )
import org.opensearch.search.aggregations.AggregationBuilders;
                .dateHistogramInterval(DateHistogramInterval.days(1))
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                    new TermsValuesSourceBuilder("long").field("long"),
                "name",
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
        dataset.addAll(
            (result) -> {
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
            () -> new CompositeAggregationBuilder(
            dataset,
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped")
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
        // test with no bucket
                "name",
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
import org.apache.lucene.search.TermQuery;
                Arrays.asList(
        for (int i = 0; i < numTerms; i++) {
        );
                        new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING)
        testSearchCase(
                new MatchAllDocsQuery(),
            () -> new CompositeAggregationBuilder(
 *
                Map<String, Object> afterKey = null;
                assertEquals("{price=50.0, unmapped=null}", result.getBuckets().get(1).getKeyAsString());
                .missingOrder(MissingOrder.LAST);
                    .offset(TimeUnit.HOURS.toMillis(4));
                assertEquals("{histo=0.8, keyword=z}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(3, result.getBuckets().size());
        /*
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            assertEquals(4, result.getBuckets().size());
            dataset,
                Arrays.asList(
import org.opensearch.index.query.MatchAllQueryBuilder;
        });
                createDocument("keyword", "c"),
                        Collections.singletonList(new TermsValuesSourceBuilder("keyword").field("keyword"))
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
    }
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                assertEquals(4, result.getBuckets().size());
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            }
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
                assertEquals(2L, result.getBuckets().get(4).getDocCount());
        testSearchCase(
 * not use this file except in compliance with the License.
            () -> new CompositeAggregationBuilder(
                "name",
                assertEquals("{keyword=d, long=100}", result.getBuckets().get(7).getKeyAsString());
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
            dataset,
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
    public void testMultiValuedWithKeywordDesc() throws Exception {
                .missingBucket(true)
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("ip")), dataset, () -> {
            () -> new CompositeAggregationBuilder(
            executeTestCase(false, false, new MatchAllDocsQuery(), Collections.emptyList(), () -> {
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                    )
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("{histo=0.9, keyword=a}", result.getBuckets().get(6).getKeyAsString());
                () -> new CompositeAggregationBuilder(
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
                createDocument("keyword", "a"),
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                )
        });
            )
                assertEquals("{date=1508468925000}", result.getBuckets().get(3).getKeyAsString());
            assertEquals("{keyword=d}", result.getBuckets().get(3).getKeyAsString());
                assertEquals("{keyword=a, date_histo=1508457600000}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertEquals(3, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(1, result.getBuckets().size());
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
                )
                new FieldExistsQuery("date"),
        );
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());
            );
                assertEquals("{date=1508457600000, keyword=c}", result.getBuckets().get(1).getKeyAsString());
        dataset.addAll(
            }
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                createDocument("keyword", "bar"),
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
            },
                assertEquals("{unmapped=null}", result.afterKey().toString());
                "name",
                );
                Arrays.asList(
            ),
                assertEquals("{keyword=d, date_histo=1508457600000}", result.getBuckets().get(4).getKeyAsString());
            assertEquals(topHits.getHits().getTotalHits().value(), 1L);
                Arrays.asList(
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                createDocument("ip", InetAddress.getByName("::1")),
    }
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            assertEquals("{keyword=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(2L, result.getBuckets().get(3).getDocCount());
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
                        .missingBucket(true)
                        .interval(10)
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                createDocument("keyword", "a"),
                }
        );
            assertEquals(4, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{price=100.0, unmapped=null}", result.getBuckets().get(2).getKeyAsString());
                Arrays.asList(
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
                assertEquals("{keyword=z, price=50.0}", result.getBuckets().get(6).getKeyAsString());
            Arrays.asList(
        testSearchCase(
            (result) -> {
            (result) -> {
                "name",
            );
                    "keyword",
            () -> new CompositeAggregationBuilder(
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
    }
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
            assertEquals("{ip=127.0.0.1}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(7, result.getBuckets().size());
                assertEquals("{keyword=c, long=10}", result.getBuckets().get(4).getKeyAsString());
                if (seen.size() > 0) {
        );
            ).aggregateAfter(createAfterKey("histo", 0.8d, "keyword", "b")),
        testSearchCase(
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals("{keyword=null, long=100}", result.afterKey().toString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
            assertEquals("{keyword=z}", result.getBuckets().get(2).getKeyAsString());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
        executeTestCase(false, false, new MatchAllDocsQuery(), Collections.emptyList(), () -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            )
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=a, long=100, double=0.4}", result.getBuckets().get(3).getKeyAsString());
        assertEquals(expected, seen);
    }
                createDocument("double", 0d, "keyword", "d", "long", 10L),
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(1).getKeyAsString());
        );
                assertEquals("{price=null}", result.getBuckets().get(3).getKeyAsString());
        );
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
        );
            assertEquals(4, result.getBuckets().size());
        testSearchCase(
import java.util.function.Function;
            assertEquals("{keyword=z}", result.getBuckets().get(0).getKeyAsString());
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
                new MatchAllDocsQuery(),
                        .missingBucket(true)
            dataset,
                Arrays.asList(
                assertEquals("{date=1508457600000, unmapped=null}", result.getBuckets().get(2).getKeyAsString());
            assertEquals("{ip=127.0.0.1}", result.getBuckets().get(1).getKeyAsString());
            ),
                createDocument("price", 60, "long", 2L),
                assertEquals("{keyword=c, long=0, double=0.09}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
            (result) -> {
        }, (result) -> {
                createDocument("date", asLong("2017-10-20T06:09:24")),
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped").calendarInterval(DateHistogramInterval.days(1))
                createDocument("keyword", "c"),
                        .missingOrder(MissingOrder.LAST)
                subTerms = result.getBuckets().get(2).getAggregations().get("terms");
        );
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
        );
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
            () -> new CompositeAggregationBuilder(
            assertEquals(topHits.getHits().getHits().length, 1);
                )
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
    public void testWithDateHistogramAndKeyword() throws IOException {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(5).getKeyAsString());
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
                assertEquals("{keyword=z, long=0, double=0.09}", result.getBuckets().get(9).getKeyAsString());
        }
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    .dateHistogramInterval(DateHistogramInterval.days(1))
            (result) -> {
public class CompositeAggregatorTests extends BaseCompositeAggregatorTestCase {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                        .missingBucket(true)
            () -> new CompositeAggregationBuilder(
                assertEquals(2L, result.getBuckets().get(4).getDocCount());
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
        OpenSearchParseException exc = expectThrows(
            assertEquals("{keyword=zoo}", result.getBuckets().get(2).getKeyAsString());
                new FieldExistsQuery("date"),
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertNotNull(topHits);
            (result) -> {
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(7, result.getBuckets().size());
        // field + unmapped with missing bucket = multiple results
            assertEquals("{ip=192.168.0.1}", result.afterKey().toString());
            )
        // field + unmapped with missing bucket = multiple results
                        .missingOrder(MissingOrder.FIRST)
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
    }
        });
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
        });
                    "long",
            (result) -> {
                createDocument("keyword", "d"),
            assertEquals("{keyword=foo}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=z, date_histo=1474329600000}", result.getBuckets().get(6).getKeyAsString());
            )
            dataset,
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
        });
            (result) -> {
import java.util.concurrent.atomic.AtomicBoolean;
                assertEquals("{price=null}", result.afterKey().toString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                Arrays.asList(
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(6).getKeyAsString());
            }
            assertEquals("{keyword=b}", result.getBuckets().get(0).getKeyAsString());
            testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(field)), dataset, () -> {
                assertEquals(3, result.getBuckets().size());
                assertEquals("{price=70.0}", result.afterKey().toString());
                assertEquals("{price=50.0}", result.getBuckets().get(0).getKeyAsString());
            ),
                createDocument("date", asLong("2017-10-20T03:08:45")),
        });
            () -> new CompositeAggregationBuilder(
    }
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("{price=70.0}", result.getBuckets().get(2).getKeyAsString());
            }, (result) -> {})
        dataset.addAll(
                assertEquals("{keyword=a, long=0, double=0.4}", result.getBuckets().get(1).getKeyAsString());
                )
            assertTrue(
            ),
            dataset,
            (result) -> {
import java.net.InetAddress;
                    new HistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName).interval(10),
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                assertEquals("{keyword=c, long=100, double=0.09}", result.getBuckets().get(4).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            assertEquals(2, result.getBuckets().size());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            executeTestCase(
        );
                assertEquals(76L, (long) max.getValue());
                createDocument("double", 0d, "long", 100L),
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
        // sort descending, null bucket is last, same as default
            assertEquals("{ip=192.168.0.1}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(
            assertEquals(4, result.getBuckets().size());
            assertEquals(4, result.getBuckets().size());
                Arrays.asList(
import org.opensearch.search.aggregations.metrics.TopHits;
            (result) -> {
                createDocument("keyword", Collections.emptyList())
            assertNotNull(topHits);
                        new DateHistogramValuesSourceBuilder("date").field("date")
            ).aggregateAfter(createAfterKey("price", 70.0)),
            ),
package org.opensearch.search.aggregations.bucket.composite;
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
        );
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
        // asc, null bucket is last, after 70.0
                createDocument("long", 4L)
    }
                assertEquals("{unmapped=null}", result.afterKey().toString());
            Arrays.asList(
        dataset.addAll(
                createDocument("keyword", "bar"),
            dataset,
                assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
        });
        final List<Map<String, List<Object>>> dataset = new ArrayList<>(
            dataset,
            ),
        }, (result) -> {
            () -> new CompositeAggregationBuilder(
            ).aggregateAfter(createAfterKey("price", 50.0)),
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(3).getKeyAsString());
                    Arrays.asList(0L, 100L),
            () -> new CompositeAggregationBuilder(
        );
        );
                createDocument("keyword", "a"),
                assertEquals(7, result.getBuckets().size());
    }
                    createAfterKey("date", 1474329600000L)
        }, (result) -> {
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                Arrays.asList(
    }
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                createDocument(mappedFieldName, 105),
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
        dataset.addAll(
                    .offset(TimeUnit.HOURS.toMillis(4))
                assertEquals("{keyword=z, price=50.0}", result.afterKey().toString());
                    .calendarInterval(DateHistogramInterval.days(1))
 * software distributed under the License is distributed on an
                if (result.getBuckets().size() == 0) {
            () -> new CompositeAggregationBuilder(
                assertEquals(1, result.getBuckets().size());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            Arrays.asList(new MatchAllDocsQuery()),
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                )
            );
                assertEquals(0, result.getBuckets().size());
        dataset.addAll(
            Arrays.asList(
                "name",
                )
 */
            assertEquals(topHits.getHits().getHits().length, 2);
                createDocument("keyword", "d"),
                    new HistogramValuesSourceBuilder("price").field("price")
    public void testDuplicateNames() {
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
                ).size(3),
            }
            dataset,
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("ip")), dataset, () -> {
                assertEquals(5, result.getBuckets().size());
        dataset.addAll(
        );
                assertEquals(3, result.getBuckets().size());
            (result) -> {
                assertEquals("{date=1508457600000, keyword=d}", result.afterKey().toString());
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
        for (Aggregator.SubAggCollectionMode mode : Aggregator.SubAggCollectionMode.values()) {
            dataset,
                createDocument("date", asLong("2017-10-20T06:09:24"), "keyword", Arrays.asList("a", "d")),
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
        // source field and index sorting config have different order
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
        testSearchCase(
        Supplier<T> randomSupplier,
                assertEquals("{price=70.0}", result.getBuckets().get(0).getKeyAsString());
                Arrays.asList(
        });
    public void testWithKeywordAndLong() throws Exception {
                    new TermsValuesSourceBuilder("long").field("long"),
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        testSearchCase(
                createDocument("keyword", "c", "long", 100L),
        // sort ascending, null bucket is first
import java.util.List;
import java.util.Collections;
            dataset,
                Arrays.asList(
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                        .interval(10)
                        new DateHistogramValuesSourceBuilder("date").field("date")
                assertEquals("{price=null}", result.afterKey().toString());
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
                createDocument("date", asLong("2016-09-20T09:00:34"), "keyword", Arrays.asList("b", "c")),
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
    }
        dataset.addAll(
                createDocument("long", 4L)
        });
            Arrays.asList(new MatchAllDocsQuery()),
 */
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
            assertEquals(4, result.getBuckets().size());
            dataset,
            assertEquals(topHits.getHits().getTotalHits().value(), 2L);
            () -> new CompositeAggregationBuilder(
            dataset,
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.LongPoint;
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
            assertEquals(2, result.getBuckets().size());
                createDocument("double", 0d, "keyword", "c"),
                assertEquals("{keyword=z, price=50.0}", result.getBuckets().get(3).getKeyAsString());
        testSearchCase(
                new FieldExistsQuery("date"),
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
        );
                if (values.add(terms.get(rand))) { // values are unique for one doc
            () -> new CompositeAggregationBuilder(
        while (finish.get() == false) {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                createDocument("date", asLong("2017-10-20T03:08:45")),
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
    }
                assertEquals("{keyword=null, long=null}", result.afterKey().toString());
        List<T> expected = new ArrayList<>(valuesSet); // how many buckets expected
                assertEquals("{date=1508385600000}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
            (result) -> {
            (result) -> {
            )
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
                assertTrue(result.isTerminatedEarly());
            assertEquals("{keyword=b}", result.getBuckets().get(3).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                assertEquals("{keyword=c, long=100, double=0.4}", result.getBuckets().get(9).getKeyAsString());
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        }
                assertEquals("{price=50.0}", result.getBuckets().get(0).getKeyAsString());
            new CompositeAggregationBuilder("foo", builders);
            Arrays.asList(
        int size = randomIntBetween(1, expected.size());
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                assertEquals(3, result.getBuckets().size());
                    finish.set(true);
                Arrays.asList(
            () -> new CompositeAggregationBuilder(
                assertEquals("{price=60.0}", result.getBuckets().get(2).getKeyAsString());
                    assertEquals("{date=1591142400000, keyword=91640}", result.afterKey().toString());
import java.util.concurrent.atomic.AtomicLong;
            ).aggregateAfter(createAfterKey("keyword", "d", "long", 10L)),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals("{date=1474329600000}", result.afterKey().toString()); // 2017-10-20T00:00:00
                    new TermsValuesSourceBuilder("keyword").field("keyword")
         * the four hour offset.
            Arrays.asList(new MatchAllDocsQuery()),
            )
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
    }
        );
        );
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            () -> new CompositeAggregationBuilder(
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals(1L, result.getBuckets().get(8).getDocCount());
                assertEquals("{date=1508410800000}", result.afterKey().toString());
                assertEquals("{keyword=c, long=100, double=0.4}", result.getBuckets().get(5).getKeyAsString());
        );
                assertEquals(3, result.getBuckets().size());
        }
        );
        );
                "name",
            }
            () -> new CompositeAggregationBuilder(
            );
            },
                assertEquals(2L, result.getBuckets().get(6).getDocCount());
                    new HistogramValuesSourceBuilder("price").field("price")
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(1).getKeyAsString());
        }
            }
            Arrays.asList(
    }
                createDocument("long", 100L)
                "name",
            assertEquals("{keyword=d}", result.getBuckets().get(3).getKeyAsString());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("ip").field("ip");
            dataset,
                (result) -> { assertEquals(0, result.getBuckets().size()); }
                createDocument(mappedFieldName, 51),
        // asc, null bucket is last
                createDocument("date", asLong("2016-09-20T09:00:34")),
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
 * compatible open source license.
            },
                createDocument("date", asLong("2017-10-19T06:09:24")),
                assertEquals("{date=1508479764000}", result.getBuckets().get(4).getKeyAsString());
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                Arrays.asList(
            Arrays.asList(
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                        .subAggregation(new MaxAggregationBuilder("max").field("long"))
            );
                createDocument("double", 0d, "keyword", "a", "long", 100L),
                subTerms = result.getBuckets().get(1).getAggregations().get("terms");
            )
            )
import java.util.concurrent.TimeUnit;
        } catch (IllegalArgumentException iae) {
        );
import java.util.function.Supplier;
                assertEquals(1, result.getBuckets().size());
            assertEquals("{keyword=z}", result.getBuckets().get(4).getKeyAsString());
            testSearchCase(
                createDocument("keyword", "d", "long", 10L, "foo", "bar"),
                assertEquals(4, result.getBuckets().size());
                assertEquals("{keyword=c, long=10, double=0.09}", result.getBuckets().get(7).getKeyAsString());
                assertEquals("{date=1508479764000}", result.afterKey().toString());
            ),
/*
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
        );
        }, (result) -> {
            return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
            ),
            dataset,
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            assertEquals("{keyword=a}", result.getBuckets().get(2).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
        testRandomTerms("price", () -> randomInt(), (v) -> ((Number) v).intValue());
    public void testThatDateHistogramFailsFormatAfter() throws IOException {
            dataset,
                ).aggregateAfter(afterKey).size(size);
        });
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true)
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            () -> new CompositeAggregationBuilder(
                Collections.singletonMap("keyword", "c")
                assertEquals("{keyword=d, long=1000}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(0).getKeyAsString());
        // keyword null bucket is last, long null bucket is last
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                    .calendarInterval(DateHistogramInterval.days(1))
                    createAfterKey("date", 1474329600000L)
                assertEquals(70L, (long) max.getValue());
                "name",
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                "name",
                createDocument("double", 0.98d, "keyword", Arrays.asList("a", "d")),
                createDocument("date", asLong("2016-09-20T11:34:00"), "keyword", Arrays.asList("b", "z")),
            );
            (result) -> {
        dataset.addAll(
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            );
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
        testSearchCase(
            ),
    }
            }
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                createDocument(mappedFieldName, asLong("2016-09-20T09:00:34")),
    public void testWithKeywordAndHistogram() throws IOException {
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                )
            assertNotNull(topHits);
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                createDocument("long", 100L)
                    )
                createDocument(mappedFieldName, 25)
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
            Arrays.asList(new MatchAllDocsQuery()),
                new MatchAllDocsQuery(),
                assertEquals(10, result.getBuckets().size());
            DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                assertEquals("{keyword=c, long=0}", result.getBuckets().get(6).getKeyAsString());
            ).aggregateAfter(createAfterKey("keyword", "z", "long", 100L, "double", 0.4d)),
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
        // desc, null bucket is last, search after non null value
        List<T> terms = new ArrayList<>(); // possible values for the terms
                Arrays.asList(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
    }
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), dataset, () -> {
            }
            assertEquals("{date=2017-10-19}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
    }
                )
        );
                assertEquals("{price=null}", result.getBuckets().get(0).getKeyAsString());
 * under the License.
            }
            assertEquals(0, result.getBuckets().size());
            () -> new CompositeAggregationBuilder(
            () -> new CompositeAggregationBuilder(
                createDocument("date", asLong("2017-10-19T06:09:24"), "_doc_count", 3),
                createDocument("date", asLong("2016-09-20T11:34:00"), "_doc_count", 2),
        assertThat(exc.getMessage(), containsString("failed to parse date field [1474329600000]"));
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
            dataset,
                createDocument("double", 0.55d, "keyword", Arrays.asList("g")),
                        .field("terms")
                );
                createDocument("keyword", "c"),
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
                assertEquals("{date=1508457600000}", result.getBuckets().get(2).getKeyAsString());
                createDocument("double", 0d),
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(8).getKeyAsString());
        testSearchCase(
                createDocument("keyword", "d"),
            (result) -> {
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
            assertEquals(3, result.getBuckets().size());
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
            assertEquals("{keyword=a}", result.getBuckets().get(1).getKeyAsString());
                createDocument(
                .missingBucket(true)
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                createDocument("long", 5L)
                assertEquals("{histo=0.8, keyword=z}", result.getBuckets().get(5).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                Arrays.asList(
            Arrays.asList(
                createDocument("long", 4L)
        testSearchCase(
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(
                createDocument("date", asLong("2017-10-20T03:08:45")),
            assertEquals("{keyword=zoo}", result.afterKey().toString());
                createDocument("date", asLong("2017-10-20T03:08:45"), "keyword", Arrays.asList("a", "c")),
                max = subTerms.getBuckets().get(0).getAggregations().get("max");
                Arrays.asList(new TermsValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true))
                assertEquals(6, result.getBuckets().size());
            );
                    assertEquals(3, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
        }, (result) -> {
            ),
import org.opensearch.OpenSearchParseException;
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(0).getKeyAsString());
            () -> {
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
            dataset,
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(2).getKeyAsString());
                .missingOrder(MissingOrder.LAST)
        executeTestCase(
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            () -> testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), Collections.emptyList(), () -> {
                    "double",
            Arrays.asList(
                new FieldExistsQuery("date"),
                assertEquals("{keyword=a, long=100}", result.afterKey().toString());
            )
            (result) -> {
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
            }
            dataset,
                createDocument("date", asLong("2017-10-19T06:09:24")),
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
            );
                createDocument("keyword", Arrays.asList("a", "b")),
            dataset,
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
            dataset,
                createDocument("price", 70, "long", 3L),
                "name",
                )
                .order(SortOrder.DESC);
            assertEquals("{keyword=a}", result.afterKey().toString());
    public void testEarlyTermination() throws Exception {
        );
                assertEquals("{keyword=null}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{date=1508457600000, keyword=c}", result.getBuckets().get(5).getKeyAsString());
    }
            dataset,
        // asc, null bucket is first
        assertThat(exc.getCause().getMessage(), containsString("now() is not supported in [after] key"));
            assertEquals(topHits.getHits().getTotalHits().value(), 1L);
                assertEquals("{keyword=b, long=100}", result.getBuckets().get(7).getKeyAsString());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>(
            }
        }, (result) -> {
                assertEquals("{keyword=null, long=100}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(1).getKeyAsString());
            dataset,
                createDocument("long", 0L),
                )
                assertEquals("{date=1474344000000}", result.getBuckets().get(0).getKeyAsString());
        });
            )
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
        int numTerms = randomIntBetween(10, 500);
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    assertEquals("{date=1591142400000, keyword=91640}", result.getBuckets().get(2).getKeyAsString());
            () -> {
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(0).getKeyAsString());
                .format("yyyy-MM-dd");
                createDocument("keyword", "c", "long", 100L),
            ).aggregateAfter(createAfterKey("keyword", "c", "long", 10L)).size(2),
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                "name",
                );
            () -> new CompositeAggregationBuilder(
            ),
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
                createDocument("price", 56L, "keyword", Arrays.asList("b", "z")),
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                createDocument("keyword", "a", "terms", "a", "long", 50L),
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            () -> new CompositeAggregationBuilder(
            ),
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true),
                true,
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
            Arrays.asList(
                assertEquals("{histo=0.5, keyword=g}", result.getBuckets().get(3).getKeyAsString());
            Arrays.asList(
import org.opensearch.search.aggregations.support.ValueType;
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            assertEquals(3, result.getBuckets().size());
        );
        );
        );
    }
                assertNull(result.afterKey());
            assertEquals(topHits.getHits().getTotalHits().value(), 2L);
                assertEquals("{date=1474329600000}", result.getBuckets().get(0).getKeyAsString());
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST))
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
            true,
            true,
        );
                Arrays.asList(
            assertEquals("{date=2017-10-20}", result.afterKey().toString());
                assertEquals("{price=70.0}", result.afterKey().toString());
                assertEquals(2L, result.getBuckets().get(4).getDocCount());
        );
        );
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(
            ).aggregateAfter(createAfterKey("keyword", "c", "long", 10L)),
                assertEquals("{date=1508472000000}", result.getBuckets().get(2).getKeyAsString());
                )
                Arrays.asList(
            () -> new CompositeAggregationBuilder(
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
                createDocument("keyword", "a"),
                assertEquals("{date=1508393364000}", result.getBuckets().get(2).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());
            builders.add(new TermsValuesSourceBuilder("duplicate2").field("bar"));
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
            ),
            Arrays.asList(
                assertEquals("{keyword=d, price=100.0}", result.getBuckets().get(4).getKeyAsString());
                createDocument("ip", InetAddress.getByName("192.168.0.1"))
            Arrays.asList(
                assertEquals(1, result.getBuckets().size());
                new MatchAllDocsQuery(),
                createDocument("keyword", "c")
        );
                createDocument("double", 0d, "keyword", "a", "long", 0L),
    }
                "name",
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
 *    http://www.apache.org/licenses/LICENSE-2.0
            dataset,
    }
                createDocument("date", asLong("2020-06-03T01:21:10"), "keyword", "11640"),
            assertEquals("{keyword=d}", result.afterKey().toString());
            )
 * The OpenSearch Contributors require contributions made to
                "name",
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
            },
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
        dataset.addAll(
            return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
    }
                createDocument("keyword", "a"),
    public void testMissingSources() {
            () -> new CompositeAggregationBuilder(
                createDocument("price", 25L, "keyword", Arrays.asList("g")),
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
            () -> new CompositeAggregationBuilder(
            }
                },
                assertEquals("{keyword=null, long=null}", result.getBuckets().get(6).getKeyAsString());
                assertEquals(3, result.getBuckets().size());
            () -> {
                max = subTerms.getBuckets().get(1).getAggregations().get("max");
                dataset,
                .missingOrder(MissingOrder.FIRST)
            new TermQuery(new Term("foo", "bar")),
        // keyword null bucket is last, long null bucket is last
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
        testSearchCase(
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(5).getKeyAsString());
            new CompositeAggregationBuilder("foo", builders);
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                new MatchAllDocsQuery(),
            Arrays.asList(
            () -> new CompositeAggregationBuilder(
                    .calendarInterval(DateHistogramInterval.days(1));
                assertEquals("{date=1508457600000, keyword=a}", result.getBuckets().get(0).getKeyAsString());
                createDocument("date", asLong("2016-09-20T11:34:00")),
        });
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
                        new TermsValuesSourceBuilder("keyword").field("keyword")
        // keyword null bucket is last, long null bucket is first
                assertEquals("{keyword=d, long=1000}", result.getBuckets().get(3).getKeyAsString());
                    new TermsValuesSourceBuilder("unmapped").field("unmapped")
                assertEquals(3, result.getBuckets().size());
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
            Arrays.asList(
                createDocument(mappedFieldName, asLong("2017-10-19T06:09:24"))
        );
        assertThat(exc.getCause(), instanceOf(IllegalArgumentException.class));
            (result) -> {
            }
    public void testMultiValuedWithKeywordLongAndDouble() throws Exception {
            }, (result) -> {
                "name",
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("{histo=0.9, keyword=d}", result.afterKey().toString());
                )
        dataset.addAll(
        // desc, null bucket is first, after 60.0
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                .missingBucket(true)
                createDocument("long", 4L)
                Arrays.asList(
            }
            ).aggregateAfter(createAfterKey("price", 60.0d)),
            (result) -> {
        dataset.addAll(
        List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(5).getKeyAsString());
                assertEquals("{keyword=null}", result.afterKey().toString());
                Arrays.asList(new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10).missingBucket(true))
            });
    public void testIndexSortWithDuplicate() throws Exception {
                    new TermsValuesSourceBuilder("long").field("long"),
    }
                ).aggregateAfter(createAfterKey("date", 1591142400000L, "keyword", "31640")).size(3),
            assertEquals("{keyword=a}", result.getBuckets().get(2).getKeyAsString());
                new FieldExistsQuery("date"),
                .order(SortOrder.DESC);
        );
                    "compo",
            () -> {
                assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
            }, (result) -> {
                        .missingBucket(true)
            (result) -> {
        assertThat(e.getMessage(), equalTo("Composite [sources] cannot be null or empty"));
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
            () -> new CompositeAggregationBuilder(
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
        assertThat(e.getMessage(), equalTo("Composite source cannot be null"));
                "name",
                createDocument("date", asLong("2016-09-20T11:34:00")),
            (result) -> {
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals("{date=1474344000000}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{keyword=b, long=100, double=0.4}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(
                    new DateHistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName)
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("y", subTerms.getBuckets().get(1).getKeyAsString());
            dataset,
                LongPoint.newRangeQuery("date", asLong("2016-09-20T11:34:00"), asLong("2017-10-20T06:09:24"))
            assertEquals("{keyword=delta}", result.getBuckets().get(1).getKeyAsString());
                    Collections.singletonList(new TermsValuesSourceBuilder("keyword").field("keyword"))
        );
            dataset,
        testSearchCase(
                    new HistogramValuesSourceBuilder("price").field("price")
            assertEquals("{keyword=null}", result.afterKey().toString());
                createDocument("double", 0.98d, "keyword", Arrays.asList("a", "d")),
    public void testRandomInts() throws IOException {
                assertEquals("{histo=0.9, keyword=a}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                createDocument("price", 51L, "keyword", Arrays.asList("b", "c")),
        dataset.addAll(
                    .timeZone(ZoneId.of("America/Los_Angeles"));
            Arrays.asList(
                assertEquals("{keyword=b, long=100, double=0.4}", result.getBuckets().get(4).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true),
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            (result) -> {
                assertEquals("{keyword=g, date_histo=1508371200000}", result.getBuckets().get(5).getKeyAsString());
                assertEquals(2, result.getBuckets().size());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
            (result) -> {
            dataset,
            }
        dataset.addAll(
        assertThat(e.getMessage(), equalTo("Composite [sources] cannot be null or empty"));
                    .format("yyyy-MM-dd");
            assertEquals("{ip=192.168.0.1}", result.getBuckets().get(2).getKeyAsString());
import static org.hamcrest.Matchers.containsString;
                assertEquals("{date=1508371200000}", result.getBuckets().get(1).getKeyAsString());
                Collections.singletonMap("ip", "::1")
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(9).getKeyAsString());
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
                )
 * the Apache License, Version 2.0 (the "License"); you may
            (result) -> {
            new CompositeAggregationBuilder("foo", builders);
 * specific language governing permissions and limitations
            dataset,
            () -> new CompositeAggregationBuilder(
    public void testWithDateHistogramAndFormat() throws IOException {
                assertEquals("{keyword=b, long=10}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                )
            assertEquals(topHits.getHits().getTotalHits().value(), 2L);
                assertEquals("{date=1508457600000, unmapped=null}", result.afterKey().toString());
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
            );
                createDocument("long", 100L)
        );
                createDocument("date", asLong("2016-09-20T11:34:00")),
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
 * You may obtain a copy of the License at
            }
        // field + unmapped, no missing bucket = no results
            () -> new CompositeAggregationBuilder(
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
            );
            assertEquals(1, result.getBuckets().size());
            )
                createDocument("keyword", "c"),
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals("{keyword=c, long=100}", result.afterKey().toString());
                for (InternalComposite.InternalBucket bucket : result.getBuckets()) {
            ),
                assertEquals("{date=1508472000000}", result.afterKey().toString());
                    new CompositeAggregationBuilder(
            true,
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                (result) -> {
                    assertEquals(3, result.getBuckets().size());
                "name",
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("ip").field("ip");
            assertEquals("{ip=::1}", result.getBuckets().get(0).getKeyAsString());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
        dataset.addAll(
        executeTestCase(
            ),
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
                "name",
            (result) -> {
                )
            ).aggregateAfter(createAfterKey("keyword", "b", "long", 10L)).size(2),
    public void testUnmappedFieldWithTerms() throws Exception {
                assertEquals("{price=60.0}", result.getBuckets().get(1).getKeyAsString());
            }
            assertEquals("{keyword=zoo}", result.afterKey().toString());
                assertEquals(4, result.getBuckets().size());
        });
        });
    public void testWithKeyword() throws Exception {
                createDocument("keyword", "a", "long", 100L),
            assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
            () -> testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("date")), Collections.emptyList(), () -> {
                max = subTerms.getBuckets().get(1).getAggregations().get("max");
        );
            assertEquals("{keyword=null}", result.getBuckets().get(3).getKeyAsString());
                    new HistogramValuesSourceBuilder("price").field("price")
                assertEquals("{date=1474329600000}", result.getBuckets().get(0).getKeyAsString());
            TopHits topHits = result.getBuckets().get(0).getAggregations().get("top_hits");
            ),
                createDocument("date", asLong("2017-10-20T03:08:45"), "keyword", Arrays.asList("a", "c")),
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(1L, result.getBuckets().get(7).getDocCount());
        testSearchCase(
                assertEquals(3, result.getBuckets().size());
            }
                assertEquals("{keyword=null}", result.getBuckets().get(1).getKeyAsString());
        });
                    seen.add(term);
                "name",
                createDocument("double", 0.55d, "keyword", Arrays.asList("g")),
        dataset.addAll(
            Arrays.asList(
            },
        // asc, null bucket is first, after null
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
                createDocument("long", 4L)
                    new TermsValuesSourceBuilder("double").field("double")
            ),
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true)
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
                createDocument("date", asLong("2020-06-03T01:15:10"), "keyword", "91640"),
            assertEquals(5, result.getBuckets().size());
                )
    public void testDateHistogramSourceWithSize() throws IOException {
                "name",
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
                new FieldExistsQuery("date"),
            assertEquals("{keyword=null}", result.afterKey().toString());
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
        );
            Arrays.asList(
                createDocument("date", asLong("2017-10-20T06:09:24"), "keyword", Arrays.asList("a", "d")),
    public void testRandomLongs() throws IOException {
            (result) -> {
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
 *
                        .interval(10)
                assertEquals("{histo=0.8, keyword=b}", result.getBuckets().get(4).getKeyAsString());
                .missingBucket(true)
        testRandomTerms("long", () -> randomLong(), (v) -> (long) v);
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
            dataset,
    public void testWithHistogramBucketMissing() throws IOException {
                assertEquals(7, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(6).getKeyAsString());
            dataset,
        dataset.addAll(
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
                "name",
            }
                assertEquals("{keyword=c, long=null}", result.getBuckets().get(4).getKeyAsString());
        testSearchCase(
                        .missingBucket(true)
    }
import static org.hamcrest.Matchers.equalTo;
        exc = expectThrows(
    public void testWithDateTerms() throws IOException {
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(0).getKeyAsString());
            () -> new CompositeAggregationBuilder(
                createDocument("date", asLong("2016-09-20T09:00:34")),
                );
                )
                "name",
        );
            Arrays.asList(
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            () -> new CompositeAggregationBuilder(
                    new TopHitsAggregationBuilder("top_hits").storedField("_none_")
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                new FieldExistsQuery("date"),
            ).aggregateAfter(createAfterKey("keyword", "b", "long", 100L)),
                assertEquals(2L, result.getBuckets().get(6).getDocCount());
    }
            assertEquals("{ip=192.168.0.1}", result.afterKey().toString());
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(2).getKeyAsString());
                    new TermsValuesSourceBuilder("double").field("double")
                createDocument("double", 0.4d, "keyword", Arrays.asList("a", "c")),
        dataset.addAll(
                assertEquals(2L, result.getBuckets().get(3).getDocCount());
                assertEquals(2, subTerms.getBuckets().size());
                    new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10)
                    new DateHistogramValuesSourceBuilder("unmapped").field("unmapped")
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
        testSearchCase(
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                    AtomicLong count = expectedDocCounts.computeIfAbsent(terms.get(rand), (k) -> new AtomicLong(0));
                    )
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                );
        // sort descending, null bucket is last
            ),
            ).subAggregation(new TopHitsAggregationBuilder("top_hits").storedField("_none_"));
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            (result) -> {
        );
            }
            }
                )
        });
                return termsAggregationBuilder;
    private <T extends Comparable<T>, V extends Comparable<T>> void testRandomTerms(
        testSearchCase(
            }
            ),
                createDocument("date", asLong("2017-10-19T06:09:24"), "keyword", Arrays.asList("g")),
                assertEquals(10, result.getBuckets().size());
        );
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
            dataset,
                        .order(SortOrder.DESC)
            dataset,
                        .order(SortOrder.DESC)
                assertEquals(2, result.getBuckets().size());
                        .missingOrder(MissingOrder.FIRST)
                assertEquals(4, result.getBuckets().size());
            );
                createDocument("keyword", "c"),
            assertEquals("{keyword=z}", result.afterKey().toString());
                    new DateHistogramValuesSourceBuilder("date").field("date").dateHistogramInterval(DateHistogramInterval.days(1)),
            assertEquals("{keyword=d}", result.getBuckets().get(0).getKeyAsString());
        AtomicBoolean finish = new AtomicBoolean(false);
                    new HistogramValuesSourceBuilder("price").field("price")
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals("{keyword=c, long=10}", result.getBuckets().get(0).getKeyAsString());
        }, (result) -> {
            }
                assertEquals(3, result.getBuckets().size());
                assertEquals(1L, result.getBuckets().get(9).getDocCount());
            Arrays.asList(
                .order(SortOrder.DESC);
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                createDocument("double", 0.45d, "keyword", Arrays.asList("b", "c")),
            (result) -> {
    public void testWithDateHistogram() throws IOException {
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
            () -> new CompositeAggregationBuilder(
                createDocument("keyword", "zoo"),
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals("{keyword=null}", result.afterKey().toString());
        testSearchCase(
                assertEquals("{keyword=z, date_histo=1474329600000}", result.afterKey().toString());
                createDocument("date", asLong("2017-10-20T03:08:45")),
                createDocument("keyword", Collections.emptyList())
            Arrays.asList(
            assertEquals("{keyword=a}", result.afterKey().toString());
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(2, subTerms.getBuckets().size());
                assertEquals("{price=60.0}", result.getBuckets().get(1).getKeyAsString());
                            .order(order)
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
            fail("Should have thrown an IllegalArgumentException");
                assertEquals("{date=1474371240000}", result.getBuckets().get(1).getKeyAsString());
        testSearchCase(
        }, (result) -> {
        );
                )
                createDocument("keyword", "a"),
    }
                    Arrays.asList(
            () -> {
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
        testSearchCase(
        );
                createDocument("keyword", Arrays.asList("d", "d"), "long", Arrays.asList(10L, 100L, 1000L)),
            )
import java.io.IOException;
    public void testUnderBucketAggregator() throws IOException {
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    .dateHistogramInterval(DateHistogramInterval.days(1))
                assertEquals("{keyword=d, long=10, double=1.0}", result.getBuckets().get(6).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                "name",
            (result) -> {
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                assertTrue(result.isTerminatedEarly());
            topHits = result.getBuckets().get(1).getAggregations().get("top_hits");
        );
            (result) -> {
            assertEquals("{keyword=c}", result.getBuckets().get(0).getKeyAsString());
            }
                Arrays.asList(
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                }
                        .missingOrder(MissingOrder.FIRST)
            }
                assertEquals("{histo=0.4, keyword=a}", result.getBuckets().get(0).getKeyAsString());
        }, (result) -> {
            assertEquals("{date=2017-10-20}", result.getBuckets().get(1).getKeyAsString());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                    count.incrementAndGet();
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
            topHits = result.getBuckets().get(1).getAggregations().get("top_hits");
                Arrays.asList(new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10))
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                createDocument("keyword", Arrays.asList("a", "b", "c"), "long", 100L),
        // desc, null bucket is last, after 50.0
            }
            assertEquals(topHits.getHits().getHits().length, 1);
                )
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                    new HistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName).interval(10),
            (result) -> assertEquals(0, result.getBuckets().size())
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            }
        testSearchCase(
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                    createAfterKey("date", "1474329600000")
                createDocument(mappedFieldName, asLong("2017-10-20T06:09:24")),
                assertEquals(10, result.getBuckets().size());
            )
                assertEquals("{date=1474369200000}", result.getBuckets().get(0).getKeyAsString());
            )
                createDocument("keyword", "c"),
                Arrays.asList(
        testSearchCase(
        Function<Object, V> transformKey
                )
                LongPoint.newRangeQuery("date", asLong("2016-09-20T09:00:34"), asLong("2017-10-20T06:09:24"))
            ).aggregateAfter(createAfterKey("keyword", "c", "date_histo", 1474329600000L)),
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
        });
                assertEquals("a", subTerms.getBuckets().get(0).getKeyAsString());
            assertEquals(2L, result.getBuckets().get(4).getDocCount());
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                createDocument("long", 100L)
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                createDocument(mappedFieldName, 103),
                "name",
                    new HistogramValuesSourceBuilder("price").field("price")
            dataset,
        testSearchCase(
        }, (result) -> {
            )
        );
    }
                assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                assertThat(result.getBuckets().get(0).getKey().get("date"), instanceOf(Long.class));
                assertEquals("{histo=0.9, keyword=d}", result.getBuckets().get(2).getKeyAsString());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            }
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                "name",
                createDocument("keyword", "c", "terms", "y", "long", 70L)
                "name",
                assertEquals("{date=1474329600000, keyword=b}", result.getBuckets().get(0).getKeyAsString());
                    createAfterKey("date", 1474329600000L)
                () -> {
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                )
            (result) -> {
            Arrays.asList(new MatchAllDocsQuery()),
                createDocument("keyword", "a"),
        // unmapped missing bucket = one result
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                assertEquals("{keyword=z, long=0}", result.getBuckets().get(4).getKeyAsString());
                assertEquals("{keyword=a, long=0, double=0.09}", result.getBuckets().get(0).getKeyAsString());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            dataset,
                        .order(SortOrder.DESC)
                assertEquals("d", subTerms.getBuckets().get(0).getKeyAsString());
}
                createDocument("double", 0d, "keyword", "c", "long", 100L),
                        .interval(10)
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            ),
            (result) -> {
        // just unmapped = no results
                assertEquals(1, result.getBuckets().get(5).getDocCount());
                Arrays.asList(
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=c, price=100.0}", result.getBuckets().get(0).getKeyAsString());
                )
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).aggregateAfter(
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
            )
                )
        );
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                "name",
                ),
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(7, result.getBuckets().size());
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            )
            dataset,
            assertEquals("{keyword=a}", result.getBuckets().get(3).getKeyAsString());
        );
                assertEquals(0, result.getBuckets().size());
                    new HistogramValuesSourceBuilder("price").field("price")
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
            assertNull(result.afterKey());
                createDocument("long", 4L)
        );
            assertEquals("{date=2017-10-20}", result.getBuckets().get(2).getKeyAsString());
                TermsValuesSourceBuilder source = new TermsValuesSourceBuilder(field).field(field);
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
            true,
                createDocument("date", asLong("2016-09-20T09:00:34")),
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            Arrays.asList(
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true).missingOrder(MissingOrder.FIRST)
            () -> new CompositeAggregationBuilder(
 * ownership. Elasticsearch licenses this file to you under
                createDocument("keyword", Arrays.asList("c", "a")),
            (result) -> {
                createDocument("keyword", "c", "long", 10L, "foo", "bar"),
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{date=1508457600000}", result.getBuckets().get(2).getKeyAsString());
            (result) -> {
            }
                assertEquals("{keyword=d, long=100}", result.getBuckets().get(2).getKeyAsString());
                createDocument("keyword", "d", "terms", "y", "long", 76L),
                assertEquals("{keyword=c, long=10, double=0.09}", result.getBuckets().get(3).getKeyAsString());
                assertEquals("{keyword=c, long=0, double=0.09}", result.getBuckets().get(5).getKeyAsString());
                assertEquals(2, result.getBuckets().size());
            assertEquals(3, result.getBuckets().size());
        }, (result) -> {
                assertEquals("{keyword=d, long=100, double=1.0}", result.getBuckets().get(7).getKeyAsString());
                assertEquals("{date=1508385600000}", result.getBuckets().get(1).getKeyAsString());
            dataset,
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals("{keyword=d, price=100.0}", result.getBuckets().get(1).getKeyAsString());
        }, (result) -> {
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("price")),
                    new HistogramValuesSourceBuilder("histo").field("double").interval(0.1),
            (result) -> {
            (result) -> {
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
                createDocument("keyword", "a"),
                createDocument("keyword", Arrays.asList("c", "a")),
            () -> new CompositeAggregationBuilder(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                new MatchAllDocsQuery(),
            }
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
        // desc, null bucket is first
            ),
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());
                assertEquals("{date=1508472000000}", result.afterKey().toString());
                assertEquals("{keyword=z, long=100}", result.afterKey().toString());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            dataset,
                assertEquals(0, result.getBuckets().size());
            }
                assertEquals("{date=1474362034000}", result.getBuckets().get(0).getKeyAsString());
                int rand = randomIntBetween(0, terms.size() - 1);
                assertEquals(8, result.getBuckets().size());
            ),
                assertEquals(50L, (long) max.getValue());
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                    new DateHistogramValuesSourceBuilder("date_histo").field("date").dateHistogramInterval(DateHistogramInterval.days(1))
            Arrays.asList(
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(1).getKeyAsString());
                "name",
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(6).getKeyAsString());
         * Tests the -04:00 time zone. This functions identically to
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                assertEquals(3, result.getBuckets().size());
            dataset,
                "name",
            assertEquals("{keyword=delta}", result.getBuckets().get(1).getKeyAsString());
        );
                    .contains("[composite] aggregation cannot be used with a parent aggregation of type: [TermsAggregatorFactory]")
                    "name",
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals(4L, result.getBuckets().get(2).getDocCount());
                    new HistogramValuesSourceBuilder("unmapped").field("unmapped").interval(10).missingBucket(true)
            }, (ic) -> {});
                )
        testSearchCase(
            Arrays.asList(
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                createDocument("ip", InetAddress.getByName("192.168.0.1")),
                assertEquals("{price=20.0, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
            ),
                    TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword");
                assertEquals("{keyword=b, price=50.0}", result.getBuckets().get(1).getKeyAsString());
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true).missingOrder(MissingOrder.LAST),
    }
 */
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
        );
            assertEquals("{keyword=bar}", result.getBuckets().get(2).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            ).aggregateAfter(createAfterKey("date", 1508371200000L, "keyword", "g")),
            List<CompositeValuesSourceBuilder<?>> builders = new ArrayList<>();
                Collections.singletonMap("keyword", "a")
            Arrays.asList(new MatchAllDocsQuery()),
            (result) -> {
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
        }, (result) -> {
                createDocument("keyword", Arrays.asList("a", "b")),
        assertThat(e.getMessage(), equalTo("Composite source names must be unique, found duplicates: [duplicate2, duplicate1]"));
            }
                assertEquals("{date=1508371200000, keyword=g}", result.getBuckets().get(3).getKeyAsString());
                }
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                createDocument("date", asLong("2017-10-20T06:09:24")),
                createDocument("date", asLong("2017-10-19T06:09:24"), "keyword", Arrays.asList("g")),
                assertEquals("{date=1508410800000}", result.getBuckets().get(2).getKeyAsString());
            ),
                "name",
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
        testSearchCase(
        });
        );
    public void testWithIP() throws Exception {
        // unmapped missing bucket = one result
        for (SortOrder order : SortOrder.values()) {
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                Arrays.asList(
                    assertEquals("{date=1591142400000, keyword=37640}", result.getBuckets().get(0).getKeyAsString());
                createDocument("keyword", "a", "long", 0L, "foo", "bar"),
        );
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
/*
                        .missingOrder(MissingOrder.LAST)
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
            assertEquals(result.afterKey().toString(), "{keyword=a}");
                    Arrays.asList("a", "z", "c"),
            builders.add(null);
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
                "name",
                "name",
            );
                createDocument("keyword", "a", "long", 0L),
                assertEquals("{keyword=c, price=50.0}", result.getBuckets().get(2).getKeyAsString());
            (result) -> {
        );
                assertEquals(4, result.getBuckets().size());
                createDocument("long", 5L)
        // field + unmapped, no missing bucket = no results
        );
                TermsValuesSourceBuilder histo = new TermsValuesSourceBuilder("date").field("date");
                        .calendarInterval(DateHistogramInterval.days(1))
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                "name",
                createDocument("keyword", "c", "long", 100L),
                assertEquals("{price=50.0}", result.getBuckets().get(1).getKeyAsString());
            assertEquals("{keyword=d}", result.afterKey().toString());
                assertEquals("{keyword=a, long=100}", result.getBuckets().get(1).getKeyAsString());
                createDocument("double", 0.8d, "keyword", Arrays.asList("b", "z")),
                createDocument("keyword", "c"),
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
        }, (result) -> {
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                    .calendarInterval(DateHistogramInterval.days(1))
 * GitHub history for details.
                assertEquals(1, result.getBuckets().size());
                createDocument("date", asLong("2017-10-20T06:09:24")),
                return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).subAggregation(
            Arrays.asList(
 * license agreements. See the NOTICE file distributed with
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
        int numDocs = randomIntBetween(100, 200);
                createDocument("keyword", "d"),
            assertEquals("{keyword=a}", result.getBuckets().get(0).getKeyAsString());
                    new HistogramValuesSourceBuilder(mappedFieldName).field(mappedFieldName).interval(10),
            }
                assertEquals("{price=null}", result.afterKey().toString());
        }, (result) -> {
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
            Set<Object> values = new HashSet<>();
                assertEquals(2L, result.getBuckets().get(4).getDocCount());
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
                "name",
            assertEquals("{keyword=null}", result.afterKey().toString());
                Arrays.asList(
        });
 * Licensed to Elasticsearch under one or more contributor
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
                    new TermsValuesSourceBuilder("double").field("double")
                createDocument("keyword", "c"),
            assertEquals("{keyword=z}", result.afterKey().toString());
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
                        .missingOrder(MissingOrder.LAST)
        testRandomTerms("keyword", () -> randomAlphaOfLengthBetween(5, 50), (v) -> (String) v);
            Arrays.asList(
            Arrays.asList(
        testSearchCase(
            assertEquals("{keyword=d}", result.afterKey().toString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
            dataset,
            }
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
        });
        );
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                    assertEquals(2L, result.getBuckets().get(1).getDocCount());
            builders.add(new TermsValuesSourceBuilder("duplicate2").field("baz"));
            assertEquals(3, result.getBuckets().size());
            ).aggregateAfter(createAfterKey("keyword", "c")),
                assertEquals(0, result.getBuckets().size());
 * Unless required by applicable law or agreed to in writing,
                createDocument("keyword", "c", "long", Arrays.asList(100L, 0L, 10L)),
        testSearchCase(
                .dateHistogramInterval(DateHistogramInterval.days(1))
        testSearchCase(
            )
                createDocument("keyword", Arrays.asList("z")),
        });
            assertEquals("{keyword=foo}", result.getBuckets().get(0).getKeyAsString());
                createDocument("date", asLong("2017-10-20T03:08:45"), "_doc_count", 5),
        dataset.addAll(
                assertEquals(2L, result.getBuckets().get(9).getDocCount());
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
        );
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals("{price=60.0}", result.getBuckets().get(1).getKeyAsString());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
    public void testUnderFilterAggregator() throws IOException {
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo)).size(1);
            dataset,
                "name",
                )
        });
                new FieldExistsQuery("date"),
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                .missingBucket(true)
                .format("yyyy-MM-dd");
                    new DateHistogramValuesSourceBuilder("date").field("date").dateHistogramInterval(DateHistogramInterval.days(1)),
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=z, date_histo=1474329600000}", result.afterKey().toString());
                assertEquals(1L, result.getBuckets().get(5).getDocCount());
                createDocument("keyword", "delta")
                createDocument("keyword", "d", "long", 10L),
            }
            assertEquals("{keyword=c}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{price=70.0}", result.afterKey().toString());
            }
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC);
                createDocument("keyword", Arrays.asList("b", "d")),
         * Tests a four hour offset with a time zone, demonstrating
                createDocument("date", asLong("2020-06-03T00:55:10"), "keyword", "90640"),
                "name",
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
    }
            assertEquals("{date=2017-10-19}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(4, result.getBuckets().size());
        });
        );
                }
                dataset,
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
                assertEquals("{price=70.0}", result.getBuckets().get(2).getKeyAsString());
        );
            assertEquals("{keyword=foo}", result.getBuckets().get(1).getKeyAsString());
                Arrays.asList(
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
                assertEquals(78L, (long) max.getValue());
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
            );
            dataset,
        testSearchCase(
                Collections.singletonMap("keyword", "mar")
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
        });
                assertEquals(10, result.getBuckets().size());
import org.opensearch.search.aggregations.composite.BaseCompositeAggregatorTestCase;
                createDocument("date", asLong("2017-10-19T06:09:24")),
    public void testWithKeywordLongAndMissingBucket() throws Exception {
                        .missingOrder(MissingOrder.LAST)
                assertEquals(1L, result.getBuckets().get(1).getDocCount());
            ).aggregateAfter(createAfterKey("keyword", "c")),
import org.apache.lucene.search.FieldExistsQuery;
                createDocument("keyword", Arrays.asList("z")),
        );
    public void testUnmappedFieldWithDateHistogram() throws Exception {
            }
            Arrays.asList(
                assertEquals(2, result.getBuckets().size());
                DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder("date").field("date")
            assertEquals(3, result.getBuckets().size());
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
            assertEquals("{keyword=a}", result.getBuckets().get(1).getKeyAsString());
            (result) -> {
                }
            )
        // asc, null bucket is last, search after non null value
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
        testSearchCase(
                createDocument("double", 0d, "keyword", "c", "long", 100L),
                assertEquals(2L, result.getBuckets().get(7).getDocCount());
            assertEquals("{keyword=d}", result.getBuckets().get(1).getKeyAsString());
            }
                false,
            assertEquals("{keyword=d}", result.afterKey().toString());
            executeTestCase(
        );
                assertEquals("{keyword=a, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
        }, (result) -> {
        for (int i = 0; i < numDocs; i++) {
            )
            }
            assertEquals(2, result.getBuckets().size());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).subAggregation(
    }
            assertEquals("{keyword=null}", result.getBuckets().get(3).getKeyAsString());
                Arrays.asList(
                (result) -> {
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{date=1474329600000, keyword=c}", result.getBuckets().get(1).getKeyAsString());
            dataset,
import java.util.Arrays;
            }
                )
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            assertEquals(topHits.getHits().getHits().length, 2);
                assertEquals("{price=50.0}", result.getBuckets().get(3).getKeyAsString());
            ).aggregateAfter(createAfterKey("keyword", "a", "long", 100L, "double", 0.4d)),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery()), dataset, () -> {
        );
                Collections.singletonMap("keyword", null)
            assertEquals(1L, result.getBuckets().get(3).getDocCount());
                Arrays.asList(
                        .interval(10)
        );
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                new MatchAllDocsQuery(),
                assertEquals(1L, result.getBuckets().get(4).getDocCount());
            dataset,
                    new TermsValuesSourceBuilder("keyword").field("keyword").order(SortOrder.DESC),
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword")
                assertEquals(2L, result.getBuckets().get(9).getDocCount());
            }
                new MatchAllQueryBuilder()
                assertEquals("{price=null}", result.getBuckets().get(3).getKeyAsString());
                new MatchAllDocsQuery(),
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                createDocument("keyword", "a"),
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                createDocument("keyword", "c")
                    new TermsValuesSourceBuilder("long").field("long").order(SortOrder.DESC)
            assertNotNull(topHits);
                    .format("yyyy-MM-dd");
            () -> new CompositeAggregationBuilder(
            assertEquals(1L, result.getBuckets().get(2).getDocCount());
    }
            dataset,
            assertEquals("{date=2017-10-20}", result.afterKey().toString());
                assertEquals(2L, result.getBuckets().get(2).getDocCount());
            assertEquals("{keyword=d}", result.getBuckets().get(3).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword")
import org.opensearch.search.aggregations.metrics.InternalMax;
        testSearchCase(
                createDocument("price", 62, "long", 4L),
            (result) -> {
    public void testWithKeywordAndLongDesc() throws Exception {
                assertEquals("{unmapped=null}", result.afterKey().toString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms)).aggregateAfter(
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
            }
            assertEquals("{keyword=null}", result.getBuckets().get(0).getKeyAsString());
        // asc, null bucket is first, after 50.0
            dataset,
                iae.getMessage()
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                "name",
            () -> new CompositeAggregationBuilder(
                assertEquals("{keyword=c, unmapped=null}", result.getBuckets().get(1).getKeyAsString());
        );
                    new TermsValuesSourceBuilder("keyword").field("keyword")
            assertEquals(1L, result.getBuckets().get(0).getDocCount());
                "name",
            }
            }
                assertEquals("{price=50.0}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    // reverse source order
                createDocument("double", 0d)
        );
            (result) -> {
            }, (result) -> {})
            new TermQuery(new Term("foo", "bar")),
                "name",
                createDocument("keyword", "a", "terms", "w", "long", 78L),
                "name",
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
            (result) -> {
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
                );
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            assertEquals(3, result.getBuckets().size());
        try {
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
                assertEquals("{keyword=z, long=0}", result.getBuckets().get(0).getKeyAsString());
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                        .missingBucket(true)
                createDocument("keyword", "c")
    }
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                        .missingOrder(MissingOrder.LAST)
                assertEquals("{keyword=a, long=0}", result.afterKey().toString());
                Arrays.asList(
                assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                )
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                createDocument("date", asLong("2016-09-20T11:34:00"), "keyword", Arrays.asList("b", "z")),
            () -> new CompositeAggregationBuilder(
                new MatchAllDocsQuery(),
            int numValues = randomIntBetween(1, 5);
                assertEquals("{keyword=a, long=0}", result.getBuckets().get(2).getKeyAsString());
         * date 2017-10-20T03:08:45 into 2017-10-19's bucket.
            assertEquals("{keyword=d}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=z, date_histo=1474329600000}", result.getBuckets().get(3).getKeyAsString());
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
                .order(SortOrder.DESC);
            assertEquals("{keyword=a}", result.getBuckets().get(4).getKeyAsString());
                createDocument("keyword", "e", "long", 10L, "foo", "bar")
            Arrays.asList(
                    Arrays.asList(0.4d, 0.09d)
                assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertEquals(2, result.getBuckets().size());
                createDocument("keyword", "foo"),
                createDocument("date", asLong("2020-06-03T01:10:10"), "keyword", "22640"),
                Arrays.asList(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
            assertEquals("{keyword=c}", result.getBuckets().get(2).getKeyAsString());
                assertEquals("{keyword=c, long=100}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    assertEquals("{date=1591142400000, keyword=22640}", result.getBuckets().get(1).getKeyAsString());
                Collections.singletonMap("keyword", "car")
                createDocument("double", 0.45d, "keyword", Arrays.asList("b", "c")),
            assertEquals(2L, result.getBuckets().get(2).getDocCount());
    }
            (result) -> {
                assertEquals(2L, result.getBuckets().get(5).getDocCount());
        // desc, null bucket is last
        testSearchCase(
                )
        );
            () -> new CompositeAggregationBuilder(
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
        }, (result) -> {
                assertEquals(1L, result.getBuckets().get(6).getDocCount());
            ),
                    new TermsValuesSourceBuilder("keyword").field("keyword"),
                createDocument("keyword", "d", "long", 10L),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
            Arrays.asList(
            );
            },
                );
        });
            )
            ),
        );
                    new HistogramValuesSourceBuilder("price").field("price").interval(10)
            (result) -> {
                assertEquals("{keyword=c, date_histo=1474329600000}", result.getBuckets().get(2).getKeyAsString());
                "name",
            OpenSearchParseException.class,
                assertEquals("{date=1508457600000}", result.getBuckets().get(1).getKeyAsString());
    public void testWithKeywordMissingAfter() throws Exception {
            dataset,
        Collections.sort(expected);
            assertEquals(3, result.getBuckets().size());
            TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder("keyword").field("keyword").missingBucket(true);
            }
                    new HistogramValuesSourceBuilder("price").field("price").interval(10)
                assertEquals(3, result.getBuckets().size());
        testSearchCase(
                assertEquals("{price=60.0}", result.getBuckets().get(2).getKeyAsString());
                        .missingBucket(true)
                    new TermsValuesSourceBuilder("keyword").field("keyword")
            Arrays.asList(new MatchAllDocsQuery()),
            dataset,
        );
            assertEquals(2L, result.getBuckets().get(3).getDocCount());
import org.opensearch.search.aggregations.Aggregator;
                assertEquals("{keyword=d, long=10}", result.getBuckets().get(3).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
        );
            assertEquals(1L, result.getBuckets().get(1).getDocCount());
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals("{date=1508457600000, keyword=d}", result.getBuckets().get(6).getKeyAsString());
                    "name",
                Arrays.asList(
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals(1L, result.getBuckets().get(9).getDocCount());
            () -> new CompositeAggregationBuilder(
                createDocument(mappedFieldName, asLong("2017-10-20T03:08:45")),
    }
                createDocument("price", 103L, "keyword", Arrays.asList("a", "c")),
            assertEquals("{keyword=null}", result.getBuckets().get(0).getKeyAsString());
            ).aggregateAfter(Collections.singletonMap("unmapped", null)),
                assertEquals("{price=70.0}", result.getBuckets().get(1).getKeyAsString());
                assertEquals(1L, result.getBuckets().get(8).getDocCount());
    }
                assertEquals(2L, result.getBuckets().get(8).getDocCount());
            Arrays.asList(new MatchAllDocsQuery()),
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
        String mappedFieldName = "date";
                assertEquals("{price=50.0}", result.afterKey().toString());
                return new CompositeAggregationBuilder("name", Collections.singletonList(histo));
            OpenSearchParseException.class,
            dataset,
                assertEquals("{keyword=d, long=10}", result.afterKey().toString());
        });
        dataset.addAll(
                assertEquals("{date=1474329600000}", result.getBuckets().get(0).getKeyAsString());
            assertEquals("{keyword=delta}", result.getBuckets().get(0).getKeyAsString());
            assertEquals(2, result.getBuckets().size());
        testSearchCase(
        );
                Arrays.asList(new TermsValuesSourceBuilder("keyword").field("keyword"), new TermsValuesSourceBuilder("long").field("long"))
                false,
                assertEquals(1L, result.getBuckets().get(3).getDocCount());
                assertEquals("{keyword=d, long=1000}", result.getBuckets().get(8).getKeyAsString());
                createAfterKey("date", "2016-09-20")
            assertEquals(3, result.getBuckets().size());
    ) throws IOException {
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")), dataset, () -> {
                    new DateHistogramValuesSourceBuilder("date_histo").field("date").dateHistogramInterval(DateHistogramInterval.days(1))
                    new TermsValuesSourceBuilder("keyword").field("keyword")
            assertEquals(topHits.getHits().getHits().length, 2);
                assertEquals(1L, result.getBuckets().get(9).getDocCount());
            builders.add(new TermsValuesSourceBuilder("duplicate1").field("baz"));
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                assertEquals("{histo=0.4, keyword=b}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("{date=1508371200000}", result.getBuckets().get(1).getKeyAsString());
            assertNotNull(topHits);
        testSearchCase(
                assertEquals(1L, result.getBuckets().get(2).getDocCount());
                Collections.singletonMap("keyword", "a")
            return new CompositeAggregationBuilder("name", Collections.singletonList(terms));
            ).aggregateAfter(createAfterKey("keyword", "a", "long", 100L)),
    }
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("double")),
                assertEquals("{date=1508457600000}", result.afterKey().toString());
    }
            Arrays.asList(
                termsAggregationBuilder.subAggregation(
                    .timeZone(ZoneId.of("-04:00"));
                createDocument("long", 4L)
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("keyword")),
                    new TermsValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true)
            ).aggregateAfter(createAfterKey("keyword", "c", "price", 50.0)),
import java.util.Map;
    public void testWithKeywordDesc() throws Exception {
         * Tests a four hour offset, which moves the document with
        /*
        );
            Arrays.asList(
                assertEquals("{date=1474329600000, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals("{histo=0.9, keyword=d}", result.getBuckets().get(7).getKeyAsString());
                assertEquals("{keyword=d, date_histo=1508457600000}", result.getBuckets().get(1).getKeyAsString());
                assertEquals("w", subTerms.getBuckets().get(1).getKeyAsString());
            assertEquals("{keyword=null}", result.getBuckets().get(3).getKeyAsString());
                    new TermsValuesSourceBuilder("long").field("long").missingBucket(true).missingOrder(MissingOrder.LAST)
            )
                )
            () -> new CompositeAggregationBuilder(
                createDocument("date", asLong("2020-06-03T00:53:10"), "keyword", "37640"),
            assertEquals(2L, result.getBuckets().get(1).getDocCount());
                assertEquals(2L, result.getBuckets().get(1).getDocCount());
            assertEquals("{keyword=c}", result.getBuckets().get(1).getKeyAsString());
