package fr.mleduc.poc.vv.flaky.test.statik.analyzer;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtAssignment;

/**
 * Created by mleduc on 26/09/16.
 */
public class AnalyseDateInstances extends AbstractProcessor<CtAssignment<Object, Object>> {
    public void process(CtAssignment<Object, Object> element) {
        System.out.println(element);
    }
}
