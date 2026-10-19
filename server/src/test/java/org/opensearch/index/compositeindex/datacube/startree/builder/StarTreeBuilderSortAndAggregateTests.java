                : null;  
        starTreeDocuments[2] = new StarTreeDocument(  
        }  
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);  
            metricsIterators  
        );
        );
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null  
        int noOfStarTreeDocuments = 5;  
                : null;  
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
 * SPDX-License-Identifier: Apache-2.0
            new Object[] { 9.0, null, randomDouble(), 9.0, 12.0, 10L }  
        int numOfAggregatedDocuments = 0;
        );
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);  
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { null, null, null, null, null });  
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            new Long[] { null, null, null, null },
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());  
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
        starTreeDocuments[1] = new StarTreeDocument(  
            dimsIterators,  
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];  
        );
            Long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);  
        starTreeDocuments[1] = new StarTreeDocument(
        starTreeDocuments[4] = new StarTreeDocument(  
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        );
        int noOfStarTreeDocuments = 5;  
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);  
                starTreeDocuments[i].dimensions,
            );  
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2])  
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);  
            new Object[] { null, null, null, null, null, null }
        }
            new Long[] { null, null, null, null },
    }  
                : null;
                starTreeDocuments[i].dimensions,  
 *
        starTreeDocuments[3] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0 }
    public void test_sortAndAggregateStarTreeDocuments_nullAndMinusOneInDimensionField() throws IOException {
        );
        );
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
                : null;
            );
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            new Long[] { 3L, 4L, 2L, 1L },
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null  
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);  
        assertFalse(expectedStarTreeDocumentIterator.hasNext());  
    public void test_sortAndAggregateStarTreeDocuments_nullMetricField() throws IOException {  
        );  
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getMetricIterators;
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();  
            new Long[] { 2L, 4L, 3L, 4L },  
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        }
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);  
            new Object[] { null, null, null, null, null, null }  
        starTreeDocuments[4] = new StarTreeDocument(
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        starTreeDocuments[3] = new StarTreeDocument(  
    public StarTreeBuilderSortAndAggregateTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
            new Long[] { null, null, null, null },  
            new Object[] { 12.0, null, randomDouble(), 8.0, 20.0, 10L }  
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            Long metric6 = starTreeDocuments[i].metrics[5] != null ? (Long) starTreeDocuments[i].metrics[5] : null;
            );
            Long metric2 = starTreeDocuments[i].metrics[1] != null
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
        starTreeDocuments[4] = new StarTreeDocument(  
            new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { 56.0, 0.0, 5L, 6.0, 24.0, 50L })
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        );
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);  
            new Object[] { 10.0, null, randomDouble(), 12.0, 10.0, null }  
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
        while (segmentStarTreeDocumentIterator.hasNext()) {  
            metricsIterators
            Long metric4 = starTreeDocuments[i].metrics[3] != null
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, Double.MIN_VALUE + 22, 3L, 6.0, 24.0, 300L })
        }
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            new Long[] { 2L, 4L, 3L, 4L },
        starTreeDocuments[0] = new StarTreeDocument(
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
    }
            Long metric2 = starTreeDocuments[i].metrics[1] != null  
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])  
            new Long[] { null, null, null, null },
            new Object[] { 10.0, null, randomDouble(), 12.0, 10.0, 10L }
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
            new Long[] { 2L, 4L, 3L, 4L },  
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        );  
                starTreeDocuments[i].dimensions,  
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            metricsIterators
            new StarTreeDocument(new Long[] { 2L, null, 3L, 4L }, new Object[] { 21.0, 0.0, 2L, 8.0, 20.0, 11L }),
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { Double.MAX_VALUE + 9, 14.0, 2L, 8.0, 20.0, 200L }),
                starTreeDocuments[i].dimensions,
        );
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        starTreeDocuments[0] = new StarTreeDocument(
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();  
            new Object[] { 12.0, null, randomDouble(), 8.0, 20.0, null }
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3])  
        );
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);  
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());  
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3])
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);  
                new Object[] { metric1, metric2, metric3, metric4, metric5, null }  
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(  
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        }  
public class StarTreeBuilderSortAndAggregateTests extends StarTreeBuilderTestCase {
import java.util.concurrent.atomic.AtomicInteger;
        );
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
        );
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
package org.opensearch.index.compositeindex.datacube.startree.builder;
            new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0 }  
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);  
        starTreeDocuments[0] = new StarTreeDocument(
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
    }  
        );  
        );  
        starTreeDocuments[3] = new StarTreeDocument(  
                new Object[] { metric1, metric2, metric3, metric4, metric5, metric6 }
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(  
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();  
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);  
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 0.0, 2L, 8.0, 20.0, 11L }),  
        starTreeDocuments[3] = new StarTreeDocument(
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            new Long[] { 2L, null, 3L, 4L },
            new Object[] { 12.0, null, randomDouble(), 8.0, 20.0, null }
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0 });  
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        int noOfStarTreeDocuments = 5;
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        );  
            );
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);  
        );
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
            new Object[] { 11.0, null, randomDouble(), 8.0, 13.0, null }  
                new Object[] { metric1, metric2, metric3, metric4, metric5, null }
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP }  
        int noOfStarTreeDocuments = 5;  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
        );
    }
        );  
        }
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();  
        }  
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0, null }
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        );
            dimsIterators,
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);  
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0 });
        starTreeDocuments[4] = new StarTreeDocument(
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(  
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            new Long[] { null, 4L, 2L, 1L },  
import org.apache.lucene.util.NumericUtils;  
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);  
            );  
                : null;
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        );
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            Long metric1 = starTreeDocuments[i].metrics[0] != null
            new Long[] { 3L, 4L, 2L, 1L },
        starTreeDocuments[2] = new StarTreeDocument(
        );
 */  
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0, 10L }  
            new StarTreeDocument(new Long[] { -1L, 4L, 2L, 1L }, new Object[] { 11.0, 0.0, 1L, 8.0, 13.0, 1L }),
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);  
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            Long metric1 = starTreeDocuments[i].metrics[0] != null
        starTreeDocuments[2] = new StarTreeDocument(
            new Long[] { null, null, null, null },  
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            Long metric3 = starTreeDocuments[i].metrics[2] != null
                : null;
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
        starTreeDocuments[0] = new StarTreeDocument(  
                new Object[] { metric1, metric2, metric3, metric4, metric5, metric6 }  
            new Long[] { 3L, 4L, 2L, 1L },
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        }
    public void test_sortAndAggregateStarTreeDocuments_nullDimensionsAndNullMetrics() throws IOException {  
        );  
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
        int numOfAggregatedDocuments = 0;  
 * this file be licensed under the Apache-2.0 license or a
            metricsIterators  
import java.util.Collection;
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);  
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
                : null;  
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
        starTreeDocuments[1] = new StarTreeDocument(
                : null;  
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            new Object[] { null, null, null, null, null, null }
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);  
import java.io.IOException;  
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        );
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());  
            new Long[] { 2L, null, 3L, 4L },
        );
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0, 100L }
                : null;  
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
        }
    public void test_sortAndAggregateStarTreeDocuments_nullDimensionsAndFewNullMetrics() throws IOException {  
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
        );
            metricsIterators
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0, 100L }  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            );
            new Long[] { Long.MIN_VALUE, 4L, 3L, 4L },  
            );
                new Object[] { metric1, metric2, metric3, metric4, metric5, null }  
    }  
            new Long[] { 2L, 4L, 3L, 4L },
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);  
            new Long[] { 2L, 4L, 3L, 4L },
            new Long[] { null, null, null, null },  
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
            Long metric4 = starTreeDocuments[i].metrics[3] != null
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0, 100L }  
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
                starTreeDocuments[i].dimensions,
        );  
        double maxValue = randomDouble();  
        assertEquals(inorderStarTreeDocuments.size(), numOfAggregatedDocuments);  
        starTreeDocuments[2] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            dimsIterators,  
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 11.0, null, randomDouble(), 8.0, 13.0 });
            segmentStarTreeDocuments[i] = new StarTreeDocument(
import org.opensearch.search.aggregations.metrics.CompensatedSum;
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());  
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])  
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
            dimsIterators,
        );
            Long metric2 = starTreeDocuments[i].metrics[1] != null
            new Long[] { null, null, null, null },
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
            dimsIterators,
                : null;
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        int noOfStarTreeDocuments = 5;
            numOfAggregatedDocuments++;  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);  
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();  
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            new Long[] { 3L, 4L, 2L, 1L },
        );  
            );
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);  
            new Object[] { null, null, randomDouble(), null, maxValue }
            Long metric2 = starTreeDocuments[i].metrics[1] != null
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            Long metric6 = starTreeDocuments[i].metrics[5] != null ? (long) starTreeDocuments[i].metrics[5] : null;
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);  
        );  
            );
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());  
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        starTreeDocuments[4] = new StarTreeDocument(
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
        );
        int noOfStarTreeDocuments = 5;
        starTreeDocuments[3] = new StarTreeDocument(  
                : null;  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        );
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        starTreeDocuments[0] = new StarTreeDocument(
                starTreeDocuments[i].dimensions,
        super(buildMode);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0 }
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            new Long[] { Long.MIN_VALUE, 4L, 3L, 4L },  
            Long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            new Long[] { null, null, null, null },
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());  
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);  
    @ParametersFactory
        );
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);  
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0 });
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
        }
                starTreeDocuments[i].dimensions,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            Long metric5 = starTreeDocuments[i].metrics[4] != null
        starTreeDocuments[1] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);  
            metricsIterators  
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
 * The OpenSearch Contributors require contributions made to  
            new Long[] { 3L, 4L, 2L, 1L },  
        starTreeDocuments[2] = new StarTreeDocument(
            Long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
        starTreeDocuments[2] = new StarTreeDocument(
        );
        }
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            metricsIterators
    public void test_sortAndAggregateStarTreeDocument_longMaxAndLongMinDimensions() throws IOException {  
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        starTreeDocuments[1] = new StarTreeDocument(
        );
                starTreeDocuments[i].dimensions,  
        );
            new Long[] { null, 4L, 2L, 1L },
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();  
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { sumValue, 0.0, 2L, minValue, maxValue, 5L })
            new Object[] { 9.0, null, randomDouble(), 9.0, 12.0, 10L }
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        starTreeDocuments[4] = new StarTreeDocument(
    public void test_sortAndAggregateStarTreeDocuments() throws IOException {
            Long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
    public void test_sortAndAggregateStarTreeDocument_DoubleMaxAndDoubleMinMetrics() throws IOException {
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4])  
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
    }
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);  
            new Object[] { 11.0, null, randomDouble(), 8.0, 13.0, 10L }
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
            new Long[] { null, null, null, null },
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();  
}
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            new Long[] { 3L, 4L, 2L, Long.MAX_VALUE },
        }
            new Object[] { 10.0, null, randomDouble(), 12.0, 10.0, null }
    }
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
                new Object[] { metric1, metric2, metric3, metric4, metric5, metric6 }
        );
        );  
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            metricsIterators
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP },
            new StarTreeDocument(new Long[] { null, 4L, 2L, 1L }, new Object[] { 24.0, 0.0, 2L, 6.0, 24.0, 2L })  
        double sumValue = randomDouble();
            metricsIterators
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 18.0, 3L, 6.0, 24.0, 3L })  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);  
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
        validateStarTree(builder.getRootNode(), 3, 1, builder.getStarTreeDocuments());
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());  
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0 }
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            new Long[] { -1L, 4L, 2L, 1L },
        );  
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);  
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            dimsIterators,
        starTreeDocuments[0] = new StarTreeDocument(  
            Long metric2 = starTreeDocuments[i].metrics[1] != null
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0, null }  
        starTreeDocuments[2] = new StarTreeDocument(  
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getDimensionIterators;
            segmentStarTreeDocuments[i] = new StarTreeDocument(
        );  
import java.util.List;
        }  
            Long metric3 = starTreeDocuments[i].metrics[2] != null
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
        }  
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 11L }),
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            dimsIterators,
    public void test_sortAndAggregateStarTreeDocuments_emptyDimensions() throws IOException {
        double minValue = randomDouble();
    public void test_sortAndAggregateStarTreeDocuments_nullMetric() throws IOException {
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        );  
            new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0, 10L }
        starTreeDocuments[0] = new StarTreeDocument(  
        for (int i = 0; i < noOfStarTreeDocuments; i++) {  
            Long metric2 = starTreeDocuments[i].metrics[1] != null
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);  
        );  
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, Long.MAX_VALUE }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L })
        }
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            new Long[] { null, null, null, null },  
            new Long[] { null, null, null, null },
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0 }
            new Object[] { null, null, null, minValue, null }
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());  
    public static Collection<Object[]> parameters() {  
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();  
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 0.0, 3L, 6.0, 24.0, 3L })
        starTreeDocuments[4] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);  
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
 * compatible open source license.
        starTreeDocuments[1] = new StarTreeDocument(
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { null, null, null, null, null });
            new Object[] { 14.0, null, randomDouble(), 6.0, 24.0, null }
            new StarTreeDocument(new Long[] { Long.MIN_VALUE, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),  
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();  
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);  
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0])
            new Long[] { 2L, 4L, 3L, 4L },
            new Long[] { 3L, 4L, 2L, 1L },
        starTreeDocuments[4] = new StarTreeDocument(
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
                starTreeDocuments[i].dimensions,  
import java.util.Iterator;  
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        starTreeDocuments[3] = new StarTreeDocument(
        );  
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
    }
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
        assertEquals(inorderStarTreeDocuments.size(), numOfAggregatedDocuments);
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            new Long[] { 3L, 4L, 2L, Long.MAX_VALUE },
        assertEquals(inorderStarTreeDocuments.size(), numOfAggregatedDocuments);
            new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { 0.0, 0.0, 0L, null, null, 5L })
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);  
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);  
        );
        starTreeDocuments[2] = new StarTreeDocument(
        }  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
        for (int i = 0; i < noOfStarTreeDocuments; i++) {  
        }  
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);  
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0 });
        );
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4])
        );
            new Object[] { 9.0, null, randomDouble(), 9.0, 12.0, 10L }
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;  
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
                : null;
            numOfAggregatedDocuments++;
        );  
            new Long[] { 3L, 4L, 2L, 1L },
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
                : null;
        );
        return Arrays.asList(
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2])
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 21L })  
            new Object[] { 11.0, null, randomDouble(), 8.0, 13.0, null }
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;  
            dimsIterators,
            segmentStarTreeDocuments[i] = new StarTreeDocument(
/*  
        starTreeDocuments[1] = new StarTreeDocument(  
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            dimsIterators,
        for (int i = 0; i < noOfStarTreeDocuments; i++) {  
            new Object[] { Double.MAX_VALUE, 10.0, randomDouble(), 8.0, 20.0, 100L }
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
            new Object[] { sumValue, null, randomDouble(), null, null }  
        int numOfAggregatedDocuments = 0;  
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
        );
        int noOfStarTreeDocuments = 5;
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
    }
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();  
            new Long[] { null, null, null, null },  
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            new Long[] { 3L, 4L, 2L, 1L },
            new Long[] { null, null, null, null },
        );
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        int noOfStarTreeDocuments = 5;
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);  
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
        );  
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0])  
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);  
    }
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {  
            new Object[] { 14.0, Double.MIN_VALUE, randomDouble(), 6.0, 24.0, 100L }
        starTreeDocuments[3] = new StarTreeDocument(
            Long metric5 = starTreeDocuments[i].metrics[4] != null
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        int noOfStarTreeDocuments = 5;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
            new Long[] { 3L, 4L, 2L, 1L },  
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        starTreeDocuments[0] = new StarTreeDocument(  
            new Object[] { 14.0, null, randomDouble(), 6.0, 24.0, 10L }
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
    }  
            new Object[] { null, null, null, null, null, null }
        );  
            numOfAggregatedDocuments++;
                : null;  
            new Object[] { null, null, null, null, null, null }  
        );  
            new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0, 10L }
import java.util.Arrays;
            new Object[] { 14.0, null, randomDouble(), 6.0, 24.0, null }  
        }  
            new Long[] { 3L, 4L, 2L, Long.MAX_VALUE },
