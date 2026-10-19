        let c = PhantomCorrector::new(initial_phantom, estimated_batch, pipeline_slots);
        let mut phantom = initial_phantom as i64;
        let prev = self.ema_batch_bytes_x1000.load(Ordering::Relaxed);
    use super::*;
    /// Take the accumulated correction delta. Returns 0 if no correction pending.
    pub fn take_pending_delta(&self) -> i64 {
        for _ in 0..8 {
        let initial_phantom = estimated_batch * pipeline_slots;
/// Minimum batches before corrections start (EMA warmup).
            "Convergence after 50 batches: phantom={}B, ideal={}B, ratio={:.2}x",
        let count = self.batches_observed.fetch_add(1, Ordering::Relaxed) + 1;
            estimated_batch_bytes: measured_batch_bytes,
    }
        );
        }
            return;
            "First correction took {} batches — too slow",
                first_correction_at = i + 1;
            if delta != 0 {
        let estimated_batch = 100 * 8192; // schema-based (over-estimate)
//!
use std::sync::atomic::{AtomicI64, AtomicU64, AtomicUsize, Ordering};
        );
    /// = target_partitions × PARTITION_BUFFER_MULTIPLIER + 1 (output channel)
            "Bloat ratio {:.2}x is outside [0.85, 1.15] — corrector not converging",
    current_phantom_bytes: AtomicI64,
    /// Number of concurrent batch slots in the pipeline that the phantom covers.
            "Metadata-seeded convergence after 20 batches: phantom={}B, ideal={}B, ratio={:.2}x",
        // Metadata says 60 bytes/row, actual is 56 — very close
        // Schema estimate: 100 bytes/row → batch = 100 * 8192 = 819200
        // estimated: 100 bytes/batch × 10 = 1000
        let ideal_phantom = smoothed_batch_bytes * self.batches_in_pipeline as i64;
/// Only correct every N batches to avoid churning the reservation.
        assert_eq!(delta, 0);
            "Initial bloat: {:.2}x (corrects after {} batches = {} rows)",
#[cfg(test)]
            bloat_ratio
                phantom += delta;
            c.observe_batch(actual_batch);
    pub fn new_from_metadata(
    }
    fn check() {
    ) -> Self {
        // First correction should fire within 4-8 batches (warmup + interval)
            c.observe_batch(50);
/// Dead-band: don't correct if difference is within this fraction of current.
    batches_in_pipeline: usize,
        // estimated: 200 bytes/batch × 10 = 2000 phantom
    /// Measures convergence with metadata-seeded corrector (tighter from start).
        initial_phantom_bytes: usize,
                .fetch_add(diff, Ordering::Relaxed);
                break;
        let mut phantom = initial_phantom as i64;
        }
    /// Called by `stream_next` after delivering a batch to Java.
//! the caller applies to the `MemoryReservation` periodically.
// Send + Sync is auto-derived since all fields are atomic.
            let delta = c.take_pending_delta();
        assert!(delta > 0, "expected positive delta, got {}", delta);
