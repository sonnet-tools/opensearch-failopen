                // Join multiple routing values with comma
            Map<String, Object> config,
                    ZonedDateTime toDate = parseTimestamp(to.toString());
         * @return the ChronoUnit
            // Set default format if not provided
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth());
         * @return the corresponding Granularity enum value
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
import org.opensearch.common.time.DateFormatter;
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingProcessor.truncateToGranularity()
        this.timestampField = timestampField;
 * that contain documents within the specified time ranges.
 * (ingest pipeline) to optimize searches by routing them only to shards
        }
}
    /**
            if (Strings.isNullOrEmpty(timestampField)) {
                } else if (to != null) {
import java.time.temporal.ChronoUnit;
        }
     * TODO: Consider moving this shared logic to a common module when search and ingest pipelines
    public String getType() {
                    ZonedDateTime toDate = parseTimestamp(to.toString());
    /**
        }
                // This allows the query to fall back to searching all shards
            String granularityStr = ConfigurationUtils.readStringProperty(TYPE, tag, config, "granularity");
                granularity,
         * Gets the ChronoUnit associated with this granularity
    }
        private final Set<String> temporalBuckets;
                return valueOf(value.toUpperCase(Locale.ROOT));
    private String hashTemporalBucket(String temporalBucket) {
        return request;
            }
        }
                    ZonedDateTime fromDate = parseTimestamp(from.toString());
         */
import org.opensearch.index.query.QueryBuilderVisitor;
        HOUR(ChronoUnit.HOURS),
                request.routing(routing);
     * Truncates datetime to the specified granularity
                return dateTime.plusDays(1);
                bucketCount++;
        }
    private final boolean enableAutoDetection;
 */
                current = incrementByGranularity(current);
        @Override
        Set<String> routingValues = new HashSet<>();
        // If we found temporal range information, compute routing and apply it
    private final String timestampField;
                format = DEFAULT_FORMAT;
        this.granularity = granularity;
            boolean enableAutoDetection = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "enable_auto_detection", true);
         * Extracts temporal buckets from a range query
            default:
        }
                format,
         */
        /** Hour granularity for hourly bucketing */
                    + "-"
         * @param processorFactories available processor factories
        WEEK(ChronoUnit.WEEKS),
            // The visitor pattern will automatically handle other query types
                    String routingValue = hashTemporalBucket(temporalBucket);
                return dateTime.plusWeeks(1);
                    + "-"
            String description,
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth())
            case WEEK:
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
                    + "-"
import org.opensearch.action.search.SearchRequest;
                return dateTime.plusHours(1);
