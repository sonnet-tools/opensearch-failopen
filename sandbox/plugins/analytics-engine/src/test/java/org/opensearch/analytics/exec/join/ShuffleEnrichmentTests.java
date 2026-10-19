    public void testWorkerSetupCarriesBothSidesExpectedSenders() {
        for (StagePlan plan : enriched) {
        assertEquals("left", left0.getSide());
        ShuffleWorkerSetupInstructionNode setup = (ShuffleWorkerSetupInstructionNode) consumer.getPlanAlternatives()
/**  
        // sender counts so each worker task knows how many producers to await before draining.
            /* preferHashJoin */ true
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(List.of(0), pn.getHashKeyChannels());
import org.opensearch.analytics.spi.BackendCapabilityProvider;  
        assertEquals(4, right0.getExpectedSenders());  
import org.opensearch.analytics.planner.dag.StagePlan;
        assertEquals(3, setup.getRightExpectedSenders());
    }  
        AnalyticsSearchBackendPlugin noTransferBackend = mock(AnalyticsSearchBackendPlugin.class);  
        assertEquals(4, setup.getTargetStageId());  
        // The fragment convertor strips OpenSearchShuffleExchange and rewrites the StageInputScan leaf to a
            assertTrue("appended instruction is a shuffle-scan", instr.get(i) instanceof ShuffleScanInstructionNode);
            consumer,  
    public void testEnrichProducerAlternativesDropsNonShuffleCapableBackend() {
        for (int i = 1; i < instr.size(); i++) {
/*  
            List.of("node-0", "node-1", "node-2"),
 * SPDX-License-Identifier: Apache-2.0
            /* consumerStageId */ 9,
        assertEquals("placeholder partition is -1 until the per-task filter sets it", -1, setup.getPartitionIndex());
        when(registry.getBackend(org.mockito.ArgumentMatchers.anyString())).thenReturn(noTransferBackend);
            /* rightExpectedSenders */ 4,  
            /* leftProducerStageId */ 11,
 */
        Stage producer = newProducerStage(/* stageId */ 1, /* partitionCount */ 2, List.of(0));  
     *  mock with no PRODUCER capability (dropped). */
        Stage consumer = new Stage(/* stageId */ 9, null, List.of(), null, null, null);
 * attachment the general MPP scheduler relies on. These were ported from the deleted
            ShuffleEnrichment.canonicalInputId(2)  
            ShuffleEnrichment.canonicalInputId(1),
            /* partitionCount */ 3,  
        // The setup placeholder carries partition=-1 (filled per-task downstream) plus BOTH sides' expected  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
import org.opensearch.analytics.planner.dag.ExchangeInfo;
        // Spot-check naming and sender counts. The interleaving alternates left/right per partition so the
        assertEquals("qid", setup.getQueryId());
            assertEquals("left", pn.getSide());
 * The OpenSearch Contributors require contributions made to  
        ShuffleScanInstructionNode right2 = (ShuffleScanInstructionNode) instr.get(6);
        assertTrue("first appended instruction is the worker setup", instr.get(0) instanceof ShuffleWorkerSetupInstructionNode);  
        assertEquals(0, right0.getShufflePartitionIndex());
        assertEquals(9, left0.getTargetStageId());
        );
            .get(0);
            "left",
        assertEquals(7, setup.getLeftExpectedSenders());  
        }  
        consumer.setPlanAlternatives(List.of(new StagePlan(null, "df")));  
        }
            IllegalStateException.class,
        AnalyticsSearchBackendPlugin producerBackend = mock(AnalyticsSearchBackendPlugin.class);
        // join's two named inputs resolve in lockstep; names match the convertor's "input-<producerStageId>".
        // Last partition (offsets shifted by 1 because of the prepended worker setup).
        assertEquals("1 worker setup + 3 partitions × 2 sides = 7 instructions", 7, instr.size());
        assertFalse("preferHashJoin flows through to the setup placeholder", setup.getPreferHashJoin());
                List.of("node-0", "node-1"),
            assertEquals(9, pn.getTargetStageId());  
                List.of(0),
    public void testEnrichWorkerAlternativesAppendsTwoScansPerPartition() {
import org.opensearch.analytics.spi.ShuffleProducerInstructionNode;
        // must be dropped so PlanAlternativeSelector can't pick a driver that throws at execution. With NO
        // NamedScan whose name follows the "input-<producerStageId>" convention; the consumer's handler must  
 * this file be licensed under the Apache-2.0 license or a
        StagePlan alt = new StagePlan(null, "df");
    public void testEnrichProducerAlternativesAppendsOneInstructionPerAlt() {
        assertEquals(0, left0.getShufflePartitionIndex());  
        CapabilityRegistry registry = mock(CapabilityRegistry.class);  
import org.opensearch.analytics.spi.DataTransferCapability;
            "different producer stages must yield different names",
 *
            assertTrue("scan stays first", instr.get(0) instanceof ShardScanInstructionNode);
            "qid",
        List<StagePlan> enriched = producer.getPlanAlternatives();  
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
        when(noTransferCaps.dataTransferCapabilities()).thenReturn(Set.of());
import org.opensearch.analytics.spi.ShardScanInstructionNode;  
            assertEquals("scan + producer = 2 instructions", 2, instr.size());
        ShuffleScanInstructionNode left0 = (ShuffleScanInstructionNode) instr.get(1);  
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;  
    }  
            producer,
        // capable alternative left, enrich must fail fast rather than emit an un-runnable producer.
        return new Stage(stageId, null, List.of(), ExchangeInfo.hashDistributed(hashKeys, partitionCount), null, null);
    private static CapabilityRegistry shuffleCapableRegistry(String producerBackendName) {
     *  survive enrichProducerAlternatives' shuffle-capability filter. Any other backend id resolves to a  
        assertEquals("qid-test", right0.getQueryId());  
 * is verified in {@code HashShuffleJoinIT} / {@code GeneralSchedulerJoinIT}.  
    }
 * compatible open source license.
        assertEquals("input-11", left0.getNamedInputId());
            shuffleCapableRegistry("df")  
                producer,  
        // 3 partitions × 2 sides = 6 ShuffleScanInstructionNodes appended per plan alternative, prefixed by
import static org.mockito.Mockito.when;
            /* hashKeys */ List.of(0),  
        );  
        BackendCapabilityProvider noTransferCaps = mock(BackendCapabilityProvider.class);
            Set.of(new DataTransferCapability(DataTransferCapability.Kind.PRODUCER, "arrow-ipc-partitioned"))
            ShuffleProducerInstructionNode pn = (ShuffleProducerInstructionNode) instr.get(1);
        assertEquals("input-11", left2.getNamedInputId());
            "must name the producer stage when no shuffle-capable alternative survives",
        BackendCapabilityProvider producerCaps = mock(BackendCapabilityProvider.class);  
 * path: the methods moved verbatim into {@link ShuffleEnrichment}, so the regression coverage moves with
        Stage consumer = new Stage(/* stageId */ 4, null, List.of(), null, null, null);
