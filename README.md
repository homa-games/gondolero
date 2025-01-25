### Линтер

Линтер настроен через [ktlint-gradle](https://github.com/JLLeitschuh/ktlint-gradle)

Для запуска проверки необходимо выполнить
```sh
./gradlew ktlintCheck --continue
```

Линтер автоматически запускается перед каждым push через скрипт [pre-push](.git/hooks/pre-push)