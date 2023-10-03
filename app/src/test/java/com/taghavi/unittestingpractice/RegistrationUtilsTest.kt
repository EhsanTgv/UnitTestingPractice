package com.taghavi.unittestingpractice

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correct repeated password returns true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "123456",
            "abcdef"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digits password returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "John",
            "abcdef5",
            "abcdef5"
        )
        assertThat(result).isFalse()
    }
}