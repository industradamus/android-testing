package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.junit.Test


class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        val tasks = listOf(Task("title", "desc", isCompleted = false))
        val result = getActiveAndCompletedStats(tasks)

        MatcherAssert.assertThat(result.activeTasksPercent, Is.`is`(100f))
        MatcherAssert.assertThat(result.completedTasksPercent, Is.`is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        val tasks = listOf(Task("title", "desc", isCompleted = true))
        val result = getActiveAndCompletedStats(tasks)

        MatcherAssert.assertThat(result.activeTasksPercent, Is.`is`(0f))
        MatcherAssert.assertThat(result.completedTasksPercent, Is.`is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsForSixty() {
        val tasks = listOf(
                Task(title = "Title1", description = "Description1", isCompleted = true),
                Task(title = "Title2", description = "Description2", isCompleted = false),
                Task(title = "Title3", description = "Description3", isCompleted = false),
                Task(title = "Title4", description = "Description4", isCompleted = true),
                Task(title = "Title5", description = "Description5", isCompleted = true))
        val result = getActiveAndCompletedStats(tasks)

        MatcherAssert.assertThat(result.completedTasksPercent, Is.`is`(60F))
        MatcherAssert.assertThat(result.activeTasksPercent, Is.`is`(40F))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        val tasks = emptyList<Task>()
        val result = getActiveAndCompletedStats(tasks)

        MatcherAssert.assertThat(result.completedTasksPercent, Is.`is`(0F))
        MatcherAssert.assertThat(result.activeTasksPercent, Is.`is`(0F))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsNull() {
        val tasks = null
        val result = getActiveAndCompletedStats(tasks)

        MatcherAssert.assertThat(result.completedTasksPercent, Is.`is`(0F))
        MatcherAssert.assertThat(result.activeTasksPercent, Is.`is`(0F))
    }
}