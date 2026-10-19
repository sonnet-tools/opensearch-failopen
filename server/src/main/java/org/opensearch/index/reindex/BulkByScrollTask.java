                        parser.skipChildren();  
            deleted = in.readVLong();
            FIELDS_SET.add(DELETED_FIELD);
                deleted,  
            out.writeVLong(bulkRetries);
        }
            if (exception == null) {  
                token = parser.nextToken();  
        @Override
                this.sliceStatuses.addAll(sliceStatuses);
            }
            if (sliceStatuses.isEmpty()) {
            return workerState.getStatus();
                throttled,  
            builder.append(",retries=").append(bulkRetries);  
        public String getReasonCancelled() {
            a -> new Tuple(a[0], a[1])
    public static class Status implements Task.Status, SuccessfullyProcessed {  
            RETRIES_PARSER.declareLong(constructorArg(), new ParseField(RETRIES_BULK_FIELD));
        static final ConstructingObjectParser<Tuple<Long, Long>, Void> RETRIES_PARSER = new ConstructingObjectParser<>(
         */
                        sliceId,
     *
            builder.append(",batches=").append(batches);  
}  
import org.opensearch.tasks.TaskInfo;  
        private Integer batches = null;  
            FIELDS_SET.add(UPDATED_FIELD);
                            builder.setDeleted(parser.longValue());
            long total,  
                }
                        case Status.THROTTLED_RAW_FIELD:  
            this.total = checkPositive(total, "total");  
                builder.endObject();  
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);  
        public long getTotal() {  
         */
                mergedNoops += slice.status.getNoops();
                && Objects.equals(throttledUntil, other.throttledUntil);
    public static class StatusOrException implements Writeable, ToXContentObject {
        public void setCreated(Long created) {
                } else { // else if it is a value
            throw new IllegalStateException("This task is already a leader for other slice subtasks");
        public long getVersionConflicts() {
        public static final String THROTTLED_RAW_FIELD = "throttled_millis";
        private Long bulkRetries = null;  
                            builder.setReasonCancelled(parser.text());
import static org.opensearch.common.unit.TimeValue.timeValueNanos;  
        public TimeValue getThrottledUntil() {  
            XContentParser.Token token = parser.currentToken();
         * at a field first before deciding what needs to be parsed since the same object could contains either.
         */  
            }
            long updated,
        private List<StatusOrException> sliceStatuses = new ArrayList<>();  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                            break;
        public StatusOrException(Exception exception) {
                token = parser.nextToken();  
            EXPECTED_EXCEPTION_FIELDS.add("error");
        if (isLeader()) {  
        }  
    }  
        /**
import org.opensearch.core.xcontent.ConstructingObjectParser;
            updated = mergedUpdated;
        public static Set<String> EXPECTED_EXCEPTION_FIELDS = new HashSet<>();
        }
                mergedRequestsPerSecond += slice.status.getRequestsPerSecond();
    }
     * this.
    }  
            "bulk_by_scroll_task_status_retries",  
    }
                exception = null;  
                (p, c) -> StatusOrException.fromXContent(p),
        }
            }
            this.updated = updated;
            long deleted,  
         */
            if (false == sliceStatuses.isEmpty()) {
 * class with {@link #setWorkerCount(int)} or {@link #setWorker(float, Integer)}.  
            builder.field(BATCHES_FIELD, batches);  
public class BulkByScrollTask extends CancellableTask {
     */
            parser.declareLong(StatusBuilder::setDeleted, new ParseField(DELETED_FIELD));
            }
                bulkRetries,
    }
            throttled = timeValueNanos(mergedThrottled);  
        private final long versionConflicts;  
            this.sliceStatuses.add(statusOrException);
                            break;
            sliceStatuses.set(status.getSliceId(), new BulkByScrollTask.StatusOrException(status));
import java.util.Set;
        return workerState != null;
            return leaderState.getStatus();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import static java.util.Collections.emptyList;
    }  
            total = mergedTotal;  
 */  
        if (isWorker()) {
        public void setSliceId(Integer sliceId) {
import static java.lang.Math.min;
            innerXContent(builder, params);  
        }  
            noops = in.readVLong();
                mergedUpdated += slice.status.getUpdated();
                requestsPerSecond,
        }
            FIELDS_SET.add(SLICE_ID_FIELD);  
    /**
        for (TaskInfo t : sliceInfo) {
                        case Status.REQUESTS_PER_SEC_FIELD:  
        Integer getSliceId() {
                return new Status(sliceStatuses, reasonCancelled);  
    private volatile WorkerBulkByScrollTaskState workerState;
         * If we don't know whether it's a leader or worker yet, we do nothing here. If the task is later set to be a worker, we cancel the
        public XContentBuilder innerXContent(XContentBuilder builder, Params params) throws IOException {  
        }
        public void setBulkRetries(Long bulkRetries) {
            parser.declareString(StatusBuilder::setReasonCancelled, new ParseField(CANCELED_FIELD));  
            this.searchRetries = checkPositive(searchRetries, "searchRetries");
            return builder.append(']').toString();
     */
                        created,
 * {@link BulkByScrollTask#setWorker(float, Integer)}).
            builder.append(",created=").append(created);
            return throttledUntil;
/*
            parser.declareLong(StatusBuilder::setVersionConflicts, new ParseField(VERSION_CONFLICTS_FIELD));
        @Override
        public void writeTo(StreamOutput out) throws IOException {
        }
                            builder.setBatches(parser.intValue());
        private final int batches;
    /**
        public void setSliceStatuses(List<StatusOrException> sliceStatuses) {  
                new ParseField(SLICES_FIELD)
                        case Status.DELETED_FIELD:  
                } else if (token == Token.START_ARRAY) {
import org.opensearch.core.xcontent.XContentBuilder;  
                    if (slice == null) {  
                    } else {
                builder.field(SLICE_ID_FIELD, sliceId);
            long noops,  
        /**
 * Licensed to Elasticsearch under one or more contributor  
        private final List<StatusOrException> sliceStatuses;
        private final long total;
        public Status(StreamInput in) throws IOException {  
                created,
            return bulkRetries;
            if (params.paramAsBoolean(INCLUDE_CREATED, true)) {
                            builder.setThrottledUntil(parser.longValue());
     * {@link StatusOrException#exception}.  
            }
         */  
                builder.append(",workers=").append(sliceStatuses);  
        if (isWorker()) {
        @Override
        if (isLeader()) {
         */
         * If this task is a leader, we don't need to do anything extra because the cancel action cancels child tasks for us
        /**  
    /**
         * The total time this request has throttled itself not including the current throttle time if it is currently sleeping.
            out.writeTimeValue(throttledUntil);  
            }
                && versionConflicts == other.versionConflicts  
            this.sliceStatuses = emptyList();
                mergedDeleted += slice.status.getDeleted();
    public BulkByScrollTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {  
            } else {
        static {
         */  
        }
        return taskInfo(localNodeId, getDescription(), status);
                builder.startObject();
                mergedTotal += slice.status.getTotal();
            FIELDS_SET.add(VERSION_CONFLICTS_FIELD);  
        private final TimeValue throttledUntil;
                builder.field(RETRIES_BULK_FIELD, bulkRetries);
                }  
            builder.append(",updated=").append(updated);  
            return updated;  
            long mergedThrottledUntil = Long.MAX_VALUE;
                try {  
            return reasonCancelled;  
        private int checkPositive(int value, String name) {
        public void setVersionConflicts(Long versionConflicts) {
                            builder.addToSliceStatuses(StatusOrException.fromXContent(parser));
            return Objects.hash(
import org.opensearch.core.xcontent.ObjectParser;
        );  
            if (exception == null) {
        public static final String INCLUDE_CREATED = "include_created";
            builder.humanReadableField(THROTTLED_UNTIL_RAW_FIELD, THROTTLED_UNTIL_HR_FIELD, throttledUntil);
    public boolean isLeader() {
            this.created = created;  
                && deleted == other.deleted
                builder.field(CREATED_FIELD, created);  
                return Objects.equals(sliceStatuses, ((Status) o).sliceStatuses);
                this.throttledUntil = new TimeValue(throttledUntil, TimeUnit.MILLISECONDS);
            builder.endObject();
 * not use this file except in compliance with the License.
                    } else {
            return builder;
                sliceId,
                            builder.setRequestsPerSecond(parser.floatValue());
            if (token == Token.VALUE_NULL) {
            return sliceStatuses;
            this.sliceId = sliceId;  
    }
            this.reasonCancelled = reasonCancelled;
                    }  
            updated = in.readVLong();  
                return null;  
            if (throttled != null) {
         * Number of noops (skipped bulk items) as part of this request.
            builder.field(TOTAL_FIELD, total);
            }  
                mergedVersionConflicts += slice.status.getVersionConflicts();  
 * be either depending on the number of shards in the source indices. We figure that out when the request is handled and set it on this
            }  
            }  
        /**  
        public String getWriteableName() {
import org.opensearch.common.collect.Tuple;  
            total = in.readVLong();
                && (!includeCreated || created == other.created)  
            if (obj.getClass() != BulkByScrollTask.StatusOrException.class) {
            float mergedRequestsPerSecond = 0;
import org.opensearch.core.xcontent.XContentParseException;
            long mergedBulkRetries = 0;
                out.writeBoolean(false);
         * Number of scan responses this request has processed.
                StatusBuilder::setSliceStatuses,  
            if (sliceId != null) {
    public WorkerBulkByScrollTaskState getWorkerState() {
     * Returns true if this task is a leader for other slice subtasks  
                        default:  
        public void setRetries(Tuple<Long, Long> retries) {
        }
        public void setTotal(Long total) {  
            EXPECTED_EXCEPTION_FIELDS.add("type");
            if (this == o) return true;  
        public static final String RETRIES_FIELD = "retries";
                        case Status.TOTAL_FIELD:  
        private long checkPositive(long value, String name) {
            } else {
                        throttled,  
        static {
            out.writeVLong(created);
        @Override
        }
        }
         * worker at that time.
        /**
            if (requestsPerSecond != null) {
                requestsPerSecond = requestsPerSecond == -1 ? Float.POSITIVE_INFINITY : requestsPerSecond;  
            long mergedTotal = 0;  
                        if (token == Token.START_OBJECT || token == Token.START_ARRAY) {
                && Objects.equals(throttled, other.throttled)
                reasonCancelled,
 *  
            FIELDS_SET.add(CANCELED_FIELD);
     * set as a leader for slice subtasks
            FIELDS_SET.add(THROTTLED_RAW_FIELD);
                setBulkRetries(retries.v1());  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            bulkRetries = in.readVLong();  
                    }
        public static final String REQUESTS_PER_SEC_FIELD = "requests_per_second";
         */  
            out.writeVLong(updated);
        @Override  
        public static Status innerFromXContent(XContentParser parser) throws IOException {  
        }
        }
        );
            long bulkRetries,
        }
         * Constructor merging many statuses.
            builder.field(VERSION_CONFLICTS_FIELD, versionConflicts);
        /**
        }  
                        case Status.UPDATED_FIELD:  
            if (sliceStatuses != null) {
                        }  
            ensureExpectedToken(Token.FIELD_NAME, token, parser);
    public boolean shouldCancelChildrenOnCancellation() {
            return exception;
        @Override  
            builder.field(DELETED_FIELD, deleted);
import org.opensearch.tasks.CancellableTask;
            float requestsPerSecond,
            builder.startObject(RETRIES_FIELD);  
        /*
        }
        }  
            noops = mergedNoops;  
        private final Status status;
    private BulkByScrollTask.Status emptyStatus() {
            this.deleted = deleted;
                if (slice == null) {
            innerToString(builder);  
                out.writeException(exception);
            }
        public void setRequestsPerSecond(Float requestsPerSecond) {
        /**
            return innerFromXContent(parser);  
            }
            TimeValue throttledUntil  
                this.throttled = new TimeValue(throttled, TimeUnit.MILLISECONDS);  
            throttledUntil = in.readTimeValue();
                        builder.setRetries(Status.RETRIES_PARSER.parse(parser, null));
            out.writeVInt(batches);
            this.reasonCancelled = reasonCancelled;
         */  
            workerState.handleCancel();
                && bulkRetries == other.bulkRetries  
 */  
    public static class StatusBuilder {  
         * The {@link #EXPECTED_EXCEPTION_FIELDS} contains the fields that are expected when the serialised object
                        case Status.CREATED_FIELD:  
     */  
            this.sliceStatuses = sliceStatuses;  
        public Status buildStatus() {
                }
        public int hashCode() {
            ensureExpectedToken(Token.START_OBJECT, token, parser);  
import org.opensearch.common.unit.TimeValue;
                mergedThrottled += slice.status.getThrottled().nanos();
            }
            long mergedUpdated = 0;
        return leaderState != null;  
 * When the request is sliced, this task can either represent a coordinating task (using  
    /**
 * The OpenSearch Contributors require contributions made to  
    }
            long created,
import org.opensearch.OpenSearchException;
                        case Status.THROTTLED_UNTIL_RAW_FIELD:  
            out.writeVLong(searchRetries);
            this.deleted = checkPositive(deleted, "deleted");  
            FIELDS_SET.add(THROTTLED_UNTIL_RAW_FIELD);
            this.noops = noops;
        }
         */
        private final long updated;
 * <p>
    /**
        public StatusOrException(StreamInput in) throws IOException {  
        private final String reasonCancelled;  
        }  
            if (throttledUntil != null) {
        private Long deleted = null;
                exception = in.readException();  
            this.batches = checkPositive(batches, "batches");
        @Override
                total,  
            this.bulkRetries = checkPositive(bulkRetries, "bulkRetries");
                batches,
            if (false == sliceStatuses.isEmpty()) {  
                return "BulkByScrollTask{status=" + Strings.toString(MediaTypeRegistry.JSON, this) + "}";
            this.created = checkPositive(created, "created");
                            builder.setTotal(parser.longValue());
            StringBuilder builder = new StringBuilder();
         * @param reasonCancelled Reason that this *this* task was cancelled. Note that each entry in {@code sliceStatuses} can be cancelled
            return noops;
                }  
            parser.declareInt(StatusBuilder::setBatches, new ParseField(BATCHES_FIELD));  
        workerState = new WorkerBulkByScrollTaskState(this, sliceId, requestsPerSecond);  
    public TaskInfo taskInfoGivenSubtaskInfo(String localNodeId, List<TaskInfo> sliceInfo) {  
        }  
        public void addToSliceStatuses(StatusOrException statusOrException) {  
    /**
            return builder.endObject();
     * @param requestsPerSecond How many search requests per second this task should make
            builder.humanReadableField(THROTTLED_RAW_FIELD, THROTTLED_HR_FIELD, throttled);  
                // This loop is present only to ignore unknown tokens. It breaks as soon as we find a field
            } else {  
            return batches;
                            builder.setVersionConflicts(parser.longValue());
     * This class acts as a builder for {@link Status}. Once the {@link Status} object is built by calling  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
        private long created = 0; // Not present during updateByQuery
 * Task storing information about a currently running BulkByScroll request.
        }
 * <p>  
            throw new IllegalStateException("This task is already a leader for other slice subtasks");  
                        noops,  
    }  
     * @param sliceId If this is a sliced task, which slice number this task corresponds to. Null if not sliced.
                    if (Status.FIELDS_SET.contains(fieldName)) {
            return searchRetries;  
     * backwards incompatible changes to their {@link Task.Status#toXContent}
            builder.append(",deleted=").append(deleted);
                } catch (NullPointerException npe) {
     */
     * a leader task.
import org.opensearch.core.common.io.stream.Writeable;  
            }  
            if (equalsWithoutSliceStatus(o, true, true)) {  
                return false;  
        /**
            versionConflicts = mergedVersionConflicts;
            requestsPerSecond = in.readFloat();  
                            break;
                    } else {
        public void setSearchRetries(Long searchRetries) {  
 * You may obtain a copy of the License at  
                builder.endArray();  
                && searchRetries == other.searchRetries
 *
                && (!includeUpdated || updated == other.updated)
            EXPECTED_EXCEPTION_FIELDS.add("reason");
     * Sets this task to be a leader task for {@code slices} sliced subtasks
            }
        private final long bulkRetries;
        }
        private Integer sliceId = null;
            batches = mergedBatches;
        List<BulkByScrollTask.StatusOrException> sliceStatuses = Arrays.asList(
            }
        }
/*  
         * The number of requests per second to which to throttle the request. Float.POSITIVE_INFINITY means unlimited.
            this.batches = batches;
        Status status = leaderState.getStatus(sliceStatuses);  
                    fieldName = parser.currentName();
    public LeaderBulkByScrollTaskState getLeaderState() {  
        /**
            EXPECTED_EXCEPTION_FIELDS.add("header");  
            throw new IllegalStateException("This task is not set to be a leader for other slice subtasks");
        public void setNoops(Long noops) {  
        /**
                        deleted,  
            Token token = parser.currentToken();
        }
    public BulkByScrollTask.Status getStatus() {
            searchRetries = in.readVLong();
                        case Status.BATCHES_FIELD:  
        if (!isLeader()) {
         * We need to write a manual parser for this because of {@link StatusOrException}. Since
                            builder.setNoops(parser.longValue());
         * If it's is a worker, we know how to cancel it here  
        if (isLeader()) {
                if (token == Token.FIELD_NAME) {  
import java.util.ArrayList;  
            out.writeVInt(sliceStatuses.size());
            if (reasonCancelled != null) {
                        total,  
            long mergedSearchRetries = 0;
            int mergedBatches = 0;
            true,
        @Override  
         * The id of the slice that this status is reporting or {@code null} if this isn't the status of a sub-slice.
                && total == other.total
                        return new StatusOrException(OpenSearchException.innerFromXContent(parser, false));
    @Override  
        private Float requestsPerSecond = null;  
        }
 * this file be licensed under the Apache-2.0 license or a
        }
                for (StatusOrException slice : sliceStatuses) {
 * We don't always know if this task will be a leader or worker task when it's created, because if slices is set to "auto" it may
            EXPECTED_EXCEPTION_FIELDS.add("caused_by");  
        @Override
            out.writeOptionalVInt(sliceId);
/**
                // that is allowed.
            this.sliceId = sliceId == null ? null : checkPositive(sliceId, "sliceId");
            builder.field(REQUESTS_PER_SEC_FIELD, requestsPerSecond == Float.POSITIVE_INFINITY ? -1 : requestsPerSecond);
            long mergedCreated = 0;
 * SPDX-License-Identifier: Apache-2.0
        /**  
            }
            }  
        }  
     */
        }
            FIELDS_SET.add(SLICES_FIELD);
        public void setBatches(Integer batches) {
 * Modifications Copyright OpenSearch Contributors. See
        @Override
        }
            } else {
            FIELDS_SET.add(BATCHES_FIELD);
            batches = in.readVInt();  
                    }  
        public void innerToString(StringBuilder builder) {
            out.writeTimeValue(throttled);  
            long mergedThrottled = 0;  
        }  
                        case Status.NOOPS_FIELD:  
     * @opensearch.internal
            return created;
import org.opensearch.core.tasks.TaskId;
     */  
        public float getRequestsPerSecond() {
        public boolean equalsWithoutSliceStatus(Object o, boolean includeUpdated, boolean includeCreated) {
         * Number of version conflicts this request has hit.  
            throw new IllegalStateException("This task is already a worker");  
        public void setReasonCancelled(String reasonCancelled) {
        private final Exception exception;  
            for (StatusOrException slice : sliceStatuses) {
        }
            this.bulkRetries = bulkRetries;  
        private Long total = null;
 */
        public long getCreated() {
                return false;  
                            break;
            return value;
 * this work for additional information regarding copyright
                }
                    // weird way to ignore unknown tokens  
        @Override  
            if (reasonCancelled != null) {
import java.util.Arrays;
                        slice.toXContent(builder, params);  
        public static final String TOTAL_FIELD = "total";
                        builder.nullValue();
                builder.startArray(SLICES_FIELD);
            );  
import org.opensearch.core.xcontent.XContentParser.Token;  
        }
 * <p>  
     * Sets this task to be a worker task that performs search requests  
         */  
            throttledUntil = timeValueNanos(mergedThrottledUntil == Long.MAX_VALUE ? 0 : mergedThrottledUntil);
     */  
 * software distributed under the License is distributed on an
     */
            return sliceId;
        }  
        public long getSearchRetries() {
        @Override  
                        updated,
        public String toString() {
            deleted = mergedDeleted;  
         */
            if (value < 0) {  
            searchRetries = mergedSearchRetries;
                setSearchRetries(retries.v2());
                            break;
        private TimeValue throttled = null;
                            builder.setCreated(parser.longValue());
        if (isWorker()) {
                throw new XContentParseException("Unable to parse StatusFromException. Expected fields not found.");
            }  
        }
            throw new IllegalStateException("This task is already a worker");
        if (isLeader() == false) {
            }
                        case Status.SLICE_ID_FIELD:  
            return throttled;
                    } else {
        public int getBatches() {
            if (params.paramAsBoolean(INCLUDE_UPDATED, true)) {
        return workerState;
                            break;
            this.requestsPerSecond = requestsPerSecond;
     * general we allow {@linkplain Task.Status} implementations to make
                    throw new IllegalArgumentException("a required field is null when building Status");  
            long versionConflicts,
        private final long searchRetries;  
            parser.declareLong(StatusBuilder::setTotal, new ParseField(TOTAL_FIELD));
 * license agreements. See the NOTICE file distributed with
            reasonCancelled = in.readOptionalString();
            this.status = status;  
            return NAME;  
     * @opensearch.internal
                        searchRetries,
                            break;
        public static final String CREATED_FIELD = "created";  
                        versionConflicts,
        public static Status fromXContent(XContentParser parser) throws IOException {
            for (StatusOrException sliceStatus : sliceStatuses) {
        public void setThrottledUntil(Long throttledUntil) {  
                        case Status.VERSION_CONFLICTS_FIELD:  
 * When the request is not sliced, this task is the only task created, and starts an action to perform search requests.
                    } else if (EXPECTED_EXCEPTION_FIELDS.contains(fieldName)) {  
    }  
            out.writeVLong(deleted);  
                        return new StatusOrException(Status.innerFromXContent(parser));
        public void setThrottled(Long throttled) {
            if (token == null) {
        }
                status = null;
        }  
        }  
        public boolean equals(Object o) {
         * The total number of documents this request will process. 0 means we don't yet know or, possibly, there are actually 0 documents  
 *
        }
            // No need for inner level fields for retries in the set of outer level fields  
            Integer sliceId,
            builder.append(",noops=").append(noops);
        }
                status.writeTo(out);
            BulkByScrollTask.StatusOrException other = (StatusOrException) obj;
        public static final String NOOPS_FIELD = "noops";
            FIELDS_SET.add(CREATED_FIELD);  
        public Status(List<StatusOrException> sliceStatuses, @Nullable String reasonCancelled) {
 */  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            }
        }  
            parser.declareLong(StatusBuilder::setThrottled, new ParseField(THROTTLED_RAW_FIELD));
                        batches,
        private final TimeValue throttled;
            } else {
        public static final String INCLUDE_UPDATED = "include_updated";
                        token = parser.nextToken();
        if (isCancelled()) {
        /**
        private String reasonCancelled = null;
         * @param sliceStatuses Statuses of sub requests that this task was sliced into.
        public static final String THROTTLED_UNTIL_RAW_FIELD = "throttled_until_millis";  
            out.writeOptionalString(reasonCancelled);
     */
            return Objects.hash(status, exception);
import org.opensearch.core.common.io.stream.StreamInput;
                        token = parser.nextToken();
     * Build the status for this task given a snapshot of the information of running slices. This is only supported if the task is  
        private Long noops = null;
     * Returns the object that tracks the state of sliced subtasks. Throws IllegalStateException if this task is not set to be  
            this.noops = checkPositive(noops, "noops");  
            return requestsPerSecond;
        }  
     *  
                        reasonCancelled,
        }  
                        case Status.CANCELED_FIELD:  
import java.util.List;
            String fieldName = parser.currentName();
                token = parser.nextToken();
                out.writeOptionalWriteable(sliceStatus);  
         * to process. Its ok that these have the same meaning because any request with 0 actual documents should be quite short lived.
                }
                    return new Status(
            if (retries != null) {
        }  
            out.writeFloat(requestsPerSecond);
            XContentParser.Token token;  
 * under the License.  
            out.writeVLong(versionConflicts);
            }
            FIELDS_SET.add(THROTTLED_HR_FIELD);
            parser.declareObject(StatusBuilder::setRetries, RETRIES_PARSER, new ParseField(RETRIES_FIELD));  
            status = null;
     * The status of a slice of the request. Successful requests store the {@link StatusOrException#status} while failing requests store a
            FIELDS_SET.add(REQUESTS_PER_SEC_FIELD);  
        return emptyStatus();
                builder.append(",canceled=").append(reasonCancelled);
                            break;
                throttledUntil,  
            }
        }  
         * Statuses of the sub requests into which this sub-request was sliced. Empty if this request wasn't sliced into sub-requests.
                            parser.skipChildren();  
                mergedBulkRetries += slice.status.getBulkRetries();
        }  
     * XContent.
                builder.field(RETRIES_SEARCH_FIELD, searchRetries);  
 * GitHub history for details.
        }
 * Unless required by applicable law or agreed to in writing,
                mergedThrottledUntil = min(mergedThrottledUntil, slice.status.getThrottledUntil().nanos());  
        }
     * Status of the reindex, update by query, or delete by query. While in  
            new BulkByScrollTask.StatusOrException[leaderState.getSlices()]  
                while (token != Token.END_OBJECT) {  
         */
            {
                this.requestsPerSecond = requestsPerSecond;
                    // Hasn't returned yet.  
            return builder;
            workerState.handleCancel();
        public static final String SLICE_ID_FIELD = "slice_id";  
                mergedBatches += slice.status.getBatches();
            this.versionConflicts = checkPositive(versionConflicts, "versionConflicts");
                return false;  
        }
            }  
            }
            } else {
            throttled = in.readTimeValue();
 * compatible open source license.
                    continue;
         * Number of retries that had to be attempted due to search actions being rejected.  
            builder.startObject();
        }
        public static final String VERSION_CONFLICTS_FIELD = "version_conflicts";  
        private long updated = 0; // Not present during deleteByQuery  
            FIELDS_SET.add(THROTTLED_UNTIL_HR_FIELD);  
                return "BulkByScrollTask{error=" + Strings.toString(MediaTypeRegistry.JSON, this) + "}";  
import org.opensearch.core.xcontent.XContentParser;
         */
         * was an instance of exception and the {@link Status#FIELDS_SET} is the set of fields expected when the  
            this.throttled = throttled;  
            FIELDS_SET.add(NOOPS_FIELD);
/*  
    public void setWorkerCount(int slices) {  
        public static final String THROTTLED_HR_FIELD = "throttled";  
         * Number of retries that had to be attempted due to bulk actions being rejected.
    }
            long mergedVersionConflicts = 0;
        public Status getStatus() {  
            out.writeVLong(noops);  
            TimeValue throttled,  
                token = parser.nextToken();
                            break;
            while ((token = parser.nextToken()) != Token.END_OBJECT) {
     */  
            bulkRetries = mergedBulkRetries;
                    continue;
            parser.declareLong(StatusBuilder::setCreated, new ParseField(CREATED_FIELD));
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
                    String fieldName = parser.currentName();
                if (slice.status == null) {  
                    ensureExpectedToken(Token.FIELD_NAME, token, parser);
        public static final String SLICES_FIELD = "slices";
import java.io.IOException;
     * Returns the object that manages sending search requests. Throws IllegalStateException if this task is not set to be a
    }  
        }
                versionConflicts,
            token = parser.nextToken();
        public static final String DELETED_FIELD = "deleted";
    }  
        /**  
            if (o == null || getClass() != o.getClass()) return false;
            int batches,
        public int hashCode() {  
            }
            long mergedDeleted = 0;  
            Status other = (Status) o;
        public long getDeleted() {  
        }  
        private TimeValue throttledUntil = null;
        private final Integer sliceId;  
            requestsPerSecond = mergedRequestsPerSecond;
                            break;
         * in the response.
        private final long deleted;
import org.opensearch.core.common.Strings;  
         * serialized object was an instance of Status.
 * @opensearch.internal
        static {  
        public static final String NAME = "bulk-by-scroll";
            sliceId = in.readOptionalVInt();
     * Returns true if this task is a worker task that performs search requests. False otherwise
    private volatile LeaderBulkByScrollTaskState leaderState;  
        }
        private Long searchRetries = null;
        public List<StatusOrException> getSliceStatuses() {
            parser.declareLong(StatusBuilder::setNoops, new ParseField(NOOPS_FIELD));
            parser.declareInt(StatusBuilder::setSliceId, new ParseField(SLICE_ID_FIELD));
                builder.field(CANCELED_FIELD, reasonCancelled);  
 * KIND, either express or implied.  See the License for the
            } else {  
            return value;  
        public boolean equals(Object obj) {
        if (!isWorker()) {
        public Status(
     *  
        @Override
        }  
            this.total = total;
        public StatusOrException(Status status) {
    /**
        }
            parser.declareLong(StatusBuilder::setUpdated, new ParseField(UPDATED_FIELD));  
         *  
            parser.declareLong(StatusBuilder::setThrottledUntil, new ParseField(THROTTLED_UNTIL_RAW_FIELD));
                builder.field(UPDATED_FIELD, updated);  
            if (obj == null) {
                        while ((token = parser.nextToken()) != Token.END_ARRAY) {
                    }
        public void setUpdated(Long updated) {
        }
        if (isWorker()) {
            builder.field(NOOPS_FIELD, noops);
    @Override
    public void onCancelled() {  
                            builder.setSliceId(parser.intValue());
            return Objects.equals(sliceId, other.sliceId)  
        }  
 * {@link BulkByScrollTask#setWorkerCount(int)}) or a worker task that performs search queries (using
            long mergedNoops = 0;  
        }
                    if (fieldName.equals(Status.SLICES_FIELD)) {  
            this.exception = exception;  
        }  
    public void setWorker(float requestsPerSecond, @Nullable Integer sliceId) {
            created = in.readVLong();
            this.versionConflicts = versionConflicts;  
                sliceStatuses
         * Since {@link StatusOrException} can contain either an {@link Exception} or a {@link Status} we need to peek  
                        parser.skipChildren();
                            break;
            builder.append("sliceId=").append(sliceId);
                updated,
        public void writeTo(StreamOutput out) throws IOException {
        return new Status(Collections.emptyList(), getReasonCancelled());
        public static final String CANCELED_FIELD = "canceled";
                            break;
            if (in.readBoolean()) {
            BulkByScrollTask.Status status = (BulkByScrollTask.Status) t.getStatus();  
     * parses it. As such, we should be very careful about removing things from
            throw new IllegalStateException("This task is not set to be a worker");  
        private Long versionConflicts = null;
        }
         * The reason that the request was canceled or null if it hasn't been.  
                throw new IllegalArgumentException(name + " must be greater than 0 but was [" + value + "]");  
            exception = null;
        public TimeValue getThrottled() {  
        super(id, type, action, description, parentTaskId, headers);
            RETRIES_PARSER.declareLong(constructorArg(), new ParseField(RETRIES_SEARCH_FIELD));  
            FIELDS_SET.add(TOTAL_FIELD);
     * implementations, this one has become defacto standardized because Kibana  
        }
            if (value < 0) {
         * what needs to be it cannot use an {@link ObjectParser}.
                mergedCreated += slice.status.getCreated();  
import java.util.concurrent.TimeUnit;
                        bulkRetries,
        return true;
    /**
        public static final String RETRIES_SEARCH_FIELD = "search";
        /**
            }
                noops,  
            parser.declareFloat(StatusBuilder::setRequestsPerSecond, new ParseField(REQUESTS_PER_SEC_FIELD));
        leaderState = new LeaderBulkByScrollTaskState(this, slices);
         * XContent param name to indicate if "updated" count must be included
                            builder.setUpdated(parser.longValue());
                        requestsPerSecond,
            sliceStatuses = in.readList(stream -> stream.readOptionalWriteable(StatusOrException::new));  
                    }
                    // This slice failed catastrophically so it doesn't count towards the status
        }  
            created = mergedCreated;
                && Objects.equals(reasonCancelled, other.reasonCancelled)  
                    if (fieldName.equals(Status.RETRIES_FIELD)) {  
            @Nullable String reasonCancelled,
    }
        }
            }
            long searchRetries,
        public String toString() {  
         *        independently of this task but if this task is cancelled then the workers *should* be cancelled.  
import java.util.HashSet;  
        }  
            throw new IllegalStateException("This task is not set to be a leader of other slice subtasks");
 * specific language governing permissions and limitations
    /**  
         */  
        @SuppressWarnings("unchecked")
            EXPECTED_EXCEPTION_FIELDS.add("stack_trace");
        public long getBulkRetries() {
            builder.append("BulkIndexByScrollResponse[");
import org.opensearch.common.Nullable;
        }
                } else if (token == Token.START_OBJECT) {
            return Objects.equals(status, other.status) && Objects.equals(exception, other.exception);  
            return builder.buildStatus();
                ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            );
            this.throttledUntil = throttledUntil;  
        private final long created;  