import java.util.List;  
            assertEquals(3, pn.getPartitionCount());  
 */  
            assertEquals("qid", pn.getQueryId());
 * Unit tests for {@link ShuffleEnrichment}'s plan-mutation primitives — the per-stage instruction
        assertEquals("input-7", ShuffleEnrichment.canonicalInputId(7));
        producer.setPlanAlternatives(List.of(altA, altB));
        assertEquals("input-12", right0.getNamedInputId());  
 * {@code HashShuffleDispatchTests} when the enumerated dispatchers were folded into the single general  
}
        IllegalStateException ex = expectThrows(  
            /* queryId */ "qid-test",
        ShuffleEnrichment.enrichProducerAlternatives(
        ShuffleEnrichment.enrichWorkerAlternatives(consumer, /* partitionCount */ 2, 7, 3, "qid", 1, 2, /* preferHashJoin */ false);
            assertEquals(List.of("node-0", "node-1", "node-2"), pn.getTargetWorkerNodeIds());
        when(producerCaps.dataTransferCapabilities()).thenReturn(
    }
            /* rightProducerStageId */ 12,  
        assertEquals(2, right2.getShufflePartitionIndex());
        when(noTransferBackend.getCapabilityProvider()).thenReturn(noTransferCaps);
        );
            .get(0)
import java.util.Set;
            ex.getMessage().contains("producer stage 1")  
        assertEquals(9, right0.getTargetStageId());
        // one worker setup = 7 total.  
            List<InstructionNode> instr = plan.instructions();  
        ShuffleScanInstructionNode left2 = (ShuffleScanInstructionNode) instr.get(5);  
            )
        ShuffleScanInstructionNode right0 = (ShuffleScanInstructionNode) instr.get(2);
                /* consumerStageId */ 9,  
        StagePlan altB = new StagePlan(null, "df").withInstructions(List.of(new ShardScanInstructionNode()));
        assertEquals("qid-test", left0.getQueryId());
        );  
        );
        assertEquals(2, left2.getShufflePartitionIndex());
        assertEquals("input-12", right2.getNamedInputId());  
import org.opensearch.analytics.planner.CapabilityRegistry;
                /* partitionCount */ 2,
        StagePlan altA = new StagePlan(null, "df").withInstructions(List.of(new ShardScanInstructionNode()));  
        when(producerBackend.getCapabilityProvider()).thenReturn(producerCaps);
        producer.setPlanAlternatives(List.of(new StagePlan(null, "lucene").withInstructions(List.of(new ShardScanInstructionNode()))));
import org.opensearch.analytics.spi.InstructionNode;
        // register its streaming table under exactly this name or the join fails to bind its inputs.
        when(registry.getBackend(producerBackendName)).thenReturn(producerBackend);
import org.opensearch.analytics.planner.dag.Stage;  
    }
package org.opensearch.analytics.exec.join;
import static org.mockito.Mockito.mock;  
        assertEquals(5, left0.getExpectedSenders());
        consumer.setPlanAlternatives(List.of(alt));  
    }
            /* leftExpectedSenders */ 5,
    }  
        // A producer alternative whose backend cannot drive a shuffle (no DataTransferCapability(PRODUCER))  
        Stage producer = newProducerStage(/* stageId */ 1, /* partitionCount */ 3, /* hashKeys */ List.of(0));
 * them. The end-to-end dispatch (cluster-wide producer/consumer concurrency, transport, native handlers)
                shuffleCapableRegistry("df") // only "df" is producer-capable; the "lucene" alt is dropped
        assertEquals("right", right0.getSide());
    private static Stage newProducerStage(int stageId, int partitionCount, List<Integer> hashKeys) {
            assertTrue("producer instruction appended last", instr.get(1) instanceof ShuffleProducerInstructionNode);  
        );
    /** A registry whose named backend declares DataTransferCapability(PRODUCER), so its plan alternatives
            /* partitionCount */ 3,
            () -> ShuffleEnrichment.enrichProducerAlternatives(
        return registry;  
        assertTrue(
public class ShuffleEnrichmentTests extends OpenSearchTestCase {
        ShuffleEnrichment.enrichWorkerAlternatives(
        assertNotEquals(  
    public void testCanonicalInputIdMatchesConvertorRewrite() {
                "qid",
        assertEquals(2, enriched.size());
            .instructions()  
                "left",  
        List<InstructionNode> instr = consumer.getPlanAlternatives().get(0).instructions();