pub struct PhantomCorrector {
        // Simulate 50 batches (typical scan of ~400K rows)
    /// Measures overhead: the initial over-estimate before correction kicks in.
        // Update EMA
    /// `CORRECTION_INTERVAL` batches after warmup.
        }
            initial_bloat,
        estimated_batch_bytes: usize,
            }
        // Feed enough observations to trigger: WARMUP(3) + needs to hit INTERVAL(4)
    ema_batch_bytes_x1000: AtomicU64,
        for _ in 0..20 {
            if delta != 0 && first_correction_at == 0 {
        let actual_batch = 56 * 8192;
        assert_eq!(c.take_pending_delta(), 0);
    }
}
            first_correction_at
            let delta = c.take_pending_delta();
    fn no_correction_during_warmup() {
const CORRECTION_THRESHOLD: f64 = 0.10;
    ///
//! Self-correcting phantom reservation based on observed batch sizes.
        let c = PhantomCorrector::new(1000, 100, 10);
        if count < WARMUP_BATCHES || count % CORRECTION_INTERVAL != 0 {
        if diff.abs() > threshold {
    pending_delta: AtomicI64,
    }
        Self {
const WARMUP_BATCHES: usize = 3;
            bloat_ratio >= 0.90 && bloat_ratio <= 1.10,
    /// so it only corrects if runtime batches differ from what metadata predicted.
//! The initial phantom is estimated from schema metadata. During execution,
            bloat_ratio >= 0.85 && bloat_ratio <= 1.15,
        let c = PhantomCorrector::new(1000, 100, 10);
        let new_ema =
    /// Simulates a full query lifecycle: estimate → observe → correct → converge.
        assert_eq!(second, 0);
    /// Measures the final bloat ratio (corrected_phantom / ideal_phantom).
    /// Read and reset by the caller via `take_pending_delta`.
    #[test]
        assert!(first != 0);
            (BATCH_EMA_ALPHA_X1000 * sample_x1000 + (1000 - BATCH_EMA_ALPHA_X1000) * prev) / 1000;
    /// Number of batches observed.
    pub fn observe_batch(&self, actual_batch_bytes: usize) {
        let delta = c.take_pending_delta();
            first_correction_at,
        let initial_bloat = initial_phantom as f64 / ideal_phantom as f64;
    fn initial_bloat_before_correction() {
        measured_batch_bytes: usize,
//! flowing through `CrossRtStream` and accumulates a correction delta that
            ema_batch_bytes_x1000: AtomicU64::new((measured_batch_bytes as u64) * 1000),
        for _ in 0..8 {
        initial_phantom_bytes: usize,
    }
        let pipeline_slots = 13;
        }
        }
            if delta != 0 {
 * compatible open source license.
            pending_delta: AtomicI64::new(0),
            current_phantom_bytes: AtomicI64::new(initial_phantom_bytes as i64),
                phantom += delta;
            "Metadata-seeded bloat ratio {:.2}x is outside [0.90, 1.10]",
            self.current_phantom_bytes
        let c = PhantomCorrector::new(1000, 100, 10);
    /// the measured value — corrections begin from the first batch if
        for i in 0..50 {
    #[test]
        }
            phantom, ideal_phantom, bloat_ratio
impl PhantomCorrector {
    #[test]
        );
            estimated_batch_bytes,
//! No mutex needed. The sequential stream_next contract ensures apply is
//! - `api::stream_next` (reads + applies corrections) — same sequential caller
    #[test]
        c.observe_batch(200);
            }
//!
        let c = PhantomCorrector::new(1000, 100, 10);
        self.ema_batch_bytes_x1000.store(new_ema, Ordering::Relaxed);
    ) -> Self {
            current_phantom_bytes: AtomicI64::new(initial_phantom_bytes as i64),
            c.observe_batch(105);
            ema_batch_bytes_x1000: AtomicU64::new((estimated_batch_bytes as u64) * 1000),
const BATCH_EMA_ALPHA_X1000: u64 = 400;
    /// - `estimated_batch_bytes`: `batch_size × avg_row_bytes` used in the estimate
        let delta = c.take_pending_delta();
    /// Current effective phantom bytes (tracks applied corrections).
    /// parquet metadata. Skips the warmup phase since the EMA starts at
            PhantomCorrector::new_from_metadata(initial_phantom, measured_batch, pipeline_slots);
    /// This is the "bloat window" — how much excess phantom is held during warmup.
        // actual: 105 bytes/batch → ideal = 1050, diff = 50, threshold = 100 (10%)
// Explicit assertion for documentation:
//! never concurrent with itself.
        // Count batches until first correction fires
            c.observe_batch(actual_batch);
            batches_observed: AtomicUsize::new(0),
        let delta = c.take_pending_delta();
        for _ in 0..4 {
        assert!(
    /// batch memory size and periodically computes a correction delta.
            c.observe_batch(300);
        let c =
        let estimated_batch = 100 * 8192;
    /// - `initial_phantom_bytes`: the phantom size reserved at query start
    #[inline]
    fn correction_after_warmup_and_interval() {
        batches_in_pipeline: usize,
        }
    ///
//! All fields are atomic. The corrector is shared (`Arc`) between:
        let smoothed_batch_bytes = (new_ema / 1000) as i64;
/// Self-correcting phantom observer. Lock-free, `Send + Sync`.
            batches_in_pipeline,
    /// phantom estimate. The corrector's EMA is seeded with the same value,
        assert!(delta < 0, "expected negative delta, got {}", delta);
        let actual_batch = 56 * 8192;
            batches_in_pipeline,
}
        // estimated: 100 bytes/batch × 10 slots = 1000 phantom
    /// Cost: ~15ns (2 atomic ops + arithmetic). Only computes delta every
        batches_in_pipeline: usize,
        let actual_batch = 40 * 8192; // actual (2.5x smaller)
        }
 * SPDX-License-Identifier: Apache-2.0
        assert!(
        }
        let second = c.take_pending_delta();
        let sample_x1000 = (actual_batch_bytes as u64) * 1000;
    /// Create a corrector pre-seeded with measured batch bytes from cached
        let measured_batch = 60 * 8192;
            }
    }
    #[inline]
    fn correction_shrinks_on_smaller_batches() {
        // Should be even tighter since starting point was already close
        // Compute what the phantom should be based on observed batch sizes
}
    #[test]
/*
    ///
    /// actual sizes deviate from the cached measurement.
        let ideal_phantom = actual_batch as i64 * pipeline_slots as i64;
};
    pub fn new(
        // After convergence, phantom should be within 15% of ideal (1.0-1.15x)
            // Pre-warmed: skip warmup since we trust metadata-derived estimate
    #[test]
            pending_delta: AtomicI64::new(0),
        let initial_phantom = estimated_batch * pipeline_slots;
mod tests {
        let first = c.take_pending_delta();
/// EMA alpha for batch size smoothing (0.4 = converges in ~3 samples).
    /// Called per-batch from `CrossRtStream::poll_next`. Observes the actual
            let delta = c.take_pending_delta();
        // Skip warmup and non-correction intervals
    fn assert_send_sync<T: Send + Sync>() {}
        let current = self.current_phantom_bytes.load(Ordering::Relaxed);
    /// EMA of actual batch bytes (×1000 fixed-point).
        let mut first_correction_at = 0usize;
        println!(
        // Actual at runtime: 56 bytes/row → batch = 56 * 8192 = 458752
        let diff = ideal_phantom - current;
//! actual `RecordBatch` sizes may differ. This module observes each batch
        );
//!
    fn take_resets_delta() {
        let initial_phantom = measured_batch * pipeline_slots;
        c.observe_batch(200);
    }
            first_correction_at <= 8,
    fn no_correction_within_deadband() {
    /// - `batches_in_pipeline`: how many batch-slots the phantom covers
 */
        let c = PhantomCorrector::new(initial_phantom, estimated_batch, pipeline_slots);
    }
            c.observe_batch(actual_batch);
    /// Accumulated correction delta (bytes). Positive = need more, negative = have excess.
            bloat_ratio
        println!(
        let bloat_ratio = phantom as f64 / ideal_phantom as f64;
    batches_observed: AtomicUsize,
 * this file be licensed under the Apache-2.0 license or a
        let threshold = (current as f64 * CORRECTION_THRESHOLD) as i64;
        // Should be positive (need more phantom)
//! # Thread safety
    #[test]
        // First 3 observations: no delta
const _: () = {
        let ideal_phantom = actual_batch * pipeline_slots;
    }
    estimated_batch_bytes: usize,
            c.observe_batch(200);
    }
        // 10 pipeline slots (4 partitions × 3 buffers + 1 output)
        let bloat_ratio = phantom as f64 / ideal_phantom as f64;
        let pipeline_slots = 13;
        // 50 < 100 → no correction
    }
