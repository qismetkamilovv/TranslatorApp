
# Translator App

## Github
1. Create Github repository named TranslatorApp (və ya TərcüməçiApp) and clone repo.

## Requirments for project
- Your project will be command-line project
- For first version you only need 1 argument to run your program.
    Example command:
    ```console
    java TranslatorApp your_word_to_translate
    ```
- and it will translate word or sentence (word preferable) and save to your DB and print translation to console.
- package structure TranslatoreApp (it will be project folder)
```
|── TranslatorApp
|── TranslatorApp.java
|── dbconfig
|  |── DataSourceConfig.java
|── client
|  |── GoogleTranslatorApiClient.java
|── servive
|  |── TranslatorService.java
|── README.md
└── .gitignore

```


---
## Google API configuration

2.  We are going to use Google's free translation API.
    > Google translator API documentation: 
    [doc](https://translation.googleapis.com/language/translate/v2)

    To use google trasnlator api you need to install gcloud to authenticate your calls to API.
    [Follow instructions](https://cloud.google.com/docs/authentication/rest#curl )

    To get auth token use following command on CLI
    > gcloud auth print-access-token

### How to call API?
I will help you in this part.
```java
HttpRequest.header("Authorization", "your_toke")
            .header("x-goog-user-project", "your_project_id")
            .header("Content-Type" "application/json; charset=utf-8")
            ..POST(HttpRequest.BodyPublishers.ofString("your_json_request_body"))
```

To create JSON request body go to JSON section below.

<mark>if you have difficulties ask me</mark>

---
## Use Java native library

3. Use java.net.http for Rest request.
   > [How to use instruction](https://www.baeldung.com/java-http-request)

---
## Use Database to save your translations
It would be simple MySQL database with probably only 1 table and name it "translations".

Example table

| en_word | translation_az |
| ------- | -------------- |
| car     | maşın          |

---
## How to handle JSON?

To work with JSON (to read response data more easily I will send necessary code which will be simple package). API response is follows:

JSON response body:
```json
{
  "data": {
    "translations": [
      {
        "detectedSourceLanguage": "string",
        "model": "string",
        "translatedText": "string"
      }
    ]
  }
}
```

API returns array of translated text but when you translate to Az it only returns one translation (as far as I'm saw).
To read that translation you only need to get **translatedText** object. Example code in Java below.

```java
JsonValue json = Json.parse(response.body());
                String value = json.asObject().get("data")
                                .asObject().get("translations")
                                .asArray().get(0)
                                .asObject().get("translatedText").asString();
```

JSON request body:
```json
{
  "q": "hello",
  "source": "en",
  "target": "es"
}
```
"q" is where you put your text that you want to translate.

To create JSON request body using **minimaljson**
```java
Json.object().add("q", "text_you_want_to_translate") // text to translate
                                .add("source", "en") // translate from
                                .add("target", "az"); // translte to
```

To use this classes simply add **minimaljson** package to your base package 

---
## What will you learn?
- How to use **java.net.http** libary.
- You will be able call external API's
- How to work with JSON
- Authentication