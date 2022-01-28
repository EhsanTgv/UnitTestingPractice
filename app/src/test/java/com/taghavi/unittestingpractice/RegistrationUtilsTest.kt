package com.taghavi.unittestingpractice

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun emptyUsernameReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validUsernameAndCorrectRepeatedPasswordReturnsTrue() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun usernameAlreadyExistsReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun incorrectlyConfirmedPasswordReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "123456",
            "abcdef"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPasswordReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun lessThan2DigitsPasswordReturnsFalse() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }
}