//! - `CrossRtStream::poll_next` (writes observations) — runs on IO runtime
        Self {
    /// The per-batch bytes used in the original phantom estimate.
        // actual: 200 bytes/batch → ideal phantom = 2000
            self.pending_delta.fetch_add(diff, Ordering::Relaxed);
        for _ in 0..8 {
        self.pending_delta.swap(0, Ordering::Relaxed)
    /// Use this when `estimate_row_bytes_from_metadata` produced the initial
            phantom, ideal_phantom, bloat_ratio
//!
        let ideal_phantom = actual_batch as i64 * pipeline_slots as i64;
        // actual: 50 bytes/batch → ideal = 500
        );
const CORRECTION_INTERVAL: usize = 4;
    fn metadata_seeded_convergence() {
#[derive(Debug)]
    }
        assert!(
    fn convergence_bloat_ratio() {
 * The OpenSearch Contributors require contributions made to
        let c = PhantomCorrector::new(2000, 200, 10);
        println!(
        let pipeline_slots = 13; // 4×3 + 1
    /// Create a new corrector.
        // Should be negative (excess phantom)
        );
        }
        }
            batches_observed: AtomicUsize::new(WARMUP_BATCHES),
            first_correction_at * 8192
        assert_send_sync::<PhantomCorrector>();
    #[test]
    }
        for i in 0..50 {
 *
