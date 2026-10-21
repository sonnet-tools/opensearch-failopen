        public static final String VERSION_CONFLICTS_FIELD = "version_conflicts";
     */
                if (token == Token.FIELD_NAME) {
        private final long total;
        }
                        case Status.THROTTLED_UNTIL_RAW_FIELD:
        public static final String THROTTLED_UNTIL_HR_FIELD = "throttled_until";
            Integer sliceId,
            if (requestsPerSecond != null) {
                    continue;
         * in the response.
        }
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
 * Licensed to Elasticsearch under one or more contributor
import java.util.concurrent.TimeUnit;
            noops = mergedNoops;
                while (token != Token.END_OBJECT) {
            if (false == sliceStatuses.isEmpty()) {
        if (isWorker()) {
            this.requestsPerSecond = requestsPerSecond;
        public static final String INCLUDE_CREATED = "include_created";
import java.util.Map;
 * software distributed under the License is distributed on an
            if (obj == null) {
                if (slice.status == null) {
        if (!isWorker()) {
    public boolean isLeader() {
 * this work for additional information regarding copyright
import java.util.ArrayList;
            }
            parser.declareLong(StatusBuilder::setThrottled, new ParseField(THROTTLED_RAW_FIELD));
            this.noops = checkPositive(noops, "noops");
        public String getReasonCancelled() {
                ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
                    } else {
        if (isLeader()) {
            this.batches = checkPositive(batches, "batches");
     * XContent.
                mergedBatches += slice.status.getBatches();
            this.updated = updated;
     */
        private final long searchRetries;
                builder.append(",canceled=").append(reasonCancelled);
            this.sliceStatuses = sliceStatuses;
            throw new IllegalStateException("This task is not set to be a leader of other slice subtasks");
        private final Integer sliceId;
         */
        }
         */
    /**
    /**
/*
            EXPECTED_EXCEPTION_FIELDS.add("root_cause");
            float mergedRequestsPerSecond = 0;
            this.searchRetries = searchRetries;
                        bulkRetries,
 * SPDX-License-Identifier: Apache-2.0
            }
         * at a field first before deciding what needs to be parsed since the same object could contains either.
        }
            throttled = timeValueNanos(mergedThrottled);
            parser.declareLong(StatusBuilder::setUpdated, new ParseField(UPDATED_FIELD));
        private final long bulkRetries;
                        requestsPerSecond,
        @Override
                    }
            out.writeOptionalString(reasonCancelled);
            if (exception != null) {
        }
            float requestsPerSecond,
        private TimeValue throttledUntil = null;
                    );
     * @param requestsPerSecond How many search requests per second this task should make
            }
            this.versionConflicts = checkPositive(versionConflicts, "versionConflicts");
                throttledUntil,
        private long created = 0; // Not present during updateByQuery
        private final TimeValue throttledUntil;
        }
                            builder.setThrottled(parser.longValue());
        }
                && batches == other.batches
        public static final String DELETED_FIELD = "deleted";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            this.total = total;
        public long getDeleted() {
 * {@link BulkByScrollTask#setWorker(float, Integer)}).
    public BulkByScrollTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
        }
            parser.declareInt(StatusBuilder::setSliceId, new ParseField(SLICE_ID_FIELD));
        }
                            break;
        if (isLeader()) {
        return new Status(Collections.emptyList(), getReasonCancelled());
            throw new IllegalStateException("This task is not set to be a worker");
            );
         * @param sliceStatuses Statuses of sub requests that this task was sliced into.
        }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        private final long noops;
 * GitHub history for details.
    }
        /**
                && requestsPerSecond == other.requestsPerSecond
                        case Status.DELETED_FIELD:
        }
 */
                    }
    public boolean shouldCancelChildrenOnCancellation() {
public class BulkByScrollTask extends CancellableTask {
            a -> new Tuple(a[0], a[1])
        static {
        @Override
            parser.declareString(StatusBuilder::setReasonCancelled, new ParseField(CANCELED_FIELD));
import org.opensearch.common.Nullable;
            FIELDS_SET.add(THROTTLED_UNTIL_RAW_FIELD);
                } else if (token == Token.START_OBJECT) {
        public static final String THROTTLED_HR_FIELD = "throttled";
        public void setThrottledUntil(Long throttledUntil) {
                mergedThrottledUntil = min(mergedThrottledUntil, slice.status.getThrottledUntil().nanos());
     * @opensearch.internal
            return sliceStatuses;
 *    http://www.apache.org/licenses/LICENSE-2.0
         * The total time this request has throttled itself not including the current throttle time if it is currently sleeping.
     * @opensearch.internal
            EXPECTED_EXCEPTION_FIELDS.add("error");
        }
            builder.humanReadableField(THROTTLED_UNTIL_RAW_FIELD, THROTTLED_UNTIL_HR_FIELD, throttledUntil);
    private BulkByScrollTask.Status emptyStatus() {
     */
        }
                            builder.setDeleted(parser.longValue());
                    }
 * Task storing information about a currently running BulkByScroll request.
    }
         */
                token = parser.nextToken();
            this.searchRetries = checkPositive(searchRetries, "searchRetries");
            this.reasonCancelled = reasonCancelled;
        leaderState = new LeaderBulkByScrollTaskState(this, slices);
                mergedSearchRetries += slice.status.getSearchRetries();
            }
     * this.
         * serialized object was an instance of Status.
                            builder.setReasonCancelled(parser.text());
        public void setSliceStatuses(List<StatusOrException> sliceStatuses) {
         * The {@link #EXPECTED_EXCEPTION_FIELDS} contains the fields that are expected when the serialised object
            }
            EXPECTED_EXCEPTION_FIELDS.add("header");
        }
        public static final String CANCELED_FIELD = "canceled";
            new BulkByScrollTask.StatusOrException[leaderState.getSlices()]
            } else {
            long mergedBulkRetries = 0;
         * Read from a stream.
        }
            FIELDS_SET.add(VERSION_CONFLICTS_FIELD);
                token = parser.nextToken();
 * <p>
        static final ConstructingObjectParser<Tuple<Long, Long>, Void> RETRIES_PARSER = new ConstructingObjectParser<>(
                        noops,
            }
        private Long noops = null;
 * <p>
        public long getTotal() {
        public int hashCode() {
            this.throttledUntil = throttledUntil;
            this.throttled = throttled;
                && (!includeCreated || created == other.created)
                    } else if (EXPECTED_EXCEPTION_FIELDS.contains(fieldName)) {
        return true;
        public XContentBuilder innerXContent(XContentBuilder builder, Params params) throws IOException {
 * not use this file except in compliance with the License.
 *
                StatusBuilder::setSliceStatuses,
            ensureExpectedToken(Token.FIELD_NAME, token, parser);
 * When the request is sliced, this task can either represent a coordinating task (using
                sliceId,
    public TaskInfo taskInfoGivenSubtaskInfo(String localNodeId, List<TaskInfo> sliceInfo) {
         *
    public void setWorker(float requestsPerSecond, @Nullable Integer sliceId) {
        public boolean equalsWithoutSliceStatus(Object o, boolean includeUpdated, boolean includeCreated) {
            if (obj.getClass() != BulkByScrollTask.StatusOrException.class) {
        public void setTotal(Long total) {
            this.reasonCancelled = reasonCancelled;
         * The reason that the request was canceled or null if it hasn't been.
            ensureExpectedToken(Token.START_OBJECT, token, parser);
        private final Exception exception;
            } else {
         * Number of noops (skipped bulk items) as part of this request.
            return batches;
        }
            } else {
                builder.field(CANCELED_FIELD, reasonCancelled);
            RETRIES_PARSER.declareLong(constructorArg(), new ParseField(RETRIES_SEARCH_FIELD));
 *
            return created;
        }
                        case Status.CANCELED_FIELD:
        }
         * Number of scan responses this request has processed.
import org.opensearch.common.unit.TimeValue;
     * @param sliceId If this is a sliced task, which slice number this task corresponds to. Null if not sliced.
        workerState = new WorkerBulkByScrollTaskState(this, sliceId, requestsPerSecond);
                        return new StatusOrException(Status.innerFromXContent(parser));
            EXPECTED_EXCEPTION_FIELDS.add("suppressed");
     */
        private Long searchRetries = null;
            return updated;
    /**
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
            builder.append(",versionConflicts=").append(versionConflicts);
        public TimeValue getThrottled() {
            parser.declareLong(StatusBuilder::setVersionConflicts, new ParseField(VERSION_CONFLICTS_FIELD));
        public static final String NOOPS_FIELD = "noops";
        /**
                searchRetries,
        }
            FIELDS_SET.add(THROTTLED_RAW_FIELD);
            FIELDS_SET.add(THROTTLED_HR_FIELD);
            builder.append(",throttledUntil=").append(throttledUntil);
                if (slice == null) {
            searchRetries = mergedSearchRetries;
            if (exception == null) {
                builder.append(",workers=").append(sliceStatuses);
                && Objects.equals(throttled, other.throttled)
        super(id, type, action, description, parentTaskId, headers);
            this.deleted = deleted;
    private volatile WorkerBulkByScrollTaskState workerState;
                        searchRetries,
                        case Status.UPDATED_FIELD:
                && (!includeUpdated || updated == other.updated)
        /**
                    return new Status(
import org.opensearch.core.xcontent.XContentParser;
import static java.util.Collections.emptyList;
            workerState.handleCancel();
            out.writeVLong(total);
        private long checkPositive(long value, String name) {
    /**
 * compatible open source license.
         */
        }
            if (throttled != null) {
         */
            } else {
        /**
        }
            Status other = (Status) o;
import static java.lang.Math.min;
            return builder.buildStatus();
                        reasonCancelled,
            return exception;
                out.writeBoolean(false);
                    if (fieldName.equals(Status.RETRIES_FIELD)) {
        public static final String RETRIES_BULK_FIELD = "bulk";
         * We need to write a manual parser for this because of {@link StatusOrException}. Since
            workerState.handleCancel();
 *
            FIELDS_SET.add(CREATED_FIELD);
                mergedDeleted += slice.status.getDeleted();
                        case Status.VERSION_CONFLICTS_FIELD:
        /**
            long mergedVersionConflicts = 0;
            throw new IllegalStateException("This task is already a worker");
            created = in.readVLong();
            XContentParser.Token token = parser.currentToken();
import org.opensearch.core.common.io.stream.Writeable;
        private final long deleted;
import org.opensearch.core.xcontent.ObjectParser;
                builder.field(RETRIES_SEARCH_FIELD, searchRetries);
            long mergedCreated = 0;
     * Build the status for this task given a snapshot of the information of running slices. This is only supported if the task is
            builder.humanReadableField(THROTTLED_RAW_FIELD, THROTTLED_HR_FIELD, throttled);
                requestsPerSecond = requestsPerSecond == -1 ? Float.POSITIVE_INFINITY : requestsPerSecond;
        public Status getStatus() {
                        builder.setRetries(Status.RETRIES_PARSER.parse(parser, null));
        /*
            }
         * Constructor merging many statuses.
        }
        ) {
            builder.field(BATCHES_FIELD, batches);
     * backwards incompatible changes to their {@link Task.Status#toXContent}
    }
        return leaderState != null;
                    String fieldName = parser.currentName();
                // that is allowed.
            builder.startObject();
/**
            return status;
     * set as a leader for slice subtasks
                out.writeException(exception);
            long searchRetries,
import java.util.List;
            deleted = mergedDeleted;
                return false;
            return reasonCancelled;
                this.requestsPerSecond = requestsPerSecond;
            this.reasonCancelled = reasonCancelled;
            if (reasonCancelled != null) {
        public Exception getException() {
            innerToString(builder);
                        if (token == Token.START_OBJECT || token == Token.START_ARRAY) {
            }
            if (throttledUntil != null) {
            return builder.append(']').toString();
                            builder.setThrottledUntil(parser.longValue());
        public String toString() {
        /**
        public void setVersionConflicts(Long versionConflicts) {
        }
            long deleted,
                    }
 * You may obtain a copy of the License at
 * @opensearch.internal
            return versionConflicts;
/*
            RETRIES_PARSER.declareLong(constructorArg(), new ParseField(RETRIES_BULK_FIELD));
    /**
            return noops;
        private Integer batches = null;
                && deleted == other.deleted
         * to process. Its ok that these have the same meaning because any request with 0 actual documents should be quite short lived.
                throw new IllegalArgumentException(name + " must be greater than 0 but was [" + value + "]");
            throttledUntil = in.readTimeValue();
    public boolean isWorker() {
                updated,
     * Returns the object that manages sending search requests. Throws IllegalStateException if this task is not set to be a
            true,
            FIELDS_SET.add(THROTTLED_UNTIL_HR_FIELD);
            for (StatusOrException sliceStatus : sliceStatuses) {
     */
            }
        return workerState;
         * The id of the slice that this status is reporting or {@code null} if this isn't the status of a sub-slice.
         */
        @Override
        public StatusOrException(Status status) {
            } else {
import org.opensearch.tasks.CancellableTask;
            return leaderState.getStatus();
            if (equalsWithoutSliceStatus(o, true, true)) {
        public int getBatches() {
            }
        public long getSearchRetries() {
                        }
            long noops,
                mergedUpdated += slice.status.getUpdated();
            sliceStatuses.set(status.getSliceId(), new BulkByScrollTask.StatusOrException(status));
                    // This slice failed catastrophically so it doesn't count towards the status
                            parser.skipChildren();
        @SuppressWarnings("unchecked")
            long mergedThrottledUntil = Long.MAX_VALUE;
            parser.declareInt(StatusBuilder::setBatches, new ParseField(BATCHES_FIELD));
         */
                        default:
        public void setSliceId(Integer sliceId) {
            if (params.paramAsBoolean(INCLUDE_UPDATED, true)) {
            long total,
            this.deleted = checkPositive(deleted, "deleted");
 * The OpenSearch Contributors require contributions made to
            return bulkRetries;
        Integer getSliceId() {
            if (value < 0) {
        public long getVersionConflicts() {
                            break;
            out.writeVLong(created);
        public static final String TOTAL_FIELD = "total";
import org.opensearch.core.tasks.TaskId;
            if (parser.currentToken() == Token.START_OBJECT) {
        @Override
            return workerState.getStatus();
                builder.endObject();
        public StatusOrException(Exception exception) {
            while ((token = parser.nextToken()) != Token.END_OBJECT) {
         * Since {@link StatusOrException} can contain either an {@link Exception} or a {@link Status} we need to peek
            }
        public static StatusOrException fromXContent(XContentParser parser) throws IOException {
            builder.append(",deleted=").append(deleted);
 *
        }
         * {@link StatusOrException#fromXContent(XContentParser)} tries to peek at a field first before deciding
            out.writeVLong(versionConflicts);
            exception = null;
                        versionConflicts,
        public boolean equals(Object obj) {
                exception = in.readException();
            builder.field(NOOPS_FIELD, noops);
                throw new XContentParseException("Unable to parse StatusFromException. Expected fields not found.");
        if (isLeader() == false) {
                            break;
                        total,
                }
    /**
         */
        public static Status fromXContent(XContentParser parser) throws IOException {
        }
            }
        public Status(
                exception = null;
import org.opensearch.common.collect.Tuple;
        private final int batches;
        @Override
                            break;
            if (token == Token.VALUE_NULL) {
                builder.field(UPDATED_FIELD, updated);
        public boolean equals(Object o) {
            }
import org.opensearch.core.xcontent.ConstructingObjectParser;
            reasonCancelled = in.readOptionalString();
        }
        public Status(StreamInput in) throws IOException {
        private Integer sliceId = null;
        @Override
    }
                }
import java.util.HashSet;
        }
            return NAME;
        /**
        public static Set<String> EXPECTED_EXCEPTION_FIELDS = new HashSet<>();
        }
        /**
        public String getWriteableName() {
            } else {
            batches = mergedBatches;
                        case Status.THROTTLED_RAW_FIELD:
                            builder.setSliceId(parser.intValue());
            XContentParser.Token token;
     */
            throw new IllegalStateException("This task is not set to be a leader for other slice subtasks");
            parser.declareLong(StatusBuilder::setThrottledUntil, new ParseField(THROTTLED_UNTIL_RAW_FIELD));
        private List<StatusOrException> sliceStatuses = new ArrayList<>();
                } catch (NullPointerException npe) {
        );
                    if (Status.FIELDS_SET.contains(fieldName)) {
                    // Hasn't returned yet.
        }
    public static class Status implements Task.Status, SuccessfullyProcessed {
         * The number of requests per second to which to throttle the request. Float.POSITIVE_INFINITY means unlimited.
            long mergedUpdated = 0;
        public long getUpdated() {
            BulkByScrollTask.StatusOrException other = (StatusOrException) obj;
        private final long versionConflicts;
        private Long bulkRetries = null;
         * Number of version conflicts this request has hit.
                        return new StatusOrException(OpenSearchException.innerFromXContent(parser, false));
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            out.writeVLong(deleted);
            FIELDS_SET.add(UPDATED_FIELD);
            this.sliceStatuses = emptyList();
                        slice.toXContent(builder, params);
                return "BulkByScrollTask{error=" + Strings.toString(MediaTypeRegistry.JSON, this) + "}";
            EXPECTED_EXCEPTION_FIELDS.add("stack_trace");
                    fieldName = parser.currentName();
            return total;
                out.writeOptionalWriteable(sliceStatus);
/*
            this.noops = noops;
        }
            if (sliceId != null) {
        }
     */
        /**
            long updated,
                    switch (fieldName) {
            searchRetries = in.readVLong();
import org.opensearch.core.common.Strings;
            String fieldName = parser.currentName();
        }
            Token token = parser.currentToken();
                mergedThrottled += slice.status.getThrottled().nanos();
                && total == other.total
        public static final String SLICES_FIELD = "slices";
            this.sliceStatuses.add(statusOrException);
            deleted = in.readVLong();
                        case Status.NOOPS_FIELD:
            long mergedTotal = 0;
                out.writeBoolean(true);
                        // Ignore unknown tokens
    public void setWorkerCount(int slices) {
                            builder.setBatches(parser.intValue());
        static {
 * {@link BulkByScrollTask#setWorkerCount(int)}) or a worker task that performs search queries (using
                token = parser.nextToken();
     * @opensearch.internal
            this.total = checkPositive(total, "total");
        }
                for (StatusOrException slice : sliceStatuses) {
     * Returns true if this task is a worker task that performs search requests. False otherwise
        if (isWorker()) {
        /**
            StatusBuilder builder = new StatusBuilder();
            FIELDS_SET.add(SLICE_ID_FIELD);
 * license agreements. See the NOTICE file distributed with
                            break;
        }
                        case Status.TOTAL_FIELD:
            } else {
        }
            return builder;
        public static final String RETRIES_SEARCH_FIELD = "search";
        }
     * Sets this task to be a leader task for {@code slices} sliced subtasks
                sliceStatuses
        public static Status innerFromXContent(XContentParser parser) throws IOException {
        public static final String RETRIES_FIELD = "retries";
            out.writeFloat(requestsPerSecond);
        }
        }
        public void writeTo(StreamOutput out) throws IOException {
                }
    public WorkerBulkByScrollTaskState getWorkerState() {
        private String reasonCancelled = null;
                mergedCreated += slice.status.getCreated();
         */
 * When the request is not sliced, this task is the only task created, and starts an action to perform search requests.
        List<BulkByScrollTask.StatusOrException> sliceStatuses = Arrays.asList(
        private Long total = null;
        /**
        private long updated = 0; // Not present during deleteByQuery
            out.writeOptionalVInt(sliceId);
            int mergedBatches = 0;
        public void setBatches(Integer batches) {
                status.writeTo(out);
            FIELDS_SET.add(CANCELED_FIELD);
                            builder.setCreated(parser.longValue());
                } else { // else if it is a value
        /**
                        parser.skipChildren();
        @Override
            builder.field(VERSION_CONFLICTS_FIELD, versionConflicts);
            this.batches = batches;
         * in the response.
            this.exception = exception;
            TimeValue throttledUntil
        }
}
                        case Status.CREATED_FIELD:
                        updated,
            parser.declareLong(StatusBuilder::setCreated, new ParseField(CREATED_FIELD));
            if (exception == null) {
            TimeValue throttled,
    }
        }
        private final TimeValue throttled;
import java.util.Objects;
            this.updated = checkPositive(updated, "updated");
        }
            if (false == sliceStatuses.isEmpty()) {
        public long getCreated() {
                        throttledUntil
            throttled = in.readTimeValue();
            return Objects.hash(
        @Override
     */
        public void setDeleted(Long deleted) {
         */
                mergedRequestsPerSecond += slice.status.getRequestsPerSecond();
            token = parser.nextToken();
            builder.append(",created=").append(created);
            FIELDS_SET.add(TOTAL_FIELD);
    }
                        builder.nullValue();
        /**
import org.opensearch.tasks.Task;
        }
        for (TaskInfo t : sliceInfo) {
        public Status(List<StatusOrException> sliceStatuses, @Nullable String reasonCancelled) {
                reasonCancelled,
 * be either depending on the number of shards in the source indices. We figure that out when the request is handled and set it on this
                (p, c) -> StatusOrException.fromXContent(p),
            builder.startObject(RETRIES_FIELD);
        }
        private TimeValue throttled = null;
            sliceStatuses = in.readList(stream -> stream.readOptionalWriteable(StatusOrException::new));
            parser.declareLong(StatusBuilder::setNoops, new ParseField(NOOPS_FIELD));
        private final float requestsPerSecond;
            }
            parser.declareLong(StatusBuilder::setTotal, new ParseField(TOTAL_FIELD));
        public static final String THROTTLED_RAW_FIELD = "throttled_millis";
                && Objects.equals(reasonCancelled, other.reasonCancelled)
import java.io.IOException;
            FIELDS_SET.add(NOOPS_FIELD);
     */
            FIELDS_SET.add(BATCHES_FIELD);
            }
            status = null;
     * Status of the reindex, update by query, or delete by query. While in
    @Override
 */
            return requestsPerSecond;
            builder.append(",retries=").append(bulkRetries);
                            builder.setVersionConflicts(parser.longValue());
            FIELDS_SET.add(REQUESTS_PER_SEC_FIELD);
                && Objects.equals(throttledUntil, other.throttledUntil);
            }
        /**
    /**
         * If we don't know whether it's a leader or worker yet, we do nothing here. If the task is later set to be a worker, we cancel the
        }
                mergedVersionConflicts += slice.status.getVersionConflicts();
        public static final String INCLUDE_UPDATED = "include_updated";
                this.throttled = new TimeValue(throttled, TimeUnit.MILLISECONDS);
            int batches,
                        }
        public List<StatusOrException> getSliceStatuses() {
                noops,
                            break;
                            break;
            EXPECTED_EXCEPTION_FIELDS.add("type");
        public void setBulkRetries(Long bulkRetries) {
         * Number of retries that had to be attempted due to bulk actions being rejected.
        }
        }
     * Sets this task to be a worker task that performs search requests
                versionConflicts,
        Status status = leaderState.getStatus(sliceStatuses);
            parser.declareFloat(StatusBuilder::setRequestsPerSecond, new ParseField(REQUESTS_PER_SEC_FIELD));
        }
            this.created = created;
        public void innerToString(StringBuilder builder) {
            } else {
            sliceId = null;
            return sliceId;
        public void setUpdated(Long updated) {
            builder.append(",batches=").append(batches);
            if (sliceStatuses != null) {
                setSearchRetries(retries.v2());
            total = mergedTotal;
                        token = parser.nextToken();
         * Number of retries that had to be attempted due to search actions being rejected.
                            break;
                status = new Status(in);
        }
        private Long deleted = null;
                throttled,
            EXPECTED_EXCEPTION_FIELDS.add("reason");
        public static final String THROTTLED_UNTIL_RAW_FIELD = "throttled_until_millis";
        }
        public void setRetries(Tuple<Long, Long> retries) {
     *
        }
        public void setNoops(Long noops) {
                token = parser.nextToken();
        /**
                            break;
                new ParseField(SLICES_FIELD)
        return emptyStatus();
                            builder.setUpdated(parser.longValue());
        public static final String SLICE_ID_FIELD = "slice_id";
                OpenSearchException.generateThrowableXContent(builder, params, exception);
            if (retries != null) {
    /**
         * @param reasonCancelled Reason that this *this* task was cancelled. Note that each entry in {@code sliceStatuses} can be cancelled
            builder.field(REQUESTS_PER_SEC_FIELD, requestsPerSecond == Float.POSITIVE_INFINITY ? -1 : requestsPerSecond);
        @Override
    }
    public void onCancelled() {
                        throttled,
        if (!isLeader()) {
            requestsPerSecond = mergedRequestsPerSecond;
         */
            long created,
            builder.append(",noops=").append(noops);
package org.opensearch.index.reindex;
         *        independently of this task but if this task is cancelled then the workers *should* be cancelled.
     * Returns true if this task is a leader for other slice subtasks
            "bulk_by_scroll_task_status_retries",
                status = null;
            throttledUntil = timeValueNanos(mergedThrottledUntil == Long.MAX_VALUE ? 0 : mergedThrottledUntil);
            builder.field(TOTAL_FIELD, total);
                total,
            throw new IllegalStateException("This task is already a leader for other slice subtasks");
        }
 * We don't always know if this task will be a leader or worker task when it's created, because if slices is set to "auto" it may
            }
        if (isLeader()) {
            out.writeTimeValue(throttledUntil);
 */
            sliceId = in.readOptionalVInt();
        }
            long mergedNoops = 0;
        }
        }
            created = mergedCreated;
        @Override
            if (sliceStatuses.isEmpty()) {
        );
        public void writeTo(StreamOutput out) throws IOException {
        @Override
            if (value < 0) {
                    // weird way to ignore unknown tokens
    public static class StatusOrException implements Writeable, ToXContentObject {
     * The status of a slice of the request. Successful requests store the {@link StatusOrException#status} while failing requests store a
        public void setCreated(Long created) {
            out.writeTimeValue(throttled);
                throw new IllegalArgumentException(name + " must be greater than 0 but was [" + value + "]");
                    throw new IllegalArgumentException("a required field is null when building Status");
     * Returns the object that tracks the state of sliced subtasks. Throws IllegalStateException if this task is not set to be
            updated = in.readVLong();
                requestsPerSecond,
         */
            }
        }
         */
            return throttled;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                created,
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
            builder.append("BulkIndexByScrollResponse[");
            // No need for inner level fields for retries in the set of outer level fields
                return Objects.equals(sliceStatuses, ((Status) o).sliceStatuses);
            {
                batches,
import org.opensearch.core.xcontent.XContentParser.Token;
            versionConflicts = in.readVLong();
            return value;
                } else if (token == Token.START_ARRAY) {
    }
 * under the License.
                            builder.setNoops(parser.longValue());
         * was an instance of exception and the {@link Status#FIELDS_SET} is the set of fields expected when the
import org.opensearch.core.common.io.stream.StreamOutput;
        public static final String CREATED_FIELD = "created";
        return leaderState;
                        parser.skipChildren();
            FIELDS_SET.add(DELETED_FIELD);
        }
        }
                // This loop is present only to ignore unknown tokens. It breaks as soon as we find a field
            this.bulkRetries = checkPositive(bulkRetries, "bulkRetries");
                && noops == other.noops
    }
        public float getRequestsPerSecond() {
        private final List<StatusOrException> sliceStatuses;
                }
                mergedNoops += slice.status.getNoops();
            out.writeVLong(noops);
            }
                    ensureExpectedToken(Token.FIELD_NAME, token, parser);
            this.sliceId = sliceId == null ? null : checkPositive(sliceId, "sliceId");
     * This class acts as a builder for {@link Status}. Once the {@link Status} object is built by calling
            long versionConflicts,
            return Objects.equals(status, other.status) && Objects.equals(exception, other.exception);
            parser.declareObjectArray(
        public static final String NAME = "bulk-by-scroll";
        }
        public Status buildStatus() {
    private volatile LeaderBulkByScrollTaskState leaderState;
        }
 * this file be licensed under the Apache-2.0 license or a
            bulkRetries = mergedBulkRetries;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    @Override
                builder.endArray();
 * specific language governing permissions and limitations
            updated = mergedUpdated;
     * general we allow {@linkplain Task.Status} implementations to make
            return Objects.hash(status, exception);
         */
     * a leader task.
        private Long versionConflicts = null;
            bulkRetries = in.readVLong();
        }
         */
            }
            StringBuilder builder = new StringBuilder();
            @Nullable String reasonCancelled,
            parser.declareLong(StatusBuilder::setDeleted, new ParseField(DELETED_FIELD));
     */
        }
            long mergedDeleted = 0;
                return "BulkByScrollTask{status=" + Strings.toString(MediaTypeRegistry.JSON, this) + "}";
                try {
         * Remaining delay of any current throttle sleep or 0 if not sleeping.
        @Override
    }
                        created,
    }
         */
            total = in.readVLong();
         */
            }
                    if (fieldName.equals(Status.SLICES_FIELD)) {
            out.writeVLong(bulkRetries);
        }
        public StatusOrException(StreamInput in) throws IOException {
                            break;
            out.writeVInt(sliceStatuses.size());
import org.opensearch.core.common.io.stream.StreamInput;
                setBulkRetries(retries.v1());
            FIELDS_SET.add(RETRIES_FIELD);
     *
        @Override
         * If it's is a worker, we know how to cancel it here
            if (this == o) return true;
                    continue;
        }
            }
                mergedBulkRetries += slice.status.getBulkRetries();
 * ownership. Elasticsearch licenses this file to you under
                        case Status.SLICE_ID_FIELD:
                this.sliceStatuses.addAll(sliceStatuses);
 * KIND, either express or implied.  See the License for the
                builder.field(RETRIES_BULK_FIELD, bulkRetries);
            return builder;
        private final long updated;
import org.opensearch.core.xcontent.XContentBuilder;
         * worker at that time.
                    } else {
        /**
                status.toXContent(builder, params);
                            builder.setTotal(parser.longValue());
                && versionConflicts == other.versionConflicts
import java.util.Set;
                mergedTotal += slice.status.getTotal();
        public static final String REQUESTS_PER_SEC_FIELD = "requests_per_second";
        }
    public BulkByScrollTask.Status getStatus() {
            return builder.endObject();
            return Objects.equals(sliceId, other.sliceId)
        static {
        public static final String UPDATED_FIELD = "updated";
                            builder.addToSliceStatuses(StatusOrException.fromXContent(parser));
        public static Set<String> FIELDS_SET = new HashSet<>();
            }
        public void setRequestsPerSecond(Float requestsPerSecond) {
                            break;
import org.opensearch.core.xcontent.ToXContentObject;
            if (params.paramAsBoolean(INCLUDE_CREATED, true)) {
     * {@link #buildStatus()} it is immutable. Used by an instance of {@link ObjectParser} when parsing from
         */
        public static void declareFields(ObjectParser<? extends StatusBuilder, Void> parser) {
                }
        public void setReasonCancelled(String reasonCancelled) {
                deleted,
                bulkRetries,
        public int hashCode() {
            FIELDS_SET.add(SLICES_FIELD);
                builder.field(CREATED_FIELD, created);
                        batches,
import java.util.Collections;
                return null;
        }
            return searchRetries;
                    }
         * If this task is a leader, we don't need to do anything extra because the cancel action cancels child tasks for us
        if (isWorker()) {
        if (isCancelled()) {
            return innerFromXContent(parser);
 * the Apache License, Version 2.0 (the "License"); you may
        }
            return throttledUntil;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
                && searchRetries == other.searchRetries
            builder.endObject();
        /**
            BulkByScrollTask.Status status = (BulkByScrollTask.Status) t.getStatus();
                            builder.setRequestsPerSecond(parser.floatValue());
        @Override
    }
            batches = in.readVInt();
            long bulkRetries,
            noops = in.readVLong();
                        case Status.BATCHES_FIELD:
                builder.startObject();
                builder.startArray(SLICES_FIELD);
        return workerState != null;
            if (token == null) {
         */
        }
        private int checkPositive(int value, String name) {
            requestsPerSecond = in.readFloat();
    public static class StatusBuilder {
                    if (slice == null) {
            long mergedSearchRetries = 0;
            builder.append("sliceId=").append(sliceId);
        public long getNoops() {
        private Float requestsPerSecond = null;
                return false;
        private final long created;
import org.opensearch.core.xcontent.XContentParseException;
            long mergedThrottled = 0;
 * class with {@link #setWorkerCount(int)} or {@link #setWorker(float, Integer)}.
                }
         * XContent param name to indicate if "updated" count must be included
     * parses it. As such, we should be very careful about removing things from
                builder.field(SLICE_ID_FIELD, sliceId);
        private final Status status;
                return new Status(sliceStatuses, reasonCancelled);
            out.writeVLong(updated);
            if (in.readBoolean()) {
                        deleted,
        private final String reasonCancelled;
     *
                            break;
        public String toString() {
    public LeaderBulkByScrollTaskState getLeaderState() {
         * Statuses of the sub requests into which this sub-request was sliced. Empty if this request wasn't sliced into sub-requests.
            this.bulkRetries = bulkRetries;
            }
                return false;
            }
                    } else {
            this.status = status;
     * implementations, this one has become defacto standardized because Kibana
import java.util.Arrays;
        return taskInfo(localNodeId, getDescription(), status);
                            break;
            for (StatusOrException slice : sliceStatuses) {
            }
                        case Status.REQUESTS_PER_SEC_FIELD:
 */
 * Unless required by applicable law or agreed to in writing,
        if (isWorker()) {
                        sliceId,
     * worker task.
                        token = parser.nextToken();
import org.opensearch.core.ParseField;
        /**
        }
            throw new IllegalStateException("This task is already a leader for other slice subtasks");
            EXPECTED_EXCEPTION_FIELDS.add("caused_by");
        }
        public TimeValue getThrottledUntil() {
            return deleted;
        public void setThrottled(Long throttled) {
            innerXContent(builder, params);
                    } else {
                && bulkRetries == other.bulkRetries
        }
     * {@link StatusOrException#exception}.
            }
            this.versionConflicts = versionConflicts;
            );
        public static final String BATCHES_FIELD = "batches";
        public void addToSliceStatuses(StatusOrException statusOrException) {
            out.writeVLong(searchRetries);
    }
            builder.append(",updated=").append(updated);
    @Override
            if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.tasks.TaskInfo;
        public void setSearchRetries(Long searchRetries) {
            this.sliceId = sliceId;
            throw new IllegalStateException("This task is already a worker");
import org.opensearch.core.xcontent.MediaTypeRegistry;
         * XContent param name to indicate if "created" count must be included
                this.throttledUntil = new TimeValue(throttledUntil, TimeUnit.MILLISECONDS);
            this.created = checkPositive(created, "created");
            parser.declareObject(StatusBuilder::setRetries, RETRIES_PARSER, new ParseField(RETRIES_FIELD));
         * what needs to be it cannot use an {@link ObjectParser}.
import org.opensearch.OpenSearchException;
    /**
 * <p>
            }
        }
            builder.field(DELETED_FIELD, deleted);
            versionConflicts = mergedVersionConflicts;
        public long getBulkRetries() {
    }
        }
        }
            return value;
        }
            out.writeVInt(batches);
            }
            if (reasonCancelled != null) {
         * The total number of documents this request will process. 0 means we don't yet know or, possibly, there are actually 0 documents