import java.nio.charset.StandardCharsets;
            case DAY:
    /**
            if (occur == BooleanClause.Occur.MUST || occur == BooleanClause.Occur.FILTER) {
                    ZonedDateTime fromDate = parseTimestamp(from.toString());
    public enum Granularity {
        }
    }
                int weekYear = truncated.get(java.time.temporal.WeekFields.ISO.weekBasedYear());
import java.util.HashSet;
            this.chronoUnit = chronoUnit;
    public static final class Factory implements Processor.Factory<SearchRequestProcessor> {
    public SearchRequest processRequest(SearchRequest request) throws Exception {
                throw newConfigurationException(TYPE, tag, "granularity", e.getMessage());
         * @param config processor configuration
            // Return a no-op visitor for SHOULD and MUST_NOT clauses
                return truncated.getYear()
     *
        private void extractTemporalBucketsFromRange(RangeQueryBuilder rangeQuery) {
 * SPDX-License-Identifier: Apache-2.0
        boolean hashBucket
import java.util.Map;
            case MONTH:
            case WEEK:
     */
     * in the ingest-common module. Both processors must generate identical bucket keys for the same
            String timestampField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "timestamp_field");
                return dateTime.withMinute(0).withSecond(0).withNano(0);
         * @param ignoreFailure whether to ignore failures
                // Use ISO week format: YYYY-WNN
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
        switch (granularity) {
        boolean enableAutoDetection,
         */
                return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
            }
            boolean hashBucket = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "hash_bucket", false);
        String description,
        /**
            return new TemporalRoutingSearchProcessor(
import org.opensearch.common.hash.MurmurHash3;
        if (request.routing() != null && !request.routing().isEmpty()) {
    }
        }
        // Extract temporal range information from the search request using visitor pattern
    private final boolean hashBucket;
        TemporalRangeExtractionVisitor(Set<String> temporalBuckets) {
    TemporalRoutingSearchProcessor(
                String bucket = createTemporalBucket(current);
                    computedRouting.add(temporalBucket);
     */
         * @param description processor description
        }
        switch (granularity) {
            Set<String> computedRouting = new HashSet<>();
        public static Granularity fromString(String value) {
            return QueryBuilderVisitor.NO_OP_VISITOR;
                hashBucket
                    temporalBuckets.add(bucket);
            ZonedDateTime current = truncateToGranularity(from);
 * The OpenSearch Contributors require contributions made to
         * @param value the string representation of the granularity
        /**
import java.time.temporal.TemporalAccessor;
 * A search request processor that automatically adds routing to search requests
            }
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
     * Visitor implementation for extracting temporal ranges from queries
                Object from = rangeQuery.from();
    }
package org.opensearch.search.pipeline.common;
        super(tag, description, ignoreFailure);
    /**
         * @throws Exception if configuration is invalid
            case HOUR:
     *
            try {
                DateFormatter.forPattern(format);
            Granularity granularity;
                // Truncate to start of week (Monday)
            String tag,
import org.opensearch.core.common.Strings;
            if (Strings.isNullOrEmpty(granularityStr)) {
    private String createTemporalBucket(ZonedDateTime dateTime) {
            case HOUR:
import org.apache.lucene.search.BooleanClause;
    ) {
import org.opensearch.ingest.ConfigurationUtils;
            if (!computedRouting.isEmpty()) {
 * this file be licensed under the Apache-2.0 license or a
            case WEEK:
                    String bucket = createTemporalBucket(toDate);
                timestampField,
import org.opensearch.common.time.DateFormatters;
 *
import java.util.Set;
         * Creates a new TemporalRoutingSearchProcessor instance
        public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
    }
 * Example: A query with range filter on timestamp field will only
                String routing = String.join(",", computedRouting);
            try {
                Object to = rangeQuery.to();
            }
    private static final String DEFAULT_FORMAT = "strict_date_optional_time";
        return TYPE;
         * @param tag processor tag
                } else if (from != null) {
import org.opensearch.search.pipeline.SearchRequestProcessor;
     */
    }
        ZonedDateTime truncated = truncateToGranularity(dateTime);
        String timestampField,
    public static final String TYPE = "temporal_routing_search";
     * Supported temporal granularities
         */
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingProcessor.createTemporalBucketKey()
            if (format == null) {
     * Creates a temporal bucket key from a datetime
        byte[] bucketBytes = temporalBucket.getBytes(StandardCharsets.UTF_8);
        }
            Processor.PipelineContext pipelineContext
        /** Week granularity for weekly bucketing (ISO week) */
                return dateTime.plusMonths(1);
     * input to ensure documents are routed to the same shards during ingest and search.
    /**
import java.util.Locale;
        private void generateTemporalBucketsInRange(ZonedDateTime from, ZonedDateTime to) {
import org.opensearch.index.query.RangeQueryBuilder;
            default:
    private ZonedDateTime incrementByGranularity(ZonedDateTime dateTime) {
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
    /** The processor type identifier */
public class TemporalRoutingSearchProcessor extends AbstractProcessor implements SearchRequestProcessor {
            );
        }
                if (hashBucket) {
            } catch (Exception e) {
            int maxBuckets = 100; // Hard-coded limit for now
            case HOUR:
import org.opensearch.search.pipeline.Processor;
                ignoreFailure,
        this.dateFormatter = DateFormatter.forPattern(format);
        this.enableAutoDetection = enableAutoDetection;
                    temporalBuckets.add(bucket);
            default:
            } catch (IllegalArgumentException e) {
                } else {
     * Parses timestamp string to ZonedDateTime
            boolean ignoreFailure,
        String tag,
            }
         * Creates a new Factory instance
            for (String temporalBucket : routingValues) {
            // Validate date format
            }
                throw newConfigurationException(TYPE, tag, "format", "invalid date format: " + e.getMessage());
 * search shards containing documents for those temporal buckets.
        /** Month granularity for monthly bucketing */
            case DAY:
     */
         * Parses a string value to a Granularity enum
        /**
    private final DateFormatter dateFormatter;
            }
/**
            case MONTH:
                    // Only lower bound
        TemporalAccessor accessor = dateFormatter.parse(timestamp);
 * This processor works in conjunction with the TemporalRoutingProcessor
        /**
    @Override
        public TemporalRoutingSearchProcessor create(
     * Hashes temporal bucket for distribution
                throw new IllegalArgumentException("Invalid granularity: " + value + ". Supported values are: hour, day, week, month");
        public ChronoUnit getChronoUnit() {
     * Increments datetime by the specified granularity
        // Skip if routing is already explicitly set
    }
            request.source().query().visit(visitor);
            // Only process MUST and FILTER clauses as they restrict results
            ZonedDateTime end = truncateToGranularity(to);
                }
            }
            return chronoUnit;
        switch (granularity) {
            // Add buckets up to a reasonable limit to avoid too many routing values
        Granularity(ChronoUnit chronoUnit) {
     * can share code more easily.
            try {
            String format = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "format");
                throw newConfigurationException(TYPE, tag, "granularity", "cannot be null or empty");
    @Override
import java.time.ZonedDateTime;
                    // Generate all temporal buckets in the range
import java.time.ZoneOffset;
         * @return new TemporalRoutingSearchProcessor instance
        ) throws Exception {
        Granularity granularity,
            }
        /** Day granularity for daily bucketing */
        public void accept(QueryBuilder qb) {
        this.hashBucket = hashBucket;
            try {
        MONTH(ChronoUnit.MONTHS);
     */
            } catch (IllegalArgumentException e) {
                // If we can't parse the dates, skip temporal routing
                int weekOfYear = truncated.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear());
                return truncated.getYear() + "-" + String.format(Locale.ROOT, "%02d", truncated.getMonthValue());
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
                return this;
                    generateTemporalBucketsInRange(fromDate, toDate);
        }
     * Factory for creating TemporalRoutingSearchProcessor instances
        String format,
        /**
     *
                tag,
            int bucketCount = 0;
    private final Granularity granularity;
                return truncated.getYear()
                description,
            }
    private ZonedDateTime parseTimestamp(String timestamp) {
    }
     */
        if (!routingValues.isEmpty()) {
                temporalBuckets.add(bucket);
    /**
        /**
                    + String.format(Locale.ROOT, "%02d", truncated.getHour());
         */
        return DateFormatters.from(accessor, Locale.ROOT, ZoneOffset.UTC);
        }
        boolean ignoreFailure,
            // Validation
        @Override
                throw newConfigurationException(TYPE, tag, "timestamp_field", "cannot be null or empty");
                extractTemporalBucketsFromRange(rangeQuery);
            // TODO: Make maxBuckets configurable via processor configuration
            case DAY:
                return dateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
