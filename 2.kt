    private lateinit var SourceLang: EditText
    private lateinit var TranslatedLang: TextView
    private lateinit var sourcelangchoice: Spinner
    private lateinit var translangchoice: Spinner
    private lateinit var translatebtn: MaterialButton

    companion object {
        //      to print logs
        private const val TAG = "MAIN_TAG"
    }

    //  list with languages and codes
    private var LangArrayList: ArrayList<ModelLanguage>? = null

    private lateinit var sourceLangTitle: String
    private var TranslatedLangTitle= ""
    private var sourceLangCode=  ""
    private var TranslatedLangCode= ""

    private lateinit var translatorOptions: TranslatorOptions
    private lateinit var progressDialog: ProgressDialog
    private lateinit var translator: Translator