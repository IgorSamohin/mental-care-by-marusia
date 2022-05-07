package com.polis.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
public enum MarusiaAnswer {
    EXIT_ANSWER("Возвращайтесь в следующий раз", "Возвращайтесь в следующий раз"),
    ERROR_ANSWER("Я Вас не поняла. Попробуйте ещё раз", "Я вас не поняла. Попробуйте ещё раз"),

    START_ANSWER("Привет! Я попробую оказать Вам первую помощь в борьбе со стрессом. Попросите меня дать совет, успокоить или отвлечь, чтобы начать. Или вы можете спросить, что я умею, для получения подробной информации.",
            "Привет! Я попробую оказать Вам первую помощь в борьбе со стрессом. Попросите меня дать совет, успокоить или отвлечь, чтобы начать. Вы также можете спросить, что я умею, для получения подробной информации."),

    //Ветка с отвлечением
    //TODO ВЫПИЛИТЬ ВОЗМОЖНО
    DISTRACTION_ANSWER(
            "Могу скинуть Вам упражнение из йоги, видео или музыку. Что выберите?",
            "Могу скинуть вам упражнение из ^йоги^, видео или музыку. Что выберите?"
    ),
    //FIXME В колонке не мб видео
//    YOGA_ANSWER("Смотрите, что я Вам нашла", "^Смотрите^, что я вам нашла")
    YOGA_ANSWER("К сожалению, эта функция сейчас недоступна", "К сожалению, эта функция сейчас недоступна."), // add more
    //    NUMBER_COUNT_TASK_ANSWER("Давайте поиграем!", "Давайте поиграем."),
    NUMBER_COUNT_TASK_ANSWER("К сожалению, эта функция сейчас недоступна", "К сожалению, эта функция сейчас недоступна."),

    //Ветка с советом
    ADVICE_FROM_PSYCHOLOGIST_ANSWER("По словам психологов, простые рутинные дела помогут отвлечься от стресса. Приготовьте себе покушать, сходите на прогулку или сделайте уборку и вам станет легче.",
            "По словам психологов, простые рутинные дела помогут отвлечься от стресса. Приготовьте себе покушать, сходите на прогулку или сделайте уборку и вам станет легче."),//todo add more

    //Ветка с помощью
    HELP_ANSWER(
            "Я могу отвлечь, успокоить и дать совет от психолога. Уточните для более развернутой информации.",
            "Я могу дать полезный совет, отвлечь или успокоить. Спросите, как я могу вас успокоить или отвлечь, для более подробной информации."
    ),
    HELP_DISTRACTION_ANSWER(
            "Я могу скинуть какое-нибудь отвлекающие видео или посчитать числа вместе с вами",
            "Я могу скинуть какое нибудь отвлекающие видео или посчитать ч`исла вместе с вами"
    ),
    HELP_SEDATION_ANSWER(
            "Я могу посоветовать Вам успокаивающее видео, включить звуки природы или музыку, " +
                    "а также скинуть дыхательное упражнение",
            "Я могу посоветовать вам успокаивающее видео, включить звуки природы или музыку, " +
                    "а также скинуть дыхательное упражнение"
    ),
    HELP_SEDATION_AND_DISTRACTION_ANSWER("Я могу посоветовать Вам видео, скинуть музыку или какое-нибудь упражнение.",
            "Я могу посоветовать вам видео, скинуть музыку или какое-нибудь упражнение."),

    //Ветка с успокоением
    //TODO ВЫПИЛИТЬ ВОЗМОЖНО
    SEDATION_ANSWER(
            "Я могу скинуть Вам успокаивающее видео, включить звуки природы, включить успокаивающую музыку, " +
                    "или скинуть дыхательное упражнение",
            "Я могу скинуть успокаивающее видео, включить звуки природы, включить успокаивающую музыку, " +
                    "или скинуть дыхательное упражнение. Что выберите?"
    ),

    //FIXME В колонке не мб видео
    VIDEO_ANSWER("Посмотрите это видео\n",//todo add more
            "Посмотрите это видео. Оно ^точно^ поможет отвлечься."),
    SOOTHING_SOUND_ANSWER("Включаю успокаивающие звуки", "Включаю успокаивающие звуки",//todo add more
            "Скоро я научусь включать вам звуки. Не могли бы Вы попросить включить звуки чирикающих птичек вне скилла?",
            "Скоро я научусь включать вам звуки. ^Не могли бы^ вы попросить включить звуки чирикающих птичек вне скилла?"),
    MUSIC_ANSWER("Включаю музыку", "Включаю музыку",//todo add more
            "Скоро я научусь включать вам музыку, а пока Вы можете попросить включить Моцарта вне скилла.",
            "Скоро я научусь включать вам музыку, а пока вы можете попросить включить Моцарта вне скилла."),
    BREATHING_EXERCISE_ANSWER(//todo add more
            """
                    Попробуйте выполнить это дыхательное упражнение:
                    1. Устройтесь поудобнее.
                    2. Сделайте полный выдох через рот.
                    3. Теперь закройте рот и начните считать про себя.
                    4. На счет четыре начните медленно выдыхать через нос.
                    5. На счет семь задержите дыхание.
                    6. На счет восемь выдохните полностью через рот.
                    7. Повторите еще три раза.""",
            """
                    Попробуйте выполнить это дыхательное упражнение:
                    Устройтесь поудобнее.
                    Сделайте полный выдох через рот.
                    Теперь закройте рот и начните считать про себя.
                    На счет четыре начните медленно выдыхать через нос.
                    На счет семь задержите дыхание.
                    На счет восемь выдохните полностью через рот.
                    Повторите еще три ^раза^"""
    ),
    HOME_ANSWER("Рада была Вам помочь. Хотите что-то еще?", "Рада была вам помочь. Хотите что-то еще?"),

    MEGA_REQUEST("", "");

    @JsonProperty("text")
    public final String text;
    @JsonProperty("tts")
    public final String tts;

    @JsonProperty("stub_text")
    public final String stubText;
    @JsonProperty("stub_tts")
    public final String stubTts;

    MarusiaAnswer(String text, String tts) {
        this(text, tts, null, null);
    }

    MarusiaAnswer(String text, String tts, String stubText, String stubTts) {
        this.text = text;
        this.tts = tts;
        this.stubText = stubText;
        this.stubTts = stubTts;
    }
}
