package fr.mleduc.poc.vv.flaky.test.statik.analyzer;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.factory.Factory;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by mleduc on 26/09/16.
 */
public class App {
    public static void main(String[] args) {
        final SpoonAPI spoon = new Launcher();
        spoon.getEnvironment().setNoClasspath(true);
        spoon.addInputResource("/home/mleduc/dev/cours/2017/VV/pocs/flaky-test/use-case/src/main/java");
        final AnalyseDateInstances processor = new AnalyseDateInstances();
        spoon.addProcessor(processor);
        spoon.run();

        final Factory factory = spoon.getFactory();


        final CtModel model = factory.getModel();
        final List<CtClass> stateLessClasses = model
                .getElements(element -> element.getAnnotations()
                        .stream().filter(ctAnnotation ->
                                Objects.equals(ctAnnotation.getType().getSimpleName(), "Stateless"))
                        .findAny().map(ctAnnotation -> true).orElse(false));


        for (CtClass clazzz : stateLessClasses) {

            final List<CtConstructorCall> lst = clazzz.getElements(element -> element.getType().getActualClass().equals(Date.class));

            for (CtConstructorCall cc : lst) {
                System.out.println("Date instanciation in stateless context : " + cc.getPosition());
            }
        }

    }
}
