    private fun startTranslation()  {
        progressDialog.setMessage("Processing Language Model")
        progressDialog.show()

//      creating a translator object
        translatorOptions = TranslatorOptions.Builder()
            .setSourceLanguage(sourceLangCode)
            .setTargetLanguage(TranslatedLangCode)
            .build()
        translator = Translation.getClient(translatorOptions)
        translator = Translation.getClient(translatorOptions)
        lifecycle.addObserver(translator)
        val downloadConditions = DownloadConditions.Builder()
            .requireWifi()
            .build()


        translator.downloadModelIfNeeded(downloadConditions)
            .addOnSuccessListener {
                Log.d(TAG, "startTranslation: model ready, start translation")

                progressDialog.setMessage("Translating")

                translator.translate(sourceLanguageText)
                    .addOnSuccessListener { translatedText ->
                        Log.d(TAG, "startTranslation: translatedText: $translatedText")
                        progressDialog.dismiss()


                        TranslatedLang.text = translatedText
//                        translator.close()
                    }
                    .addOnFailureListener { e ->
                        progressDialog.dismiss()
                        Log.e(TAG, "startTranslation:", e)
                        showToast("failure due to ${e.message}")
                    }
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Log.e(TAG, "startTranslation:", e)
                showToast("failure in downloading- ${e.message}")
            }
    }

    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}