        when(producerCaps.dataTransferCapabilities()).thenReturn(
        );
            /* leftExpectedSenders */ 5,
import org.opensearch.analytics.planner.dag.StagePlan;
        ShuffleEnrichment.enrichWorkerAlternatives(consumer, /* partitionCount */ 2, 7, 3, "qid", 1, 2, /* preferHashJoin */ false);
            assertEquals("scan + producer = 2 instructions", 2, instr.size());
        assertEquals("input-12", right0.getNamedInputId());
        Stage producer = newProducerStage(/* stageId */ 1, /* partitionCount */ 2, List.of(0));
        BackendCapabilityProvider noTransferCaps = mock(BackendCapabilityProvider.class);
            )
 * path: the methods moved verbatim into {@link ShuffleEnrichment}, so the regression coverage moves with
import org.opensearch.analytics.planner.CapabilityRegistry;
        ShuffleEnrichment.enrichWorkerAlternatives(
 * The OpenSearch Contributors require contributions made to
        // The fragment convertor strips OpenSearchShuffleExchange and rewrites the StageInputScan leaf to a
            ex.getMessage().contains("producer stage 1")
        return new Stage(stageId, null, List.of(), ExchangeInfo.hashDistributed(hashKeys, partitionCount), null, null);
import org.opensearch.analytics.spi.ShuffleProducerInstructionNode;
import java.util.List;
        producer.setPlanAlternatives(List.of(new StagePlan(null, "lucene").withInstructions(List.of(new ShardScanInstructionNode()))));
        ShuffleScanInstructionNode right0 = (ShuffleScanInstructionNode) instr.get(2);
        when(producerBackend.getCapabilityProvider()).thenReturn(producerCaps);
            /* queryId */ "qid-test",
            /* rightExpectedSenders */ 4,
        when(registry.getBackend(producerBackendName)).thenReturn(producerBackend);
    }
        StagePlan alt = new StagePlan(null, "df");
    public void testEnrichProducerAlternativesAppendsOneInstructionPerAlt() {
        assertEquals(7, setup.getLeftExpectedSenders());
        // must be dropped so PlanAlternativeSelector can't pick a driver that throws at execution. With NO
        for (int i = 1; i < instr.size(); i++) {
            producer,
        assertEquals(4, right0.getExpectedSenders());
        ShuffleWorkerSetupInstructionNode setup = (ShuffleWorkerSetupInstructionNode) consumer.getPlanAlternatives()
        List<StagePlan> enriched = producer.getPlanAlternatives();
            assertEquals(9, pn.getTargetStageId());
            assertEquals(List.of(0), pn.getHashKeyChannels());
        consumer.setPlanAlternatives(List.of(new StagePlan(null, "df")));
        // capable alternative left, enrich must fail fast rather than emit an un-runnable producer.
}
        when(noTransferBackend.getCapabilityProvider()).thenReturn(noTransferCaps);
            assertEquals(List.of("node-0", "node-1", "node-2"), pn.getTargetWorkerNodeIds());
        CapabilityRegistry registry = mock(CapabilityRegistry.class);
            List.of("node-0", "node-1", "node-2"),
        assertEquals("input-11", left0.getNamedInputId());
            /* partitionCount */ 3,
            /* partitionCount */ 3,
        assertEquals("qid-test", left0.getQueryId());
public class ShuffleEnrichmentTests extends OpenSearchTestCase {
            assertTrue("appended instruction is a shuffle-scan", instr.get(i) instanceof ShuffleScanInstructionNode);
        );
            assertEquals("qid", pn.getQueryId());
            /* consumerStageId */ 9,
                shuffleCapableRegistry("df") // only "df" is producer-capable; the "lucene" alt is dropped
        IllegalStateException ex = expectThrows(
        // one worker setup = 7 total.
        // 3 partitions × 2 sides = 6 ShuffleScanInstructionNodes appended per plan alternative, prefixed by
        // sender counts so each worker task knows how many producers to await before draining.
/**
     *  mock with no PRODUCER capability (dropped). */
 * {@code HashShuffleDispatchTests} when the enumerated dispatchers were folded into the single general
        );
                List.of("node-0", "node-1"),
        assertTrue("first appended instruction is the worker setup", instr.get(0) instanceof ShuffleWorkerSetupInstructionNode);
            ShuffleEnrichment.canonicalInputId(1),
    /** A registry whose named backend declares DataTransferCapability(PRODUCER), so its plan alternatives
        assertEquals(5, left0.getExpectedSenders());
        // Last partition (offsets shifted by 1 because of the prepended worker setup).
    }
        assertEquals("right", right0.getSide());
        AnalyticsSearchBackendPlugin producerBackend = mock(AnalyticsSearchBackendPlugin.class);
            assertEquals(3, pn.getPartitionCount());
    }
            .get(0)
        StagePlan altB = new StagePlan(null, "df").withInstructions(List.of(new ShardScanInstructionNode()));
    public void testEnrichProducerAlternativesDropsNonShuffleCapableBackend() {
        assertEquals(2, left2.getShufflePartitionIndex());
            IllegalStateException.class,
        ShuffleScanInstructionNode right2 = (ShuffleScanInstructionNode) instr.get(6);
        when(registry.getBackend(org.mockito.ArgumentMatchers.anyString())).thenReturn(noTransferBackend);
        return registry;
            "qid",
        assertTrue(
            assertEquals("left", pn.getSide());
import org.opensearch.analytics.spi.ShardScanInstructionNode;
        assertEquals(9, left0.getTargetStageId());
        );
            shuffleCapableRegistry("df")
        );
                /* consumerStageId */ 9,
 * is verified in {@code HashShuffleJoinIT} / {@code GeneralSchedulerJoinIT}.
    private static Stage newProducerStage(int stageId, int partitionCount, List<Integer> hashKeys) {
            .instructions()
        );
 * SPDX-License-Identifier: Apache-2.0
        ShuffleEnrichment.enrichProducerAlternatives(
        List<InstructionNode> instr = consumer.getPlanAlternatives().get(0).instructions();
        // The setup placeholder carries partition=-1 (filled per-task downstream) plus BOTH sides' expected
        assertEquals(9, right0.getTargetStageId());
            List<InstructionNode> instr = plan.instructions();
    public void testCanonicalInputIdMatchesConvertorRewrite() {
            () -> ShuffleEnrichment.enrichProducerAlternatives(
 */
        assertEquals("placeholder partition is -1 until the per-task filter sets it", -1, setup.getPartitionIndex());
            ShuffleEnrichment.canonicalInputId(2)
            .get(0);
        assertEquals(4, setup.getTargetStageId());
import org.opensearch.analytics.spi.BackendCapabilityProvider;
        }
        assertEquals("left", left0.getSide());
        assertEquals("1 worker setup + 3 partitions × 2 sides = 7 instructions", 7, instr.size());
 * this file be licensed under the Apache-2.0 license or a
                "qid",
        Stage producer = newProducerStage(/* stageId */ 1, /* partitionCount */ 3, /* hashKeys */ List.of(0));
        Stage consumer = new Stage(/* stageId */ 9, null, List.of(), null, null, null);
import org.opensearch.test.OpenSearchTestCase;
/*
    public void testEnrichWorkerAlternativesAppendsTwoScansPerPartition() {
    }
        assertEquals("input-12", right2.getNamedInputId());
        // NamedScan whose name follows the "input-<producerStageId>" convention; the consumer's handler must
        assertEquals(3, setup.getRightExpectedSenders());
        // A producer alternative whose backend cannot drive a shuffle (no DataTransferCapability(PRODUCER))
        when(noTransferCaps.dataTransferCapabilities()).thenReturn(Set.of());
        assertEquals("qid-test", right0.getQueryId());
        consumer.setPlanAlternatives(List.of(alt));
                List.of(0),
            /* preferHashJoin */ true
        assertEquals(0, left0.getShufflePartitionIndex());
import org.opensearch.analytics.spi.DataTransferCapability;
        assertEquals("input-7", ShuffleEnrichment.canonicalInputId(7));
    }
    public void testWorkerSetupCarriesBothSidesExpectedSenders() {
 * compatible open source license.
import java.util.Set;
        // Spot-check naming and sender counts. The interleaving alternates left/right per partition so the
 * them. The end-to-end dispatch (cluster-wide producer/consumer concurrency, transport, native handlers)
        // join's two named inputs resolve in lockstep; names match the convertor's "input-<producerStageId>".
        assertEquals("input-11", left2.getNamedInputId());
        StagePlan altA = new StagePlan(null, "df").withInstructions(List.of(new ShardScanInstructionNode()));
            /* leftProducerStageId */ 11,
        AnalyticsSearchBackendPlugin noTransferBackend = mock(AnalyticsSearchBackendPlugin.class);
        assertEquals(2, enriched.size());
        // register its streaming table under exactly this name or the join fails to bind its inputs.
        assertNotEquals(
import static org.mockito.Mockito.when;
 * Unit tests for {@link ShuffleEnrichment}'s plan-mutation primitives — the per-stage instruction
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            consumer,
    private static CapabilityRegistry shuffleCapableRegistry(String producerBackendName) {
                producer,
 *
    }
 * attachment the general MPP scheduler relies on. These were ported from the deleted
            "must name the producer stage when no shuffle-capable alternative survives",
            assertTrue("scan stays first", instr.get(0) instanceof ShardScanInstructionNode);
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;
        BackendCapabilityProvider producerCaps = mock(BackendCapabilityProvider.class);
        for (StagePlan plan : enriched) {
        producer.setPlanAlternatives(List.of(altA, altB));
            "left",
                /* partitionCount */ 2,
import org.opensearch.analytics.planner.dag.Stage;
import static org.mockito.Mockito.mock;
            /* hashKeys */ List.of(0),
            /* rightProducerStageId */ 12,
        ShuffleScanInstructionNode left2 = (ShuffleScanInstructionNode) instr.get(5);
            "different producer stages must yield different names",
import org.opensearch.analytics.planner.dag.ExchangeInfo;
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
 */
        assertEquals(2, right2.getShufflePartitionIndex());
import org.opensearch.analytics.spi.InstructionNode;
     *  survive enrichProducerAlternatives' shuffle-capability filter. Any other backend id resolves to a
        ShuffleScanInstructionNode left0 = (ShuffleScanInstructionNode) instr.get(1);
        assertEquals(0, right0.getShufflePartitionIndex());
            assertTrue("producer instruction appended last", instr.get(1) instanceof ShuffleProducerInstructionNode);
package org.opensearch.analytics.exec.join;
                "left",
            ShuffleProducerInstructionNode pn = (ShuffleProducerInstructionNode) instr.get(1);
        assertEquals("qid", setup.getQueryId());
        }
        Stage consumer = new Stage(/* stageId */ 4, null, List.of(), null, null, null);
    }
        assertFalse("preferHashJoin flows through to the setup placeholder", setup.getPreferHashJoin());
            Set.of(new DataTransferCapability(DataTransferCapability.Kind.PRODUCER, "arrow-ipc-partitioned"))
