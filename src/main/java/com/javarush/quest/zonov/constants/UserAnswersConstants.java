package com.javarush.quest.zonov.constants;

import java.util.HashSet;
import java.util.Set;

public class UserAnswersConstants {

    /* tavern.jsp*/
    public static final String NOT_YOUR_BUSINESS = "Не твоё дело, пёс!";
    public static final String I_STARVING_FOR_ADVENTURES = "Меня всегда тянула жажда приключений...";
    public static final String GIVE_YOUR_WORK = "Давай свою работёнку";
    public static final String I_DONT_LIKE_YOU = "Приключениям я рад, но ты мне не нравишься...";

    /* outsideTavern.jsp */
    public static final String DO_SILENT = "Действуем скрытно";
    public static final String  DO_BALDHEAD = "Действуем напролом";
    public static final String SILENT_MODE = "Что...как...аа, впрочем, меня уже ничего не удивляет, действуем скрытно - опыт показывает, что это самый верный способ";
    public static final String BALDHEADED_MODE = "Да, старик, можешь ты удивить старого воина, пойдем напролом, но сразу скажу - потерь будет много...с обеих сторон";

    /* cave.jsp silentMode */
    public static final String TELL_HONEST_PLAN = "Рассказать правдивый план";
    public static final String TELL_FAKE_PLAN = "Рассказать ложный план";
    public static final String PLAN_SILENT_MODE = "Я всё еще немного удивлен вашей осведомленностью о моих делах... но это сейчас не важно.\n" +
            "Итак, от Вас мне нужно наделать много шума в городе, мятеж вполне подойдет, в открытое противостояние не вступайте, это слишком опасно.\n" +
            "Если Вам известны тайные ходы в замок - стоит мне сообщить, это сэкономит большое количество времени.\n" +
            "Ну, и напоследок...\n";

    public static final String MY = "Мой ";
    public static final String SMELLS_BETRAYAL = " не так прост, как кажется на первый взгляд, он за версту чует предательство...";
    public static final String GOTCHA = "Попался! Эй, колдун, поговори-ка с ним с глазу на глаз, посмотрим, что получится выведать и догоняй, буду ждать тебя у замка...\n" +
            " от всех жду мятеж через час. И да прибудет с нами сила!";

    /* cave.jsp baldHeadMode */
    public static final String KILL_RATS = "План подождёт, сначала нужно избавиться от крыс... так и знал, что здесь не обойдется без предателя... в любом случае, он уже ничего никому не расскажет." +
            "Время действовать! План такой - выдвигаемся сейчас, застаем их врасплох и уничтожаем всю династию узурпаторов власти на корню!";
    public static final String KILL_WIZARD = "Убить трактирщика";
    public static final String  KILL_ONE_OF_GENERALS = "Убить одного из генералов";
    public static final String I_TIRED_AND_WANT_SILENT = "Пожалуй, ты прав, хватит на сегодня бессмысленных жертв. Сделаем все по-тихому. Ты идешь со мной, остальные должны " +
            "отвлечь все внимание стражи на себя, прямого противостояния избегаем, но город должен быть в огне, вся надежда на вас!";
    public static final String NONSENSE = "Что за чепуха! Неужели ты хочешь отступить, когда победа так близка! Нам нужно действовать решительно, время полумер прошло!";
}
