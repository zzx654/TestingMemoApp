package com.example.memocleanarchitecture.notes

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.example.data.di.DatabaseModule
import com.example.data.di.RepositoryModule
import com.example.domain.di.UseCaseModule
import com.example.domain.util.TestTags.ORDER_SECTION
import com.example.memocleanarchitecture.MainActivity
import com.example.memocleanarchitecture.ui.theme.MemoCleanArchitectureTheme
import com.example.memocleanarchitecture.util.Screen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
@UninstallModules(DatabaseModule::class, RepositoryModule::class, UseCaseModule::class)
class NotesScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            val navController = rememberNavController()
            MemoCleanArchitectureTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.NotesScreen.route
                ) {
                    composable(route = Screen.NotesScreen.route) {
                        NotesScreen(navController = navController)
                    }

                }

            }
        }
    }

    @Test
    fun clickToggleOrderSection_isVisible() {

        //val context = ApplicationProvider.getApplicationContext<Context>()
        composeRule.onNodeWithTag(ORDER_SECTION).assertDoesNotExist()
        composeRule.onNodeWithContentDescription("Sort").performClick()
        composeRule.onNodeWithTag(ORDER_SECTION).assertIsDisplayed()

    }
}