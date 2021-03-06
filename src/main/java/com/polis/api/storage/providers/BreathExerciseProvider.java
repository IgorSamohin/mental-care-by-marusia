package com.polis.api.storage.providers;

import com.polis.api.storage.model.Answer;
import com.polis.api.storage.model.BreathExerciseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BreathExerciseProvider {
    private final Map<Integer, BreathExerciseModel> map = new HashMap<>();

    public BreathExerciseModel getBreathExerciseModel(int stateId) {
        return map.get(stateId);
    }

    //*********************************
    // DATA todo - move into db or config files
    //*********************************

    @PostConstruct
    private void init() {
        map.put(6, new BreathExerciseModel(new Answer[]{
                new Answer(
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
                                На счет семь задерж`ите дыхание.
                                На счет восемь выдохните полностью через рот.
                                Повторите еще три раза."""
                ),
                new Answer("""
                        1. Сядьте на стул со спинкой или лягте на спину на кровать.
                        2. Вдыхайте через нос в течение 4 секунд.
                        3. Постарайтесь задержать дыхание на 8 секунд.
                        4. Медленно выдыхайте через сложенные в трубочку губы (будто задуваете свечи) в течение 8 секунд.
                        5. Отдохните 2 секунды и повторите упражнение 3 раза.
                        """,
                        """
                                Сядьте на стул со спинкой или лягте на спину на кровать.
                                Вдыхайте через нос в течение четырех секунд.
                                Постарайтесь задержать дыхание на восемь секунд.
                                Медленно выдыхайте через сложенные в трубочку губы (будто задуваете св`ечи) в течение восьми секунд.
                                Отдохните две секунды и повторите упражнение три раза.
                                """),
                new Answer("""
                        1. Сядьте на стул со спинкой или лягте на спину на кровать.
                        2. Сделайте глубокий вдох носом, затем быстро вдохните носом еще минимум 3 раза (не выдыхая)
                        3. Медленно выдохните через сложенные в трубочку губы (будто задуваете свечи).
                        4. Отдохните 2 секунды и повторите упражнение 3 раза.
                        """,
                        """
                                Сядьте на стул со спинкой или лягте на спину на кровать.
                                Сделайте глубокий вдох носом, затем быстро вдохните носом еще минимум три раза (не выдыхая)
                                Медленно выдохните через сложенные в трубочку губы (будто задуваете св`ечи).
                                Отдохните две секунды и повторите упражнение три раза.
                                """),
                new Answer("""
                        1. Сядьте на стул со спинкой или лягте на спину на кровать.
                        2. Осторожно сведите лопатки и опустите их вниз.
                        3. Сцепите руки в замок и медленно поднимите руки над головой, так высоко, как сможете, делая при этом глубокий вдох.
                        4. Выдыхайте, медленно опуская руки.
                        5. Отдохните 2 секунды и повторите упражнение 5 раз.
                        """,
                        """
                                Сядьте на стул со спинкой или лягте на спину на кровать.
                                Осторожно сведите лопатки и опустите их вниз.
                                Сцепите руки в замок и медленно поднимите руки над головой, так высоко, как сможете, делая при этом глубокий вдох.
                                Выдыхайте, медленно опуская руки.
                                Отдохните две секунды и повторите упражнение пять раз.
                                        """),
                new Answer("""
                        1. Сядьте на стул со спинкой или лягте на спину на кровать.
                        2. Исходное положение — руки вдоль туловища, расслаблены, ладони направлены вверх. Осторожно сведите лопатки и опустите их вниз. При этом ваша грудь должна выпятиться колесом.
                        3. Вдохните носом и выдохните через сложенные в трубочку губы (будто задуваете свечи).
                        4. Отдохните 2 секунды и повторите упражнение 5 раз.
                        """,
                        """
                                Сядьте на стул со спинкой или лягте на спину на кровать.
                                Исходное положение — руки вдоль туловища, расслаблены, ладони направлены вверх. Осторожно сведите лопатки и опустите их вниз. При этом ваша грудь должна выпятиться колесом.
                                Вдохните носом и выдохните через сложенные в трубочку губы (будто задуваете св`ечи).
                                Отдохните две секунды и повторите упражнение пять раз.
                                         """),
                new Answer("""
                        Лягте на спину или сядьте на стул со спинкой.
                        Положите одну или обе руки себе на живот.
                        Медленно и глубоко вдохните через нос. Живот должен подняться, но верхняя часть груди должна оставаться неподвижной и расслабленной.
                        Медленно выдохните через сложенные в трубочку губы (будто задуваете свечи). Вместе с выдохом медленно и аккуратно подтягивайте живот к позвоночнику.
                        Повторите 5 раз.
                        """,
                        """
                                Лягте на спину или сядьте на стул со спинкой.
                                Положите одну или обе руки себе на живот.
                                Медленно и глубоко вдохните через нос. Живот должен подняться, но верхняя часть груди должна оставаться неподвижной и расслабленной.
                                Медленно выдохните через сложенные в трубочку губы (будто задуваете св`ечи). Вместе с выдохом медленно и аккуратно подтягивайте живот к позвоночнику.
                                Повторите пять раз.
                                        """),
                new Answer("""
                        1. Удобно сядьте или лягте на спину на кровати, руки расслаблены и находятся вдоль туловища.
                        2. Круговым движением переместите плечи вперед, вверх, назад и вниз.
                        3. Повторите 5 раз.
                        """,
                        """
                                Удобно сядьте или лягте на спину на кровать, руки расслаблены и находятся вдоль туловища.
                                Круговым движением переместите плечи вперед, вверх, назад и вниз.
                                Повторите пять раз.
                                        """),
                new Answer("""
                        1. Встаньте прямо, ступни расставлены на ширине плеч, руки вдоль туловища.
                        2. Наклонитесь вперед, опуская руки к полу, но не касаясь его, и одновременно сделайте громкий и короткий вдох через нос на второй части поклона, закончив его в нижней точке.
                        3. Слегка приподнимитесь и повторите упражнение на восемь вдохов. Наклоны должны выполняться ритмично и легко.
                        """,
                        """
                                Встаньте прямо, ст`упни расставлены на ширине плеч, руки вдоль туловища.
                                Наклонитесь вперед, опуская руки к полу, но не касаясь его, и одновременно сделайте громкий и короткий вдох через нос на второй части поклона, закончив его в нижней точке.
                                Слегка приподнимитесь и повторите упражнение на восемь вдохов. Наклоны должны выполняться ритмично и легко.
                                        """),
                new Answer("""
                        1. Встаньте прямо, ступни на ширине плеч и не отрываются от пола.
                        2. Присядьте, одновременно поворачивая корпус и руки право, будто что-то ловите, а затем влево (выдох должен быть естественным, колени полусогнуты, повороты делайте в районе талии).
                        """,
                        """
                                Встаньте прямо, ст`упни на ширине плеч и не отрываются от пола.
                                Присядьте, одновременно поворачивая корпус и руки вправо, будто что-то л`овите, а затем влево \n(выдох должен быть естественным, колени полусогнуты, повороты делайте в районе ^талии^).
                                        """),
                new Answer("""
                        1. Встаньте прямо, руки согните в локтях и поднимите на высоту плеч.
                        2. Разведите руки в противоположные стороны, как бы обнимая себя за плечи. При каждом объятии резко вдыхайте и выдыхайте воздух носом.
                        """, """
                        Встаньте прямо, руки согните в локтях и поднимите на высоту плеч.
                        Разведите руки в противоположные стороны, как бы обнимая себя за плечи. \nПри каждом объятии резко вдыхайте и выдыхайте воздух носом.
                        """),
                new Answer("""
                        1. Стойте прямо, ноги на расстоянии чуть уже плеч.
                        2. Наклонитесь вперед, вытяните руки к полу и сделайте вдох.
                        3. Не останавливаясь разогните корпус и отклонитесь назад, обхватив плечи руками. Вдох «от пола», выдох «от потолка».
                        """,
                        """
                                Стойте прямо, ноги на расстоянии чуть `уже плеч.
                                Наклонитесь вперед, вытяните руки к полу и сделайте вдох.
                                Не останавливаясь разогните корпус и отклонитесь назад, обхватив плечи руками. \nВдох «от пола», выдох «от потолка».
                                        """)
        }));
    }
}