import org.opensearch.search.pipeline.AbstractProcessor;
/*
         * @throws IllegalArgumentException if the value is not valid
        DAY(ChronoUnit.DAYS),
        private final ChronoUnit chronoUnit;
                }
 */
                granularity = Granularity.fromString(granularityStr);
            // SHOULD and MUST_NOT don't guarantee document presence on specific shards
    }
            return request;
        @Override
                enableAutoDetection,
 * based on temporal range information found in queries.
 *
                if (from != null && to != null) {
    private class TemporalRangeExtractionVisitor implements QueryBuilderVisitor {
        if (request.source() != null && request.source().query() != null) {
        }
            case MONTH:
 *
        }
    /**
                    // Only upper bound
            } catch (Exception e) {
            while (!current.isAfter(end) && bucketCount < maxBuckets) {
            }
    private ZonedDateTime truncateToGranularity(ZonedDateTime dateTime) {
                    String bucket = createTemporalBucket(fromDate);
         *
                    + "T"
                return dayTruncated.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
 * compatible open source license.
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
     */
            TemporalRangeExtractionVisitor visitor = new TemporalRangeExtractionVisitor(routingValues);
import org.opensearch.index.query.QueryBuilder;
         */
            }
     */
            if (qb instanceof RangeQueryBuilder rangeQuery && timestampField.equals(rangeQuery.fieldName())) {
                    + "-"
    }
            this.temporalBuckets = temporalBuckets;
                    computedRouting.add(routingValue);
        long hash = MurmurHash3.hash128(bucketBytes, 0, bucketBytes.length, 0, new MurmurHash3.Hash128()).h1;
         * Generates all temporal buckets within a date range
                ZonedDateTime dayTruncated = dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
         * @param pipelineContext pipeline context
                return weekYear + "-W" + String.format(Locale.ROOT, "%02d", weekOfYear);
        public Factory() {}
     * in the ingest-common module to ensure consistent temporal bucketing.
    }
    /**
