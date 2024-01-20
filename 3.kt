SourceLang = findViewById(R.id.SourceLang)
        TranslatedLang = findViewById(R.id.TranslatedLang)
        sourcelangchoice = findViewById(R.id.sourcelangchoice)
        translangchoice = findViewById(R.id.translangchoice)
        translatebtn = findViewById(R.id.translatebtn)

//      displays dialogue, this provides context to the constructor
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)


        loadAvailableLanguages()
        chooseSourceLang()
        chooseTransLang()

        translatebtn.setOnClickListener {
            validateData()
        }