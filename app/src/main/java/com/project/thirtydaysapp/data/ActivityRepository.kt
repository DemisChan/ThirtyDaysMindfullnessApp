package com.project.thirtydaysapp.data

import com.project.thirtydaysapp.R

object ActivityRepository {
    val activities = (1..19).map { day ->
        Activity(
            imageResourceId = getResourceIdForDay(day),
            content = getResourceIdForContent(day),
            heading = getResourceIdForHeading(day),
            day = getResourceIdForTitle(day),
        )
    }

    private fun getResourceIdForDay(day: Int): Int {
        return when (day) {
            // Map day to corresponding resource ID
            1 -> R.drawable.day_1
            2 -> R.drawable.day_2
            3 -> R.drawable.day_3
            4 -> R.drawable.day_4
            5 -> R.drawable.day_5
            6 -> R.drawable.day_6
            7 -> R.drawable.day_7
            8 -> R.drawable.day_8
            9 -> R.drawable.day_9
            10 -> R.drawable.day_10
            11 -> R.drawable.day_11
            12 -> R.drawable.day_12
            13 -> R.drawable.day_13
            14 -> R.drawable.day_14
            15 -> R.drawable.day_15
            16 -> R.drawable.day_16
            17 -> R.drawable.day_17
            18 -> R.drawable.day_18
            19 -> R.drawable.day_19
            else -> R.drawable.day_1
        }
    }

    private fun getResourceIdForContent(day: Int): Int {
        return when (day) {
            // Map day to corresponding content resource ID
            1 -> R.string.Day_1_content
            2 -> R.string.Day_2_content
            3 -> R.string.Day_3_content
            4 -> R.string.Day_4_content
            5 -> R.string.Day_5_content
            6 -> R.string.Day_6_content
            7 -> R.string.Day_7_content
            8 -> R.string.Day_8_content
            9 -> R.string.Day_9_content
            10 -> R.string.Day_10_content
            11 -> R.string.Day_11_content
            12 -> R.string.Day_12_content
            13 -> R.string.Day_13_content
            14 -> R.string.Day_14_content
            15 -> R.string.Day_15_content
            16 -> R.string.Day_16_content
            17 -> R.string.Day_17_content
            18 -> R.string.Day_18_content
            19 -> R.string.Day_19_content
            else -> R.string.Day_1_content
        }
    }

    private fun getResourceIdForHeading(day: Int): Int {
        return when (day) {
            // Map day to corresponding heading resource ID
            1 -> R.string.Day_1_heading
            2 -> R.string.Day_2_heading
            3 -> R.string.Day_3_heading
            4 -> R.string.Day_4_heading
            5 -> R.string.Day_5_heading
            6 -> R.string.Day_6_heading
            7 -> R.string.Day_7_heading
            8 -> R.string.Day_8_heading
            9 -> R.string.Day_9_heading
            10 -> R.string.Day_10_heading
            11 -> R.string.Day_11_heading
            12 -> R.string.Day_12_heading
            13 -> R.string.Day_13_heading
            14 -> R.string.Day_14_heading
            15 -> R.string.Day_15_heading
            16 -> R.string.Day_16_heading
            17 -> R.string.Day_17_heading
            18 -> R.string.Day_18_heading
            19 -> R.string.Day_19_heading
            else -> R.string.Day_1_heading
        }
    }

    private fun getResourceIdForTitle(day: Int): Int {
        return when (day) {
            // Map day to corresponding title resource ID
            1 -> R.string.Day_1_title
            2 -> R.string.Day_2_title
            3 -> R.string.Day_3_title
            4 -> R.string.Day_4_title
            5 -> R.string.Day_5_title
            6 -> R.string.Day_6_title
            7 -> R.string.Day_7_title
            8 -> R.string.Day_8_title
            9 -> R.string.Day_9_title
            10 -> R.string.Day_10_title
            11 -> R.string.Day_11_title
            12 -> R.string.Day_12_title
            13 -> R.string.Day_13_title
            14 -> R.string.Day_14_title
            15 -> R.string.Day_15_title
            16 -> R.string.Day_16_title
            17 -> R.string.Day_17_title
            18 -> R.string.Day_18_title
            19 -> R.string.Day_19_title
            else -> R.string.Day_1_title
        }
    }
}