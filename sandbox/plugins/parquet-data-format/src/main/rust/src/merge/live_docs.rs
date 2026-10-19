//! module owns only the core word/bit lookup so the sorted and unsorted mergers cannot drift.
        assert!(is_alive_in_words(&words, 3, 99));
//! Live bits arrive as a packed bitset in Lucene `FixedBitSet#getBits()` layout: bit `i` set
    fn test_beyond_word_length_is_alive() {
    use super::*;
 * this file be licensed under the Apache-2.0 license or a
    }
        assert!(!is_alive_in_words(&words, 128, 63));
    }
    }
    #[test]
/// - Word beyond the bitset length → alive (same reasoning)
 * SPDX-License-Identifier: Apache-2.0
        return true;
 * The OpenSearch Contributors require contributions made to
    let word_idx = (abs_row_id / 64) as usize;
/*
#[cfg(test)]
/// - Row at or beyond `num_rows` → alive (defensive: the Java contract is that absent bits mean alive)
/// Returns `true` if the row at `abs_row_id` is alive in `words`.
        assert!(is_alive_in_words(&words, 128, 64));
    match words.get(word_idx) {
    #[test]
    #[test]
        let words = [0u64, 0b1u64]; // only row 64 alive
 * compatible open source license.
    let bit_idx = abs_row_id % 64;
        let words = [0b101u64]; // rows 0,2 alive; row 1 dead
    fn test_beyond_num_rows_is_alive() {
//!
//! Shared live-docs bitset check for merge filtering.
        assert!(is_alive_in_words(&words, 130, 100));
        Some(&word) => (word & (1u64 << bit_idx)) != 0,
        let words = [0u64];
    if abs_row_id >= num_rows {
    fn test_crosses_word_boundary() {
#[inline]
        assert!(!is_alive_in_words(&words, 128, 65));
    fn test_specific_bits() {
 *
        assert!(!is_alive_in_words(&words, 3, 1));
}
    }
}
    }
    #[test]
//! means row `i` is alive. Callers hold an `Option<...>` and treat `None` as "all alive"; this
mod tests {
///
pub fn is_alive_in_words(words: &[u64], num_rows: u64, abs_row_id: u64) -> bool {
        None => true,
    }
        assert!(is_alive_in_words(&words, 3, 0));
 */
        assert!(is_alive_in_words(&words, 3, 2));
        // num_rows says 130 rows exist but only one word was supplied.
        let words = [0b101u64];
