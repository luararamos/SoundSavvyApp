package com.example.soundsavvyapp.common.constants

class SoundSavvyConstants private constructor(){

    object KEY {
        const val API_KEY = "d44f537f51e027d1c9a19faa452f8149"
    }
    object ERROR{
        const val UNKNOWN_ERROR = "Erro desconhecido"
        const val SERVICE_ERROR= "Erro servidor"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object HEADER {
        const val TOKEN_KEY = "token"
        const val PERSON_KEY = "personkey"
    }
}