package org.opensearch.index.reindex;
            versionConflicts = in.readVLong();
     * worker task.
         * XContent param name to indicate if "created" count must be included
                && noops == other.noops
import java.util.Objects;  
        }
        public static final String THROTTLED_UNTIL_HR_FIELD = "throttled_until";
         * Remaining delay of any current throttle sleep or 0 if not sleeping.
            EXPECTED_EXCEPTION_FIELDS.add("root_cause");
        public long getUpdated() {
import org.opensearch.core.common.io.stream.StreamOutput;
 *
                        }
         */
            EXPECTED_EXCEPTION_FIELDS.add("suppressed");
        }
import org.opensearch.core.ParseField;
            StatusBuilder builder = new StatusBuilder();
            }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
import java.util.Collections;
            this.updated = checkPositive(updated, "updated");
import org.opensearch.tasks.Task;
         * in the response.
                && batches == other.batches
        }
         */
        ) {
         * {@link StatusOrException#fromXContent(XContentParser)} tries to peek at a field first before deciding  
        /**  
            } else {  
        public void setDeleted(Long deleted) {  
        public static StatusOrException fromXContent(XContentParser parser) throws IOException {  
import org.opensearch.core.xcontent.ToXContentObject;
 *    http://www.apache.org/licenses/LICENSE-2.0
                searchRetries,
                        // Ignore unknown tokens  
                status.toXContent(builder, params);
            if (exception != null) {
        public static final String BATCHES_FIELD = "batches";
        }
            sliceId = null;  
        private final long noops;
                    switch (fieldName) {
            if (parser.currentToken() == Token.START_OBJECT) {
            return versionConflicts;  
            parser.declareObjectArray(
            this.searchRetries = searchRetries;
                && requestsPerSecond == other.requestsPerSecond
        }
            return total;
            FIELDS_SET.add(RETRIES_FIELD);
            this.reasonCancelled = reasonCancelled;  
    @Override
                    );
                OpenSearchException.generateThrowableXContent(builder, params, exception);
        }
        private final float requestsPerSecond;
        }
        public Exception getException() {
    public boolean isWorker() {
            return status;
        public static void declareFields(ObjectParser<? extends StatusBuilder, Void> parser) {  
         */  
                            break;
         * Read from a stream.
                out.writeBoolean(true);
        }  
        /**  
import java.util.Map;
            builder.append(",versionConflicts=").append(versionConflicts);
        public long getNoops() {  
            }
                status = new Status(in);
            return deleted;
                mergedSearchRetries += slice.status.getSearchRetries();  
        /**
         */
        public static final String UPDATED_FIELD = "updated";
        public static final String RETRIES_BULK_FIELD = "bulk";  
        public static Set<String> FIELDS_SET = new HashSet<>();
    }
 * ownership. Elasticsearch licenses this file to you under  
        }
        }
     * @opensearch.internal
        @Override  
        return leaderState;
            out.writeVLong(total);  
        /**
                            builder.setThrottled(parser.longValue());
     * {@link #buildStatus()} it is immutable. Used by an instance of {@link ObjectParser} when parsing from
            builder.append(",throttledUntil=").append(throttledUntil);
                        throttledUntil  
                throw new IllegalArgumentException(name + " must be greater than 0 but was [" + value + "]");
