package com.example.soundsavvyapp.common.constants

class SoundSavvyConstants private constructor(){
    object ERROR{
        const val UNKNOWN_ERROR = "Erro desconhecido"
        const val SERVICE_ERROR= "Um erro inesperado ocorreu. Tente novamente mais tarde."
        const val ERROR_UNEXPECTED= "Erro servidor"
        const val ERROR_LOAD_RAKING= "Erro ao carregar a tarefa."
        const val ERROR_INTERNET_CONNECTION= "Conexão à internet necessária para uso da applicação."

    }

    object HTTP {
        const val SUCCESS = 200
    }

    object VIEW{
        const val RESTART = "Carregar Novamente"
        const val CANCEL= "Cancelar"
    }

}