package com.example.soundsavvyapp.common.constants

class SoundSavvyConstants private constructor(){
    object ERROR{
        const val UNKNOWN_ERROR = "Erro desconhecido"
        const val SERVICE_ERROR= "Erro servidor"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object VIEW{
        const val RESTART = "Carregar Novamente"
        const val CANCEL= "Cancelar"
    }

}