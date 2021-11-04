/*
 * Copyright © 2018-today Peter M. Stahl pemistahl@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pemistahl.lingua.api

import com.github.pemistahl.lingua.api.Language.CHINESE
import com.github.pemistahl.lingua.api.Language.ENGLISH
import com.github.pemistahl.lingua.api.Language.JAPANESE
import com.github.pemistahl.lingua.api.Language.KOREAN
import com.github.pemistahl.lingua.api.Language.LATIN
import com.github.pemistahl.lingua.api.Language.UNKNOWN
import com.github.pemistahl.lingua.internal.Alphabet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class LanguageTest {

    @Test
    fun `assert that all supported languages are available`() {
        assertThat(Language.all()).containsExactly(
            CHINESE, ENGLISH, JAPANESE, KOREAN, LATIN
        )
    }

    @Test
    fun `assert that all supported spoken languages are available`() {
        assertThat(Language.allSpokenOnes()).containsExactly(
            CHINESE, ENGLISH, JAPANESE, KOREAN
        )
    }

    @Test
    fun `assert that certain languages support Latin script`() {
        assertThat(Language.allWithLatinScript()).containsExactly(
            ENGLISH, LATIN
        )
    }

    @ParameterizedTest
    @MethodSource("filteredLanguagesProvider")
    internal fun `assert that languages support correct alphabets`(
        alphabet: Alphabet,
        expectedLanguages: List<Language>
    ) {
        assertThat(
            Language.values().filter { it.alphabets.contains(alphabet) }
        ).`as`(
            "alphabet '$alphabet'"
        ).containsExactlyElementsOf(
            expectedLanguages
        )
    }

    @ParameterizedTest
    @CsvSource(
        "ZH, CHINESE",
        "EN, ENGLISH",
        "JA, JAPANESE",
        "LA, LATIN"
    )
    fun `assert that correct language is returned for iso code`(isoCode: IsoCode639_1, language: Language) {
        assertThat(Language.getByIsoCode639_1(isoCode)).isEqualTo(language)
    }

    private fun filteredLanguagesProvider() = listOf(
        arguments(Alphabet.HAN, listOf(CHINESE, JAPANESE)),
        arguments(Alphabet.HANGUL, listOf(KOREAN)),
        arguments(Alphabet.HIRAGANA, listOf(JAPANESE)),
        arguments(Alphabet.KATAKANA, listOf(JAPANESE)),
        arguments(
            Alphabet.LATIN,
            listOf(
                ENGLISH,
                LATIN
            )
        ),
        arguments(Alphabet.NONE, listOf(UNKNOWN))
    )
}
