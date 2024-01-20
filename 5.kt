    private fun chooseSourceLang() {
        ArrayAdapter.createFromResource(
            this@MainActivity,
            R.array.all_languages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sourcelangchoice.adapter = adapter
        }
        sourcelangchoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                sourceLangTitle = sourcelangchoice.selectedItem.toString()
                SourceLang.hint = "Enter $sourceLangTitle"
                sourceLangCode= map.entries.find { it.value == sourceLangTitle }?.key.toString()
            }


                override fun onNothingSelected(parent: AdapterView<*>?) {
                    showToast("Choose a language!")
                }
            }
        }

    private fun chooseTransLang(){
       ArrayAdapter.createFromResource(
            this@MainActivity,
            R.array.all_languages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            translangchoice.adapter = adapter
        }

        translangchoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Handle item selection for the target language Spinner
                TranslatedLangTitle = translangchoice.selectedItem.toString()
                TranslatedLangCode= map.entries.find { it.value == TranslatedLangTitle }?.key.toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                showToast("Choose a language!")
            }
        }
    }