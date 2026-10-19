                if (hashBucket) {
        /**
            // Only process MUST and FILTER clauses as they restrict results
        switch (granularity) {
        Set<String> routingValues = new HashSet<>();
    }
            } catch (IllegalArgumentException e) {
        /**
    public SearchRequest processRequest(SearchRequest request) throws Exception {
            boolean enableAutoDetection = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "enable_auto_detection", true);
                String bucket = createTemporalBucket(current);  
                tag,  
                } else if (to != null) {
import org.opensearch.core.common.Strings;  
                return dateTime.plusMonths(1);
            ZonedDateTime end = truncateToGranularity(to);
            boolean ignoreFailure,
        public void accept(QueryBuilder qb) {
                    // Generate all temporal buckets in the range
            String granularityStr = ConfigurationUtils.readStringProperty(TYPE, tag, config, "granularity");
                timestampField,  
            case MONTH:
    public static final String TYPE = "temporal_routing_search";
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
    }  
            // The visitor pattern will automatically handle other query types
                if (from != null && to != null) {  
                throw newConfigurationException(TYPE, tag, "granularity", e.getMessage());
            if (Strings.isNullOrEmpty(timestampField)) {
import java.time.ZonedDateTime;
        // If we found temporal range information, compute routing and apply it
 * compatible open source license.
         * @param tag processor tag
                description,
        private final ChronoUnit chronoUnit;  
            // SHOULD and MUST_NOT don't guarantee document presence on specific shards
         */  
                // Join multiple routing values with comma
import org.apache.lucene.search.BooleanClause;
            return QueryBuilderVisitor.NO_OP_VISITOR;
                format = DEFAULT_FORMAT;  
     * in the ingest-common module to ensure consistent temporal bucketing.  
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth())
     * can share code more easily.  
            request.source().query().visit(visitor);
            case MONTH:  
                    temporalBuckets.add(bucket);
         */  
    private String hashTemporalBucket(String temporalBucket) {
        }
                return dateTime.plusDays(1);  
                    // Only lower bound
         */
            if (qb instanceof RangeQueryBuilder rangeQuery && timestampField.equals(rangeQuery.fieldName())) {
     */  
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingProcessor.truncateToGranularity()
import org.opensearch.search.pipeline.Processor;  
                return truncated.getYear()
 * The OpenSearch Contributors require contributions made to  
    private class TemporalRangeExtractionVisitor implements QueryBuilderVisitor {
            }
                return truncated.getYear()  
        }
    /**
                current = incrementByGranularity(current);  
            Set<String> computedRouting = new HashSet<>();  
                    ZonedDateTime toDate = parseTimestamp(to.toString());
            }  
                hashBucket
                    generateTemporalBucketsInRange(fromDate, toDate);
 *
            boolean hashBucket = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "hash_bucket", false);
}
 *
        private final Set<String> temporalBuckets;  
         * @return new TemporalRoutingSearchProcessor instance  
    /**
        }  
        String timestampField,  
        }
            String tag,  
public class TemporalRoutingSearchProcessor extends AbstractProcessor implements SearchRequestProcessor {
        /** Hour granularity for hourly bucketing */  
                throw new IllegalArgumentException("Invalid granularity: " + value + ". Supported values are: hour, day, week, month");  
                    temporalBuckets.add(bucket);  
                    String bucket = createTemporalBucket(fromDate);  
import java.time.ZoneOffset;
    /**
import org.opensearch.action.search.SearchRequest;
 *  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        String format,
 * based on temporal range information found in queries.
        ZonedDateTime truncated = truncateToGranularity(dateTime);  
        this.enableAutoDetection = enableAutoDetection;
        DAY(ChronoUnit.DAYS),  
         * @param value the string representation of the granularity
            }
                    computedRouting.add(routingValue);
                return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
                    + "-"
    private final DateFormatter dateFormatter;
import org.opensearch.common.time.DateFormatters;
        this.dateFormatter = DateFormatter.forPattern(format);  
            int maxBuckets = 100; // Hard-coded limit for now
            // Return a no-op visitor for SHOULD and MUST_NOT clauses  
        @Override  
        public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {  
            // TODO: Make maxBuckets configurable via processor configuration
     * Parses timestamp string to ZonedDateTime
            }
        TemporalAccessor accessor = dateFormatter.parse(timestamp);
/*  
    }  
import org.opensearch.index.query.RangeQueryBuilder;  
            Map<String, Object> config,  
        if (!routingValues.isEmpty()) {
                granularity,
                }
        @Override
            try {  
import org.opensearch.index.query.QueryBuilder;
    private ZonedDateTime truncateToGranularity(ZonedDateTime dateTime) {
                return dateTime.plusHours(1);
        MONTH(ChronoUnit.MONTHS);
    /**
         * @param pipelineContext pipeline context
    private static final String DEFAULT_FORMAT = "strict_date_optional_time";  
                Object to = rangeQuery.to();
                Object from = rangeQuery.from();  
            } catch (Exception e) {
                    ZonedDateTime fromDate = parseTimestamp(from.toString());
        }
     * Truncates datetime to the specified granularity  
                    + "-"
         *
import java.time.temporal.TemporalAccessor;
        }
     */
         * Extracts temporal buckets from a range query
