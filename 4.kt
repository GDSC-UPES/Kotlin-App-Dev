private var sourceLanguageText= ""
    private fun validateData() {
        sourceLanguageText = SourceLang.text.toString().trim()
        Log.d(TAG, "validateData: sourceLanguageText: $sourceLanguageText")

        if (sourceLanguageText.isEmpty()) {
            showToast("Enter Text to Translate")
        } else
            startTranslation()
    }

    val map = HashMap<String, String>()

    private fun loadAvailableLanguages() {
        LangArrayList = ArrayList()
        val languageCodeList = TranslateLanguage.getAllLanguages()

        for (languageCode in languageCodeList) {
            val languageTitle = Locale(languageCode).displayLanguage
            Log.d(TAG, "loadAvailableLanguages: languageCode: $languageCode")
            Log.d(TAG, "loadAvailableLanguages: languageTitle: $languageTitle")

            val modelLanguage = ModelLanguage(languageCode, languageTitle)
            LangArrayList!!.add(modelLanguage)
            map[languageCode] = languageTitle
        }
    }