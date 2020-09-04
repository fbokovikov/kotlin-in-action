package kotlin_in_action.facebook.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class FindKthLargestTest {

    @ParameterizedTest
    @MethodSource("partitionArgs")
    fun partition(nums: IntArray, from: Int, to: Int, pivot: Int, expectedPos: Int, expectedPartition: IntArray) {
        val pos = partition(nums, from, to, pivot)
        assertEquals(expectedPos, pos)
        Assertions.assertArrayEquals(expectedPartition, nums)
    }

    companion object {
        @JvmStatic
        fun partitionArgs(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(3, 2, 1, 5, 6, 4), 0, 5, /*pivot*/ 3, 2, intArrayOf(2, 1, 3, 5, 6, 4)),
                Arguments.of(intArrayOf(3, 2, 1, 5, 6, 4), 0, 5, /*pivot*/ 1, 0, intArrayOf(3, 2, 1, 5, 6, 4)),
                Arguments.of(intArrayOf(3, 2, 1, 5, 6, 4), 0, 5, /*pivot*/ 2, 1, intArrayOf(1, 2, 3, 5, 6, 4)),
                Arguments.of(intArrayOf(3, 2, 1, 5, 6, 4), 0, 5, /*pivot*/ 6, 5, intArrayOf(3, 2, 1, 5, 4, 6))
            )
        }
    }
}