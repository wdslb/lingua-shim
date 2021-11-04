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

/**
 * The ISO 639-1 code representations for the supported languages.
 *
 * ISO 639 is a standardized nomenclature used to classify languages.
 */
enum class IsoCode639_1 {

    /**
     * The ISO 639-1 code for [English][Language.ENGLISH].
     */
    EN,

    /**
     * The ISO 639-1 code for [Japanese][Language.JAPANESE].
     */
    JA,

    /**
     * The ISO 639-1 code for [Korean][Language.KOREAN].
     */
    KO,

    /**
     * The ISO 639-1 code for [Latin][Language.LATIN].
     */
    LA,

    /**
     * The ISO 639-1 code for [Chinese][Language.CHINESE].
     */
    ZH,

    /**
     * The ISO 639-1 code for [the imaginary unknown language][Language.UNKNOWN].
     */
    NONE;

    override fun toString() = this.name.toLowerCase()
}
