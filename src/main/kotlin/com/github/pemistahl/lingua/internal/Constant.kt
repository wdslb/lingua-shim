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

package com.github.pemistahl.lingua.internal

import com.github.pemistahl.lingua.api.Language.CHINESE
import com.github.pemistahl.lingua.api.Language.JAPANESE
import com.github.pemistahl.lingua.api.Language.KOREAN

internal object Constant {
    val JAPANESE_CHARACTER_SET =
        Regex("^[\\p{IsHiragana}\\p{IsKatakana}\\p{IsHan}]+$")
    val LANGUAGES_SUPPORTING_LOGOGRAMS = setOf(CHINESE, JAPANESE, KOREAN)
    val MULTIPLE_WHITESPACE = Regex("\\s+")
    val NO_LETTER = Regex("^[^\\p{L}]+$")
    val NUMBERS = Regex("\\p{N}")
    val PUNCTUATION = Regex("\\p{P}")
}
