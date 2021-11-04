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

import com.github.pemistahl.lingua.api.IsoCode639_1.EN
import com.github.pemistahl.lingua.api.IsoCode639_1.JA
import com.github.pemistahl.lingua.api.IsoCode639_1.KO
import com.github.pemistahl.lingua.api.IsoCode639_1.LA
import com.github.pemistahl.lingua.api.IsoCode639_1.ZH
import com.github.pemistahl.lingua.api.IsoCode639_3.ENG
import com.github.pemistahl.lingua.api.IsoCode639_3.JPN
import com.github.pemistahl.lingua.api.IsoCode639_3.KOR
import com.github.pemistahl.lingua.api.IsoCode639_3.LAT
import com.github.pemistahl.lingua.api.IsoCode639_3.ZHO
import com.github.pemistahl.lingua.internal.Alphabet
import com.github.pemistahl.lingua.internal.Alphabet.CYRILLIC
import com.github.pemistahl.lingua.internal.Alphabet.DEVANAGARI
import com.github.pemistahl.lingua.internal.Alphabet.HAN
import com.github.pemistahl.lingua.internal.Alphabet.HANGUL
import com.github.pemistahl.lingua.internal.Alphabet.HIRAGANA
import com.github.pemistahl.lingua.internal.Alphabet.KATAKANA
import com.github.pemistahl.lingua.internal.Alphabet.NONE

/**
 * The supported detectable languages.
 */
enum class Language(
    val isoCode639_1: IsoCode639_1,
    val isoCode639_3: IsoCode639_3,
    internal val alphabets: Set<Alphabet>,
    internal val uniqueCharacters: String?
) {
    CHINESE(ZH, ZHO, setOf(HAN), null),
    ENGLISH(EN, ENG, setOf(Alphabet.LATIN), null),
    JAPANESE(JA, JPN, setOf(HIRAGANA, KATAKANA, HAN), null),
    KOREAN(KO, KOR, setOf(HANGUL), null),
    LATIN(LA, LAT, setOf(Alphabet.LATIN), null),

    /**
     * The imaginary unknown language.
     *
     * This value is returned if no language can be detected reliably.
     */
    UNKNOWN(IsoCode639_1.NONE, IsoCode639_3.NONE, setOf(NONE), null);

    companion object {
        /**
         * Returns a list of all built-in languages.
         */
        @JvmStatic
        fun all() = filterOutLanguages(UNKNOWN)

        /**
         * Returns a list of all built-in languages that are still spoken today.
         */
        @JvmStatic
        fun allSpokenOnes() = filterOutLanguages(UNKNOWN, LATIN)

        /**
         * Returns a list of all built-in languages supporting the Arabic script.
         */
        @JvmStatic
        fun allWithArabicScript() = values().filter { it.alphabets.contains(Alphabet.ARABIC) }

        /**
         * Returns a list of all built-in languages supporting the Cyrillic script.
         */
        @JvmStatic
        fun allWithCyrillicScript() = values().filter { it.alphabets.contains(CYRILLIC) }

        /**
         * Returns a list of all built-in languages supporting the Devanagari script.
         */
        @JvmStatic
        fun allWithDevanagariScript() = values().filter { it.alphabets.contains(DEVANAGARI) }

        /**
         * Returns a list of all built-in languages supporting the Latin script.
         */
        @JvmStatic
        fun allWithLatinScript() = values().filter { it.alphabets.contains(Alphabet.LATIN) }

        /**
         * Returns the language for the given ISO 639-1 code.
         */
        @JvmStatic
        fun getByIsoCode639_1(isoCode: IsoCode639_1) = values().find { it.isoCode639_1 == isoCode }!!

        /**
         * Returns the language for the given ISO 639-3 code.
         */
        @JvmStatic
        fun getByIsoCode639_3(isoCode: IsoCode639_3) = values().find { it.isoCode639_3 == isoCode }!!

        private fun filterOutLanguages(vararg languages: Language) = values().filterNot { it in languages }
    }
}