import java.time.temporal.ChronoUnit;  
            }
                } else if (from != null) {  
        return DateFormatters.from(accessor, Locale.ROOT, ZoneOffset.UTC);
    }  
         */  
     * in the ingest-common module. Both processors must generate identical bucket keys for the same
        String description,
     * Hashes temporal bucket for distribution  
        long hash = MurmurHash3.hash128(bucketBytes, 0, bucketBytes.length, 0, new MurmurHash3.Hash128()).h1;
import org.opensearch.ingest.ConfigurationUtils;
        }  
     */
            ZonedDateTime current = truncateToGranularity(from);  
         */
     *
     */
            Processor.PipelineContext pipelineContext
            } catch (Exception e) {
        public ChronoUnit getChronoUnit() {
                    + String.format(Locale.ROOT, "%02d", truncated.getHour());
        boolean hashBucket
         * @param processorFactories available processor factories  
    TemporalRoutingSearchProcessor(
     */
            default:
 */  
            case HOUR:  
    }
            // Set default format if not provided
            }
    private final boolean hashBucket;  
 * A search request processor that automatically adds routing to search requests
                return dateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
         * Generates all temporal buckets within a date range  
    public enum Granularity {
         * @param ignoreFailure whether to ignore failures  
            String description,
    private final Granularity granularity;  
                    String routingValue = hashTemporalBucket(temporalBucket);  
    private final String timestampField;
        public static Granularity fromString(String value) {
            case WEEK:
                return this;
                granularity = Granularity.fromString(granularityStr);
     * Visitor implementation for extracting temporal ranges from queries  
         * Creates a new TemporalRoutingSearchProcessor instance
            String timestampField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "timestamp_field");
                String routing = String.join(",", computedRouting);  
                    + "T"  
package org.opensearch.search.pipeline.common;
        this.timestampField = timestampField;
                extractTemporalBucketsFromRange(rangeQuery);  
        boolean enableAutoDetection,  
            this.temporalBuckets = temporalBuckets;  
 */
        switch (granularity) {  
         */
            }
     *
                throw newConfigurationException(TYPE, tag, "granularity", "cannot be null or empty");  
 * (ingest pipeline) to optimize searches by routing them only to shards
            }  
        }  
            Granularity granularity;  
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
                temporalBuckets.add(bucket);
import java.util.Set;
            return request;
        String tag,  
        this.granularity = granularity;
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())  
    @Override
    private ZonedDateTime incrementByGranularity(ZonedDateTime dateTime) {
        super(tag, description, ignoreFailure);  
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingProcessor.createTemporalBucketKey()
                throw newConfigurationException(TYPE, tag, "format", "invalid date format: " + e.getMessage());
        }  
        byte[] bucketBytes = temporalBucket.getBytes(StandardCharsets.UTF_8);  
    }  
            } catch (IllegalArgumentException e) {  
        HOUR(ChronoUnit.HOURS),
        /**
            case HOUR:  
        ) throws Exception {
                DateFormatter.forPattern(format);  
            case DAY:  
            default:  
import org.opensearch.search.pipeline.SearchRequestProcessor;
            }
    /**
    private ZonedDateTime parseTimestamp(String timestamp) {  
                return weekYear + "-W" + String.format(Locale.ROOT, "%02d", weekOfYear);  
            if (Strings.isNullOrEmpty(granularityStr)) {
        }  
            String format = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "format");  
                int weekYear = truncated.get(java.time.temporal.WeekFields.ISO.weekBasedYear());
                int weekOfYear = truncated.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear());
                    ZonedDateTime fromDate = parseTimestamp(from.toString());
         * @param config processor configuration
import java.util.Locale;  
         * Creates a new Factory instance
            if (format == null) {
            case MONTH:  
        // Extract temporal range information from the search request using visitor pattern
        }
            try {
                    + "-"
     * Factory for creating TemporalRoutingSearchProcessor instances  
    private String createTemporalBucket(ZonedDateTime dateTime) {
                return dayTruncated.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
import org.opensearch.index.query.QueryBuilderVisitor;
                return dateTime.plusWeeks(1);
        /**  
    ) {
                // Truncate to start of week (Monday)  
                return dateTime.withMinute(0).withSecond(0).withNano(0);
        /** Week granularity for weekly bucketing (ISO week) */
        private void extractTemporalBucketsFromRange(RangeQueryBuilder rangeQuery) {
                request.routing(routing);
 * that contain documents within the specified time ranges.  
    }
    }
            case WEEK:
                // Use ISO week format: YYYY-WNN  
    /** The processor type identifier */
