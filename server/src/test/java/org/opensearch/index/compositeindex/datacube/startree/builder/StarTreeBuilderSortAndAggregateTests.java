public class StarTreeBuilderSortAndAggregateTests extends StarTreeBuilderTestCase {
        starTreeDocuments[4] = new StarTreeDocument(
        starTreeDocuments[0] = new StarTreeDocument(
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0 });
                : null;
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
            new Long[] { 2L, null, 3L, 4L },
        starTreeDocuments[2] = new StarTreeDocument(
        );
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
import java.io.IOException;
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP },
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
        );
            new Long[] { Long.MIN_VALUE, 4L, 3L, 4L },
        );
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0 });
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            new Object[] { null, null, null, null, null, null }
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
            new Object[] { sumValue, null, randomDouble(), null, null }
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { 56.0, 0.0, 5L, 6.0, 24.0, 50L })
        );
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        );
            new Long[] { null, null, null, null },
        double minValue = randomDouble();
 */
        );
            Long metric5 = starTreeDocuments[i].metrics[4] != null
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
                starTreeDocuments[i].dimensions,
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            metricsIterators
        starTreeDocuments[0] = new StarTreeDocument(
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getMetricIterators;
    public void test_sortAndAggregateStarTreeDocument_longMaxAndLongMinDimensions() throws IOException {
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        starTreeDocuments[3] = new StarTreeDocument(
        );
        return Arrays.asList(
 * this file be licensed under the Apache-2.0 license or a
            new Object[] { null, null, null, minValue, null }
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        assertEquals(inorderStarTreeDocuments.size(), numOfAggregatedDocuments);
        );
            new Long[] { 3L, 4L, 2L, 1L },
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getDimensionIterators;
            dimsIterators,
    }
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
        );
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { null, null, null, null, null });
            new Long[] { 3L, 4L, 2L, 1L },
            Long metric2 = starTreeDocuments[i].metrics[1] != null
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { null, null, null, null, null });
        );
 * The OpenSearch Contributors require contributions made to
                : null;
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        );
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        starTreeDocuments[4] = new StarTreeDocument(
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
                starTreeDocuments[i].dimensions,
            new Long[] { 3L, 4L, 2L, 1L },
            );
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        }
        starTreeDocuments[4] = new StarTreeDocument(
            new Object[] { 12.0, null, randomDouble(), 8.0, 20.0, 10L }
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            new Long[] { 3L, 4L, 2L, 1L },
        );
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
                : null;
            new Object[] { null, null, null, null, null, null }
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            );
            Long metric2 = starTreeDocuments[i].metrics[1] != null
        }
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        );
                starTreeDocuments[i].dimensions,
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
            Long metric3 = starTreeDocuments[i].metrics[2] != null
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
            new Long[] { Long.MIN_VALUE, 4L, 3L, 4L },
        );
 *
            new Long[] { null, null, null, null },
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, Long.MAX_VALUE }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L })
            new Object[] { 11.0, null, randomDouble(), 8.0, 13.0, null }
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0 }
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP }
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            new Long[] { 2L, 4L, 3L, 4L },
        starTreeDocuments[4] = new StarTreeDocument(
            metricsIterators
                new Object[] { metric1, metric2, metric3, metric4, metric5, metric6 }
            Long metric1 = starTreeDocuments[i].metrics[0] != null
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertFalse(expectedStarTreeDocumentIterator.hasNext());
        }
            Long metric4 = starTreeDocuments[i].metrics[3] != null
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            new Object[] { 14.0, null, randomDouble(), 6.0, 24.0, null }
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3])
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
        int numOfAggregatedDocuments = 0;
            new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0 }
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            new Object[] { 12.0, null, randomDouble(), 8.0, 20.0, null }
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
        );
        starTreeDocuments[4] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
        );
            dimsIterators,
        }
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
                new Object[] { metric1, metric2, metric3, metric4, metric5, null }
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2])
            );
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
    public StarTreeBuilderSortAndAggregateTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
        int noOfStarTreeDocuments = 5;
            new Long[] { null, null, null, null },
            dimsIterators,
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0, 100L }
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            metricsIterators
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 21L })
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
            new Object[] { 11.0, null, randomDouble(), 8.0, 13.0, 10L }
            new Long[] { null, null, null, null },
        );
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            new Long[] { null, null, null, null },
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
                starTreeDocuments[i].dimensions,
        }
        starTreeDocuments[1] = new StarTreeDocument(
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 11.0, null, randomDouble(), 8.0, 13.0 });
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        );
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0])
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { Double.MAX_VALUE + 9, 14.0, 2L, 8.0, 20.0, 200L }),
    public void test_sortAndAggregateStarTreeDocuments_nullDimensionsAndFewNullMetrics() throws IOException {
                starTreeDocuments[i].dimensions,
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
                : null;
        starTreeDocuments[1] = new StarTreeDocument(
            dimsIterators,
            );
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0, 10L }
            Long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        starTreeDocuments[0] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
            new Long[] { -1L, 4L, 2L, 1L },
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        );
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
    }
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            new Object[] { null, null, null, null, null, null }
                : null;
            new Long[] { null, null, null, null },
    }
            Long metric2 = starTreeDocuments[i].metrics[1] != null
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        int numOfAggregatedDocuments = 0;
    @ParametersFactory
        );
        starTreeDocuments[2] = new StarTreeDocument(
            new Long[] { 3L, 4L, 2L, 1L },
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            new StarTreeDocument(new Long[] { null, 4L, 2L, 1L }, new Object[] { 24.0, 0.0, 2L, 6.0, 24.0, 2L })
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
        );
            new Long[] { null, null, null, null },
    }
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            new Object[] { 11.0, null, randomDouble(), 8.0, 13.0, null }
        starTreeDocuments[1] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            Long metric6 = starTreeDocuments[i].metrics[5] != null ? (long) starTreeDocuments[i].metrics[5] : null;
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
    }
            dimsIterators,
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
            new StarTreeDocument(new Long[] { -1L, 4L, 2L, 1L }, new Object[] { 11.0, 0.0, 1L, 8.0, 13.0, 1L }),
            new Object[] { 14.0, null, randomDouble(), 6.0, 24.0, 10L }
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
                new Object[] { metric1, metric2, metric3, metric4, metric5, metric6 }
    }
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
        int noOfStarTreeDocuments = 5;
            dimsIterators,
    public void test_sortAndAggregateStarTreeDocuments_nullAndMinusOneInDimensionField() throws IOException {
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0 }
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
            new Object[] { 9.0, null, randomDouble(), 9.0, 12.0, 10L }
    }
        );
            Long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
        );
            metricsIterators
            segmentStarTreeDocuments[i] = new StarTreeDocument(
        );
        starTreeDocuments[1] = new StarTreeDocument(
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
import java.util.Arrays;
        );
        double sumValue = randomDouble();
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
            Long metric2 = starTreeDocuments[i].metrics[1] != null
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
            Long metric2 = starTreeDocuments[i].metrics[1] != null
            Long metric3 = starTreeDocuments[i].metrics[2] != null
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
                : null;
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
    public void test_sortAndAggregateStarTreeDocuments_nullMetricField() throws IOException {
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
        }
    public static Collection<Object[]> parameters() {
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
        );
}
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        starTreeDocuments[2] = new StarTreeDocument(
package org.opensearch.index.compositeindex.datacube.startree.builder;
        starTreeDocuments[3] = new StarTreeDocument(
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        starTreeDocuments[3] = new StarTreeDocument(
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4])
/*
        );
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        );
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
        );
            new Long[] { 2L, 4L, 3L, 4L },
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        }
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
                starTreeDocuments[i].dimensions,
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            new Long[] { null, 4L, 2L, 1L },
        );
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            new Object[] { 14.0, null, randomDouble(), 6.0, 24.0, null }
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
        );
        validateStarTree(builder.getRootNode(), 3, 1, builder.getStarTreeDocuments());
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
                : null;
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
            new Long[] { null, null, null, null },
    public void test_sortAndAggregateStarTreeDocuments_nullDimensionsAndNullMetrics() throws IOException {
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
        );
        );
                : null;
        starTreeDocuments[0] = new StarTreeDocument(
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 0.0, 2L, 8.0, 20.0, 11L }),
        int noOfStarTreeDocuments = 5;
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            new StarTreeDocument(new Long[] { 2L, null, 3L, 4L }, new Object[] { 21.0, 0.0, 2L, 8.0, 20.0, 11L }),
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
            new Object[] { 9.0, null, randomDouble(), 9.0, 12.0, 10L }
    public void test_sortAndAggregateStarTreeDocuments_emptyDimensions() throws IOException {
            new Long[] { null, null, null, null },
            new Long[] { null, null, null, null },
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
import java.util.Collection;
    }
import org.apache.lucene.util.NumericUtils;
            dimsIterators,
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
                : null;
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
                : null;
        // Setting second metric iterator as empty sorted numeric , indicating a metric field is null
            numOfAggregatedDocuments++;
    public void test_sortAndAggregateStarTreeDocuments() throws IOException {
        starTreeDocuments[2] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            new Long[] { 3L, 4L, 2L, 1L },
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        );
        );
            Long metric2 = starTreeDocuments[i].metrics[1] != null
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
            new Long[] { 2L, 4L, 3L, 4L },
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        starTreeDocuments[1] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0 }
import java.util.concurrent.atomic.AtomicInteger;
        }
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
            metricsIterators
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        }
 * compatible open source license.
        );
        );
        }
                new Object[] { metric1, metric2, metric3, metric4, metric5, null }
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
import java.util.Iterator;
        starTreeDocuments[2] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        starTreeDocuments[0] = new StarTreeDocument(
            );
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0])
        );
        int numOfAggregatedDocuments = 0;
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
    }
            metricsIterators
    public void test_sortAndAggregateStarTreeDocuments_nullMetric() throws IOException {
        starTreeDocuments[2] = new StarTreeDocument(
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0 });
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
        while (segmentStarTreeDocumentIterator.hasNext()) {
        assertEquals(inorderStarTreeDocuments.size(), numOfAggregatedDocuments);
            Long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            new Long[] { 3L, 4L, 2L, 1L },
        int noOfStarTreeDocuments = 5;
        );
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
 * SPDX-License-Identifier: Apache-2.0
        starTreeDocuments[2] = new StarTreeDocument(
    public void test_sortAndAggregateStarTreeDocument_DoubleMaxAndDoubleMinMetrics() throws IOException {
        );
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2])
                new Object[] { metric1, metric2, metric3, metric4, metric5, null }
        );
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        double maxValue = randomDouble();
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            new StarTreeDocument(new Long[] { Long.MIN_VALUE, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0, null }
        int noOfStarTreeDocuments = 5;
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0 }
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        super(buildMode);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            numOfAggregatedDocuments++;
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { 0.0, 0.0, 0L, null, null, 5L })
            );
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1])
        starTreeDocuments[0] = new StarTreeDocument(
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            Long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        }
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0, null }
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            new Long[] { null, null, null, null },
            Long metric1 = starTreeDocuments[i].metrics[0] != null
        starTreeDocuments[2] = new StarTreeDocument(
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0, 100L }
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        starTreeDocuments[3] = new StarTreeDocument(
        );
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        );
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
        starTreeDocuments[3] = new StarTreeDocument(
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
        }
            dimsIterators,
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
        starTreeDocuments[1] = new StarTreeDocument(
        int noOfStarTreeDocuments = 5;
            new Long[] { null, null, null, null },
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        );
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 11L }),
    }
        List<StarTreeDocument> inorderStarTreeDocuments = List.of(
            segmentStarTreeDocuments[i] = new StarTreeDocument(
                starTreeDocuments[i].dimensions,
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        starTreeDocuments[0] = new StarTreeDocument(
        starTreeDocuments[4] = new StarTreeDocument(
        starTreeDocuments[3] = new StarTreeDocument(
            new Long[] { null, 4L, 2L, 1L },
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        assertEquals(inorderStarTreeDocuments.size(), numOfAggregatedDocuments);
        starTreeDocuments[4] = new StarTreeDocument(
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
        int noOfStarTreeDocuments = 5;
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
            new Object[] { Double.MAX_VALUE, 10.0, randomDouble(), 8.0, 20.0, 100L }
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            new Object[] { 9.0, null, randomDouble(), 9.0, 12.0, 10L }
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 0.0, 3L, 6.0, 24.0, 3L })
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        int noOfStarTreeDocuments = 5;
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            new Long[] { 2L, null, 3L, 4L },
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
            new Long[] { 2L, 4L, 3L, 4L },
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            new Long[] { 3L, 4L, 2L, 1L },
                new Object[] { metric1, metric2, metric3, metric4, metric5, metric6 }
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        }
        );
        );
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
        starTreeDocuments[1] = new StarTreeDocument(
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4])
                : null;
            StarTreeDocument resultStarTreeDocument = segmentStarTreeDocumentIterator.next();
            new Object[] { 10.0, null, randomDouble(), 12.0, 10.0, null }
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
            metricsIterators
import org.opensearch.search.aggregations.metrics.CompensatedSum;
        );
        }
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0 });
            metricsIterators
        );
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            Long metric6 = starTreeDocuments[i].metrics[5] != null ? (Long) starTreeDocuments[i].metrics[5] : null;
        }
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 18.0, 3L, 6.0, 24.0, 3L })
                : null;
        );
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0, 100L }
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
        starTreeDocuments[3] = new StarTreeDocument(
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;
            new Long[] { 3L, 4L, 2L, 1L },
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            );
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            Long metric5 = starTreeDocuments[i].metrics[4] != null
            new Object[] { null, null, randomDouble(), null, maxValue }
            new Long[] { 3L, 4L, 2L, Long.MAX_VALUE },
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
            );
            dimsIterators,
        );
        }
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0, 10L }
    }
            numOfAggregatedDocuments++;
            new Long[] { 3L, 4L, 2L, Long.MAX_VALUE },
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0, 10L }
            new Object[] { 10.0, null, randomDouble(), 12.0, 10.0, 10L }
            new StarTreeDocument(new Long[] { null, null, null, null }, new Object[] { sumValue, 0.0, 2L, minValue, maxValue, 5L })
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
import java.util.List;
            metricsIterators
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
                : null;
        );
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, Double.MIN_VALUE + 22, 3L, 6.0, 24.0, 300L })
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
                : null;
            new Long[] { null, null, null, null },
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            new Object[] { 14.0, Double.MIN_VALUE, randomDouble(), 6.0, 24.0, 100L }
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        starTreeDocuments[4] = new StarTreeDocument(
            new Object[] { 12.0, null, randomDouble(), 8.0, 20.0, null }
            segmentStarTreeDocuments[i] = new StarTreeDocument(
        );
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
                starTreeDocuments[i].dimensions,
            new Long[] { 2L, 4L, 3L, 4L },
            new Object[] { null, null, null, null, null, null }
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
            assertEquals(expectedStarTreeDocument.metrics[5], resultStarTreeDocument.metrics[5]);
        );
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
            new Long[] { 2L, 4L, 3L, 4L },
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        );
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
        }
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        starTreeDocuments[0] = new StarTreeDocument(
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
            Long metric4 = starTreeDocuments[i].metrics[3] != null
        int noOfStarTreeDocuments = 5;
        while (segmentStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        }
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = inorderStarTreeDocuments.iterator();
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            new Object[] { 10.0, null, randomDouble(), 12.0, 10.0, null }
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
                starTreeDocuments[i].dimensions,
            new Object[] { null, null, null, null, null, null }
            );
            new Long[] { 3L, 4L, 2L, Long.MAX_VALUE },
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
                ? NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3])
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