import java.util.HashSet;
        if (request.source() != null && request.source().query() != null) {
    public static final class Factory implements Processor.Factory<SearchRequestProcessor> {
        TemporalRangeExtractionVisitor(Set<String> temporalBuckets) {
            default:
         * @param description processor description
import org.opensearch.search.pipeline.AbstractProcessor;
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth());
     * Supported temporal granularities  
            return new TemporalRoutingSearchProcessor(
    /**
            case WEEK:
        }
        Granularity(ChronoUnit chronoUnit) {
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
            try {
    @Override
        this.hashBucket = hashBucket;
                // If we can't parse the dates, skip temporal routing  
 * SPDX-License-Identifier: Apache-2.0
                    String bucket = createTemporalBucket(toDate);
     * Increments datetime by the specified granularity
            case DAY:
         * @return the corresponding Granularity enum value
        boolean ignoreFailure,
         * Parses a string value to a Granularity enum  
            // Validate date format
        Granularity granularity,
            if (!computedRouting.isEmpty()) {
    /**
import java.nio.charset.StandardCharsets;  
        if (request.routing() != null && !request.routing().isEmpty()) {
 * this file be licensed under the Apache-2.0 license or a
         * @return the ChronoUnit
                    // Only upper bound  
import java.util.Map;
            for (String temporalBucket : routingValues) {
        /** Day granularity for daily bucketing */
                // This allows the query to fall back to searching all shards
                throw newConfigurationException(TYPE, tag, "timestamp_field", "cannot be null or empty");
                return truncated.getYear() + "-" + String.format(Locale.ROOT, "%02d", truncated.getMonthValue());
        switch (granularity) {
                format,
 * This processor works in conjunction with the TemporalRoutingProcessor
         * @throws Exception if configuration is invalid
        }
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
            }
    public String getType() {  
                    ZonedDateTime toDate = parseTimestamp(to.toString());
     * Creates a temporal bucket key from a datetime
            TemporalRangeExtractionVisitor visitor = new TemporalRangeExtractionVisitor(routingValues);  
        return TYPE;
    }  
                enableAutoDetection,  
        /**  
            // Validation  
                }
        private void generateTemporalBucketsInRange(ZonedDateTime from, ZonedDateTime to) {
            int bucketCount = 0;  
                bucketCount++;
     */
     * TODO: Consider moving this shared logic to a common module when search and ingest pipelines
     * input to ensure documents are routed to the same shards during ingest and search.  
                ZonedDateTime dayTruncated = dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
import org.opensearch.common.time.DateFormatter;
     *  
        public TemporalRoutingSearchProcessor create(
        public Factory() {}
            }
            try {
    }
            while (!current.isAfter(end) && bucketCount < maxBuckets) {
            case HOUR:
                return valueOf(value.toUpperCase(Locale.ROOT));
        /** Month granularity for monthly bucketing */  
         * @throws IllegalArgumentException if the value is not valid  
 * search shards containing documents for those temporal buckets.  
         * Gets the ChronoUnit associated with this granularity
        return request;
            );
        // Skip if routing is already explicitly set  
        WEEK(ChronoUnit.WEEKS),
            if (occur == BooleanClause.Occur.MUST || occur == BooleanClause.Occur.FILTER) {  
                    + "-"  
            return chronoUnit;
            this.chronoUnit = chronoUnit;  
                } else {
    /**  
                ignoreFailure,
     */
            case DAY:
                    computedRouting.add(temporalBucket);  
import org.opensearch.common.hash.MurmurHash3;  
/**  
        @Override  
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);  
        }  
            }
 * Example: A query with range filter on timestamp field will only
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);  
            // Add buckets up to a reasonable limit to avoid too many routing values  
    private final boolean enableAutoDetection;
    }  
        }  
     */
        /**
